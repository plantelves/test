package test10;

//import test10.TestClassModel.MethodModel;



//�۲���
interface MethodModel{
    fun shouldBeGenerated(): Boolean = true
    fun generateSignature(p: Printer)
    fun generateBody(p: Printer)
}

//����۲���
interface TestMethodModel : MethodModel {
    override fun generateSignature(p: Printer) {
        p.print("public void $name() throws Exception")
    }
}   


//Ŀ��
public abstract class Generator{
	 public abstract void generateTestMethod(Printer p, MethodModel methodModel);	
}

//����Ŀ��
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