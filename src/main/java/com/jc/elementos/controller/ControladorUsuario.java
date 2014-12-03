/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jc.elementos.controller;

import com.jc.elementos.model.DAOUsuarioImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author T107
 */
@Controller
@RequestMapping("/")

public class ControladorUsuario {
    @RequestMapping(value="/user", method=RequestMethod.GET,headers={"Accept=Application/json"})
    public @ResponseBody String hola2()throws Exception{
        DAOUsuarioImpl d=new DAOUsuarioImpl();
        
        //String hola='hola mundo';
        return d.obtenerTodos();
    }
    
    @RequestMapping(value="/user/{id}",method=RequestMethod.GET,headers={"Accept=Application/json"})
    public @ResponseBody String hola3(@PathVariable Integer id) throws Exception{
    DAOUsuarioImpl du=new DAOUsuarioImpl();
    
        return du.obtenerUsuarioPorId(id);
    }
    
    
    
}
