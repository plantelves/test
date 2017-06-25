package test10;

//import test10.TestClassModel.MethodModel;



//观察者
interface MethodModel{
    fun shouldBeGenerated(): Boolean = true
    fun generateSignature(p: Printer)
    fun generateBody(p: Printer)
}

//具体观察者
interface TestMethodModel : MethodModel {
    override fun generateSignature(p: Printer) {
        p.print("public void $name() throws Exception")
    }
}   


//目标
public abstract class Generator{
	 public abstract void generateTestMethod(Printer p, MethodModel methodModel);	
}

//具体目标
public class TestGenerator extends Generator{	    
	    public void generateTestMethod(Printer p, MethodModel methodModel) {
	        generateMetadata(p, methodModel);
	        
	        methodModel.generateSignature(p);
	        p.printWithNoIndent(" {");
	        p.println();
	        
	        p.pushIndent();

	        methodModel.generateBody(p);

	        p.popIndent();
	        p.println("}");
	    }
}