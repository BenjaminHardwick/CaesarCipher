// Benjamin Hardwick
// 201385730
// sgbhardw@liverpool.ac.uk
public class BreakCaesar {

    public static void main (String args[]) {
        if (args.length > 1)
            endEarly("Too many parameters!");
        if (args.length < 1)
            endEarly("Too few parameters!");
 
        Caesar C = new Caesar();
        String cipherText = args[0];
        System.out.println(C.decipher(cipherText));
    } 
 
    /** print message and usage help and terminate unsuccessfully */
    public static void endEarly(String message){
        System.out.println(message);
        System.err.println("Usage: java BreakCaesar \"cipher text\"");
        System.exit(-1);
    }
 }
 