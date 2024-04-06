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
import java.time.Period;
import java.util.Date;

public class RegistroLicenciaBO implements IRegistroLicenciaBO {

    private ILicenciaDAO licenciaDAO;
    private IPersonaDAO personaDAO;

    public RegistroLicenciaBO(ILicenciaDAO licenciaDAO, IPersonaDAO personaDAO) {
        this.licenciaDAO = licenciaDAO;
        this.personaDAO = personaDAO;
    }

    @Override
    public Licencia registrarLicencia(NuevoLicenciaDTO nuevoLicenciaDTO) {
       
        if (nuevoLicenciaDTO == null || nuevoLicenciaDTO.getNumeroLicencia() == null || nuevoLicenciaDTO.getVigencia() == null
                || nuevoLicenciaDTO.getFechaExpedicion() == null || nuevoLicenciaDTO.getIdPersona() == null) {
            System.out.println("Número de licencia: " + nuevoLicenciaDTO.getNumeroLicencia());
            System.out.println("Vigencia: " + nuevoLicenciaDTO.getVigencia());
            System.out.println("Fecha de expedición: " + nuevoLicenciaDTO.getFechaExpedicion());
            System.out.println("ID de persona: " + nuevoLicenciaDTO.getIdPersona());
            throw new IllegalArgumentException("Los datos de la licencia son inválidos.");
        }

        // Aquí puedes agregar impresiones adicionales para depuración
        System.out.println("Número de licencia: " + nuevoLicenciaDTO.getNumeroLicencia());
        System.out.println("Vigencia: " + nuevoLicenciaDTO.getVigencia());
        System.out.println("Fecha de expedición: " + nuevoLicenciaDTO.getFechaExpedicion());
        System.out.println("ID de persona: " + nuevoLicenciaDTO.getIdPersona());

        // Validar que la persona asociada a la licencia exista y tenga datos válidos
        Persona persona = personaDAO.obtenerPersonaPorId(nuevoLicenciaDTO.getIdPersona());
        if (persona == null || !validarDatosPersona(persona)) {
            throw new IllegalArgumentException("La persona asociada a la licencia es inválida.");
        }

        // Calcular la vigencia de la licencia y validar que esté dentro del rango permitido
        int duracionVigencia = calcularDuracionVigencia(nuevoLicenciaDTO.getVigencia(), nuevoLicenciaDTO.getFechaExpedicion());
        if (duracionVigencia < 1 || duracionVigencia > 3) {
            throw new IllegalArgumentException("La duración de la vigencia debe ser de 1 a 3 años a partir de la fecha de expedición.");
        }

        // Calcular el costo de la licencia
        int costoLicencia = calcularCostoLicencia(duracionVigencia);

        // Crear una nueva instancia de Licencia y asignarle los valores
        Licencia licencia = new Licencia();
        licencia.setNumeroLicencia(nuevoLicenciaDTO.getNumeroLicencia());
        licencia.setVigencia(java.sql.Date.valueOf(nuevoLicenciaDTO.getVigencia()));
        licencia.setCosto(costoLicencia);
        licencia.setFechaExpedicion(java.sql.Date.valueOf(nuevoLicenciaDTO.getFechaExpedicion()));
        licencia.setPersona(persona);

        // Guardar la licencia en la base de datos
        licenciaDAO.guardarLicencia(licencia);

        return licencia;
    }

    private boolean validarDatosPersona(Persona persona) {
        return persona.getRFC() != null && !persona.getRFC().isEmpty()
                && persona.getNombre() != null && !persona.getNombre().isEmpty()
                && persona.getFechaNacimiento() != null && !persona.getFechaNacimiento().after(new Date())
                && persona.getTelefono() != null && !persona.getTelefono().isEmpty();
    }

    private int calcularDuracionVigencia(LocalDate fechaVigencia, LocalDate fechaExpedicion) {
        // Calcular la diferencia de años entre la fecha de vigencia y la fecha de expedición
        return Period.between(fechaExpedicion, fechaVigencia).getYears();
    }

    private int calcularCostoLicencia(int duracionVigencia) {
        int costoLicencia = 0;
        switch (duracionVigencia) {
            case 1:
                costoLicencia = 600; // Costo para 1 año
                break;
            case 2:
                costoLicencia = 900; // Costo para 2 años
                break;
            case 3:
                costoLicencia = 1100; // Costo para 3 años
                break;
        }
        return costoLicencia;
    }

    @Override
    public boolean validarDatos(Persona persona) {
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
        Date fechaNacimiento = persona.getFechaNacimiento();
        if (fechaNacimiento == null || fechaNacimiento.after(new Date())) {
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
