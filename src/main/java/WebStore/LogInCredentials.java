package WebStore;


public class LogInCredentials {

    private String name;
    private String password;
    private boolean areValid;

    public LogInCredentials(String Name, String Password){
        this.name = Name;
        this.password = Password;
        areValid = false;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public boolean areValid(){
        return this.areValid;
    }

    public void areValid(boolean areValid){
        this.areValid = areValid;
    }


    @Override
    public String toString() {
        return name +" "+ password;
    }




}
