package Compare;

import java.io.*;
//Serialization is time-consuming
class Professor2 implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  String name;
  int age;

  Professor2(String name, int age) {
      this.name = name;
      this.age = age;
  }
}

class Student2 implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  String name;// ��������
  int age;
  Professor2 p;// ѧ��1��ѧ��2������ֵ����һ���ġ�

  Student2(String name, int age, Professor2 p) {
      this.name = name;
      this.age = age;
      this.p = p;
  }

  public Object deepClone() throws IOException, OptionalDataException,
          ClassNotFoundException {
      // ������д������
      ByteArrayOutputStream bo = new ByteArrayOutputStream();
      ObjectOutputStream oo = new ObjectOutputStream(bo);
      oo.writeObject(this);
      // �����������
      ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
      ObjectInputStream oi = new ObjectInputStream(bi);
      return (oi.readObject());
  }

}

public class DeepCopy2 {

  /**
   * @param args
   */
  public static void main(String[] args) throws OptionalDataException,
          IOException, ClassNotFoundException {
      long t1 = System.currentTimeMillis();
      Professor2 p = new Professor2("wangwu", 50);
      Student2 s1 = new Student2("zhangsan", 18, p);
      Student2 s2 = (Student2) s1.deepClone();
      s2.p.name = "lisi";
      s2.p.age = 30;
      System.out.println("name=" + s1.p.name + "," + "age=" + s1.p.age); // ѧ��1�Ľ��ڲ��ı䡣
      long t2 = System.currentTimeMillis();
      System.out.println(t2-t1);
  }

}