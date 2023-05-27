package br.unisanta.ads.project;

import java.sql.SQLException;

public class Application {

	public static void main(String[] args) {
		
		try {
			BookDAL.getConnection();
		} catch (SQLException e) {
			System.exit(0);
		}

		BookBLL bll = new BookBLL();
		bll.setUIL(new BookUIL());
		bll.initBLL();
	}
}