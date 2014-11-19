/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jc.elementos.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author T107
 */
public class ProbarUsuarioDirecciones {
    
    public static void main(String[]args){
        SessionFactory factory= NewHibernateUtil.getSessionFactory();
        Session sesion=  factory.openSession();
        Transaction tranza= sesion.beginTransaction();
        
        Usuario u=new Usuario();
        Direccion d=new Direccion();
        
        d.setCalle("calle de la amargura");
        d.setColonia("colonia del avón");
        d.setEstado("Ebriedad");
        //Importante ligar al usuario anterior esta dirección
        d.setIdUsuario(u);
        
        
        u.setDireccion(d);
        u.setEdad(43);
        u.setNombre("Daniela Guevara");
        u.setSueldo(300002f);
        
        sesion.save(u);
        sesion.save(d);
        
        tranza.commit();
        sesion.close();
        System.out.println("Fuck yeahhhh, todo se guardó bien!!!!");
    }
    
}
