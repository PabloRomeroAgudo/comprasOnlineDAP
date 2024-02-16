package dao;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public interface UsuarioDAO extends CrudDAO {
	
	public static final MongoCollection<Document> collection = database.getCollection("usuarios");
}
