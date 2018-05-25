package org.supcom.javase.managers;

import org.supcom.javase.models.Continent;
import org.supcom.javase.models.Country;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public class CountryManager extends BaseManager<String,Country> {
    @Inject
    @PersistenceContext(name = "world")
    private EntityManager entityManager;

    protected CountryManager() {
        super(Country.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
    public List<Country> findByName(String name){
        TypedQuery<Country> query = entityManager.createNamedQuery("findByCountryName",Country.class);
        query.setParameter("name",name);
        return query.getResultList();
    }

    public List<Country> findByContinent(Continent continent){
        TypedQuery<Country> query = entityManager.createNamedQuery("findByContinent",Country.class);
        query.setParameter("continent",continent);
        return query.getResultList();
    }

    @Transactional
    public void editCountry(Country country){
        final Country managed = entityManager.find(Country.class,country.getId());
        if(managed==null){
            throw new IllegalArgumentException("There is no record in database");
        }
        if(!managed.equals(country)){
            managed.setName(country.getName());
            managed.setPopulation(country.getPopulation());
            managed.setContinent(country.getContinent());
            managed.setRegion(country.getRegion());
            managed.setSurfaceArea(country.getSurfaceArea());
            managed.setIndepYear(country.getIndepYear());
            managed.setLifeExpectancy(country.getLifeExpectancy());
            managed.setGnp(country.getGnp());
            managed.setGnpOld(country.getGnpOld());
            managed.setLocalName(country.getLocalName());
            managed.setGovernmentForm(country.getGovernmentForm());
            managed.setHeadOfState(country.getHeadOfState());
            managed.setCapital(country.getCapital());
            managed.setCode2(country.getCode2());
        }
    }
}
