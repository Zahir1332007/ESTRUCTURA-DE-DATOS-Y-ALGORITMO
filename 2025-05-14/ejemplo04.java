
import java.util.Calendar;


class ejemplo04{
    public static void  main(String[] args){
        Calendar cal=Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        int dia=cal.get(Calendar.DAY_OF_WEEK);

        System.out.println("hoy dia es :"+dia);

        for(int i=1;i<=7; i++){
            if(dia==1){
                
            }else{
                System.out.println("dia" +i);
            }
        }
        System.out.println("fuera del for");
    }
}