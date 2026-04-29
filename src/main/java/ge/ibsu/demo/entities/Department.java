package ge.ibsu.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name="departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="department_id")
    private Long id;

    @Column(name="department_name")
    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return departmentName;
    }

    public void setName(String name) {
        this.departmentName = departmentName;
    }

    public Location getLocation() { return location; }

    public void setLocation(Location location) { this.location = location; }

    public Employee getManager() { return manager; }

    public void setManager(Employee manager) { this.manager = manager; }
}

