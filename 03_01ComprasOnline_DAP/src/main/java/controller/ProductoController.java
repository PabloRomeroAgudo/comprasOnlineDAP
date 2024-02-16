package controller;

import dao.ProductoDAOImpl;

public class ProductoController {
	ProductoDAOImpl dao = new ProductoDAOImpl();
	
	public Boolean add(String entity){
		return dao.add(entity);
	}

	public String findAll(){
		return dao.findAll();
	}

	public String findByName(String init){
		return dao.findByName(init);
	}

	public String findById(Integer id){
		return dao.findById(id);
	}
	
	public Boolean update(String entity){
		return dao.update(entity);
	}
	
	public Boolean delete(Integer id){
		return dao.delete(id);
	}

}

