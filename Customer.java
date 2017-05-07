package Customer;

import javax.swing.JOptionPane;

class Meal{	
	private String food;
	private String drink;
	
	public void setFood(String food){
		this.food=food;
	};
	public void setDrink(String drink){
		this.drink=drink;
	};
	public String getFood(){
		return food;
	};
	public String getDrink(){
		return drink;
	};
}		//��ȡʳ��

abstract class MealBuilder{
	protected Meal meal = new Meal();
	
	public abstract void buildFood();
	public abstract void buildDrink();
	
	public Meal getMeal(){
		return meal;
	}
}		//����ʳ�ｨ����

class SubMealBuilderA extends MealBuilder{

	public void buildFood(){
		meal.setFood("����");
	}
	public void buildDrink() {
		meal.setDrink("����");
	}
}		//����ʳ�ｨ�췽��ʵ�� �ײ�A

class SubMealBuilderB extends MealBuilder{	
	public void buildFood(){
		meal.setFood("�����");
	}
	public void buildDrink() {
		meal.setDrink("��֭");
	}
}		//����ʳ�ｨ�췽��ʵ�� �ײ�B

class KFCWaiter{
	private MealBuilder mb;
	
	public KFCWaiter(MealBuilder mb){
		this.mb = mb;
	}
	
	public void setMealBuilder(MealBuilder mb){
		this.mb = mb;
	}
	
	public  Meal construct(){
		mb.buildFood();
		mb.buildDrink();
		return mb.getMeal();
	}
}		//ָ����waiter

public class Customer {
	public static void main(String args[]){
		String s = JOptionPane.showInputDialog("��ѡ���ײ�A|B ");
		if(s.equals("A")){
			MealBuilder mb_A = new SubMealBuilderA();
			KFCWaiter waiter_A = new KFCWaiter(mb_A);
			Meal meal_A = waiter_A.construct();
			
			System.out.println("�ײ�"+s);
			System.out.println(meal_A.getFood());
			System.out.println(meal_A.getDrink());
		}
		else if(s.equals("B")){
			MealBuilder mb_B = new SubMealBuilderB();
			KFCWaiter waiter_B = new KFCWaiter(mb_B);
			Meal meal_B = waiter_B.construct();
			
			System.out.println("�ײ�"+s);
			System.out.println(meal_B.getFood());
			System.out.println(meal_B.getDrink());
		}
		
		
		
		System.out.println("ʳ�����͸��˿�");
		
	}
}		//�����γ�ʳ���͸��˿�
