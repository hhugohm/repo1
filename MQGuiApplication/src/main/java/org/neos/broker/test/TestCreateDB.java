package org.neos.broker.test;

import org.neos.broker.sqljet.utils.SqljetUtils;
import org.tmatesoft.sqljet.core.SqlJetException;

public class TestCreateDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			SqljetUtils.createDataBase();
		} catch (SqlJetException e) {
		
			e.printStackTrace();
		}

	}

}
