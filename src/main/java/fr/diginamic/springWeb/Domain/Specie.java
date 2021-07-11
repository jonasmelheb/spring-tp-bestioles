package fr.diginamic.springWeb.Domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Specie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    @Column(name = "common_name")
    private String commonName;
    @Column(name = "latinName")
    private String latinName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public Specie(Long id, String commonName, String latinName) {
        super();
        this.id = id;
        this.commonName = commonName;
        this.latinName = latinName;
    }

    public Specie(String commonName, String latinName) {
        super();
        this.commonName = commonName;
        this.latinName = latinName;
    }

    public Specie() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Specie [id=" + id + ", commonName=" + commonName + ", latinName=" + latinName + "]";
    }


}
