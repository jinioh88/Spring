package org.zrock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleContrller {
	private static final Logger logger = LoggerFactory.getLogger(SampleContrller.class); 
	
	@RequestMapping("doA") 
	public void doA() {
		logger.info("doA called!!");
	}
	
	@RequestMapping("doB")
	public void doB() {
		logger.info("doB called!!");
	}
	
	@RequestMapping("doC")
	public String doC(@ModelAttribute("msg") String msg) {
		logger.info("doC called!!");
		return "result";
	}
}
