#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import net.sf.jasperreports.engine.JRException;

/**
 * Created by daweizhuang on 11/2/16.
 */
public interface PDFReportService {
    Integer generateTimeSheetReport(int userId, int weekId) throws JRException;
}
