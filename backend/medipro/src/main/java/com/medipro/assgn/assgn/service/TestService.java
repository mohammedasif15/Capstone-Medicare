package com.medipro.assgn.assgn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;

import com.medipro.assgn.assgn.beans.Test;
import com.medipro.assgn.assgn.dao.TestDao;

public interface TestService {
	
	public List<Test> listAllTest();

	public Test addTest(Test t);

	public void updateTopic(Test t);

	public void deleteTest(int did);

	public Test findTest(int did);
	public List<Test> loginTwo(int id, String name);

	
	
	

}
