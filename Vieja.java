import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;			
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/*
 * 
 */


class MiJButton extends JButton
{
    public int index;
    MiJButton(int i)
    {
        index=i;
    }
};

public class Vieja extends JFrame implements ActionListener		//Paso 1 (modelado de eventos)
{

    private JPanel panel;	//panel que contendra los botones
    private MiJButton botones[] = new MiJButton[9];		//9 botones con el campo index
    boolean ban=true;
    int vieja[][]={{0,0,0},{0,0,0},{0,0,0}};			//matriz inicializada
    int veces=0;

    Vieja()
    {
        setTitle("vieja");
        this.setSize(200,200);
        setLocation(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel= new JPanel();
        panel.setLayout(new GridLayout(3,3));		//filas y columnas

        for(int i=0;i<9;i++)
        {
            botones[i]= new MiJButton(i);
            panel.add(botones[i]);						
            botones[i].addActionListener(this);			//Paso 2 (modelado de eventos)

        }
        add(panel);		

           

        setVisible(true);		//visible todo el frame

    }

    //Responder al evento
    public void actionPerformed(ActionEvent e) {
    //if(e.getActionCommand().isEmpty)
        veces++;
        if(ban){
            botones[((MiJButton)e.getSource()).index].setText("X");
            
            ban=false;
            llenar(((MiJButton)e.getSource()).index,-1);
        }else{
            botones[((MiJButton)e.getSource()).index].setText("0");
           llenar(((MiJButton)e.getSource()).index,1);
            ban=true;
        }
         botones[((MiJButton)e.getSource()).index].setEnabled(false);
         buscarganador();
    }

    public void llenar(int index,int jugada)
    {
        switch(index)
        {
            case 0:vieja[0][0]=jugada;break;
            case 1:vieja[0][1]=jugada;break;
            case 2:vieja[0][2]=jugada;break;
            case 3:vieja[1][0]=jugada;break;
            case 4:vieja[1][1]=jugada;break;
            case 5:vieja[1][2]=jugada;break;
            case 6:vieja[2][0]=jugada;break;
            case 7:vieja[2][1]=jugada;break;
            case 8:vieja[2][2]=jugada;break;

        }
    }

    public void buscarganador()
    {
        int sumaV,sumaH,sumaDP=0,sumaDS=0,ganador=0;

        for(int i=0;i<=2;i++)
        {

            sumaV=0;sumaH=0;
            for(int j=0;j<=2;j++)
            {
                sumaH+=vieja[i][j];
                sumaV+=vieja[j][i];
            }
            sumaDP+=vieja[i][i];
            sumaDS+=vieja[2-i][i];
            if(sumaH==3)ganador=1;  if(sumaH==-3)ganador=-1;
            if(sumaV==3)ganador=1;  if(sumaV==-3)ganador=-1;

        }
       if(sumaDP==3)ganador=1;  if(sumaDP==-3)ganador=-1;
       if(sumaDS==3)ganador=1;  if(sumaDS==-3)ganador=-1;

        if(ganador==-1)
        {
        	Toolkit.getDefaultToolkit().beep();		//pitido
            this.setTitle("Ganador X");
            JOptionPane.showMessageDialog(null,"Ganador X");
            limpiar();
        }else{
        	
        	if(ganador==1)
        	{
        		Toolkit.getDefaultToolkit().beep();		//pitido
        		this.setTitle("Ganador 0");
        		JOptionPane.showMessageDialog(null,"Ganador 0");
        		limpiar();
        	}else{
        		if(veces==9)		//si ya no hay jugadas y no hubo ganador gana la vieja
                {
                	Toolkit.getDefaultToolkit().beep();	//pitido
                   this.setTitle("Ganado Vieja");
                   JOptionPane.showMessageDialog(null,"Ganador La Vieja");
                   
                   limpiar();
                }
        	}
        	
        }
     
    }

    public void limpiar()
    {
        int c=0;
        for(int i=0;i<=2;i++)
        {
            for(int j=0;j<=2;j++)
            {
                vieja[i][j]=0;
                botones[c].setEnabled(true);
                botones[c].setText("");
                c++;
            }
        }
        this.setTitle("vieja");
        veces=0;
    }
    
    public static void main(String[] args) {
        new Vieja();
    }

}
