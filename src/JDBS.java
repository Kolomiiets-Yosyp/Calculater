import java.sql.*;
import java.util.Scanner;

public class JDBS {
    public static Connection connection;
   static String url = "jdbc:mysql://localhost:3306/schema";
    static String username = "root";
    static String password = "123456789";
    static Scanner scanner= new Scanner(System.in);
    static Scanner scanner1= new Scanner(System.in);
    public static void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            PreparedStatement pStatement;
            System.out.println("Enter Num : ");
            int nim =scanner.nextInt();
            System.out.println("Enter something : ");
            String som =scanner1.nextLine();
            pStatement = connection.prepareStatement("INSERT into table_name values (?,?)");
            pStatement.setInt(1, nim);
            pStatement.setString(2, som);

            int i = pStatement.executeUpdate();
            ResultSet resultSet ;

            resultSet = statement.executeQuery("select * from table_name");
            while (resultSet.next()) {
                System.out.println(  resultSet.getInt(1)+" "+
                resultSet.getString(2));
                }

            PreparedStatement pStatement1 = connection.prepareStatement("update table_name set some= ? where id=?");
            pStatement1.setString(1,"Update");
            pStatement1.setInt(2,nim);
            System.out.println("Your text changed to Update");
            int i1 = pStatement1.executeUpdate();
            ResultSet resultSet1= statement.executeQuery("select * from table_name");
            while (resultSet1.next()) {
                System.out.println(  resultSet1.getInt(1)+" "+
                        resultSet1.getString(2));
            }



            PreparedStatement pStatement2 = connection.prepareStatement("Delete from table_name where id = ?");
            pStatement2.setInt(1,nim);
            System.out.println("Your text deleted");
            int i2 = pStatement2.executeUpdate();
            ResultSet  resultSet2 = statement.executeQuery("select * from table_name");
            while (resultSet2.next()) {
                System.out.println(  resultSet2.getInt(1)+" "+
                        resultSet2.getString(2));
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        Connect();
    }
}