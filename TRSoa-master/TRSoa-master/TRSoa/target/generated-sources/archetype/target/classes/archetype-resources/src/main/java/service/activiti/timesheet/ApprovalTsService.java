#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.activiti.timesheet;

import ${package}.dao.TimesheetDAO;
import ${package}.dao.UserDAO;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The backing service of the process flow.
 */
@Service
public class ApprovalTsService {
	private static final Logger LOGGER = Logger.getLogger(ApprovalTsService.class);
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private TimesheetDAO tsDAO;
	@Autowired
	private UserDAO userDAO;
	public void deny(DelegateExecution execution) {
		LOGGER.info("/////////////////////////////////////////deny you ts id:" + execution.getVariable("tsSubId") + "  submitterId: " + execution.getVariable("submitterId") + "  reviewerName: " + execution.getVariable("reviewerName"));
	}
	
	public void validate(DelegateExecution execution) {
		LOGGER.info("/////////////////////////////////////////validate you ts id:" + execution.getVariable("tsSubId") + "  submitterId: " + execution.getVariable("submitterId") + "  reviewerName: " + execution.getVariable("reviewerName"));
		execution.setVariable("valid", true);
	}
	
	public void save(DelegateExecution execution) {
		LOGGER.info("/////////////////////////////////////////save you ts id:" + execution.getVariable("tsSubId") + "  submitterId: " + execution.getVariable("submitterId") + "  reviewerName: " + execution.getVariable("reviewerName"));
		Integer subId = (Integer) execution.getVariable("tsSubId");
		tsDAO.submitTs(subId);
	}
	
	public void invalidNotify(DelegateExecution execution) {
		LOGGER.info("/////////////////////////////////////////notify you invalid ts id:" + execution.getVariable("tsSubId") + "  submitterId: " + execution.getVariable("submitterId") + "  reviewerName: " + execution.getVariable("reviewerName"));
	}
	
	public void approve(DelegateExecution execution) {
		LOGGER.info("/////////////////////////////////////////approved you ts id:" + execution.getVariable("tsSubId") + "  submitterId: " + execution.getVariable("submitterId") + "  reviewerName: " + execution.getVariable("reviewerName"));
	}

}
