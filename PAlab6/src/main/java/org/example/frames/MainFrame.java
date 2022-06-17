package org.example.frames;

import org.example.panels.ConfigPanel;
import org.example.panels.ControlPanel;
import org.example.panels.DrawingPanel;

import javax.swing.*;
import java.awt.*;

/**
 * MainFrame este fereastra principala a programului, aici vor fi incluse ConfigPanel ControlPanel si DrawingPanel
 */

public class MainFrame extends JFrame {
    public ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("my application");
        init();
    }

    public DrawingPanel getCanvas() {
        return canvas;
    }

    public ConfigPanel getConfigPanel() {
        return configPanel;
    }

    public void init(){

        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);

        setLayout(new BorderLayout());

        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        add(canvas, BorderLayout.CENTER);

        pack();





    }


}
