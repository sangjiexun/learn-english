package recitation_others;
//等级与经验管理
public class grade {
public int ex;
public int grade ,lastex,nextex;
public double l;
public grade (int x){
	ex=x;
	
	}	

public int getgrade(){
	grade = (int) (((float) Math.log((float)ex/(float)500+1))/ (float)Math.log(1.1))+1;
	return grade;
}

public double getlen(){
	
	nextex=(int) (500*(Math.pow(1.1,grade)-1));
    lastex=(int) (500*(Math.pow(1.1,(grade-1))-1));
    l=(double)(ex-lastex)/(double)(nextex-lastex);
	return l;
}

}


