package com.pm.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
	@GetMapping("/error")
	public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		if(status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			
			if(statusCode == HttpStatus.NOT_FOUND.value()) {
				return "error404";
			}
			else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "error500";
			}
			else if(statusCode == HttpStatus.FORBIDDEN.value()) {
				return "error403";
			}
		}
		
		return "error";
	}
	
	public String getErrorPath() {
		return "/error";
	}

}
