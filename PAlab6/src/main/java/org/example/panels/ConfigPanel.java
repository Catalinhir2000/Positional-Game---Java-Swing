package org.example.panels;

import org.example.frames.MainFrame;

import javax.swing.*;

/**
 * DrawingPanel isi va lua configuratia din ConfigPanel si anume numar de linii coloane ale grid-ului
 */

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner rowSpinner;
    JSpinner colSpinner;
    private int rows = 10, cols = 10;
    JButton createButton = new JButton("create");

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init(){
        label = new JLabel("Grid size:");
        rowSpinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        rowSpinner.setValue(rows);
        colSpinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        colSpinner.setValue(cols);

        add(label);
        add(rowSpinner);
        add(colSpinner);
        add(createButton);
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}

