package com.medipro.assgn.assgn.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.medipro.assgn.assgn.beans.Login;
import com.medipro.assgn.assgn.beans.Product;

@Repository
public class LoginDaoImpl implements LoginDao {

	
	@PersistenceContext
	private EntityManager em;
	
	
	@Transactional
	@Override
	public List<Login> getUser() {
		// TODO Auto-generated method stub
		String sql="Select t from Login t";
		Query qry=em.createQuery(sql);
		List<Login> userList=qry.getResultList();
		System.out.println(userList);
		return userList;
	}


//	@Transactional
//	@Override
//	public int addNewUser(Login login) {
//		// TODO Auto-generated method stub
//		em.persist(login);
//		return login.getId();
//	}
	
	@Transactional

	public int addNewUser(Login login) {
		// TODO Auto-generated method stub
		em.persist(login);
		return login.getId();
	}

	@Transactional
	public Login loginAdmin(int id, String password) {
		try {
		String jpql = "select a from Login a where id=:uid and a.password=:pwd";
		TypedQuery<Login> query = em.createQuery(jpql, Login.class);
		query.setParameter("uid", id);
		query.setParameter("pwd", password);
		Login login = query.getSingleResult();
		System.out.println("yes ");
		return login;
		}catch (Exception e) {
			return null;
		}
	}

	@Transactional
	@Override
	public List<Login> getUserProfile(int id) {
		// TODO Auto-generated method stub
		//select * from logins where id = 160;
		Query qry = em.createQuery("select l from Login l where l.id=:id");
		qry.setParameter("id", id);
		List<Login> login = qry.getResultList();
		return login;
	}
		
	@Transactional
	@Override
	public List UpdateName(String name,int id) {
		// TODO Auto-generated method stub
		//Product t = em.find(Product.class, pid);
		//update logins set name = 'Gnanmurthy' where id=160;
		Query query =em.createQuery("Update Login l set l.name=:name where l.lid=:id");
		query.setParameter("name",name);
		query.setParameter("id",id);
		query.executeUpdate();
		
		//qry.setParameter("name",name)"
		String sql1="Select t from Login t";
		Query qry1=em.createQuery(sql1);
		List ProductList=qry1.getResultList();
		return ProductList;
		
	}

	@Transactional
	@Override
	public void UpdateName(int Id,Login login) {
		// TODO Auto-generated method stub
		Login l = em.find(Login.class, Id);
		if(login.getName()!=null  ) {
		l.setName(login.getName());
		}
		if(login.getPassword()!=null ) {
		l.setPassword(login.getPassword());
		}
		if(login.getContact()!=0) {
		l.setContact(login.getContact());
		}
		em.merge(l);
		String sql1="Select t from Login t";
		Query qry1=em.createQuery(sql1);
		List ProductList=qry1.getResultList();
	}
	
//	@Transactional
//	public Admin loginAdmin(long adminId, String adminPassword) {
//
//		
//		//try {
//			String jpql = "select a from Admin a where a.adminId=:uid and a.adminPassword=:pwd";
//			TypedQuery<Admin> query = em.createQuery(jpql, Admin.class);
//			query.setParameter("uid", adminId);
//			query.setParameter("pwd", adminPassword);
//			Admin admin = query.getSingleResult();
//			System.out.println("yes ");
//			return admin;
////			}catch (Exception e) {
////				return null;
////			}
//		}
	
	


}
