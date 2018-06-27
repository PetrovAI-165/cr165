package kursa;

public class Teacher {
    protected String name;
    protected String surname;
    protected String secondName;
    protected static String password="908f";
    Teacher(String name,String surname, String secondName){
        this.name=name;
        this.surname=surname;
        this.secondName=secondName;
    }
    public static String getPassword(){
        return password;
    }
    public static void setPassword(String p){
        password=p;
    }
    public String getName() {
        return name;
    }
    public String getSecondName() {
        return secondName;
    }
    public String getSurname() {
        return surname;
    }
    public void setName(String n){
        name=n;
    }
    public void setSurname(String sn){
        surname=sn;
    }
    public void setSecondName(String scn){
        secondName=scn;
    }
}
