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
					+ "\n\n0 - Voltar"));
			
			switch(menuOption) {
				case 1:
					JOptionPane.showMessageDialog(null, postBicycle(conn));
					break;
					
				case 2:
					listBicycles(conn);
					break;
					
				case 3:
					listById(conn);
					break;
					
				case 4:
					JOptionPane.showMessageDialog(null, update(conn));
					break;
				
				case 5:
					JOptionPane.showMessageDialog(null, remove(conn));
					break;
					
				case 0:
					break;
				
				default: JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
			}
			
		}while(menuOption != 0);
		
	}
	
	private static String remove(ConnectionFactory conn) {
		if(conn.getUser().getIsAdmin()) {
			int bicycleId = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID da Bicicleta"));
			Bicycle bicycle = bicycleController.getById(conn, bicycleId);
			
			return bicycleController.delete(conn, bicycle, bicycleId).getMessage();
			
		}else {
			return "Empregado não pode realizar alterações no banco";
		}
	}
	
	private static String update(ConnectionFactory conn) {
		if(conn.getUser().getIsAdmin()) {
			int bicycleId = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID da Bicicleta"));
			Bicycle bicycle = bicycleController.getById(conn, bicycleId);
			
			String brand = JOptionPane.showInputDialog("Informe a marca \n-->Marca atual: "+bicycle.getBrand());
			bicycle.setBrand(brand);
			String model = JOptionPane.showInputDialog("Informe o modelo \n-->Modelo atual: "+bicycle.getModel());
			bicycle.setModel(model);
			String color = JOptionPane.showInputDialog("Informe a cor \n-->Cor atual: "+bicycle.getColor());
			bicycle.setColor(color);
			
//		BicycleStatus bicycleStatus = bicycle.getBicycleStatus();
//		int bicycleStatusId = Integer.parseInt(JOptionPane.showInputDialog("Informe o Status ID da Bicicleta \n--> Status Atual: " + bicycleStatus.getBicycleStatus()));
//		bicycleStatus.setBicycleStatusId(bicycleStatusId);
			
			bicycle.setDateTimeUpdate(LocalDateTime.now());
			bicycle.setDateTimeUpdateUserId(conn.getUser().getUserId());	
			
			return bicycleController.put(conn, bicycle).getMessage();
		}else {
			return "Empregado não pode realizar alterações no banco";
		}
		
	}
	
	private static void listById(ConnectionFactory conn) {
		if(conn.getUser() != null) {
			
			int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID da Bicicleta"));
			Bicycle b = bicycleController.getById(conn, id);
			
			JOptionPane.showMessageDialog(null, "ID: "+b.getBicycleId() +" | Marca: "+b.getBrand()+" | Modelo: "+b.getModel()+" | Cor: "+b.getColor() + " | Status: " + b.getBicycleStatus().getDescription());
		}
	}
	
	private static void listBicycles(ConnectionFactory conn) {
			List<Bicycle> bicycles = bicycleController.getAll(conn, new Bicycle());
			
			if(bicycles.isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "Não há bicicletas cadastradas");
			}else {
				
				for (Bicycle b : bicycles) {
					System.out.println("ID: "+b.getBicycleId() +"\tMarca: "+b.getBrand()+"\tModelo: "+b.getModel()+"\tCor: "+b.getColor() + "\tStatus: " + b.getBicycleStatus().getDescription());
				}
			}
	}
	
	private static String postBicycle(ConnectionFactory conn) {
		if(conn.getUser().getIsAdmin()) {
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
		}else {
			return "Empregado não pode realizar alterações no banco";
		}
	}
}
