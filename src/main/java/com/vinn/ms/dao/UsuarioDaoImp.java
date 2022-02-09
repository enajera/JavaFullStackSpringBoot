package com.vinn.ms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vinn.ms.models.Usuario;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional 
public class UsuarioDaoImp implements UsuarioDao{

        @Override
	public List<Usuario> getUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

}
