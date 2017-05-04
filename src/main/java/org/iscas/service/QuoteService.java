package org.iscas.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.iscas.databean.QuoteBean;
import org.iscas.util.ServiceInvoke;

/**
 * Created by andyren on 2016/10/25.
 */
public class QuoteService {

	public QuoteBean getQuote(String symbol, String uuid) throws JsonParseException, JsonMappingException, IOException {
		// 调用Quote服务获取相关信息
		InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties");
		Properties properties = new Properties();
		properties.load(in);
		String quoteServiceIP = properties.getProperty("quote.services.ip");
		String quoteServicePort = properties.getProperty("quote.services.port");
		// String quoteServiceIP = "133.133.133.67";
		// String quoteServicePort = "8082";
		ServiceInvoke quoteServiceInvoke = new ServiceInvoke();
		// 调用account服务的getAccount
		String quoteBeanResponse = quoteServiceInvoke.doGetCall(
				"http://" + quoteServiceIP + ":" + quoteServicePort + "/quote/query/" + symbol, "uuid=" + uuid);
		// System.out.println("AccountDataBean: " + accountDataBeanResponse);
		ObjectMapper quoteObjectMapper = new ObjectMapper();
		QuoteBean quoteBean = quoteObjectMapper.readValue(quoteBeanResponse, QuoteBean.class);

		return quoteBean;
	}

}
