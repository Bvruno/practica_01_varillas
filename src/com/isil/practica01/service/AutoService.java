package com.isil.practica01.service;

import java.sql.SQLException;
import java.util.List;

import com.isil.practica01.dao.AutoDAO;
import com.isil.practica01.model.Auto;

/**
 * AbstractService.java This SERVICE class provides CRUD database operations for the
 * table autos in the database.
 * 
 * @author Bruno Varillas
 *
 */
public class AutoService {

    AutoDAO dao= new AutoDAO();

	public void insertAuto(Auto auto) throws SQLException {
		dao.insertAuto(auto);
		} 

	public Auto selectAuto(int id) {
		return dao.selectAuto(id);
	}

	public List<Auto> selectAllAutos() {
		return dao.selectAllAutos();
	}

	public boolean deleteAuto(int id) throws SQLException {
		return dao.deleteAuto(id);
	}

	public boolean updateAuto(Auto auto) throws SQLException {
		return dao.updateAuto(auto);
	}

	

}
