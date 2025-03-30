package org.example.firstapi;

// Создаем класс, чтобы мы могли принимать запросы юзера через методы get

public class UserRequest {
    private Integer id;
    private String name;
    private Long phone;
    private String email;
    private String author;
    private String role;
    private String ganer;
    private String yearofpub;
    private String namebooks;
    private String birthd;
    private String surname;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGaner() {
        return ganer;
    }

    public void setGaner(String ganer) {
        this.ganer = ganer;
    }

    public String getYearofpub() {
        return yearofpub;
    }

    public void setYearofpub(String yearofpub) {
        this.yearofpub = yearofpub;
    }

    public String getNameofbooks() {
        return namebooks;
    }

    public void setNameofbooks(String namebooks) {
        this.namebooks = namebooks;
    }

    public String getBirthd() {
        return birthd;
    }

    public void setBirthd(String birthd) {
        this.birthd = birthd;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
