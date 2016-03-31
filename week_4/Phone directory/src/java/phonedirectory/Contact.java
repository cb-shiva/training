/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonedirectory;
import java.sql.*;
/**
 *
 * @author cb-shiva
 */
public class Contact {
    private String firstName ="sfeaffaf", lastName="", addressLine1="", addressLine2="",
            city="", state="", zip="",workNumber="",homeNumber="",mobileNumber="",phoneId="";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/phone_books?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "";
    
    private Connection getConnection()throws SQLException, ClassNotFoundException{
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL,USER,PASS);    
    }
    
    public Contact(String firstName, String lastName, String addressLine1, String addressLine2, String city, String state, String zip, String workNumber, String homeNumber, String mobileNumber,String phoneId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.workNumber = workNumber;
        this.homeNumber = homeNumber;
        this.mobileNumber = mobileNumber;
        this.phoneId = phoneId;
    }
    
    public Contact(String phoneId)throws SQLException, ClassNotFoundException{
        this.phoneId = phoneId;
        this.firstName = phoneId;
        PreparedStatement contactQuery = getConnection().prepareStatement("Select * from phone_book where phone_book_id like ?");
        contactQuery.setString(1,phoneId);
        ResultSet r =contactQuery.executeQuery();
        if(r.next()){
            this.firstName = r.getString("first_name");
            this.lastName = r.getString("last_name");
            this.addressLine1 = r.getString("address_line_1");
            this.addressLine2 = r.getString("address_line_2");
            this.city = r.getString("city");
            this.state = r.getString("state");
            this.zip = r.getString("zip");
            this.workNumber = r.getString("work_number");
            this.homeNumber = r.getString("home_number");
            this.mobileNumber = r.getString("mobile_number");
        }
    }
    
    public String getPhoneId(){
        return phoneId;
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

    /**
     * @return the addressLine1
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * @return the addressLine2
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @return the workNumber
     */
    public String getWorkNumber() {
        return workNumber;
    }

    /**
     * @return the homeNumber
     */
    public String getHomeNumber() {
        return homeNumber;
    }

    /**
     * @return the mobileNumber
     */
    public String getMobileNumber() {
        return mobileNumber;
    }
    
}
