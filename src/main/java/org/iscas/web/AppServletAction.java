package org.iscas.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iscas.databean.AccountBean;
import org.iscas.databean.AccountDataBean;
import org.iscas.databean.OrderBean;
import org.iscas.databean.QuoteBean;
import org.iscas.entity.Account;
import org.iscas.entity.AccountProfile;
import org.iscas.entity.Holding;
import org.iscas.service.AcountService;
import org.iscas.service.HoldingService;
import org.iscas.service.OrderService;
import org.iscas.service.QuoteService;
import org.iscas.service.TradeService;
import org.iscas.util.Log;

/**
 * Created by Summer on 2016/11/17.
 */
public class AppServletAction {

	// 页面跳转
	private void requestDispatch(ServletContext ctx, HttpServletRequest req, HttpServletResponse resp, String userID,
			String page) throws ServletException, IOException {
		ctx.getRequestDispatcher(page).include(req, resp);
	}

	// doWelcome
	public void doWelcome(ServletContext ctx, HttpServletRequest req, HttpServletResponse resp, String status,
			String uuid) throws ServletException, IOException {
		// 从数据库中获取实时数据，和tradehome.html页面交互，填充数据
		// System.out.println("doWelcome");
		req.setAttribute("results", status);
		requestDispatch(ctx, req, resp, null, "/welcome.jsp");
		// requestDispatch(ctx, req, resp, null,
		// TradeConfig.getPage(TradeConfig.WELCOME_PAGE));
	}

	// doLogin
	public void doLogin(ServletContext ctx, HttpServletRequest req, HttpServletResponse resp, String userID,
			String passwd, String uuid) throws IOException, ServletException {
		String results = "";
		try {
			AcountService acountService = new AcountService();

			// String uuid = GenerateUUID.getUUID();

			if (acountService.login(userID, passwd, uuid)) {
				// if (acountService.login(userID, passwd)) {
				// System.out.println("登录成功");
				HttpSession session = req.getSession(true);
				session.setAttribute("uidBean", userID);
				session.setAttribute("sessionCreationDate", new java.util.Date());
				results = "Ready to Trade";
				doHome(ctx, req, resp, userID, results, uuid);
				// requestDispatch(ctx, req, resp, userID, "/tradehome.html");
				return;
			} else {
				// System.out.println("登录失败");
				req.setAttribute("results", results + "\nCould not find account for user=" + userID);
				// log the exception with an error level of 3 which means,
				// handled exception but would invalidate a automation run
				Log.log("TradeServletAction.doLogin(...)", "Error finding account for user " + userID + "",
						"user entered a bad username or the database is not populated");
				throw new NullPointerException("User does not exist or password is incorrect!");
			}
		} catch (java.lang.IllegalArgumentException e) {
			req.setAttribute("results", results + "illegal argument:" + e.getMessage());
			Log.error(e, "TradeServletAction.doLogin(...)",
					"illegal argument, information should be in exception string",
					"treating this as a user error and forwarding on to a new page");
		} catch (Exception e) {
			// log the exception with error page
			throw new ServletException("TradeServletAction.doLogin(...)" + "Exception logging in user=" + userID
					+ " with password=" + passwd + "; " + e.getMessage(), e);
		}

		// requestDispatch(ctx, req, resp, userID,
		// TradeConfig.getPage(TradeConfig.WELCOME_PAGE));
		requestDispatch(ctx, req, resp, userID, "/welcome.jsp");

	}

	// doHome
	public void doHome(ServletContext ctx, HttpServletRequest req, HttpServletResponse resp, String userID,
			String results, String uuid) throws javax.servlet.ServletException, java.io.IOException {
		Log.log("Home:account->trade->holding");
		Log.log("Home:trade->account->holding->quote");
		BigDecimal balance;
		String result = "";
		try {
			// AccountDataBean accountData = tAction.getAccountData(userID);
			// Collection<HoldingDataBean> holdingDataBeans =
			// tAction.getHoldings(userID);
			// System.out.println("正在跳转到home页面…………");

			// String uuid = GenerateUUID.getUUID();
			req.setAttribute("uuid", uuid);

			TradeService tradeService = new TradeService();
			AccountDataBean accountData = tradeService.getAccountDataBean(userID, uuid);

			HoldingService holdingService = new HoldingService();
			Collection<Holding> holdingDataBeans = holdingService.getHoldings(userID, uuid);

			req.setAttribute("accountData", accountData);
			req.setAttribute("holdingDataBeans", holdingDataBeans);
			// See Edge Caching above
			// req.setAttribute("marketSummaryData", marketSummaryData);
			req.setAttribute("results", results);
		} catch (java.lang.IllegalArgumentException e) {
			// this is a user error so I will
			// forward them to another page rather than throw a 500
			req.setAttribute("results", results + "check userID = " + userID + " and that the database is populated");
			requestDispatch(ctx, req, resp, userID, "/tradehome.jsp");
			// log the exception with an error level of 3 which means, handled
			// exception but would invalidate a automation run
			Log.error("TradeServletAction.doHome(...)" + "illegal argument, information should be in exception string"
					+ "treating this as a user error and forwarding on to a new page", e);
			// } catch (javax.ejb.FinderException e) {
			// moved to below
		} catch (Exception e) {
			boolean javaee = false;
			// since we will not have the EJB Spec for non-JavaEE containers,
			// lets try to handle the expected exception logic, where for
			// JavaEE we should catch a javax.ejb.FinderException while
			// for non-JavaEE we should catch a RuntimeException

			if (!javaee && (e instanceof RuntimeException)) { // non-JavaEE
																// container
				// this is a user error so I will
				// forward them to another page rather than throw a 500
				req.setAttribute("results", results + "\nCould not find account for + " + userID);
				// requestDispatch(ctx, req, resp,
				// TradeConfig.getPage(TradeConfig.HOME_PAGE));
				// log the exception with an error level of 3 which means,
				// handled
				// exception but would invalidate a automation run
				Log.error("TradeServletAction.doHome(...)" + "Error finding account for user " + userID
						+ "treating this as a user error and forwarding on to a new page", e);
			} else {
				// log the exception with error page
				throw new ServletException("TradeServletAction.doHome(...)" + " exception user =" + userID, e);
			}
		}

		// System.out.println("跳转到tradehome ");
		requestDispatch(ctx, req, resp, userID, "/tradehome.jsp");
		// requestDispatch(ctx, req, resp, userID,
		// TradeConfig.getPage(TradeConfig.HOME_PAGE));
	}

	// do Register
	public void doRegister(ServletContext ctx, HttpServletRequest req, HttpServletResponse resp, String userID,
			String password, String cpassword, String fullname, String address, String email, String creditcard,
			String openBalance, String uuid) throws ServletException, IOException {
		String results = "";

		try {
			// String uuid = GenerateUUID.getUUID();
			// Validate user passwords match and are atleast 1 char in length
			if ((password.equals(cpassword)) && (password.length() >= 1)) {

				AcountService accountService = new AcountService();
				AccountBean accountData = accountService.register(userID, password, cpassword, fullname, address, email,
						creditcard, openBalance, uuid);

				if (accountData == null) {
					results = "Registration operation failed;";
					// System.out.println(results);
					req.setAttribute("results", results);
					requestDispatch(ctx, req, resp, userID, "/register.jsp");
				} else {
					doLogin(ctx, req, resp, userID, password, uuid);
					results = "Registration operation succeeded;  Account " + accountData.getAccountID()
							+ " has been created.";
					req.setAttribute("results", results);

				}
			} else {
				// Password validation failed
				results = "Registration operation failed, your passwords did not match";
				// System.out.println(results);
				req.setAttribute("results", results);
				requestDispatch(ctx, req, resp, userID, "/register.jsp");
			}

		} catch (Exception e) {
			// log the exception with error page
			throw new ServletException("TradeServletAction.doRegister(...)" + " exception user =" + userID, e);
		}
	}

	// do quotes
	public void doQuotes(ServletContext ctx, HttpServletRequest req, HttpServletResponse resp, String userID,
			String symbols, String uuid) throws ServletException, IOException {

		String results = "";

		// String uuid = GenerateUUID.getUUID();
		req.setAttribute("uuid", uuid);
		requestDispatch(ctx, req, resp, userID, "/quote.jsp");
	}

	// doLogout
	public void doLogout(ServletContext ctx, HttpServletRequest req, HttpServletResponse resp, String userID,
			String uuid) throws ServletException, IOException {
		String results = "";
		// String uuid = GenerateUUID.getUUID();
		AcountService accountService = new AcountService();
		try {
			accountService.logout(userID, uuid);

		} catch (java.lang.IllegalArgumentException e) { // this is a user
															// error so I will
			// forward them to another page, at the end of the page.
			req.setAttribute("results", results + "illegal argument:" + e.getMessage());

			// log the exception with an error level of 3 which means, handled
			// exception but would invalidate a automation run
			Log.error(e, "TradeServletAction.doLogout(...)",
					"illegal argument, information should be in exception string",
					"treating this as a user error and forwarding on to a new page");
		} catch (Exception e) {
			// log the exception and foward to a error page
			Log.error(e, "TradeServletAction.doLogout(...):", "Error logging out" + userID,
					"fowarding to an error page");
			// set the status_code to 500
			throw new ServletException("TradeServletAction.doLogout(...)" + "exception logging out user " + userID, e);
		}
		HttpSession session = req.getSession();
		if (session != null) {
			session.invalidate();
		}

		Object o = req.getAttribute("TSS-RecreateSessionInLogout");
		if (o != null && ((Boolean) o).equals(Boolean.TRUE)) {
			// Recreate Session object before writing output to the response
			// Once the response headers are written back to the client the
			// opportunity
			// to create a new session in this request may be lost
			// This is to handle only the TradeScenarioServlet case
			session = req.getSession(true);
		}
		requestDispatch(ctx, req, resp, userID, "/welcome.jsp");
	}

	// do buy
	public void doBuy(ServletContext ctx, HttpServletRequest req, HttpServletResponse resp, String userID,
			String symbol, String quantity, String uuid) throws ServletException, IOException {

		String results = "";
		// String uuid = GenerateUUID.getUUID();
		TradeService tradeService = new TradeService();

		try {

			OrderBean orderData = tradeService.buy(symbol, quantity, userID, uuid);

			req.setAttribute("orderData", orderData);
			req.setAttribute("results", results);
		} catch (java.lang.IllegalArgumentException e) { // this is a user
															// error so I will
			// forward them to another page rather than throw a 500
			req.setAttribute("results", results + "illegal argument:");
			requestDispatch(ctx, req, resp, userID, "/tradehome.jsp");
			// log the exception with an error level of 3 which means, handled
			// exception but would invalidate a automation run
			Log.error(e, "TradeServletAction.doBuy(...)", "illegal argument. userID = " + userID, "symbol = " + symbol);
		} catch (Exception e) {
			// log the exception with error page
			throw new ServletException(
					"TradeServletAction.buy(...)" + " exception buying stock " + symbol + " for user " + userID, e);
		}
		requestDispatch(ctx, req, resp, userID, "/order.jsp");
	}

	// do sell
	public void doSell(ServletContext ctx, HttpServletRequest req, HttpServletResponse resp, String userID,
			Integer holdingID, String uuid) throws ServletException, IOException {
		String results = "";
		// String uuid = GenerateUUID.getUUID();
		TradeService tradeService = new TradeService();

		try {

			HoldingService holdingService = new HoldingService();
			Holding holding = holdingService.getHoldingByHoldingID(holdingID.toString(), uuid);

			OrderBean orderData = tradeService.sell(userID, holding.getQuoteSymbol(), uuid);

			req.setAttribute("orderData", orderData);
			req.setAttribute("results", results);
		} catch (java.lang.IllegalArgumentException e) { // this is a user
															// error so I will
			// just log the exception and then later on I will redisplay the
			// portfolio page
			// because this is just a user exception
			Log.error(e, "TradeServletAction.doSell(...)",
					"illegal argument, information should be in exception string", "user error");
		} catch (Exception e) {
			// log the exception with error page
			throw new ServletException("TradeServletAction.doSell(...)" + " exception selling holding " + holdingID
					+ " for user =" + userID, e);
		}
		requestDispatch(ctx, req, resp, userID, "/order.jsp");
	}

	// do Portfolio
	public void doPortfolio(ServletContext ctx, HttpServletRequest req, HttpServletResponse resp, String userID,
			String results, String uuid) throws ServletException, IOException {

		try {
			// Get the holdiings for this user
			// String uuid = GenerateUUID.getUUID();
			HoldingService holdingService = new HoldingService();

			Collection quoteDataBeans = new ArrayList();
			Collection holdingDataBeans = holdingService.getHoldings(userID, uuid);

			// Walk through the collection of user
			// holdings and creating a list of quotes
			if (holdingDataBeans.size() > 0) {
				QuoteService quoteService = new QuoteService();
				Iterator it = holdingDataBeans.iterator();
				while (it.hasNext()) {
					Holding holdingData = (Holding) it.next();
					QuoteBean quoteData = quoteService.getQuote(holdingData.getQuoteSymbol(), uuid);
					quoteDataBeans.add(quoteData);
				}
			} else {
				results = results + ".  Your portfolio is empty.";
			}
			req.setAttribute("results", results);
			req.setAttribute("holdingDataBeans", holdingDataBeans);
			req.setAttribute("quoteDataBeans", quoteDataBeans);
			requestDispatch(ctx, req, resp, userID, "/portfolio.jsp");
		} catch (java.lang.IllegalArgumentException e) { // this is a user
															// error so I will
			// forward them to another page rather than throw a 500
			req.setAttribute("results", results + "illegal argument:" + e.getMessage());
			requestDispatch(ctx, req, resp, userID, "/portfolio.jsp");
			// log the exception with an error level of 3 which means, handled
			// exception but would invalidate a automation run
			Log.error(e, "TradeServletAction.doPortfolio(...)",
					"illegal argument, information should be in exception string", "user error");
		} catch (Exception e) {
			// log the exception with error page
			throw new ServletException("TradeServletAction.doPortfolio(...)" + " exception user =" + userID, e);
		}
	}

	// do Account
	public void doAccount(ServletContext ctx, HttpServletRequest req, HttpServletResponse resp, String userID,
			String results, String uuid) throws javax.servlet.ServletException, java.io.IOException {
		try {

			// String uuid = GenerateUUID.getUUID();

			AcountService accountService = new AcountService();
			Account accountData = accountService.getAccountByUserID(userID, uuid);
			AccountProfile accountProfileData = accountService.getAccountProfileByUserID(userID, uuid);

			OrderService orderService = new OrderService();
			Collection orderDataBeans = orderService.getOrdersByUserID(userID, uuid);

			req.setAttribute("accountData", accountData);
			req.setAttribute("accountProfileData", accountProfileData);
			req.setAttribute("orderDataBeans", orderDataBeans);
			req.setAttribute("results", results);
			requestDispatch(ctx, req, resp, userID, "/account.jsp");
		} catch (java.lang.IllegalArgumentException e) { // this is a user
															// error so I will
			// forward them to another page rather than throw a 500
			req.setAttribute("results", results + "could not find account for userID = " + userID);
			requestDispatch(ctx, req, resp, userID, "/tradehome.jsp");
			// log the exception with an error level of 3 which means, handled
			// exception but would invalidate a automation run
			Log.error("TradeServletAction.doAccount(...)",
					"illegal argument, information should be in exception string", e);
		} catch (Exception e) {
			// log the exception with error page
			throw new ServletException("TradeServletAction.doAccount(...)" + " exception user =" + userID, e);
		}

	}

}
