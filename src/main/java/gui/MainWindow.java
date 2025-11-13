/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author vince
 */

import monitor.HardwareInfo;
import monitor.StressTest;
import utils.ChartBuilder;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        setTitle("Monitor de Hardware");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        HardwareInfo hi = new HardwareInfo();
        JTextArea infoArea = new JTextArea();
        infoArea.setText(hi.getCPUInfo() + "\n\n" + hi.getRAMInfo() + "\n\n" +
                         hi.getMotherboardInfo() + "\n\n" + hi.getGPUInfo());
        add(new JScrollPane(infoArea), BorderLayout.CENTER);

        JButton stressButton = new JButton("Ejecutar prueba de estrés");
        stressButton.addActionListener(e -> {
            try {
                StressTest st = new StressTest();
                long serial = st.runSerialTest();
                long parallel = st.runParallelTest();
                JOptionPane.showMessageDialog(this, "Serie: " + serial / 1e6 + " ms\nParalelo: " + parallel / 1e6 + " ms");
                add(ChartBuilder.buildComparisonChart(serial, parallel), BorderLayout.SOUTH);
                revalidate();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        add(stressButton, BorderLayout.NORTH);
    }
}

