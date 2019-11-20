
/**Benjamin Hardwick
* 201385730
* sgbhardw@liverpool.ac.uk
* Implementing the Caesar Cipher method.
* @author Benjamin Hardwick 2019
* @version Assignment 2
*/

/**
* This is where the constructor class for <b>Caesar</b> begins, and it will
* take the alphabet(string) and will shift(integer) it with the text given from the Rotate.java.
* As you can see below, if the shift is greater than 26, it will run the operator.
* If the shift is within 26, it will run the shift's operator(%) and will add 26.
* hence beginning the <i>Caesar Cipher.</i>
**/

public class Caesar implements RotationCipher {

  /** English letter frequencies */
  static final double[] ENGLISH_FREQUENCIES = {
      0.0855, 0.0160, 0.0316, 0.0387, 0.1210,
      0.0218, 0.0209, 0.0496, 0.0733, 0.0022,
      0.0081, 0.0421, 0.0253, 0.0717, 0.0747,
      0.0207, 0.0010, 0.0633, 0.0673, 0.0894,
      0.0268, 0.0106, 0.0183, 0.0019, 0.0172,
      0.0011
  }; 

  public String rotate(String text, int shift){
      // java's modulo operator can return negative values.
      // the following line ensures that 0 ≤ shift < 26
      shift = (shift % 26 + 26) % 26;

      String result = "";
      
      for (int i = 0; i < text.length(); i++)  {

         char c = text.charAt(i);  // get the i^th character

         // if not a character [a-z] or [A-Z], keep it as is
         if (!Character.isLetter(c)) {
             result += c;
         }
         // otherwise, translate according to shift
         else {
             char base = Character.isLowerCase(c) ? 'a' : 'A';
             result += (char) ((((c - base) + shift) % 26) + base);
         }
      }
      return result;
  } 

  
  public String decipher(String s){
    
    // this will be bigger (= worse) than all possible chi^2 values and therefore replaced in the first iteration
    double bestChi = Double.POSITIVE_INFINITY;  
    String bestGuess = s;

    for (int i=0; i < ENGLISH_FREQUENCIES.length; i++) {
        // rotate s by shift i
        String r = rotate(s, i);

        // compute letter frequencies
        double[] freqs = frequencies(r); 

        double chi = chiSquared(freqs, ENGLISH_FREQUENCIES);
        if (bestChi > chi) {
            bestChi = chi;
            bestGuess = r;
        }
        
        // debugging only
        // System.out.println(i +": " +r + " :" +chi + " (best: " + bestChi + ")");
    }
    return bestGuess;
  }

  public double[] frequencies(String s){
      
      int[] charCount = new int[26];
      int totalChars = 0;
      double[] freq = new double[26];

      // initialize character counts to zero
      for (int i = 0; i < freq.length; i++)  {
         charCount[i] = 0;
      }
  
      //  For purposes of calculating letter frequencies
      //  we will convert everything to lower case.  
      s = s.toLowerCase();

      // iterate through s and increment counts as seen
      for (int i = 0; i < s.length(); i++)  {
          char c = s.charAt(i);         
          if (Character.isLetter(c)){ 
              charCount[c - 'a'] += 1; 
              totalChars++;            
         }
      }

      // compute and return frequencies
      for (int i = 0; i < freq.length; i++){
         freq[i] = (double)charCount[i]/totalChars;
      }

      return freq;
  }

  public double chiSquared(double[] a, double[] b){
      double sum = 0.0;
      
      for (int i = 0; i < a.length; i++)  {
          sum += Math.pow((a[i] - b[i]), 2) / b[i];
      }
      return sum;
  }
}
