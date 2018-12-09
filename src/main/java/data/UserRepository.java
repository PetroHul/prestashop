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
                .setSocialTitle(true)
                .setFirstName("fn1")
                .setLastName("ln1")
                .setEMail("em1@ukr.net")
                .setPassword("password1")
                .setBirthdate("10/12/1856")
                .build();
    }


}
