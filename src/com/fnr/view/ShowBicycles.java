package com.fnr.view;

import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JOptionPane;

import com.fnr.connection.ConnectionFactory;
import com.fnr.controller.BicycleController;
import com.fnr.controller.BicycleStatusController;
import com.fnr.interfaces.IController;
import com.fnr.model.Bicycle;
import com.fnr.model.BicycleStatus;

public class ShowBicycles {
	static IController<Bicycle> bicycleController = new BicycleController();
	static IController<BicycleStatus> bicycleStatusController = new BicycleStatusController();

	
	public static void showBicyclesView(ConnectionFactory conn) {
		
		int menuOption = 0;
		do {
			menuOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite uma opção:"
					+ "\n1 - Cadastrar"
					+ "\n2 - Listar"
					+ "\n3 - Buscar por código"
					+ "\n4 - Atualizar"
					+ "\n5 - Remover"
					+ "\n0 - Voltar"));
			
			switch(menuOption) {
				case 1:
					JOptionPane.showMessageDialog(null, postBicycle(conn));
					break;
					
				case 2:
					break;
					
				case 3:
					break;
					
				case 4:
					break;
				
				case 5:
					break;
					
				case 0:
					break;
				
//				default: 
			}
			
		}while(menuOption != 0);
		
	}
	
	private static String postBicycle(ConnectionFactory conn) {
		String brand = JOptionPane.showInputDialog(null, "Informe a marca");
		String model = JOptionPane.showInputDialog(null, "Informe o modelo");
		String color = JOptionPane.showInputDialog(null, "Informe a cor");
		
		List<BicycleStatus> bStatus = bicycleStatusController.getAll(conn, new BicycleStatus()); 
		for (BicycleStatus b : bStatus) {
			System.out.println("Status: "+b.getBicycleStatus()+"\tDescrição: "+b.getDescription()+"\tID: "+b.getBicycleStatusId());
		}
		
		int idBicycleStatus = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do Status da bicicleta: "));
		
		BicycleStatus bicycleStatus = bicycleStatusController.getById(conn, idBicycleStatus);
		
		Bicycle bicycle = new Bicycle(bicycleStatus, brand, model, color);
		bicycle.setDateTimeCreation(LocalDateTime.now());
		bicycle.setDateTimeCreationUserId(conn.getUser().getUserId());		
		
		return bicycleController.post(conn, bicycle).getMessage();
	}
}
