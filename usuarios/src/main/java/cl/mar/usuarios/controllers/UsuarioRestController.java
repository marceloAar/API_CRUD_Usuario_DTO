package cl.mar.usuarios.controllers;
//@mAR 2023 | API Usuarios - DTO - /login: email-password 

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.mar.usuarios.models.Usuario;
import cl.mar.usuarios.services.dto.UsuarioDTO;
import cl.mar.usuarios.services.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@GetMapping("/listar")
	public List<Usuario> listarUsuarios(){
		return usuarioService.listarUsuarios();
	}
	
	
	@PostMapping("/crear")
	public Usuario crearUsuario(@RequestBody Usuario usuario) {		
		return usuarioService.crearModificarUsuario(usuario);
	}
	
	
	@PutMapping("/modificar")
	public Usuario modificarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.crearModificarUsuario(usuario);
	}
	
	
	@GetMapping("/buscar/{id}")
	public Optional<Usuario> buscarUsuario(@PathVariable Long id){
		return usuarioService.buscarUsuarioPorId(id);
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminaUsuario(@PathVariable Long id) {
		usuarioService.borrarUsuario(id);
		return "Usuario "+id+" eliminado correctamente";
	}
	
	
	@PostMapping("/login")
	public UsuarioDTO login(@RequestBody Usuario usuario) {
		return usuarioService.login(usuario.getEmail(), usuario.getPassword());
	}

}
