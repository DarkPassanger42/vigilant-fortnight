package WebStore;


public class LogInCredentials {

    private String Name;
    private String Password;

    public LogInCredentials(String Name, String Password){
        this.Name = Name;
        this.Password = Password;
    }

    public String getName(){
        return Name;
    }

    public String getPassword(){
        return Password;
    }

    @Override
    public String toString() {
        return Name +" "+ Password;
    }




}
