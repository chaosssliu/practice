#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import ${package}.converter.TimesheetToReportConverter;
import ${package}.dao.DocumentDAO;
import ${package}.entity.AdminLookup;
import ${package}.entity.TsApproval;
import ${package}.entity.User;
import ${package}.entity.UserDocInfo;
import ${package}.utility.Constants;
import ${package}.utility.OaUtils;
import ${package}.vo.TimeSheetDateVO;
import ${package}.vo.TimeSheetProjectVO;
import ${package}.vo.TsReportItem;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by daweizhuang on 11/2/16.
 */
@Service
public class PDFReportServiceImpl implements PDFReportService {

    @Autowired
    TimesheetService timesheetService;

    @Value("${symbol_dollar}{temp_file_location_timesheet}")
    String tempFileLocation;

    @Autowired
    DocumentDAO docDAO;

    @Override
    @Transactional
    public Integer generateTimeSheetReport(int userId, int weekId) throws JRException {

        List<TimeSheetDateVO> dateList = timesheetService.getCurrentTimesheetDate(weekId);
        List<TimeSheetProjectVO> dataList = timesheetService.getProjTimesheetData(weekId, userId);
        TsApproval approvalStatus = timesheetService.getTimesheetStatus(weekId,userId);

        String jasperFileName = "TS.jasper";
        ClassLoader classLoader = getClass().getClassLoader();
        jasperFileName = classLoader.getResource(jasperFileName).getFile();

        HashMap<String, Object> parameters = new HashMap<>();
        for (TimeSheetDateVO vo : dateList) {
            parameters.put(OaUtils.getDayOfWeek(vo.getDate()),vo.getDate());
        }
        parameters.put("submitter",approvalStatus.getSubmitter().getUserDetails().getFirstName() + " " + approvalStatus.getSubmitter().getUserDetails().getLastName());
        parameters.put("approver",approvalStatus.getApprover().getUserDetails().getFirstName() + " " + approvalStatus.getApprover().getUserDetails().getLastName());
        parameters.put("statusDate", approvalStatus.getStatusDate());
        parameters.put("status", approvalStatus.getStatus().getValue());
        parameters.put("comment", approvalStatus.getComment());
        parameters.put("totalHours", approvalStatus.getTotalHours());

        List<TsReportItem> itemList = TimesheetToReportConverter.convertTsToReportItem(dataList);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(itemList);
        JasperPrint jprint = JasperFillManager.fillReport(jasperFileName, parameters, dataSource);

        String fileNameStamped = OaUtils.timeStampPrefix("ts.pdf");
        File file = new File(tempFileLocation+ File.separator + userId );
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileLocation = file.getAbsolutePath() + File.separator+ fileNameStamped;
        JasperExportManager.exportReportToPdfFile(jprint, fileLocation);
        UserDocInfo docInfo = new UserDocInfo();
        docInfo.setDocName(OaUtils.timeStampPrefix("ts.pdf"));
        docInfo.setFileType(Constants.PDF);
        docInfo.setFileLocation(fileLocation);
        docInfo.setUser(new User(userId));
        docInfo.setUploadTime(new Date());
        docInfo.setDocType(new AdminLookup(Constants.TIMESHEET_LOOKUP_ID));
        UserDocInfo udi = docDAO.saveFileInfo(docInfo);
        return udi.getId();
    }
}
