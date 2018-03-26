/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.repository;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author diego
 */
public abstract class Repository<T extends Object> {

    public abstract Class getEntityClass();

    public T load(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        T result = (T) session.load(getEntityClass(), id);

        session.getTransaction().commit();

        return result;
    }

    public T get(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        T result = (T) session.get(getEntityClass(), id);

        session.getTransaction().commit();

        return result;
    }

    public void delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        T result = (T) session.get(getEntityClass(), id);

        session.delete(result);

        session.getTransaction().commit();
    }

    public void delete(T entity) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        session.delete(entity);

        session.getTransaction().commit();
    }

    public void save(T entity) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        session.saveOrUpdate(entity);

        session.getTransaction().commit();
    }

    public List<T> listAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction t = session.beginTransaction();

        Criteria c
                = session.createCriteria(getEntityClass());

        List<T> result = c.list();

        t.commit();

        return result;
    }

    protected DetachedCriteria createCriteria() {
        return DetachedCriteria.forClass(getEntityClass());
    }

    public List<T> listByCriteria(DetachedCriteria criteria) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction t = session.beginTransaction();

        List<T> result = criteria.getExecutableCriteria(session).list();

        session.getTransaction().commit();

        return result;
    }

}
