package com.revature;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Driver {

   public static Logger logger = LogManager.getLogger(Driver.class);



    public static void main(String[] args){
        logger.info("Starting Application");
        Application.run();


    }


}
