package org.iscas.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.iscas.entity.Holding;
import org.iscas.util.ServiceInvoke;

/**
 * Created by Summer on 2016/11/14.
 */
public class HoldingService {
	public List<Holding> getHoldings(String userid, String uuid) throws IOException {
		// 调用Account服务获取相关信息
		InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties");
		Properties properties = new Properties();
		properties.load(in);
		String holdingServiceIP = properties.getProperty("holding.services.ip");
		String holdingServicePort = properties.getProperty("holding.services.port");
		// String holdingServiceIP = "133.133.133.67";
		// String holdingServicePort = "8084";
		ServiceInvoke tradeServiceInvoke = new ServiceInvoke();
		// 调用holding服务
		String holdingDataBeanResponse = tradeServiceInvoke.doGetCall(
				"http://" + holdingServiceIP + ":" + holdingServicePort + "/holding/query/" + userid, "uuid=" + uuid);
		ObjectMapper tradeObjectMapper = new ObjectMapper();
		Holding[] holdingsArray = tradeObjectMapper.readValue(holdingDataBeanResponse, Holding[].class);

		List<Holding> holdings = new ArrayList<Holding>();
		for (Holding holding : holdingsArray) {
			holdings.add(holding);
		}
		return holdings;
	}

	public Holding getHoldingByHoldingID(String holdingID, String uuid)
			throws JsonParseException, JsonMappingException, IOException {

		InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties");
		Properties properties = new Properties();
		properties.load(in);
		String holdingServiceIP = properties.getProperty("holding.services.ip");
		String holdingServicePort = properties.getProperty("holding.services.port");

		ServiceInvoke tradeServiceInvoke = new ServiceInvoke();
		// 调用holding服务
		String holdingDataBeanResponse = tradeServiceInvoke.doGetCall(
				"http://" + holdingServiceIP + ":" + holdingServicePort + "/holding/queryByHoldingID/" + holdingID,
				"uuid=" + uuid);
		ObjectMapper tradeObjectMapper = new ObjectMapper();
		Holding holding = tradeObjectMapper.readValue(holdingDataBeanResponse, Holding.class);

		return holding;
	}
}
