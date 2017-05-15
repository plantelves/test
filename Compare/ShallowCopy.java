package Compare;

class Professor0 implements Cloneable {
    String name;
    int age;
 
    Professor0(String name, int age) {
        this.name = name;
        this.age = age;
    }
 
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
 
class Student0 implements Cloneable {
    String name;// ��������
    int age;
    Professor0 p;// ѧ��1��ѧ��2������ֵ����һ���ġ�
 
    Student0(String name, int age, Professor0 p) {
        this.name = name;
        this.age = age;
        this.p = p;
    }
 
    public Object clone() {
        Student0 o = null;
        try {
            o = (Student0) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
 
        return o;
    }
}
 
public class ShallowCopy {
    public static void main(String[] args) {
        Professor0 p = new Professor0("wangwu", 50);
        Student0 s1 = new Student0("zhangsan", 18, p);
        Student0 s2 = (Student0) s1.clone();
        s2.p.name = "lisi";
        s2.p.age = 30;
        s2.name = "z";
        s2.age = 45;
        System.out.println("ѧ��s1��������" + s1.name + "\nѧ��s1���ڵ�������" + s1.p.name + "," + "\nѧ��s1���ڵ����" + s1.p.age);// ѧ��1�Ľ���
    }
}
		//s2���ˣ���s1Ҳ���ˣ�֤��s1��p��s2��pָ�����ͬһ������
		//���������е�ʵ�������У�ȴ�������������������Ҫ�����

 