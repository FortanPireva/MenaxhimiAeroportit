package DB;

import java.sql.*;

public class DatabaseManager {
    private Connection connection;                                             // The database connection object.
    private Statement statement;                                               // the database statement object, used to execute SQL commands.

    public DatabaseManager (String username, String password ) {               // the constructor for the database manager.
        String url = "jdbc:mysql://localhost:3310/menaxhimiaeroportit?characterEncoding=latin1&useConfigs=maxPerformance";       // our database--username is your O'Reilly login username and is passed in.
        try {
            Class.forName ("com.mysql.jdbc.Driver");                           // get the driver for this database.
            System.out.println("Driver is set; ready to go!");
        }
        catch (Exception e) {
            System.out.println("Failed to load JDBC/ODBC driver.");
            return;                                                            // cannot even find the driver--return to caller since cannot do anything.
        }

        try {                                                                     // Establish the database connection, create a statement for execution of SQL commands.
            connection = DriverManager.getConnection (url, username, password );  // username and password are passed into this Constructor.
            statement  = connection.createStatement(); // statement used to do things in the database (e.g., create the PhoneBook table).
            System.out.println("Successful Connection");
        }
        catch (SQLException exception ) {
            System.out.println ("\n*** SQLException caught ***\n");
            while (exception != null) 
            {                                                                     // grab the exception caught to tell us the problem.
                System.out.println ("SQLState:   " + exception.getSQLState()  );
                System.out.println ("Message:    " + exception.getMessage()   );
                System.out.println ("Error code: " + exception.getErrorCode() );
                exception = exception.getNextException ();
                System.out.println ( "" );
            }
        }
        catch (java.lang.Exception exception) {                                  // perhaps there is an exception that was not SQL related.
            exception.printStackTrace();                                         // shows a trace of the exception error--like we see in the console.
        }
    }
    public Statement getStatement()
    {
    	return statement;
    }
}   