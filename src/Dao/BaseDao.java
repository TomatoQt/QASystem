package Dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;

public class BaseDao {
    protected DataSource dataSource;

    public BaseDao() {
        try {
            Context context=new InitialContext();
            dataSource=(DataSource)context.lookup("java:comp/env/QASystem");
        }
        catch(NamingException ne) {
            System.out.println("Exception:"+ne);
        }
    }

    public Connection getConnection() throws Exception {
        return dataSource.getConnection();
    }
}
