package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.AlunoController;
import controller.InstrutorController;
import javax.swing.JTextPane;

public class PainelCadastroAlunoInstrutor extends JPanel {
	
	private JLabel lblObservacoes;
	private JLabel lblFormacao;
	private JLabel lblSalario;
	private JTextField txtNome;
	private JTextField txtDataNascimento;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCep;
	private JTextField txtTelefone;
	private JTextField txtCelular;
	private JTextField txtEmail;
	private JTextField txtObservacoes;
	private JTextField txtSalario;
	private JTextField txtFormacao;
	private JFormattedTextField txtCpf;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;
	private JRadioButton rdbtnAluno;
	private JRadioButton rdbtnInstrutor;
	private JComboBox comboBoxModalidade;

	/**
	 * Create the panel.
	 */
	public PainelCadastroAlunoInstrutor() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 41, 1, 1);
		panel.setLayout(null);
		add(panel);
		
		JLabel lblNome = new JLabel("Nome Completo");
		lblNome.setBounds(28, 66, 111, 14);
		add(lblNome);
		
		JLabel lblEndere�o = new JLabel("Endere\u00E7o");
		lblEndere�o.setBounds(28, 254, 111, 14);
		add(lblEndere�o);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(346, 107, 46, 14);
		add(lblSexo);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(28, 190, 111, 14);
		add(lblCelular);
		
		JLabel lblCep = new JLabel("Cep");
		lblCep.setBounds(28, 229, 111, 14);
		add(lblCep);
		
		JLabel lblDtNascimento = new JLabel("Data Nascimento");
		lblDtNascimento.setBounds(28, 97, 111, 14);
		add(lblDtNascimento);
		
		JLabel lblCpf = new JLabel("Cpf");
		lblCpf.setBounds(28, 127, 111, 14);
		add(lblCpf);
		
		JLabel lblModalidade = new JLabel("Modalidade");
		lblModalidade.setBounds(346, 164, 86, 14);
		add(lblModalidade);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(28, 279, 111, 14);
		add(lblBairro);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(28, 161, 111, 14);
		add(lblTelefone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(28, 319, 111, 14);
		add(lblEmail);
		
		lblObservacoes = new JLabel("Observa\u00E7\u00F5es");
		lblObservacoes.setVisible(false);
		lblObservacoes.setBounds(28, 357, 111, 14);
		add(lblObservacoes);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(126, 254, 148, 20);
		txtEndereco.setColumns(10);
		add(txtEndereco);		
				
		txtNome = new JTextField();
		txtNome.setBounds(126, 66, 148, 20);
		txtNome.setColumns(10);
		add(txtNome);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(126, 189, 148, 20);
		txtCelular.setColumns(10);
		add(txtCelular);
		
		txtCep = new JTextField();
		txtCep.setBounds(126, 223, 148, 20);
		txtCep.setColumns(10);
		add(txtCep);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setBounds(126, 94, 148, 20);
		txtDataNascimento.setColumns(10);
		add(txtDataNascimento);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(126, 285, 148, 20);
		txtBairro.setColumns(10);
		add(txtBairro);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(126, 161, 148, 20);
		txtTelefone.setColumns(10);
		add(txtTelefone);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(126, 316, 148, 20);
		txtEmail.setColumns(10);
		add(txtEmail);
		
		txtObservacoes = new JTextField();
		txtObservacoes.setVisible(false);
		txtObservacoes.setBounds(28, 381, 246, 94);
		txtObservacoes.setColumns(10);
		add(txtObservacoes);
		
		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			txtCpf = new JFormattedTextField(mascaraCpf);
			txtCpf.setBounds(126, 127, 148, 20);
			add(txtCpf);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(375, 123, 86, 23);
		add(rdbtnMasculino);
		
		rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(548, 123, 86, 23);
		add(rdbtnFeminino);
		
		ButtonGroup btnGroupSexo = new ButtonGroup();
		btnGroupSexo.add(rdbtnMasculino);
		btnGroupSexo.add(rdbtnFeminino);
		
		ArrayList<String> listaModalidades = consultarModalidades();
		comboBoxModalidade = new JComboBox(listaModalidades.toArray());
		comboBoxModalidade.setBounds(346, 189, 182, 20);
		add(comboBoxModalidade);
		
		rdbtnAluno = new JRadioButton("Aluno");
		rdbtnAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblObservacoes.setVisible(true);
				txtObservacoes.setVisible(true);
				lblFormacao.setVisible(false);
				lblSalario.setVisible(false);
				txtFormacao.setVisible(false);
				txtSalario.setVisible(false);			
			}
		});
		
		rdbtnAluno.setBounds(375, 38, 81, 23);
		add(rdbtnAluno);
		
		rdbtnInstrutor = new JRadioButton("Instrutor");
		rdbtnInstrutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFormacao.setVisible(true);
				lblSalario.setVisible(true);
				txtFormacao.setVisible(true);
				txtSalario.setVisible(true);
				lblObservacoes.setVisible(false);
				txtObservacoes.setVisible(false);
			}
		});
		rdbtnInstrutor.setBounds(548, 38, 109, 23);
		add(rdbtnInstrutor);
		
		ButtonGroup btnGroupTipo = new ButtonGroup();
		btnGroupTipo.add(rdbtnAluno);
		btnGroupTipo.add(rdbtnInstrutor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mensagem = "";
				if(rdbtnAluno.isSelected()) {
					AlunoController controller = new AlunoController();
					mensagem = controller.cadastrarAluno(txtCpf.getText(), txtNome.getText(),
							txtDataNascimento.getText(), txtTelefone.getText(),
							txtCelular.getText(), txtEndereco.getText(), txtBairro.getText(),
							txtCep.getText(), txtEmail.getText(), comboBoxModalidade.getSelectedItem().toString(),
							txtObservacoes.getText());
					
				} else if(rdbtnInstrutor.isSelected()) {
					InstrutorController controller = new InstrutorController();
					mensagem = controller.cadastrarInstrutor(txtCpf.getText(), txtNome.getText(),
							txtDataNascimento.getText(), txtTelefone.getText(), txtCelular.getText(),
							txtEndereco.getText(), txtBairro.getText(), txtCep.getText(), txtEmail.getText(),
							comboBoxModalidade.getSelectedItem().toString(), txtObservacoes.getText(),
							txtFormacao.getText(), txtSalario.getText());
					
				} else {
					mensagem = "Selecione o tipo de cadastro (Aluno/Instrutor)";
				}
				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		btnCadastrar.setBounds(273, 491, 119, 23);
		add(btnCadastrar);
		
		lblSalario = new JLabel("Salario");
		lblSalario.setVisible(false);
		lblSalario.setBounds(346, 357, 46, 14);
		add(lblSalario);
		
		txtSalario = new JTextField();
		txtSalario.setVisible(false);
		txtSalario.setBounds(428, 354, 229, 20);
		add(txtSalario);
		txtSalario.setColumns(10);
		
		lblFormacao = new JLabel("Forma\u00E7\u00E3o");
		lblFormacao.setVisible(false);
		lblFormacao.setBounds(346, 319, 61, 14);
		add(lblFormacao);
		
		txtFormacao = new JTextField();
		txtFormacao.setVisible(false);
		txtFormacao.setBounds(428, 316, 229, 20);
		add(txtFormacao);
		txtFormacao.setColumns(10);
		
		JTextPane txtpnAtuacao = new JTextPane();
		txtpnAtuacao.setText("Atuacao");
		txtpnAtuacao.setBounds(346, 11, 61, 20);
		add(txtpnAtuacao);
		
	}
	
	private ArrayList<String> consultarModalidades() {
		
		ArrayList<String> listaModalidades = new ArrayList<String>();
		
		listaModalidades.add("Musculac�o");
		listaModalidades.add("Nata��o");
		listaModalidades.add("Boxe");
		
		return listaModalidades;
	}
}
