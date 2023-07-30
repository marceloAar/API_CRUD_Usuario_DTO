package cl.mar.usuarios.services.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {	
	
	private String nombre;
	
	private String apellido;
	
	private int edad;	

}
