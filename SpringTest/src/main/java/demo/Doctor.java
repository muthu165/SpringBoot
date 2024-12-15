package demo;

public class Doctor implements Staff{
    private String qualification;

    public Doctor(String qualification) {
        this.qualification = qualification;
    }
    public void assist(){
        System.out.println("Assisted by doc muthu!");
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
