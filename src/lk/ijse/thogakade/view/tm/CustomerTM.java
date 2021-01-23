package lk.ijse.thogakade.view.tm;

import com.jfoenix.controls.JFXButton;

public class CustomerTM {
    private int id;
    private String name;
    private String address;
    private String salary;
    private JFXButton jfxButton;

    public CustomerTM() {
    }

    public CustomerTM(int id, String name, String address, String salary, JFXButton jfxButton) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jfxButton = jfxButton;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public JFXButton getJfxButton() {
        return jfxButton;
    }

    public void setJfxButton(JFXButton jfxButton) {
        this.jfxButton = jfxButton;
    }

    @Override
    public String toString() {
        return "CustomerTM{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary='" + salary + '\'' +
                ", jfxButton=" + jfxButton +
                '}';
    }
}
