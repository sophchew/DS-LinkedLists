public class Main {
    public static void main(String[] args) {

        MyLL<String> testLL = new MyLL<String>(true, true);
       System.out.println(testLL);

       for(int i = 0;  i<3; i++) {
           testLL.add("HI"+ i);
       }

        System.out.println(testLL.remove("HI2"));
        System.out.println();


       System.out.println(testLL);






    }
}