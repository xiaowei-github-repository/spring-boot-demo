package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.fabric.xmlrpc.base.Array;

@Controller
@RequestMapping("/page")
public class HtmlController {

	private Logger logger = LoggerFactory.getLogger(HtmlController.class);

	@GetMapping("/index")
	public String index(Model model) {

		logger.debug("index");

		model.addAttribute("info", "You are good !");

		List<String> nameList = new ArrayList<>();
		nameList.add("xiaoming");
		nameList.add("tianming");
		model.addAttribute("nameList", nameList);
		
		System.out.println("index");

		return "index";
	}

}
