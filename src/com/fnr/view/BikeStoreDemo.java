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
					+"\n\nDigite uma opÁ„o:"
							+ "\n1 - Bicicletas"
							+ "\n2 - Atendimentos"
							+ "\n3 - Clientes"
							+ "\n4 - Usu·rios"
							+ "\n\n0 - Logout"));
					
					switch(menuOption) {
					case 1:
						ShowBicycles.showBicyclesView(conn);
						break;
						
					case 2:
						break;
						
					case 3:
						break;
						
					case 4:
						break;
						
					case 0:
						ShowLogin.showLoginView();
						break;
						
//					default: 
					}
					
					
					
				}while(menuOption != 0);
			}else {
				System.out.println("User inv·lido");
			}
			
			
			
			
			
			
//			BicycleStatus bikeStatusPronta = new BicycleStatus("BD", "Bike despachada");
//			bikeStatusPronta.setDateTimeCreation(LocalDateTime.now());
//			bikeStatusPronta.setDateTimeCreationUserId(1);
//
//			IController<BicycleStatus> bikeStatusController = new BicycleStatusController();
//			IController<Bicycle> bikeController = new BicycleController();
//
//			bikeStatusController.post(bikeStatusPronta);// Inserir Bike Status (OK)
//			
//			List<BicycleStatus> b1 = bikeStatusController.getAll(new BicycleStatus()); // Listar todos os dados da tabela (OK)
//			for (BicycleStatus b : b1) {
//				System.out.println(b.getDescription());
//			}

			// In√≠cio fun√ß√£o atualizar (OK)
//			 BicycleStatus bikeStatus = bikeStatusController.getById(4);
//			
//			 Bicycle bike = bikeController.getById(3);
//			 bike.setBicycleStatus(bikeStatus);
//			 bike.setBrand("Cannondale");
//			 bike.setColor("Vermelho");
//			 bike.setModel("F21");
//			
//			 System.out.println(bikeController.put(bike, 3));

			// In√≠cio fun√ß√£o remover (OK)
			// System.out.println(bikeController.delete(3));
//
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			ConnectionFactory.getEMFactory().close();
		}

	}

}
