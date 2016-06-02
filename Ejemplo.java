import java.awt.*;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;


public class Ejemplo extends JFrame implements ActionListener{
	
	public JButton boton;
	public JButton boton2;
	public JPanel panel;
	public JTextField text, text2;
	public JLabel etiqueta, etiqueta2;
	public Container contenedor, menu;
	
	public static void main(String[] args){
			EventQueue.invokeLater(
				new Runnable(){
					public void run(){
						try{
							Ejemplo ejemplo=new Ejemplo();
							ejemplo.setVisible(true); 
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}
			);
		
	}
	
	public Ejemplo(){
		int sizeX = 450;
		int sizeY = 300;
		
		this.setBounds(200,200,450,300);/*pos x , posy , longH ,LongV*/
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		try{
		this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("fondo.png")))));
		
		
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		boton = new JButton("boton");/*crea el boton*/
		boton.setBounds(getMiddlePoint(sizeX, 80, 50), 160, 80, 45);
		this.getContentPane().add(boton);
		boton.addActionListener(this);
		
		boton2=new JButton("boton2");/*crea el boton*/
		boton2.setBounds(getMiddlePoint(sizeX, 80, -50) ,160 , 80, 45);			
		boton2.addActionListener(this);
		
		int textSizeX = 100;
		int textOffset = 45;
		text = new JTextField();
		text.setBounds(getMiddlePoint(sizeX, textSizeX, textOffset), 70, textSizeX, 30);
		getContentPane().add(text);
		
		int labelSizeX = 70;
		etiqueta = new JLabel();
		etiqueta.setBounds(getMiddlePoint(sizeX, labelSizeX, -textOffset), 70, labelSizeX, 30);
		etiqueta.setText("Username");
		// etiqueta.setForeground(Color.RED);
		// etiqueta.setBackground(color.red);
		// etiqueta.setOpaque(true);
		getContentPane().add(etiqueta);
		
		int textSizeX2 = 100;
		int textOffset2 = 45;
		text2 = new JTextField();
		text2.setBounds(getMiddlePoint(sizeX, textSizeX2, textOffset2), 110, textSizeX2, 30);
		getContentPane().add(text2);
		
		int labelSizeX2 = 70;
		etiqueta2 = new JLabel();
		etiqueta2.setBounds(getMiddlePoint(sizeX, labelSizeX2, -textOffset2), 110, labelSizeX2, 30);
		etiqueta2.setText("Password");
		getContentPane().add(etiqueta2);
		
		text2.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					boton.doClick();
				}
			}
		});
	}
	
	public int getMiddlePoint(int x1, int x2, int offset){
		return (x1 - x2)/2 + offset;
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == boton){
			/*
			System.out.println("he pulsado el boton");
			getContentPane().add(boton2);
			repaint();
			*/
			
			String x = text.getText();
			this.getContentPane().remove(boton);
			text.setEnabled(false);
			this.setVisible(true);
			repaint();
			
			menu = getContentPane();
			contenedor = new Container();
			
			try{
				this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("fondo.png")))));
			}catch(IOException ev){
				ev.printStackTrace();
			}
			
			setContentPane(contenedor);
			getContentPane().add(boton2);
			
			this.setVisible(true);
			repaint();
		}
		
		if(e.getSource() == boton2){
			setContentPane(menu);
			boton.setEnabled(true);
			getContentPane().add(boton);
			
			repaint();
		}
	}	
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER){
			System.out.println("Hello");

		}
	}

}




