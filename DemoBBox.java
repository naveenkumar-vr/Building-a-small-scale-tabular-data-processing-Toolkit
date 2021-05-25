package imt2018055;
import java.util.*;
import animation.*;
public class DemoBBox implements BBox{
	private Point minpoint,maxpoint;
	public DemoBBox(Point Minpoint,Point Maxpoint){
		minpoint = Minpoint;
		maxpoint = Maxpoint;
	}
	public Point getMinPt(){
		return minpoint;
	}
	public Point getMaxPt(){
		return maxpoint;
	}
	public boolean intersects(BBox b){
		// if(this.getMinPt().getX()>b.getMaxPt().getX() || this.getMinPt().getX()<b.getMinPt().getX()){
		// 	return false;
		// }
		// if(this.getMinPt().getY()>b.getMaxPt().getY() || this.getMinPt().getY()<b.getMinPt().getY()){
		// 	return false;
		// }
		// if(this.getMaxPt().getX()>b.getMaxPt().getX() || this.getMaxPt().getX()<b.getMinPt().getX()){
		// 	return false;
		// }
		// if(this.getMaxPt().getY()>b.getMaxPt().getY() || this.getMaxPt().getY()<b.getMinPt().getY()){
		// 	return false;
		// }
		// return true;
		if(this.getMinPt().getX()>b.getMaxPt().getX() || this.getMaxPt().getX()<b.getMinPt().getX()){
			return false;
		}
		if(this.getMinPt().getY()>b.getMaxPt().getY() || this.getMaxPt().getY()<b.getMinPt().getY()){
			return false;
		}
		return true;

	}
	public String toString(){
		return this.getMinPt().getX()+","+this.getMinPt().getY();
	}
}