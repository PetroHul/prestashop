package DB;

import org.testng.annotations.Test;
import tools.ConncectDB;

import java.sql.SQLException;

public class CartTest {
    @Test
    public void addToCartTestDB() throws SQLException {
        String insert = "INSERT INTO `ps_cart` (`id_cart`, `id_shop_group`, `id_shop`, `id_carrier`, `delivery_option`, `id_lang`, `id_address_delivery`, `id_address_invoice`, `id_currency`, `id_customer`, `id_guest`, `secure_key`, `recyclable`, `gift`, `gift_message`, `mobile_theme`, `allow_seperated_package`, `date_add`, `date_upd`, `checkout_session_data`) VALUES (NULL, '1', '1', '0', '', '1', '0', '0', '1', '149', '1512', 'fa0aaaf5a5410dd59b2b4cfe9dddaf2c', '0', '0', '', '0', '0', '2018-12-16 19:51:56', '2018-12-16 19:51:56', NULL)";
        ConncectDB conncectDB = new ConncectDB();
        conncectDB.DMLDataQuery(insert);

    }
}
