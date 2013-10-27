/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.controller;

import com.myprojects.myworld.exception.PlatformException;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author srividyak
 */
@Controller
public class BaseController {
    
    /**
     * statusCode 1
     * @param ex
     */
    @ExceptionHandler(HibernateException.class)
    @ResponseBody
    public Map<String,Object> handleHibernateException(HibernateException ex) {
        return getResponse(1, ex.getMessage());
    }
    
    /**
     * statusCode 2
     * @param ex
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Map<String,Object> handleContraintViolationException(ConstraintViolationException ex) {
        return getResponse(2, ex.getMessage());
    }
    
    /**
     * statusCode 3
     * @param ex
     * @throws PlatformException 
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> handleGenericException(Exception ex) {
        return getResponse(3, ex.getMessage());
    }
    
    private Map<String, Object> getResponse(int statusCode, String msg) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("statusCode", statusCode);
        response.put("errorMessage", msg);
        return response;
    }
    
    @ExceptionHandler(PlatformException.class)
    @ResponseBody
    public Map<String, Object> handlePlatformException(PlatformException ex) {
        return getResponse(ex.getStatusCode(), ex.getCustomMsg());
    }
}
