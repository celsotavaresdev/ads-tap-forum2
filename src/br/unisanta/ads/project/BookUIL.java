package br.unisanta.ads.project;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BookUIL extends JFrame {

	private final JTextField txtCodigo;
	private final JTextField txtTitulo;
	private final JTextField txtAutor;
	private final JTextField txtEditora;
	private final JTextField txtAno;
	private final JButton btnSalvar;
	private final JButton btnLer;
	private final JButton btnLimpar;
	private final JButton btnExcluir;
	private final JButton btnAlterar;

	public BookUIL() {
		setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 300, 293);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(10, 15, 48, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblTitulo = new JLabel("Título:");
		lblTitulo.setBounds(10, 46, 48, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(10, 77, 48, 14);
		contentPane.add(lblAutor);
		
		JLabel lblEditora = new JLabel("Editora:");
		lblEditora.setBounds(10, 108, 48, 14);
		contentPane.add(lblEditora);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(10, 139, 48, 14);
		contentPane.add(lblAno);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(60, 12, 55, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(60, 43, 214, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(60, 74, 214, 20);
		contentPane.add(txtAutor);
		txtAutor.setColumns(10);
		
		txtEditora = new JTextField();
		txtEditora.setBounds(60, 105, 214, 20);
		contentPane.add(txtEditora);
		txtEditora.setColumns(10);
		
		txtAno = new JTextField();
		txtAno.setBounds(60, 136, 55, 20);
		contentPane.add(txtAno);
		txtAno.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 186, 80, 23);
		contentPane.add(btnSalvar);
		
		btnLer = new JButton("Ler");
		btnLer.setBounds(102, 186, 80, 23);
		contentPane.add(btnLer);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(194, 186, 80, 23);
		contentPane.add(btnLimpar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(10, 220, 80, 23);
		contentPane.add(btnExcluir);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(102, 220, 80, 23);
		contentPane.add(btnAlterar);
	}

	public JTextField getTxtCodigo() {
		return txtCodigo;
	}

	public JTextField getTxtTitulo() {
		return txtTitulo;
	}

	public JTextField getTxtAutor() {
		return txtAutor;
	}

	public JTextField getTxtEditora() {
		return txtEditora;
	}

	public JTextField getTxtAno() {
		return txtAno;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public JButton getBtnLer() {
		return btnLer;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public JButton getBtnExcluir() {
		return btnExcluir;
	}

	public JButton getBtnAlterar() {
		return btnAlterar;
	}
}