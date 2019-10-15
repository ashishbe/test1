package com.test.aj.dao;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.test.aj.Model.Employee;

@Repository
public class EmployeeDAO {

	
	HibernateTemplate HTemplet;
	
	public EmployeeDAO() {
		// TODO Auto-generated constructor stub
	}

	public HibernateTemplate getHTemplet() {
		return HTemplet;
	}

	public void setHTemplet(HibernateTemplate hTemplet) {
		HTemplet = hTemplet;
	}
	
	
	public void saveEmploeedao(Employee e)
	{
		HTemplet.save(e);
	}
}
