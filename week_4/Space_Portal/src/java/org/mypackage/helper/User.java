/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.helper;
import java.sql.*;
/**
 *
 * @author cb-shiva
 */

public class User {
    private String email="", firstName="", lastName="", addressLine1="", addressLine2="", City="",State="",Zip="",Country="";
    private boolean addressExists = true;
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/space_portal?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "";
    public User(String email) throws SQLException, ClassNotFoundException{
        this.email = email;
        Class.forName(JDBC_DRIVER);
        Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
        PreparedStatement query = con.prepareStatement("Select * from user_details where email like ?");
        query.setString(1, email);
        ResultSet r = query.executeQuery();
        if(r.next()){
            firstName = r.getString("firstname");
            lastName = r.getString("lastname");
            addressLine1 = r.getString("address_line_1");
            addressLine2 = r.getString("address_line_2");
            City = r.getString("city");
            State = r.getString("state");
            Zip = r.getString("zip");
            Country = r.getString("country");
            if("N/A".equals(addressLine1)){
                addressExists = false;
            }
        }
    }
    public boolean addressExists(){
        return addressExists;
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
     * @return the City
     */
    public String getCity() {
        return City;
    }

    /**
     * @return the State
     */
    public String getState() {
        return State;
    }

    /**
     * @return the Zip
     */
    public String getZip() {
        return Zip;
    }

    /**
     * @return the Country
     */
    public String getCountry() {
        return Country;
    }

    /**
     * @return the address
     */

    
}
