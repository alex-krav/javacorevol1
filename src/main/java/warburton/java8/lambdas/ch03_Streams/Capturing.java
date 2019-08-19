package warburton.java8.lambdas.ch03_Streams;

import java.awt.*;
import java.awt.event.ActionEvent;

public class Capturing {
    private ActionEvent lastEvent;
    private Button button;

    private void registerHandler() {
        button.addActionListener(event -> this.lastEvent = event);
    }

    public void main(String[] args) {
//        ActionEvent localEvent = null;
//        button.addActionListener(event -> localEvent = event);
    }
}
