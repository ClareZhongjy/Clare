package mybatisTest;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.SpringMVC.service.impl.CustomerService;

public class TestMybatis {
	
	private Logger logger = Logger.getLogger(TestMybatis.class);
	
    private ApplicationContext ac = null; 
    public static void main(String[] args) {
        TestMybatis test=new TestMybatis();
        test.before();
    }
    public void before() {  
      ac = new ClassPathXmlApplicationContext("applicationContext.xml"); //引入配置文件 
      CustomerService customerService= (CustomerService) ac.getBean("customerService");//需要注意这里的customerService 是在service中使用@Service（“customerService”）一致
      System.out.println(customerService.getAllCustomer().get(0).getName());
      logger.info("test");
    /*  CustomerService TellerService= (CustomerService) ac.getBean("TellerService");
      System.out.println(TellerService);*/
  } 
}