package com.vinn.ms.controllers;

import com.vinn.ms.dao.UsuarioDao;
import com.vinn.ms.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Elvin");
        usuario.setApellido("Najera");
        usuario.setEmail("Elvin7@gmail.com");
        usuario.setTelefono("22334455");
        return usuario; 
    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(){
       return  usuarioDao.getUsuario();
    }
    
    @RequestMapping(value = "api/usuarios",method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){
         usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "usuario/editar")
    public Usuario editar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Elvin");
        usuario.setApellido("Najera");
        usuario.setEmail("Elvin7@gmail.com");
        usuario.setTelefono("22334455");
        return usuario;
    }
    
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){
         usuarioDao.eliminar(id);
    }


}
