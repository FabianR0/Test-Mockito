import org.example.controlladores.BetUtil;
import org.example.modelo.EventosSport;
import org.example.modelo.MultipleApuesta;
import org.example.modelo.Publicidad;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class BetUtilTest {


    @Test
    public void testDeposito() {

        double inicialBalance = BetUtil.getBalance();
        double deposito = 100.00;

        BetUtil.deposito(deposito);

        Assert.assertEquals(inicialBalance + deposito, BetUtil.getBalance(), 0.001);
    }

    @Test
    public void multipleDeposito() {
        double inicialBalance = BetUtil.getBalance();

        double deposito1 = 100.00;
        BetUtil.deposito(deposito1);
        double balanceEsperado1 = inicialBalance + deposito1;
        Assert.assertEquals(balanceEsperado1, BetUtil.getBalance(), 0.001);


        double deposito2 = 200.00;
        BetUtil.deposito(deposito2);
        double balanceEsperado2 = balanceEsperado1 + deposito2;
        Assert.assertEquals(balanceEsperado2, BetUtil.getBalance(), 0.001);
    }

    @Test
    public void testRetirar() {

        BetUtil.deposito(100.0);
        double inicialBalance = BetUtil.getBalance();
        double cantidadRetiro = 50.0;

        BetUtil.Retirar(cantidadRetiro);

        Assert.assertEquals(inicialBalance - cantidadRetiro, BetUtil.getBalance(), 0.001);
    }

    //para verificar que se lance una excepción
    //cuando se proporciona un monto de retiro inválido
    @Test(expected = IllegalArgumentException.class)
    public void testRetirarCantidadInvalida() {
        BetUtil.deposito(100.0);
        double retirarCantidad = -50.0;

        BetUtil.Retirar(retirarCantidad);
        //()-> va tener un ambiente de prueba
        Assert.assertThrows(IllegalAccessError.class, () -> BetUtil.Retirar(retirarCantidad));
    }

    @Test
    public void testPublicidad() {

        BetUtil.CampaPublicitaria campaPublicitaria = new BetUtil.CampaPublicitaria();

        Publicidad Advertisement = new Publicidad("¡Apuesta en grande y gana grande!");

        campaPublicitaria.addAdvertisement(Advertisement);

        Assert.assertEquals(1, campaPublicitaria.getAdvertisements().size());
        Assert.assertEquals("¡Apuesta en grande y gana grande!", campaPublicitaria.getAdvertisements().get(0).getMessage());
    }

    @Test
    public void MultiplePublicidad() {

        BetUtil.CampaPublicitaria publicitaria = new BetUtil.CampaPublicitaria();

        //varios anuncios publicitarios
        Publicidad advertisement1 = new Publicidad("¡Apuesta en grande y gana grande!");
        Publicidad advertisement2 = new Publicidad("¡Aprovecha nuestras promociones exclusivas!");
        Publicidad advertisement3 = new Publicidad("¡No te pierdas la emoción de las apuestas deportivas!");
        // Agrega los anuncios publicitarios a la lista de anuncios de la campaña publicitaria
        publicitaria.addAdvertisement(advertisement1);
        publicitaria.addAdvertisement(advertisement2);
        publicitaria.addAdvertisement(advertisement3);

        // Comprueba que la lista de anuncios publicitarios se actualizó correctamente
        Assert.assertEquals(3, publicitaria.getAdvertisements().size());
        Assert.assertEquals("¡Apuesta en grande y gana grande!", publicitaria.getAdvertisements().get(0).getMessage());
        Assert.assertEquals("¡Aprovecha nuestras promociones exclusivas!", publicitaria.getAdvertisements().get(1).getMessage());
        Assert.assertEquals("¡No te pierdas la emoción de las apuestas deportivas!", publicitaria.getAdvertisements().get(2).getMessage());
    }

    @Test
    public void seleccionDeEventosDeportivos() {
        BetUtil.EventoSeleccion seleccion = new BetUtil.EventoSeleccion();

            EventosSport event = new EventosSport("Evento 1", "Fútbol");

            seleccion.seleccionEvento(event);
            List<EventosSport> exclusivo = seleccion.getSelectedEvents();

            Assert.assertEquals(1, exclusivo.size());
            Assert.assertEquals(event, exclusivo.get(0));
        }

    @Test
    public void realizarApuestas() {

        String equipo1 = "Manchester United";
        String equipo2 = "Barcelona FC";
        double cuotaEquipo1 = 1.5;
        double cuotaEquipo2 = 2.5;
        BetUtil.Apuesta apuesta = new BetUtil.Apuesta(equipo1, equipo2, cuotaEquipo1, cuotaEquipo2);

        Assert.assertEquals(equipo1, apuesta.getEquipo1());
        Assert.assertEquals(equipo2, apuesta.getEquipo2());
        Assert.assertEquals(cuotaEquipo1, apuesta.getCuotaEquipo1(),0.0001);
        Assert.assertEquals(cuotaEquipo2, apuesta.getCuotaEquipo2(),0.0001);
    }

    @Test
    public void multipleRealizarApuestas() {

        String equipo1 = "Manchester United";
        String equipo2 = "Barcelona FC";
        double cuotaEquipo1 = 1.5;
        double cuotaEquipo2 = 2.5;

        BetUtil.Apuesta apuesta1 = new BetUtil.Apuesta(equipo1, equipo2, cuotaEquipo1, cuotaEquipo2);

        Assert.assertEquals(equipo1, apuesta1.getEquipo1());
        Assert.assertEquals(equipo2, apuesta1.getEquipo2());
        Assert.assertEquals(cuotaEquipo1, apuesta1.getCuotaEquipo1(),0.0001);
        Assert.assertEquals(cuotaEquipo2, apuesta1.getCuotaEquipo2(),0.0001);

        String equipo3 = "Real Madrid";
        String equipo4 = "Liverpool FC";
        double cuotaEquipo3 = 2.0;
        double cuotaEquipo4 = 3.0;

        BetUtil.Apuesta apuesta2 = new BetUtil.Apuesta(equipo3, equipo4, cuotaEquipo3, cuotaEquipo4);

        Assert.assertEquals(equipo3, apuesta2.getEquipo1());
        Assert.assertEquals(equipo4, apuesta2.getEquipo2());
        Assert.assertEquals(cuotaEquipo3, apuesta2.getCuotaEquipo1(),0.0001);
        Assert.assertEquals(cuotaEquipo4, apuesta2.getCuotaEquipo2(),0.0001);
    }
    @Test
    public void bonoficaciones() {
        double monto = 100;
        double porcentaje = 10;

        BetUtil.Bonificacion bonificacion = new BetUtil.Bonificacion(monto, porcentaje);

        double bonificacionEsperada = 100 * ((double) 10 / 100);

        Assert.assertEquals(bonificacionEsperada,  bonificacion.calcularBonificacion(), 0.0001);
    }

    @Test
    public void multipleBonificaciones() {
        double montoApuesta1 = 100;
        double porcentajeBonificacion1 = 10;

        double montoApuesta2 = 200;
        double porcentajeBonificacion2 = 20;

        double montoApuesta3 = 300;
        double porcentajeBonificacion3 = 30;

        BetUtil.Bonificacion bonificacion1 = new BetUtil.Bonificacion(montoApuesta1, porcentajeBonificacion1);
        BetUtil.Bonificacion bonificacion2 = new BetUtil.Bonificacion(montoApuesta2, porcentajeBonificacion2);
        BetUtil.Bonificacion bonificacion3 = new BetUtil.Bonificacion(montoApuesta3, porcentajeBonificacion3);

        double bonificacionEsperada1 = montoApuesta1 * ((double) porcentajeBonificacion1 / 100);
        double bonificacionEsperada2 = montoApuesta2 * ((double) porcentajeBonificacion2 / 100);
        double bonificacionEsperada3 = montoApuesta3 * ((double) porcentajeBonificacion3 / 100);

        Assert.assertEquals(bonificacionEsperada1, bonificacion1.calcularBonificacion(), 0.0001);
        Assert.assertEquals(bonificacionEsperada2, bonificacion2.calcularBonificacion(), 0.0001);
        Assert.assertEquals(bonificacionEsperada3, bonificacion3.calcularBonificacion(), 0.0001);
    }

    @Test
    public void promociones() {
        double montoApuesta = 100;
        double descuento = 20;

        BetUtil.Promocion promocion = new BetUtil.Promocion(montoApuesta, descuento);

        double montoApuestaConDescuento = montoApuesta - (montoApuesta * (descuento / 100));
        Assert.assertEquals(montoApuestaConDescuento, promocion.aplicarPromocion(), 0.0001);
    }

    @Test
    public void multiplePromociones() {
        double montoApuesta1 = 100;
        double descuento1 = 20;

        BetUtil.Promocion promocion1 = new BetUtil.Promocion(montoApuesta1, descuento1);

        double montoApuestaConDescuento1 = montoApuesta1 - (montoApuesta1 * (descuento1 / 100));

        double montoApuesta2 = 200;
        double descuento2 = 30;

        BetUtil.Promocion promocion2 = new BetUtil.Promocion(montoApuesta2, descuento2);

        double montoApuestaConDescuento2 = montoApuesta2 - (montoApuesta2 * (descuento2 / 100));
        Assert.assertEquals(montoApuestaConDescuento1, promocion1.aplicarPromocion(), 0.0001);
        Assert.assertEquals(montoApuestaConDescuento2, promocion2.aplicarPromocion(), 0.0001);
    }

    @Test
    public void resultadosEnVivo() {
        String equipo1 = "Celtic FC";
        String equipo2 = "Sevilla FC";
        int golesEquipo1 = 2;
        int golesEquipo2 = 1;

        BetUtil.ResultadoEnVivo resultadoEnVivo = new BetUtil.ResultadoEnVivo(equipo1, equipo2);

        resultadoEnVivo.actualizarResultado(golesEquipo1, golesEquipo2);

        Assert.assertEquals(golesEquipo1, resultadoEnVivo.getGolesEquipo1());
        Assert.assertEquals(golesEquipo2, resultadoEnVivo.getGolesEquipo2());
    }

    @Test
    public void multipleResultadosEnVivo() {
        String equipo1 = "Porto";
        String equipo2 = "Ajax";
        int golesEquipo1 = 2;
        int golesEquipo2 = 1;

        BetUtil.ResultadoEnVivo resultadoEnVivo1 = new BetUtil.ResultadoEnVivo(equipo1, equipo2);

        resultadoEnVivo1.actualizarResultado(golesEquipo1, golesEquipo2);

        Assert.assertEquals(golesEquipo1, resultadoEnVivo1.getGolesEquipo1());
        Assert.assertEquals(golesEquipo2, resultadoEnVivo1.getGolesEquipo2());

        String equipo3 = "Bayern Munchen";
        String equipo4 = "Chelse";
        int golesEquipo3 = 3;
        int golesEquipo4 = 0;

        BetUtil.ResultadoEnVivo resultadoEnVivo2 = new BetUtil.ResultadoEnVivo(equipo3, equipo4);

        resultadoEnVivo2.actualizarResultado(golesEquipo3, golesEquipo4);

        Assert.assertEquals(golesEquipo3, resultadoEnVivo2.getGolesEquipo1());
        Assert.assertEquals(golesEquipo4, resultadoEnVivo2.getGolesEquipo2());
    }

    @Test
    public void estadisticaDelPartido() {
        String equipo1 = "Real Madrid";
        String equipo2 = "Atltico Madrid";
        int tirosEquipo1 = 10;
        int tirosEquipo2 = 8;
        int tirosAlArcoEquipo1 = 5;
        int tirosAlArcoEquipo2 = 4;

        BetUtil.EstadisticaDelPartido estadisticaDelPartido = new BetUtil.EstadisticaDelPartido(equipo1, equipo2);

        estadisticaDelPartido.actualizarEstadisticas(tirosEquipo1, tirosEquipo2, tirosAlArcoEquipo1, tirosAlArcoEquipo2);

        Assert.assertEquals(tirosEquipo1, estadisticaDelPartido.getTirosEquipo1());
        Assert.assertEquals(tirosEquipo2, estadisticaDelPartido.getTirosEquipo2());
        Assert.assertEquals(tirosAlArcoEquipo1, estadisticaDelPartido.getTirosAlArcoEquipo1());
        Assert.assertEquals(tirosAlArcoEquipo2, estadisticaDelPartido.getTirosAlArcoEquipo2());
    }

    @Test
    public void multipleEstadisticaDelPartido() {
        String equipo1 = "Tottenhan";
        String equipo2 = "AC Milan";
        int golesEquipo1 = 2;
        int golesEquipo2 = 1;

        BetUtil.ResultadoEnVivo resultadoEnVivo1 = new BetUtil.ResultadoEnVivo(equipo1, equipo2);
        resultadoEnVivo1.actualizarResultado(golesEquipo1, golesEquipo2);

        Assert.assertEquals(golesEquipo1, resultadoEnVivo1.getGolesEquipo1());
        Assert.assertEquals(golesEquipo2, resultadoEnVivo1.getGolesEquipo2());
        // Second match statistics
        String equipo3 = "Borussia Dortmund";
        String equipo4 = "Arsenal";
        int golesEquipo3 = 3;
        int golesEquipo4 = 0;

        BetUtil.ResultadoEnVivo resultadoEnVivo2 = new BetUtil.ResultadoEnVivo(equipo3, equipo4);

        resultadoEnVivo2.actualizarResultado(golesEquipo3, golesEquipo4);

        Assert.assertEquals(golesEquipo3, resultadoEnVivo2.getGolesEquipo1());
        Assert.assertEquals(golesEquipo4, resultadoEnVivo2.getGolesEquipo2());
    }

    @Test
    public void correoElectronico() {

        BetUtil.CorreoElectronico correoElectronico =
                new BetUtil.CorreoElectronico("cliente@ejemplo.com", "Promoción de apuestas deportivas",
                        "¡Aprovecha nuestra promoción especial!");

        boolean resultadoEnvio = correoElectronico.enviarCorreo();

        Assert.assertTrue(resultadoEnvio);
    }

    @Test
    public void multipleCorreoElectronico() {

        BetUtil.CorreoElectronico correoElectronico1 =
                new BetUtil.CorreoElectronico("cliente1@ejemplo.com", "Promoción de apuestas deportivas",
                        "¡Aprovecha nuestra promoción especial!");

        boolean resultadoEnvio1 = correoElectronico1.enviarCorreo();

        Assert.assertTrue(resultadoEnvio1);

        BetUtil.CorreoElectronico correoElectronico2 =
                new BetUtil.CorreoElectronico("cliente2@ejemplo.com", "Otra promoción",
                        "Te regalamos un bono del 50% de tu proximo deposito ¡hasta s/50!");
        boolean resultadoEnvio2 = correoElectronico2.enviarCorreo();

        Assert.assertTrue(resultadoEnvio2);
    }

    @Test
    public void InvalidoCorreoElectronico()  {
        BetUtil.CorreoElectronico correoElectronico3 =
                new BetUtil.CorreoElectronico("cliente3@ejemplo.com", "Otra promoción",
                        "Tenemos otra promoción para ti");

        boolean resultadoEnvio3 = correoElectronico3.enviarCorreo();

        Assert.assertTrue(resultadoEnvio3);

        // Test escenario de falla
        BetUtil.CorreoElectronico correoElectronico4 =
               new BetUtil.CorreoElectronico("invalidemail", "Promoción",
                      "Obten hasta $50.000 en apuesta gratis - sino gana estu primera apuesta");
        boolean resultadoEnvio4 = correoElectronico4.enviarCorreo();

        Assert.assertTrue(resultadoEnvio4);
    }

    @Test
    public void pruebasDeIntegracionDePagos() {

        BetUtil.IntegracionPagos integracionPagos = new BetUtil.IntegracionPagos();

        boolean resultadoPago = integracionPagos.procesarPago("1234567812345678", "12/25/2023", "123", 100.0);

        Assert.assertTrue(resultadoPago);
    }

    @Test
    public void combinarEventos() {
        List<String> eventos = new ArrayList<>();
        eventos.add("Fútbol: Barcelona vs. Real Madrid");
        eventos.add("Baloncesto: Lakers vs. Celtics");
        eventos.add("Tenis: Federer vs. Nadal");

        String combinadoEventos = org.example.controlladores.BetUtil.VarioSports.combineEvents(eventos);

        String esperado = "Fútbol: Barcelona vs. Real Madrid\n" +
                "Baloncesto: Lakers vs. Celtics\n" +
                "Tenis: Federer vs. Nadal";
        Assert.assertEquals(esperado, combinadoEventos);

    }

    @Test
    public void ListaMultipleApuestaVariado() {
        MultipleApuesta betLugar = new MultipleApuesta();
        List<BetUtil.Bet> bets = new ArrayList<>();
        bets.add(new BetUtil.Bet("Fútbol", "Equipo A vs Equipo B", 100));
        bets.add(new BetUtil.Bet("Baloncesto", "Equipo C vs Equipo D", 50));

        double total = betLugar.placeMultipleBet(bets);

        Assert.assertEquals(150, total,0.0001);
    }
}

