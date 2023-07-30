package cl.mar.usuarios.services;

import java.util.List;
import java.util.Optional;

import cl.mar.usuarios.models.Usuario;
import cl.mar.usuarios.services.dto.UsuarioDTO;

public interface IUsuarioService {

	List<Usuario> listarUsuarios();

    Optional<Usuario> buscarUsuarioPorId(Long id);   

    Usuario crearModificarUsuario(Usuario usuario);

    void borrarUsuario(Long id);
    
    UsuarioDTO login(String email, String password);     

}
