package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Doctor doctor = context.getBean(Doctor.class);
        doctor.assist();
        doctor.setQualification("MBBS");
        System.out.println(doctor);
        System.out.println(doctor.getQualification());
        Nurse nurse = (Nurse) context.getBean("nurse");
        nurse.assist();

        Doctor doctor1 = context.getBean(Doctor.class);
        doctor1.assist();
        System.out.println(doctor1);
//
//        System.out.println(doctor.getQualification());

    }
}
