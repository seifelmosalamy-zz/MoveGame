/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wave;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class Game extends Canvas implements Runnable 

{
	public static int  ctr = 0 ; 
	
public static final int WIDTH = 640 , HEIGHT  = WIDTH /12*9;
    private Thread thread ; 
    private boolean running = false ;
    private Handler handler ; 
    private Random r ; 
    private HUD hud ; 
    private Spawn spawnner ; 
     
    public Game ()
    {
    	System.out.println(ctr);
    		handler = new Handler();
    		this.addKeyListener(new KeyInput(handler));
    
    		new Window (WIDTH , HEIGHT , "let's start our game " , this );
          hud = new HUD();
          spawnner = new Spawn (handler , hud );
          r= new Random();
    
      
 handler.addObject(new Player(WIDTH/2-32,HEIGHT / 2-32, ID.Player,handler));

 handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH) , r.nextInt(Game.HEIGHT), ID.BasicEnemy , handler)); 
    
    
    }
    
    public synchronized void start()
    {
    	//starting thread
    	

    	thread = new Thread (this);
    	thread.start();
    	running = true ; 
    }
    
    public  synchronized void stop ()
    {
    		try {
    			thread.join(); // killing the thread 
    			running = false ; 
    		}catch(Exception e )
    		{
    			e.printStackTrace();
    		}
    }
    public void run ()
    {
    	this.requestFocus(); // to make the selection automated to the game 
       //Game loop to update it self 
    	 long lastTime = System.nanoTime(); //amount taken to get into (running)
    	 double amountOfTicks = 60.0 ; 
    	 double  ns  = 1000000000 / amountOfTicks;
    	 double delta = 0 ; //catch the time 
    	 long timer = System.currentTimeMillis();
    	 int frames =0 ; 
    	 while ( running)
    	 {
    		 
    		 
    		 long now = System.nanoTime();
    		 delta += (now - lastTime) / ns ;
    		 lastTime = now ;
    		 while(delta >= 1 )
    		 {
    			 tick(); 	
    			
    		delta-- ;
    			 
    		 }
    		 
    		 if (running)
    		
    			  render();
    		 frames ++ ; 
    		 
    		
    		    	if ( System.currentTimeMillis() - timer > 1000)
    	{
    		timer += 1000 ; 
    		System.out.println("FPS : " + frames  );
    		frames = 0 ; 
    	}
    	 }
    	 stop ();
    }
   

	private void tick () {
		
		handler.tick();
    		hud.tick();
    		spawnner.tick();
    	 
    		
    }
    
    private void render()
    {
    	this.requestFocus();
    		BufferStrategy bs = this.getBufferStrategy();
    		if (bs == null )
    		{
    			this.createBufferStrategy(3);
    			return ; 
    		}
    			
    		Graphics g = bs.getDrawGraphics();
    		g.setColor(Color.black);
    		g.fillRect(0, 0, WIDTH, HEIGHT);
    		handler.render(g); 
    		hud.render(g);
    		g.dispose();
    		bs.show();
    }
    public static  float clamp (float var , float min , float max )
    {
    		if(var >= max )
    		{
    			return var = max  ;
    		}
    		else if ( var <= min)
    			return var = min ; 
    		else return var ; 
    }
    
    public static void main (String args[])
    {
    	new Game ();
    	
    }
    
    
}


