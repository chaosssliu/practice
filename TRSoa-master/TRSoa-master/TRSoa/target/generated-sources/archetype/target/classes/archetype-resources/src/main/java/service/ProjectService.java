#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;import ${package}.entity.Project;import ${package}.vo.ProjectVO;import java.util.List;/** * Created by Dawei on 9/1/16. */public interface ProjectService {    Project saveProject(ProjectVO projectVO);    List<ProjectVO> getProjListForDashboard();    List<ProjectVO> getProjListForMap();    List<ProjectVO> getProjListForDocumentTree();}