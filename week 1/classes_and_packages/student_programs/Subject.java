package school;
class Subject {
	String subject1,subject2,subject3;
	float marks1,marks2,marks3;

	//Methods for setting instance values
	public void setSubject1(String _subject1){
		subject1 = _subject1;
	}
	public void setSubject2(String _subject2){
		subject2 = _subject2;
	}
	public void setSubject3(String _subject3){
		subject3 = _subject3;
	}
	public void setMarks1(float _marks1){
		marks1 = _marks1;
	}
	public void setMarks2(float _marks2){
		marks2 = _marks2;
	}
	public void setMarks3(float _marks3){
		marks3 = _marks3;
	}

	//Methods for getting instance values
	public String getSubject1(){
		return subject1;
	}
	public String getSubject2(){
		return subject2;
	}
	public String getSubject3(){
		return subject3;
	}
	public float getMarks1(){
		return marks1;
	}
	public float getMarks2(){
		return marks2;
	}
	public float getMarks3(){
		return marks3;
	}
}