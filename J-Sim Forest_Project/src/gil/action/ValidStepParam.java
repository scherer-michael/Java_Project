
package gil.action;

import bol.BOLObject;
import gil.MainFrame;
import gil.PanPara;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValidStepParam implements ActionListener {
    
    BOLObject obj;
    MainFrame frame;
    

    public ValidStepParam(BOLObject obj, MainFrame frame) {
        this.obj = obj;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PanPara panelParam = (PanPara) ((Component)e.getSource()).getParent();
        int StepNumber = Integer.valueOf(panelParam.getTfStepNumber().getText());
        int StepSpeed = panelParam.getSlStepSpeed().getValue();
        obj.getStep().setStepParameter(StepNumber, StepSpeed);
        
        panelParam.getTfStep().setEnabled(false);
        panelParam.getTfStepNumber().setEnabled(false);
        panelParam.getSlStepSpeed().setEnabled(false);
        panelParam.getSliderNumber().setEnabled(false);
        //panelParam.getButStepValid().setVisible(false);
        
        for (int j = 0; j < frame.getPanGraphic().getGridWidth(); j++) {
            for (int i = 0; i < frame.getPanGraphic().getGridLength(); i++) {
                frame.getPanGraphic().getGrid()[i][j].addMouseListener(new SetColorJPanelCell(obj, frame));
            }
        }
        
        panelParam.getCbFireMode().setVisible(true);
        panelParam.getCbInvasionMode().setVisible(true);
        panelParam.getRadioPanel().setVisible(true);
        panelParam.getButGeneration().setEnabled(true);
        panelParam.getButNext().setEnabled(true);
        
        frame.getPanMenu().getGeneItem().setEnabled(true);
        frame.getPanMenu().getFireItem().setEnabled(true);
        frame.getPanMenu().getInfectItem().setEnabled(true);
    }
    
}
