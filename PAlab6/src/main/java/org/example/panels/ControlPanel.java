package org.example.panels;

import org.example.frames.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * ContraolPanel este folosit pentru a salva, sau a incarca un fisier cu imaginea desenata
 * Contine si un butor de exit pentru a opri programul
 */

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");

    public ControlPanel(MainFrame frame){
        this.frame = frame;
        init();
    }



    private void init(){
        setLayout(new GridLayout(1, 4));
        add(exitBtn);
        add(loadBtn);
        add(saveBtn);
        add(resetBtn);

        exitBtn.addActionListener(this::exit);
        loadBtn.addActionListener(this::load);
        saveBtn.addActionListener(this::save);



    }

    private void save(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(frame);
        if (option == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            try {
                ImageIO.write(frame.getCanvas().image, "PNG", file);
            } catch (IOException ex) {
                System.err.print(ex);
            }
            saveBtn.setText("fisier salvat ca: " + file.getName());
        }
        else {
            saveBtn.setText("s-a anulat comanda save");
        }
    }

    private void load(ActionEvent e){
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(frame);
        if (option == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            try {
                frame.getCanvas().offscreen.drawImage(ImageIO.read(file), 0 , 0, frame);
                frame.repaint();
            } catch (IOException ex) {
                System.out.println(ex);
            }
            loadBtn.setText("imagine incarcata: " + file.getName());
        }
        else {
            loadBtn.setText("comanda load a fost anulata");
        }
    }

    private void exit(ActionEvent e) {
        frame.dispose();
    }





}
