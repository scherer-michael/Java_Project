package gil;

import bol.Case;
import bol.Etat;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanGraphic extends JPanel{
    private JButton[][] grid;
    private Case[][] tabToShow;
    private int gridWidth;
    private int gridLength;

    public PanGraphic( Case[][] tabToShow){
        this.setPreferredSize(new Dimension(600, 500));
        this.gridLength = 0;
        this.gridWidth = 0;
        this.tabToShow = tabToShow;
        this.grid = new JButton[gridWidth][gridLength];
    }
    
    private void updateGrid() {
        this.setLayout(new GridLayout(this.gridWidth, this.gridLength));
        grid = new JButton[this.gridWidth][this.gridLength];
        for(int y=0; y<this.gridLength; y++)
        {
            for(int x=0; x<this.gridWidth; x++)
            {
                this.ConvertCellGrid(x, y);
                this.add(grid[x][y]); //ajout des boutons
                this.ConvertGridCell(x, y);
            }
        }
    }
    
    private void ConvertCellGrid(int x, int y) 
    {
        switch (tabToShow[x][y].getEtat()) 
        {
            case vide:        //vide -- blanc -- 255,255,255 -- 0
                this.grid[x][y].setBackground(new Color(255, 255, 255));
                break;
            case jeunePousse:  //jeune pousse -- vert clair -- 147,208,81 -- 1
                this.grid[x][y].setBackground(new Color(147,208,81));
                break;
            case arbuste:       //arbuste -- vert -- 52,153,51 -- 2
                this.grid[x][y].setBackground(new Color(52,153,51));
                break;
            case arbre:         //arbre -- vert foncée  -- 1,73,0 -- 3
                this.grid[x][y].setBackground(new Color(1,73,0));
                break;
            case feu:           //feu -- rouge -- 231,31,27 -- 4
                this.grid[x][y].setBackground(new Color(231,31,27));
                break;
            case cendre:        //cendre -- gris -- 129,130,129 -- 5
                this.grid[x][y].setBackground(new Color(129,130,129));
                break;
            case infecte:       //infecte -- violet -- 109,58,150 -- 6
                this.grid[x][y].setBackground(new Color(109,58,150));
                break;
            default:
                this.grid[x][y].setBackground(new Color(255, 255, 255));
                break;
        }
    }
    private void ConvertGridCell(int x, int y) 
    {
        switch (grid[x][y].getBackground().getRGB()) {
            case -1:        //vide -- blanc -- 255,255,255 -- 0
                tabToShow[x][y].setEtat(Etat.vide);
                break;
            case -7090095:  //jeune pousse -- vert clair -- 147,208,81 -- 1
                tabToShow[x][y].setEtat(Etat.jeunePousse);
                break;
            case -13330125: //arbuste -- vert -- 52,153,51 -- 2
                tabToShow[x][y].setEtat(Etat.arbuste);
                break;
            case -16692992: //arbre -- vert foncée  -- 1,73,0 -- 3
                tabToShow[x][y].setEtat(Etat.arbre);
                break;
            case -1630437:  //feu -- rouge -- 231,31,27 -- 4
                tabToShow[x][y].setEtat(Etat.feu);
                break;
            case -8289663:  //cendre -- gris -- 129,130,129 -- 5
                tabToShow[x][y].setEtat(Etat.cendre);
                break;
            case -9618794:  //infecte -- violet -- 109,58,150 -- 6
                tabToShow[x][y].setEtat(Etat.infecte);
                break;
            default:
                tabToShow[x][y].setEtat(Etat.vide);
                break;
        }
    }
    
    public Case[][] getTabToShow() {
        return tabToShow;
    }

    public void setTabToShow(Case[][] tabToShow) {
        this.tabToShow = tabToShow;
        this.updateGrid();
    }
}
