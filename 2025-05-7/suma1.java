public class suma1{
    public static void main(String[] args){
        int a;
        int b;
        System.out.println("dame el valor a");
        String inputA=System.console().readLine();
        a=Integer.parseInt(inputA);

        System.out.println("dame el valor b");
        String inputB=System.console().readLine();
        b=Integer.parseInt(inputB);

        System.out.println("la suma es:"+(a+b));
    }
}
