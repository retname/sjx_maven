import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zy.entity.Options;
import zy.entity.Subject;
import zy.service.SubjectService;

import java.util.List;

/**
 * Created by zhangyu on 2017/10/14.
 */
public class TestSubject {


    @Test
    public void Test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-hiberanate.xml");
        SubjectService service  = (SubjectService) context.getBean("subjectServiceImpl");
        List<Subject> all = service.findAll();
        System.out.println(all.size());
        for (Subject item :
                all) {
            System.out.println(item.getCreateDate());
        }

    }


}
