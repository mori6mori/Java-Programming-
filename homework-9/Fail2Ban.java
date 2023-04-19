
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Fail2Ban{
    public static void main (String[] args) throws FileNotFoundException{
        File f = new File (args[0]);
        Scanner input = new Scanner (f);
        PrintWriter output = new PrintWriter(args[1]);
        ArrayList<String> ips = new ArrayList<String>();
        ArrayList<Integer> counts = new ArrayList<Integer>();  
        ArrayList<String> countedIps = new ArrayList<String>(); 
        int i = 0;
        int count = 0;
        while (input.hasNextLine()){
        
            String line = input.nextLine();
        
            String[] words = line.split(" ");
       
            if (words[5].equals("Invalid")){
            
                String invalidIp = words[9];
                ips.add(i, invalidIp);

            }
       
        }
        input.close();
        
        counts = frequency(ips);
    
        for (String a : ips){
            if (!a.equals("counted")){
                countedIps.add(a);
            }
        }


        for (int a = 0; a < counts.size(); a++){
            if (counts.get(a) > 2){
                //System.out.println( countedIps.get(a) + " counts: " + counts.get(a)); 
                output.printf("ip: %s\n", countedIps.get(a));
            }
               
        }
        output.close();

    }
    //this method takes in an arraylist of Strings (invalid ip addresses) and returns an arraylist of integers
    public static ArrayList<Integer> frequency(ArrayList<String> array){
        int count = 0;
        ArrayList<Integer> counts = new ArrayList<Integer>();
        
        for (int i = 0; i < array.size(); i++){
            if(!array.get(i).equals("counted")){
               count = 0; 
               for (int n = i+1; n < array.size(); n++){
                    if (array.get(i).equals(array.get(n))){
                        count ++;
                        array.set(n, "counted");
                    }
               } 
               counts.add(count+1);
            }
        }
        
        return counts;
    }
}