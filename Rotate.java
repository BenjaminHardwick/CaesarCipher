import java.util.*;
/**
* <p><b>STUDENT NAME:</b> Benjamin Hardwick</p>
* <p><b>STUDENT ID:</b> 201385730</p>
* <p><b>STUDENT EMAIL:</b> sgbhardw@liverpool.ac.uk</p>
*
*
*
* @author Benjamin Hardwick 2019
* @version Assignment 2
*/

public class Rotate{

/** <b>Creating a new caesar</b> which will then be used to implement the arguments.
* Below displays the use of the arguments and how they are put into the variables.
* @param args is what the user will input, the arguments... Essenstially, when the cmd prompt is opened, and the user runs
* the program under 'java Rotate', they will then input their arguments... <b>Example: 'java Rotate 3 "Hello World"'.</b>
* the args will then detect the arguments inputted, and it works like so <b>'java Rotate x amount of shifts... Y for the string.'</b>
* Therefore when the program is getting the arguments, it will parse the integer, and the text can just be declared.
* Also, you can see the Caesar is called this is instead of making Rotate extend Caesar. Just an alternative.
* I then pass the parameters onto the Caesar.java to then produce the encrypted message.
*/
public static void main (String args[]){
    Caesar C = new Caesar();
    try{
        if (args.length > 2)
            endEarly("Too many parameters!");
        if (args.length < 2)
            endEarly("Too few parameters!");

        String text = args[1];
        int shift = Integer.parseInt(args[0]);
        System.out.println(C.rotate(text, shift));
    }
    catch (NumberFormatException e) {
        endEarly("Could not parse first parameter (shift) as int");
    }

}

/** print message and usage help and terminate unsuccessfully */
public static void endEarly(String message){
    System.out.println(message);
    System.out.println("Usage: java Rotate *integer* \"cipher text\"");
    System.exit(-1);
}
}
