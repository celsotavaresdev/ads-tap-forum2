package br.unisanta.ads.project;

import javax.swing.JOptionPane;

import net.ucanaccess.jdbc.UcanaccessSQLException;

public class BookBLL {
	private Book book = new Book();
	private BookUIL uil;

	public void setUIL(BookUIL uil) {
		this.uil = uil;
	}

	public void initBLL() {
        uil.getBtnSalvar().addActionListener(e -> createBook());
        uil.getBtnLer().addActionListener(e -> getBook());
        uil.getBtnLimpar().addActionListener(e -> clearFields());
        uil.getBtnExcluir().addActionListener(e -> deleteBook());
        uil.getBtnAlterar().addActionListener(e -> updateBook());
    }

	private void createBook() {
		try {
            validateFields();

            book = new Book();
            book.setCodigo(uil.getTxtCodigo().getText().trim());
            book.setTitulo(uil.getTxtTitulo().getText().trim());
            book.setAutor(uil.getTxtAutor().getText().trim());
            book.setEditora(uil.getTxtEditora().getText().trim());
            book.setAno(uil.getTxtAno().getText().trim());

            BookDAL.create(book);

            JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (ValidationException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Atenção", JOptionPane.WARNING_MESSAGE);
		} catch (UcanaccessSQLException e) {
			JOptionPane.showMessageDialog(null, "Código já cadastrado em outro livro!","Erro", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!","Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
	}

	public void getBook() {
		try {
			validateCodigo();
			
			book = new Book();
			book = BookDAL.get(uil.getTxtCodigo().getText().trim());
			
			fillFields();
		} catch (ValidationException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Atenção", JOptionPane.WARNING_MESSAGE);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Livro não encontrado!","Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!","Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
	}

	public void deleteBook() {
		try {
			validateCodigo();

			book = BookDAL.get(uil.getTxtCodigo().getText().trim());
			BookDAL.delete(book.getCodigo());
			
			clearFields();
			JOptionPane.showMessageDialog(null, "Livro removido com sucesso!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (ValidationException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Atenção", JOptionPane.WARNING_MESSAGE);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Livro não encontrado!","Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!","Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
	}

	public void updateBook() {
		try {
            validateFields();

            book = BookDAL.get(uil.getTxtCodigo().getText().trim());
            
            book.setCodigo(uil.getTxtCodigo().getText().trim());
            book.setTitulo(uil.getTxtTitulo().getText().trim());
            book.setAutor(uil.getTxtAutor().getText().trim());
            book.setEditora(uil.getTxtEditora().getText().trim());
            book.setAno(uil.getTxtAno().getText().trim());

            BookDAL.update(book);

            JOptionPane.showMessageDialog(null, "Livro atualizado com sucesso!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (ValidationException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Atenção", JOptionPane.WARNING_MESSAGE);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Livro não encontrado!","Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!","Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
	}
	
	public void clearFields() {
		uil.getTxtCodigo().setText("");
		uil.getTxtTitulo().setText("");
		uil.getTxtAutor().setText("");
		uil.getTxtEditora().setText("");
		uil.getTxtAno().setText("");
    }

	private void fillFields() {
		uil.getTxtCodigo().setText(book.getCodigo());
		uil.getTxtTitulo().setText(book.getTitulo());
		uil.getTxtAutor().setText(book.getAutor());
		uil.getTxtEditora().setText(book.getEditora());
		uil.getTxtAno().setText(book.getAno());
    }
	
	private void validateCodigo() throws ValidationException {
		if (uil.getTxtCodigo().getText().trim().isEmpty()) {
			throw new ValidationException("O código é de preenchimento obrigatório!");
        }
    }
	
	private void validateFields() throws ValidationException {
		validateCodigo();

		if (uil.getTxtTitulo().getText().trim().isEmpty()) {
			throw new ValidationException("O título é de preenchimento obrigatório!");
        }

		if (uil.getTxtAutor().getText().trim().isEmpty()) {
			throw new ValidationException("O autor é de preenchimento obrigatório!");
        }
		
		if (uil.getTxtEditora().getText().trim().isEmpty()) {
			throw new ValidationException("A editora é de preenchimento obrigatório!");
        }
		
		if (uil.getTxtAno().getText().trim().isEmpty()) {
			throw new ValidationException("O ano é de preenchimento obrigatório!");
        }	

		try {
			Integer.parseInt(uil.getTxtAno().getText());
        }
        catch (NumberFormatException e) {
        	throw new ValidationException("O valor do ano deve ser numérico!");
        }
		
		if (! (Integer.parseInt(uil.getTxtAno().getText()) > 0)) {
			throw new ValidationException("O valor do ano deve ser positivo!");
        }
		

    }
}