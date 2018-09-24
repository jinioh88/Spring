package org.zrock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zrock.web.domain.ProductVO;

@Controller
public class SampleContrller2 {
	private static final Logger logger = LoggerFactory.getLogger(SampleContrller2.class); 
	
	@RequestMapping("/doD")
	public String doD(Model model) {
		ProductVO product = new ProductVO("Sample Product", 10000);
		logger.info("doD");
		model.addAttribute(product);
		
		return "productDetail";
	}
	
	@RequestMapping("doE")
	public String doE(RedirectAttributes rttr) {
		logger.info("doE");
		
		rttr.addFlashAttribute("msg","This is the Message!");
		return "redirect:/doF";
	}
	
	@RequestMapping("doF")
	public void doF(@ModelAttribute String msg) {
		logger.info("doF!!");
	}
	
	@RequestMapping("doJson")
	public @ResponseBody ProductVO doJson() {
		ProductVO vo  = new ProductVO("샘플상품", 30000);
		
		return vo;
	}
}
