package com.medipro.assgn.assgn.dao;

import java.util.List;

import com.medipro.assgn.assgn.beans.Product;
import com.medipro.assgn.assgn.beans.Test;

public interface ProductDao {

	List<Product> listAllPrd();

	int addProduct(Product product);

	List<Product> ListAvaPrd();

	List<Product> delProduct(int pid);

	List<Product> editProduct(int pid, Product product);

	List<Product> toggleProduct(int pid);

	List<Product> toggleProductSecond(int pid);

	List Antibiotic();

	List INSULIN();

	List SYRUP();

	List getProduct(int id);

}
