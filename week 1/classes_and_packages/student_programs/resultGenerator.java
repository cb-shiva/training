//This class is used to calculate and generate the results
package school;
class ResultGenerator {
	public static void generateResult(Student studentObj){
		Subject subjects = studentObj.getSubjects();
		float total = (subjects.getMarks1()+subjects.getMarks2()+subjects.getMarks3());
		float avg = (float) total/3;
		System.out.println("Student Id:- "+studentObj.getStudentId());
		System.out.println("Name:- "+studentObj.getStudentName());
		System.out.print("Subject 1:- "+subjects.getSubject1()+"Marks:- "+subjects.getMarks1()+"\n");
		System.out.print("Subject 2:- "+subjects.getSubject2()+"Marks:- "+subjects.getMarks2()+"\n");
		System.out.print("Subject 3:- "+subjects.getSubject3()+"Marks:- "+subjects.getMarks3()+"\n");
		System.out.println("Total:- "+total);
		System.out.println("Average:- "+avg);
	}
}