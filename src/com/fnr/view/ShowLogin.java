package com.fnr.view;

import javax.swing.JOptionPane;

import com.fnr.connection.ConnectionFactory;
import com.fnr.model.User;
import com.fnr.utils.LoginInfo;
import com.fnr.utils.Utils;

public class ShowLogin {
	
	public static ConnectionFactory showLoginView() {
		try {
			// LOGIN DO USUÁRIO
			User user = null;
			
			do {
				String email = JOptionPane.showInputDialog(null, "Email:");
				String password = JOptionPane.showInputDialog(null, "Senha:");

				LoginInfo login = new LoginInfo(email, Utils.encryptPassword(password));

				user = Utils.authUser(login);

				if (user == null) {
					JOptionPane.showMessageDialog(null, "Usuário não encontrado... Tente novamente");
				} 
			} while (user == null);
			
			return new ConnectionFactory(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
