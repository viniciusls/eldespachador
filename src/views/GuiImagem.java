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

public class GuiImagem extends JFrame{
	private static GuiImagem principal;
	private JLabel lblImagem, lblTitle;
	private JButton btnSair;
	private Container container;
	private static Image img;
	
	public GuiImagem(String filename, int width, int height) {
		inicializarComponentes(filename, width, height);
		definirEventos();
	}	
	private void inicializarComponentes(String filename, int width, int height) {
		setTitle("El Despachador - Carta Produto");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, width+6, height+29);
		setLocationRelativeTo(null);
		setLayout(null);

		container = getContentPane();

		try {
			File file = new File(filename);
			img = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		lblImagem = new JLabel(new ImageIcon(img));

		btnSair = new JButton("Sair");

		lblImagem.setBounds(0, 0, width, height);

		add(lblImagem);
		add(btnSair);

	}

	private void definirEventos() {
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				principal.setVisible(false);
			}
		});
	}
	public static void abrir(String filename, int width, int height) {
		principal = new GuiImagem(filename, width, height);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		principal.setLocation((d.width - principal.getSize().width) / 2,
				(d.height - principal.getSize().height) / 2);
		principal.setResizable(false);
		principal.setVisible(true);
	}
}
