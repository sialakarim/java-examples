package org.supcom.javase.managers;

import org.supcom.javase.models.City;
import org.supcom.javase.models.Country;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public class CityManager extends BaseManager<Integer,City> {
    @Inject
    @PersistenceContext(name = "world")
    private EntityManager entityManager;

    @Inject
    private CountryManager manager;

    public CityManager() {
        super(City.class);
    }

    public List<City> findByName(String name){
        TypedQuery<City> query = entityManager.createNamedQuery("findByName",City.class);
        query.setParameter("name",name);
        return query.getResultList();
    }

    public List<City> findByCountryCode(String countryCode){
        Country country= manager.findById(countryCode);
        if(country==null){
            return null ;
        }
        TypedQuery<City> query = entityManager.createNamedQuery("findByCountryCode",City.class);
        query.setParameter("country",country);
        return query.getResultList();
    }
    @Transactional
    public void editCity(City city){
        final City managed = entityManager.find(City.class,city.getId());
        if(managed==null){
            throw new IllegalArgumentException("There is no record in database");
        }
        if(!managed.equals(city)){
            managed.setName(city.getName());
            managed.setPopulation(city.getPopulation());
            managed.setDistrict(city.getDistrict());
            managed.setCountryCode(city.getCountryCode());
        }
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
