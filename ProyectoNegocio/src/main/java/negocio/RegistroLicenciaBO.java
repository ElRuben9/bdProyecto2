/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 *
 * @author ruben
 */
import dto.NuevoLicenciaDTO;
import entidadesJPA.Licencia;
import DAOS.ILicenciaDAO;
import DAOS.IPersonaDAO;
import entidadesJPA.Persona;
import java.time.LocalDate;

public class RegistroLicenciaBO implements IRegistroLicenciaBO {

    private ILicenciaDAO licenciaDAO;
    private IPersonaDAO personaDAO;

    public RegistroLicenciaBO(ILicenciaDAO licenciaDAO, IPersonaDAO personaDAO) {
        this.licenciaDAO = licenciaDAO;
        this.personaDAO = personaDAO;
    }

    @Override
    public Licencia registrarLicencia(NuevoLicenciaDTO nuevoLicenciaDTO) {
        return null;
    }

    private boolean validarDatos(Persona persona) {
        // Verificar que el RFC no esté vacío y tenga longitud adecuada
        String rfc = persona.getRFC();
        if (rfc == null || rfc.isEmpty() || rfc.length() != 13) {
            return false;
        }

        // Verificar que el nombre completo no esté vacío
        String nombreCompleto = persona.getNombreCompleto();
        if (nombreCompleto == null || nombreCompleto.isEmpty()) {
            return false;
        }

        // Verificar que la fecha de nacimiento no sea nula y no sea en el futuro
        LocalDate fechaNacimiento = persona.getFechaNacimiento();
        if (fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now())) {
            return false;
        }

        // Verificar que el teléfono no esté vacío y tenga longitud adecuada
        String telefono = persona.getTelefono();
        if (telefono == null || telefono.isEmpty() || telefono.length() != 10) {
            return false;
        }
        
        // Si todas las validaciones pasan, retornar true
        return true;
    }

}
