package dbo.oqp;

import java.io.Serializable;

public class Person implements Serializable {
    public String Secondname;
    public String Birthday;
    public int Height;
    public int index;

    Person(int size, String name, String age, int sm) {
        Secondname = name;
        Birthday = age;
        Height = sm;
        index = size;
    }

    public String toString() {
        String person = "Индекс №"+ getIndex() + "\n";
        person += "Фамилия: " + getSecondname() + "\n";
        person += "Дата рождения: " + getBirthday() + "\n";
        person += "Рост: " + getHeight() + "\n"+"\n";
        return person;
    }

    public String getSecondname()
    {
        return Secondname;
    }

    public String getBirthday() {return Birthday;}

    public int getHeight() {return Height; }

    public int getIndex() {return index; }

    public int setIndex(int key) {return index=key;}
}