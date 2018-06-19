package com.fnr.view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.fnr.connection.ConnectionFactory;
import com.fnr.model.User;
import com.fnr.utils.LoginInfo;
import com.fnr.utils.Utils;

public class ShowLogin {
	
	public static ConnectionFactory showLoginView() {
		try {
			User user = null;
			
			do {
				String email = JOptionPane.showInputDialog(null, "Email:");
				
				JPanel panel = new JPanel();
				JLabel label = new JLabel("Informe a senha");
				JPasswordField pass = new JPasswordField(10);
				
				panel.add(label);
				panel.add(pass);
				
				panel.setSize(600, 450);
				
				String[] options = new String[]{"OK", "Cancelar"};
				int option = JOptionPane.showOptionDialog(null, panel, "Login",
				                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
				                         null, options, options[0]);
				
				char[] password = null;
				if(option == 0) {
				    password = pass.getPassword();
				}

				LoginInfo login = new LoginInfo(email, Utils.encryptPassword(new String(password)));

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