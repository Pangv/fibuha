package de.lebk.fibuha.database;

import java.sql.*;

/**
 * @author sopaetzel
 */
public class DatabaseConnection {

    private static DatabaseConnection instance = new DatabaseConnection();
    private Connection connection;
    private Statement statement;

    private DatabaseConnection() {

    }

    public static DatabaseConnection getInstance() {
        return instance;
    }

    public void openConnection() throws SQLException, ClassNotFoundException {
        String connectionString = "jdbc:h2:~/data/fibuha";
        Class.forName("org.h2.Driver");
        this.connection = DriverManager.getConnection(connectionString, "", "");
        this.statement = connection.createStatement();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public ResultSet getData(String sql) throws SQLException {
        return statement.executeQuery(sql);
    }

    public int changeData(String sql) throws SQLException {
        return statement.executeUpdate(sql);
    }

    public boolean mergeData(String sql) throws SQLException {
        return statement.execute(sql);
    }

    void getMetaInformation() throws SQLException {
        DatabaseMetaData metaData = this.connection.getMetaData();

        String[] types = {"TABLE"};

        ResultSet metaRS = metaData.getTables(null, null, "%", types);

        while (metaRS.next()) {
            System.out.println("Meta-Information: ");
            System.out.println("==============\n");
            // Catalog
            String tableCatalog = metaRS.getString(1);
            System.out.println("Catalog: " + tableCatalog);

            // Schemata
            String tableSchema = metaRS.getString(2);
            System.out.println("Tabellen-Schema: " + tableSchema);

            // Tabellennamen
            String tableName = metaRS.getString(3);
            System.out.println("Tabellen-Name: " + tableName);

            // Tabellentyp
            String tableType = metaRS.getString(4);
            System.out.println("Tabellen-Typ: " + tableType + "\n");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
