#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;import ${package}.entity.Project;import ${package}.vo.ProjectVO;import java.util.List;/** * Created by Dawei on 9/1/16. */public interface ProjectDAO {    Project saveProject(Project project);    List<Project> getProject();    List<ProjectVO> getProjectNameList();}