package com.ldeng.domain.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.ldeng.domain.entity.CleaningUser;

public class CleaningUserRepository {

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	SessionFactory sessionFactory;

	public java.util.List<CleaningUser> getUserByName(String userName) {

		System.out.println("====================getting a call in repo=============");
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(CleaningUser.class);
		criteria.add(Restrictions.eq("username", userName));
		java.util.List<CleaningUser> cleaningUserList = criteria.list();
		session.close();
		return cleaningUserList;
	}

	public void saveCLeaningUser(CleaningUser cleaningUser) {
		System.out.println("====================getting a call in repo=============");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(cleaningUser);
		session.getTransaction().commit();
		session.close();
	}

}
