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
import org.hibernate.criterion.Order;

/**
 *
 * @author diego
 */
public abstract class Repository<T extends Object> {

    public abstract Class getEntityClass();

    public Order getDefaultOrder() {
        return Order.desc("id");
    }

    public T load(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction t = session.beginTransaction();

        try {
            T result = (T) session.load(getEntityClass(), id);

            t.commit();

            return result;
        } catch (Exception e) {
            t.rollback();

            throw e;
        }

    }

    public T get(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction t = session.beginTransaction();

        try {
            T result = (T) session.get(getEntityClass(), id);

            t.commit();

            return result;
        } catch (Exception e) {
            t.rollback();

            throw e;
        }

    }

    public void delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction t = session.beginTransaction();

        try {
            T result = (T) session.get(getEntityClass(), id);

            session.delete(result);

            t.commit();
        } catch (Exception e) {
            t.rollback();

            throw e;
        }

    }

    public void delete(T entity) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction t = session.beginTransaction();

        try {
            session.delete(entity);

            t.commit();
        } catch (Exception e) {
            t.rollback();

            throw e;
        }
    }

    public void save(T entity) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction t = session.beginTransaction();

        try {
            session.saveOrUpdate(entity);

            t.commit();
        } catch (Exception e) {
            t.rollback();

            throw e;
        }
    }

    public List<T> listAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction t = session.beginTransaction();

        try {
            Criteria c
                    = session.createCriteria(getEntityClass());

            c.addOrder(getDefaultOrder());
            List<T> result = c.list();

            t.commit();

            return result;

        } catch (Exception e) {
            t.rollback();

            throw e;
        }
    }

    protected DetachedCriteria createCriteria() {
        final DetachedCriteria criteria = DetachedCriteria.forClass(getEntityClass());
        criteria.addOrder(getDefaultOrder());
        return criteria;
    }

    public List<T> listByCriteria(DetachedCriteria criteria) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction t = session.beginTransaction();

        try {
            List<T> result = criteria.getExecutableCriteria(session).list();

            t.commit();

            return result;

        } catch (Exception e) {
            t.rollback();

            throw e;
        }
    }

}
