package interfaces;

public interface TimeTrackable {

    void startJob(); // Inicia el seguimiento del tiempo del trabajo
    void finishJob(); // Finaliza el seguimiento del tiempo del trabajo
    int durationJob(); // Devuelve la duracion del trabajo en horas

}
