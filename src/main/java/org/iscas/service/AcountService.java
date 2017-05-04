package org.iscas.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.iscas.databean.AccountBean;
import org.iscas.entity.Account;
import org.iscas.entity.AccountProfile;
import org.iscas.util.ServiceInvoke;

/**
 * Created by Summer on 2016/11/11. 封装请求Acount微服务的API web层调用Acount服务的API
 */

public class AcountService {

	// String accountServiceIP = "";
	// String accountServicePort = "";

	// private Environment env;

	public String getResource() {
		// HttpClient client = new DefaultHttpClient();
		System.out.print("welcome");
		return "welcome";
	}

	// public boolean login(String userid, String passwd) throws IOException {
	public boolean login(String userid, String passwd, String uuid) throws IOException {
		// 调用Account服务获取相关信息
		InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties");
		Properties properties = new Properties();
		properties.load(in);
		String accountServiceIP = properties.getProperty("account.services.ip");
		String accountServicePort = properties.getProperty("account.services.port");
		// String accountServiceIP = "133.133.133.67";
		// String accountServicePort = "8085";
		ServiceInvoke accountServiceInvoke = new ServiceInvoke();
		// 调用account服务的getAccount
		String accountResponse = accountServiceInvoke.doPostCall(
				"http://" + accountServiceIP + ":" + accountServicePort + "/account/login",
				"userid=" + userid + "&password=" + passwd + "&uuid=" + uuid);
		// System.out.println("accountResponse: " + accountResponse);
		if (accountResponse == null || accountResponse.equals("")) {// 验证身份失败
			return false;
		}
		return true;
	}

	// Regist Acount
	public AccountBean register(String userID, String password, String cpassword, String fullname, String address,
			String email, String creditcard, String openBalance, String uuid)
			throws JsonParseException, JsonMappingException, IOException {
		// 验证acount微服务是否是可用状态
		InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties");
		Properties properties = new Properties();
		properties.load(in);
		String accountServiceIP = properties.getProperty("account.services.ip");
		String accountServicePort = properties.getProperty("account.services.port");
		ServiceInvoke accountServiceInvoke = new ServiceInvoke();
		// 调用account服务的register
		String accountResponse = accountServiceInvoke.doPostCall(
				"http://" + accountServiceIP + ":" + accountServicePort + "/account/register",
				"fullname=" + fullname + "&address=" + address + "&email=" + email + "&userID=" + userID + "&password="
						+ password + "&cpassword=" + cpassword + "&creditcard=" + creditcard + "&openBalance="
						+ openBalance + "&uuid=" + uuid);

		ObjectMapper tradeObjectMapper = new ObjectMapper();
		AccountBean accountBean = tradeObjectMapper.readValue(accountResponse, AccountBean.class);

		return accountBean;
	}

	// logout Acount
	public AccountBean logout(String userID, String uuid) throws JsonParseException, JsonMappingException, IOException {
		// 验证acount微服务是否是可用状态
		InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties");
		Properties properties = new Properties();
		properties.load(in);
		String accountServiceIP = properties.getProperty("account.services.ip");
		String accountServicePort = properties.getProperty("account.services.port");
		ServiceInvoke accountServiceInvoke = new ServiceInvoke();
		// 调用account服务的register
		String accountResponse = accountServiceInvoke.doPostCall(
				"http://" + accountServiceIP + ":" + accountServicePort + "/account/logout/" + userID, "uuid=" + uuid);

		ObjectMapper tradeObjectMapper = new ObjectMapper();
		AccountBean accountBean = tradeObjectMapper.readValue(accountResponse, AccountBean.class);

		return accountBean;
	}

	// query Account
	public Account getAccountByUserID(String userid, String uuid)
			throws JsonParseException, JsonMappingException, IOException {
		// 验证acount微服务是否是可用状态
		InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties");
		Properties properties = new Properties();
		properties.load(in);
		String accountServiceIP = properties.getProperty("account.services.ip");
		String accountServicePort = properties.getProperty("account.services.port");
		ServiceInvoke accountServiceInvoke = new ServiceInvoke();
		// 调用account服务的register
		String accountResponse = accountServiceInvoke.doGetCall(
				"http://" + accountServiceIP + ":" + accountServicePort + "/account/query/" + userid, "uuid=" + uuid);

		ObjectMapper tradeObjectMapper = new ObjectMapper();
		Account account = tradeObjectMapper.readValue(accountResponse, Account.class);

		return account;
	}

	public AccountProfile getAccountProfileByUserID(String userid, String uuid)
			throws JsonParseException, JsonMappingException, IOException {
		// 验证acount微服务是否是可用状态
		InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties");
		Properties properties = new Properties();
		properties.load(in);
		String accountServiceIP = properties.getProperty("account.services.ip");
		String accountServicePort = properties.getProperty("account.services.port");
		ServiceInvoke accountServiceInvoke = new ServiceInvoke();
		// 调用account服务的register
		String accountResponse = accountServiceInvoke.doGetCall(
				"http://" + accountServiceIP + ":" + accountServicePort + "/account/queryAccountProfile/" + userid,
				"uuid=" + uuid);

		ObjectMapper tradeObjectMapper = new ObjectMapper();
		AccountProfile accountProfile = tradeObjectMapper.readValue(accountResponse, AccountProfile.class);

		return accountProfile;
	}

	// Account managed services
	public String manage() {

		return "test";
	}

	// update Account
	public String update() {

		return "test";
	}

	// delete Account
	public String delete() {

		return "success";
	}

}
