package com.medipro.assgn.assgn.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.medipro.assgn.assgn.beans.Login;
import com.medipro.assgn.assgn.beans.Product;
import com.medipro.assgn.assgn.beans.Test;

@Repository
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	@Override
	public List<Product> listAllPrd() {
		// TODO Auto-generated method stub
		String sql="Select t from Product t ";
		Query qry=em.createQuery(sql);
		List<Product> ProductList=qry.getResultList();
		return ProductList;
		
	}
	
	@Transactional
	@Override
	public List<Product> ListAvaPrd() {
		// TODO Auto-generated method stub
		String sql="Select t from Product t where t.status='A' ";
		Query qry=em.createQuery(sql);
		List<Product> ProductList=qry.getResultList();
		return ProductList;
		
	}

	@Transactional
	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		em.merge(product);
		return product.getPid();
	}

	@Transactional
	@Override
	public List<Product> delProduct(int pid) {
		// TODO Auto-generated method stub
		Product t = em.find(Product.class, pid);
		em.remove(t);
		String sql="Select t from Product t ";
		Query qry=em.createQuery(sql);
		List<Product> ProductList=qry.getResultList();
		return ProductList;
		
	}
	
	@Transactional
	@Override
	public List<Product> editProduct(int pid, Product product) {
		// TODO Auto-generated method stub
		Product t = em.find(Product.class, pid);
		if(t!=null)
		em.merge(product);

		String sql="Select t from Product t";
		Query qry=em.createQuery(sql);
		List<Product> ProductList=qry.getResultList();
		return ProductList;
		
	}
	
	@Transactional
	@Override
	public List<Product> toggleProduct(int pid) {
		// TODO Auto-generated method stub
		//Product t = em.find(Product.class, pid);
		Query query =em.createQuery("Update Product t set t.status='A' where pid=:pid ");
		query.setParameter("pid",pid);
		query.executeUpdate();
		
		//qry.setParameter("name",name)"
		String sql1="Select t from Product t";
		Query qry1=em.createQuery(sql1);
		List<Product> ProductList=qry1.getResultList();
		return ProductList;
		
	}

	@Transactional
	@Override
	public List<Product> toggleProductSecond(int pid) {
		// TODO Auto-generated method stub
		Query query =em.createQuery("Update Product t set t.status='N' where pid=:pid ");
		query.setParameter("pid",pid);
		query.executeUpdate();
		
		//qry.setParameter("name",name)"
		String sql1="Select t from Product t";
		Query qry1=em.createQuery(sql1);
		List<Product> ProductList=qry1.getResultList();
		return ProductList;

	}
	
	
	//categories
	
	@Transactional
	@Override
	public List Antibiotic() {
		// TODO Auto-generated method stub
		//select * from medical_products where ptype = 'Antibiotic';
		Query qry = em.createQuery("select c from Product c where ptype='Antibiotic'"); 
		List ProductList=qry.getResultList();
		return ProductList;
	}
	
	@Transactional
	@Override
	public List INSULIN() {
		// TODO Auto-generated method stub
		//select * from medical_products where ptype = 'Insulin';
		Query qry = em.createQuery("select c from Product c where ptype='Insulin'"); 
		List ProductList=qry.getResultList();
		return ProductList;
	}


	@Transactional
	@Override
	public List SYRUP() {
		// TODO Auto-generated method stub
		//select * from medical_products where ptype = 'Syrup';
		Query qry = em.createQuery("select c from Product c where ptype='Syrup'"); 
		List ProductList=qry.getResultList();
		return ProductList;
	}

	@Override
	public List getProduct(int id) {
		// TODO Auto-generated method stub
		Product p = em.find(Product.class, id);
		
		Query qry =  em.createQuery("select p from Products where pid=:id");
		
		
		return null;
	}
	
	

}
