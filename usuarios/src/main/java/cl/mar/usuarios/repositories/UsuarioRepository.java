package cl.mar.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.mar.usuarios.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Usuario findByEmailAndPassword(String email, String password);

}
