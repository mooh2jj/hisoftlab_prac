package com.example.service.chart;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.CartDTO;
import com.example.service.CartService;

@Service
public class GoogleChartServiceImpl implements GoogleChartService {

	@Autowired
	CartService cartService;
	
	@Override
	public JSONObject getChartData() {
		List<CartDTO> items = cartService.cartMoney();
		System.out.println("items :" + items);
		// 리턴할 json 객체
		JSONObject data = new JSONObject();	// {}
		// json의 컬럼 객체
		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		// json 베열 객체
		JSONArray title = new JSONArray();
		col1.put("label", "상품명");
		col1.put("type", "string");
		col2.put("label", "금액");
		col2.put("type", "number");
		
		title.add(col1);
		title.add(col2);
		
		data.put("cols", title);
		
		JSONArray body = new JSONArray();	// rows
		for(CartDTO dto : items) {
			JSONObject name = new JSONObject();
			name.put("v", dto.getProduct_name());	// 상품명
			JSONObject money = new JSONObject();
			money.put("v", dto.getMoney());		// 금액 
			
			JSONArray row = new JSONArray();
			row.add(name);
			row.add(money);
			
			JSONObject cell = new JSONObject();
			cell.put("c", row);
			body.add(cell);			// 레코드 1개 추가
		}
		data.put("rows", body);
		
		return data;
	}

}
