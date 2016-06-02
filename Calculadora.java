


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;   //para capturar el evento del boton
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class Calculadora extends JFrame implements ActionListener  {

     private JTextField areaTexto;
     private JButton botones[];
      int i;
      float num1=0, num2=0;
      char oper;

    public Calculadora(){


    //Creando Ventana

        super("Calculadora"); // Herencia
        this.setSize(175, 220);  // Tamaño
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); //psrs cerrar la ventana
        this.setLocation(500, 80); //Centrar la ventana en la pantalla
        this.setResizable(false); //para que no se pueda maximizar

    //Inicializando Constructores

        this.setLayout(new FlowLayout() ); // agrega los elementos uno al lado del otro

        areaTexto = new JTextField(14); // escribe un cuadro de texto
        areaTexto.setHorizontalAlignment(JTextField.RIGHT);// el curso se posiciona del lado derecho
        areaTexto.setEditable(false);//no se puede editar con el cursor

        botones = new JButton[15];

        this.add(areaTexto);

        for( i=0; i<9; i++){

            botones[i] = new JButton(" "+(i+1)+" ");
            this.add(botones[i]);
            botones[i].addActionListener(this);		//para colocar la accion de presionar
        }



        botones[9] = new JButton(" "+0+" ");
        this.add(botones[9]);
        botones[9].addActionListener(this);
        
        botones[10] = new JButton(" + ");
        this.add(botones[10]);
        botones[10].addActionListener(this);

        botones[11] = new JButton(" - ");
        this.add(botones[11]);
        botones[11].addActionListener(this);

        botones[12] = new JButton(" x ");
        this.add(botones[12]);
        botones[12].addActionListener(this);
        
        botones[13] = new JButton(" / ");
        this.add(botones[13]);
        botones[13].addActionListener(this);


        botones[14] = new JButton(" = ");
        this.add(botones[14]);
        botones[14].addActionListener(this);


        this.setVisible(true);   // Que sea visible la ventana ultimo

    }

    public void actionPerformed(ActionEvent evento) {
			
			//double i=3.1416;this.areaTexto.setText(String.valuout(i));
			
			if (evento.getSource()==botones[0]){
				this.areaTexto.setText(areaTexto.getText()+botones[0].getText().substring(1,2));
			}
			else
			{
				if(evento.getSource()==botones[1]){
					this.areaTexto.setText(areaTexto.getText()+botones[1].getText().substring(1,2));
				}
				else 
				{
					if(evento.getSource()==botones[2]){
						this.areaTexto.setText(areaTexto.getText()+botones[2].getText().substring(1,2));
					}
					else{
						
					}
				}
			}
       /* if(evento.getSource()==botones[0]){
            areaTexto.setText(areaTexto.getText()+botones[0].getText().toString().substring(1,2));
        }else if(evento.getSource()==botones[1]){
            areaTexto.setText(areaTexto.getText()+botones[1].getText().toString().substring(1,2));
        }else if(evento.getSource()==botones[2]){
            areaTexto.setText(areaTexto.getText()+botones[2].getText().toString().substring(1,2));
        }else if(evento.getSource()==botones[3]){
            areaTexto.setText(areaTexto.getText()+botones[3].getText().toString().substring(1,2));
        }else if(evento.getSource()==botones[4]){
            areaTexto.setText(areaTexto.getText()+botones[4].getText().toString().substring(1,2));
        }else if(evento.getSource()==botones[5]){
            areaTexto.setText(areaTexto.getText()+botones[5].getText().substring(1,2));
        }else if(evento.getSource()==botones[6]){
            areaTexto.setText(areaTexto.getText()+botones[6].getText().substring(1,2));
        }else if(evento.getSource()==botones[7]){
            areaTexto.setText(areaTexto.getText()+botones[7].getText().substring(1,2));
        }else if(evento.getSource()==botones[8]){
            areaTexto.setText(areaTexto.getText()+botones[8].getText().substring(1,2));
        }else if(evento.getSource()==botones[9]){
            areaTexto.setText(areaTexto.getText()+botones[9].getText().toString().substring(1,2));

        }else if(evento.getSource()==botones[10]&&!areaTexto.getText().isEmpty()){//+
            num1=num1+Float.parseFloat(areaTexto.getText());
            areaTexto.setText("");

        }else if(evento.getSource()==botones[11]&&!areaTexto.getText().isEmpty()){//-
            num1=num1-Float.parseFloat(areaTexto.getText());
            areaTexto.setText("");
        }else if(evento.getSource()==botones[12]&&!areaTexto.getText().isEmpty()){//*
            num1=num1*Float.parseFloat(areaTexto.getText());
            areaTexto.setText("");
        }else if(evento.getSource()==botones[13]&&!areaTexto.getText().isEmpty()){// /
            num1=num1/Float.parseFloat(areaTexto.getText());
            areaTexto.setText("");
        }else if(evento.getSource()==botones[14]){//=
           
            String num;
            num= String.valueOf(num1);
            
            areaTexto.setText(num);}*/
    }
    
     public static void main(String[] args) {

        Calculadora calcu = new Calculadora();
      }
}
