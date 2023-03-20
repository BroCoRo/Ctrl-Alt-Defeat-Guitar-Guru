package com.CtrlAltDefeat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.Clip;

/**
* Create a mainscreen that will display everything that happens in the app
* @author Brodin Collins-Robb
*/
public class MainScreen extends JFrame implements ActionListener{
  //instance variables 
  private Picture picture;
  private Background Backgrounds;
  private Guitar chordList;
  private String mainChord;
  private String variationType;
  //create a jpanel with borderlayout manager 
  JPanel mainPanel = new JPanel(new BorderLayout());
  /**
  * Constructor sets up JFrame and JPanel and adds a combobox containing all 288 chord options
  */
  public MainScreen(){
    //set the size of the Jframe
    this.setSize(1212,595);

    //create the picture 
    this.picture = new Picture();
    //add the picture to the screen
    mainPanel.add(this.picture, BorderLayout.CENTER);
    //create the background to select which image to show later on
    this.Backgrounds = new Background();

    //set the image to start on the title image
    BufferedImage visuals = this.Backgrounds.getPicture("one");
    this.picture.showPicture(visuals);

    //create a combobox to select the chord
    String[] choices = {
      "A M","A min","A Aug","A Sus2","A Sus4","A 5","A 6","A 7","A maj7","A 7sus4","A 9","A add9","A m6","A m7","A m7♭5","A m9","A 11","A 13","A 9♭","A 9♯","A 13♭","A 7dim","A 7♭5","A Dim",

      "A♯/B♭ M","A♯/B♭ min","A♯/B♭ Aug","A♯/B♭ Sus2","A♯/B♭ Sus4","A♯/B♭ 5","A♯/B♭ 6","A♯/B♭ 7","A♯/B♭ maj7","A♯/B♭ 7sus4","A♯/B♭ 9","A♯/B♭ add9","A♯/B♭ m6","A♯/B♭ m7","A♯/B♭ m7♭5","A♯/B♭ m9","A♯/B♭ 11","A♯/B♭ 13","A♯/B♭ 9♭","A♯/B♭ 9♯","A♯/B♭ 13♭","A♯/B♭ 7dim","A♯/B♭ 7♭5","A♯/B♭ Dim",

      "B M","B min","B Aug","B Sus2","B Sus4","B 5","B 6","B 7","B maj7","B 7sus4","B 9","B add9","B m6","B m7","B m7♭5","B m9","B 11","B 13","B 9♭","B 9♯","B 13♭","B 7dim","B 7♭5","B Dim",

      "C M","C min","C Aug","C Sus2","C Sus4","C 5","C 6","C 7","C maj7","C 7sus4","C 9","C add9","C m6","C m7","C m7♭5","C m9","C 11","C 13","C 9♭","C 9♯","C 13♭","C 7dim","C 7♭5","C Dim",

      "C♯/D♭ M","C♯/D♭ min","C♯/D♭ Aug","C♯/D♭ Sus2","C♯/D♭ Sus4","C♯/D♭ 5","C♯/D♭ 6","C♯/D♭ 7","C♯/D♭ maj7","C♯/D♭ 7sus4","C♯/D♭ 9","C♯/D♭ add9","C♯/D♭ m6","C♯/D♭ m7","C♯/D♭ m7♭5","C♯/D♭ m9","C♯/D♭ 11","C♯/D♭ 13","C♯/D♭ 9♭","C♯/D♭ 9♯","C♯/D♭ 13♭","C♯/D♭ 7dim","C♯/D♭ 7♭5","C♯/D♭ Dim",

      "D M","D min","D Aug","D Sus2","D Sus4","D 5","D 6","D 7","D maj7","D 7sus4","D 9","D add9","D m6","D m7","D m7♭5","D m9","D 11","D 13","D 9♭","D 9♯","D 13♭","D 7dim","D 7♭5","D Dim",

      "D♯/E♭ M","D♯/E♭ min","D♯/E♭ Aug","D♯/E♭ Sus2","D♯/E♭ Sus4","D♯/E♭ 5","D♯/E♭ 6","D♯/E♭ 7","D♯/E♭ maj7","D♯/E♭ 7sus4","D♯/E♭ 9","D♯/E♭ add9","D♯/E♭ m6","D♯/E♭ m7","D♯/E♭ m7♭5","D♯/E♭ m9","D♯/E♭ 11","D♯/E♭ 13","D♯/E♭ 9♭","D♯/E♭ 9♯","D♯/E♭ 13♭","D♯/E♭ 7dim","D♯/E♭ 7♭5","D♯/E♭ Dim",

      "E M","E min","E Aug","E Sus2","E Sus4","E 5","E 6","E 7","E maj7","E 7sus4","E 9","E add9","E m6","E m7","E m7♭5","E m9","E 11","E 13","E 9♭","E 9♯","E 13♭","E 7dim","E 7♭5","E Dim",

      "F M","F min","F Aug","F Sus2","F Sus4","F 5","F 6","F 7","F maj7","F 7sus4","F 9","F add9","F m6","F m7","F m7♭5","F m9","F 11","F 13","F 9♭","F 9♯","F 13♭","F 7dim","F 7♭5","F Dim",

      "F♯/G♭ M","F♯/G♭ min","F♯/G♭ Aug","F♯/G♭ Sus2","F♯/G♭ Sus4","F♯/G♭ 5","F♯/G♭ 6","F♯/G♭ 7","F♯/G♭ maj7","F♯/G♭ 7sus4","F♯/G♭ 9","F♯/G♭ add9","F♯/G♭ m6","F♯/G♭ m7","F♯/G♭ m7♭5","F♯/G♭ m9","F♯/G♭ 11","F♯/G♭ 13","F♯/G♭ 9♭","F♯/G♭ 9♯","F♯/G♭ 13♭","F♯/G♭ 7dim","F♯/G♭ 7♭5","F♯/G♭ Dim",

      "G M","G min","G Aug","G Sus2","G Sus4","G 5","G 6","G 7","G maj7","G 7sus4","G 9","G add9","G m6","G m7","G m7♭5","G m9","G 11","G 13","G 9♭","G 9♯","G 13♭","G 7dim","G 7♭5","G Dim",

      "G♯/A♭ M","G♯/A♭ min","G♯/A♭ Aug","G♯/A♭ Sus2","G♯/A♭ Sus4","G♯/A♭ 5","G♯/A♭ 6","G♯/A♭ 7","G♯/A♭ maj7","G♯/A♭ 7sus4","G♯/A♭ 9","G♯/A♭ add9","G♯/A♭ m6","G♯/A♭ m7","G♯/A♭ m7♭5","G♯/A♭ m9","G♯/A♭ 11","G♯/A♭ 13","G♯/A♭ 9♭","G♯/A♭ 9♯","G♯/A♭ 13♭","G♯/A♭ 7dim","G♯/A♭ 7♭5","G♯/A♭ Dim",
      };
    
    JComboBox cb = new JComboBox(choices);
    //add an action listener 
    cb.addActionListener(this);
    //add the comboboxs to the panel
    mainPanel.add(cb, BorderLayout.SOUTH);

    //make the x close the application
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    //add the panel to the main MainScreen
    this.add(mainPanel);
    //make the frame visible
    this.setVisible(true);

    //create a new scanner 
    Scanner information = null;
    try{
      information = new Scanner(new File("chords.txt"));
      //create the guitar (a collection of all the chords)
      this.chordList = new Guitar(information);
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  /**
  * This is a method that runs after the user has selected a chord from the selection menu
  * @param the action event that is formed when the user clicks an option from the selection menu
  */
  public void actionPerformed(ActionEvent e){
    JComboBox cb = (JComboBox)e.getSource();
    String selectedChord = (String)cb.getSelectedItem();
    try {
		updateScreen(selectedChord);
	} catch (UnsupportedAudioFileException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (LineUnavailableException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} 
  }

  //Store only one instance of the file so that the action listener can play more than one chord audio clip
  File soundFile = null;
  
  /**
  * This is a method that when called will update the screen once the user has selected a chord, this method calls the picture class and will display the fretboard photo as well as the updated information about the chord
  * @param the specific chord with its variation that the user has selected
  * @throws IOException 
  * @throws UnsupportedAudioFileException 
  * @throws LineUnavailableException 
  */
  public void updateScreen(String showSelectedChord) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
    //update the image to show the second image and the chord information
    BufferedImage visuals = this.Backgrounds.getPicture("two");
    this.picture.showPicture(visuals);
    
    JButton audioButton = new JButton("Strum");
    audioButton.setContentAreaFilled(false);
	String tempFixedName = showSelectedChord;

    chordNameEdgeCaseChecker(tempFixedName);
    
	//add an action listener 
    audioButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            Clip clip;
			try {
	        	AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
				clip = AudioSystem.getClip();
				clip.loop(Clip.LOOP_CONTINUOUSLY); // set loop to true
				clip.open(audioStream);
				clip.start();
			} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
        }
    });
    //add the button to the panel
    mainPanel.add(audioButton, BorderLayout.WEST);

    //make the x close the application
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    //add the panel to the main MainScreen
    this.add(mainPanel);
    //make the frame visible
    this.setVisible(true);

    
    //take only the first part of the chord requested to start finding the chord in the programs index's
    if(showSelectedChord.contains(" ")){
      String[] chordType = showSelectedChord.split(" ");
      this.mainChord = chordType[0];
      this.variationType = chordType[1];
    }

    //access the specified chord type and variation and send the correct information from the scanner to the picture class to be displayed
    Chord currentGeneralChord = this.chordList.getName(mainChord);
    Scene currentChordVariation = currentGeneralChord.getVariation(variationType);
    this.picture.fillChordInfo(currentChordVariation.getXValues(),currentChordVariation.getYValues(),currentChordVariation.getSymbols());
    this.picture.showChordScene();

  }

private void chordNameEdgeCaseChecker(String tempFixedName) {
	//sound files cannot include a flat symbol so check for this character and replace it where needed
    if(tempFixedName.indexOf('♭') == -1)
    {
    	soundFile = new File("Sounds/" + tempFixedName + ".wav");
    }
    else 
    {
    	tempFixedName = tempFixedName.replace('♭', 'b');
    	soundFile = new File("Sounds/" + tempFixedName + ".wav");
	}
    //sound files cannot include a / symbol so check for this character and replace it where needed
    if(tempFixedName.indexOf('/') == -1)
    {
    	soundFile = new File("Sounds/" + tempFixedName + ".wav");
    }
    else 
    {
    	tempFixedName = tempFixedName.replace('/', '-');
    	soundFile = new File("Sounds/" + tempFixedName + ".wav");
	}
    //sound files cannot include a ♯ symbol so check for this character and replace it where needed
    if(tempFixedName.indexOf('♯') == -1)
    {
    	soundFile = new File("Sounds/" + tempFixedName + ".wav");
    }
    else 
    {
    	tempFixedName = tempFixedName.replace('♯', '#');
    	soundFile = new File("Sounds/" + tempFixedName + ".wav");
	}
}
}