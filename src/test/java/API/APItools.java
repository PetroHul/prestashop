package API;

import data.IUser;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

public class APItools {

    public static boolean isEmailInBase(String email) {
        Response response = get("customers/?display=[email]");
        return response.asString().contains(email);
    }

    public static String getUserEmail(String id) {
        Response response = get("customers/?display=[email]&filter[id]=[" + id + "]");
        String fst = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<prestashop xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n" +
                "<customers>\n" +
                "<customer>\n" +
                "\t<email><![CDATA[";
        String end = "]]></email>\n" +
                "</customer>\n" +
                "</customers>\n" +
                "</prestashop>\n";

        return response.asString().substring(fst.length()).replaceAll(end,"");
    }

    public static String createUserXML(IUser user) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<prestashop xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n" +
                "    <customer>\n" +
                "        <id></id>\n" +
                "        <id_default_group>3</id_default_group>\n" +
                "        <id_lang></id_lang>\n" +
                "        <newsletter_date_add></newsletter_date_add>\n" +
                "        <ip_registration_newsletter></ip_registration_newsletter>\n" +
                "        <last_passwd_gen></last_passwd_gen>\n" +
                "        <secure_key></secure_key>\n" +
                "        <deleted></deleted>\n" +
                "        <passwd>" + user.getPassword() + "</passwd>\n" +
                "        <lastname>" + user.getLastName() + "</lastname>\n" +
                "        <firstname>" + user.getFirstName() + "</firstname>\n" +
                "        <email>" + user.getEmail() + "</email>\n" +
                "        <id_gender>" + user.getGender() + "</id_gender>\n" +
                "        <birthday></birthday>\n" +
                "        <newsletter></newsletter>\n" +
                "        <optin></optin>\n" +
                "        <website></website>\n" +
                "        <company></company>\n" +
                "        <siret></siret>\n" +
                "        <ape></ape>\n" +
                "        <outstanding_allow_amount></outstanding_allow_amount>\n" +
                "        <show_public_prices></show_public_prices>\n" +
                "        <id_risk></id_risk>\n" +
                "        <max_payment_days></max_payment_days>\n" +
                "        <active>1</active>\n" +
                "        <note></note>\n" +
                "        <is_guest></is_guest>\n" +
                "        <id_shop></id_shop>\n" +
                "        <id_shop_group></id_shop_group>\n" +
                "        <date_add></date_add>\n" +
                "        <date_upd></date_upd>\n" +
                "        <reset_password_token></reset_password_token>\n" +
                "        <reset_password_validity></reset_password_validity>\n" +
                "        <associations>\n" +
                "            <groups>\n" +
                "                <group>\n" +
                "                    <id></id>\n" +
                "                </group>\n" +
                "            </groups>\n" +
                "        </associations>\n" +
                "    </customer>\n" +
                "</prestashop>";
    }
}
