package com.vinn.ms.dao;

import java.util.List;

import com.vinn.ms.models.Usuario;

public interface UsuarioDao {

    public List<Usuario> getUsuario();

    public void eliminar(Long id);

    public void registrar(Usuario usuario);

    public Usuario obtenerUsuario(Usuario usuario);
}
