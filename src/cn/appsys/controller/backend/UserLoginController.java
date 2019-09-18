package cn.appsys.controller.backend;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.BackendUser;
import cn.appsys.service.backend.BackendUserService;
import cn.appsys.tools.Constants;

@Controller
@RequestMapping(value = "/manager")
public class UserLoginController {
	private Logger logger = Logger.getLogger(UserLoginController.class);

	@Resource
	private BackendUserService backendUserService;

	/**
	 * 跳转到后台管理登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login() {
		logger.debug("LoginController welcome AppInfoSystem backend==================");
		return "backendlogin";
	}

	/**
	 * 登录具体实现
	 * 
	 * @param userCode
	 * @param userPassword
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	public String doLogin(@RequestParam String userCode, @RequestParam String userPassword, HttpServletRequest request,
			HttpSession session) {
		logger.debug("doLogin====================================");
		// 调用service方法，进行用户匹配
		BackendUser user = null;
		try {
			user = backendUserService.login(userCode, userPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null != user) {// 登录成功
			// 放入session
			session.setAttribute(Constants.USER_SESSION, user);
			// 页面跳转（main.jsp）
			return "redirect:/manager/backend/main";
		} else {
			// 页面跳转（login.jsp）带出提示信息--转发
			request.setAttribute("error", "用户名或密码不正确");
			return "backendlogin";
		}
	}

	/**
	 * 跳转到欢迎页
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/backend/main")
	public String main(HttpSession session) {
		if (session.getAttribute(Constants.USER_SESSION) == null) {
			return "redirect:/manager/login";
		}
		return "backend/main";
	}

	/**
	 * 退出系统
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		// 清除session
		session.removeAttribute(Constants.USER_SESSION);
		return "backendlogin";
	}
}
