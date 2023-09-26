package vo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestSaveClientForm {
    private String tipoIdentificacion;
    private Integer numeroIdentificacion;
    private String nombre;
    private String apellido;
    private String correo;
    private String numeroCelular;
    // datos direccion
    private String provincia;
    private String ciudad;
    private String direccion;
    private String tipoDireccion;
}
