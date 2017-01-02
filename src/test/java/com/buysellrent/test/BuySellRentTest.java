package com.buysellrent.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.buysellrent.DTO.User;
import com.buysellrent.domain.response.CheckCredentialResponse;
import com.buysellrent.exception.BussinesException;
import com.buysellrent.icontroller.IUserController;
import com.buysellrent.idao.IUserDAO;
import com.buysellrent.iservice.IUserService;


/**
 * 
 * @author taner cakiroglu
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/rest-servlet.xml"  })
public class BuySellRentTest {

	@Autowired
	private IUserDAO userDAO;

	@Autowired
	private IUserService userService;

	@Autowired
	private IUserController userController;

	@Test
	public void daoCheckCredentialTest() {
		User credential = new User();
		credential.setPassword("123*-+");
		credential.setEmail("merchant@test.com");
		boolean returnVal = userDAO.checkCredential(credential);
		assertEquals(returnVal, true);
	}
	
	@Test
	public void daoCheckCredentialTest1() {
		User credential = new User();
		credential.setPassword("123");
		credential.setEmail("merchant@test.com");
		boolean returnVal = userDAO.checkCredential(credential);
		assertEquals(returnVal, false);
	}

	@Test
	public void serviceCheckCredentialTest() {
		User credential = new User();
		credential.setPassword("123*-+");
		credential.setEmail("merchant@test.com");
		Object returnVal = userService.checkCredential(credential);
		assertTrue(returnVal instanceof CheckCredentialResponse);
	}
	
	@Test(expected=BussinesException.class)
	public void controllerCheckCredentialTest() throws BussinesException {
		User credential = new User();
		credential.setPassword(" ");
		credential.setEmail("merchant@test.com");
		Object returnVal = userController.checkCredentail(credential);
		assertTrue(returnVal instanceof String);
	}

	@Test(expected=BussinesException.class)
	public void controllerCheckCredentialTest1() throws BussinesException {
		User credential = new User();
		credential.setPassword("123*-+");
		credential.setEmail(null);
		Object returnVal = userController.checkCredentail(credential);
		assertTrue(returnVal instanceof String);
	}

}
