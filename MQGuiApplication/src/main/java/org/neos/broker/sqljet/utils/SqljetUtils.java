package org.neos.broker.sqljet.utils;

import java.io.File;

import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.SqlJetTransactionMode;
import org.tmatesoft.sqljet.core.table.SqlJetDb;

public class SqljetUtils {
	private static String DATA_BASE_NAME = "mbroker.db";
	private static String TC_CONEXION="TC_CONEXION";
	private static String TW_MENSAJE="TW_MENSAJE";
	private static String TC_USUARIO="TC_USUARIO";
	private static final String CREATE_TC_CONEXION =
			" CREATE TABLE " + TC_CONEXION + " ( " +
			" ID_CONEXION   	TEXT(50) 	NOT NULL," +
			" TIPO_AMBIENTE		TEXT(50) 	NOT NULL," +
			" HOST 				TEXT(100) 	NOT NULL," +
			" QMANAGER			TEXT(100) 	NOT NULL," +
			" QPUT  			TEXT(100) 	NOT NULL," +
			" QGET  			TEXT(100) 	NOT NULL," +
			" QPORT  			INTEGER 	NOT NULL," +
			" QCHANEL 			TEXT(100) 	NOT NULL," +
			" FECHA_ALTA		DATE		NOT NULL," +
			" BND_SECURITY		INTEGER		NOT NULL," +
			" ID_USUARIO		INTEGER," +
			" PRIMARY KEY(ID_CONEXION)," +
			" FOREIGN KEY(ID_USUARIO) REFERENCES TC_USUARIO(ID_USUARIO)" +
			" )";
	private static final String CREATE_TW_MENSAJE =
			" CREATE TABLE " + TW_MENSAJE + " (" +
			" ID_MENSAJE		INTEGER NOT NULL," +
			" TITULO_MENSAJE 	VARCHAR(50) NOT NULL," +
			" REQUEST_MESSAGE	VARCHAR(5000) NOT NULL," +
			" RESPONSE_MESSAGE	VARCHAR(5000) NOT NULL," +
			" ID_CONEXION     	VARCHAR(50) NOT NULL," +
			" PRIMARY KEY(ID_MENSAJE)," +
			" FOREIGN KEY(ID_CONEXION) REFERENCES TC_CONEXION(ID_CONEXION)" +
			" )";
	
	private static final String CREATE_TC_USUARIO =
			" CREATE TABLE " + TC_USUARIO + " ( " +
			" ID_USUARIO		INTEGER		NOT NULL," +
			" USUARIO			TEXT(20) 	NOT NULL," +
			" PASSWORD			TEXT(10) 	NOT NULL," +
			" PRIMARY KEY(ID_USUARIO)" +
			" )";
	
	public static void close(SqlJetDb db) throws SqlJetException {
		db.close();
		db = null;
	}

	public static void beginReadTransaction(SqlJetDb db) throws 
															SqlJetException {
		db.beginTransaction(SqlJetTransactionMode.READ_ONLY);
	}

	public static void commitTransaction(SqlJetDb db) throws SqlJetException {
		db.commit();
	}

	public static SqlJetDb openSql(SqlJetDb db, File fileDB)
			throws SqlJetException {
		db = SqlJetDb.open(fileDB, true);
		db.beginTransaction(SqlJetTransactionMode.WRITE);
		db.getOptions().setUserVersion(1);

		return db;
	}
	
	public static boolean createDataBase() throws SqlJetException{
		SqlJetDb db = null;
		File fileDB = new File(DATA_BASE_NAME);
		boolean existDB=false;

		if (!fileDB.exists()) {
			try {
				db = SqljetUtils.openSql(db, fileDB);
				System.out.println("La BD: " + DATA_BASE_NAME
						+ " FUE CREADA CON EXITO!!!");
				createTables(db, fileDB);
				existDB=true;
			} catch (SqlJetException e) {
				e.printStackTrace();
			} finally {
				commitTransaction(db);
				close(db);
			}
		} else {
			System.out.println("La BD: " + DATA_BASE_NAME
					+ " YA EXISTEE!!!");
		}
		return existDB;
	}
	
	
	  
	public static boolean  createTables(SqlJetDb db,File fileDB) {
		boolean createTables=false;

		try {
			db.createTable(CREATE_TC_CONEXION);
			System.out.println("SE CREO LA TABLA: " +TC_CONEXION +
					" CON EXITO" );
			db.createTable(CREATE_TW_MENSAJE);
			System.out.println("SE CREO LA TABLA: " +TW_MENSAJE +
					" CON EXITO" );
			db.createTable(CREATE_TC_USUARIO);
			System.out.println("SE CREO LA TABLA: " +TC_USUARIO +
					" CON EXITO" );
			createTables=true;
		} catch (SqlJetException e) {
			e.printStackTrace();
		}
	
			
		return createTables;

	}
	

}
