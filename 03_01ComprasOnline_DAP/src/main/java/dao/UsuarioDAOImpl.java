package dao;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Projections;

import utils.Utils;

public class UsuarioDAOImpl implements UsuarioDAO {

	@Override
	public Boolean add(String entity) {
		Integer codigo;
		Document json;
		
		try {
			json = Document.parse(entity);
			codigo = json.getInteger("codigo");			
		} catch (Exception e) {
			return false;
		}
		
		// El producto tiene que tener codigo SI o SI
		if (codigo == null) {
			return false;
		}
		
		Boolean exists = !findById(codigo).equals("");
		
		if (!exists) {
			collection.insertOne(json);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String findAll() {
		StringBuffer sb = new StringBuffer();
		
		Bson projectionFields = Projections.fields(
				Projections.excludeId());
		
		MongoCursor<Document> cursor = collection.find()
				.projection(projectionFields)
				.iterator();
		try {
		     while(cursor.hasNext()) {
		    	 String json = Utils.pretty(cursor.next().toJson());
		    	 json += cursor.hasNext() ? ",\n" : "\n";
		         sb.append(json);
		     }
		} catch (Exception e) {
			System.err.println("Error en findAll de Usuarios");
		} finally {
		     cursor.close();
		}
		
		return sb.toString();
	}

	@Override
	public String findByName(String init) {
		StringBuffer sb = new StringBuffer();
		
		Bson projectionFields = Projections.fields(
				Projections.excludeId());
		
		MongoCursor<Document> cursor = collection.find(regex("nombre", "^" + init.toLowerCase()))
				.projection(projectionFields)
				.iterator();
		try {
		     while(cursor.hasNext()) {
		    	 String json = Utils.pretty(cursor.next().toJson());
		    	 json += cursor.hasNext() ? ",\n" : "\n";
		         sb.append(json);
		     }
		} catch (Exception e) {
			System.err.println("Error en findByName de Usuarios");
		} finally {
		     cursor.close();
		}
		
		return sb.toString();
	}

	@Override
	public String findById(Integer id) {
		String usuario = "";
		
		Bson projectionFields = Projections.fields(
				Projections.excludeId());
		
		MongoCursor<Document> cursor = collection.find(eq("codigo", id))
				.projection(projectionFields)
				.iterator();
		try {
		     if (cursor.hasNext()) {
		    	 usuario = Utils.pretty(cursor.next().toJson());
		     }
		} catch (Exception e) {
			System.err.println("Error en findById de Usuarios");
		} finally {
		     cursor.close();
		}
		
		return usuario;
	}

	@Override
	public Boolean update(String entity) {
		Integer codigo;
		
		try {
			Document json = Document.parse(entity);
			codigo = json.getInteger("codigo");			
		} catch (Exception e) {
			return false;
		}
		
		// El producto tiene que tener codigo SI o SI
		if (codigo == null) {
			return false;
		}
		
		Boolean exists = !findById(codigo).equals("");
		
		if (exists) {
			delete(codigo);
			add(entity);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			if (findById(id).equals("")) {
				return false;
			}
			collection.deleteOne(eq("codigo", id));
		} catch (Exception e) {
			System.err.println("Error en delete de Usuarios");
			return false;
		}
		
		return true;
	}
}
