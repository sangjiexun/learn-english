package others;

public class grade {
public int ex;
public int grade;	
public grade (int x){
	ex=x;
    grade = (int) (((float) Math.log((float)ex/(float)500+1))/ (float)Math.log(1.1))+1;
	}	
}