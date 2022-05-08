package Parser.Main;
import Parser.Command.Command;
import Parser.Errors.NoModelError;
import Parser.Errors.NoVerifyTaError;
import Parser.Invoker.Switch;
import Parser.OperatorCommands.*;
import Parser.OperatorCommands.SmiNoRedundant;
import Parser.Receiver.Mutator;
import Parser.Mutation.OptionsArgs;

import org.apache.commons.cli.*;

import java.io.*;
import java.util.*;

//////////////////////////////////////////////////////////////////////


import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//////////////////////////////////////////////////////////////////////

public class EntryPoint {

    public static void main(String[] args)  {

        long startTime = System.currentTimeMillis();
        String output = "";
        OptionsArgs opt = new OptionsArgs();

        try{
            opt.parseArgs(args);
        } catch (ParseException e) {
            opt.printHelp();
            System.exit(1);
        } catch (NoModelError e) {
            System.out.println("-m,--model <path> is a required option" +
                    "\nTry `java -jar MutationUppaal.jar -h' for more information" +
                    "\nPress enter to exit.");
            Scanner scan = new Scanner(System.in);
            scan.nextLine();
            System.exit(1);
        } catch (NoVerifyTaError e) {
            System.out.println("-v,--verifyta <path> is a required option to score" +
                    "\nDo you want to generate the mutants without scoring? (y/n)\n");
            Scanner scan = new Scanner(System.in);
            String response = scan.next();
            while (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
                System.out.println("\nInvalid response. Try again.");
                response = scan.next();
            }
            if (response.equalsIgnoreCase("n")) {
                System.out.println("\nTry `java -jar MutationUppaal.jar -h' for more information");
                System.out.println("\nPress enter to exit.");
                scan = new Scanner(System.in);
                scan.nextLine();
                System.exit(1);
            } else {
                System.out.println("\nFine. Mutants without score will be generated");
            }
        }

        String path = opt.getPathMutants();

        if(opt.getPathMutants().equals("")){
            String here = System.getProperty("user.dir");
            String idFile = Long.toString(System.currentTimeMillis());
            path = here.concat(File.separator + "Mutation"+ idFile);
        }

        System.out.println("mutants will be created in this path: "+path);

        File fileMutants = new File(path);
        fileMutants.mkdirs();
        if(!fileMutants.exists()){
            System.out.println("there was an error creating the directory indicated " +
                    "\nwith the path option [-p <path>]. You may have indicated a wrong route. " +
                    "\nPress enter to exit.");
            Scanner scan = new Scanner(System.in);
            scan.nextLine();
            System.exit(1);
        }

        Mutator mutator = null;
        try {
            mutator = new Mutator(opt.getModelFile(), fileMutants, opt.getEnv());
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        Command ccnMutant = new Ccn(mutator);
        Command cxlMutant = new Cxl(mutator);
        Command cxsMutant = new Cxs(mutator);
        Command smiMutant = new Smi(mutator);
        Command smiNoRedundant = new SmiNoRedundant(mutator);
        Command tadMutant = new Tad(mutator);
        Command tadRandomSyncMutant = new TadRandomSync(mutator);
        //prepare mutants only  if opt.getTadSync!=""
        Command tadSyncMutant = new TadSync(mutator, opt.getTadSync());
        Command tmiMutant = new Tmi(mutator);

        Switch mySwitch = new Switch(tmiMutant, tadMutant, tadSyncMutant, tadRandomSyncMutant,
                smiMutant, smiNoRedundant,
                cxlMutant, cxsMutant, ccnMutant);


        if(opt.isTmi()) mySwitch.tmi();
        if(opt.isTad()) mySwitch.tad();
        if(!opt.getTadSync().equals("")) mySwitch.tadSync();
        if(opt.isTadRandomSync()) mySwitch.setTadRandomSync();
        if(opt.isSmi()) mySwitch.smi();
        if(opt.isSmiNoRedundant()) mySwitch.smiNoRedundant();
        if(opt.isCxl()) mySwitch.cxl();
        if(opt.isCxs()) mySwitch.cxs();
        if(opt.isCcn()) mySwitch.ccn();


        mutator.runOperators();
        try {
            mutator.joinOperators();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }

        output = output.concat(mutator.infoMutants());

        try {
            if(!opt.getVerifyTaFile().equals("")){
                output =output.concat(
                        mutator.verifyMutants(
                                path,
                                opt.getVerifyTaFile(),
                                opt.getQueryFile()
                        )
                );
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        long duration = (endTime - startTime);

        output = output.concat("Time execution: " +
                String.format("%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes(duration),
                TimeUnit.MILLISECONDS.toSeconds(duration) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)))
        );
        try {
            if(opt.isLog()){
                FileWriter myWriter = null;
                myWriter = new FileWriter(new File(fileMutants, "log"));
                myWriter.write(output);
                myWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(output);

    }
}
