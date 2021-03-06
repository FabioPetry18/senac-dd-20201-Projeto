package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuCadastro = new JMenu("Cadastro");
		menuCadastro.setHorizontalAlignment(SwingConstants.LEFT);
		menuCadastro.setForeground(Color.BLACK);
		menuCadastro.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(menuCadastro);
		
		JMenuItem menuItemCadastroAlunoInstrutor = new JMenuItem("Aluno/Instrutor");
		menuItemCadastroAlunoInstrutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane = new PainelCadastroAlunoInstrutor();
				setContentPane(contentPane);
				revalidate();				
			}
		});
		menuCadastro.add(menuItemCadastroAlunoInstrutor);
		
		JMenuItem menuItemCadastroModalidade = new JMenuItem("Modalidade");
		menuItemCadastroModalidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane = new PainelCadastroModalidade();
				setContentPane(contentPane);
				revalidate();
			}
		});
		menuCadastro.add(menuItemCadastroModalidade);
		
		JMenu menuConsulta = new JMenu("Consulta");
		menuConsulta.setForeground(Color.BLACK);
		menuConsulta.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(menuConsulta);
		
		JMenuItem menuItemConsultaAluno = new JMenuItem("Aluno");
		menuItemConsultaAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane = new PainelConsultaAluno();
				setContentPane(contentPane);
				revalidate();
			}
		});
		menuConsulta.add(menuItemConsultaAluno);
		
		JMenuItem menuItemConsultaInstrutor = new JMenuItem("Instrutor");
		menuItemConsultaInstrutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane = new PainelConsultaInstrutor();
				setContentPane(contentPane);
				revalidate();
			}
		});
		menuConsulta.add(menuItemConsultaInstrutor);
		
		JMenu mnEditar = new JMenu("Editar");
		mnEditar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnEditar.setForeground(Color.BLACK);
		menuBar.add(mnEditar);
		
		JMenuItem menuItemAluno = new JMenuItem("Aluno");
		menuItemAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane = new PainelEdicaoAluno();
				setContentPane(contentPane);
				revalidate();
			}
		});
		mnEditar.add(menuItemAluno);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
