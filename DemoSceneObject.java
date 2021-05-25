package imt2018055;
import java.util.*;
import java.lang.Math;

import animation.BBox;
import animation.Point;
import animation.SceneObject;

public class DemoSceneObject extends SceneObject {

	private String name;
	private Point cpos,dpos;
	private int flag=0;
	private static int count = 0;
	private DemoBBox b,b1;
	private ArrayList<SceneObject> a;  //actors
	private ArrayList<SceneObject> o;  //obstacles

	public DemoSceneObject(){
		name = "object"+count;
		cpos = new Point(0,0);
		dpos = new Point(0,0);
		count++;
	}
	@Override
	public String getObjName() {
		return name;
	}

	@Override
	public Point getPosition() {
		return cpos;
	}

	@Override
	public void setPosition(int x, int y) {
		cpos.setPos(x,y);	
	}

	public void setDestPosition(int x, int y) {
		dpos.setPos(x,y);
	}
	
	protected  ArrayList<Point> getOutline(){
		ArrayList<Point> points= new ArrayList<>();
		Point p1=new Point(cpos.getX(),cpos.getY());
		Point p2=new Point(cpos.getX()+20,cpos.getY());
		Point p3=new Point(cpos.getX()+20,cpos.getY()+20);
		Point p4=new Point(cpos.getX(),cpos.getY()+20);
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		return points;
	}

	@Override
	public BBox getBBox() {
		b = new DemoBBox(cpos,this.getOutline().get(2));
		return b;
	}
	boolean checkgoodmove(ArrayList<SceneObject> a,ArrayList<SceneObject> o){
		for(int i=0;i<a.size();i++){
			if(a.get(i).getObjName()!=this.getObjName())
			{
				if(this.getBBox().intersects(a.get(i).getBBox())){
				return false;
				}
			}
		}
		for(int i=0;i<o.size();i++){
			if(o.get(i).getObjName()!=this.getObjName())
			{
				if(this.getBBox().intersects(o.get(i).getBBox()))
				return false;
			}
		}
		return true;
	}
	protected void updatePos(int deltaT){
		// int speed=1;
        a=DemoScene.getScene().getActors();
		o=DemoScene.getScene().getObstacles();
		// for(int i=0;i<speed;i++)
		// {
		    if(this.getPosition().getX()-this.dpos.getX()!=0 && flag==0)
			{
				if(Math.abs(this.getPosition().getX()-this.dpos.getX())<10 )
				{
					b1 = new DemoBBox(dpos,this.getOutline().get(2));
					this.setPosition(this.dpos.getX(),this.getPosition().getY());
				}
				else if(this.getPosition().getX()>this.dpos.getX() )
				{
					this.setPosition(this.getPosition().getX()-10,this.getPosition().getY());
					if(!checkgoodmove(a,o))
					{
						
						this.setPosition(this.getPosition().getX()+10,this.getPosition().getY()+10);
						if(!checkgoodmove(a,o))
						{
							this.setPosition(this.getPosition().getX(),this.getPosition().getY()-20);
							if(!checkgoodmove(a,o))
							{
								this.setPosition(this.getPosition().getX(),this.getPosition().getY()+10);
							}
						}
					}
				}
				else if(this.getPosition().getX()<this.dpos.getX() )
				{
					this.setPosition(this.getPosition().getX()+10,this.getPosition().getY());
					if(!checkgoodmove(a,o))
					{

						this.setPosition(this.getPosition().getX()-10,this.getPosition().getY()-10);
						if(!checkgoodmove(a,o))
						{
							this.setPosition(this.getPosition().getX(),this.getPosition().getY()+20);
							if(!checkgoodmove(a,o))
							{
								this.setPosition(this.getPosition().getX(),this.getPosition().getY()-10);
							}
						}
					}
				}
			}
			else if(this.getPosition().getY()-this.dpos.getY()!=0)
			{
				flag=1;
				if(Math.abs(this.getPosition().getY()-this.dpos.getY())<10)
				{
					b1 = new DemoBBox(dpos,this.getOutline().get(2));
					this.setPosition(this.getPosition().getX(),this.dpos.getY());
				}
				else if(this.getPosition().getY()<this.dpos.getY())
				{
					this.setPosition(this.getPosition().getX(),this.getPosition().getY()+10);
					if(!checkgoodmove(a,o))
					{
						this.setPosition(this.getPosition().getX()+10,this.getPosition().getY()-10);
						// this.setPosition(this.getPosition().getX()+11,this.getPosition().getY()+9);
						if(!checkgoodmove(a,o))
						{
							this.setPosition(this.getPosition().getX()-20,this.getPosition().getY());
							if(!checkgoodmove(a,o))
							{
								this.setPosition(this.getPosition().getX()+10,this.getPosition().getY());
							}
						}
					}
				}
				else if(this.getPosition().getY()>this.dpos.getY())
				{
					this.setPosition(this.getPosition().getX(),this.getPosition().getY()-10);
					if(!checkgoodmove(a,o))
					{
						this.setPosition(this.getPosition().getX()-10,this.getPosition().getY()+10);
						// this.setPosition(this.getPosition().getX()-11,this.getPosition().getY()-9);
						if(!checkgoodmove(a,o))
						{
							this.setPosition(this.getPosition().getX()+20,this.getPosition().getY());
							if(!checkgoodmove(a,o))
							{
								this.setPosition(this.getPosition().getX()-10,this.getPosition().getY());
							}
						}
					}
				}
				if(this.getPosition().getY()==this.dpos.getY())
				{
					flag=0;
				}
			}		
		// }	
		if(this.getPosition().getY()==this.dpos.getY() && this.getPosition().getX()==this.dpos.getX())
		{
			// System.out.print("actor reached destination and is removed\n");
			// DemoScene.getScene().getActors().remove(this);
		}
	}
	public String toString(){
		return this.getObjName();
	}
}





