#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;import ${package}.entity.User;import ${package}.vo.UserDetailsVO;/** * Created by daweizhuang on 8/11/16. */public interface UserDAO {    UserDetailsVO findVOByUsername(String username);    User findUserById(int userId);}