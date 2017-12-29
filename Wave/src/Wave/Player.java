package Wave;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {

		Random r = new Random();
		Handler handler ;
	public Player(int x, int y, ID id , Handler handler) {
		super(x, y, id);
		this.handler = handler ; 
		
		// TODO Auto-generated constructor stub
		
	}

	public Rectangle getBounds()
	{
		return new Rectangle ( (int)x ,(int)y, 32,32);
	}
	public void tick() {
		x+= velX;
		y+= velY;
		// TODO Auto-generated method stub
		
		if ( y <= 0 || y >= Game.HEIGHT - 50 ) 
			
			velY *= -1 ;
		if ( x <= 0 || x >= Game.WIDTH - 32 ) 
			
			velX *= -1 ;
		//x = Game.clamp(x,0,Game.WIDTH - 37 );
	    //y = Game.clamp(y,0,Game.HEIGHT - 60 );
		handler.addObject(new Trail (x ,y,ID.Trail  , Color.white , 40,40, handler , 0.1f ));
		collision();
	}
private void collision ()
{
	for ( int i = 0 ; i < handler.object.size(); i++ )
	{
		GameObject tempobject = handler.object.get(i);
		if(tempobject.getId() == ID.BasicEnemy ||tempobject.getId() == ID.SmartEnemy  ||tempobject.getId() == ID.FastEnemy ||tempobject.getId() == ID.VeryFastEnemy) // temp object is now a basic enemy or smart
		{
			if(getBounds().intersects(tempobject.getBounds())) {
				//collision code
				HUD.HEALTH -= 2 ; 
			}
			
		}
	}
}

	public void render(Graphics g) {
		
		Graphics2D g2d =  (Graphics2D) g; 
		g.setColor(Color.RED);
		g2d.draw(getBounds());
		
		
		if (id == ID.Player)
			g.setColor(Color.white);
			g.fillRect((int)x,(int) y, 40, 40);
	} 
	
	

}
