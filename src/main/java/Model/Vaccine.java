package Model;

public class Vaccine {
    private String name;


    public Vaccine(String name) {
        this.name = name;
    }

    // 이게 getter
    public String getName() {
        return name;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vaccine{name='" + name + "'}";
    }
}
