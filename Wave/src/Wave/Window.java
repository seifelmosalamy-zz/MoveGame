/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wave;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;


 
 // @author seifelmosalamy
 
public class Window extends Canvas
{
	private static final long serialVersionUID = 7975347679563590512L;

public Window (  int width , int height , String title , Game game )
{
    JFrame frame = new JFrame(title);
    frame.setPreferredSize(new Dimension (width , height));
    frame.setMaximumSize(new Dimension (width , height ));
    frame.setMinimumSize(new Dimension (width, height));
    //make the game close when clicking on close or the threads will keep running 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    frame.setLocationRelativeTo(null);
    frame.add(game);      
    frame.setVisible(true); // to see the game 
    game.start();
        
       
       }    
        
        
        
        
        }
