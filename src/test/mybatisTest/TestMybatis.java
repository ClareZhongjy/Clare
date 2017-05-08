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
      ac = new ClassPathXmlApplicationContext("applicationContext.xml"); //���������ļ� 
      CustomerService customerService= (CustomerService) ac.getBean("customerService");//��Ҫע�������customerService ����service��ʹ��@Service����customerService����һ��
      System.out.println(customerService.getAllCustomer().get(0).getName());
      logger.info("test");
    /*  CustomerService TellerService= (CustomerService) ac.getBean("TellerService");
      System.out.println(TellerService);*/
  } 
}