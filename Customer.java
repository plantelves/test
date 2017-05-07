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
}		//获取食物

abstract class MealBuilder{
	protected Meal meal = new Meal();
	
	public abstract void buildFood();
	public abstract void buildDrink();
	
	public Meal getMeal(){
		return meal;
	}
}		//抽象食物建造者

class SubMealBuilderA extends MealBuilder{

	public void buildFood(){
		meal.setFood("汉堡");
	}
	public void buildDrink() {
		meal.setDrink("可乐");
	}
}		//具体食物建造方法实现 套餐A

class SubMealBuilderB extends MealBuilder{	
	public void buildFood(){
		meal.setFood("鸡肉卷");
	}
	public void buildDrink() {
		meal.setDrink("果汁");
	}
}		//具体食物建造方法实现 套餐B

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
}		//指挥者waiter

public class Customer {
	public static void main(String args[]){
		String s = JOptionPane.showInputDialog("请选择套餐A|B ");
		if(s.equals("A")){
			MealBuilder mb_A = new SubMealBuilderA();
			KFCWaiter waiter_A = new KFCWaiter(mb_A);
			Meal meal_A = waiter_A.construct();
			
			System.out.println("套餐"+s);
			System.out.println(meal_A.getFood());
			System.out.println(meal_A.getDrink());
		}
		else if(s.equals("B")){
			MealBuilder mb_B = new SubMealBuilderB();
			KFCWaiter waiter_B = new KFCWaiter(mb_B);
			Meal meal_B = waiter_B.construct();
			
			System.out.println("套餐"+s);
			System.out.println(meal_B.getFood());
			System.out.println(meal_B.getDrink());
		}
		
		
		
		System.out.println("食物已送给顾客");
		
	}
}		//最终形成食物送给顾客
