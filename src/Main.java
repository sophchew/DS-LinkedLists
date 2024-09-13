public class Main {
    public static void main(String[] args) {

        MyLL<String> testLL = new MyLL<String>();
        System.out.println(testLL);
        System.out.println(testLL.size());
       for(int i = 0;  i<10; i++) {
           testLL.add("HI"+ i);
       }

        //System.out.println(testLL.remove("HI0"));
       System.out.println(testLL.remove(-1));
     System.out.println(testLL);




    }
}