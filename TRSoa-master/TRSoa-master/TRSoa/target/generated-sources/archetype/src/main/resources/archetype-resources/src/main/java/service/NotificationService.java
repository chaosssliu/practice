#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;import ${package}.entity.Notification;import java.util.Date;import java.util.List;/** * Created by daweizhuang on 8/23/16. */public interface NotificationService {    List<Notification> getAllNotification();    List<Notification> getNotiForToday();    boolean removeNotification(Integer notificationId);    Notification saveNoti(Integer type, String title, String content, Date from, Date to);}