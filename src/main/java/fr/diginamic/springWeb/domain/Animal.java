package fr.diginamic.springWeb.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    @Column
    private String name;
    @Column
    private String color;
    @Column
    private String sex;
    @ManyToOne
    @JoinColumn(name = "ID_SPECIE")
    Specie specie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Specie getSpecie() {
        return specie;
    }

    public void setSpecie(Specie specie) {
        this.specie = specie;
    }

    public Animal(Long id, String name, String color, String sex, Specie specie) {
        super();
        this.id = id;
        this.name = name;
        this.color = color;
        this.sex = sex;
        this.specie = specie;
    }

    public Animal() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Animal [id=" + id + ", name=" + name + ", color=" + color + ", sex=" + sex + ", specie=" + specie + "]";
    }

}
