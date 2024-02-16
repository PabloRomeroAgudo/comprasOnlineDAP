package dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

import bd.MongoDB;

public interface CrudDAO {
	public static final MongoClient mongoClient = MongoDB.getClient();
	public static final MongoDatabase database = mongoClient.getDatabase("comprasOnlineDAP");
	
	Boolean add(String entity);
	
	String findAll();

	String findByName(String init);

	String findById(Integer id);
	
	Boolean update(String entity);
	
	Boolean delete(Integer id);
	
}
