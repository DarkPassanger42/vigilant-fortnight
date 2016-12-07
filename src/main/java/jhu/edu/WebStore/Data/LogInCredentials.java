package jhu.edu.WebStore.Data;


public class LogInCredentials {

    private String username;
    private String password;
    private boolean areValid;

    public LogInCredentials(String Username, String Password){
        this.username = Username;
        this.password = Password;
        areValid = false;
    }

    public String getName(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getId(){
        return username;
    }

    public boolean areValid(){
        return this.areValid;
    }

    public void areValid(boolean areValid){
        this.areValid = areValid;
    }

    @Override
    public String toString() {
        return username +" "+ password;
    }




}
