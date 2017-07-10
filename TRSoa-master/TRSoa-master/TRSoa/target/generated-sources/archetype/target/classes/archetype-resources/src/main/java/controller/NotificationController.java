#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;import ${package}.component.Dropdown;import ${package}.entity.AdminLookup;import ${package}.service.MessageService;import ${package}.service.NotificationService;import org.apache.log4j.Logger;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.format.annotation.DateTimeFormat;import org.springframework.stereotype.Controller;import org.springframework.ui.ModelMap;import org.springframework.web.bind.annotation.ModelAttribute;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestParam;import org.springframework.web.servlet.mvc.support.RedirectAttributes;import java.util.Date;import java.util.List;@Controllerpublic class NotificationController {	private static final Logger LOGGER = Logger.getLogger(NotificationController.class);	@Autowired    NotificationService notiService;	@Autowired    Dropdown dropdown;	@Autowired    MessageService msg;	@RequestMapping({"/notification"})	public String manageNotification(ModelMap model) {		model.addAttribute("fullNotificationList",notiService.getAllNotification());		return "Notification/dashboard_notification_management";	}	@RequestMapping({"/notification/remove"})	public String removeNotification(@RequestParam("notification_to_remove_id") Integer notificationId, final RedirectAttributes redirectAttributes) {		LOGGER.debug("///Notification with id " + notificationId + " is deleted./");		notiService.removeNotification(notificationId);		//redirectAttributes.addFlashAttribute("errorMsg","haha");		redirectAttributes.addFlashAttribute("successMsg",msg.getMessage("notification_removed_success",null));		return "redirect:/notification";	}	@RequestMapping({"/notification/createOrUpdate"})	public String createOrUpdateNotification(String title, String content, Integer type, @DateTimeFormat(pattern="yyyy-MM-dd")Date from, @DateTimeFormat(pattern="yyyy-MM-dd")Date to, final RedirectAttributes redirectAttributes) {		LOGGER.debug("title: " + title + " content:" + content + " type:" + type + "Date from / to" + from +" / " + to);		notiService.saveNoti(type, title, content, from, to);		redirectAttributes.addFlashAttribute("successMsg",msg.getMessage("notification_added_success",null));		return "redirect:/notification";	}	@ModelAttribute("notificationTypeList")    public List<AdminLookup> getTypeDropdown(){	    return dropdown.getNotificationTypeList();    }}