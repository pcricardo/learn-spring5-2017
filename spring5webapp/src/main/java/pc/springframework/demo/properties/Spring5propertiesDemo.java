package pc.springframework.demo.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import pc.springframework.demo.properties.examplebeans.FakeDataSource;
import pc.springframework.demo.properties.examplebeans.FakeJmsBroker;

@SpringBootApplication
public class Spring5propertiesDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Spring5propertiesDemo.class, args);

        System.out.println("test FakeDataSource");
        FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean("fakeDataSource");
        System.out.println(fakeDataSource);

        System.out.println("Test FakeDataSource with environment vars");
        FakeDataSource fakeDataSourceEnv = (FakeDataSource) ctx.getBean("fakeDataSourceEnv");
        System.out.println(fakeDataSourceEnv);

        System.out.println("Test FakeJmsBroker");
        FakeJmsBroker fakeJmsBroker = (FakeJmsBroker) ctx.getBean(FakeJmsBroker.class);
        System.out.println(fakeJmsBroker);
    }


}
