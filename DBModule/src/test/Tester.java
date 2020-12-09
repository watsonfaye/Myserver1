import com.bdqn.dao.impl.StudentImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

public class Tester {
    public  ApplicationContext ctx;
    {
        ctx=new ClassPathXmlApplicationContext("springDB.xml");
    }

    @Test
    public void Test1(){
        Connection conn= (Connection) ctx.getBean("conn");
        System.out.println(conn);
    }
    @Test
    public void Test2(){
        StudentImpl studentimpl= (StudentImpl) ctx.getBean("studentImpl");

        System.out.println(studentimpl.getAll());
    }
    @Test
    public  void Test3(){

    }
}
