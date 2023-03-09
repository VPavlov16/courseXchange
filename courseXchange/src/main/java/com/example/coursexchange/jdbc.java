package com.example.coursexchange;
import java.sql.*;


public class jdbc {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/blackmarket";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "123456789";
    private static final String INSERT_QUERY = "INSERT INTO users (u_fname, u_lname, u_username, u_tel, u_email, u_pass) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_QUERY = "SELECT * FROM users WHERE u_email = ? and u_pass = ? OR u_username = ? and u_pass=?;";
    private static final String INSERT_ANN = "INSERT INTO announcement(ann_title, ann_type, ann_subject, ann_descript, ann_price,ann_userId) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String getID = "SELECT u_id FROM users WHERE u_email = ? and u_pass = ? OR u_username = ? and u_pass=?;";
  //  private static final String SELECT_PROF = "SELECT u_fname,u_lname,u_username,u_email,u_tel FROM users WHERE u_email = ? and u_pass = ? OR u_username = ? and u_pass=?;";

    public static String firstName;
    public static String lastName;
    public static String userName;
    public static String email;
    public static String phoneNum;

    public static int uid;
    //get user info
   /* public void getInfo(String uName, String emailche, String pNum,String pass)throws SQLException{
        try(Connection connection = DriverManager.getConnection(DATABASE_URL,DATABASE_USERNAME,DATABASE_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROF)){
            preparedStatement.setString(1,emailche);
            preparedStatement.setString(2,pass);
            preparedStatement.setString(3,uName);
            preparedStatement.setString(4,pass);

            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                firstName = resultSet.getString("u_fname");
                System.out.println(firstName);
                lastName = resultSet.getString("u_lname");
                System.out.println(lastName);
                userName = resultSet.getString("u_username");
                System.out.println(userName);
                email = resultSet.getString("u_email");
                System.out.println(email);
                phoneNum = resultSet.getString("u_tel");
                System.out.println(phoneNum);
            }
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    */

    //insert into  db
    public void insertRecords(String firstName,String lastName,String UserName,String phoneNum,String emailche,String password) throws SQLException{

        try(Connection connection = DriverManager.getConnection(DATABASE_URL,DATABASE_USERNAME,DATABASE_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)){
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            preparedStatement.setString(3,UserName);
            preparedStatement.setString(4,phoneNum);
            preparedStatement.setString(5,emailche);
            preparedStatement.setString(6,password);

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }

    }
    //read from db
    public boolean validate(String emailche,String password,String username) throws SQLException{

        //connect
        try(Connection connection = DriverManager.getConnection(DATABASE_URL,DATABASE_USERNAME,DATABASE_PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)){
            preparedStatement.setString(1,emailche);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,username);
            preparedStatement.setString(4,password);

            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                //get user info for profile
                firstName = resultSet.getString("u_fname");
                System.out.println(firstName);
                lastName = resultSet.getString("u_lname");
                System.out.println(lastName);
                userName = resultSet.getString("u_username");
                System.out.println(userName);
                email = resultSet.getString("u_email");
                System.out.println(email);
                phoneNum = resultSet.getString("u_tel");
                System.out.println(phoneNum);
                return true;
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return false;
    }

    //insert announcements
    public void insertAnn(String title,String type,String subject,String description,double price,int aidi) throws SQLException{

        try(Connection connection = DriverManager.getConnection(DATABASE_URL,DATABASE_USERNAME,DATABASE_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ANN)){
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,type);
            preparedStatement.setString(3,subject);
            preparedStatement.setString(4,description);
            preparedStatement.setDouble(5,price);
            preparedStatement.setInt(6,aidi);

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }

    }

    //get id
    public void getUsID(String emailche,String password,String username) throws SQLException{

        try(Connection connection = DriverManager.getConnection(DATABASE_URL,DATABASE_USERNAME,DATABASE_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(getID)){
            preparedStatement.setString(1,emailche);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,username);
            preparedStatement.setString(4,password);

            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                uid = resultSet.getInt("u_id");
                System.out.println(uid);
            }
        }catch (SQLException e){
            printSQLException(e);
        }

    }

    //errors
    public static void printSQLException(SQLException ex){
        for (Throwable e:ex){
            if (e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQL State: "+ ((SQLException) e).getSQLState());
                System.err.println("Error Code: "+ ((SQLException) e).getErrorCode());
                System.err.println("Message: "+ e.getMessage());
                Throwable t = ex.getCause();
                while(t != null){
                    System.out.println("Cause: "+t);
                    t=t.getCause();
                }

            }
        }
    }
}
