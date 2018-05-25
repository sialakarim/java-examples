package org.supcom.javase.managers;


import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

@Interceptor
@Transactional
public class TransactionManager {

    @AroundInvoke
    public Object runTransaction(InvocationContext invocationContext) throws Exception {
        EntityManager em = EntityManagerProvider.getEntityManager(invocationContext.getTarget().getClass());
        EntityTransaction tx = em.getTransaction();
        boolean act = !tx.isActive();
        if (act){
            tx.begin();
        }
        try {
            Object result = invocationContext.proceed();
            if (act) {
                tx.commit();
            }
            return result;
        } catch (Exception e) {
            if (act) {
                tx.rollback();
            }
            throw e;
        }
    }
}
