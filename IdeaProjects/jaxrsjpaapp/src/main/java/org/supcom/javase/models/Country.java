package org.supcom.javase.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@AttributeOverride(name="id",column = @Column(name="Code"))
@NamedQueries(
        {@NamedQuery(name = "findByCountryName",query = "SELECT c from Country c where c.name=:name"),
                @NamedQuery(name = "findByContinent", query = "SELECT c from Country c where c.continent=:continent")}
)
@XmlRootElement
public class Country extends BaseEntity<String> {
    @Column(name = "Name")
    @Size(min=3,max=52)
    private String name ;

    @Column(name="Continent")
    @Enumerated(EnumType.STRING)
    private Continent continent;

    @Column(name = "Region")
    @Size(min=3,max=26)
    private String region ;

    @Column(name="SurfaceArea")
    private Double surfaceArea;

    @Column(name="Population")
    @Size(min=1,max=11)
    private Integer population;

    @Column(name="LifeExpectancy")
    private Double lifeExpectancy;

    @Column(name="GNP")
    private Double gnp;

    @Column(name="IndepYear")
    @Size(min=4,max=6)
    private Short indepYear;

    @Column(name="GNPOld")
    private Double gnpOld;

    @Column(name = "LocalName")
    @Size(min=3,max=45)
    private String localName ;

    @Column(name = "GovernmentForm")
    @Size(min=3,max=45)
    private String governmentForm ;

    @Column(name = "HeadOfState")
    @Size(min=3,max=60)
    private String headOfState ;

    @OneToOne
    @JoinColumn(name="Capital")
    private City capital;

    @Column(name = "Code2")
    @Size(min=2,max=2)
    private String code2 ;


    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(Double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public Double getGnp() {
        return gnp;
    }

    public void setGnp(Double gnp) {
        this.gnp = gnp;
    }

    public Short getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(Short indepYear) {
        this.indepYear = indepYear;
    }

    public Double getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(Double gnpOld) {
        this.gnpOld = gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }
}
