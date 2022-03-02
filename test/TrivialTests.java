import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import smellytrivial.Game;

public class TrivialTests {
    @Test
    public void true_is_true(){
        Assertions.assertTrue(true);
    }

    @Test
    public void crear_Game(){
        Game trivial = new Game();
    }

    @Test
    public void si_al_principio_saco_un_1_voy_a_casila_1()
    {
        //Arrange
        Game sut = new Game();
        sut.agregar("María");
        sut.agregar("Juan");

        sut.tirarDado(1);

        String expected = "La nueva posición de María es 1";

        //Act
        String actual = sut.nuevaPosicionJugador();

        //Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void tener_al_menos_2_jugadores()
    {
        Game sut = new Game();
        sut.agregar("María");
        boolean expected = false;
        boolean jugable = sut.esJugable();
        Assertions.assertEquals(expected, jugable);
    }

    @Test
    public void tener_como_mucho_6_jugadores()
    {
        Game sut = new Game();
        sut.agregar("María");
        sut.agregar("Juan");
        sut.agregar("Luis");
        sut.agregar("Sergio");
        sut.agregar("Gabi");
        sut.agregar("Fernando");
        boolean jugable = sut.esJugable();
        boolean expected = true;
        Assertions.assertEquals(expected, jugable);
    }
    @Test
    public void salga_de_la_carcel()
    {
        Game sut = new Game();
        sut.agregar("María");
        sut.agregar("Juan");
        sut.tirarDado(1);
        sut.fueRespuestaCorrecta();
        sut.tirarDado(1);
        sut.respuestaIncorrecta();
        sut.tirarDado(1);
        String posicion = sut.nuevaPosicionJugador();
        String expected = "La nueva posición de María es 2";
        Assertions.assertEquals(expected, posicion);
    }
}
