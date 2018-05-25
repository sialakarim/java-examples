package org.supcom.javase.managers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@ApplicationScoped
@SuppressWarnings("unused")
public class EntityManagerProvider {
    private Logger log = Logger.getLogger(EntityManagerProvider.class.getName());

    private final static Map<String,EntityManagerFactory> emfs = new HashMap<>();
    private final static Map<String,String> beanToUnit = new HashMap<>();
    private final static ThreadLocal<Map<String,EntityManager>> ems = new ThreadLocal<>();

    @Produces
    @Dependent
    public EntityManager createEntityManager(InjectionPoint injectionPoint) {
        if(!injectionPoint.getAnnotated().isAnnotationPresent(PersistenceContext.class)){
            throw new IllegalStateException("Injected EntityManager must be annotated with " +
                    "@PersistenceContext with unitName specified!");
        }
        PersistenceContext persistenceContext = injectionPoint.getAnnotated().getAnnotation(PersistenceContext.class);
        EntityManagerFactory emf;
        final String unitName = persistenceContext.name();
        if(!emfs.containsKey(unitName)){
            emf = Persistence.createEntityManagerFactory(unitName);
            emfs.put(unitName,emf);
        }else{
            emf = emfs.get(unitName);
        }
        beanToUnit.put(injectionPoint.getBean().getBeanClass().getName(),unitName);
        EntityManager em = emf.createEntityManager();
        Map<String,EntityManager> map = ems.get();
        if(map==null){
            map = new HashMap<>();
            ems.set(map);
        }
        map.put(injectionPoint.getBean().getBeanClass().getName(),em);
        return em;
    }

    public void closeEM(@Disposes EntityManager manager) {
        if(manager.isOpen()){
            manager.close();
        }
    }

    public void closeEMF(EntityManagerFactory factory) {
        if(factory.isOpen()) {
            factory.close();
        }
    }

    /**
     * To use by TransactionManager
     * @param embClass The managed type of the entity class
     * @param <T> The actual entity class
     * @return The entity manager for tha
     */
    protected static <T> EntityManager getEntityManager(Class<T> embClass){
        int idx =embClass.getTypeName().indexOf('$');
        String key = embClass.getTypeName().substring(0,idx);
        Map<String,EntityManager> map = ems.get();
        if(map==null){
            map = new HashMap<>();
            ems.set(map);
        }
        if(!map.containsKey(key)){
            map.put(key,emfs.get(beanToUnit.get(key)).createEntityManager());
        }
        return map.get(key);
    }
}
