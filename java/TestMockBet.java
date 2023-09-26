import org.example.controlladores.BetUtil;
import org.example.modelo.EventosSport;
import org.example.modelo.MultipleApuesta;
import org.example.modelo.Publicidad;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestMockBet {
    @Test
    public void testDeposito() {
        BetUtil betUtilMock = Mockito.mock(BetUtil.class);

        double inicialBalance = 500.00;
        Mockito.when(betUtilMock.getBalance()).thenReturn(inicialBalance);

        double deposito = 100.00;
        betUtilMock.deposito(deposito);

        Assert.assertEquals(inicialBalance + deposito, betUtilMock.getBalance(), 0.001);
    }
    @Test
    public void multipleDeposito() {

        BetUtil betUtilMock = Mockito.mock(BetUtil.class);

        // Establecer el saldo inicial
        double inicialBalance = 500.00;
        Mockito.when(betUtilMock.getBalance()).thenReturn(inicialBalance);

        // Realizar el primer depósito
        double deposito1 = 100.00;
        betUtilMock.deposito(deposito1);
        double balanceEsperado1 = inicialBalance + deposito1;
        Assert.assertEquals(balanceEsperado1, betUtilMock.getBalance(), 0.001);

        double deposito2 = 200.00;
        betUtilMock.deposito(deposito2);
        double balanceEsperado2 = balanceEsperado1 + deposito2;
        Assert.assertEquals(balanceEsperado2, betUtilMock.getBalance(), 0.001);
    }
    @Test
    public void testRetirar() {

        BetUtil betUtilMock = Mockito.mock(BetUtil.class);

        double inicialBalance = 100.0;
        Mockito.when(betUtilMock.getBalance()).thenReturn(inicialBalance);

        double cantidadRetiro = 50.0;
        betUtilMock.Retirar(cantidadRetiro);

        Assert.assertEquals(inicialBalance - cantidadRetiro, betUtilMock.getBalance(), 0.001);
    }
    @Test
    public void testPublicidad() {
        // Crear objetos mocks de las clases necesarias
        BetUtil.CampaPublicitaria campaPublicitariaMock = Mockito.mock(BetUtil.CampaPublicitaria.class);
        Publicidad advertisementMock = Mockito.mock(Publicidad.class);

        // Configurar el comportamiento esperado de los mocks
        Mockito.when(advertisementMock.getMessage()).thenReturn("¡Apuesta en grande y gana grande!");
        Mockito.when(campaPublicitariaMock.getAdvertisements()).thenReturn(Collections.singletonList(advertisementMock));

        // Realizar las operaciones y verificar los resultados
        campaPublicitariaMock.addAdvertisement(advertisementMock);

        Assert.assertEquals(1, campaPublicitariaMock.getAdvertisements().size());
        Assert.assertEquals("¡Apuesta en grande y gana grande!", campaPublicitariaMock.getAdvertisements().get(0).getMessage());
    }
    @Test
    public void MultiplePublicidad() {
        BetUtil.CampaPublicitaria publicitariaMock = Mockito.mock(BetUtil.CampaPublicitaria.class);

        Publicidad advertisement1Mock = Mockito.mock(Publicidad.class);
        Publicidad advertisement2Mock = Mockito.mock(Publicidad.class);
        Publicidad advertisement3Mock = Mockito.mock(Publicidad.class);

        Mockito.when(advertisement1Mock.getMessage()).thenReturn("¡Apuesta en grande y gana grande!");
        Mockito.when(advertisement2Mock.getMessage()).thenReturn("¡Aprovecha nuestras promociones exclusivas!");
        Mockito.when(advertisement3Mock.getMessage()).thenReturn("¡No te pierdas la emoción de las apuestas deportivas!");

        publicitariaMock.addAdvertisement(advertisement1Mock);
        publicitariaMock.addAdvertisement(advertisement2Mock);
        publicitariaMock.addAdvertisement(advertisement3Mock);

        Assert.assertEquals(3, publicitariaMock.getAdvertisements().size());
        Assert.assertEquals("¡Apuesta en grande y gana grande!", publicitariaMock.getAdvertisements().get(0).getMessage());
        Assert.assertEquals("¡Aprovecha nuestras promociones exclusivas!", publicitariaMock.getAdvertisements().get(1).getMessage());
        Assert.assertEquals("¡No te pierdas la emoción de las apuestas deportivas!", publicitariaMock.getAdvertisements().get(2).getMessage());
    }
    @Test
    public void seleccionDeEventosDeportivos() {
        BetUtil.EventoSeleccion seleccionMock = Mockito.mock(BetUtil.EventoSeleccion.class);

        EventosSport eventMock = Mockito.mock(EventosSport.class);

        seleccionMock.seleccionEvento(eventMock);
        List<EventosSport> exclusivo = seleccionMock.getSelectedEvents();

        Assert.assertEquals(1, exclusivo.size());
        Assert.assertEquals(eventMock, exclusivo.get(0));
    }
    @Test
    public void realizarApuestas() {
        String equipo1 = "Manchester United";
        String equipo2 = "Barcelona FC";
        double cuotaEquipo1 = 1.5;
        double cuotaEquipo2 = 2.5;

        BetUtil.Apuesta apuestaMock = Mockito.mock(BetUtil.Apuesta.class);

        Mockito.when(apuestaMock.getEquipo1()).thenReturn(equipo1);
        Mockito.when(apuestaMock.getEquipo2()).thenReturn(equipo2);
        Mockito.when(apuestaMock.getCuotaEquipo1()).thenReturn(cuotaEquipo1);
        Mockito.when(apuestaMock.getCuotaEquipo2()).thenReturn(cuotaEquipo2);

        Assert.assertEquals(equipo1, apuestaMock.getEquipo1());
        Assert.assertEquals(equipo2, apuestaMock.getEquipo2());
        Assert.assertEquals(cuotaEquipo1, apuestaMock.getCuotaEquipo1(), 0.0001);
        Assert.assertEquals(cuotaEquipo2, apuestaMock.getCuotaEquipo2(), 0.0001);
    }
    @Test
    public void multipleRealizarApuestas() {
        String equipo1 = "Manchester United";
        String equipo2 = "Barcelona FC";
        double cuotaEquipo1 = 1.5;
        double cuotaEquipo2 = 2.5;

        BetUtil.Apuesta apuesta1Mock = Mockito.mock(BetUtil.Apuesta.class);

        Mockito.when(apuesta1Mock.getEquipo1()).thenReturn(equipo1);
        Mockito.when(apuesta1Mock.getEquipo2()).thenReturn(equipo2);
        Mockito.when(apuesta1Mock.getCuotaEquipo1()).thenReturn(cuotaEquipo1);
        Mockito.when(apuesta1Mock.getCuotaEquipo2()).thenReturn(cuotaEquipo2);

        Assert.assertEquals(equipo1, apuesta1Mock.getEquipo1());
        Assert.assertEquals(equipo2, apuesta1Mock.getEquipo2());
        Assert.assertEquals(cuotaEquipo1, apuesta1Mock.getCuotaEquipo1(), 0.0001);
        Assert.assertEquals(cuotaEquipo2, apuesta1Mock.getCuotaEquipo2(), 0.0001);

        String equipo3 = "Real Madrid";
        String equipo4 = "Liverpool FC";
        double cuotaEquipo3 = 2.0;
        double cuotaEquipo4 = 3.0;

        BetUtil.Apuesta apuesta2Mock = Mockito.mock(BetUtil.Apuesta.class);

        Mockito.when(apuesta2Mock.getEquipo1()).thenReturn(equipo3);
        Mockito.when(apuesta2Mock.getEquipo2()).thenReturn(equipo4);
        Mockito.when(apuesta2Mock.getCuotaEquipo1()).thenReturn(cuotaEquipo3);
        Mockito.when(apuesta2Mock.getCuotaEquipo2()).thenReturn(cuotaEquipo4);

        Assert.assertEquals(equipo3, apuesta2Mock.getEquipo1());
        Assert.assertEquals(equipo4, apuesta2Mock.getEquipo2());
        Assert.assertEquals(cuotaEquipo3, apuesta2Mock.getCuotaEquipo1(), 0.0001);
        Assert.assertEquals(cuotaEquipo4, apuesta2Mock.getCuotaEquipo2(), 0.0001);
    }
    @Test
    public void bonoficaciones() {
        double monto = 100;
        double porcentaje = 10;

        BetUtil.Bonificacion bonificacionMock = Mockito.mock(BetUtil.Bonificacion.class);

        Mockito.when(bonificacionMock.calcularBonificacion()).thenReturn(monto * (porcentaje / 100.0));

        double bonificacionEsperada = monto * (porcentaje / 100.0);

        Assert.assertEquals(bonificacionEsperada, bonificacionMock.calcularBonificacion(), 0.0001);
    }
    @Test
    public void multipleBonificaciones() {
        double montoApuesta1 = 100;
        double porcentajeBonificacion1 = 10;

        double montoApuesta2 = 200;
        double porcentajeBonificacion2 = 20;

        double montoApuesta3 = 300;
        double porcentajeBonificacion3 = 30;

        BetUtil.Bonificacion bonificacion1Mock = Mockito.mock(BetUtil.Bonificacion.class);
        BetUtil.Bonificacion bonificacion2Mock = Mockito.mock(BetUtil.Bonificacion.class);
        BetUtil.Bonificacion bonificacion3Mock = Mockito.mock(BetUtil.Bonificacion.class);

        Mockito.when(bonificacion1Mock.calcularBonificacion()).thenReturn(montoApuesta1 * (porcentajeBonificacion1 / 100.0));
        Mockito.when(bonificacion2Mock.calcularBonificacion()).thenReturn(montoApuesta2 * (porcentajeBonificacion2 / 100.0));
        Mockito.when(bonificacion3Mock.calcularBonificacion()).thenReturn(montoApuesta3 * (porcentajeBonificacion3 / 100.0));

        double bonificacionEsperada1 = montoApuesta1 * (porcentajeBonificacion1 / 100.0);
        double bonificacionEsperada2 = montoApuesta2 * (porcentajeBonificacion2 / 100.0);
        double bonificacionEsperada3 = montoApuesta3 * (porcentajeBonificacion3 / 100.0);

        Assert.assertEquals(bonificacionEsperada1, bonificacion1Mock.calcularBonificacion(), 0.0001);
        Assert.assertEquals(bonificacionEsperada2, bonificacion2Mock.calcularBonificacion(), 0.0001);
        Assert.assertEquals(bonificacionEsperada3, bonificacion3Mock.calcularBonificacion(), 0.0001);
    }
    @Test
    public void promociones() {
        double montoApuesta = 100;
        double descuento = 20;

        BetUtil.Promocion promocionMock = Mockito.mock(BetUtil.Promocion.class);

        Mockito.when(promocionMock.aplicarPromocion()).thenReturn(montoApuesta - (montoApuesta * (descuento / 100)));

        double montoApuestaConDescuento = montoApuesta - (montoApuesta * (descuento / 100));
        Assert.assertEquals(montoApuestaConDescuento, promocionMock.aplicarPromocion(), 0.0001);
    }
    @Test
    public void multiplePromociones() {
        double montoApuesta1 = 100;
        double descuento1 = 20;

        BetUtil.Promocion promocion1Mock = Mockito.mock(BetUtil.Promocion.class);
        Mockito.when(promocion1Mock.aplicarPromocion()).thenReturn(montoApuesta1 - (montoApuesta1 * (descuento1 / 100)));

        double montoApuestaConDescuento1 = montoApuesta1 - (montoApuesta1 * (descuento1 / 100));

        double montoApuesta2 = 200;
        double descuento2 = 30;

        BetUtil.Promocion promocion2Mock = Mockito.mock(BetUtil.Promocion.class);
        Mockito.when(promocion2Mock.aplicarPromocion()).thenReturn(montoApuesta2 - (montoApuesta2 * (descuento2 / 100)));

        double montoApuestaConDescuento2 = montoApuesta2 - (montoApuesta2 * (descuento2 / 100));

        Assert.assertEquals(montoApuestaConDescuento1, promocion1Mock.aplicarPromocion(), 0.0001);
        Assert.assertEquals(montoApuestaConDescuento2, promocion2Mock.aplicarPromocion(), 0.0001);
    }
    @Test
    public void resultadosEnVivo() {
        String equipo1 = "Celtic FC";
        String equipo2 = "Sevilla FC";
        int golesEquipo1 = 2;
        int golesEquipo2 = 1;

        BetUtil.ResultadoEnVivo resultadoEnVivoMock = Mockito.mock(BetUtil.ResultadoEnVivo.class);
        resultadoEnVivoMock.actualizarResultado(golesEquipo1, golesEquipo2);

        Mockito.when(resultadoEnVivoMock.getGolesEquipo1()).thenReturn(golesEquipo1);
        Mockito.when(resultadoEnVivoMock.getGolesEquipo2()).thenReturn(golesEquipo2);

        Assert.assertEquals(golesEquipo1, resultadoEnVivoMock.getGolesEquipo1());
        Assert.assertEquals(golesEquipo2, resultadoEnVivoMock.getGolesEquipo2());
    }
    @Test
    public void multipleResultadosEnVivo() {
        String equipo1 = "Porto";
        String equipo2 = "Ajax";
        int golesEquipo1 = 2;
        int golesEquipo2 = 1;

        BetUtil.ResultadoEnVivo resultadoEnVivo1Mock = Mockito.mock(BetUtil.ResultadoEnVivo.class);
        resultadoEnVivo1Mock.actualizarResultado(golesEquipo1, golesEquipo2);

        Mockito.when(resultadoEnVivo1Mock.getGolesEquipo1()).thenReturn(golesEquipo1);
        Mockito.when(resultadoEnVivo1Mock.getGolesEquipo2()).thenReturn(golesEquipo2);

        Assert.assertEquals(golesEquipo1, resultadoEnVivo1Mock.getGolesEquipo1());
        Assert.assertEquals(golesEquipo2, resultadoEnVivo1Mock.getGolesEquipo2());

        String equipo3 = "Bayern Munchen";
        String equipo4 = "Chelse";
        int golesEquipo3 = 3;
        int golesEquipo4 = 0;

        BetUtil.ResultadoEnVivo resultadoEnVivo2Mock = Mockito.mock(BetUtil.ResultadoEnVivo.class);
        resultadoEnVivo2Mock.actualizarResultado(golesEquipo3, golesEquipo4);

        Mockito.when(resultadoEnVivo2Mock.getGolesEquipo1()).thenReturn(golesEquipo3);
        Mockito.when(resultadoEnVivo2Mock.getGolesEquipo2()).thenReturn(golesEquipo4);

        Assert.assertEquals(golesEquipo3, resultadoEnVivo2Mock.getGolesEquipo1());
        Assert.assertEquals(golesEquipo4, resultadoEnVivo2Mock.getGolesEquipo2());
    }
    @Test
    public void estadisticaDelPartido() {
        String equipo1 = "Real Madrid";
        String equipo2 = "Atltico Madrid";
        int tirosEquipo1 = 10;
        int tirosEquipo2 = 8;
        int tirosAlArcoEquipo1 = 5;
        int tirosAlArcoEquipo2 = 4;

        BetUtil.EstadisticaDelPartido estadisticaDelPartidoMock = Mockito.mock(BetUtil.EstadisticaDelPartido.class);
        estadisticaDelPartidoMock.actualizarEstadisticas(tirosEquipo1, tirosEquipo2, tirosAlArcoEquipo1, tirosAlArcoEquipo2);

        Mockito.when(estadisticaDelPartidoMock.getTirosEquipo1()).thenReturn(tirosEquipo1);
        Mockito.when(estadisticaDelPartidoMock.getTirosEquipo2()).thenReturn(tirosEquipo2);
        Mockito.when(estadisticaDelPartidoMock.getTirosAlArcoEquipo1()).thenReturn(tirosAlArcoEquipo1);
        Mockito.when(estadisticaDelPartidoMock.getTirosAlArcoEquipo2()).thenReturn(tirosAlArcoEquipo2);

        Assert.assertEquals(tirosEquipo1, estadisticaDelPartidoMock.getTirosEquipo1());
        Assert.assertEquals(tirosEquipo2, estadisticaDelPartidoMock.getTirosEquipo2());
        Assert.assertEquals(tirosAlArcoEquipo1, estadisticaDelPartidoMock.getTirosAlArcoEquipo1());
        Assert.assertEquals(tirosAlArcoEquipo2, estadisticaDelPartidoMock.getTirosAlArcoEquipo2());
    }
    @Test
    public void multipleEstadisticaDelPartido() {
        String equipo1 = "Tottenhan";
        String equipo2 = "AC Milan";
        int golesEquipo1 = 2;
        int golesEquipo2 = 1;

        BetUtil.ResultadoEnVivo resultadoEnVivoMock1 = Mockito.mock(BetUtil.ResultadoEnVivo.class);
        resultadoEnVivoMock1.actualizarResultado(golesEquipo1, golesEquipo2);

        Mockito.when(resultadoEnVivoMock1.getGolesEquipo1()).thenReturn(golesEquipo1);
        Mockito.when(resultadoEnVivoMock1.getGolesEquipo2()).thenReturn(golesEquipo2);

        Assert.assertEquals(golesEquipo1, resultadoEnVivoMock1.getGolesEquipo1());
        Assert.assertEquals(golesEquipo2, resultadoEnVivoMock1.getGolesEquipo2());

        // Second match statistics
        String equipo3 = "Borussia Dortmund";
        String equipo4 = "Arsenal";
        int golesEquipo3 = 3;
        int golesEquipo4 = 0;

        BetUtil.ResultadoEnVivo resultadoEnVivoMock2 = Mockito.mock(BetUtil.ResultadoEnVivo.class);
        resultadoEnVivoMock2.actualizarResultado(golesEquipo3, golesEquipo4);

        Mockito.when(resultadoEnVivoMock2.getGolesEquipo1()).thenReturn(golesEquipo3);
        Mockito.when(resultadoEnVivoMock2.getGolesEquipo2()).thenReturn(golesEquipo4);

        Assert.assertEquals(golesEquipo3, resultadoEnVivoMock2.getGolesEquipo1());
        Assert.assertEquals(golesEquipo4, resultadoEnVivoMock2.getGolesEquipo2());
    }
    @Test
    public void correoElectronico() {
        String destinatario = "cliente@ejemplo.com";
        String asunto = "Promoción de apuestas deportivas";
        String mensaje = "¡Aprovecha nuestra promoción especial!";

        BetUtil.CorreoElectronico correoElectronicoMock = Mockito.mock(BetUtil.CorreoElectronico.class);
        Mockito.when(correoElectronicoMock.enviarCorreo()).thenReturn(true);

        boolean resultadoEnvio = correoElectronicoMock.enviarCorreo();

        Assert.assertTrue(resultadoEnvio);
    }
    @Test
    public void multipleCorreoElectronico() {
        String destinatario1 = "cliente1@ejemplo.com";
        String asunto1 = "Promoción de apuestas deportivas";
        String mensaje1 = "¡Aprovecha nuestra promoción especial!";

        BetUtil.CorreoElectronico correoElectronicoMock1 = Mockito.mock(BetUtil.CorreoElectronico.class);
        Mockito.when(correoElectronicoMock1.enviarCorreo()).thenReturn(true);

        boolean resultadoEnvio1 = correoElectronicoMock1.enviarCorreo();

        Assert.assertTrue(resultadoEnvio1);

        String destinatario2 = "cliente2@ejemplo.com";
        String asunto2 = "Otra promoción";
        String mensaje2 = "Te regalamos un bono del 50% de tu próximo depósito ¡hasta s/50!";

        BetUtil.CorreoElectronico correoElectronicoMock2 = Mockito.mock(BetUtil.CorreoElectronico.class);
        Mockito.when(correoElectronicoMock2.enviarCorreo()).thenReturn(true);

        boolean resultadoEnvio2 = correoElectronicoMock2.enviarCorreo();

        Assert.assertTrue(resultadoEnvio2);
    }
    @Test
    public void InvalidoCorreoElectronico() {
        String destinatario3 = "cliente3@ejemplo.com";
        String asunto3 = "Otra promoción";
        String mensaje3 = "Tenemos otra promoción para ti";

        BetUtil.CorreoElectronico correoElectronicoMock3 = Mockito.mock(BetUtil.CorreoElectronico.class);
        Mockito.when(correoElectronicoMock3.enviarCorreo()).thenReturn(true);

        boolean resultadoEnvio3 = correoElectronicoMock3.enviarCorreo();

        Assert.assertTrue(resultadoEnvio3);

        String destinatario4 = "invalidemail";
        String asunto4 = "Promoción";
        String mensaje4 = "Obten hasta $50.000 en apuesta gratis - sino gana estu primera apuesta";

        BetUtil.CorreoElectronico correoElectronicoMock4 = Mockito.mock(BetUtil.CorreoElectronico.class);
        Mockito.when(correoElectronicoMock4.enviarCorreo()).thenReturn(true);

        boolean resultadoEnvio4 = correoElectronicoMock4.enviarCorreo();

        Assert.assertTrue(resultadoEnvio4);
    }
    @Test
    public void pruebasDeIntegracionDePagos() {
        String numeroTarjeta = "1234567812345678";
        String fechaExpiracion = "12/25/2023";
        String codigoSeguridad = "123";
        double monto = 100.0;

        BetUtil.IntegracionPagos integracionPagosMock = Mockito.mock(BetUtil.IntegracionPagos.class);
        Mockito.when(integracionPagosMock.procesarPago(numeroTarjeta, fechaExpiracion, codigoSeguridad, monto))
                .thenReturn(true);

        boolean resultadoPago = integracionPagosMock.procesarPago(numeroTarjeta, fechaExpiracion, codigoSeguridad, monto);

        Assert.assertTrue(resultadoPago);
    }
    @Test
    public void combinarEventos() {
        List<String> eventos = new ArrayList<>();
        eventos.add("Fútbol: Barcelona vs. Real Madrid");
        eventos.add("Baloncesto: Lakers vs. Celtics");
        eventos.add("Tenis: Federer vs. Nadal");

        BetUtil.VarioSports varioSportsMock = Mockito.mock(BetUtil.VarioSports.class);
        Mockito.when(varioSportsMock.combineEvents(eventos))
                .thenReturn("Fútbol: Barcelona vs. Real Madrid\n" +
                        "Baloncesto: Lakers vs. Celtics\n" +
                        "Tenis: Federer vs. Nadal");

        String combinadoEventos = varioSportsMock.combineEvents(eventos);

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

        BetUtil.MultipleApuesta multipleApuestaMock = Mockito.mock(BetUtil.MultipleApuesta.class);
        Mockito.when(multipleApuestaMock.placeMultipleBet(bets)).thenReturn(150.0);

        double total = multipleApuestaMock.placeMultipleBet(bets);

        Assert.assertEquals(150, total, 0.0001);
    }
}


