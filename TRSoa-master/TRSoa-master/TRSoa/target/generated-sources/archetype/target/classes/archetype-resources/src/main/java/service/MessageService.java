#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;/** * Created by daweizhuang on 9/1/16. */public interface MessageService {    String getMessage(String msgName, String[] param);}