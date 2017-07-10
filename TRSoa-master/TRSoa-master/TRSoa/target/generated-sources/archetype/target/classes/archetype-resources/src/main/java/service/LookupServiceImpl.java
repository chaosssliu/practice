#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;import ${package}.dao.LookupDAO;import ${package}.entity.AdminLookup;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import java.util.List;/** * Created by Dawei on 8/24/16. */@Servicepublic class LookupServiceImpl implements LookupService {    @Autowired    LookupDAO lookupDAO;    @Override    public List<AdminLookup> getAllLookup() {        return lookupDAO.getAllAdminLookup();    }}