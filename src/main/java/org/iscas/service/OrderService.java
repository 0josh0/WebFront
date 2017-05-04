package org.iscas.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.iscas.entity.Orders;
import org.iscas.util.ServiceInvoke;

/**
 * Created by Summer on 2016/11/14.
 */
public class OrderService {

	// query Orders
	public List<Orders> getOrdersByUserID(String userid, String uuid)
			throws JsonParseException, JsonMappingException, IOException {
		// 验证acount微服务是否是可用状态
		InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties");
		Properties properties = new Properties();
		properties.load(in);
		String orderServiceIP = properties.getProperty("order.services.ip");
		String orderServicePort = properties.getProperty("order.services.port");

		// System.out.println("IP: " + orderServiceIP);
		// System.out.println("port: " + orderServicePort);

		ServiceInvoke orderServiceInvoke = new ServiceInvoke();
		// 调用account服务的register
		String orderResponse = orderServiceInvoke.doGetCall(
				"http://" + orderServiceIP + ":" + orderServicePort + "/orders/query/" + userid, "uuid=" + uuid);

		ObjectMapper tradeObjectMapper = new ObjectMapper();
		Orders[] orders = tradeObjectMapper.readValue(orderResponse, Orders[].class);

		List<Orders> list = new ArrayList<Orders>();
		for (Orders order : orders) {
			list.add(order);
		}

		return list;
	}
}
