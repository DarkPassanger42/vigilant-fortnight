package jhu.edu.WebStore.Data;


public class LogInCredentials {

    private String id;
    private String password;
    private boolean areValid;

    public LogInCredentials(String ID, String Password){
        this.id = ID;
        this.password = Password;
        areValid = false;
    }

    public String getName(){
        return id;
    }

    public String getPassword(){
        return password;
    }

    public String getId(){
        return id;
    }

    public boolean areValid(){
        return this.areValid;
    }

    public void areValid(boolean areValid){
        this.areValid = areValid;
    }


    @Override
    public String toString() {
        return id +" "+ password;
    }




}
