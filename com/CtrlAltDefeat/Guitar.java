package com.CtrlAltDefeat;
import java.util.ArrayList;
import java.util.Scanner;

/**
* This represents all the individual chords making up the chord of the guitar 
* @author Brodin Collins-Robb, Owen Garland, Tyler Schiefley and Patryk Zbikowski
*/
public class Guitar implements Aggregate{
  //instance variables
  private ArrayList<Chord> guitarList = new ArrayList<>();

  /**
  * Constructor to make the guitar array storing all of the chords 
  * @param the scanner input
  */
 
  public Guitar(Scanner scanner){
    //create the array with 288 positions for the chords 
	guitarList = new ArrayList<>();
    //create a for loop to fill the array-information from scanner is to be sent to the Chord class 
    for(int i = 0; i < 12; i++){
      Chord c = new Chord(scanner);
      this.guitarList.add(c);
    }
  }
  /**
  * When called it will return the name of chord as well as the index the chord name was found in so that all the information about the chord will be with the chord name 
  * @param the name of the chord
  */
  public Chord getName(String chordName){
    //Start a loop to cycle through all the indexes in search of the requested chord
	//iterator design pattern
	  Iterator gutiarIterator = createIterator();
    while(gutiarIterator.hasNext()) {
      
    	Chord currentChord = (Chord)gutiarIterator.next();
    	
      if((currentChord.getName()).equals(chordName)){
    	  
        return currentChord;
        
      }
    } 
    //return statement to skip errors (only will run if no name is found but all names will be pre-entered so this line should never run)
    return this.guitarList.get(1);
  }
@Override
public Iterator createIterator() {
	// TODO Auto-generated method stub
	
	return new GuitarIterator(this);
} 

public ArrayList<Chord> getChords(){
	return this.guitarList;
}

}