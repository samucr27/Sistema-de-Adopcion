import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String documento;
    private List<Perro> perrosAdoptados;

    public Persona(String nombre, String apellido, int edad, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
        this.perrosAdoptados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public List<Perro> getPerrosAdoptados() {
        return perrosAdoptados;
    }

    public void setPerrosAdoptados(List<Perro> perrosAdoptados) {
        this.perrosAdoptados = perrosAdoptados;
    }

    public void adoptarPerro(Perro perro) {
        if (perrosAdoptados.size() < 3) {
            perrosAdoptados.add(perro);
        }
    }

    public Perro perroMasGrande() {
        if (perrosAdoptados.isEmpty()) return null;

        Perro masViejo = perrosAdoptados.get(0);
        for (Perro p : perrosAdoptados) {
            if (p.getEdad() > masViejo.getEdad()) {
                masViejo = p;
            }
        }
        return masViejo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona: ").append(nombre).append(" ").append(apellido)
                .append(", Edad: ").append(edad)
                .append(", Documento: ").append(documento)
                .append("\nPerros adoptados:\n");

        if (perrosAdoptados.isEmpty()) {
            sb.append("  Ninguno\n");
        } else {
            for (Perro p : perrosAdoptados) {
                sb.append("  ").append(p).append("\n");
            }
        }
        return sb.toString();
    }
}

