package com.fnr.view;

import javax.swing.JOptionPane;

import com.fnr.connection.ConnectionFactory;

public class BikeStoreDemo {

	public static void main(String[] args) {

		try {
				
			ConnectionFactory conn = ShowLogin.showLoginView();
			if(conn != null) {
				
				int menuOption = 0;
				do {
					
					menuOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Cargo: "+conn.getUserPu() 
					+"\n\nDigite uma opção:"
							+ "\n1 - Bicicletas"
							+ "\n2 - Atendimentos"
							+ "\n3 - Clientes"
							+ "\n4 - Usuários"
							+ "\n\n0 - Logout"));
					
					switch(menuOption) {
						case 1:
							ShowBicycles.showBicyclesView(conn);
							break;
							
						case 2:
	//						ShowBicycles.showBicyclesView(conn);
							break;
							
						case 3:
	//						ShowBicycles.showBicyclesView(conn);
							break;
							
						case 4:
							ShowUsers.showUsersView(conn);
							break;
							
						case 0:
							conn.getEMFactory().close();
							ShowLogin.showLoginView();
							break;
							
						default: JOptionPane.showMessageDialog(null, "Informe um valor vÃ¡lido!");
					}
					
				}while(menuOption != 0);
			}else {
				System.out.println("User inválido");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			ConnectionFactory.getEMFactory().close();
		}

	}

}
