package Parser.Mutation;

import Parser.Antlr.UppaalParser;
import Parser.Antlr.UppaalParserBaseVisitor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class UppaalVisitor extends UppaalParserBaseVisitor<String> {


    private final int tmiOperator;
    private int indexCurrentTransition;

    private final String templateTad;
    private final String sourceTad;
    private final String targetTad;
    private final String outputTad;

    private final String locationSmi;

    private final HashMap<String, HashSet<ClockType>> clockEnv;
    private String currentEnv = "Global";
    private final int idCxlOperator;
    private int indexCxl;
    private final int idCxsOperator;
    private int indexCxs;
    private int indexCcn;
    private final int idCcnOperator;
    private boolean isControllable = false;
    private boolean isClockLeft = false;
    private boolean isClockRight = false;
    private String envTarget;

    public UppaalVisitor (int tmiOperator, String templateTad, String sourceTad, String targetTad, String outputTad, String locationSmi,
                          HashMap<String, HashSet<ClockType>> clockEnv, int idCxlOperator, int idCxsOperator, int idCcnOperator,
                          String envTarget){


        this.tmiOperator = tmiOperator;
        this.indexCurrentTransition = 0;

        this.templateTad = templateTad;
        this.sourceTad = sourceTad;
        this.targetTad = targetTad;
        this.outputTad = outputTad;

        this.locationSmi = locationSmi;

        this.clockEnv = clockEnv;
        this.idCxlOperator = idCxlOperator;
        this.idCxsOperator = idCxsOperator;
        this.idCcnOperator = idCcnOperator;
        this.indexCxl = 0;
        this.indexCxs = 0;
        this.indexCcn = 0;
        this.envTarget = envTarget;
    }

    @Override
    public String visitModel(UppaalParser.ModelContext ctx) {
        String model = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<!DOCTYPE nta PUBLIC '-//Uppaal Team//DTD Flat System 1.1//EN' 'http://www.it.uu.se/research/group/darts/uppaal/flat-1_2.dtd'>\n";

        model = model.concat(visit(ctx.nta()));
        return model;
    }

    @Override
    public String visitProlog(UppaalParser.PrologContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitNta(UppaalParser.NtaContext ctx) {
        String nta = "<nta>\n";
        nta = nta.concat(visit(ctx.declaration()).concat("\n"));

        List<UppaalParser.TemplateContext> templates = ctx.template();

        for(UppaalParser.TemplateContext template: templates){
            nta = nta.concat(visit(template)).concat("\n");
        }

        nta = nta.concat(visit(ctx.system())).concat("\n");

        if(ctx.queries() != null){
            nta = nta.concat(visit(ctx.queries())).concat("\n");
        }

        nta = nta.concat("</nta>");
        return nta;
    }

    @Override
    public String visitDeclaration(UppaalParser.DeclarationContext ctx) {
        String declaration = ctx.OPEN_DECLARATION().getText();
        declaration = declaration.concat(visit(ctx.declContent()));
        //.println(declaration);
        declaration = declaration.concat(ctx.CLOSE_DECLARATION().getText());
        return declaration;
    }

    @Override
    public String visitDeclContent(UppaalParser.DeclContentContext ctx) {
        String declContent = "";

        List<UppaalParser.DeclarationsContext> declarations = ctx.declarations();

        for(UppaalParser.DeclarationsContext declaration: declarations){
            declContent = declContent.concat(visit(declaration)).concat("\n");
        }

        return declContent;
    }

    @Override
    public String visitIdentifierExpr(UppaalParser.IdentifierExprContext ctx) {
        return ctx.IDENTIFIER().getText();
    }

    @Override
    public String visitNatExpr(UppaalParser.NatExprContext ctx) {
        return ctx.NAT().getText();
    }

    @Override
    public String visitDoubleExpr(UppaalParser.DoubleExprContext ctx) {
        return ctx.POINT().getText();
    }

    @Override
    public String visitArrayExpr(UppaalParser.ArrayExprContext ctx) {
        return visit(ctx.expr(0)).concat("[").concat(visit(ctx.expr(1))).concat("]");
    }

    @Override
    public String visitStopWatchExpr(UppaalParser.StopWatchExprContext ctx) {
        return visit(ctx.expr()).concat("'");
    }

    @Override
    public String visitParenthesisExpr(UppaalParser.ParenthesisExprContext ctx) {
        return "(".concat(visit(ctx.expr())).concat(")");
    }

    @Override
    public String visitExprIncrement(UppaalParser.ExprIncrementContext ctx) {
        return visit(ctx.expr()).concat("++");
    }

    @Override
    public String visitIncrementExpr(UppaalParser.IncrementExprContext ctx) {
        return "++".concat(visit(ctx.expr()));
    }

    @Override
    public String visitExprDecrement(UppaalParser.ExprDecrementContext ctx) {
        return visit(ctx.expr()).concat("--");
    }

    @Override
    public String visitDecrementExpr(UppaalParser.DecrementExprContext ctx) {
        return "--".concat(visit(ctx.expr()));
    }

    @Override
    public String visitAssignExpr(UppaalParser.AssignExprContext ctx) {
        return visit(ctx.expr(0)).concat(ctx.assign.getText()).concat(visit(ctx.expr(1)));
    }

    @Override
    public String visitUnaryExpr(UppaalParser.UnaryExprContext ctx) {
        return ctx.unary.getText().concat(" ").concat(visit(ctx.expr()));
    }

    @Override
    public String visitComparisonExpr(UppaalParser.ComparisonExprContext ctx) {
        return visit(ctx.expr(0)).concat(" ").concat(ctx.binary.getText()).concat(" ").concat(visit(ctx.expr(1)));
    }


    @Override
    public String visitBinaryExpr(UppaalParser.BinaryExprContext ctx) {
        return visit(ctx.expr(0)).concat(" ").concat(ctx.binary.getText()).concat(" ").concat(visit(ctx.expr(1)));
    }

    @Override
    public String visitIfExpr(UppaalParser.IfExprContext ctx) {
        return visit(ctx.expr(0)).concat("?").concat(visit(ctx.expr(1))).concat(":").concat(visit(ctx.expr(2)));
    }

    @Override
    public String visitDotExpr(UppaalParser.DotExprContext ctx) {
        return visit(ctx.expr()).concat(".").concat(ctx.IDENTIFIER().getText());
    }


    @Override
    public String visitFuncExpr(UppaalParser.FuncExprContext ctx) {
        return visit(ctx.expr()).concat("(").concat(visit(ctx.arguments())).concat(")");
    }
    
    @Override
    public String visitForallExpr(UppaalParser.ForallExprContext ctx) {
        return "forall (".concat(ctx.IDENTIFIER().getText()).concat(":").concat(visit(ctx.type())).concat(")").concat(visit(ctx.expr()));
    }

    @Override
    public String visitExistsExpr(UppaalParser.ExistsExprContext ctx) {
        return "exists (".concat(ctx.IDENTIFIER().getText()).concat(":").concat(visit(ctx.type())).concat(")").concat(visit(ctx.expr()));
    }

    @Override
    public String visitSumExpr(UppaalParser.SumExprContext ctx) {
        return "sum (".concat(ctx.IDENTIFIER().getText()).concat(":").concat(visit(ctx.type())).concat(")").concat(visit(ctx.expr()));
    }

    @Override
    public String visitTrueExpr(UppaalParser.TrueExprContext ctx) {
        return "true";
    }

    @Override
    public String visitFalseExpr(UppaalParser.FalseExprContext ctx) {
        return "false";
    }

    @Override
    public String visitArguments(UppaalParser.ArgumentsContext ctx) {
        String arguments = "";

        List<UppaalParser.ExprContext> expressions = ctx.expr();

        String separator = "";
        for(UppaalParser.ExprContext expr: expressions){
            arguments = arguments.concat(separator).concat(visit(expr));
            separator = ", ";
        }
        return arguments;
    }

    @Override
    public String visitVariableDeclaration(UppaalParser.VariableDeclarationContext ctx) {
        return visit(ctx.variableDecl());
    }

    @Override
    public String visitVariableDecl(UppaalParser.VariableDeclContext ctx) {
        String variableDecl = visit(ctx.type());

        List<UppaalParser.VariableIDContext> variablesId = ctx.variableID();
        String separator = " ";

        for(UppaalParser.VariableIDContext variableId: variablesId){
            variableDecl = variableDecl.concat(separator).concat(visit(variableId));
            separator = ", ";
        }
        variableDecl = variableDecl.concat(";");
        return variableDecl;
    }

    @Override
    public String visitType(UppaalParser.TypeContext ctx) {
        String type = "";
        if(ctx.prefix() != null){
            type = visit(ctx.prefix()).concat(" ");
        }
        type = type.concat(visit(ctx.typeId()));
        return type;
    }

    @Override
    public String visitUrgentPrefix(UppaalParser.UrgentPrefixContext ctx) {
        return "urgent";
    }

    @Override
    public String visitBroadcastPrefix(UppaalParser.BroadcastPrefixContext ctx) {
        return "broadcast";
    }

    @Override
    public String visitMetaPrefix(UppaalParser.MetaPrefixContext ctx) {
        return "meta";
    }

    @Override
    public String visitConstPrefix(UppaalParser.ConstPrefixContext ctx) {
        return "const";
    }

    @Override
    public String visitIdentifierType(UppaalParser.IdentifierTypeContext ctx) {
        return ctx.IDENTIFIER().getText();
    }

    @Override
    public String visitIntType(UppaalParser.IntTypeContext ctx) {
        return "int";
    }

    @Override
    public String visitDoubleType(UppaalParser.DoubleTypeContext ctx) {
        return "double";
    }

    @Override
    public String visitClockType(UppaalParser.ClockTypeContext ctx) {
        return "clock";
    }

    @Override
    public String visitChanType(UppaalParser.ChanTypeContext ctx) {
        return "chan";
    }

    @Override
    public String visitBoolType(UppaalParser.BoolTypeContext ctx) {
        return "bool";
    }

    @Override
    public String visitIntDomainType(UppaalParser.IntDomainTypeContext ctx) {
        String intDomain = "int [";
        intDomain = intDomain.concat(visit(ctx.expr(0))).concat(", ").concat(visit(ctx.expr(1))).concat("]");
        return intDomain;
    }

    @Override
    public String visitScalarType(UppaalParser.ScalarTypeContext ctx) {
        String scalar = "scalar [";
        scalar = scalar.concat(visit(ctx.expr())).concat("]");
        return scalar;
    }

    @Override
    public String visitStructType(UppaalParser.StructTypeContext ctx) {
        String struct = "struct {\n";
        List<UppaalParser.FieldDeclContext> fields = ctx.fieldDecl();
        for(UppaalParser.FieldDeclContext field: fields){
            struct = struct.concat(visit(field));
        }
        struct = struct.concat("}");
        return struct;
    }

    @Override
    public String visitFieldDecl(UppaalParser.FieldDeclContext ctx) {
        String fieldDecl = visit(ctx.type());
        List<UppaalParser.VarFieldDeclContext> varsField = ctx.varFieldDecl();
        String separator = " ";

        for(UppaalParser.VarFieldDeclContext varField: varsField){
            fieldDecl = fieldDecl.concat(separator).concat(visit(varField));
            separator = ", ";
        }

        fieldDecl = fieldDecl.concat(";");
        return fieldDecl;
    }

    @Override
    public String visitVarFieldDecl(UppaalParser.VarFieldDeclContext ctx) {
        String varField = ctx.IDENTIFIER().getText();
        List<UppaalParser.ArrayDeclContext> arraysDecl = ctx.arrayDecl();

        for(UppaalParser.ArrayDeclContext arrayDecl: arraysDecl){
            varField = varField.concat(visit(arrayDecl));
        }
        return varField;
    }

    @Override
    public String visitArrayDeclExpr(UppaalParser.ArrayDeclExprContext ctx) {
        String arrayDecl = "[";
        arrayDecl = arrayDecl.concat(visit(ctx.expr())).concat("]");
        return arrayDecl;
    }

    @Override
    public String visitArrayDeclType(UppaalParser.ArrayDeclTypeContext ctx) {
        String arrayDecl = "[";
        arrayDecl = arrayDecl.concat(visit(ctx.type())).concat("]");
        return arrayDecl;
    }

    @Override
    public String visitVariableID(UppaalParser.VariableIDContext ctx) {
        String variableId = ctx.IDENTIFIER().getText().concat(" ");

        List<UppaalParser.ArrayDeclContext> arraysDecl = ctx.arrayDecl();

        for(UppaalParser.ArrayDeclContext arrayDecl: arraysDecl){
            variableId = variableId.concat(visit(arrayDecl));
        }

        if(ctx.initialiser()!=null){
            variableId = variableId.concat("= ").concat(visit(ctx.initialiser()));
        }

        return variableId;
    }

    @Override
    public String visitInitialiserExpr(UppaalParser.InitialiserExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public String visitInitialiserArray(UppaalParser.InitialiserArrayContext ctx) {
        String initiliserArray = "{";
        List<UppaalParser.InitialiserContext> initialisers = ctx.initialiser();
        String separator = "";
        for(UppaalParser.InitialiserContext initialiser : initialisers){
            initiliserArray = initiliserArray.concat(separator).concat(visit(initialiser));
            separator = ", ";
        }

        initiliserArray = initiliserArray.concat("}");

        return initiliserArray;
    }

    @Override
    public String visitTypeDeclaration(UppaalParser.TypeDeclarationContext ctx) {
        return visit(ctx.typeDecl());
    }

    @Override
    public String visitTypeDecl(UppaalParser.TypeDeclContext ctx) {
        String typeDecl = "typedef ".concat(visit(ctx.type()));

        List<UppaalParser.VarFieldDeclContext> varFields = ctx.varFieldDecl();
        String separator = " ";
        for (UppaalParser.VarFieldDeclContext varField: varFields){
            typeDecl = typeDecl.concat(separator).concat(visit(varField));
            separator = ", ";
        }

        typeDecl = typeDecl.concat(";");
        return typeDecl;
    }

    @Override
    public String visitFunctionDeclaration(UppaalParser.FunctionDeclarationContext ctx) {
        return visit(ctx.function());
    }

    @Override
    public String visitFunction(UppaalParser.FunctionContext ctx) {
        String visitFunction = visit(ctx.type()).concat(" ").concat(ctx.IDENTIFIER().getText()).concat("(");
        visitFunction = visitFunction.concat(visit(ctx.funcParameters()));
        visitFunction = visitFunction.concat(")").concat(visit(ctx.block()));
        return visitFunction;
    }

    @Override
    public String visitFuncParameters(UppaalParser.FuncParametersContext ctx) {
        String visitFunParameters = "";

        List<UppaalParser.FuncParameterContext> funcParameters = ctx.funcParameter();
        String separator = "";

        for(UppaalParser.FuncParameterContext funcParameter: funcParameters){
            visitFunParameters = visitFunParameters.concat(separator).concat(visit(funcParameter));
            separator = ", ";
        }

        return visitFunParameters;
    }

    @Override
    public String visitFuncParameter(UppaalParser.FuncParameterContext ctx) {
        String funcParameter = visit(ctx.type()).concat(" ");

        if(ctx.BITAND() != null){
            funcParameter = funcParameter.concat("&amp;");
        }

        funcParameter = funcParameter.concat(visit(ctx.varFieldDecl()));

        return funcParameter;
    }

    @Override
    public String visitBlock(UppaalParser.BlockContext ctx) {
        String block = "{\n";
        block = block.concat(visit(ctx.declContent()));

        List<UppaalParser.StatementContext> statements = ctx.statement();

        for(UppaalParser.StatementContext statement : statements){
            block = block.concat(visit(statement)).concat("\n");
        }

        block = block.concat("}");

        return block;
    }

    @Override
    public String visitStatementBlock(UppaalParser.StatementBlockContext ctx) {
        return visit(ctx.block());
    }

    @Override
    public String visitStatementSemicolon(UppaalParser.StatementSemicolonContext ctx) {
        return ";";
    }

    @Override
    public String visitStatementExpr(UppaalParser.StatementExprContext ctx) {
        return visit(ctx.expr()).concat(";");
    }

    @Override
    public String visitStatementFor(UppaalParser.StatementForContext ctx) {
        return visit(ctx.forLoop());
    }

    @Override
    public String visitStatementIteration(UppaalParser.StatementIterationContext ctx) {
        return visit(ctx.iteration());
    }

    @Override
    public String visitStatementWhile(UppaalParser.StatementWhileContext ctx) {
        return visit(ctx.whileLoop());
    }

    @Override
    public String visitStatementDoWhile(UppaalParser.StatementDoWhileContext ctx) {
        return visit(ctx.doWhile());
    }

    @Override
    public String visitStatementIf(UppaalParser.StatementIfContext ctx) {
        return visit(ctx.ifStatement());
    }

    @Override
    public String visitStatementReturn(UppaalParser.StatementReturnContext ctx) {
        return visit(ctx.returnStatement());
    }

    @Override
    public String visitForLoop(UppaalParser.ForLoopContext ctx) {
        String forLoop = "for (";
        forLoop = forLoop.concat(visit(ctx.expr(0))).concat(";").concat(visit(ctx.expr(1))).concat(";").concat(visit(ctx.expr(2))).concat(")");
        forLoop = forLoop.concat(visit(ctx.statement()));
        return forLoop;
    }

    @Override
    public String visitIteration(UppaalParser.IterationContext ctx) {
        String iteration = "for (";
        iteration = iteration.concat(ctx.IDENTIFIER().getText()).concat(":").concat(visit(ctx.type())).concat(")");
        iteration = iteration.concat(visit(ctx.statement()));
        return iteration;
    }

    @Override
    public String visitWhileLoop(UppaalParser.WhileLoopContext ctx) {
        String whileLoop = "while (";
        whileLoop = whileLoop.concat(visit(ctx.expr())).concat(")");
        whileLoop = whileLoop.concat(visit(ctx.statement()));
        return whileLoop;
    }

    @Override
    public String visitDoWhile(UppaalParser.DoWhileContext ctx) {
        String doWhile = "do ";
        doWhile = doWhile.concat(visit(ctx.statement())).concat("while (").concat(visit(ctx.expr())).concat(");");
        return doWhile;
    }

    @Override
    public String visitIfStatement(UppaalParser.IfStatementContext ctx) {
        String ifStatement = "if (";
        ifStatement = ifStatement.concat(visit(ctx.expr())).concat(")").concat(visit(ctx.statement(0)));
        if (ctx.statement(1)!=null){
            ifStatement = ifStatement.concat("else ").concat(visit(ctx.statement(1)));
        }
        return ifStatement;
    }

    @Override
    public String visitReturnStatement(UppaalParser.ReturnStatementContext ctx) {
        String returnStatement = "return ";
        if(ctx.expr()!=null){
            returnStatement = returnStatement.concat(visit(ctx.expr()));
        }
        returnStatement = returnStatement.concat(";");
        return returnStatement;
    }

    @Override
    public String visitChanDeclaration(UppaalParser.ChanDeclarationContext ctx) {
        return visit(ctx.chanPriority());
    }

    @Override
    public String visitChanPriority(UppaalParser.ChanPriorityContext ctx) {
        String chanPriority = "chan priority ";
        chanPriority = chanPriority.concat(visit(ctx.chanOrDef(0)));
        for(int i=0; i<ctx.chanSeparator().size(); i++){
            chanPriority = chanPriority.concat(visit(ctx.chanSeparator(i))).concat(visit(ctx.chanOrDef(i+1)));
        }
        return chanPriority;
    }

    @Override
    public String visitChanOrDef(UppaalParser.ChanOrDefContext ctx) {
        if(ctx.DEFAULT()!=null){
            return "default";
        }
        return visit(ctx.chanExpr());
    }

    @Override
    public String visitChanSeparator(UppaalParser.ChanSeparatorContext ctx) {
        if(ctx.COMMA()!=null){
            return ", ";
        }
        return "&lt;";
    }

    @Override
    public String visitChanIdentifier(UppaalParser.ChanIdentifierContext ctx) {
        return ctx.IDENTIFIER().getText();
    }

    @Override
    public String visitChanArray(UppaalParser.ChanArrayContext ctx) {
        String chanArray = visit(ctx.chanExpr()).concat("[");
        chanArray = chanArray.concat(visit(ctx.expr())).concat("]");
        return chanArray;
    }


    @Override
    public String visitTemplate(UppaalParser.TemplateContext ctx) {
        String template = "<template>\n";
        template = template.concat(visit(ctx.tempContent()));
        template = template.concat("</template>");
        return template;
    }

    @Override
    public String visitTempContent(UppaalParser.TempContentContext ctx) {
        String tempContent = "";
        boolean addInput = false;
        if(ctx.name() != null){
            //print <name> ~[<&]+ </name>
            this.currentEnv = ctx.name().anything().getText();
            tempContent = tempContent.concat(visit(ctx.name())).concat("\n");
            addInput = this.templateTad.equals(ctx.name().anything().getText());
        }
        if(ctx.parameter() != null){
            //print <parameter> ~[<&]+ </parameter>
            tempContent = tempContent.concat(visit(ctx.parameter())).concat("\n");
        }
        if(ctx.declaration() != null){
            //print <declaration> ~[<&] </declaration>
            tempContent = tempContent.concat(visit(ctx.declaration())).concat("\n");
        }

        List<UppaalParser.LocationContext> locations = ctx.location();
        for(UppaalParser.LocationContext location: locations){
            tempContent = tempContent.concat(visit(location)).concat("\n");
        }

        List<UppaalParser.BranchpointContext> branchpoints = ctx.branchpoint();
        for(UppaalParser.BranchpointContext branchpoint: branchpoints){
            tempContent = tempContent.concat(visit(branchpoint)).concat("\n");
        }

        tempContent = tempContent.concat(visit(ctx.initLoc())).concat("\n");

        if(addInput){
            tempContent = tempContent.concat("<transition>\n<source ref=").concat(this.sourceTad).concat("/>\n");
            tempContent = tempContent.concat("<target ref=").concat(this.targetTad).concat("/>\n");
            if(!this.outputTad.equals("")){
                tempContent = tempContent.concat("<label kind=\"synchronisation\" x=\"0\" y=\"0\">").concat(this.outputTad).concat("</label>").concat("\n");
            }
            tempContent = tempContent.concat("</transition>\n");
        }
        List<UppaalParser.TransitionContext> transitions = ctx.transition();

        for(UppaalParser.TransitionContext transition: transitions){
            this.isControllable = false;
            tempContent = tempContent.concat(visit(transition)).concat("\n");
        }

        return tempContent;
    }

    @Override
    public String visitName(UppaalParser.NameContext ctx) {
        String name = "<name";
        if(ctx.coordinate() != null){
            name = name.concat(visit(ctx.coordinate()));
        }
        name = name.concat(">").concat(ctx.anything().getText());
        name = name.concat("</name>");
        return name;
    }

    @Override
    public String visitCoordinate(UppaalParser.CoordinateContext ctx) {
        String coordinate = " x=".concat(ctx.STRING(0).getText());
        coordinate = coordinate.concat(" y=").concat(ctx.STRING(1).getText());
        return coordinate;
    }

    @Override
    public String visitParameter(UppaalParser.ParameterContext ctx) {
        String parameter = ctx.OPEN_PARAMETER().getText();

        parameter = parameter.concat(visit(ctx.funcParameters()));

        parameter = parameter.concat(ctx.CLOSE_PARAMETER().getText());

        return parameter;
    }

    @Override
    public String visitLocation(UppaalParser.LocationContext ctx) {
        if(ctx.STRING().getText().equals(this.locationSmi)){
            return "";
        }

        String location = "<location id=".concat(ctx.STRING().getText());
        if(ctx.coordinate()!=null){
            location = location.concat(visit(ctx.coordinate()));
        }
        location = location.concat(">").concat("\n");
        if(ctx.name()!=null){
            location = location.concat(visit(ctx.name())).concat("\n");
        }

        List<UppaalParser.LabelLocContext> labelLocs = ctx.labelLoc();
        for(UppaalParser.LabelLocContext labelLoc: labelLocs){
            location = location.concat(visit(labelLoc)).concat("\n");
        }

        if(ctx.URGENT_LOC()!=null){
            location = location.concat("<urgent/>\n");
        }
        if(ctx.COMMITTED()!=null){
            location = location.concat("<committed/>\n");
        }
        location = location.concat("</location>");
        return location;
    }

    @Override
    public String visitLabelLoc(UppaalParser.LabelLocContext ctx) {
        String labelLoc = "<label kind=";
        labelLoc = labelLoc.concat(ctx.STRING().getText());

        if(ctx.coordinate()!=null){
            labelLoc = labelLoc.concat(visit(ctx.coordinate()));
        }

        labelLoc = labelLoc.concat(">");

        labelLoc = labelLoc.concat(visit(ctx.anything()));
        labelLoc = labelLoc.concat("</label>");
        return labelLoc;
    }

    @Override
    public String visitBranchpoint(UppaalParser.BranchpointContext ctx) {
        String branchpoint = "<branchpoint id=";
        branchpoint = branchpoint.concat(ctx.STRING().getText());

        if(ctx.coordinate()!=null){
            branchpoint = branchpoint.concat(visit(ctx.coordinate()));
        }

        branchpoint = branchpoint.concat(">");

        branchpoint = branchpoint.concat(" </branchpoint>");
        return branchpoint;
    }

    @Override
    public String visitInitLoc(UppaalParser.InitLocContext ctx) {
        String initLoc = "<init ref=";
        initLoc = initLoc.concat(ctx.STRING().getText()).concat("/>");
        return initLoc;
    }

    @Override
    public String visitTransition(UppaalParser.TransitionContext ctx) {
        this.indexCurrentTransition++;
        if(this.indexCurrentTransition==this.tmiOperator){
            return "";
        }
        if(this.locationSmi.equals(ctx.source().STRING().getText())){
            return "";
        }
        if(this.locationSmi.equals(ctx.target().STRING().getText())){
            return "";
        }
        String transition = "<transition>\n";

        transition = transition.concat(visit(ctx.source())).concat("\n");
        transition = transition.concat(visit(ctx.target())).concat("\n");

        List<UppaalParser.LabelTransSyncInputContext> labelsInput = ctx.labelTransSyncInput();
        for(UppaalParser.LabelTransSyncInputContext label: labelsInput){
            transition = transition.concat(visit(label)).concat("\n");
        }

        List<UppaalParser.LabelTransSyncOutputContext> labelsOutput = ctx.labelTransSyncOutput();
        for(UppaalParser.LabelTransSyncOutputContext label: labelsOutput){
            transition = transition.concat(visit(label)).concat("\n");
        }

        List<UppaalParser.LabelTransGuardContext> labelsGuard = ctx.labelTransGuard();
        for(UppaalParser.LabelTransGuardContext label: labelsGuard){
            transition = transition.concat(visit(label)).concat("\n");
        }

        List<UppaalParser.LabelTransContext> labelsTrans = ctx.labelTrans();
        for(UppaalParser.LabelTransContext label: labelsTrans){
            transition = transition.concat(visit(label)).concat("\n");
        }

        List<UppaalParser.NailContext> nails = ctx.nail();
        for(UppaalParser.NailContext nail: nails){
            transition = transition.concat(visit(nail)).concat("\n");
        }

        transition = transition.concat("</transition>");
        return transition;
    }

    @Override
    public String visitSource(UppaalParser.SourceContext ctx) {
        String source = "<source ref=";
        source = source.concat(ctx.STRING().getText()).concat("/>");
        return source;
    }

    @Override
    public String visitTarget(UppaalParser.TargetContext ctx) {
        String target = "<target ref=";
        target = target.concat(ctx.STRING().getText()).concat("/>");
        return target;
    }

    @Override
    public String visitLabelTrans(UppaalParser.LabelTransContext ctx) {
        String label = "<label kind=";
        label = label.concat(ctx.STRING().getText());
        if(ctx.coordinate() != null){
            label = label.concat(visit(ctx.coordinate()));
        }
        label = label.concat(">").concat(ctx.anything().getText());
        label = label.concat("</label>");
        return label;
    }

    @Override
    public String visitLabelTransGuard(UppaalParser.LabelTransGuardContext ctx) {
        String label = ctx.OPEN_GUARD().getText();
        if(ctx.guardExpr()!=null){
            label = label.concat(visit(ctx.guardExpr()));
        }
        label = label.concat("</label>");
        return label;
    }

    @Override
    public String visitLabelTransSyncInput(UppaalParser.LabelTransSyncInputContext ctx) {
        this.isControllable = true;
        String label = ctx.OPEN_SYNC().getText();
        if(ctx.expr()!=null){
            label = label.concat(visit(ctx.expr()));
        }
        label = label.concat("?</label>");
        return label;
    }

    @Override
    public String visitLabelTransSyncOutput(UppaalParser.LabelTransSyncOutputContext ctx) {
        String label = ctx.OPEN_SYNC().getText();
        if(ctx.expr()!=null){
            label = label.concat(visit(ctx.expr()));
        }
        label = label.concat("!</label>");
        return label;
    }

    @Override
    public String visitIdentifierGuard(UppaalParser.IdentifierGuardContext ctx) {
        this.isClockRight |= this.clockEnv.get(this.currentEnv).contains(new ClockType(ctx.IDENTIFIER().getText()));
        this.isClockRight |= this.clockEnv.get("Global").contains(new ClockType(ctx.IDENTIFIER().getText()));
        return ctx.IDENTIFIER().getText();
    }

    @Override
    public String visitNatGuard(UppaalParser.NatGuardContext ctx) {
        return ctx.NAT().getText();
    }

    @Override
    public String visitDoubleGuard(UppaalParser.DoubleGuardContext ctx) {
        return ctx.POINT().getText();
    }

    @Override
    public String visitArrayGuard(UppaalParser.ArrayGuardContext ctx) {
        return visit(ctx.guardExpr(0)).concat("[").concat(visit(ctx.guardExpr(1))).concat("]");
    }

    @Override
    public String visitStopWatchGuard(UppaalParser.StopWatchGuardContext ctx) {
        return visit(ctx.guardExpr()).concat("'");
    }

    @Override
    public String visitParenthesisGuard(UppaalParser.ParenthesisGuardContext ctx) {
        String guard = "(";
        guard = guard.concat(visit(ctx.guardExpr())).concat(")");
        return guard;
    }

    @Override
    public String visitGuardIncrement(UppaalParser.GuardIncrementContext ctx) {
        return visit(ctx.guardExpr()).concat("++");
    }

    @Override
    public String visitIncrementGuard(UppaalParser.IncrementGuardContext ctx) {
        return ("++").concat(visit(ctx.guardExpr()));
    }

    @Override
    public String visitGuardDecrement(UppaalParser.GuardDecrementContext ctx) {
        return visit(ctx.guardExpr()).concat("--");
    }

    @Override
    public String visitDecrementGuard(UppaalParser.DecrementGuardContext ctx) {
        return ("--").concat(visit(ctx.guardExpr()));
    }

    @Override
    public String visitAssignGuard(UppaalParser.AssignGuardContext ctx) {
        String assign = visit(ctx.guardExpr(0));
        assign = assign.concat(ctx.assign.getText());
        assign = assign.concat(visit(ctx.guardExpr(1)));
        return assign;
    }

    @Override
    public String visitUnaryGuard(UppaalParser.UnaryGuardContext ctx) {
        return ctx.unary.getText().concat(" ").concat(visit(ctx.guardExpr()));
    }

    public String increase(String expr){
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        String exprPlusOne;
        if(pattern.matcher(expr).matches()){
            int newNumber = Integer.parseInt(expr) + 1;
            exprPlusOne =  String.valueOf(newNumber);
            return exprPlusOne;
        }
        exprPlusOne = ("(").concat(expr).concat(" + 1 )");
        return exprPlusOne;
    }
    public String decrease(String expr){
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        String exprPlusOne;
        if(pattern.matcher(expr).matches()){
            int newNumber = Integer.parseInt(expr) - 1;
            exprPlusOne =  " ".concat(String.valueOf(newNumber)).concat(" ");
            return exprPlusOne;
        }
        exprPlusOne = ("(").concat(expr).concat(" - 1 )");
        return exprPlusOne;
    }
    @Override
    public String visitComparisonGuard(UppaalParser.ComparisonGuardContext ctx) {

        String guardLeft = visit(ctx.guardExpr(0));
        this.isClockLeft = this.isClockRight;
        this.isClockRight = false;

        String operator = ctx.binary.getText();
        String guardRight = visit(ctx.guardExpr(1));

        if(this.isClockLeft ^ this.isClockRight){
            if(this.isControllable){
                if(this.isClockLeft){
                    this.isClockLeft = false;
                    if(operator.equals("&gt;") ||operator.equals("&gt;=")){
                        if(this.currentEnv.equals(this.envTarget)){
                            this.indexCxl++;
                            if(this.indexCxl==this.idCxlOperator){
                                guardLeft = guardLeft.concat(" ").concat(operator).concat(" ").concat(increase(guardRight));
                                return guardLeft;
                            }
                        }
                    }
                    if(operator.equals("&lt;") || operator.equals("&lt;=")){
                        if(this.currentEnv.equals(this.envTarget)){
                            this.indexCxs++;
                            if(this.indexCxs==this.idCxsOperator){
                                guardLeft = guardLeft.concat(" ").concat(operator).concat(" ").concat(decrease(guardRight));
                                return guardLeft;
                            }
                        }
                    }
                }
                else{
                    this.isClockRight = false;
                    if(operator.equals("&lt;") || operator.equals("&lt;=")){
                        if(this.currentEnv.equals(this.envTarget)){
                            this.indexCxl++;
                            if(this.indexCxl==this.idCxlOperator){
                                guardLeft = increase(guardLeft).concat(" ").concat(operator).concat(" ").concat(guardRight);
                                return guardLeft;
                            }
                        }
                    }
                    if(operator.equals("&gt;") || operator.equals("&gt;=")){
                        if(this.currentEnv.equals(this.envTarget)){
                            this.indexCxs++;
                            if(this.indexCxs==this.idCxsOperator){
                                guardLeft = decrease(guardLeft).concat(" ").concat(operator).concat(" ").concat(guardRight);
                                return guardLeft;
                            }
                        }
                    }
                }
            }
            else{
                if(this.isClockLeft){
                    this.isClockLeft = false;
                    if(operator.equals("&lt;") || operator.equals("&lt;=")){
                        if(this.currentEnv.equals(this.envTarget)){
                            this.indexCxl++;
                            if(this.indexCxl==this.idCxlOperator){
                                guardLeft = guardLeft.concat(" ").concat(operator).concat(increase(guardRight));
                                return guardLeft;
                            }
                        }
                    }
                    if(operator.equals("&gt;") || operator.equals("&gt;=")){
                        if(this.currentEnv.equals(this.envTarget)){
                            this.indexCxs++;
                            if(this.indexCxs==this.idCxsOperator){
                                guardLeft = guardLeft.concat(" ").concat(operator).concat(decrease(guardRight));
                                return guardLeft;
                            }
                        }

                    }
                }
                else{
                    this.isClockRight = false;
                    if(operator.equals("&gt;") || operator.equals("&gt;=")){
                        if(this.currentEnv.equals(this.envTarget)){
                            this.indexCxl++;
                            if(this.indexCxl==this.idCxlOperator){
                                guardLeft = increase(guardLeft).concat(" ").concat(operator).concat(" ").concat(guardRight);
                                return guardLeft;
                            }
                        }
                    }
                    if(operator.equals("&lt;") || operator.equals("&lt;=")){
                        if(this.currentEnv.equals(this.envTarget)){
                            this.indexCxs++;
                            if(this.indexCxs==this.idCxsOperator){
                                guardLeft = decrease(guardLeft).concat(" ").concat(operator).concat(" ").concat(guardRight);
                                return guardLeft;
                            }
                        }
                    }
                }

            }
            if(!operator.equals("==") && !operator.equals("!=")){
                if(this.currentEnv.equals(this.envTarget)){
                    this.indexCcn++;
                    if(this.indexCcn==this.idCcnOperator) {

                        switch (ctx.binary.getType()) {
                            case UppaalParser.GREATER:
                                guardLeft = guardLeft.concat(" &lt;= ");
                                break;
                            case UppaalParser.GREATEREQ:
                                guardLeft = guardLeft.concat(" &lt; ");
                                break;
                            case UppaalParser.LESS:
                                guardLeft = guardLeft.concat(" &gt;= ");
                                break;
                            case UppaalParser.LESSEQ:
                                guardLeft = guardLeft.concat(" &gt; ");
                                break;
                        }
                        guardLeft = guardLeft.concat(visit(ctx.guardExpr(1)));

                        this.isClockLeft = false;
                        this.isClockRight = false;
                        return guardLeft;
                    }
                }
            }
        }
        this.isClockLeft = false;
        this.isClockRight = false;
        guardLeft = guardLeft.concat(" ").concat(operator).concat(" ").concat(guardRight);
        return guardLeft;

    }

    @Override
    public String visitBinaryGuard(UppaalParser.BinaryGuardContext ctx) {
        String guard = visit(ctx.guardExpr(0));
        guard = guard.concat(" ").concat(ctx.binary.getText()).concat(" ");
        guard = guard.concat(visit(ctx.guardExpr(1)));
        return guard;
    }

    @Override
    public String visitIfGuard(UppaalParser.IfGuardContext ctx) {
        return visit(ctx.guardExpr(0)).concat(" ? ").concat(visit(ctx.guardExpr(1))).concat(" : ").concat(visit(ctx.guardExpr(2)));
    }

    @Override
    public String visitDotGuard(UppaalParser.DotGuardContext ctx) {
        return visit(ctx.guardExpr()).concat(".").concat(ctx.IDENTIFIER().getText());
    }

    @Override
    public String visitFuncGuard(UppaalParser.FuncGuardContext ctx) {
        return ctx.IDENTIFIER().getText().concat("(").concat(visit(ctx.guardArguments())).concat(")");
    }

    @Override
    public String visitForallGuard(UppaalParser.ForallGuardContext ctx) {
        return ("forall(").concat(ctx.IDENTIFIER().getText()).concat(":").concat(visit(ctx.guardType())).concat(")").concat(visit(ctx.guardExpr()));
    }

    @Override
    public String visitExistsGuard(UppaalParser.ExistsGuardContext ctx) {
        return ("exists(").concat(ctx.IDENTIFIER().getText()).concat(":").concat(visit(ctx.guardType())).concat(")").concat(visit(ctx.guardExpr()));
    }

    @Override
    public String visitSumGuard(UppaalParser.SumGuardContext ctx) {
        return ("sum(").concat(ctx.IDENTIFIER().getText()).concat(":").concat(visit(ctx.guardType())).concat(")").concat(visit(ctx.guardExpr()));
    }

    @Override
    public String visitTrueGuard(UppaalParser.TrueGuardContext ctx) {
        return "true";
    }

    @Override
    public String visitFalseGuard(UppaalParser.FalseGuardContext ctx) {
        return "false";
    }



    @Override
    public String visitGuardArguments(UppaalParser.GuardArgumentsContext ctx) {
        String arguments = "";

        List<UppaalParser.GuardExprContext> expressions = ctx.guardExpr();

        String separator = "";
        for(UppaalParser.GuardExprContext expr: expressions){
            arguments = arguments.concat(separator).concat(visit(expr));
            separator = ", ";
        }
        return arguments;
    }

    @Override
    public String visitGuardType(UppaalParser.GuardTypeContext ctx) {
        String type = "";
        if(ctx.META() != null){
            type = "meta ";
        }
        if(ctx.CONST() != null){
            type = "const ";
        }
        return type.concat(visit(ctx.guardTypeId()));
    }

    @Override
    public String visitGuardTypeInt(UppaalParser.GuardTypeIntContext ctx) {
        return "int";
    }

    @Override
    public String visitGuardTypeIntDomain(UppaalParser.GuardTypeIntDomainContext ctx) {
        return ("int[").concat(visit(ctx.guardExpr(0))).concat(", ").concat(visit(ctx.guardExpr(1))).concat("]");
    }

    @Override
    public String visitGuardTypeScalar(UppaalParser.GuardTypeScalarContext ctx) {
        return ("scalar[").concat(visit(ctx.guardExpr())).concat("]");
    }

    @Override
    public String visitNail(UppaalParser.NailContext ctx) {
        //<nail x="391" y="85"/>
        String nail = "<nail ";
        nail = nail.concat(visit(ctx.coordinate()));
        nail = nail.concat("/>");
        return nail;
    }

    @Override
    public String visitSystem(UppaalParser.SystemContext ctx) {
        return ("<system>").concat(visit(ctx.anything())).concat("</system>");
    }

    @Override
    public String visitQueries(UppaalParser.QueriesContext ctx) {
        String queries = "<queries>\n";
        List<UppaalParser.QueryContext> queryList = ctx.query();
        for(UppaalParser.QueryContext query: queryList){
            queries = queries.concat(visit(query)).concat("\n");
        }
        queries = queries.concat("</queries>");
        return queries;
    }

    @Override
    public String visitQuery(UppaalParser.QueryContext ctx) {
        String query = "<query>\n";
        if(ctx.formula()!=null){
            query = query.concat(visit(ctx.formula())).concat("\n");
        }
        if(ctx.comment()!=null){
            query = query.concat(visit(ctx.comment())).concat("\n");
        }
        query = query.concat("</query>");
        return query;
    }

    @Override
    public String visitFormula(UppaalParser.FormulaContext ctx) {
        return ("<formula>").concat(visit(ctx.anything())).concat("</formula>");
    }

    @Override
    public String visitComment(UppaalParser.CommentContext ctx) {
        return ("<comment>").concat(visit(ctx.anything())).concat("</comment>");
    }

    @Override
    public String visitAnything(UppaalParser.AnythingContext ctx) {
        return ctx.getText();
    }

}
