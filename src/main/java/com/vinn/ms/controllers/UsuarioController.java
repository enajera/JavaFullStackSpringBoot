package com.vinn.ms.controllers;

import com.vinn.ms.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Elvin");
        usuario.setApellido("Najera");
        usuario.setEmail("Elvin7@gmail.com");
        usuario.setTelefono("22334455");
        return usuario;
    }

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios(){

        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setId(1l);
        usuario.setNombre("Elvin");
        usuario.setApellido("Najera");
        usuario.setEmail("Elvin7@gmail.com");
        usuario.setTelefono("22334455");
        usuarios.add(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.setId(2l);
        usuario2.setNombre("Gabriela");
        usuario2.setApellido("Fiallos");
        usuario2.setEmail("gmfiallos@gmail.com");
        usuario2.setTelefono("222224455");
        usuarios.add(usuario2);

        Usuario usuario3 = new Usuario();
        usuario3.setId(3l);
        usuario3.setNombre("Sofia");
        usuario3.setApellido("Najera");
        usuario3.setEmail("sofia@gmail.com");
        usuario3.setTelefono("99558877");
        usuarios.add(usuario3);

        return usuarios;
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


}
