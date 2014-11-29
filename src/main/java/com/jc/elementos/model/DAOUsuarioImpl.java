package com.jc.elementos.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DAOUsuarioImpl {
    
    public String obtenerTodos() throws Exception{
        SessionFactory factory=NewHibernateUtil.getSessionFactory();
        Session session= factory.openSession();
        Transaction tranza= session.beginTransaction();
 Criteria cri=session.createCriteria(Usuario.class);
 
 
 
 ArrayList<Usuario> usuarios= (ArrayList<Usuario>)cri.list();
 Map<String, ArrayList<Usuario>> singletonMap = Collections.singletonMap("usuarios", usuarios);
 
 
 
 ObjectMapper mapper= new ObjectMapper();
 
 tranza.commit();
 session.close();
 
 return mapper.writeValueAsString(singletonMap);
    }
   public String obtenerUsuarioPorId(Integer Id) throws Exception{
        SessionFactory factory=NewHibernateUtil.getSessionFactory();
        Session session= factory.openSession();
        Transaction tranza= session.beginTransaction();
 Criteria cri=session.createCriteria(Usuario.class).add(Restrictions.idEq(Id));
    Usuario u = (Usuario) cri.uniqueResult();
  ObjectMapper mapper= new ObjectMapper();
 
 tranza.commit();
 session.close();
 
 return mapper.writeValueAsString(u);
    }
    
    
    
}
