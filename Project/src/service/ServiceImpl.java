package service;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ServiceImpl {
	public void revise(HttpServletRequest request,  HttpServletResponse response) throws NamingException, Exception;
}
