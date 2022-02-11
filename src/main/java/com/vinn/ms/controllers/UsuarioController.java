package com.vinn.ms.controllers;

import com.vinn.ms.dao.UsuarioDao;
import com.vinn.ms.models.Usuario;
import com.vinn.ms.utils.JWTUtil;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Elvin");
        usuario.setApellido("Najera");
        usuario.setEmail("Elvin7@gmail.com");
        usuario.setTelefono("22334455");
        return usuario;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token) {
        if (validarToken(token)) {
            return null;
        }

        return usuarioDao.getUsuario();
    }

    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {

        // Encriptacion de contraseña
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "usuario/editar")
    public Usuario editar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Elvin");
        usuario.setApellido("Najera");
        usuario.setEmail("Elvin7@gmail.com");
        usuario.setTelefono("22334455");
        return usuario;
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) {
        if (validarToken(token)) {
            return;
        }

        usuarioDao.eliminar(id);
    }

}
