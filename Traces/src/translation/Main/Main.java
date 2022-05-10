package translation.Main;


import translation.Antlr.TraceUppaalLexer;
import translation.Antlr.TraceUppaalParser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import translation.Antlr.TraceUppaalLexer;
import translation.Antlr.TraceUppaalParserVisitor;
import translation.Tron.TronExec;
import translation.visitor.TranslationVisitor;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        long timeInit = System.currentTimeMillis();

        String mutantsFolder = "/home/user/Documents/TranslationTraceUppaal/GearControl/mutGearTraces/";
        String folderSave = "gearK100N5";

        int nTraces = 5;

        File file = new File(mutantsFolder);
        final String[] pathnames = file.list();

        String pathFolder = file.getAbsolutePath();

        assert pathnames != null;
        int nModels = pathnames.length;

        Set<String> channels = new HashSet<>();
        float timeout = 0;

        String prop = "/home/user/Documents/TranslationTraceUppaal/prop100.q";
        String folderTraces = "/home/user/Documents/TranslationTraceUppaal/".concat(folderSave).concat("/").concat("traces/");
        String verifyTA = "/home/user/Downloads/uppaal64-4.1.26/bin-Linux/verifyta";

        try{
            File theDir = new File(folderTraces);
            if (!theDir.exists()){
                theDir.mkdirs();
            }
            File folderTracesSim = new File("/home/user/Documents/TranslationTraceUppaal/".concat(folderSave).concat("/tracesSim/"));
            if(!folderTracesSim.exists()){
                folderTracesSim.mkdirs();
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        Random rand = new Random();
        for(String nameModel: pathnames){

            String fullNameModel = pathFolder.concat("/").concat(nameModel);

            for(int i =0; i<nTraces; i++){
                try{

                    System.out.println(fullNameModel);
                    ProcessBuilder pb = new ProcessBuilder(
                            "bash",
                            verifyTA,
                            "-q",
                            "-t",
                            "0",
                            "-r",
                            Integer.toString(rand.nextInt()),
                            fullNameModel,
                            prop
                    );
                    pb.redirectErrorStream(true);
                    Process p = pb.start();

                    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

                    String line = null;
                    String traceString = "";

                    stdInput.readLine();
                    stdInput.readLine();

                    while ((line = stdInput.readLine()) != null) {
                        traceString = traceString.concat(line).concat("\n");
                    }


                    CharStream input = CharStreams.fromString(traceString);
                    TraceUppaalLexer lexer = new TraceUppaalLexer(input);
                    CommonTokenStream tokens = new CommonTokenStream(lexer);
                    TraceUppaalParser parser = new TraceUppaalParser(tokens);
                    ParseTree tree = parser.trace();



                    FileWriter traceTrn = null;
                    FileWriter preambleTrn = null;

                    try{
                        FileWriter fileTraceString = new FileWriter("/home/user/Documents/TranslationTraceUppaal/".concat(folderSave).concat("/tracesSim/".concat(nameModel).concat(Integer.toString(i))));
                        fileTraceString.write(traceString);
                        fileTraceString.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    try{
                        traceTrn = new FileWriter(folderTraces.concat("/").concat(nameModel).concat(Integer.toString(i)).concat("Trace.trn"));

                        TranslationVisitor eval = new TranslationVisitor(channels);

                        traceTrn.write(eval.visit(tree));
                        traceTrn.close();

                        float newTimeout = eval.getTimeout();

                        if(newTimeout>timeout){
                            timeout=newTimeout;
                        }

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

        try{
            FileWriter traceTrn = new FileWriter("/home/user/Documents/TranslationTraceUppaal/preamble.trn");

            Preamble preamble = new Preamble(channels, "1000", Integer.toString(Math.round(timeout) + 1));
            traceTrn.write(preamble.getPreamble());
            traceTrn.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        long timeFinishTraces = System.currentTimeMillis();

        long durationTraces = timeFinishTraces - timeInit;


        ArrayList<String> bisimilar = new ArrayList<>();
        ArrayList<String> noBisimilar = new ArrayList<>();



        String saveFileLog = "/home/user/Documents/TranslationTraceUppaal/".concat(folderSave).concat("/similarTracesLog.csv");

        FileWriter fwLog = null;
        try {
            fwLog = new FileWriter(saveFileLog);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter outLog = new PrintWriter(fwLog, true);
        PrintWriter outBisimilar = new PrintWriter(fwLog, true);
        PrintWriter outNoBisimilar = new PrintWriter(fwLog, true);


        long startTime = System.currentTimeMillis();
        

        for(int i = 0; i<nModels; i++){

            for(int j =i+1; j<nModels; j++){


                Simulation passComplete = new TronExec().checkModels(pathFolder, pathnames[i], pathnames[j], folderTraces, nTraces);
                if(passComplete.isSimilar()){
                    outLog.print("Bisimilar, ");
                    outLog.print(pathnames[i].concat("-").concat(pathnames[j]));
                    outLog.print("\n");
                    System.out.println("Bisimilar");
                    System.out.println(pathnames[i].concat("-").concat(pathnames[j]));

                    bisimilar.add(
                            pathnames[i].concat(", ").
                                    concat(pathnames[j]).
                                    concat(", ").
                                    concat(String.valueOf(passComplete.getTime())).
                                    concat(", ").
                                    concat(String.valueOf(passComplete.getnCheckedTraces()))
                    );
                }
                else{
                    outLog.print("No Bisimilar, ");
                    outLog.print(pathnames[i].concat("-").concat(pathnames[j]));
                    outLog.print("\n");
                    System.out.println("No Bisimilar");
                    System.out.println(pathnames[i].concat("-").concat(pathnames[j]));
                    noBisimilar.add(
                            pathnames[i].concat(", ").
                                    concat(pathnames[j]).
                                    concat(", ").
                                    concat(String.valueOf(passComplete.getTime())).
                                    concat(", ").
                                    concat(String.valueOf(passComplete.getnCheckedTraces()))
                    );
                }

            }
        }

        long endTime = System.currentTimeMillis();

        long durationSimulation = (endTime - startTime);  //time simulations in milliseconds.

        outLog.println("Duration traces: ".concat(String.valueOf(durationTraces)));

        outLog.print("Duration simulation: ".concat(String.valueOf(durationSimulation)));

        //Flush the output to the file
        outLog.flush();

        //Close the Print Writer
        outLog.close();

        String saveFile = "/home/user/Documents/TranslationTraceUppaal/".concat(folderSave).concat("/similarTraces.csv");

        FileWriter fw = null;
        try {
            fw = new FileWriter(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter out = new PrintWriter(fw, true);


        out.print("\nBisimilar\n");
        for(String pairBis: bisimilar){
            out.print(pairBis);
            out.print("\n");
        }
        out.print("\nNo Bisimilar\n");
        for(String pairNoBis: noBisimilar){
            out.print(pairNoBis);
            out.print("\n");
        }

        //Flush the output to the file
        out.flush();

        //Close the Print Writer
        out.close();



    }
}
