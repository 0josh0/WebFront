package org.iscas.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iscas.util.GenerateUUID;
import org.iscas.util.Log;

/**
 * Created by Summer on 2016/11/17.
 */
// @WebServlet("/user")
public class AppServlet extends HttpServlet {

	// public void init(ServletConfig config) throws ServletException {
	// super.init(config);
	// java.util.Enumeration en = config.getInitParameterNames();
	// while (en.hasMoreElements()) {
	// String parm = (String) en.nextElement();
	// String value = config.getInitParameter(parm);
	// TradeConfig.setConfigParam(parm, value);
	// }
	// }

	@Override
	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws ServletException, IOException {

		// System.out.println("Do Get ^^^^^^");
		// doPost(request, response);

		performTask(request, response);
	}

	@Override
	protected void doPost(javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("Do POST ^^^^^^");
		//
		// request.setCharacterEncoding("UTF-8");
		// response.setContentType("text/html;charset=utf-8");
		//
		// String action = request.getParameter("action");
		// if ("login_input".equals(action)) {
		// request.getRequestDispatcher("/index.html").forward(request,
		// response);
		// } else if ("login".equals(action)) {
		// String name = request.getParameter("name");
		// String password = request.getParameter("password");
		//
		// System.out.println("name->" + name + ",password->" + password);
		// }

		performTask(request, response);
	}

	public void performTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println(">>>>>>>>>>doPost2()<<<<<<<<<<<");
		String action = null;
		String userID = null;
		resp.setContentType("text/html");

		AppServletAction appServletAction = new AppServletAction();
		action = req.getParameter("action");// 获取/app路径拦截请求的action类型
		ServletContext ctx = getServletConfig().getServletContext();

		if (action == null) {
			// System.out.println("正在跳转到welcome界面…………");

			// InputStream in =
			// getClass().getClassLoader().getResourceAsStream("application.properties");
			// Properties properties = new Properties();
			// properties.load(in);
			// System.out.println(properties.getProperty("account.services.ip"));
			// System.out.println(properties.getProperty("account.services.port"));

			// TradeService tradeService = new TradeService();
			// MarketSummaryDataBean marketSummaryDataBean =
			// tradeService.getMarketSummary();
			// Collection topGainers = marketSummaryDataBean.getTopGainers();
			// Iterator gainers = topGainers.iterator();
			// int count = 0;
			// while (gainers.hasNext() && (count++ < 5)) {
			//
			// JSONObject jsonObj = JSONObject.fromObject(gainers.next());
			// System.out.println(jsonObj.toString());
			// // 将返回的json封装成account对象
			// ObjectMapper accountObjectMapper = new ObjectMapper();
			// QuoteDataBean quoteDataBean =
			// accountObjectMapper.readValue(jsonObj.toString(),
			// QuoteDataBean.class);
			// System.out.println(quoteDataBean.getCompanyName());
			//
			// }

			appServletAction.doWelcome(ctx, req, resp, "", "");// 跳转到登录界面
			return;
		} else if (action.equals("login")) {
			// System.out.println("正在进行登录…………");
			userID = req.getParameter("uid");
			String passwd = req.getParameter("passwd");
			String uuid = GenerateUUID.getUUID();
			// System.out.println("usename: "+userID);
			try {
				// Log.log("Home:A->T->H、T->A->H->Q");
				appServletAction.doLogin(ctx, req, resp, userID, passwd, uuid);
			} catch (ServletException se) {
				appServletAction.doWelcome(ctx, req, resp, se.getMessage(), uuid);// 跳转到登录界面
			}
			return;
		} else if (action.equals("register")) {
			// System.out.println("正在进行注册新用户…………");
			String uuid = GenerateUUID.getUUID();
			userID = req.getParameter("user id");
			String passwd = req.getParameter("passwd");
			String cpasswd = req.getParameter("confirm passwd");
			String fullname = req.getParameter("Full Name");
			String ccn = req.getParameter("Credit Card Number");
			String money = req.getParameter("money");
			String email = req.getParameter("email");
			String smail = req.getParameter("snail mail");
			appServletAction.doRegister(ctx, req, resp, userID, passwd, cpasswd, fullname, ccn, money, email, smail,
					uuid);
			return;
		}

		HttpSession session = req.getSession();
		userID = (String) session.getAttribute("uidBean");

		if (userID == null) {
			System.out.println("TradeAppServlet service error: User Not Logged in");
			appServletAction.doWelcome(ctx, req, resp, "User Not Logged in", "");
			return;
		}

		if (action.equals("quotes")) {
			// System.out.println("正在跳转到quotes页面…………");
			String uuid = GenerateUUID.getUUID();
			String symbols = req.getParameter("symbols");
			System.out.println("symbols: " + symbols);
			Log.log("Quote/Trade:quote");
			appServletAction.doQuotes(ctx, req, resp, userID, symbols, uuid);
		} else if (action.equals("buy")) {
			// System.out.println("正在购买股票…………");
			String uuid = GenerateUUID.getUUID();
			String symbol = req.getParameter("symbol");
			String quantity = req.getParameter("quantity");
			Log.log("Trade:trade");
			appServletAction.doBuy(ctx, req, resp, userID, symbol, quantity, uuid);
		} else if (action.equals("sell")) {
			// System.out.println("正在抛售股票…………");
			String uuid = GenerateUUID.getUUID();
			int holdingID = Integer.parseInt(req.getParameter("holdingID"));
			Log.log("Trade:trade ");
			appServletAction.doSell(ctx, req, resp, userID, holdingID, uuid);
		} else if (action.equals("portfolio") || action.equals("portfolioNoEdge")) {
			// System.out.println("正在跳转到portfolio页面…………");
			String uuid = GenerateUUID.getUUID();
			Log.log("Portfolio:holding->quote");
			appServletAction.doPortfolio(ctx, req, resp, userID, "Portfolio as of " + new java.util.Date(), uuid);
		} else if (action.equals("logout")) {
			// System.out.println("退出登录………………" + userID);
			String uuid = GenerateUUID.getUUID();
			Log.log("Logout:account");
			appServletAction.doLogout(ctx, req, resp, userID, uuid);
		} else if (action.equals("home")) {
			// Log.log("Home:A->T->H、T->A->H->Q ");
			String uuid = GenerateUUID.getUUID();
			appServletAction.doHome(ctx, req, resp, userID, "Ready to Trade", uuid);
		} else if (action.equals("account")) {
			// System.out.println("正在跳转到account页面…………");
			String uuid = GenerateUUID.getUUID();
			Log.log("Account:account->order");
			appServletAction.doAccount(ctx, req, resp, userID, "", uuid);
		} else if (action.equals("update_profile")) {
			// String password = req.getParameter("password");
			// String cpassword = req.getParameter("cpassword");
			// String fullName = req.getParameter("fullname");
			// String address = req.getParameter("address");
			// String creditcard = req.getParameter("creditcard");
			// String email = req.getParameter("email");
			// appServletAction.doAccountUpdate(ctx, req, resp, userID, password
			// == null ? "" : password.trim(),
			// cpassword == null ? "" : cpassword.trim(), fullName == null ? ""
			// : fullName.trim(),
			// address == null ? "" : address.trim(), creditcard == null ? "" :
			// creditcard.trim(),
			// email == null ? "" : email.trim());
		} else {
			System.out.println("TradeAppServlet: Invalid Action=" + action);
			appServletAction.doWelcome(ctx, req, resp, "TradeAppServlet: Invalid Action" + action, "");
		}

	}

}
