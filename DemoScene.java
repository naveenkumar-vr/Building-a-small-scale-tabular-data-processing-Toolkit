package imt2018055;
import java.util.*;
import animation.Scene;
public class DemoScene extends Scene{
	public DemoScene(){
		super();
	}
	protected void checkScene(){
		for(int i = 0;i<this.getActors().size();i++)
		{
			for(int j=0;j<this.getActors().size();j++)
			{
				if(this.getActors().get(i) != this.getActors().get(j))
				{
					if(this.getActors().get(i).getBBox().intersects(this.getActors().get(j).getBBox()))
					{
						// System.out.print("removed 1 actors\n");
						this.getActors().remove(i);
					}
				}
			}
				
			for(int j=0;j<this.getObstacles().size();j++)
			{
				if(this.getActors().get(i).getBBox().intersects(this.getObstacles().get(j).getBBox()))
				{
					// System.out.print("removed 1 actor\n");
					this.getActors().remove(i);
				}
			}
		}
	}
}