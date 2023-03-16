import java.util.Scanner;

/**
* This class stores all the information about each chord variation in variables 
* @author Brodin Collins-Robb
*/
public class Scene{
  //instance variables 
  private String variationName;
  private String audioFileName;
  private int[] xCoordinates;
  private int[] yCoordinates;
  private String[] playString;

  /**
  * Constructor builds everything to make the call usable
  * @param the line of text fed from the scanner assigned to the index of the chord variation array
  */
  public Scene(Scanner information){
    //setup the arrays
    xCoordinates = new int[6];
    yCoordinates = new int[6];
    playString = new String[6];
    //fill all the variables with the correct information from the scanner 
    this.variationName = information.next();
    this.audioFileName = information.next();
    for(int x = 0; x < xCoordinates.length; x++){
      this.xCoordinates[x] = Integer.parseInt(information.next());
      this.yCoordinates[x] = Integer.parseInt(information.next());
      this.playString[x] = information.next();
    }
    information.nextLine();
  }

  /**
  * Getter method to get the name of the chord variation 
  * @return the variation of the chord 
  */
  public String getVariationName(){
    return this.variationName;
  }

  /**
  * Getter method to get the audio file name
  * @return the audio file name
  */
  public String getAudioName(){
    return this.audioFileName;
  }

  /**
  * Getter method that will return the x coordinates
  * @return an array full of all the x coordinates 
  */
  public int[] getXValues(){
    return xCoordinates;
  }

  /**
  * Getter method that will return the y coordinates
  * @return an array full of all the y coordinates 
  */
  public int[] getYValues(){
    return yCoordinates;
  }

  /**
  * Getter method that will return the symbols
  * @return an array full of all the symbols 
  */
  public String[] getSymbols(){
    return playString;
  }
}