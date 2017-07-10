#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;import ${package}.entity.AdminLookup;import java.util.List;/** * Created by daweizhuang on 8/23/16. */public interface LookupDAO {    List<AdminLookup> getAllAdminLookup();}