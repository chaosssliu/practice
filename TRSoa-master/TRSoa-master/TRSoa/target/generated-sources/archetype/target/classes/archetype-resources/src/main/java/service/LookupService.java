#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;import ${package}.entity.AdminLookup;import java.util.List;/** * Created by Dawei on 8/24/16. */public interface LookupService {    List<AdminLookup> getAllLookup();}