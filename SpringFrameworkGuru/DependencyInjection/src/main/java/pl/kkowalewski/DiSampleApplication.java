package pl.kkowalewski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import pl.kkowalewski.controllers.MyController;
import pl.kkowalewski.exampleBeans.FakeDataSource;
import pl.kkowalewski.exampleBeans.FakeJmsBroker;

@SpringBootApplication
public class DiSampleApplication {

    /*------------------------ FIELDS REGION ------------------------*/

    /*------------------------ METHODS REGION ------------------------*/
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DiSampleApplication.class, args);
        MyController myController = (MyController) ctx.getBean("myController");

//        System.out.println(myController.sayHello());
//        System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
//        System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
//        System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());

        FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getUser());

        FakeJmsBroker fakeJmsBroker = (FakeJmsBroker) ctx.getBean(FakeJmsBroker.class);
        System.out.println(fakeJmsBroker.getUser());
    }
}
