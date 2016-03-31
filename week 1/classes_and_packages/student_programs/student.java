package school;
class Student {
	int studentId;
	String studentName;
	boolean gender;
	Subject subjects;

	//Methods for setting instance values
	public void setStudentName(String _studentName){
		studentName = _studentName;
	}
	public void setGender(boolean _gender){
		gender = _gender;
	}
	public void setStudentId(int _studentId){
		studentId = _studentId;
	}
	public void setSubjects(Subject _subjects){
		subjects = _subjects;
	}


	//Methods for getting instance values
	public int getStudentId(){
		return studentId;
	}
	public boolean getGender(){
		return gender;
	}
	public Subject getSubjects(){
		return subjects;
	}
	public String getStudentName(){
		return studentName;
	}
}