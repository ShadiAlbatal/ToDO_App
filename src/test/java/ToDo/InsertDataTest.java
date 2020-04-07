package ToDo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class InsertDataTest extends InsertData {
    DBinfo dBinfo= new DBinfo();

    public InsertDataTest() throws SQLException {
    }

    @Before
    public void setUp() throws Exception {
        dBinfo.useDB();
    }

    @After
    public void tearDown() throws Exception {
        dBinfo.closeConnection();
    }

    @Test
    public void testInsert() {
        String Insert= "insert into " + dBinfo.getTableName()  + "( Title, Due_Date, Project, Done ) " + "values (?,?,?,?);";
        
    }
}