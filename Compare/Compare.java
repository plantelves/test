package Compare;

public class Compare {
	public static void main(String args[]){
		String x = "abc";
		String y = new String("abc");
		if(x == y) 
			System.out.println("== ʱx=y");
		else
			System.out.println("== ʱx!=y");
		if(x.equals(y))
			System.out.println("equals ʱx=y");
		else
			System.out.println("equals ʱx!=y");
	}
}
