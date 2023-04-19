
public class Zipcode {
   

        private int zip;
        private String bar;
        private String zipString = ""; 
        private String zipString2= "";
    
       //overloading zipcode constructor @param int zip or string bar
        public Zipcode (int z){
            this.zip = z;
        }

        public Zipcode (String b){
            this.bar = b; 
        }

        public String getBarcode() {
            if((zip<01001)||(zip>99950)) {
                System.out.println("FORMAT ERROR: The ZIP code must be between 01001 and 99950");
            }
            //check how many digit 
        
            
            //converting zipcode integer into string 
            String zipString = Integer.toString(zip);
            // check length of the zipcode     
            if (zipString.length() != 5){
                System.out.println ("FORMAT ERROR: incorrect length of zipcode.The zipcode must be 5 numbers long");
            }
            
            //add checkDigit
            int checkDigit = getCheck(zip);
            String check = Integer.toString(checkDigit);
            zipString += check;


            for (int i = 0; i < zipString.length(); i++){
                char zChar = zipString.charAt(i);
                String zipChar = String.valueOf(zChar);     
                    if (zipChar.equals("1")){
                        zipString2 = zipString2 + ":::||";
                    }else if (zipChar.equals("2")){
                        zipString2 = zipString2 + "::|:|";
                    }else if (zipChar.equals("3")){
                        zipString2 = zipString2 + "::||:";
                    }else if (zipChar.equals("4")){
                        zipString2 = zipString2 + ":|::|"; 
                    }else if (zipChar.equals("5")){
                        zipString2 = zipString2 + ":|:|:";
                    }else if (zipChar.equals("6")){
                        zipString2 = zipString2 + ":||::";
                    }else if (zipChar.equals("7")){
                        zipString2 = zipString2 + "|:::|";
                    }else if (zipChar.equals("8")){
                        zipString2 = zipString2 + "|::|:";
                    }else if (zipChar.equals("9")){
                        zipString2 = zipString2 + "|:|::";
                    }else if (zipChar.equals("0")){
                        zipString2 = zipString2 + "||:::";
                    }
            }

            return "|" + zipString2 +"|" ;
        }

        public String getZIPcode(){
            String bar1 = bar.substring(1,6);
            String bar2 = bar.substring(6,11); 
            String bar3 = bar.substring(11,16);
            String bar4 = bar.substring(16,21);
            String bar5 = bar.substring(21,26);
            String bar6 = bar.substring(26,31);
            
            //find frame bars
            char b1 = bar.charAt(0);
            char b2 = bar.charAt(bar.length()-1);
            String frame1 = String.valueOf(b1); 
            String frame2 = String.valueOf(b2);

            //check frame bars
            if (frame1.equals("|") && frame2.equals("|")){
                System.out.println("Correct framebars!");
            }else{
                System.out.println("Error in framebars");
            }
           
            String[] bars = {bar1, bar2, bar3, bar4, bar5, bar6};
            for (int i = 0; i<bars.length; i++){
                if (bars[i].equals (":::||")){
                    zipString = zipString + "1";
                }else if (bars[i].equals("::|:|")){
                    zipString = zipString + "2";
                }else if (bars[i].equals("::||:")){
                    zipString = zipString + "3";
                }else if (bars[i].equals(":|::|")){
                    zipString = zipString + "4";
                }else if (bars[i].equals(":|:|:")){
                    zipString = zipString + "5";
                }else if (bars[i].equals(":||::")){
                    zipString = zipString + "6";
                }else if (bars[i].equals("|:::|")){
                    zipString = zipString + "7";
                }else if (bars[i].equals("|::|:")){
                    zipString = zipString + "8";
                }else if (bars[i].equals("|:|::")){
                    zipString = zipString + "9";
                }else if (bars[i].equals("||:::")){
                    zipString = zipString + "0";
                } 
            }
            //check checkDigit
            zipString2 = zipString.substring(0,5);
            int z=Integer.parseInt(zipString2);  
            int checkDigit = getCheck(z);
            String check = Integer.toString(checkDigit);

            char c = zipString.charAt(zipString.length()-1);
            String cDigit = String.valueOf(c); 

            if(check.equals(cDigit)){
                System.out.println ("The value of the check digit is: " + check);
            }else{
                System.out.println ("Error in checkDigit");
            }

            //return only the first 5 digits which is the zipcode
            return zipString2;
        }
    public static int getCheck(int zip) {
        int remaining = zip;
        int sum = 0;
        while (remaining > 0) {
            sum += remaining % 10;
            remaining /= 10;
        }
        return 10 - (sum % 10);
    }
}
   