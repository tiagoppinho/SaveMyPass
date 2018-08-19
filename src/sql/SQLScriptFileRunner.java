package sql;

import handlers.DatabaseHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.Customization;

/**
 * Class responsible for running the sql script files.
 * @author Tiago Pinho
 */
public class SQLScriptFileRunner {
    
    private static final String SCRIPT_FILE_START_PATH = "scripts/",
                                SCRIPT_FILE_EXTENSION = ".sql";
    
    /**
     * Runs sql scripts inside an sql script file.
     * @param scriptFileName The sql script file name (without extension).
     */
    public static void runScriptFile(String scriptFileName){
        ArrayList scripts = getScripts(scriptFileName);
        Connection connection = DatabaseHandler.getConnection();
        try{
            Statement statement = connection.createStatement();
            
            for(Object script : scripts)
                statement.execute(script.toString());
            
            statement.close();
            connection.close();
        }catch(SQLException ex){
            System.out.println(ex.toString());
            Customization.displayWarningMessage(ex.toString(), "Error");
        }
    }
    
    /**
     * Gets the scripts inside the sql script file.
     * @param scriptFileName The sql script file name (without extension).
     * @return ArrayList
     */
    private static ArrayList<String> getScripts(String scriptFileName){
        InputStream file = SQLScriptFileRunner.class.getResourceAsStream(SCRIPT_FILE_START_PATH + scriptFileName + SCRIPT_FILE_EXTENSION);
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(file));
            String line;
            ArrayList<String> scripts = new ArrayList<>(); 
            while((line = reader.readLine()) != null){
                scripts.add(line);
            }
            reader.close();
            return scripts;
        }catch(IOException ex){
            System.out.println(ex.toString());
            Customization.displayWarningMessage(ex.toString(), "Error");
        }
        return null;
    }
    
}
