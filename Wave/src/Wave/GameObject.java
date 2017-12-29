package Wave;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject 

{
	protected float x , y ; //it can only be accessed by object inherits from it only 
	protected ID id ;  
	protected float velX , velY;
	
	public GameObject(float x , float y , ID id )
	{
		this.x = x ;
		this.y = y ;
		this.id = id ; 
	}
	
	public abstract Rectangle getBounds();
	public abstract void tick();
	public abstract void render(Graphics  g );
	
	
	public void setX (int x)
	{
		this.x = x ; 
	}
	public void setY ( int y ) 
	{
		 this.y = y ; 
	}
	
public float getX () {
	return x ;
}



public float getY () {
return y ;
}

public void setVelX(int velX) {
	this.velX = velX;
}
public ID getId() {
	return id;
}
public void setId(ID id) {
	this.id = id;
}
public float getVelY() {
	return velY;
}
public void setVelY(int velY) {
	this.velY = velY;
}
public float getVelX() {
	return velX;
}


}
