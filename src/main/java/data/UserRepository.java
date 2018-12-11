package data;

public class UserRepository {

    private static volatile UserRepository instance = null;

    private UserRepository() {
    }

    public static UserRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    public IUser newUser() {
        return User.get()
                .setSocialTitle(SocialTitle.MR)
                .setFirstName("someone")
                .setLastName("someoneelse")
                .setEMail("emailsomeone@ukr.net")
                .setPassword("password1")
                .setBirthdate("10/12/1986")
                .setRecieveOffers(false)
                .setNewsLetter(true)
                .build();
    }


}
