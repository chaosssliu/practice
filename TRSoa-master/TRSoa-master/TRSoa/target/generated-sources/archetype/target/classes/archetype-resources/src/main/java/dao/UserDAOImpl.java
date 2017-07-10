#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;import ${package}.entity.User;import ${package}.entity.UserDetail;import ${package}.entity.UserRole;import ${package}.vo.UserDetailsVO;import org.apache.log4j.Logger;import org.springframework.security.core.GrantedAuthority;import org.springframework.security.core.authority.SimpleGrantedAuthority;import org.springframework.stereotype.Repository;import javax.persistence.EntityManager;import javax.persistence.NoResultException;import javax.persistence.PersistenceContext;import java.util.HashSet;import java.util.Set;/** * Created by daweizhuang on 8/11/16. */@Repositorypublic class UserDAOImpl implements UserDAO {    private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);    @PersistenceContext    EntityManager em;    @Override    public UserDetailsVO findVOByUsername(String username) {        User user = null;        try {             user = em.createNamedQuery("User.findUserByName", User.class).setParameter("userName", username).getSingleResult();        } catch (NoResultException e) {            return null;        }        UserDetail detailInfo = new UserDetail();        if(user.getUserDetails() != null) {            detailInfo.setFirstName(user.getUserDetails().getFirstName());            detailInfo.setLastName(user.getUserDetails().getLastName());            detailInfo.setId(user.getUserDetails().getId());        }else{            LOGGER.error("///The user is found but no UserDetails entry is found.");            return null;        }        Set<GrantedAuthority> authorities = new HashSet<>();        for(UserRole role:user.getUserRoles()){            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole().getValue());            authorities.add(grantedAuthority);        }        return new UserDetailsVO(user.getUserName(),user.getPassword(),detailInfo,authorities);    }    @Override    public User findUserById(int userId) {        return em.createNamedQuery("User.findUserById",User.class).setParameter("userId",userId).getSingleResult();    }}