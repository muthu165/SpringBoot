package demo;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(scopeName = "prototype")
public class Doctor implements Staff, BeanNameAware {
    @Override
    public String toString() {
        return "Doctor{" +
                "qualification='" + qualification + '\'' +
                '}';
    }

    private String qualification;
//
//    public Doctor(String qualification) {
//        this.qualification = qualification;
//    }
    public void assist(){
        System.out.println("Assisted by doc muthu!");
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("Set bean name method is called");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("PostConstruct method is called");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("PreDestroy method is called");
    }
}
