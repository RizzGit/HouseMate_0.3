package com.example.housemate_02;

public class Book {

    private int id;
    private String Name;
    private String Surname;
    private String EMail;
    private String dNascita;

    public Book(){}

    public Book(String Name, String Surname, String EMail, String dNascita) {
        super();
        this.Name = Name;
        this.Surname = Surname;
        this.EMail = EMail;
        this.dNascita = dNascita;
    }


    //getters & setters
    public int getId()	{
        return id;
    }
    public String getName()	{
        return Name;
    }
    public String getSurname()	{
        return Surname;
    }

    public void setId(int i)	{
        id = i;
    }
    public void setName(String s)	{
        Name = s;
    }
    public void setSurname(String s)	{
        Surname = s;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", Name=" + Name + ", Surname=" + Surname
                + "]";
    }
}
