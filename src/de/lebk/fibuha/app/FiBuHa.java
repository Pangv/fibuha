package de.lebk.fibuha.app;

import de.lebk.fibuha.account.Account;
import de.lebk.fibuha.account.asset_accounts.AssetAccount;
import de.lebk.fibuha.dao.DataAccessObject;
import de.lebk.fibuha.database.H2Database;
import de.lebk.fibuha.gui.Form;

import java.sql.SQLException;

/**
 * @author sopaetzel
 */
public class FiBuHa {



    static Account x = new AssetAccount(1, "X", 10000000000.0);
    static Account a = new AssetAccount(123, "A", 0.0);
    static Account b = new AssetAccount(023, "B", 0.0);
    static Account c = new AssetAccount(045, "C", 0.0);
    static Account d = new AssetAccount(111, "D", 0.0);
    static Account e = new AssetAccount(122, "E", 0.0);
    static Account f = new AssetAccount(145, "F", 0.0);
    static Account g = new AssetAccount(124, "G", 0.0);
    static Account h = new AssetAccount(112, "H", 0.0);

    public static void main(String[] args){

        try {
            new H2Database();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        DataAccessObject.getInstance().getAccountList().add(x);
        DataAccessObject.getInstance().getAccountList().add(a);
        DataAccessObject.getInstance().getAccountList().add(b);
        DataAccessObject.getInstance().getAccountList().add(c);
        DataAccessObject.getInstance().getAccountList().add(d);
        DataAccessObject.getInstance().getAccountList().add(e);
        DataAccessObject.getInstance().getAccountList().add(f);
        DataAccessObject.getInstance().getAccountList().add(g);
        DataAccessObject.getInstance().getAccountList().add(h);
        Form.main(args);
    }

}
