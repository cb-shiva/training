/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonedirectory;
import java.sql.*;
import java.util.*;
/**
 *
 * @author cb-shiva
 */

public class User {
    private String email="", firstName="", lastName="", userId = "";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/phone_books?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "";
    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    public User(String email){
        this.email = email;
    }
    
    public void fetchDetails()throws SQLException, ClassNotFoundException{
        Class.forName(JDBC_DRIVER);
        Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
        PreparedStatement detailQuery = con.prepareStatement("Select * from user_details where email like ?");
        detailQuery.setString(1, email);
        ResultSet r = detailQuery.executeQuery();
        if(r.next()){
            firstName = r.getString("firstname");
            lastName = r.getString("lastname");
            userId = r.getString("user_id");
        }
    }
    public Connection getConnection()throws SQLException, ClassNotFoundException{
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL,USER,PASS);
        
    }
    
    public ArrayList<Contact> getContactList()throws SQLException, ClassNotFoundException{
        PreparedStatement contactsQuery = getConnection().prepareStatement("Select * from user_phone_book up join phone_book p where up.phone_book_id = p.phone_book_id and up.user_id like ?");
        contactsQuery.setString(1, userId);
        ResultSet r = contactsQuery.executeQuery();
        while(r.next()){
            contacts.add(new Contact(r.getString("first_name"),r.getString("last_name"),r.getString("address_line_1"),
                                     r.getString("address_line_2"),r.getString("city"),r.getString("state"),
                                     r.getString("zip"),r.getString("work_number"),
                                     r.getString("home_number"),r.getString("mobile_number"),r.getString("phone_book_id")));
        }
        return contacts;
    }
    
    public ArrayList<Contact> getContactListByName(String name)throws SQLException, ClassNotFoundException{
        PreparedStatement contactsQuery = getConnection().prepareStatement("Select * from user_phone_book up join phone_book p where up.phone_book_id = p.phone_book_id and up.user_id = ? and (first_name like ? or last_name like ?)");
        contactsQuery.setString(1, userId);
        contactsQuery.setString(2, "%"+name+"%");
        contactsQuery.setString(3, "%"+name+"%");
        ResultSet r = contactsQuery.executeQuery();
        while(r.next()){
            contacts.add(new Contact(r.getString("first_name"),r.getString("last_name"),r.getString("address_line_1"),
                                     r.getString("address_line_2"),r.getString("city"),r.getString("state"),
                                     r.getString("zip"),r.getString("work_number"),
                                     r.getString("home_number"),r.getString("mobile_number"),r.getString("phone_book_id")));
        }
        return contacts;
    }
    public ArrayList<Contact> getContactListByNumber(String number)throws SQLException, ClassNotFoundException{
        PreparedStatement contactsQuery = getConnection().prepareStatement("Select * from user_phone_book up join phone_book p where up.phone_book_id = p.phone_book_id and up.user_id = ? and (work_number like ? or home_number like ? or mobile_number like ?)");
        contactsQuery.setString(1, userId);
        contactsQuery.setString(2, number);
        contactsQuery.setString(3, number);
        contactsQuery.setString(4, number);
        ResultSet r = contactsQuery.executeQuery();
        while(r.next()){
            contacts.add(new Contact(r.getString("first_name"),r.getString("last_name"),r.getString("address_line_1"),
                                     r.getString("address_line_2"),r.getString("city"),r.getString("state"),
                                     r.getString("zip"),r.getString("work_number"),
                                     r.getString("home_number"),r.getString("mobile_number"),r.getString("phone_book_id")));
        }
        return contacts;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }
    
    public String getUserId(){
        return userId;
    }

    
}
