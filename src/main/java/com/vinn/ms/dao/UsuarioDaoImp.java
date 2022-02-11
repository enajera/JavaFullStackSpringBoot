package com.vinn.ms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vinn.ms.models.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuario> getUsuario() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public boolean verificarCredenciales(Usuario usuario) {
        String query = "FROM Usuario where email=:email and password=:password";
        List<Usuario> lista = entityManager.createQuery(query)
        .setParameter("email", usuario.getEmail())
        .setParameter("password", usuario.getPassword())
        .getResultList();

        return !lista.isEmpty();
    }

}
