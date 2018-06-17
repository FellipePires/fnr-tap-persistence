package com.fnr.view;

import java.time.LocalDateTime;
import java.util.List;

import com.fnr.connection.ConnectionFactory;
import com.fnr.controller.BicycleController;
import com.fnr.controller.BicycleStatusController;
import com.fnr.interfaces.IController;
import com.fnr.model.Bicycle;
import com.fnr.model.BicycleStatus;

public class BikeStoreDemo {

	public static void main(String[] args) {

		System.out.println(BikeStoreDemo.class.getSimpleName());
		
		try {
			BicycleStatus bikeStatusPronta = new BicycleStatus("BD", "Bike despachada");
			bikeStatusPronta.setDateTimeCreation(LocalDateTime.now());
			bikeStatusPronta.setDateTimeCreationUserId(1);

			IController<BicycleStatus> bikeStatusController = new BicycleStatusController();
			IController<Bicycle> bikeController = new BicycleController();

			bikeStatusController.post(bikeStatusPronta);// Inserir Bike Status (OK)
			
			List<BicycleStatus> b1 = bikeStatusController.getAll(new BicycleStatus()); // Listar todos os dados da tabela (OK)
			for (BicycleStatus b : b1) {
				System.out.println(b.getDescription());
			}

			// Início função atualizar (OK)
			// BicycleStatus bikeStatus = bikeStatusController.getById(4);
			//
			// Bicycle bike = bikeController.getById(3);
			// bike.setBicycleStatus(bikeStatus);
			// bike.setBrand("Cannondale");
			// bike.setColor("Vermelho");
			// bike.setModel("F21");
			//
			// System.out.println(bikeController.put(bike, 3));

			// Início função remover (OK)
			// System.out.println(bikeController.delete(3));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.getEMFactory().close();
		}

	}

}
