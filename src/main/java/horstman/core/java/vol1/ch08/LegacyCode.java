package horstman.core.java.vol1.ch08;

import javax.swing.*;
import java.awt.*;
import java.util.Dictionary;
import java.util.Hashtable;

@SuppressWarnings("unchecked")
public class LegacyCode {
//    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        JSlider slider = new JSlider();
        Dictionary<Integer, Component> labelTable = new Hashtable<>();
        labelTable.put(0, new JLabel(new ImageIcon("nine.gif")));
        labelTable.put(20, new JLabel(new ImageIcon("ten.gif")));
        slider.setLabelTable(labelTable);

//        @SuppressWarnings("unchecked")
        Dictionary<Integer, Component> labelTable2 = slider.getLabelTable(); // warning
    }
}
