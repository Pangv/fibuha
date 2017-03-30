package de.lebk.fibuha.database;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author sopaetzel
 */
public class H2Database {

    public H2Database() throws SQLException, ClassNotFoundException {
        DatabaseConnection.getInstance().openConnection();
        Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();





        statement.execute("create table if not exists kontoart (kontoartid int primary key, bezeichnung varchar(32) unique)");
        //
        statement.execute("create table if not exists konto (kontonummer varchar(4) primary key, bezeichnung varchar(32) unique, anfangsbestand double, kontoart int)");
        statement.execute("alter table konto add foreign key (kontoart) references kontoart(kontoartid)");
        //
        statement.execute("create table if not exists buchung (zeitpunkt datetime primary key, sollkonto varchar(4),habenkonto varchar(4), buchungsbetrag double)");
        statement.execute("alter table buchung add foreign key (sollkonto) references konto(kontonummer)");
        statement.execute("alter table buchung add foreign key (habenkonto) references konto(kontonummer)");

        System.out.println("Tables created");


        DatabaseConnection.getInstance().changeData("merge into kontoart values('1','Aktivkonto')");
        DatabaseConnection.getInstance().changeData("merge into kontoart values('2','Passivkonto')");
        DatabaseConnection.getInstance().changeData("merge into kontoart values('3','Ertragskonto')");
        DatabaseConnection.getInstance().changeData("merge into kontoart values('4','Aufwandskonto')");

        DatabaseConnection.getInstance().changeData("merge into konto values('0134','BGA','3000.50','1')");

/*
        DbZugriff.getZugriffsObjekt().aendereDaten("MERGE INTO " + table + " VALUES('Delta','C2C')");
        DbZugriff.getZugriffsObjekt().aendereDaten("MERGE INTO " + table + " VALUES('Sonnentanz','Klangkarussel')");
        DbZugriff.getZugriffsObjekt().aendereDaten("MERGE INTO " + table + " VALUES('Fiction','The XX')");
        DbZugriff.getZugriffsObjekt().aendereDaten("MERGE INTO " + table + " VALUES('Sun and Moon','Above & Beyond')");

        System.out.println("Lines inserted");
        System.out.println("==============\n");


        DbZugriff.getZugriffsObjekt().getMetaInformation();*/


        DatabaseConnection.getInstance().closeConnection();
    }
}
