package views;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import models.Jogador;
import models.Pergunta;
import models.Produto;
import dao.PerguntasDAO;
import dao.ProdutosDAO;

public class GuiPrincipal extends JFrame {

	private static final long serialVersionUID = -2985020293921520516L;
	private int quantidadeJogadores = 0;
	private int jogadorAtualId = 0, jogadorIniciante = 0;
	private int rodada = 1;
	private static Image img;
	private Container container;
	private JMenuBar mb;
	private JLabel background, lblPino1, lblPino2, lblPino3, lblPino4,
			lblJogadorAtual, lblJogadorAtualNome, lblPinoLegendaJogador1,
			lblPinoLegendaJogador2, lblPinoLegendaJogador3,
			lblPinoLegendaJogador4, lblLegendaJogador1, lblLegendaJogador2,
			lblLegendaJogador3, lblLegendaJogador4, lblDocumentos, lblRodada, lblCartaJogador, btnSelecionarPergunta, btnSelecionarSorteReves;
	public Jogador jogador1 = new Jogador(), jogador2 = new Jogador(),
			jogador3 = new Jogador(), jogador4 = new Jogador(),
			jogadorAtual = new Jogador();
	private JMenu mnPrincipal, mnAjuda;
	private JMenuItem miSobre, miSair; // mnPrincipal;
	private JMenuItem miAjuda; // mnAjuda;
	private Dimension d;

	/**
	 * @return the quantidadeJogadores
	 */
	public int getQuantidadeJogadores() {
		return quantidadeJogadores;
	}

	/**
	 * @param quantidadeJogadores
	 *            the quantidadeJogadores to set
	 */
	public void setQuantidadeJogadores(int quantidadeJogadores) {
		this.quantidadeJogadores = quantidadeJogadores;
	}

	/**
	 * @return the jogadorAtualId
	 */
	public int getJogadorAtualId() {
		return jogadorAtualId;
	}

	/**
	 * @param jogadorAtualId
	 *            the jogadorAtualId to set
	 */
	public void setJogadorAtualId(int jogadorAtualId) {
		this.jogadorAtualId = jogadorAtualId;
	}

	public void drawPinos(int pos, int pino, boolean isMove) {
		int[] xp1 = {
				(int) ((int) d.width - (d.width * 0.145)),
				(int) ((int) d.width - (d.width * 0.145)),
				(int) ((int) d.width - (d.width * 0.145)),
				(int) ((int) d.width - (d.width * 0.145)),
				(int) ((int) d.width - (d.width * 0.145)),
				(int) ((int) d.width - (d.width * 0.145)),
				(int) ((int) d.width - (d.width * 0.145)),
				(int) ((int) d.width - (d.width * 0.145)),
				(int) ((int) d.width - (d.width * 0.145)),
				(int) ((int) d.width - (d.width * 0.145)),
				(int) ((int) d.width - (d.width * 0.145)),

				(int) ((int) d.width - (d.width * 0.145)),
				// Pinos embaixo
				d.width - 249,
				d.width - 302,
				d.width - 355,
				d.width - 407,
				d.width - 457,
				d.width - 510,
				d.width - 562,
				d.width - 615,
				d.width - 667,// 10
				d.width - 719, d.width - 771, d.width - 823, d.width - 875,
				d.width - 927, d.width - 982,

				d.width - 982, d.width - 982, d.width - 982, d.width - 982,
				d.width - 982, d.width - 982, d.width - 982, d.width - 982,
				d.width - 982, d.width - 982, d.width - 982, d.width - 927
				};

		int[] xp2 = { d.width - 172, d.width - 172, d.width - 172,
				d.width - 172, d.width - 172, d.width - 172, d.width - 172,
				d.width - 172, d.width - 172, d.width - 172, d.width - 172,

				d.width - 172, d.width - 225, d.width - 278, d.width - 329,
				d.width - 381, d.width - 433, d.width - 485, d.width - 539,
				d.width - 592, d.width - 644, d.width - 696,
				d.width - 748, d.width - 800, d.width - 852, d.width - 904,
				d.width - 957,

				d.width - 957, d.width - 957, d.width - 957, d.width - 957,
				d.width - 957, d.width - 957, d.width - 957, d.width - 957,
				d.width - 957, d.width - 957, d.width - 957, d.width - 904
				};

		int[] xp3 = { d.width - 198, d.width - 198, d.width - 198,
				d.width - 198, d.width - 198, d.width - 198, d.width - 198,
				d.width - 198, d.width - 198, d.width - 198, d.width - 198,

				d.width - 198, d.width - 249, d.width - 302, d.width - 355,
				d.width - 407, d.width - 457, d.width - 510, d.width - 562,
				d.width - 615, d.width - 667, d.width - 719,
				d.width - 771, d.width - 823, d.width - 875, d.width - 927,
				d.width - 982,

				d.width - 982, d.width - 982, d.width - 982, d.width - 982,
				d.width - 982, d.width - 982, d.width - 982, d.width - 982,
				d.width - 982, d.width - 982, d.width - 982, d.width - 927
				};

		int[] xp4 = { d.width - 172, d.width - 172, d.width - 172,
				d.width - 172, d.width - 172, d.width - 172, d.width - 172,
				d.width - 172, d.width - 172, d.width - 172, d.width - 172,

				d.width - 172, d.width - 225, d.width - 278, d.width - 329,
				d.width - 381, d.width - 433, d.width - 485, d.width - 539,
				d.width - 592, d.width - 644, d.width - 696,
				d.width - 748, d.width - 800, d.width - 852, d.width - 904,
				d.width - 957,

				d.width - 957, d.width - 957, d.width - 957, d.width - 957,
				d.width - 957, d.width - 957, d.width - 957, d.width - 957,
				d.width - 957, d.width - 957, d.width - 957, d.width - 904
				};

		int[] yp1 = { 50, 130, 181, 234, 287, 340, 390, 440, 492, 545, 596,
				649, 649, 649, 649, 649, 649, 649, 649, 649, 649, 649, 649,
				649, 649, 649, 649, 598, 546, 494, 443, 391, 339, 287,
				236, 184, 132, 80, 80 };
		int[] yp2 = { 50, 130, 181, 234, 287, 340, 390, 440, 492, 545, 596,
				649, 649, 649, 649, 649, 649, 649, 649, 649, 649, 649, 649,
				649, 649, 649, 649, 598, 546, 494, 443, 391, 339, 287,
				236, 184, 132, 80, 80 };
		int[] yp3 = { 75, 154, 205, 260, 313, 366, 418, 468, 518, 568, 618,
				672, 672, 672, 672, 672, 672, 672, 672, 672, 672, 672, 672,
				672, 672, 672, 672, 620, 568, 516, 465, 413, 361, 309,
				258, 206, 154, 102, 102 };
		int[] yp4 = { 75, 154, 205, 260, 313, 366, 418, 468, 518, 568, 618,
				672, 672, 672, 672, 672, 672, 672, 672, 672, 672, 672, 672,
				672, 672, 672, 672, 620, 568, 516, 465, 413, 361, 309,
				258, 206, 154, 102, 102 };

		if (!isMove) {
			try {
				File file = new File("p1.png");
				img = ImageIO.read(file);
				lblPino1 = new JLabel(new ImageIcon(img));
				lblPinoLegendaJogador1 = new JLabel(new ImageIcon(img));

				file = new File("p2.png");
				img = ImageIO.read(file);
				lblPino2 = new JLabel(new ImageIcon(img));
				lblPinoLegendaJogador2 = new JLabel(new ImageIcon(img));

				file = new File("p3.png");
				img = ImageIO.read(file);
				lblPino3 = new JLabel(new ImageIcon(img));
				lblPinoLegendaJogador3 = new JLabel(new ImageIcon(img));

				file = new File("p4.png");
				img = ImageIO.read(file);
				lblPino4 = new JLabel(new ImageIcon(img));
				lblPinoLegendaJogador4 = new JLabel(new ImageIcon(img));
			} catch (IOException e) {
				e.printStackTrace();
			}

			lblPino1.setBounds(xp1[pos], yp1[pos], 12, 12);
			lblPino2.setBounds(xp2[pos], yp2[pos], 12, 12);
			if (getQuantidadeJogadores() >= 3) {
				lblPino3.setBounds(xp3[pos], yp3[pos], 12, 12);
			}
			if (getQuantidadeJogadores() == 4) {
				lblPino4.setBounds(xp4[pos], yp4[pos], 12, 12);
			}
			lblPinoLegendaJogador1.setBounds(50, 15, 12, 12);
			lblPinoLegendaJogador2.setBounds(150, 15, 12, 12);
			lblPinoLegendaJogador3.setBounds(50, 35, 12, 12);
			lblPinoLegendaJogador4.setBounds(150, 35, 12, 12);

			add(lblPinoLegendaJogador1);
			add(lblPinoLegendaJogador2);
			add(lblPinoLegendaJogador3);
			add(lblPinoLegendaJogador4);

			add(lblPino1);
			add(lblPino2);
			if (getQuantidadeJogadores() >= 3) {
				add(lblPino3);
			}
			if (getQuantidadeJogadores() == 4) {
				add(lblPino4);
			}
		} else {
			switch (pino) {
			case 1:
				lblPino1.setBounds(xp1[pos], yp1[pos], 12, 12);
				break;
			case 2:
				lblPino2.setBounds(xp2[pos], yp2[pos], 12, 12);
				break;
			case 3:
				lblPino3.setBounds(xp3[pos], yp3[pos], 12, 12);
				break;
			case 4:
				lblPino4.setBounds(xp4[pos], yp4[pos], 12, 12);
				break;
			}
		}
	}
	
	public void drawPinosParametrizacao(int pos, int pino, String cor){
		int[] xcinza = {d.width - 865, d.width - 865,d.width - 865, d.width - 865, d.width - 865, d.width - 865, 
				d.width - 813, d.width - 761, d.width - 709, d.width - 656, d.width - 604, d.width - 552, d.width - 500};
		
		int[] xvermelho = {d.width - 813,d.width -  813,d.width -  813, d.width - 813, d.width -813, d.width - 760,
				d.width - 708 , d.width - 656,d.width -604, d.width -552, d.width -500};
		
		int[] xamarelo = {d.width - 762, d.width - 762,d.width - 762,d.width - 762,d.width - 709, d.width -656, d.width - 604, d.width - 552, d.width - 500};
		
		int[] xverde = {d.width - 709,d.width - 709, d.width - 709,d.width - 657,d.width - 603, d.width - 550,d.width - 497,d.width - 445};
		
		
		
		int[] ycinza = {144, 194, 244, 297, 350, 403, 403, 403, 403, 403, 403, 403, 403};
		
		int[] yvermelho = {144, 194, 244, 297, 350, 403, 403, 403, 350, 350, 350 , 144, 194, 244, 297, 297, 297, 297, 297, 297};
		
		int[] yamarelo = {144, 194, 244, 297, 297, 297, 297, 297, 297};
		
		int[] yverde = {144, 194,244, 244, 244, 244, 244};
		
		
		switch (cor){
		
		case "Verde":
			switch (pino) {
				case 1:
					lblPino1.setBounds(xverde[pos], yverde[pos], 12, 12);
					break;
				case 2:
					lblPino2.setBounds(xverde[pos], yverde[pos], 12, 12);
					break;
				case 3:
					lblPino3.setBounds(xverde[pos], yverde[pos], 12, 12);
					break;
				case 4:
					lblPino4.setBounds(xverde[pos], yverde[pos], 12, 12);
					break;
			}
			break;
		case "Amarelo":
			switch (pino) {
			case 1:
				lblPino1.setBounds(xamarelo[pos], yamarelo[pos], 12, 12);
				break;
			case 2:
				lblPino2.setBounds(xamarelo[pos], yamarelo[pos], 12, 12);
				break;
			case 3:
				lblPino3.setBounds(xamarelo[pos], yamarelo[pos], 12, 12);
				break;
			case 4:
				lblPino4.setBounds(xamarelo[pos], yamarelo[pos], 12, 12);
				break;
			}
			break;
		case "Vermelho":
			switch (pino) {
			case 1:
				lblPino1.setBounds(xvermelho[pos], yvermelho[pos], 12, 12);
				break;
			case 2:
				lblPino2.setBounds(xvermelho[pos], xvermelho[pos], 12, 12);
				break;
			case 3:
				lblPino3.setBounds(xvermelho[pos], xvermelho[pos], 12, 12);
				break;
			case 4:
				lblPino4.setBounds(xvermelho[pos], xvermelho[pos], 12, 12);
				break;
			}
			break;
		case "Cinza":
			switch (pino) {
			case 1:
				lblPino1.setBounds(xcinza[pos], ycinza[pos], 12, 12);
				break;
			case 2:
				lblPino2.setBounds(xcinza[pos], ycinza[pos], 12, 12);
				break;
			case 3:
				lblPino3.setBounds(xcinza[pos], ycinza[pos], 12, 12);
				break;
			case 4:
				lblPino4.setBounds(xcinza[pos], ycinza[pos], 12, 12);
				break;
			}
			break;
		
		}
	}

	public GuiPrincipal() {
		inicializarComponentes(null, null, null, null);
		definirEventos();
	}

	public GuiPrincipal(Jogador jogador1, Jogador jogador2) {
		setQuantidadeJogadores(2);
		inicializarComponentes(jogador1, jogador2, null, null);
		for(int i = 0; i<39; i++){
		drawPinos(i, 0, false);
		}
		definirEventos();
		definirProdutos();
		selecionarIniciante();

		/* Background */

		try {
			img = ImageIO.read(new File("PI_Tabuleiro.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		ImageIcon imageIcon = new ImageIcon(img); // load the image to a
													// imageIcon
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(d.width, d.height - 25,
				java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg); // transform it back
		background = new JLabel(imageIcon);
		add(background);
	}

	public GuiPrincipal(Jogador jogador1, Jogador jogador2, Jogador jogador3) {
		setQuantidadeJogadores(3);
		inicializarComponentes(jogador1, jogador2, jogador3, null);
		drawPinos(0, 0, false); // 1 = POSIÇÃO
		definirEventos();
		definirProdutos();
		selecionarIniciante();

		/* Background */

		try {
			img = ImageIO.read(new File("PI_Tabuleiro.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		ImageIcon imageIcon = new ImageIcon(img); // load the image to a
													// imageIcon
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(d.width, d.height - 25,
				java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg); // transform it back
		background = new JLabel(imageIcon);
		add(background);
	}

	public GuiPrincipal(Jogador jogador1, Jogador jogador2, Jogador jogador3,
			Jogador jogador4) {
		setQuantidadeJogadores(4);
		inicializarComponentes(jogador1, jogador2, jogador3, jogador4);
		drawPinos(0, 0, false); // 1 = POSIÇÃO
		definirEventos();
		definirProdutos();
		selecionarIniciante();

		/* Background */

		try {
			img = ImageIO.read(new File("PI_Tabuleiro.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		ImageIcon imageIcon = new ImageIcon(img); // load the image to a
													// imageIcon
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(d.width, d.height - 25,
				java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg); // transform it back
		background = new JLabel(imageIcon);
		add(background);
	}

	private void inicializarComponentes(Jogador jogador1, Jogador jogador2,
			Jogador jogador3, Jogador jogador4) {
		/* Configs */
		setTitle("El Despachador - O jogo!");
		setBounds(0, 0, 1300, 720);
		d = Toolkit.getDefaultToolkit().getScreenSize();

		/* Jogadores */
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		this.jogador3 = jogador3;
		this.jogador4 = jogador4;

		/* Labels and Buttons */
		lblLegendaJogador1 = new JLabel(this.jogador1.getNome());
		lblLegendaJogador2 = new JLabel(this.jogador2.getNome());
		if (this.jogador3 != null) {
			lblLegendaJogador3 = new JLabel(this.jogador3.getNome());
		} else {
			lblLegendaJogador3 = new JLabel("---");
		}
		if (this.jogador4 != null) {
			lblLegendaJogador4 = new JLabel(this.jogador4.getNome());
		} else {
			lblLegendaJogador4 = new JLabel("---");
		}
		lblJogadorAtual = new JLabel("Jogador atual: ");
		lblJogadorAtualNome = new JLabel("");
		btnSelecionarPergunta = new JLabel("");
		btnSelecionarSorteReves = new JLabel("");
		lblDocumentos = new JLabel("");
		lblRodada = new JLabel("Rodada: "+rodada);
		lblCartaJogador = new JLabel("");

		/* Menus */
		container = getContentPane();
		mb = new JMenuBar();

		mnPrincipal = new JMenu("Principal");
		mnPrincipal.setMnemonic('P');

		mnAjuda = new JMenu("Ajuda");
		mnAjuda.setMnemonic('A');

		miAjuda = new JMenuItem("Ajuda");
		miAjuda.setMnemonic('H');

		miSobre = new JMenuItem("Sobre");
		miSobre.setMnemonic('S');

		miSair = new JMenuItem("Sair");
		miSair.setMnemonic('C');
		// --- Montando o menu ---

		mnPrincipal.add(miSobre);
		mnPrincipal.add(miSair);

		mnAjuda.add(miAjuda);

		mb.add(mnPrincipal);
		mb.add(mnAjuda);

		Font f1 = new Font("Arial", Font.BOLD, 16);

		lblLegendaJogador1.setBounds(65, 10, 50, 25);
		lblLegendaJogador2.setBounds(165, 10, 50, 25);
		lblLegendaJogador3.setBounds(65, 30, 50, 25);
		lblLegendaJogador4.setBounds(165, 30, 50, 25);

		lblJogadorAtual.setBounds(50, 50, 150, 25);
		lblJogadorAtualNome.setBounds(175, 50, 80, 25);
		lblCartaJogador.setBounds(50, 150, 201, 207);
		lblRodada.setBounds(50, 80, 150, 25);
		btnSelecionarPergunta.setBounds(55, 375, 189, 110);
		btnSelecionarPergunta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		try {
			img = ImageIO.read(new File("Btn_Selecionar_Pergunta.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		ImageIcon imageIcon = new ImageIcon(img); // load the image to a
													// imageIcon

		btnSelecionarPergunta.setIcon(imageIcon);
		
		btnSelecionarSorteReves.setBounds(55, 375, 189, 110);
		btnSelecionarSorteReves.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		try {
			img = ImageIO.read(new File("Btn_Selecionar_Sorte_Reves.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		imageIcon = new ImageIcon(img); // load the image to a
													// imageIcon

		btnSelecionarSorteReves.setIcon(imageIcon);
		
		add(lblLegendaJogador1);
		add(lblLegendaJogador2);
		add(lblLegendaJogador3);
		add(lblLegendaJogador4);
		add(lblJogadorAtual);
		add(lblJogadorAtualNome);
		add(lblRodada);
		add(lblCartaJogador);
		add(btnSelecionarPergunta);
		add(btnSelecionarSorteReves);
		lblJogadorAtual.setFont(f1);
		lblJogadorAtualNome.setFont(f1);
		lblRodada.setFont(f1);
		setJMenuBar(mb);
	}

	private void definirEventos() {

		miSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		miSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane
						.showMessageDialog(
								null,
								"Alunos: Juliana Marques, Mariane Theodoro, Silson Telles e Vinícius Luiz.\n"
										+ "Curso: Análise e Desenvolvimento de Sistemas - 3º Semestre - Noturno\n"
										+ "FATEC-ID - Faculdade de Tecnologia de Indaiatuba\n"
										+ "Projeto Interdisciplinar.\n"
										+ "Disciplinas participantes: Banco de dados, Engenharia de Software II, Gestão e Governança de T.I. e Linguagem de Programação II \n"
										+ "Indaiatuba, São Paulo - Julho de 2015.",
								"Sobre", EXIT_ON_CLOSE);
			}
		});
		miAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuiAjuda.abrir();
			}
		});
		
		btnSelecionarPergunta.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(!jogadorAtual.isParametrizacao()){
					PerguntasDAO perguntasDao = new PerguntasDAO();
					Pergunta pergunta = new Pergunta();
					pergunta = perguntasDao.selecionarPergunta();
					boolean resposta = false;
					try {
						resposta = perguntasDao.validarResposta(
								pergunta,
								JOptionPane.showInputDialog(
										pergunta.getDescricao().replace("/", "\n")
												+ "\n"
												+ pergunta.getResposta()
														.getDescA_Resposta()
														.replace("/", "\n")
												+ "\n"
												+ pergunta.getResposta()
														.getDescB_Resposta()
														.replace("/", "\n")
												+ "\n"
												+ pergunta.getResposta()
														.getDescC_Resposta()
														.replace("/", "\n"))
										.substring(0, 1));
					} catch (NullPointerException erro) {
						resposta = false;
					} catch (StringIndexOutOfBoundsException erro) {
						resposta = false;
					}
	
					if (resposta) {
						JOptionPane.showMessageDialog(null,
								"Resposta correta! Você avançou 1 casa :D");
						drawPinos(1, getJogadorAtualId(), true);
						avancarCasas(1);
					} else {
						JOptionPane.showMessageDialog(null, "Resposta incorreta!");
						JOptionPane.showMessageDialog(null, "Sua punição será: "
								+ pergunta.getPunicao().getDescricao());
						realizarPunicao(pergunta.getPunicao().getAcao());
					}
					alterarJogador();
				}else{
					JOptionPane.showMessageDialog(null, "Você está na parametrização. Por favor, utilize o botão \"Sortear carta Sorte/Revés\" ");
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnSelecionarSorteReves.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		lblCartaJogador.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				GuiImagem.abrir(jogadorAtual.getProduto().getCodigo()+"_Card.png", 456, 471);				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});

	}

	private void definirProdutos() {
		ProdutosDAO produtosDao = new ProdutosDAO();
		ArrayList<Produto> produtos_aux = new ArrayList<Produto>();
		produtos_aux = produtosDao.getProdutosByLimit(getQuantidadeJogadores());
		Collections.shuffle(produtos_aux);

		Produto[] produtos = new Produto[getQuantidadeJogadores()];

		for (int i = 0; i < produtos.length; i++) {
			produtos[i] = produtos_aux.get(i);
		}

		jogador1.setProduto(produtos[0]);
		jogador2.setProduto(produtos[1]);
		if (jogador3 != null) {
			jogador3.setProduto(produtos[2]);
		}
		if (jogador4 != null) {
			jogador4.setProduto(produtos[3]);
		}

	}

	private void selecionarIniciante() {
		int iniciante = (int) (Math.random() * getQuantidadeJogadores()) + 1;
		jogadorIniciante = iniciante;
		String nome = "";

		switch (iniciante) {
		case 1:
			nome = this.jogador1.getNome();
			this.jogadorAtual = this.jogador1;
			break;
		case 2:
			nome = this.jogador2.getNome();
			this.jogadorAtual = this.jogador2;
			break;
		case 3:
			nome = this.jogador3.getNome();
			this.jogadorAtual = this.jogador3;
			break;
		case 4:
			nome = this.jogador4.getNome();
			this.jogadorAtual = this.jogador4;
			break;
		default:
			nome = this.jogador1.getNome();
			this.jogadorAtual = this.jogador1;
			break;
		}

		lblJogadorAtualNome.setText(nome);
		setJogadorAtualId(iniciante);
		try {
			img = ImageIO.read(new File(jogadorAtual.getProduto().getCodigo()+"_Card.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		ImageIcon imageIcon = new ImageIcon(img); // load the image to a
													// imageIcon
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(200, 207,
				java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg); // transform it back
		lblCartaJogador.setIcon(imageIcon);
		lblDocumentos.setText(""+jogadorAtual.getDocumentos());
		JOptionPane.showMessageDialog(null,
				"O jogador selecionado para iniciar é: " + iniciante + " - "
						+ nome + ". Boa sorte!");

	}

	private void alterarJogador() {
		String nome = "";
		
		switch (getJogadorAtualId()) {
		case 1:
			nome = this.jogador2.getNome();
			this.jogadorAtual = this.jogador2;
			setJogadorAtualId(2);
			break;
		case 2:
			if(this.jogador3!=null){
				nome = this.jogador3.getNome();
				this.jogadorAtual = this.jogador3;
				setJogadorAtualId(3);
			}else{
				nome = this.jogador1.getNome();
				this.jogadorAtual = this.jogador1;
				setJogadorAtualId(1);
			}
			break;
		case 3:
			if(this.jogador4!=null){
				nome = this.jogador4.getNome();
				this.jogadorAtual = this.jogador4;
				setJogadorAtualId(4);
			}else{
				nome = this.jogador1.getNome();
				this.jogadorAtual = this.jogador1;
				setJogadorAtualId(1);
			}
			break;
		case 4:
			nome = this.jogador1.getNome();
			this.jogadorAtual = this.jogador1;
			setJogadorAtualId(1);
			break;
		}
		
		if(getJogadorAtualId()==jogadorIniciante){
			rodada++;
			lblRodada.setText("Rodada: "+rodada);
			if(jogador1.getSemJogar()>0){
				jogador1.setSemJogar(jogador1.getSemJogar()-1);
			}
			if(jogador2.getSemJogar()>0){
				jogador2.setSemJogar(jogador2.getSemJogar()-1);
			}
			if(jogador3!=null){
				if(jogador3.getSemJogar()>0){
					jogador3.setSemJogar(jogador3.getSemJogar()-1);
				}
			}
			if(jogador4!=null){
				if(jogador4.getSemJogar()>0){
					jogador4.setSemJogar(jogador4.getSemJogar()-1);
				}
			}
		}
		
		if(!validaJogador(getJogadorAtualId())){
			System.out.println(getJogadorAtualId()+"/false");
			alterarJogador();
		}
		
		lblJogadorAtualNome.setText(nome);
		try {
			img = ImageIO.read(new File(jogadorAtual.getProduto().getCodigo()+"_Card.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		ImageIcon imageIcon = new ImageIcon(img); // load the image to a
													// imageIcon
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(200, 207,
				java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg); // transform it back
		lblCartaJogador.setIcon(imageIcon);
		lblDocumentos.setText(""+jogadorAtual.getDocumentos());
	}
	
	private boolean validaJogador(int id){
		switch(id){
		case 1:
			if(jogador1.getSemJogar()>0){
				System.out.println(id+"/false");
				return false;
			}else{
				return true;
			}
		case 2:
			if(jogador2.getSemJogar()>0){
				System.out.println(id+"/false");
				return false;
			}else{
				return true;
			}			
		case 3:
			if(jogador3.getSemJogar()>0){
				return false;
			}else{
				return true;
			}
		case 4:
			if(jogador4.getSemJogar()>0){
				return false;
			}else{
				return true;
			}
		default:
			return false;
		}
	}


	public void realizarPunicao(String acao) {
		String acao_wout_param = acao.substring(0, acao.indexOf("("));
		int acao_param;
		switch (acao_wout_param) {
		case "avancarCasas":
			acao_param = Integer.parseInt(acao.substring(acao.indexOf("(") + 1,
					acao.indexOf(")")));
			avancarCasas(acao_param);
		case "voltarCasas":
			acao_param = Integer.parseInt(acao.substring(acao.indexOf("(") + 1,
					acao.indexOf(")")));
			voltarCasas(acao_param);
			break;
		case "semJogar":
			acao_param = Integer.parseInt(acao.substring(acao.indexOf("(") + 1,
					acao.indexOf(")")));
			semJogar(acao_param);
			break;
		case "apresentarDocumentos":
			String acao_param_1 = acao.substring(acao.indexOf("(") + 1,
					acao.indexOf(","));
			String acao_param_2 = acao.substring(acao.indexOf(",") + 1,
					acao.indexOf(")"));
			apresentarDocumentos(acao_param_1, acao_param_2);
			break;
		case "perderDocumentos":
			acao_param = Integer.parseInt(acao.substring(acao.indexOf("(") + 1,
					acao.indexOf(")")));
			perderDocumentos(acao_param);
			break;
		}
	}

	private void avancarCasas(int quantidade) {
		switch (getJogadorAtualId()) {
		case 1:
			this.jogador1.setPosicao(this.jogador1.getPosicao() + quantidade);
			drawPinos(this.jogador1.getPosicao(), 1, true);
			break;
		case 2:
			this.jogador2.setPosicao(this.jogador2.getPosicao() + quantidade);
			drawPinos(this.jogador2.getPosicao(), 2, true);
			break;
		case 3:
			this.jogador3.setPosicao(this.jogador3.getPosicao() + quantidade);
			drawPinos(this.jogador3.getPosicao(), 3, true);
			break;
		case 4:
			this.jogador4.setPosicao(this.jogador4.getPosicao() + quantidade);
			drawPinos(this.jogador4.getPosicao(), 4, true);
			break;
		}
	}

	public void voltarCasas(int quantidade) {
		switch (getJogadorAtualId()) {
		case 1:
			if (this.jogador1.getPosicao() - quantidade > 0) {
				this.jogador1.setPosicao(this.jogador1.getPosicao()
						- quantidade);
			} else {
				this.jogador1.setPosicao(0);
			}
			drawPinos(this.jogador1.getPosicao(), 1, true);
			break;
		case 2:
			if (this.jogador2.getPosicao() - quantidade > 0) {
				this.jogador2.setPosicao(this.jogador2.getPosicao()
						- quantidade);
			} else {
				this.jogador2.setPosicao(0);
			}
			drawPinos(this.jogador2.getPosicao(), 2, true);
			break;
		case 3:
			if (this.jogador3.getPosicao() - quantidade > 0) {
				this.jogador3.setPosicao(this.jogador3.getPosicao()
						- quantidade);
			} else {
				this.jogador3.setPosicao(0);
			}
			drawPinos(this.jogador3.getPosicao(), 3, true);
			break;
		case 4:
			if (this.jogador4.getPosicao() - quantidade > 0) {
				this.jogador4.setPosicao(this.jogador4.getPosicao()
						- quantidade);
			} else {
				this.jogador4.setPosicao(0);
			}
			drawPinos(this.jogador4.getPosicao(), 4, true);
			break;
		}
	}

	public void semJogar(int vezes) {
		System.out.println(getJogadorAtualId());
		System.out.println(vezes);
		switch (getJogadorAtualId()) {
		case 1:
			this.jogador1.setSemJogar(vezes);
			break;
		case 2:
			this.jogador2.setSemJogar(vezes);
			break;
		case 3:
			this.jogador3.setSemJogar(vezes);
			break;
		case 4:
			this.jogador4.setSemJogar(vezes);
			break;
		}
	}

	public void apresentarDocumentos(String positivo, String negativo) {

	}

	public void perderDocumentos(int quantidade) {
		switch (getJogadorAtualId()) {
		case 1:
			if (this.jogador1.getDocumentos() - quantidade > 0) {
				this.jogador1.setDocumentos(this.jogador1.getDocumentos()
						- quantidade);
			} else {
				this.jogador1.setDocumentos(0);
			}
			break;
		case 2:
			if (this.jogador2.getDocumentos() - quantidade > 0) {
				this.jogador2.setDocumentos(this.jogador2.getDocumentos()
						- quantidade);
			} else {
				this.jogador2.setDocumentos(0);
			}
			break;
		case 3:
			if (this.jogador3.getDocumentos() - quantidade > 0) {
				this.jogador3.setDocumentos(this.jogador3.getDocumentos()
						- quantidade);
			} else {
				this.jogador3.setDocumentos(0);
			}
			break;
		case 4:
			if (this.jogador4.getDocumentos() - quantidade > 0) {
				this.jogador4.setDocumentos(this.jogador4.getDocumentos()
						- quantidade);
			} else {
				this.jogador4.setDocumentos(0);
			}
			break;
		}
	}

	public static void abrir(Jogador jogador1, Jogador jogador2) {
		GuiPrincipal principal = new GuiPrincipal(jogador1, jogador2);
		principal.getContentPane().setBackground(new Color(24, 24, 38));
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		principal.setLocation((d.width - principal.getSize().width) / 2,
				(d.height - principal.getSize().height) / 2);
		principal.setExtendedState(MAXIMIZED_BOTH);
		principal.setResizable(true);
		principal.setUndecorated(true);
		principal.setVisible(true);
	}

	public static void abrir(Jogador jogador1, Jogador jogador2,
			Jogador jogador3) {
		GuiPrincipal principal = new GuiPrincipal(jogador1, jogador2, jogador3);
		principal.getContentPane().setBackground(new Color(24, 24, 38));
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		principal.setLocation((d.width - principal.getSize().width) / 2,
				(d.height - principal.getSize().height) / 2);
		principal.setExtendedState(MAXIMIZED_BOTH);
		principal.setResizable(true);
		principal.setUndecorated(true);
		principal.setVisible(true);
	}

	public static void abrir(Jogador jogador1, Jogador jogador2,
			Jogador jogador3, Jogador jogador4) {
		GuiPrincipal principal = new GuiPrincipal(jogador1, jogador2, jogador3,
				jogador4);
		principal.getContentPane().setBackground(new Color(24, 24, 38));
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		principal.setLocation((d.width - principal.getSize().width) / 2,
				(d.height - principal.getSize().height) / 2);
		principal.setExtendedState(MAXIMIZED_BOTH);
		principal.setResizable(true);
		principal.setUndecorated(true);
		principal.setVisible(true);
	}

	public static void main(String[] args) {
		Jogador jogador1 = new Jogador("Vini", 0, 0, false, null, null, 5);
		Jogador jogador2 = new Jogador("Mah", 0, 0, false, null, null, 5);
		GuiPrincipal.abrir(jogador1, jogador2);
	}

}
