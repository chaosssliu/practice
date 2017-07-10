#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;import org.springframework.beans.factory.annotation.Value;import org.springframework.security.core.Authentication;import org.springframework.security.core.context.SecurityContextHolder;import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;import org.springframework.stereotype.Controller;import org.springframework.ui.ModelMap;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;@Controller@RequestMapping({"","/"})public class LoginController {	@Value("${symbol_dollar}{appVersion}")	private String version;	@Value("${symbol_dollar}{buildTime}")	private String buildTime;	@RequestMapping(method=RequestMethod.GET)	public String showIndex(ModelMap model) {		return "redirect:/dashboard";	}		@RequestMapping("/login")	public String showLogin(ModelMap model, HttpServletRequest request) {		request.getSession().setAttribute("version", version);		request.getSession().setAttribute("buildTime", buildTime);		return "login";	}	@RequestMapping(value = "/logout", method = RequestMethod.GET)	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {		Authentication auth = SecurityContextHolder.getContext().getAuthentication();		if (auth != null) {			new SecurityContextLogoutHandler().logout(request, response, auth);		}		return "redirect:/login?logout";	}	@RequestMapping(value = "/deny", method = RequestMethod.GET)	public String accessDenyPage(HttpServletRequest request, HttpServletResponse response) {		return "deny";	}}