package org.iscas.util;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by Summer on 2016/11/16.
 */
public class TradeConfig {

    private static int MAX_QUOTES = 1000;//最大股票数
   // private static Random r0 = new Random(System.currentTimeMillis());
    private static Random randomNumberGenerator = new Random(System.currentTimeMillis());//生成随机数double

    //生成double随机数
    public static double random() {
        return randomNumberGenerator.nextDouble();
    }
    //生成int随机数
    public static int rndInt(int i) {
        return (new Float(random() * i)).intValue();
    }
    //生成Float随机数
    public static float rndFloat(int i) {
        return (new Float(random() * i)).floatValue();
    }
    //生成BigDecimal随机数
    public static BigDecimal rndBigDecimal(float f) {
        return (new BigDecimal(random() * f)).setScale(
                2,
                BigDecimal.ROUND_HALF_UP);
    }
    //生成随机股票代码，s:10
    public static String rndSymbol() {
        return "s:" + rndInt(MAX_QUOTES - 1);
    }
    //生成随机数量
    public static float rndQuantity() {
        return ((new Integer(rndInt(200))).floatValue()) + 1.0f;
    }

    public final static int WELCOME_PAGE = 0;     //欢迎页面
    public final static int REGISTER_PAGE = 1;    //注册页面
    public final static int PORTFOLIO_PAGE = 2;   //业务量页面
    public final static int QUOTE_PAGE = 3;       //报价页面
    public final static int HOME_PAGE = 4;        //主页
    public final static int ACCOUNT_PAGE = 5;     //用户账户页面
    public final static int ORDER_PAGE = 6;       //订单交易页面；股票交易
    public final static int CONFIG_PAGE = 7;      //配置页面
    public final static int STATS_PAGE = 8;       //状态页面

    public static String webUI[] =
            {
                    "/welcome-bak.html",
                    "/register.html",
                    "/portfolio.html",
                    "/quote.html",
                    "/tradehome.html",
                    "/account.html",
                    "/order.html",
                    "/config.html",
                    "/runStats.html"
            };

    public static String getPage(int pageNumber) {
        return webUI[pageNumber];
    }

}
