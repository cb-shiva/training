package school;
class StudentDemo {
	public static void storeStudentData(Student studentObj){
		//Populating the student object
		studentObj.setStudentName("Stark");
		studentObj.setGender(true);
		studentObj.setStudentId(345);

		//Creating a subject object
		Subject subjectObj = new Subject();
		subjectObj.setSubject1("Math");
		subjectObj.setSubject2("History");
		subjectObj.setSubject3("Physics");
		subjectObj.setMarks1((float)78.5);
		subjectObj.setMarks2((float)93.5);
		subjectObj.setMarks3(85);

		//Setting the subjects object to the student object
		studentObj.setSubjects(subjectObj);
	}
	public static void main(String[] args) {
		Student studentObj = new Student();
		storeStudentData(studentObj);
		ResultGenerator generatorObj = new ResultGenerator();
		generatorObj.generateResult(studentObj);
	}
}