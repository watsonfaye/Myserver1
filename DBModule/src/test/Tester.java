import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

public class Tester {
    @Test
    public void Test1(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("springDB.xml");

        Connection conn= (Connection) ctx.getBean("conn");

        System.out.println(conn);
    }
}
