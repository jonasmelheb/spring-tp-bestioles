package fr.diginamic.springWeb.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private Integer age;
    @ManyToMany
    @JoinTable(name = "person__animal", joinColumns = @JoinColumn(name = "PERSON_ID"), inverseJoinColumns = @JoinColumn(name = "ANIMAL_ID"))
    Set<Animal> animals = new HashSet<Animal>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person(Long id, String firstname, String lastname, Integer age, Set<Animal> animals) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.animals = animals;
    }

    public Person() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age
                + ", animals=" + animals + "]";
    }

}
