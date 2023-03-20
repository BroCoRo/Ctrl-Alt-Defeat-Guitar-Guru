package com.CtrlAltDefeat;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

/**
* Stores the background images 
* @author Brodin Collins-Robb
*/
public class Background{

  //instance variables
  private BufferedImage optionOne;
  private BufferedImage optionTwo;

  /**
  * constructor that will load in the two images 
  */
  public Background(){
    String imageNameOne = "Title_Photo.jpg";
    String imageNameTwo = "Fretboard_Photo.jpg";
    try{
      this.optionOne = ImageIO.read(new File("Images/" + imageNameOne));
    }catch(Exception e){
      System.out.println("Images/" + imageNameOne);
      e.printStackTrace();
    }
    try{
      this.optionTwo = ImageIO.read(new File("Images/" + imageNameTwo));
    }catch(Exception e){
      System.out.println("Images/" + imageNameTwo);
      e.printStackTrace();
    }
  }
  /**
  * A method that when called will return the buffered image selected 
  * @param the image number requested
  * @return the image matching the number requested
  */
  public BufferedImage getPicture(String number){
    String iNumber = number;
    if(iNumber.equals("one")){
     return this.optionOne;
    }else{
     return this.optionTwo;
    }
  }
}