import java.util.*;

public class counting_sundays{
    public static void main(String args[]){
		System.out.println(getSundaysCount());
	}

    private static Integer getSundaysCount(){
        Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
        Integer count = 0;

        c1.set(1901, 1, 1);
        c2.set(2000, 12, 31);
    
        while(c1.compareTo(c2) == -1 ){
            if(c1.get(Calendar.DAY_OF_WEEK) == 1){
                count++;
                // System.out.println("C1 : " + c1.getTime() + " |  count : " + count);
            }
            c1.add(Calendar.MONTH, 1);
        }
        return count;
    }
}