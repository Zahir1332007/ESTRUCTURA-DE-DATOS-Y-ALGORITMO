public class ejemplo02 {
    public static void main(String arg[]){
        int n=7;
        int op = n<<3;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(op));
        int a=5;
        int b=6;
        System.out.println((a==b)?a:b);

        if(a==b){
            System.out.println(a);
        }else{
            System.out.println(b);
        }
    } 
}
/*nnotacion polaca 
a+b-c*4 ans-> answer  return 
*c4+ansb+ansc
recibir un string que contine operaciones matematicas 
y dar resultado string operacion ="a+b-c*4" 
a=1
b=3
c=3

1+2-3*4    
1+2-12*/