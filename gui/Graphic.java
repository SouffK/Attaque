package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import engine.data.Player;

public class Graphic {
    
    public Graphic(List<Integer> scores1, List<Integer> scores2) {
	    JFreeChart chart = createChart(scores1, scores2);
	    showChart(chart);
	    
	}
	
	public JFreeChart createChart(List<Integer> scores1, List<Integer> scores2) {
	    // Créer le dataset pour les scores de chaque joueur
	    XYSeriesCollection dataset = new XYSeriesCollection();
	    XYSeries series1 = new XYSeries("Joueur 1");
	    XYSeries series2 = new XYSeries("Joueur 2");
	    for (int i = 0; i < scores1.size(); i++) {
	        series1.add(i, scores1.get(i));
	    }
	    for (int i = 0; i < scores2.size(); i++) {
	        series2.add(i, scores2.get(i));
	    }
	    dataset.addSeries(series1);
	    dataset.addSeries(series2);

	    // Créer le graphique
	    JFreeChart chart = ChartFactory.createXYLineChart(
	        "Évolution des scores",
	        "Nombre de tours",
	        "Nombre de pièces",
	        dataset,
	        PlotOrientation.VERTICAL,
	        true,
	        true,
	        false
	    );

	    // Personnaliser le graphique
	    XYPlot plot = chart.getXYPlot();
	    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
	    renderer.setSeriesPaint(0, Color.RED); // couleur de la courbe du joueur 1
	    renderer.setSeriesPaint(1, Color.BLUE); // couleur de la courbe du joueur 2
	    plot.setRenderer(renderer);
	    plot.setBackgroundPaint(Color.WHITE);
	    plot.setRangeGridlinesVisible(true);
	    plot.setRangeGridlinePaint(Color.BLACK);
	    plot.setDomainGridlinesVisible(true);
	    plot.setDomainGridlinePaint(Color.BLACK);

	    return chart;
	}
	private void showChart(JFreeChart chart) {
	    // Afficher le graphique dans une fenêtre
	    ChartFrame frame = new ChartFrame("Évolution des scores", chart);
	    frame.pack();
	    frame.setVisible(true);
	}
}
