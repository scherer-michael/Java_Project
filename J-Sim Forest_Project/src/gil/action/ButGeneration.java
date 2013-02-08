package gil.action;

import bol.BOLObject;
import gil.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButGeneration implements ActionListener {
    
    private BOLObject obj;
    private MainFrame frame;

    public ButGeneration(BOLObject obj, MainFrame mainFrame) {
        this.obj = obj;
        this.frame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (obj.getStep().getRemainingTime() != 0) {
            frame.getPanPara().getButGeneration().setVisible(false);
            this.obj.getStep().start(obj, frame);
            frame.getPanPara().getButPause().setVisible(true);
        }
    }
}