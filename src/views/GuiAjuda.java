package views;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuiAjuda extends JFrame{
	private static GuiAjuda principal;
	private JLabel lblLogotipo, lblTitle;
	private JButton btnSair;
	private Container container;
	private static Image img;
	
	public GuiAjuda() {
		inicializarComponentes();
		definirEventos();
	}	
	private void inicializarComponentes() {
		setTitle("El Despachador - Ajuda");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, 500, 600);
		setLocationRelativeTo(null);
		setLayout(null);

		container = getContentPane();

		try {
			File file = new File("LogotipoClear.png");
			img = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		lblLogotipo = new JLabel(new ImageIcon(img));

		lblTitle = new JLabel("Ajuda");
		btnSair = new JButton("Sair");

		lblLogotipo.setBounds(30, 30, 400, 267);
		lblTitle.setBounds(90, 307, 80, 25);
		btnSair.setBounds(180, 507, 100, 25);

		add(lblLogotipo);
		add(lblTitle);
		add(btnSair);

	}

	private void definirEventos() {
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				principal.setVisible(false);
			}
		});
	}
	public static void abrir() {
		principal = new GuiAjuda();
		principal.getContentPane().setBackground(new Color(24, 24, 38));
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		principal.setLocation((d.width - principal.getSize().width) / 2,
				(d.height - principal.getSize().height) / 2);
		principal.setResizable(false);
		principal.setVisible(true);
	}
}
