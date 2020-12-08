import com.bdqn.util.DBUtil;
import com.bdqn.util.DataUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

public class Tester {
    @Test
    public void Test1(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-dbmodule.xml");
        DataUtil du= (DataUtil) ctx.getBean("dataUtil");
        Connection conn=du.getConn();
        System.out.println(conn);
//        System.out.println(du.getConn());
    }
}
