package Library;

//Class for author objects
class Author {
	private String name;
	private String email;
	private char gender;

	Author(String _name, String _email, char _gender){
		name = _name;
		email = _email;
		gender = _gender;
	}

	//Functions for retrieving data
	public String getName(){
		return name;
	}
	public String getEmail(){
		return email;
	}

	//Functions for setting instance variables
	public void setEmail(String _email){
		email = _email;
	}
	public char getGender(){
		return gender;
	}

	//REturns the string to display for the author object
	public String toDisplay(){
		return String.format("%s(%c) at %s",name,gender,email);
	}

	//Main function for testing
	public static void main(String[] args) {
		Author authorObj = new Author("r.k narayan","r@gmail.com",'m');
		System.out.println(authorObj.toDisplay());
		authorObj.setEmail("new@gmail.com");
		System.out.println(authorObj.toDisplay());
	}
}