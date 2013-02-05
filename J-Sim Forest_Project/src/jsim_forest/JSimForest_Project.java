package jsim_forest;

import bol.BOLObject;
import bol.Case;
import bol.Etat;
import bol.Step;
import gil.GILObject;


public class JSimForest_Project {

    public static void main(String[] args) {
        System.out.println("=== J-sim Forest ===");
        
        
        int stepNumber = 7;
        int wantedXTab = 7;
        int wantedYTab = 7;
        int TimeForOneStep = 5000;
        
        GILObject window = new GILObject();
        BOLObject calculate = new BOLObject();
        Step timeStep = new Step(TimeForOneStep, calculate);
        calculate.emptyTabGen(wantedXTab, wantedYTab);
        
        Case[][] newTab = new Case[7][7];
        for (int i = 0; i < wantedYTab; i++) {
            for (int j = 0; j < wantedXTab; j++) {
                newTab[j][i] = new Case(Etat.vide);
            }
        }
        newTab[3][2].setEtat(Etat.jeunePousse);
        newTab[3][3].setEtat(Etat.jeunePousse);
        newTab[4][3].setEtat(Etat.jeunePousse);
        newTab[5][3].setEtat(Etat.jeunePousse);
        
        
        System.out.println("=============SIMULATION==============");
        System.out.print("\n");
        System.out.print("\n");
        
        calculate.setUpdatedTab(newTab, wantedXTab, wantedYTab);
        
        timeStep.updateBOLObject(calculate);
        
        timeStep.setRemainingTime(stepNumber);
        timeStep.start();
        

        
        
    }
}
