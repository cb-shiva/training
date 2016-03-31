<%@page import="phonedirectory.Contact"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@page import="phonedirectory.User" %>

<%
    
    if(!"logged_in".equals(session.getAttribute("status"))){
        response.sendRedirect("index.jsp");
    }
    
%>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="show_styles.css">
        <script>
             function check(){
                 var dirty_bit = document.getElementById('page_is_dirty');
                
                 if (dirty_bit.value === '1') {
                     window.location.reload();
                 }
                 else{
                     dirty_bit.value = '1';
                 }
             }
             
             function post(path, phone_book_id) {
                method = "post";
                var form = document.createElement("form");
                form.setAttribute("method", method);
                form.setAttribute("action", path);
                var hiddenField = document.createElement("input");
                hiddenField.setAttribute("type", "hidden");
                hiddenField.setAttribute("name", "phone_book_id");
                hiddenField.setAttribute("value", phone_book_id);
                form.appendChild(hiddenField);
                document.body.appendChild(form);
                form.submit();
            }
        </script>
</head>
<body onload="check()">
        <%
            String email = (String)session.getAttribute("user");
            User userObj = new User(email);
            ArrayList<Contact> contacts;
            userObj.fetchDetails();
            if("number".equals(request.getParameter("search_option"))){
                contacts = userObj.getContactListByNumber(request.getParameter("search_value"));
            }
            else if("name".equals(request.getParameter("search_option"))){
                contacts = userObj.getContactListByName(request.getParameter("search_value"));
            }
            else{
                contacts = userObj.getContactList();
            }

        %>
    <div id="header">
        <div id="app-name">Phone Directory</div>
        <div id="block"></div>
        <div id="right-buttons">
            <div id="user-name">
                            Hi <% out.print(userObj.getFirstName()); %>
                        </div>
                        <input type="submit" id="deactivate-button-box" onClick="post('deactivate','')" value="Deactivate!"/>
                        <input type="submit" id="logout-button-box" onClick="parent.location='index.jsp'" value="Logout">
        </div>
    </div>
    <div id="app-container" >
        <table class="w3-table-all" cellpadding="10">
            <tr align="left">
                <th style="border-radius: 2px; min-width:120px;">NAME</th>
                <th style="min-width: 250px;">ADDRESS</th>
                <th colspan="3" style="min-width: 420px;" >PHONE</th>
                <th style="border-radius: 2px; min-width:90x;"></th>
            </tr>
            <%
                for(Contact c: contacts){
                    out.print("<tr>");
                    out.print("<td>"+c.getFirstName()+" "+c.getLastName()+"</td>");
                    out.print("<td>"+c.getAddressLine1()+" "+c.getAddressLine2()+"</td>");
                    out.print("<td>"+c.getHomeNumber()+"(home)</td>");
                    out.print("<td>"+c.getMobileNumber()+"(mobile)</td>");
                    out.print("<td>"+c.getWorkNumber()+"(work)</td>");
                    out.print("<td><input class=\"edit-btn\" type=\"submit\" onClick=\"post('editContact.jsp\','"+c.getPhoneId()+"')\" value=\"Edit\"></td>");
                    out.print("</tr>");
                }
                
            %>
          
        </table>
    </div>
    <div id="menu">
        <form name="search_form" action="show-contacts.jsp" method="POST">
            <label>Search by:-</label><br>
            <input type="radio" name="search_option" value="name">Name<br>
            <input type="radio" name="search_option" value="number">Number<br>
            <input type="radio" name="search_option" value="all">All<br>
            <input type="text" style="border-radius: 3px;" name="search_value"><br><br>
            <input class="submit-btn" type="submit" value="Search">
        </form>
        <br>
        <input class="new-contact-btn" type="submit" onClick="parent.location='addContact.jsp'" value="Add contact">
    </div>
    <form name="ignore_me">
        <input type="hidden" id="page_is_dirty" name="page_is_dirty" value="0" />
    </form>
</body>
</html>