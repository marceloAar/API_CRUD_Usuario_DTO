package cl.mar.usuarios.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.mar.usuarios.models.Usuario;
import cl.mar.usuarios.repositories.UsuarioRepository;
import cl.mar.usuarios.services.IUsuarioService;
import cl.mar.usuarios.services.dto.UsuarioDTO;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> listarUsuarios() {		
		return this.usuarioRepository.findAll();
	}
	

	@Override
	public Optional<Usuario> buscarUsuarioPorId(Long id) {		
		return usuarioRepository.findById(id);
	}

	
	@Override
	public Usuario crearModificarUsuario(Usuario usuario) {		
		return usuarioRepository.save(usuario);
	}
	

	@Override
	public void borrarUsuario(Long id) {
		usuarioRepository.deleteById(id);		
	}
	

	@Override
	public UsuarioDTO login(String email, String password) {	
		
		Usuario usuario = usuarioRepository.findByEmailAndPassword(email, password);
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getNombre()
								,usuario.getApellido()
								,usuario.getEdad());
		return usuarioDTO;
	}

}
