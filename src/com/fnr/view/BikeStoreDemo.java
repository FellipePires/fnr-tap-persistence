package com.fnr.view;

import java.time.LocalDateTime;

import com.fnr.connection.ConnectionFactory;
import com.fnr.dao.DAO;
import com.fnr.interfaces.IDAO;
import com.fnr.model.BicycleStatus;

public class BikeStoreDemo {

	public static void main(String[] args) {

//		 BicycleStatus b2 = new BicycleStatus("BM", "Bike em manutenção");
//		 b2.setDateTimeCreation(LocalDateTime.now());
//		 b2.setDateTimeCreationUserId(1);
//
//		 IDAO<BicycleStatus> d = new DAO<>();
//		 d.post(b2);

		ConnectionFactory.getEMFactory().close();
	}

}
