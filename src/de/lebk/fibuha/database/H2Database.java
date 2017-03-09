package de.lebk.fibuha.database;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author sopaetzel
 */
public class H2Database {

    public H2Database() throws SQLException{
        String table = "";
        Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();

        String createTable = "CREATE TABLE IF NOT EXISTS " + table
                + " (lied VARCHAR(76) PRIMARY KEY NOT NULL, interpret VARCHAR(255) NOT NULL)";
/*        statement.executeUpdate(createTable);

        System.out.println("Table created");


        DbZugriff.getZugriffsObjekt().aendereDaten("MERGE INTO " + table + " VALUES('Delta','C2C')");
        DbZugriff.getZugriffsObjekt().aendereDaten("MERGE INTO " + table + " VALUES('Sonnentanz','Klangkarussel')");
        DbZugriff.getZugriffsObjekt().aendereDaten("MERGE INTO " + table + " VALUES('Fiction','The XX')");
        DbZugriff.getZugriffsObjekt().aendereDaten("MERGE INTO " + table + " VALUES('Sun and Moon','Above & Beyond')");

        System.out.println("Lines inserted");
        System.out.println("==============\n");


        DbZugriff.getZugriffsObjekt().getMetaInformation();*/
    }
}
