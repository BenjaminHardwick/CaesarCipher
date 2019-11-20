/**
* <p><b>STUDENT NAME:</b> Benjamin Hardwick</p>
* <p><b>STUDENT ID:</b> 201385730</p>
* <p><b>STUDENT EMAIL:</b> sgbhardw@liverpool.ac.uk</p>
*
* Here I created the interface for the needed classes, this defines the classes and methods.
* 
*
* @author Benjamin Hardwick 2019
* @version Assignment 2
*/

public interface RotationCipher{
  
  public String rotate(String s, int n);
  public String decipher(String s);
  public double[] frequencies(String s);
  public double chiSquared(double[] a, double[] b);

}
