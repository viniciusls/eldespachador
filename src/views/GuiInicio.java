package views;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import models.Jogador;

public class GuiInicio extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2469301499525907862L;
	private int quantidadeJogadores = 0;
	private static Image img;
	private Container container;
	private JTextField txtNomeJogador1, txtNomeJogador2, txtNomeJogador3,
			txtNomeJogador4;
	private JLabel lblNomeJogador1, lblNomeJogador2, lblNomeJogador3,
			lblNomeJogador4, lblLogotipo;
	private JButton btnIniciar, btnCancelar, btnSair, btn2Jogadores,
			btn3Jogadores, btn4Jogadores;

	private static GuiInicio f;

	public GuiInicio() {
		inicializarComponentes();
		definirEventos();
	}

	/**
	 * @return the quantidadeJogadores
	 */
	public int getQuantidadeJogadores() {
		return this.quantidadeJogadores;
	}

	/**
	 * @param quantidadeJogadores
	 *            the quantidadeJogadores to set
	 */
	public void setQuantidadeJogadores(int quantidadeJogadores) {
		this.quantidadeJogadores = quantidadeJogadores;
	}

	private void limparCampos() {
		txtNomeJogador1.setText("");
		txtNomeJogador2.setText("");
		txtNomeJogador3.setText("");
		txtNomeJogador4.setText("");
		txtNomeJogador1.requestFocus();
	}

	private void inicializarComponentes() {
		setTitle("El Despachador - Iniciar jogo");
		setBounds(0, 0, 500, 520);
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

		txtNomeJogador1 = new JTextField(10);
		txtNomeJogador2 = new JTextField(10);
		txtNomeJogador3 = new JTextField(10);
		txtNomeJogador4 = new JTextField(10);
		lblNomeJogador1 = new JLabel("Jogador 1: ");
		lblNomeJogador2 = new JLabel("Jogador 2: ");
		lblNomeJogador3 = new JLabel("Jogador 3: ");
		lblNomeJogador4 = new JLabel("Jogador 4: ");
		btnIniciar = new JButton("Iniciar jogo");
		btnCancelar = new JButton("Cancelar");
		btnSair = new JButton("Sair");
		btn2Jogadores = new JButton("2 jogadores");
		btn3Jogadores = new JButton("3 jogadores");
		btn4Jogadores = new JButton("4 jogadores");

		lblLogotipo.setBounds(30, 30, 400, 267);
		lblNomeJogador1.setBounds(90, 307, 80, 25);
		lblNomeJogador2.setBounds(90, 347, 80, 25);
		lblNomeJogador3.setBounds(90, 387, 80, 25);
		lblNomeJogador4.setBounds(90, 427, 80, 25);
		txtNomeJogador1.setBounds(200, 307, 160, 25);
		txtNomeJogador2.setBounds(200, 347, 160, 25);
		txtNomeJogador3.setBounds(200, 387, 160, 25);
		txtNomeJogador4.setBounds(200, 427, 160, 25);
		btnIniciar.setBounds(80, 437, 120, 25);
		btnCancelar.setBounds(210, 437, 100, 25);
		btnSair.setBounds(180, 437, 100, 25);
		btn2Jogadores.setBounds(150, 307, 160, 25);
		btn3Jogadores.setBounds(150, 347, 160, 25);
		btn4Jogadores.setBounds(150, 387, 160, 25);

		add(lblLogotipo);
		add(btn2Jogadores);
		add(btn3Jogadores);
		add(btn4Jogadores);
		add(btnSair);

	}

	private void definirEventos() {
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chamar();
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				container.removeAll();
				add(lblLogotipo);
				add(btn2Jogadores);
				add(btn3Jogadores);
				add(btn4Jogadores);
				container.revalidate();
				container.repaint();
			}
		});
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		txtNomeJogador1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chamar();
			}
		});
		txtNomeJogador2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chamar();
			}
		});
		txtNomeJogador3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chamar();
			}
		});
		txtNomeJogador4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chamar();
			}
		});
		btn2Jogadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setQuantidadeJogadores(2);
				container.removeAll();
				btnSair.setBounds(320, 437, 100, 25);
				container.add(lblLogotipo);
				container.add(lblNomeJogador1);
				container.add(lblNomeJogador2);
				container.add(txtNomeJogador1);
				txtNomeJogador1.requestFocus();
				container.add(txtNomeJogador2);
				container.add(btnIniciar);
				container.add(btnCancelar);
				container.add(btnSair);
				container.revalidate();
				container.repaint();
			}
		});
		btn3Jogadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setQuantidadeJogadores(3);
				container.removeAll();
				btnSair.setBounds(320, 437, 100, 25);
				container.add(lblLogotipo);
				container.add(lblNomeJogador1);
				container.add(lblNomeJogador2);
				container.add(lblNomeJogador3);
				container.add(txtNomeJogador1);
				txtNomeJogador1.requestFocus();
				container.add(txtNomeJogador2);
				container.add(txtNomeJogador3);
				container.add(btnIniciar);
				container.add(btnCancelar);
				container.add(btnSair);
				container.revalidate();
				container.repaint();
			}
		});
		btn4Jogadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setQuantidadeJogadores(4);
				container.removeAll();
				btnSair.setBounds(320, 437, 100, 25);
				container.add(lblLogotipo);
				container.add(lblNomeJogador1);
				container.add(lblNomeJogador2);
				container.add(lblNomeJogador3);
				container.add(lblNomeJogador4);
				container.add(txtNomeJogador1);
				txtNomeJogador1.requestFocus();
				container.add(txtNomeJogador2);
				container.add(txtNomeJogador3);
				container.add(txtNomeJogador4);
				container.add(btnIniciar);
				container.add(btnCancelar);
				container.add(btnSair);
				container.revalidate();
				container.repaint();
			}
		});
	}

	public void chamar() {
		Jogador jogador1 = new Jogador(txtNomeJogador1.getText(), 0, 0, false, null, null, 5);
		Jogador jogador2 = new Jogador(txtNomeJogador2.getText(), 0, 0, false, null, null, 5);
		Jogador jogador3 = new Jogador(txtNomeJogador3.getText(), 0, 0, false, null, null, 5);
		Jogador jogador4 = new Jogador(txtNomeJogador4.getText(), 0, 0, false, null, null, 5);
		if (!jogador1.getNome().equals("") && !jogador2.getNome().equals("")) {
			switch (getQuantidadeJogadores()) {
			case 2:
				f.setVisible(false);
				JOptionPane
						.showMessageDialog(null,
								"Bem-vindos participantes e que a sorte esteja sempre a seu favor!");
				GuiPrincipal
						.abrir(jogador1, jogador2);
				break;
			case 3:
				if (!jogador3.getNome().equals("")) {
					f.setVisible(false);
					JOptionPane
							.showMessageDialog(null,
									"Bem-vindos participantes e que a sorte esteja sempre a seu favor!");
					GuiPrincipal
							.abrir(jogador1, jogador2, jogador3);
				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"Você selecionou a opção \"3 jogadores\" porém algum está faltando. Volte e verifique antes de começar ");
					limparCampos();
					return;
				}
				break;
			case 4:
				if (!jogador3.getNome().equals("")
						&& !jogador4.getNome().equals("")) {
					f.setVisible(false);
					JOptionPane
							.showMessageDialog(null,
									"Bem-vindos participantes e que a sorte esteja sempre a seu favor!");
					GuiPrincipal
							.abrir(jogador1, jogador2, jogador3, jogador4);
				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"Você selecionou a opção \"4 jogadores\" porém algum está faltando. Volte e verifique antes de começar ");
					limparCampos();
					return;
				}
				break;
			}
		} else {
			JOptionPane
					.showMessageDialog(null,
							"É necessário ter pelo menos jogador 1 e jogador 2 definidos!");
			limparCampos();
		}
	}

	public static void main(String[] args) {
		f = new GuiInicio();
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}

}
