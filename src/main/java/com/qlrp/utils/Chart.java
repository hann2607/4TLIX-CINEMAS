/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.utils;

import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author HAN-PC
 */
public class Chart {

    public static JPanel PieChart(String title, String[] element, double[] percent) throws Exception {
        //create dataset
        DefaultPieDataset barDataset = new DefaultPieDataset();
        for (int i = 0; i < element.length; i++) {
            barDataset.setValue(element[i] + " = " + percent[i] + "%", new Double(percent[i]));
        }

        //create chart
        JFreeChart piechart = ChartFactory.createPieChart(title, barDataset, false, true, false);//explain

        PiePlot piePlot = (PiePlot) piechart.getPlot();

        //changing pie chart blocks colors
        for (int i = 0; i < element.length; i++) {
            int R = (int) (Math.random() * 256);
            int G = (int) (Math.random() * 256);
            int B = (int) (Math.random() * 256);
            piePlot.setSectionPaint(element[i], new Color(R, G, B));
        }

        piePlot.setBackgroundPaint(Color.white);

        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        return barChartPanel;
    }

    public static JPanel LineChart(String title, String year, String amount, String[] element, double[] value) throws Exception {
        //create dataset for the graph
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < element.length; i++) {
            dataset.setValue(value[i], amount, element[i]);
        }

        //create chart
        JFreeChart linechart = ChartFactory.createLineChart(title, year, amount,
                dataset, PlotOrientation.VERTICAL, false, true, false);

        //create plot object
        CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
        // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);

        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204, 0, 51);
        lineRenderer.setSeriesPaint(0, lineChartColor);

        //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        return lineChartPanel;
    }

    public static JPanel BarChart(String title, String year, String amount, String[] element, double[] value) throws Exception {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < element.length; i++) {
            dataset.setValue(value[i], amount, element[i]);
        }

        JFreeChart chart = ChartFactory.createBarChart(title, year, amount,
                dataset, PlotOrientation.VERTICAL, false, true, false);

        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(204, 0, 51);
        renderer.setSeriesPaint(0, clr3);

        ChartPanel barpChartPanel = new ChartPanel(chart);
        return barpChartPanel;
    }

}
