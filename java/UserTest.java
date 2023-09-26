
import org.example.controlladores.AdminRegistros;
import org.example.controlladores.UserRegistros;
import org.example.modelo.Administrador;
import org.example.modelo.Usuario;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {
    
    @Mock
    private UserRegistros.BaseDeDatos baseDeDatos;
    @Mock
    private AdminRegistros.BaseDeDatos2 baseDeDatos2;

    @Test
    public void testRegistrarUser() {

        Usuario usuarioEsperado = new Usuario("Fabian","1234567","example@hotmail.com");
        Usuario usuarioBase = new Usuario("Fabian","1234567","example@hotmail.com");

        UserRegistros usuarioRegistro = new UserRegistros(baseDeDatos);

        Mockito.when(baseDeDatos.guardarUsuario(Mockito.any(Usuario.class))).thenReturn(usuarioBase);

        Usuario usuarioResultado = usuarioRegistro.registroUser("Fabian","1234567","example@hotmail.com");

        Assert.assertEquals(usuarioEsperado,usuarioResultado);
    }

    @Test
    public void testRegistrarAdmin() {

        Administrador adminEsperado = new Administrador("Fabian","1234567");
        Administrador adminBase = new Administrador("Fabian","1234567");

        Mockito.when(baseDeDatos2.guardarUsuario2(Mockito.any(Administrador.class))).thenReturn(adminBase);

        AdminRegistros adminRegistros = new AdminRegistros(baseDeDatos2);

        Administrador adminResultado = adminRegistros.registroAdmin("Fabian","1234567");
        Assert.assertEquals(adminEsperado,adminResultado);
    }
}
