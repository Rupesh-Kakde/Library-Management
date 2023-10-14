import myutil.PersonalDetails;

import java.sql.*;
import  java.text.SimpleDateFormat;

public class Database {
    private final String url = "jdbc:postgresql://localhost/library";
    private final String user = "postgres";
    private final String password = "Harish";

    private static final String SELECT_ALL_QUERY = "select * from student";

    private static final String UPDATE_USERS_SQL = "update student set username = ? where id = ?;";
    private static final String INSERT_RECORD_SQL ="insert into student(username,password,email,address,mobile,first_name,middle_name,last_name,courses) values(?,?,?,?,?,?,?,?,?);";

    public Connection connect(){
        try {
            Connection conn  = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            return  conn;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    private PersonalDetails getAllUsers() {

        try {
            // Step 1: Establishing a Connection
            Connection conn =connect();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_QUERY);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String first_name = rs.getString("first_name");
                String middle_name = rs.getString("middle_name");
                String last_name = rs.getString("last_name");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String mobile  = rs.getString("mobile");
//                Date date  = rs.getDate("DOB");

                PersonalDetails personalDetails = new PersonalDetails();
                personalDetails.setId(id);
                personalDetails.setPassword(password);
                personalDetails.setUsername(username);
                personalDetails.setFirstName(first_name);
                personalDetails.setMiddleName(middle_name);
                personalDetails.setLastName(last_name);
                personalDetails.setUsername(username);
                personalDetails.setEmail(email);
                personalDetails.setAddress(address);
                personalDetails.setMobileNo(mobile);
//                personalDetails.setDOB(date.toString());


//                System.out.println(id);
//                System.out.println(username);
//                System.out.println(password);
//                System.out.println(email);
//                System.out.println(address);
//                System.out.println(mobile);

                return  personalDetails;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return  null;
    }

    public void updateRecord()
    {
        //step -1 Establishing connection

        try{
            Connection conn = DriverManager.getConnection(url, user, password);

            //step 2:Create a statement using connection object
            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_USERS_SQL);

            preparedStatement.setString(1, "Ram");
            preparedStatement.setInt(2,3);

            //step 3:Execute the query or update
            preparedStatement.executeUpdate();

        }catch(SQLException e)
        {
            System.out.println(e);
        }
    }

    public  PersonalDetails getRecord(String username,String password)
    {
        final String GET_STUDENT_HAVING_USERNAME = "select * from student where username = \'"+username +"\' and " + "password=\'"+password+"\'";
        try {
            Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_STUDENT_HAVING_USERNAME);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String first_name = rs.getString("first_name");
                String middle_name = rs.getString("middle_name");
                String last_name = rs.getString("last_name");
                String user_name = rs.getString("username");
                String pass = rs.getString("password");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String mobile = rs.getString("mobile");

                PersonalDetails personalDetails = new PersonalDetails();
                personalDetails.setId(id);
                personalDetails.setPassword(pass);
                personalDetails.setUsername(user_name);
                personalDetails.setFirstName(first_name);
                personalDetails.setMiddleName(middle_name);
                personalDetails.setLastName(last_name);
                personalDetails.setUsername(username);
                personalDetails.setEmail(email);
                personalDetails.setAddress(address);
                personalDetails.setMobileNo(mobile);

                return personalDetails;

            }
        }catch (SQLException e) {
            System.out.println(e);
        }
        return  null;
    }

    public void insertRecord()
    {
        try{
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_RECORD_SQL);

            preparedStatement.setString(1,"Harry");
            preparedStatement.setString(2,"1234");
            preparedStatement.setString(3, "harry@gmail.com");
            preparedStatement.setString(4, "Pune");
            preparedStatement.setString(5, "1111111111");
            preparedStatement.setString(6, "Harish");
            preparedStatement.setString(7, "s");
            preparedStatement.setString(8, "Kushwah");
            preparedStatement.setString(9, "TYBCS");

            Date DOB = new Date(2004,8,25);
//            preparedStatement.setDate(10,DOB);

            preparedStatement.executeUpdate();
            conn.commit();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    private void insertRecord(PersonalDetails personalDetails)
    {
        try{
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_RECORD_SQL);

            preparedStatement.setString(1,personalDetails.getUsername());
            preparedStatement.setString(2,personalDetails.getPassword());
            preparedStatement.setString(3, personalDetails.getEmail());
            preparedStatement.setString(4, personalDetails.getAddress());
            preparedStatement.setString(5, personalDetails.getMobileNo());
            preparedStatement.setString(6, personalDetails.getFirstName());
            preparedStatement.setString(7, personalDetails.getMiddleName());
            preparedStatement.setString(8, personalDetails.getLastName());
            preparedStatement.setString(9, personalDetails.getCourses());

//            Date DOB = new Date(2004,8,25);
//            preparedStatement.setDate(9,DOB);

            preparedStatement.executeUpdate();
            conn.commit();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    //this methods are for other classes to access database
    public PersonalDetails authenticate(String username,String password)
    {
        return  getRecord(username,password);
    }
    public void addUserDetails(PersonalDetails personalDetails)
    {
        insertRecord(personalDetails);
    }
    public static void main(String[] args) {
        Database db = new Database();
//        db.insertRecord();
        PersonalDetails personalDetails = db.getRecord("Harry","1234");
        if(personalDetails!=null)
            personalDetails.showPersonalDetails();
//        db.updateRecord();
//        db.getAllUsers();

    }
}


