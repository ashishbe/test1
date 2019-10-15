package com.test.aj;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.test.aj.Model.Employee;
import com.test.aj.Model.Employee1;
import com.test.aj.dao.EmployeeDAO;

@Controller
public class HelloController {

	@Autowired
	@Qualifier("dEmpDAO")
	EmployeeDAO dEmpDAO;

	@RequestMapping(value = "/Login.ds")
	public ModelAndView firstrequest()
	{
		
		ModelAndView mv = new ModelAndView("select_form");
		mv.addObject("name", "ashish jain");
		System.out.println("first page");
		return mv;
	}
	
	@ModelAttribute
	public void init()
	{
		System.out.println("ashish");
	}
	
	@RequestMapping(value = "/select_form1.ds" , method = RequestMethod.GET)
	public ModelAndView loginrequest()
	{
		ModelAndView mv = new ModelAndView("loginform");
		mv.addObject("name", "ashish jain");
		return mv;
	}
	
	@RequestMapping(value = "/select_form2.ds" , method = RequestMethod.GET)
	public ModelAndView registerrequest()
	{
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("name", "ashish jain");
		return mv;
	}
	
	
	@RequestMapping(value = "/login1.ds" , method = RequestMethod.GET)
	public ModelAndView handle_login_request(@Valid  @ModelAttribute("employee1") Employee1 employee1 , BindingResult result )
	{

		if( result.hasErrors() )
		{
			ModelAndView mv = new ModelAndView("loginform");
			return mv;
		}
		
		SessionFactory sfactory = getsessionfactory();
		Session session = sfactory.openSession();
		
		Query query = session.createQuery("select name , password from Employee");
		
		List<Object> list = query.list();
		for(Object obj : list )
		{
			Object[] o = (Object[])obj;
			System.out.println("name = "+o[0]+"      "+"address = "+o[1]);
			
//			String name = req.getParameter("username");
//			
			if(o[0].equals(employee1.getUsername()) && o[1].equals(employee1.getPassword()))
			{
				ModelAndView mv = new ModelAndView("login_success");
				return mv;
			}
		}
		session.close();
		
		result.rejectValue("username", "error.employee1", "username or password not matched  try again.");
		
		ModelAndView mv = new ModelAndView("loginform");
		return mv;

	}
	
	@RequestMapping(value = "/register.ds" , method = RequestMethod.POST)
	public ModelAndView AddRegister(@Valid @ModelAttribute("employee") Employee employee , BindingResult result )
	{
		
		if( result.hasErrors())
		{
			ModelAndView mv = new ModelAndView("register");
			mv.addObject("name", "ashish jain");
			return mv;
		}
		
		ModelAndView mv = new ModelAndView("registration_success");
		
		SessionFactory sf = getsessionfactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee e = new Employee();
		e.setEmail(employee.getEmail());
		e.setName(employee.getName());
		e.setMobileno(employee.getMobileno());
		e.setPassword(employee.getPassword());
		
		dEmpDAO.saveEmploeedao(e);
		
//		session.save(e);
//		tx.commit();
//		session.close();
		
		
		System.out.println(employee.getName());
		
		return mv;
	}
	
	public static SessionFactory getsessionfactory()
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sfactory = (SessionFactory) cfg.buildSessionFactory();
		return sfactory;
	}
}
