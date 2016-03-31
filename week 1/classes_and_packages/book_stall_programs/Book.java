package Library;
import java.util.*;

//Class for book objects
class Book {
	private String name;
	private List<Author> authors;
	private Double price;
	private int qtyInStock;

	Book(String _name, Author _author , double _price , int _qtyInStock){
		name = _name;
		authors = new ArrayList<Author>();
		authors.add(_author);
		price = _price;
		qtyInStock = _qtyInStock;
	}

	Book(String _name, List<Author> _authors , double _price , int _qtyInStock){
		name = _name;
		authors = new ArrayList<Author>(_authors);
		price = _price;
		qtyInStock = _qtyInStock;
	}
	
	//Functions for retrieviing data
	public String getName(){
		return name;
	}

	public List<Author> getAuthors(){
		return authors;
	}

	//Functions for setting instance variables
	public void setPrice(double _price){
		price = _price;
	}

	public void setQtyInStock(int _qtyInStock){
		qtyInStock = _qtyInStock;
	}

	//Function that returns the string to display for an author object
	public String toDisplay(){
		String displayString = name + " by ";
		for (Author authorObj : authors) {
			displayString = displayString + authorObj.toDisplay() + ", ";
		}
		displayString = displayString + "\nPrice : $" + price + "\n" + "No of books available : " + qtyInStock + "\n";
		return displayString;
	}

	//Prints all the author details for the book 
	public void printAuthors(){
		for (Author authorObj : authors) {
			System.out.println(authorObj.toDisplay());		
		}
	}

	//Function for adding authors to the book
	public void addAuthor(Author _author){
		authors.add(_author);
	}

	public static void main(String[] args) {
		char userResponse, authorGenderResponse;
		String nameResponse, authorNameResponse, authorEmailResponse;
		int priceResponse, qtyInStockResponse;
		List<Book> bookList = new ArrayList<Book>();
		Scanner sc =  new Scanner(System.in);
		
		//Flags for stopping input loop
		boolean bookFlag = false, authorFlag = false;
		
		do{
			System.out.println("Add a book?[y/n] ");
			userResponse = sc.next().charAt(0);
			if(userResponse == 'y'){
				System.out.println("Enter the book's name:- ");
				nameResponse = sc.nextLine();
				nameResponse = sc.nextLine();
				System.out.println("Enter the price:- ");
				priceResponse = sc.nextInt();
				System.out.println("Enter the quantity in stock:- ");
				qtyInStockResponse = sc.nextInt();

				//Creating an author list
				ArrayList<Author> authorList = new ArrayList<Author>();
				authorFlag = false;
				do{
					System.out.println("Add authors?[y/n] ");
					userResponse = sc.next().charAt(0);
					if (userResponse == 'y') {
						System.out.println("Enter the author's name:- ");
						authorNameResponse = sc.nextLine();//Dummy scan to capture newline after previous scan
						authorNameResponse = sc.nextLine();
						System.out.println("Enter the gender of the author:- ");
						authorGenderResponse = sc.next().charAt(0);
						System.out.println("Enter the author's email id:- ");
						authorEmailResponse = sc.next();
						Author authorObj = new Author(authorNameResponse, authorEmailResponse, authorGenderResponse);
						authorList.add(authorObj);
					}
					else
						authorFlag = true;

				}while(!authorFlag);

				//Creating a book object and adding the book to the booklist
				Book bookObj = new Book(nameResponse, authorList, priceResponse, qtyInStockResponse);
				bookList.add(bookObj);


				//Displaying the details of the book object created
				System.out.println("Book created! Details are :-");
				System.out.println(bookObj.toDisplay());
				System.out.println("---------------------------------------");
			}
			else
				bookFlag = true;
		}while(!bookFlag);
	}
}