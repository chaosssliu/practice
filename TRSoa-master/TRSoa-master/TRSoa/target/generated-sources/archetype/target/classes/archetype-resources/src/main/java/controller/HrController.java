#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;import org.springframework.stereotype.Controller;import org.springframework.ui.ModelMap;import org.springframework.web.bind.annotation.RequestMapping;@Controller@RequestMapping({"/project"})public class HrController {	@RequestMapping("/hr")	public String manageHr(ModelMap model) {		return "/project/human_resource";	}}