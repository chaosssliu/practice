package org.trs.oa.dao;import org.trs.oa.entity.Notification;import org.springframework.stereotype.Repository;import javax.persistence.EntityManager;import javax.persistence.PersistenceContext;import java.util.List;/** * Created by daweizhuang on 8/23/16. */@Repositorypublic class NotificationDAOImpl implements NotificationDAO {    @PersistenceContext    EntityManager em;    @Override    public Notification save(Notification note) {        return em.merge(note);    }    @Override    public List<Notification> findNotificationOfToday() {        return em.createNamedQuery("Notification.findToday", Notification.class).getResultList();    }    @Override    public List<Notification> findALl() {        return em.createNamedQuery("Notification.findAll", Notification.class).getResultList();    }    @Override    public boolean inactiveNoti(Integer notificationId) {        int result = em.createNamedQuery("Notification.inactivate").setParameter("id", notificationId).executeUpdate();        return result > 0;    }}