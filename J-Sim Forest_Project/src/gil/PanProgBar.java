package gil;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class PanProgBar extends JPanel {
    
    private JProgressBar progressBar;

    public PanProgBar() {
        this.setPreferredSize(new Dimension(100, 40));
        progressBar = new JProgressBar(0, 100);
        progressBar.setPreferredSize(new Dimension(240, 40));
        progressBar.setStringPainted(true);
        this.add(progressBar);
    }

    public int getProgressNumber() {
        return this.progressBar.getValue();
    }

    public void setProgressNumber(int progressNumber) {
        this.progressBar.setValue(progressNumber);
    }
    
    
}
