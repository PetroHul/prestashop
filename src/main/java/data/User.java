package data;

interface ISocialTitle{
    IFirstName setSocialTitle(SocialTitle socialTitle );
}

interface IFirstName {
    ILastName setFirstName(String firstName);
}

interface ILastName {
    IEMail setLastName(String lastName);
}

interface IEMail {
    IPassword setEMail(String email);
}

interface IPassword {
    IBirthdate setPassword(String password);
}

interface IBirthdate {
    IBuildUser setBirthdate(String birthdate);
}

interface IBuildUser {
    IBuildUser setRecieveOffers(boolean recieveOffers);
    IBuildUser setNewsLetter(boolean newsLetter);
    User build();
}


public class User implements ISocialTitle, IFirstName, ILastName, IEMail, IPassword,
        IBirthdate, IBuildUser, IUser{

    private SocialTitle socialTitle;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthdate;
    private boolean recieveOffers;
    private boolean newsletter;

//    public User(){
//
//    }

    /*public User(boolean socialTitle, String firstName, String lastName, String email, String password, String birthdate,
                String recieveOffers, String newsletter) {
        this.socialTitle=socialTitle;
        this.firstName = firstName;
        this.lastName=lastName;
        this.email=email;
        this.password=password;
        this.birthdate=birthdate;
        this.recieveOffers=recieveOffers;
        this.newsletter=newsletter;
    }*/

    private User() {
        recieveOffers= true;
        newsletter=true;
    }

    public static ISocialTitle get(){
        return new User();
    }

    public SocialTitle getSocialTitle() {
        return socialTitle;
    }

    public String getGender() {
        if(getSocialTitle() == SocialTitle.MR){
            return "1";} else return "2";
    };

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public boolean isRecieveOffers() {
        return recieveOffers;
    }

    //Fluent Interface


    public IFirstName setSocialTitle(SocialTitle socialTitle) {
        this.socialTitle = socialTitle;
        return this;
    }

    public ILastName setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public IEMail setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }


    public IPassword setEMail(String email) {
        this.email = email;
        return this;
    }

    public IBirthdate setPassword(String password){
        this.password=password;
        return this;
    }

    public IBuildUser setBirthdate(String birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public IBuildUser setRecieveOffers(boolean recieveOffers) {
        this.recieveOffers = recieveOffers;
        return this;
    }

    public IBuildUser setNewsLetter(boolean newsLetter) {
        this.newsletter = newsLetter;
        return this;
    }



    public User build() {
        return this;
    }

//    public User setRecieveOffers(String recieveOffers) {
//        this.recieveOffers = recieveOffers;
//        return this;
//    }
//
//    public User setNewsletter(String newsletter) {
//        this.newsletter = newsletter;
//        return this;
//    }
}
