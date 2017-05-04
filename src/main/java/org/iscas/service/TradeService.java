package org.iscas.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.codehaus.jackson.map.ObjectMapper;
import org.iscas.databean.AccountDataBean;
import org.iscas.databean.MarketSummaryDataBean;
import org.iscas.databean.OrderBean;
import org.iscas.util.ServiceInvoke;

/**
 * Created by Summer on 2016/11/14.
 */

// 调用其他services获取home页面的信息

public class TradeService {

	// @Autowired
	// private Environment env;//读取配置文件中的信息，application.properties

	public AccountDataBean getAccountDataBean(String userid, String uuid) throws IOException {
		// 调用Account服务获取相关信息
		InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties");
		Properties properties = new Properties();
		properties.load(in);
		String tradeServiceIP = properties.getProperty("trade.services.ip");
		String tradeServicePort = properties.getProperty("trade.services.port");
		// String tradeServiceIP = "133.133.133.67";
		// String tradeServicePort = "8081";
		ServiceInvoke tradeServiceInvoke = new ServiceInvoke();
		// 调用account服务的getAccount
		String accountDataBeanResponse = tradeServiceInvoke.doGetCall(
				"http://" + tradeServiceIP + ":" + tradeServicePort + "/trade/accountDataBean/" + userid,
				"uuid=" + uuid);
		// System.out.println("AccountDataBean: " + accountDataBeanResponse);
		ObjectMapper tradeObjectMapper = new ObjectMapper();
		AccountDataBean accountDataBean = tradeObjectMapper.readValue(accountDataBeanResponse, AccountDataBean.class);

		return accountDataBean;
	}

	public MarketSummaryDataBean getMarketSummary(String uuid) throws IOException {
		// 调用Account服务获取相关信息
		InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties");
		Properties properties = new Properties();
		properties.load(in);
		String tradeServiceIP = properties.getProperty("trade.services.ip");
		String tradeServicePort = properties.getProperty("trade.services.port");
		// String tradeServiceIP = "133.133.133.67";
		// String tradeServicePort = "8081";
		ServiceInvoke tradeServiceInvoke = new ServiceInvoke();
		// 调用account服务的getAccount
		String accountDataBeanResponse = tradeServiceInvoke.doGetCall(
				"http://" + tradeServiceIP + ":" + tradeServicePort + "/trade/marketSummary/", "uuid=" + uuid);
		ObjectMapper tradeObjectMapper = new ObjectMapper();
		MarketSummaryDataBean marketSummaryDataBean = tradeObjectMapper.readValue(accountDataBeanResponse,
				MarketSummaryDataBean.class);

		return marketSummaryDataBean;
	}

	public OrderBean buy(String symbol, String quantity, String userid, String uuid) throws IOException {
		// 调用Account服务获取相关信息
		InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties");
		Properties properties = new Properties();
		properties.load(in);
		String tradeServiceIP = properties.getProperty("trade.services.ip");
		String tradeServicePort = properties.getProperty("trade.services.port");
		// String tradeServiceIP = "133.133.133.67";
		// String tradeServicePort = "8081";
		ServiceInvoke tradeServiceInvoke = new ServiceInvoke();
		// 调用account服务的getAccount
		String orderBeanResponse = tradeServiceInvoke.doPostCall(
				"http://" + tradeServiceIP + ":" + tradeServicePort + "/trade/buy/" + symbol,
				"quantity=" + quantity + "&userid=" + userid + "&uuid=" + uuid);
		ObjectMapper tradeObjectMapper = new ObjectMapper();
		OrderBean orderBean = tradeObjectMapper.readValue(orderBeanResponse, OrderBean.class);

		return orderBean;
	}

	public OrderBean sell(String userid, String symbol, String uuid) throws IOException {
		// 调用Account服务获取相关信息
		InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties");
		Properties properties = new Properties();
		properties.load(in);
		String tradeServiceIP = properties.getProperty("trade.services.ip");
		String tradeServicePort = properties.getProperty("trade.services.port");
		// String tradeServiceIP = "133.133.133.67";
		// String tradeServicePort = "8081";
		ServiceInvoke tradeServiceInvoke = new ServiceInvoke();
		// 调用account服务的getAccount
		String orderBeanResponse = tradeServiceInvoke.doPostCall(
				"http://" + tradeServiceIP + ":" + tradeServicePort + "/trade/sell/" + symbol,
				"userid=" + userid + "&uuid=" + uuid);
		ObjectMapper tradeObjectMapper = new ObjectMapper();
		OrderBean orderBean = tradeObjectMapper.readValue(orderBeanResponse, OrderBean.class);

		return orderBean;
	}
}
