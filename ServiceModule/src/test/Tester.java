import com.bdqn.service.impl.StudentBiz;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {
    public ApplicationContext ctx;
    {
        ctx=new ClassPathXmlApplicationContext("classpath:springDB.xml");
    }


    @Test
    public  void Test1(){
        StudentBiz sb= (StudentBiz) ctx.getBean("studentBiz");
        System.out.println(sb.getAll());
    }
}
