/*
 [The "BSD licence"]
 Copyright (c) 2013 Terence Parr
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

/** XML parser derived from ANTLR v4 ref guide book example */
parser grammar UppaalParser;
//check 275 page

@parser::header {
    import java.util.HashMap;
    import java.util.HashSet;
    import Parser.Mutation.*;
}

@parser::members { // add members to generated UppaalParser
    private int num=0;


    //Number of controllable transitions (input actions <expr> "?")
    //The purpose is to know how many transitions can be removed, each one will be a mutant

    //TMI array will contain the number of transitions (in reading order)
    //that has controllable transitions (input actions <expr> "?")
    //TMI.get(0) will has the transition that should be removed, until TMI.get(n)
    private ArrayList<Integer> tmi = new ArrayList<Integer>();

    //Counter with the number of the current transition
    private int currentTransition = 0;

    //env will contain as key, "Global" for global declaration and the name of each template
    //env will contain as value, and array of string


    private String currentEnv = "Global";
    private HashMap<String, ArrayList<ChanType>> channelEnv = new HashMap<String, ArrayList<ChanType>>()
        {{
            put(currentEnv, new ArrayList<ChanType>());
        }};
    private HashMap<String, HashSet<ClockType>> clockEnv = new HashMap<String, HashSet<ClockType>>()
        {{
            put(currentEnv, new HashSet<ClockType>());
        }};
    private boolean isFunctionEnv = false;

    //transitionsTad is a <Key, Value> hashmap
    //                    <name_of_template_Key, <key, value>>
    //                    <name_of_template_key, <source_key, set_of_targets>
    //transitionsTad is a structure to save in each template the locations that does not have input/output actions (<expr> "?"/"!") synchro
    //these will be candidates to mutatants, adding transitions with output actions ( <expr> "!")
    private HashMap<String, HashMap<String, HashSet<String>>> transitionsTad = new HashMap<String, HashMap<String, HashSet<String>>>();
    private String currentSource = "";
    private String currentTarget = "";

    //transitionsTadNoSync is a structure similar to transitionsTad, this one will be used to make transitions between location that has not
    //any transition
    private HashMap<String, HashMap<String, HashSet<String>>> transitionsTadNoSync = new HashMap<String, HashMap<String, HashSet<String>>>();

    //locationsSmi is a <Key, Value > hashmap
    //                  <name_of_template_Key, <value>>
    //                  <name_of_template_Key, <set_of_locations>>
    //locations that has at least one input action ( <expr> "?" ) per template
    private HashMap<String, HashSet<String>> locationsSmi = new HashMap<String, HashSet<String>>();
    private String initLocationId = "";

    ///////////////////////////////////////////////////////////////////////////
    //private boolean isClockId = false;
    private boolean isControllable = false;

    private boolean isClockLeft = false;
    private boolean isClockRight = false;
    private int clockLessNum = 0;
    private int clockGreaterNum = 0;
    private int clockEqualNum = 0;
    private int clockDifferentNum = 0;

    //CXL Constant eXchange L operator increases the constant of a clock constraint.
    private int numCxl = 0;
    //CXS Constant eXchange S operator decreases the constant of a clock constraint.
    private int numCxs = 0;
    //CCN Clock Constraint Negation operator negates a clock constraint.
    private int numCcn = 0;

    public int getNum(){
        return this.num;
    }
    public void setNum(int num){
        this.num = num;
    }
    public HashMap<String, ArrayList<ChanType>> getChannelEnv (){
        return this.channelEnv;
    }
    public HashMap<String, HashSet<ClockType>> getClockEnv (){
        return this.clockEnv;
    }
    public ArrayList<Integer> getTmi(){
        return this.tmi;
    }

    public HashMap<String, HashMap<String, HashSet<String>>> getTransitionsTad(){
        return this.transitionsTad;
    }

    public HashMap<String, HashMap<String, HashSet<String>>> getTransitionsTadNoSync(){
        return this.transitionsTadNoSync;
    }

    public HashMap<String, HashSet<String>> getLocationsSmi(){
        return this.locationsSmi;
    }

    public int getNumCxl(){
        return this.numCxl;
    }
    public int getNumCxs(){
        return this.numCxs;
    }
    public int getNumCcn(){
        return this.numCcn;
    }
}
options { tokenVocab=UppaalLexer; }

//document    :   prolog? misc* element misc*;

model       :   prolog? misc* nta misc* ;

prolog      :   XMLDeclOpen attribute* SPECIAL_CLOSE ;

content     :   chardata?
                ((element | reference | CDATA | PI | COMMENT) chardata?)* ;

element     :   '<' Name attribute* '>' content '</' Name '>'
            |   '<' Name attribute* '/>'
            ;

reference   :   EntityRef | CharRef ;

attribute   :   Name EQUALS STRING ; // Our STRING is AttValue in spec

/** ``All text that is not markup constitutes the character data of
 *  the document.''
 */
chardata    :   TEXT | SEA_WS ;

misc        :   COMMENT | PI | SEA_WS ;

nta         :   '<' 'nta' '>' misc*
                declaration misc*
                (template misc*)+
                system misc*
                (queries misc*)?
                '</' 'nta' '>' ;

//declaration :   '<' 'declaration' '>' anything '</' 'declaration' '>' ;

declaration :   OPEN_DECLARATION declContent CLOSE_DECLARATION;

declContent:   declarations* ;

declarations:   variableDecl    # VariableDeclaration
            |   typeDecl        # typeDeclaration
            |   function        # FunctionDeclaration
            |   chanPriority    # ChanDeclaration
            ;

expr        :   IDENTIFIER  # IdentifierExpr
            |   NAT         # NatExpr
            |   POINT       # DoubleExpr
            |   expr '[' expr ']'   # ArrayExpr
            |   expr '\''     # StopWatchExpr
            |   '(' expr ')'  # ParenthesisExpr
            |   expr '++'     # ExprIncrement
            |   '++' expr     # IncrementExpr
            |   expr '--'     # ExprDecrement
            |   '--' expr     # DecrementExpr
            |   expr
                    //assign is '=' in guard channel
                    assign=(ASSIGN | ':=' | '+=' | '-=' | '*=' | '/=' | '%=' | '|=' | '&amp;=' | '^=' | '&lt;&lt;=' | '&gt;&gt;=')
                        expr  # AssignExpr
            |   unary=('-' | '+' | '!' | 'not') expr  # UnaryExpr
            |   expr binary=( '&lt;' | '&lt;=' | '==' | '!=' | '&gt;=' | '&gt;' //LESS is '<' in guard channel. Greater is '>' in guard channel
                                   ) expr     # ComparisonExpr
            |   expr binary=( '+' | '-' | '*' | '/' | '%' | '&amp;'
                                    |  '|' | '^' | '&lt;&lt;' | '&gt;&gt;' | '&amp;&amp;' | '||'
                                    |  '&lt;?' | '&gt;?' | 'or' | 'and' | 'imply')
                                    expr      #BinaryExpr
            |   expr '?' expr ':' expr
                                    # IfExpr
            |   expr '.' IDENTIFIER   # DotExpr
            |   expr '(' arguments ')'# FuncExpr
            |   'forall' '(' IDENTIFIER ':' type ')' expr     # ForallExpr
            |   'exists' '(' IDENTIFIER ':' type ')' expr     # ExistsExpr
            |   'sum' '(' IDENTIFIER ':' type ')' expr        # SumExpr
            |   'true'  # TrueExpr
            |   'false' # FalseExpr
            ;


arguments   :   (expr  (',' expr)*)? ;

variableDecl:   (type variableID (',' variableID)* ';')
                {
                    if(!this.isFunctionEnv){

                        String typeId = $ctx.type().typeId().getText();

                        if(typeId.equals("chan")){
                            List<UppaalParser.VariableIDContext> variablesId = $ctx.variableID();

                            for(UppaalParser.VariableIDContext variableId: variablesId){
                                String chanId = variableId.IDENTIFIER().getText();
                                int dimensions = variableId.arrayDecl().size();
                                channelEnv.get(currentEnv).add(new ChanType(chanId, dimensions));
                            }
                        }
                        else if(typeId.equals("clock")){
                            List<UppaalParser.VariableIDContext> variablesId = $ctx.variableID();
                            for(UppaalParser.VariableIDContext variableId: variablesId){
                                String clockId = variableId.IDENTIFIER().getText();
                                clockEnv.get(currentEnv).add(new ClockType(clockId));
                            }
                        }
                        //env.get(currentEnv).add();
                    }
                } ;

type        :   prefix? typeId ;

prefix      :   URGENT      # UrgentPrefix
            |   'broadcast' # BroadcastPrefix
            |   'meta'      # MetaPrefix
            |   'const'     # ConstPrefix
            ;

typeId      :   IDENTIFIER  # IdentifierType
            |   'int'       # IntType
            |   'double'    # DoubleType
            |   'clock'     # ClockType
            |   'chan'      # ChanType
            |   'bool'      # BoolType
            |   'int' '[' expr ',' expr ']'     # IntDomainType
            |   'scalar' '[' expr ']'           # ScalarType
            |   'struct' '{' (fieldDecl)+ '}'   # StructType
            ;

fieldDecl   :   type varFieldDecl (',' varFieldDecl)* ';' ;

varFieldDecl:   IDENTIFIER arrayDecl* ;

arrayDecl   :   '[' expr ']'    # ArrayDeclExpr
            |   '[' type ']'    # ArrayDeclType
            ;

variableID  :   IDENTIFIER (arrayDecl*) ((ASSIGN | ':=') initialiser )? ;

initialiser :   expr                                        # InitialiserExpr
            |   '{' initialiser (',' initialiser)* '}'      # InitialiserArray
            ;

//typeDecl    :   'typedef' type IDENTIFIER arrayDecl* (',' IDENTIFIER arrayDecl*)* ';' ;
typeDecl    :   'typedef' type varFieldDecl (',' varFieldDecl)* ';' ;

function    :   {
                    this.isFunctionEnv = true;
                }
                type IDENTIFIER '(' funcParameters ')' block
                {
                    this.isFunctionEnv = false;
                } ;

funcParameters: (funcParameter (',' funcParameter)*)? ;

//funcParameter:  type ('&amp;')? IDENTIFIER arrayDecl* ;
funcParameter:  type ('&amp;')? varFieldDecl ;

block       :   '{' declContent statement* '}' ;

statement   :   block           # StatementBlock
            |   ';'             # StatementSemicolon
            |   expr ';'        # StatementExpr
            |   forLoop         # StatementFor
            |   iteration       # StatementIteration
            |   whileLoop       # StatementWhile
            |   doWhile         # StatementDoWhile
            |   ifStatement     # StatementIf
            |   returnStatement # StatementReturn
            ;

forLoop     :   'for' '(' expr ';' expr ';' expr ')' statement ;

iteration   :   'for' '(' IDENTIFIER ':' type ')' statement ;

whileLoop  :   'while' '(' expr ')' statement ;

doWhile    :   'do' statement 'while' '(' expr ')' ';' ;

ifStatement:   'if' '(' expr ')' statement ('else' statement)? ;

returnStatement: 'return' (expr)? ';' ;

chanPriority:  'chan' 'priority' chanOrDef (chanSeparator chanOrDef)* ';' ;

chanOrDef   :   (chanExpr | 'default' ) ;

chanSeparator:  (',' | '&lt;') ;

chanExpr    :   IDENTIFIER              # ChanIdentifier
            |   chanExpr '[' expr ']'   # ChanArray
            ;
////////////////////////////////////////////////////////////////////////////////
anything    :   chardata?
                ((reference | CDATA | PI | COMMENT) chardata?)* ;

template    :   '<' 'template' '>' misc* tempContent  '</' 'template' '>' ;

tempContent
locals[ArrayList<String> namesLocations = new ArrayList<String>()]
            :   ((name misc*)?)
                {
                    if($ctx.name()!=null){
                        currentEnv = $ctx.name().anything().getText();
                        channelEnv.put(currentEnv, new ArrayList<ChanType>());
                        clockEnv.put(currentEnv, new HashSet<ClockType>());
                        transitionsTad.put(currentEnv, new HashMap<String, HashSet<String>>());
                        transitionsTadNoSync.put(currentEnv, new HashMap<String, HashSet<String>>());
                        locationsSmi.put(currentEnv, new HashSet<String>());
                    }
                }
                ((parameter misc*)?)
                {
                    if($ctx.parameter()!=null){
                        List<UppaalParser.FuncParameterContext> funcParameters = $ctx.parameter().funcParameters().funcParameter();
                        for(UppaalParser.FuncParameterContext funcParameter: funcParameters){
                            String typeId = funcParameter.type().typeId().getText();
                            if(typeId.equals("chan")){
                                String chanId = funcParameter.varFieldDecl().IDENTIFIER().getText();
                                int dimensions = funcParameter.varFieldDecl().arrayDecl().size();
                                channelEnv.get(currentEnv).add(new ChanType(chanId, dimensions));
                            }
                            else if (typeId.equals("clock")){
                                String clockId = funcParameter.varFieldDecl().IDENTIFIER().getText();
                                clockEnv.get(currentEnv).add(new ClockType(clockId));
                            }
                        }
                    }
                }
                (declaration misc*)?

                (((location misc*) | (branchpoint misc*))+)
                {
                    List<UppaalParser.LocationContext> locations = $ctx.location();
                    for(UppaalParser.LocationContext location: locations){
                        $namesLocations.add(location.STRING().getText());
                    }
                    for(String locationSource: $namesLocations){
                        HashSet<String> target = new HashSet<String>();
                        HashSet<String> targetNoSync = new HashSet<String>();
                        for(String locationTarget: $namesLocations){
                            target.add(locationTarget);
                            targetNoSync.add(locationTarget);
                        }
                        this.transitionsTad.get(this.currentEnv).put(locationSource, target);
                        this.transitionsTadNoSync.get(this.currentEnv).put(locationSource, targetNoSync);
                    }

                }
                (initLoc misc*)
                {
                    this.initLocationId=$ctx.initLoc().STRING().getText();
                }
                (transition misc*)*
                ;

parameter   :   OPEN_PARAMETER funcParameters CLOSE_PARAMETER ;

coordinate  :   ('x'|'y') EQUALS STRING ('x'|'y') EQUALS STRING ;

initLoc    :   '<' 'init' 'ref' EQUALS STRING '/>' ;

branchpoint :   '<' 'branchpoint' 'id' EQUALS STRING
                    coordinate? '>' misc*
                    '</' 'branchpoint' '>';

location    :   '<' 'location'
                    'id' EQUALS STRING coordinate?  color? '>' misc* (name misc*)?
                    (labelLoc misc*)*
                    ('<' (URGENT_LOC | 'committed') '/>' misc*)?

                    '</' 'location' '>' ;

labelLoc   :   '<' 'label' 'kind' EQUALS STRING coordinate?  '>' anything '</' 'label' '>' ;

name        :   '<' 'name'
                    coordinate?
                    '>' anything '</' 'name' '>' ;

color       :   'color' EQUALS STRING;

transition  :   '<' 'transition' color? '>'
                {
                    this.currentTransition++;
                }
                misc* (source misc*) (target misc*)
                (   labelTrans misc*
                 |  labelTransGuard  misc*
                 |  labelTransSyncInput misc*
                 |  labelTransSyncOutput misc*)*
                (nail misc*)*
                '</' 'transition' '>'
                {
                    if(this.isControllable){
                        // It is an input transition '?'
                        // clock >= num  --Mute to-> clock >= num+1
                        this.numCxl += this.clockGreaterNum;
                        // clock <= num  --Mute to-> clock <= num-1
                        this.numCxs += this.clockLessNum;
                    }
                    else{
                        // It is an output transition '!'
                        // clock <= num  --Mute to-> clock <= num+1
                        this.numCxl += this.clockLessNum;
                        // clock >= num  --Mute to-> clock >= num-1
                        this.numCxs += this.clockGreaterNum;
                    }
                    this.numCcn += this.clockGreaterNum + this.clockLessNum;
                    this.isControllable = false;
                    this.clockGreaterNum = 0;
                    this.clockLessNum = 0;
                    this.clockEqualNum = 0;
                    this.clockDifferentNum = 0;
                    this.isClockLeft = false;
                    this.isClockRight = false;
                }
                ;

labelTransGuard: OPEN_GUARD guardExpr? CLOSE_LABEL ;
labelTransSyncInput : (OPEN_SYNC (expr '?')? CLOSE_LABEL)
                     {
                         //flag to know if a transition is controllable (<expr> '?')
                         this.isControllable = true;

                         //Add to tmi array to remove transition on tmi mutants
                         this.tmi.add(this.currentTransition);

                         //If has a synchro input remove from possible transition to make an output on tad mutants
                         //due to a transition can not has two synchro labels
                         this.transitionsTad.get(currentEnv).get(currentSource).remove(currentTarget);

                         //if it has at least one incoming action, then a mutant will be created without the target location
                         if(!this.initLocationId.equals(this.currentTarget)){
                             this.locationsSmi.get(this.currentEnv).add(this.currentTarget);
                         }
                     } ;
labelTransSyncOutput: (OPEN_SYNC (expr '!')? CLOSE_LABEL)
                    {

                        //If has a synchro input remove from possible transition to make an output on tad mutants
                        //due to a transition can not has two synchro labels
                        this.transitionsTad.get(currentEnv).get(currentSource).remove(currentTarget);
                    } ;
labelTrans: '<' 'label' 'kind' EQUALS STRING coordinate?  '>' anything '</' 'label' '>' ;

guardExpr
//locals[boolean isClockId = false, boolean isClockIdAux= false]
            :   IDENTIFIER
            {
                this.isClockRight |= this.clockEnv.get(this.currentEnv).contains(new ClockType($ctx.getText()));
                this.isClockRight |= this.clockEnv.get("Global").contains(new ClockType($ctx.getText()));

            }
            # IdentifierGuard
            |   NAT   # NatGuard
            |   POINT    # DoubleGuard
            |   guardExpr '[' guardExpr ']'   # ArrayGuard
            |   guardExpr '\''     # StopWatchGuard
            |   '(' guardExpr ')'  # ParenthesisGuard
            |   guardExpr '++'     # GuardIncrement
            |   '++' guardExpr     # IncrementGuard
            |   guardExpr '--'     # GuardDecrement
            |   '--' guardExpr     # DecrementGuard
            |   guardExpr
                    //assign is '=' in guard channel
                    assign=(ASSIGN | ':=' | '+=' | '-=' | '*=' | '/=' | '%=' | '|=' | '&amp;=' | '^=' | '&lt;&lt;=' | '&gt;&gt;=')
                        guardExpr  # AssignGuard
            |   unary=('-' | '+' | '!' | 'not') guardExpr  # UnaryGuard

            |   guardExpr
                {
                    this.isClockLeft = this.isClockRight;
                    this.isClockRight = false;
                }
                binary=( '&lt;' | '&lt;=' | '==' | '!=' | '&gt;=' | '&gt;' )//LESS is '<' in guard channel. Greater is '>' in guard channel

                guardExpr
                {
                    String operator = ((ComparisonGuardContext) _localctx).binary.getText();

                    if(this.isClockLeft ^ this.isClockRight){
                        if(this.isClockLeft){
                            if(operator.equals("&lt;") ||operator.equals("&lt;=")){
                                this.clockLessNum++;
                            }
                            if(operator.equals("&gt;") ||operator.equals("&gt;=")){
                                this.clockGreaterNum++;
                            }

                        }
                        //then this.isClockRight is true
                        else {
                            if(operator.equals("&gt;") ||operator.equals("&gt;=")){
                                this.clockLessNum++;
                            }
                            if(operator.equals("&lt;") ||operator.equals("&lt;=")){
                                this.clockGreaterNum++;
                            }
                        }
                        if(operator.equals("==")){
                            this.clockEqualNum++;
                        }
                        if(operator.equals("!=")){
                            this.clockDifferentNum++;
                        }
                    }
                    this.isClockLeft = false;
                    this.isClockRight = false;
                }
                # ComparisonGuard
            |   guardExpr binary=( '+' | '-' | '*' | '/' | '%' | '&amp;'
                                    |  '|' | '^' | '&lt;&lt;' | '&gt;&gt;' | '&amp;&amp;' | '||'
                                    |  '&lt;?' | '&gt;?' | 'or' | 'and' | 'imply')
                                    guardExpr   #BinaryGuard
            |   guardExpr '?' guardExpr ':' guardExpr
                                    # IfGuard
            |   guardExpr '.' IDENTIFIER   # DotGuard
            |   IDENTIFIER '(' guardArguments ')'# FuncGuard
            |   'forall' '(' IDENTIFIER ':' guardType ')' guardExpr     # ForallGuard
            |   'exists' '(' IDENTIFIER ':' guardType ')' guardExpr     # ExistsGuard
            |   'sum' '(' IDENTIFIER ':' guardType ')' guardExpr        # SumGuard
            |   'true'  # TrueGuard
            |   'false' # FalseGuard
            ;

guardArguments   :   (guardExpr  (',' guardExpr)*)? ;

guardType        :   ('meta' | 'const')? guardTypeId ;

guardTypeId
            :   'int'                                       # GuardTypeInt
            |   'int' '[' guardExpr ',' guardExpr ']'     # GuardTypeIntDomain
            |   'scalar' '[' guardExpr ']'                 # GuardTypeScalar
            ;

source      :   ('<' 'source' 'ref' EQUALS STRING '/>')
                {
                    this.currentSource = $ctx.STRING().getText();
                }
                ;

target      :   '<' 'target' 'ref' EQUALS STRING '/>'
                {
                    this.currentTarget = $ctx.STRING().getText();
                    this.transitionsTadNoSync.get(currentEnv).get(currentSource).remove(currentTarget);
                }
                ;

nail        :   '<' 'nail' coordinate? '/>' ;

system      :   '<' 'system' '>' anything '</' 'system' '>' ;

queries     :   '<' 'queries' '>' misc* (query misc*)* '</' 'queries' '>' ;

query       :   '<' 'query' '>' misc* (formula misc*)? (comment misc*)? '</' 'query' '>' ;

formula     :   '<' 'formula' '>' anything '</' 'formula' '>' ;

comment     :   '<' 'comment' '>' anything '</' 'comment' '>' ;


//guardExpr  :   IDENTIFIER misc*;