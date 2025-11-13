/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
/**
 *
 * @author vince
 */

import javax.swing.*;
import java.awt.*;

public class ChartBuilder {
    public static JPanel buildComparisonChart(long serialTime, long parallelTime) {
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                double serialMins = serialTime / 60_000_000_000.0;
                double parallelMins = parallelTime / 60_000_000_000.0;
                double maxTime = Math.max(serialMins, parallelMins) + 0.0001; 
                
                int chartWidth = Math.max(getWidth() - 200, 100); 
                int startX = 70; 
                int serialBarWidth = (int)((serialMins / maxTime) * chartWidth);
                int parallelBarWidth = (int)((parallelMins / maxTime) * chartWidth);

                g.setColor(Color.RED);
                g.fillRect(startX, 50, serialBarWidth, 30);
                
                g.setColor(Color.GREEN);
                g.fillRect(startX, 100, parallelBarWidth, 30);
                
                g.setColor(Color.BLACK);
                g.drawString("Serie:", 10, 70);
                g.drawString("Paralelo:", 10, 120);
                
                String serialText = String.format("%.4f min", serialMins);
                String parallelText = String.format("%.4f min", parallelMins);
                
                g.drawString(serialText, startX + serialBarWidth + 5, 70);
                g.drawString(parallelText, startX + parallelBarWidth + 5, 120);
            }
        };
        panel.setPreferredSize(new Dimension(500, 200)); 
        panel.setBorder(BorderFactory.createTitledBorder("Resultados del Stress Test"));
        return panel;
    }
}