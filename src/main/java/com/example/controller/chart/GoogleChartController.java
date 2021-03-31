package com.example.controller.chart;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.service.chart.GoogleChartService;


@RestController
@RequestMapping("/chart/*")
public class GoogleChartController {

	@Autowired
	GoogleChartService googleChartService;
	
	@RequestMapping("chart1.do")
	public ModelAndView chart1() {
		return new ModelAndView("chart/chart01");
	}
	
	@RequestMapping("chart2.do")
	public ModelAndView chart2() {
		return new ModelAndView("chart/chart02");
	}
	
	@RequestMapping("cart_money_list.do")
	public JSONObject chart_money_list() {
		return googleChartService.getChartData();
	}
}

