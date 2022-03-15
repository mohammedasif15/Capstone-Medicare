package com.medipro.assgn.assgn.dao;

import java.util.List;

import com.medipro.assgn.assgn.beans.Test;

public interface TestDao {

	List<Test> listAllTest();

	Test addTest(Test t);

	void deleteTest(int did);

	void updateTopic(Test t);

	Test findTest(int did);

	List<Test> login(Test t);

	List<Test> loginTwo(int id, String name);

	
}
