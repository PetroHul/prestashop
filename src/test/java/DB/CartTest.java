package DB;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tools.ConncectDB;

import java.sql.SQLException;

public class CartTest {

    @DataProvider(name = "cartInsert")
    public static Object[][] cartInsert() {

        String insert1 =
                "INSERT INTO `ps_cart` (`id_cart`, `id_shop_group`, `id_shop`," +
                        " `id_carrier`, `delivery_option`, `id_lang`, `id_address_delivery`, " +
                        "`id_address_invoice`, `id_currency`, `id_customer`, `id_guest`, " +
                        "`secure_key`,`date_add`,`date_upd`) " +
                        "VALUES ('1500', '1', '1', '0', '', '1', '0', '0', '1', '149', '1512'," +
                        " 'fa0aaaf5a5410dd59b2b4cfe9dddaf2c','2018-12-16 19:51:56','2018-12-16 19:51:56')";
        String insert2 =
                "INSERT INTO `ps_cart` (`id_cart`, `id_shop_group`, `id_shop`," +
                        " `id_carrier`, `delivery_option`, `id_lang`, `id_address_delivery`, " +
                        "`id_address_invoice`, `id_currency`, `id_customer`, `id_guest`, " +
                        "`secure_key`,`date_add`,`date_upd`) " +
                        "VALUES ('1501', '1', '1', '0', '', '1', '0', '0', '1', '149', '1512'," +
                        " 'fa0aaaf5a5410dd59b2b4cfe9dddaf2c','2018-12-16 19:51:56','2018-12-16 19:51:56')";
        return new Object[][]{{insert1}, {insert2}};
    }

    @Test(dataProvider = "cartInsert")
    public void addToCartTestDB(String insert) throws SQLException {
        ConncectDB conncectDB = new ConncectDB();
        conncectDB.DMLDataQuery(insert);
    }


    @DataProvider(name = "cartDelete")
    public static Object[][] cartDelete() {
        String delete1 = "DELETE FROM `ps_cart` WHERE `ps_cart`.`id_cart` = 1500";
        String delete2 = "DELETE FROM `ps_cart` WHERE `ps_cart`.`id_cart` = 1501";
        return new Object[][]{{delete1}, {delete2}};
    }


    @Test(dataProvider = "cartDelete")
    public void deleteFromCartTestDB(String delete) throws SQLException {
        ConncectDB conncectDB = new ConncectDB();
        conncectDB.DMLDataQuery(delete);
    }

}
