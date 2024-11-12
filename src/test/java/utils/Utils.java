package utils;

public class Utils {

    public static void sleep(int time){
        try{
            Thread.sleep(time);
        } catch (Exception ex){
            System.out.printf(ex.getMessage());

        }
    }
}
