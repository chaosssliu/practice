#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;import ${package}.entity.Notification;import java.util.List;/** * Created by daweizhuang on 8/23/16. */public interface NotificationDAO {    Notification save(Notification note);    List<Notification> findNotificationOfToday();    List<Notification> findALl();    boolean inactiveNoti(Integer notificationId);}