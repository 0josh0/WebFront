package org.iscas.web;

//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Created by andyren on 2016/6/28. 系统启动首页，index
 */
// @SpringBootApplication
// @WebServlet("/daytrader")
public class WebService extends HttpServlet {

	public String index() {
		return "hello";
	}

}
