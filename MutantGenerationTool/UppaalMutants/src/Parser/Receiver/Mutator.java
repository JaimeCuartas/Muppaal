package Parser.Receiver;

import Parser.Antlr.UppaalLexer;
import Parser.Antlr.UppaalParser;
import Parser.Graph.Graph;
import Parser.Mutation.UppaalVisitor;
import Parser.OperatorCommands.SmiNoRedundant;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.util.*;


public class Mutator {
    private File fileMutants;

    private String envTarget;

    private ArrayList<Thread> threadsTmi;
    private ArrayList<Thread> threadsTad;
    private ArrayList<Thread> threadsTadSync;
    private ArrayList<Thread> threadsTadRandomSync;
    private ArrayList<Thread> threadsSmi;
    private ArrayList<Thread> threadsSmiNoRedundant;
    private ArrayList<Thread> threadsCxl;
    private ArrayList<Thread> threadsCxs;
    private ArrayList<Thread> threadsCcn;
    private UppaalParser parser;
    private ParseTree tree;

    public Mutator(String modelFile, File fileMutants, String envTarget) throws IOException {

        this.fileMutants = fileMutants;

        this.threadsTmi = new ArrayList<>();
        this.threadsTad = new ArrayList<>();
        this.threadsTadSync = new ArrayList<>();
        this.threadsTadRandomSync = new ArrayList<>();
        this.threadsSmi = new ArrayList<>();
        this.threadsSmiNoRedundant = new ArrayList<>();
        this.threadsCxl = new ArrayList<>();
        this.threadsCxs = new ArrayList<>();
        this.threadsCcn = new ArrayList<>();

        CharStream input = CharStreams.fromFileName(modelFile);
        UppaalLexer lexer = new UppaalLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        this.envTarget = envTarget;
        this.parser = new UppaalParser(tokens, envTarget);
        this.tree = this.parser.model();
    }

    public String infoMutants(){
        String info = "Number of mutants:\n";
        info = info.concat("tmi ").concat(Integer.toString(this.threadsTmi.size())).concat("\n");
        info = info.concat("tad ").concat(Integer.toString(this.threadsTad.size())).concat("\n");
        info = info.concat("tadSync ").concat(Integer.toString(this.threadsTadSync.size())).concat("\n");
        info = info.concat("tadRandomSync ").concat(Integer.toString(this.threadsTadRandomSync.size())).concat("\n");
        info = info.concat("smi ").concat(Integer.toString(this.threadsSmi.size())).concat("\n");
        info = info.concat("smiNoRedundant ").concat(Integer.toString(this.threadsSmiNoRedundant.size())).concat("\n");
        info = info.concat("cxl ").concat(Integer.toString(this.threadsCxl.size())).concat("\n");
        info = info.concat("cxs ").concat(Integer.toString(this.threadsCxs.size())).concat("\n");
        info = info.concat("ccn ").concat(Integer.toString(this.threadsCcn.size())).concat("\n");

        info = info.concat("Total ").concat(Integer.toString(
                this.threadsTmi.size()
                        +this.threadsTad.size()
                        +this.threadsTadSync.size()
                        +this.threadsTadRandomSync.size()
                        +this.threadsSmi.size()
                        +this.threadsSmiNoRedundant.size()
                        +this.threadsCxl.size()
                        +this.threadsCxs.size()
                        +this.threadsCcn.size()
        )).concat("\n");
        return info;
    }

    public String verifyMutants(String pathIn, String pathVerifyTa, String pathQuery) throws IOException, InterruptedException {
        String log = "";
        int killedTmi =  killedMutants(this.threadsTmi, pathIn, pathVerifyTa, pathQuery);
        int killedTad = killedMutants(this.threadsTad, pathIn, pathVerifyTa, pathQuery);
        int killedTadSync = killedMutants(this.threadsTadSync, pathIn, pathVerifyTa, pathQuery);
        int killedTadRandomSync = killedMutants(this.threadsTadRandomSync, pathIn, pathVerifyTa, pathQuery);
        int killedSmi = killedMutants(this.threadsSmi, pathIn, pathVerifyTa, pathQuery);
        int killedSmiNoRedundant = killedMutants(this.threadsSmiNoRedundant, pathIn, pathVerifyTa, pathQuery);
        int killedCxl = killedMutants(this.threadsCxl, pathIn, pathVerifyTa, pathQuery);
        int killedCxs = killedMutants(this.threadsCxs, pathIn, pathVerifyTa, pathQuery);
        int killedCcn = killedMutants(this.threadsCcn, pathIn, pathVerifyTa, pathQuery);

        log = log.concat("Tmi killed ");
        log = log.concat(Integer.toString(killedTmi));
        log = log.concat("\nTad killed ");
        log = log.concat(Integer.toString(killedTad));
        log = log.concat("\ntadSync killed ");
        log = log.concat(Integer.toString(killedTadSync));
        log = log.concat("\ntadRandomSync killed ");
        log = log.concat(Integer.toString(killedTadRandomSync));
        log = log.concat("\nSmi killed ");
        log = log.concat(Integer.toString(killedSmi));
        log = log.concat("\nSmiNoRedundant killed ");
        log = log.concat(Integer.toString(killedSmiNoRedundant));
        log = log.concat("\nCxl killed ");
        log = log.concat(Integer.toString(killedCxl));
        log = log.concat("\nCxs killed ");
        log = log.concat(Integer.toString(killedCxs));
        log = log.concat("\nCcn killed ");
        log = log.concat(Integer.toString(killedCcn));
        log = log.concat("\nScore ").concat(Integer.toString(
                killedTmi+killedTad+killedTadSync+killedTadRandomSync+killedSmi+killedCxl+killedCxs+killedCcn
        )).concat("/").concat(Integer.toString(
                this.threadsTmi.size()
                        +this.threadsTad.size()
                        +this.threadsTadSync.size()
                        +this.threadsTadRandomSync.size()
                        +this.threadsSmi.size()
                        +this.threadsSmiNoRedundant.size()
                        +this.threadsCxl.size()
                        +this.threadsCxs.size()
                        +this.threadsCcn.size()
        ));
        log = log.concat("\n");
        return log;
    }

    public int killedMutants(ArrayList<Thread> operatorThreads, String pathIn, String pathVerifyTa, String pathQuery) throws IOException, InterruptedException {
        String mutantPath = "";
        int dead = 0;
        for(String mutantTmi: operatorThreads.stream().map(Thread::getName).toArray(String[]::new)){
            mutantPath = pathIn + File.separator + mutantTmi;
            Process p = Runtime.getRuntime().exec(pathVerifyTa.concat(" -q ").concat(mutantPath).concat(" ").concat(pathQuery));
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = reader.readLine();

            if(line == null){
                dead++;
                continue;
            }

            while ((line = reader.readLine())!=null){
                if (line.contains("NOT satisfied") || line.contains("MAY be satisfied")) {
                    dead++;
                    break;
                }
            }
        }
        return dead;
    }

    /**
     * Run operator generating mutants in fileIn path
     */
    public void runOperators(){
        this.runThreads(this.threadsTmi);
        this.runThreads(this.threadsTad);
        this.runThreads(this.threadsTadSync);
        this.runThreads(this.threadsTadRandomSync);
        this.runThreads(this.threadsSmi);
        this.runThreads(this.threadsSmiNoRedundant);
        this.runThreads(this.threadsCxl);
        this.runThreads(this.threadsCxs);
        this.runThreads(this.threadsCcn);
    }

    public void runThreads(ArrayList<Thread> threads){
        for (Thread mutantThread: threads){
            mutantThread.start();
        }
    }
/*
    public void runTmi(){
        for (Thread mutantThread: this.threadsTmi){
            mutantThread.start();
        }
    }
    public void runTad(){
        for (Thread mutantThread: this.threadsTad){
            mutantThread.start();
        }
    }
    public void runTadSync(){
        for (Thread mutantThread: this.threadsTadSync){
            mutantThread.start();
        }
    }
    public void runTadRandomSync(){
        for (Thread mutantThread: this.threadsTadRandomSync){
            mutantThread.start();
        }
    }
    public void runSmi(){
        for (Thread mutantThread: this.threadsSmi){
            mutantThread.start();
        }
    }
    public void runSmiNoRedundant(){
        for (Thread mutantThread: this.threadsSmiNoRedundant){
            mutantThread.start();
        }
    }
    public void runCxl(){
        for (Thread mutantThread: this.threadsCxl){
            mutantThread.start();
        }
    }
    public void runCxs(){
        for (Thread mutantThread: this.threadsCxs){
            mutantThread.start();
        }
    }
    public void runCcn(){
        for (Thread mutantThread: this.threadsCcn){
            mutantThread.start();
        }
    }

 */

    /**
     * Join functions to wait until every mutant is generated
     * @throws InterruptedException
     */
    public void joinOperators() throws InterruptedException {
        this.joinThreads(this.threadsTmi);
        this.joinThreads(this.threadsTad);
        this.joinThreads(this.threadsTadSync);
        this.joinThreads(this.threadsTadRandomSync);
        this.joinThreads(this.threadsSmi);
        this.joinThreads(this.threadsSmiNoRedundant);
        this.joinThreads(this.threadsCxl);
        this.joinThreads(this.threadsCxs);
        this.joinThreads(this.threadsCcn);
    }


    public void joinThreads(ArrayList<Thread> threads) throws InterruptedException {
        for (Thread mutantThread: threads){
            mutantThread.join();
        }
    }
    /*
    public void joinTmi() throws InterruptedException {
        for (Thread mutantThread: this.threadsTmi){
            mutantThread.join();
        }
    }
    public void joinTad() throws InterruptedException {
        for (Thread mutantThread: this.threadsTad){
            mutantThread.join();
        }
    }
    public void joinTadSync() throws InterruptedException {
        for (Thread mutantThread: this.threadsTadSync){
            mutantThread.join();
        }
    }
    public void joinTadRandomSync() throws  InterruptedException {
        for (Thread mutantThread: this.threadsTadRandomSync){
            mutantThread.join();
        }
    }
    public void joinSmi() throws InterruptedException {
        for (Thread mutantThread: this.threadsSmi){
            mutantThread.join();
        }
    }
    public void joinSmiNoRedundant() throws InterruptedException {
        for (Thread mutantThread: this.threadsSmiNoRedundant){
            mutantThread.join();
        }
    }
    public void joinCxl() throws InterruptedException {
        for (Thread mutantThread: this.threadsCxl){
            mutantThread.join();
        }
    }
    public void joinCxs() throws InterruptedException {
        for (Thread mutantThread: this.threadsCxs){
            mutantThread.join();
        }
    }
    public void joinCcn() throws InterruptedException {
        for (Thread mutantThread: this.threadsCcn){
            mutantThread.join();
        }
    }

     */


    public void prepareTmiOperator(){
        for (int i : parser.getTmi()) {
            threadsTmi.add(new Thread(() -> {
                UppaalVisitor eval = new UppaalVisitor(i, "", "", "", "", "", parser.getClockEnv(), -1, -1, -1, this.envTarget);
                FileWriter myWriter = null;
                try {
                    myWriter = new FileWriter(new File(this.fileMutants, "tmi" + i + ".xml"));
                    myWriter.write(eval.visit(tree));
                    myWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }, "tmi" + i + ".xml"));
        }
    }

    public void prepareTadOperator(){
        if(this.envTarget.equals("")){
            //Each template
            for (String template : parser.getTransitionsTad().keySet()) {
                //Each source
                for (String source : this.parser.getTransitionsTadNoSync().get(template).keySet()) {
                    HashSet<String> targets = this.parser.getTransitionsTadNoSync().get(template).get(source);
                    //If source does not have an available target, then continue
                    if (targets.isEmpty()) {
                        continue;
                    }

                    Iterator<String> iterTargets = targets.iterator();

                    for (int i = 0; i < targets.size(); i++) {
                        //Choose target
                        String target = iterTargets.next();

                        this.threadsTad.add(new Thread(() -> {
                            UppaalVisitor eval = new UppaalVisitor(-1, template, source, target, "", "", parser.getClockEnv(), -1, -1, -1, this.envTarget);
                            FileWriter myWriter = null;
                            try {
                                myWriter = new FileWriter(new File(this.fileMutants, "tad".concat(source.concat(target).replace("\"", "")).concat(".xml")));
                                myWriter.write(eval.visit(this.tree));
                                myWriter.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }, "tad".concat(source.concat(target).replace("\"", "")).concat(".xml")));
                    }
                }
            }
        }


        if(this.parser.getTransitionsTad().containsKey(this.envTarget)){
            //Each source
            for (String source : this.parser.getTransitionsTadNoSync().get(this.envTarget).keySet()) {
                HashSet<String> targets = this.parser.getTransitionsTadNoSync().get(this.envTarget).get(source);
                //If source does not have an available target, then continue
                if (targets.isEmpty()) {
                    continue;
                }

                Iterator<String> iterTargets = targets.iterator();

                for (int i = 0; i < targets.size(); i++) {
                    //Choose target
                    String target = iterTargets.next();

                    this.threadsTad.add(new Thread(() -> {
                        UppaalVisitor eval = new UppaalVisitor(-1, this.envTarget, source, target, "", "", parser.getClockEnv(), -1, -1, -1, this.envTarget);
                        FileWriter myWriter = null;
                        try {
                            myWriter = new FileWriter(new File(this.fileMutants, "tad".concat(source.concat(target).replace("\"", "")).concat(".xml")));
                            myWriter.write(eval.visit(this.tree));
                            myWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }, "tad".concat(source.concat(target).replace("\"", "")).concat(".xml")));
                }
            }
        }

    }

    public void prepareTadSyncOperator(String chanSync){
        if(this.envTarget.equals("")){
            //Each template
            for (String template : parser.getTransitionsTad().keySet()) {
                //Each source
                for (String source : this.parser.getTransitionsTad().get(template).keySet()) {
                    HashSet<String> targets = this.parser.getTransitionsTad().get(template).get(source);
                    //If source does not have an available target, then continue
                    if (targets.isEmpty()) {
                        continue;
                    }


                    Iterator<String> iterTargets = targets.iterator();

                    for (int i = 0; i < targets.size(); i++) {
                        //Choose target
                        String target = iterTargets.next();

                        String output = chanSync.concat("!");
                        this.threadsTadSync.add(new Thread(() -> {
                            UppaalVisitor eval = new UppaalVisitor(-1, template, source, target, output, "", parser.getClockEnv(), -1, -1, -1, this.envTarget);
                            FileWriter myWriter = null;
                            try {
                                myWriter = new FileWriter(new File(this.fileMutants, "tadSync".concat(source.concat(target).replace("\"", "")).concat(".xml")));
                                myWriter.write(eval.visit(this.tree));
                                myWriter.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }, "tadSync".concat(source.concat(target).replace("\"", "")).concat(".xml")));
                    }
                }
            }
            return;
        }
        if(this.parser.getTransitionsTad().containsKey(this.envTarget)){

            for (String source : this.parser.getTransitionsTad().get(this.envTarget).keySet()) {
                HashSet<String> targets = this.parser.getTransitionsTad().get(this.envTarget).get(source);
                //If source does not have an available target, then continue
                if (targets.isEmpty()) {
                    continue;
                }

                Iterator<String> iterTargets = targets.iterator();

                for (int i = 0; i < targets.size(); i++) {
                    //Choose target
                    String target = iterTargets.next();

                    String output = chanSync.concat("!");
                    this.threadsTadSync.add(new Thread(() -> {
                        UppaalVisitor eval = new UppaalVisitor(-1, this.envTarget, source, target, output, "", parser.getClockEnv(), -1, -1, -1, this.envTarget);
                        FileWriter myWriter = null;
                        try {
                            myWriter = new FileWriter(new File(this.fileMutants, "tadSync".concat(source.concat(target).replace("\"", "")).concat(".xml")));
                            myWriter.write(eval.visit(this.tree));
                            myWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }, "tadSync".concat(source.concat(target).replace("\"", "")).concat(".xml")));
                }
            }

        }

    }

    public void prepareTadRandomSyncOperator(){
        if(this.envTarget.equals("")){
            for (String template : parser.getTransitionsTad().keySet()) {
                String outputEnv = "";
                if (!this.parser.getChannelEnv().get("Global").isEmpty()) {
                    outputEnv = "Global";
                } else if (!this.parser.getChannelEnv().get(template).isEmpty()) {
                    outputEnv = template;
                } else {
                    continue;
                }
                for (String source : this.parser.getTransitionsTad().get(template).keySet()) {
                    HashSet<String> targets = this.parser.getTransitionsTad().get(template).get(source);

                    if (targets.isEmpty()) {
                        continue;
                    }

                    Iterator<String> iterTargets = targets.iterator();

                    for (int i = 0; i < targets.size(); i++) {
                        //Choose target
                        String target = iterTargets.next();
                        int chanPicked = 0;
                        String chan = this.parser.getChannelEnv().get(outputEnv).get(chanPicked).getName();
                        int dimensions = this.parser.getChannelEnv().get(outputEnv).get(chanPicked).getDimension();
                        for (int j=0; j<dimensions; j++){
                            chan = chan.concat("[0]");
                        }
                        String output = chan.concat("!");
                        this.threadsTadRandomSync.add(new Thread(() -> {
                            UppaalVisitor eval = new UppaalVisitor(-1, template, source, target, output, "", parser.getClockEnv(), -1, -1, -1, this.envTarget);
                            FileWriter myWriter = null;
                            try {
                                myWriter = new FileWriter(new File(this.fileMutants, "tadRandomSync".concat(source.concat(target).replace("\"", "")).concat(".xml")));
                                myWriter.write(eval.visit(this.tree));
                                myWriter.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }, "tadRandomSync".concat(source.concat(target).replace("\"", "")).concat(".xml")));
                    }
                }
            }
            return;
        }
        if(this.parser.getTransitionsTad().containsKey(this.envTarget)){
            String outputEnv = "";
            if (!this.parser.getChannelEnv().get("Global").isEmpty()) {
                outputEnv = "Global";
            } else if (!this.parser.getChannelEnv().get(this.envTarget).isEmpty()) {
                outputEnv = this.envTarget;
            } else {
                return;
            }
            for (String source : this.parser.getTransitionsTad().get(this.envTarget).keySet()) {
                HashSet<String> targets = this.parser.getTransitionsTad().get(this.envTarget).get(source);

                if (targets.isEmpty()) {
                    continue;
                }

                Iterator<String> iterTargets = targets.iterator();

                for (int i = 0; i < targets.size(); i++) {
                    //Choose target
                    String target = iterTargets.next();
                    int chanPicked = 0;
                    String chan = this.parser.getChannelEnv().get(outputEnv).get(chanPicked).getName();
                    int dimensions = this.parser.getChannelEnv().get(outputEnv).get(chanPicked).getDimension();
                    for (int j=0; j<dimensions; j++){
                        chan = chan.concat("[0]");
                    }
                    String output = chan.concat("!");
                    this.threadsTadRandomSync.add(new Thread(() -> {
                        UppaalVisitor eval = new UppaalVisitor(-1, this.envTarget, source, target, output, "", parser.getClockEnv(), -1, -1, -1, this.envTarget);
                        FileWriter myWriter = null;
                        try {
                            myWriter = new FileWriter(new File(this.fileMutants, "tadRandomSync".concat(source.concat(target).replace("\"", "")).concat(".xml")));
                            myWriter.write(eval.visit(this.tree));
                            myWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }, "tadRandomSync".concat(source.concat(target).replace("\"", "")).concat(".xml")));
                }
            }
        }

    }

    public void prepareSmiOperator(){

        if(this.envTarget.equals("")){
            for (String template : this.parser.getLocationsSmi().keySet()) {
                for (String idLocation : this.parser.getLocationsSmi().get(template)) {
                    threadsSmi.add(new Thread(() -> {
                        UppaalVisitor eval = new UppaalVisitor(-1, "", "", "", "", idLocation, parser.getClockEnv(), -1, -1, -1, this.envTarget);
                        FileWriter myWriter = null;
                        try {
                            myWriter = new FileWriter(new File(this.fileMutants, "smi".concat(template).concat((idLocation).replace("\"", "")).concat(".xml")));
                            myWriter.write(eval.visit(this.tree));
                            myWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }, "smi".concat(template).concat((idLocation).replace("\"", "")).concat(".xml")));
                }
            }
            return;
        }
        if(this.parser.getLocationsSmi().containsKey(this.envTarget)){
            for (String idLocation : this.parser.getLocationsSmi().get(this.envTarget)) {
                threadsSmi.add(new Thread(() -> {
                    UppaalVisitor eval = new UppaalVisitor(-1, "", "", "", "", idLocation, parser.getClockEnv(), -1, -1, -1, this.envTarget);
                    FileWriter myWriter = null;
                    try {
                        myWriter = new FileWriter(new File(this.fileMutants, "smi".concat(this.envTarget).concat((idLocation).replace("\"", "")).concat(".xml")));
                        myWriter.write(eval.visit(this.tree));
                        myWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }, "smi".concat(this.envTarget).concat((idLocation).replace("\"", "")).concat(".xml")));
            }
        }


    }

    public void prepareSmiNoRedundantOperator(){

        //HashMap<String, HashSet<String>> smiNoRedundant = new HashMap<>(this.parser.getLocationsSmi());
        HashMap<String, HashSet<String>> smiNoRedundant = new HashMap<>();

        if(this.envTarget.equals("")) {
            for(Map.Entry<String, HashSet<String>> entry: this.parser.getLocationsSmi().entrySet()){
                HashSet<String> newSmiLocations = new HashSet<>(entry.getValue());
                smiNoRedundant.put(entry.getKey(), newSmiLocations);
            }
        }
        if(this.parser.getLocationsSmi().containsKey(this.envTarget)){

            HashSet<String>  newSmiLocations =  new HashSet<>( this.parser.getLocationsSmi().get(this.envTarget));
            smiNoRedundant.put(this.envTarget, newSmiLocations);
            System.out.println(smiNoRedundant);
            System.out.println(newSmiLocations);
        }

        for(String template : smiNoRedundant.keySet()){
            Graph graphTemplate = this.parser.getGraphs().get(template);
            ArrayList<ArrayList<Integer>> listGraph = graphTemplate.getNumericGraph();

            smiNoRedundant.get(template).removeIf(idLocation -> graphTemplate.samePreviousNode(listGraph, idLocation));
        }

        for (String template : smiNoRedundant.keySet()) {
            for (String idLocation : smiNoRedundant.get(template)) {

                threadsSmiNoRedundant.add(new Thread(() -> {
                    UppaalVisitor eval = new UppaalVisitor(-1, "", "", "", "", idLocation, parser.getClockEnv(), -1, -1, -1, this.envTarget);
                    FileWriter myWriter = null;
                    try {
                        myWriter = new FileWriter(new File(this.fileMutants, "smiNoRedundant".concat(template).concat((idLocation).replace("\"", "")).concat(".xml")));
                        myWriter.write(eval.visit(this.tree));
                        myWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }, "smiNoRedundant".concat(template).concat((idLocation).replace("\"", "")).concat(".xml")));
            }
        }
    }

    public void prepareCxlOperator(){
        for(int i=1; i<=this.parser.getNumCxl(); i++){
            int idCxl = i;
            this.threadsCxl.add(new Thread(()->{
                UppaalVisitor eval = new UppaalVisitor(-1, "", "", "", "", "", parser.getClockEnv(), idCxl, -1, -1, this.envTarget);
                FileWriter myWriter = null;
                try {
                    myWriter = new FileWriter(new File(this.fileMutants, "cxl"+ idCxl +".xml"));
                    myWriter.write(eval.visit(this.tree));
                    myWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }, "cxl"+ idCxl +".xml"));
        }
    }

    public void prepareCxsOperator(){
        for(int i=1; i<=this.parser.getNumCxs(); i++){
            int idCxs = i;
            this.threadsCxs.add(new Thread(()->{
                UppaalVisitor eval = new UppaalVisitor(-1, "", "", "", "", "", parser.getClockEnv(), -1, idCxs, -1, this.envTarget);
                FileWriter myWriter = null;
                try {
                    myWriter = new FileWriter(new File(this.fileMutants, "cxs"+ idCxs +".xml"));
                    myWriter.write(eval.visit(this.tree));
                    myWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }, "cxs"+ idCxs +".xml"));
        }
    }

    public void prepareCcnOperator(){
        for(int i=1; i<=parser.getNumCcn(); i++){
            int idCcn = i;
            this.threadsCcn.add(new Thread(()->{
                UppaalVisitor eval = new UppaalVisitor(-1, "", "", "", "", "", parser.getClockEnv(), -1, -1, idCcn, this.envTarget);
                FileWriter myWriter = null;
                try {
                    myWriter = new FileWriter(new File(this.fileMutants, "ccn"+ idCcn +".xml"));
                    myWriter.write(eval.visit(tree));
                    myWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }, "ccn"+ idCcn +".xml"));
        }
    }

}

