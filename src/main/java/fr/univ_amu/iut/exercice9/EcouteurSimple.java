package fr.univ_amu.iut.exercice9;

import javafx.event.EventHandler;
import javafx.event.Event;

public class EcouteurSimple implements EventHandler {

    @Override
    public void handle(Event event) {
        System.out.println("Bouton actionné");
    }
}
