import java.util.Scanner;
import java.io.File;

/**
* This represents all the individual chords making up the chord of the guitar 
* @author OWen Garland
*/
public class ChordList{
  //instance variables
  private Chord[] guitar;

  /**
  * Constructor to make the guitar array storing all of the chords 
  * @param the scanner input
  */
  public ChordList(Scanner scanner){
    //create the array with 288 postions for the chords 
    this.guitar = new Chord[12];
    //create a for loop to fill the array-information from scanner is to be sent to the Chord class 
    for(int i = 0; i < 12; i++){
      Chord c = new Chord(scanner);
      this.guitar[i] = c;
    }
  }
  /**
  * When called it will return the name of chord as well as the index the chord name was found in so that all the information about the chord will be with the chord name 
  * @param the name of the chord
  * @return the index in which the chord is being stored 
  */
  public Chord getName(String chordName){
    //Start a for loop to cycle through all the indexes in search of the requested chord
    for(int x = 0; x<guitar.length; x++){
      //has the chord been found?
      if((this.guitar[x].getName()).equals(chordName)){
        return this.guitar[x];
      }
    } 
    //return statement to skip errors (only will run if no name is found but all names will be pre-entered so this line should never run)
    return this.guitar[0];
  } 

}