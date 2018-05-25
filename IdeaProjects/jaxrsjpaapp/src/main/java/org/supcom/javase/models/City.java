package org.supcom.javase.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;


@Entity
@AttributeOverride(name ="id",column = @Column(name="ID"))
@NamedQueries(
        {@NamedQuery(name = "findByName",query = "SELECT c from City c where c.name=:name"),
                @NamedQuery(name = "findByCountryCode", query = "SELECT c from City c where c.country=:country")}
)
@XmlRootElement
public class City extends BaseEntity<Integer> {

    @Column(name = "Name")
    @Size(min = 2, max = 35)
    private String name;

    @ManyToOne
    @JoinColumn(name = "CountryCode",referencedColumnName = "Code",insertable = false,updatable = false)
    @NotNull
    private Country country;

    @Column(name="CountryCode")
    @Size(min=3,max=3)
    @NotNull
    private String countryCode;

    @Column(name = "District")
    @Size(min = 2, max = 20)
    private String district;

    @Column(name = "Population")
    @Size(min = 1, max = 11)
    private Integer population;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


}
