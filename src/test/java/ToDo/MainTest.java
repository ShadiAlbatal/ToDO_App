package ToDo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class MainTest extends Main {
    DBinfo dBinfo= new DBinfo();

    public MainTest() throws SQLException {
    }

    @Before
    public void setUp() throws Exception {
        dBinfo.getConnection();
    }

    @After
    public void tearDown() throws Exception {
        dBinfo.closeConnection();
    }

    @Test
    public void testMain() {
    }
}