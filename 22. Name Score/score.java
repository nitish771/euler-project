/*
First compile - javac Helper.java
then run this file
*/
public class score{
    public static void main(String[] args) {
        String file_name = "PE_names.txt";
        
        Helper hp = new Helper(file_name);
        hp.sortFile();
        System.out.println("Total Score : " + hp.countScore());
    }
}