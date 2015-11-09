/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beanstests;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.DisposableBean;

/**
 *
 * @author george
 */
public class HelloWorld implements DisposableBean {

    private static final Log LOG = LogFactory.getLog(HelloWorld.class);

    private String message;
    private String n;
    private String last;
    private String beanName;

    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("Your Message : " + message);
    }
    
    public void setName(String name) {
        n = name;
    }
    
    public String getName() {
        LOG.info("Name: " + n);
        return n;
    }

    public String getLast() {
        LOG.info("Last: " + last);
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
    
    public void init() {
        n = "Name by init method";
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    HelloWorld.this.destroy();
                } catch (Exception ex) {
                    Logger.getLogger(HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @Override
    public void destroy() throws Exception {
        LOG.info("+++++++++++++++ destroys the object +++++++++++++++ " + HelloWorld.this.beanName);
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
