import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.*;

/**
* A J Component that will display any image to the screen
* @author Brodin Collins-Robb
*/
public class Picture extends JComponent{

  //store the picture 
  private BufferedImage picture;
  //store the current chord information
  private int[] storeX;
  private int[] storeY;
  private String[] storeS;
  private boolean showScene;
  private Font symbolFont;
  private boolean previousBar;

  /**
  * Method that takes in all the information about a single chord and fills the variables in this class to be used to show the information on the screen!
  * @param the x coordinate value of the dots
  * @param the y coordinate value of the dots
  * @param the symbol that goes inside of the dots
  */
  public void fillChordInfo(int[] tempX, int[] tempY, String[] tempS){
    //create the arrays
    this.storeX = new int[tempY.length];
    this.storeY = new int[tempX.length];
    this.storeS = new String[tempY.length];
    
    for(int z = 0; z < tempY.length; z++){
      this.storeX[z] = tempX[z];
      this.storeY[z] = tempY[z];
      this.storeS[z] = tempS[z];
    }
  }

  /**
  * Method that tells this class to show a chord scene 
  */
  public void showChordScene(){
    this.showScene = true;
  }

  /**
  * displays only the picture in the panel (the chord scene will not show)
  * @param takes in the picture to be displayed 
  */
  public void showPicture(BufferedImage pic){
    this.showScene = false;
    this.picture = pic;
    //redraw the panel
    repaint();
  } 

  /**
  * This is part of how the picture will be shown on screen -note this does not need to be called to run 
  * @param a graphics object
  */
  public void paint(Graphics g){
    g.drawImage(this.picture, 0, 0, this.getWidth(), this.getHeight(), null);
    //create all the dots and symbols to show all the information about a requested chord
    if(this.showScene == true){
      //set the infomration varialbes before displaying every chord
      int iconSize = 12;
      this.previousBar = false;
      Font symbolFont = new Font("arial",Font.BOLD,11);

      //display pin 1 but first check to see if its a bar or a pin
      if(this.storeS[0].equals("b")){
        g.setColor(new Color(255,102,102));
        g.fillOval(this.storeX[0],this.storeY[0],iconSize,(iconSize * 6));
        g.setColor(Color.BLACK);
        g.setFont(symbolFont);
        g.drawString("1",(this.storeX[0]+3),(this.storeY[0]+17));
        this.previousBar = true;
      //it is not a bar so place a pin
      }else{
        g.setColor(new Color(255,102,102));
        g.fillOval(this.storeX[0],this.storeY[0],iconSize,iconSize);
        g.setColor(Color.BLACK);
        g.setFont(symbolFont);
        g.drawString(this.storeS[0],(this.storeX[0]+2),(this.storeY[0]+10));
      }

      //display pin 2 but first check for previous bars to see if any pin/bar is needed
      if(this.storeS[1].equals("b") && this.previousBar == true){
        //dont show anything for the pin
      //double check for a bar and add one where needed 
      }else if(this.storeS[1].equals("b")){
        g.setColor(new Color(51,204,255));
        g.fillOval(this.storeX[1],this.storeY[1],iconSize,(iconSize * 5));
        g.setColor(Color.BLACK);
        g.setFont(symbolFont);
        g.drawString("1",(this.storeX[1]+3),(this.storeY[1]+17));
        this.previousBar = true;
      //it is not a bar so place a pin
      }else{
        g.setColor(new Color(51,204,255));
        g.fillOval(this.storeX[1],this.storeY[1],iconSize,iconSize);
        g.setColor(Color.BLACK);
        g.setFont(symbolFont);
        g.drawString(this.storeS[1],(this.storeX[1]+2),(this.storeY[1]+10));
      }

      //display pin 3 check to see if its a bar if it is place a bar
      if(this.storeS[2].equals("b") && this.previousBar == true){
        //dont show anything for this bar 
      //double check for a bar and add one where needed 
      }else if(this.storeS[2].equals("b")){
        g.setColor(new Color(102,255,102));
        g.fillOval(this.storeX[2],this.storeY[2],iconSize,(iconSize * 4));
        g.setColor(Color.BLACK);
        g.setFont(symbolFont);
        g.drawString("1",(this.storeX[2]+3),(this.storeY[2]+17));
        this.previousBar = true;
      //it is not a bar so place a pin
      }else{
        g.setColor(new Color(102,255,102));
        g.fillOval(this.storeX[2],this.storeY[2],iconSize,iconSize);
        g.setColor(Color.BLACK);
        g.setFont(symbolFont);
        g.drawString(this.storeS[2],(this.storeX[2]+2),(this.storeY[2]+10));
      }

      //display pin 4 check to see if a bar is needed or a pin
      if(this.storeS[3].equals("b") && this.previousBar == true){
        //dont show anything for this pin
      //double check for a bar and add one where needed 
      }else if(this.storeS[3].equals("b") || this.storeS[3].equals("b3") || this.storeS[3].equals("b2")){
        g.setColor(new Color(255,255,0));
        g.fillOval(this.storeX[3],this.storeY[3],iconSize,(iconSize * 3));
        g.setColor(Color.BLACK);
        g.setFont(symbolFont);
        //add this if statement as in this postion there is a bar that requires use of the third finger not the default first 
        if(this.storeS[3].equals("b3")){
          g.drawString("3",(this.storeX[3]+3),(this.storeY[3]+17));
        }else if(this.storeS[3].equals("b2")){
          g.drawString("2",(this.storeX[3]+3),(this.storeY[3]+17));
        }else{
          g.drawString("1",(this.storeX[3]+3),(this.storeY[3]+17));
        }
        this.previousBar = true;
      //it is not a bar so place a pin
      }else{
        g.setColor(new Color(255,255,0));
        g.fillOval(this.storeX[3],this.storeY[3],iconSize,iconSize);
        g.setColor(Color.BLACK);
        g.setFont(symbolFont);
        g.drawString(this.storeS[3],(this.storeX[3]+2),(this.storeY[3]+10));
      }

      //display pin 5 check to see if a bar is needed and place one if needed
      if(this.storeS[4].equals("b") && this.previousBar == true){
        //dont show anything for this pin
      //double check for a bar and add one where needed 
      }else if(this.storeS[4].equals("b") || this.storeS[4].equals("b4") || this.storeS[4].equals("b2")){
        g.setColor(new Color(177,156,217));
        g.fillOval(this.storeX[4],this.storeY[4],iconSize,(iconSize * 2));
        g.setColor(Color.BLACK);
        g.setFont(symbolFont);
        //if statement to use the fourth finger for the bar rather than the default first
        if(this.storeS[4].equals("b4")){
          g.drawString("4",(this.storeX[4]+3),(this.storeY[4]+17));
        }else if(this.storeS[4].equals("b2")){
          g.drawString("2",(this.storeX[4]+3),(this.storeY[4]+17));
        }else{
          g.drawString("1",(this.storeX[4]+3),(this.storeY[4]+17));
        }
        this.previousBar = true;
      //it is not a bar so place a pin
      }else{
        g.setColor(new Color(177,156,217));
        g.fillOval(this.storeX[4],this.storeY[4],iconSize,iconSize);
        g.setColor(Color.BLACK);
        g.setFont(symbolFont);
        g.drawString(this.storeS[4],(this.storeX[4]+2),(this.storeY[4]+10));
      }

      //display pin 6 but see if one is needed before placing anything
      if(this.storeS[5].equals("b") && this.previousBar == true){
        //dont show anything for this pin
      //double check for a bar and show one where needed
      }else if(this.storeS[5].equals("b")){
        g.setColor(new Color(255,127,80));
        g.fillOval(this.storeX[5],this.storeY[5],iconSize,(iconSize));
        g.setColor(Color.BLACK);
        g.setFont(symbolFont);
        g.drawString("1",(this.storeX[5]+3),(this.storeY[5]+17));
        this.previousBar = true;
      //it is not a bar so place a pin
      }else{
        g.setColor(new Color(255,127,80));
        g.fillOval(this.storeX[5],this.storeY[5],iconSize,iconSize);
        g.setColor(Color.BLACK);
        g.setFont(symbolFont);
        g.drawString(this.storeS[5],(this.storeX[5]+2),(this.storeY[5]+10));
      }
    }
  }
}