package kursa;

import java.io.Serializable;

public class Student implements Serializable {

    protected String name;
    protected String surname;
    protected String group;
    protected String password;
    protected String login;
    protected int session;
    Student(String name, String surname, String group, String login,String password) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.login=login;
        this.password = password;
        session=0;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGroup() {
        return group;
    }

    public String getPassword() {
        return password;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login=login;
    }
    public void setPassword(String password) {
        this.password=password;
    }
    public int getSession() {
        return session;
    }
    public void addSession() {
        session++;
    }
}
