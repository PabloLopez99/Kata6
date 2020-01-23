package View;

import java.awt.Dimension;
import static javafx.scene.input.KeyCode.T;
import javax.swing.JPanel;
import Model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay<T> extends ApplicationFrame {
    private final Histogram<T> histogram;
    private String namEjeX; 
    
    public HistogramDisplay(Histogram<T> Histogram, String nameEjeX) {
        super("Kata 6: HISTOGRAMA");
        this.histogram = Histogram;
        this.namEjeX = nameEjeX;
        setContentPane(createPanel());
        pack();
    }

    public void execute(){
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private JPanel createPanel() {
        ChartPanel charPanel = new ChartPanel(createChart(createDataset()));
        charPanel.setPreferredSize(new Dimension(500,400));
        return charPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataset){
        JFreeChart FreeChart = ChartFactory.createBarChart(
                "Histograma JFreeChart",
                namEjeX,
                "Nº Emails",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                rootPaneCheckingEnabled,
                rootPaneCheckingEnabled);
        return FreeChart;
    }
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (T key : histogram.keySet()) {
            dataset.addValue(histogram.getKey(key),"",(Comparable)key);
        }
        return dataset;
    }
    
}
