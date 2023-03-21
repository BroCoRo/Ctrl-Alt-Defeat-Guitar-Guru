package com.CtrlAltDefeat;
import java.util.Scanner;

/**
* This is a chord class, this represents a chord storing information about a particular chord on the guitar like how to play the chord, what the chord sounds like, the name of the chord etc.
* @author Brodin Collins-Robb, Owen Garland, Tyler Schiefley and Patryk Zbikowski
*/
public class Chord{
  //instance variables
  private String name;
  private Scene[] scene;

  /**
  * this is the constructor for the chord, this takes in the information from the scanner and starts filling in information about a chord 
  * @param the text being fed in from the scanner 
  */
  public Chord(Scanner information){
    this.name = information.nextLine();
    scene = new Scene[24];
    for(int i = 0; i < scene.length; i++){
      scene[i] = new Scene(information);
    }
  }

  /**
  * Getter method for finding chords
  * @return the name of the requested chord variation
  */
  public String getName(){
    return this.name;
  }

  /**
  * Get the chord information from a specified variation of the pre-determined general chord
  * @param the chord variation needed to be displayed
  * @return the information in the specified scene matching the requested chord variation
  */
  public Scene getVariation(String variationName){
    //create a variable to store the index to return as you cannot return a value inside a switch case
    int variationIndex;
    //start a switch case to find a specific variation of a chord 
    variationIndex = variationSwitchCase(variationName);
    return scene[variationIndex];
  }

private int variationSwitchCase(String variationName) {
	int variationIndex;
	switch(variationName){
      case "M":
        variationIndex = 0;
        break;
      case "min":
        variationIndex = 1;
        break;
      case "Aug":
        variationIndex = 2;
        break;
      case "Sus2":
        variationIndex = 3;
        break;
      case "Sus4":
        variationIndex = 4;
        break;
      case "5":
        variationIndex = 5;
        break;
      case "6":
        variationIndex = 6;
        break;
      case "7":
        variationIndex = 7;
        break;
      case "maj7":
        variationIndex = 8;
        break;
      case "7sus4":
        variationIndex = 9;
        break;
      case "9":
        variationIndex = 10;
        break;
      case "add9":
        variationIndex = 11;
        break;
      case "m6":
        variationIndex = 12;
        break;
      case "m7":
        variationIndex = 13;
        break;
      case "m7♭5":
        variationIndex = 14;
        break;
      case "m9":
        variationIndex = 15;
        break;
      case "11":
        variationIndex = 16;
        break;
      case "13":
        variationIndex = 17;
        break;
      case "9♭":
        variationIndex = 18;
        break;
      case "9♯":
        variationIndex = 19;
        break;
      case "13♭":
        variationIndex = 20;
        break;
      case "7dim":
        variationIndex = 21;
        break;
      case "7♭5":
        variationIndex = 22;
        break;
      case "Dim":
        variationIndex = 23;
        break;
      default:
        variationIndex = 0;
        break;
    }
	return variationIndex;
}
}