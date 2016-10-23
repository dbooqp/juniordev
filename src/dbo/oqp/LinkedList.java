package dbo.oqp;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LinkedList implements Serializable {

    public Link first;

    public LinkedList() {
        first = null;
    }

    public ListIterator getIterator() {
        return new ListIterator(this);
    }

    public Link getFirst() {
        return first;
    }

    public Link setFirst(Link newLink) {
        first = newLink;
        newLink.prev = null;
        return newLink;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        Link current = first;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public void display(Link first) {
        Link current = first;
        while (current != null) {
            System.out.print("->" + current.Data);
            current = current.next;
        }
    }

    public void displayFrwrd(Link first) {
        Link current = first;
        System.out.println("\n//////СПИСОК В ПРЯМОМ НАПРАВЛЕНИИ//////");
        while (current != null) {
            System.out.print("->" + current.Data);
            current = current.next;
        }
    } // ПУНКТ № 1 ТЗ

    public void displayBckwrd(Link first) {
        Link current = first;
        Link next = null;
        Link previous = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        first = previous;
        System.out.println("\n//////СПИСОК В ОБРАТНОМ НАПРАВЛЕНИИ//////");
        display(first);

    } // Вывод через ревёрс списка. ПУНКТ № 2 ТЗ

    public void displayBckwrdRecursion(Link current) {
        if (current != null) {
            displayBckwrdRecursion(current.next);
            System.out.print("->" + current.Data);
        }
    } // Вывод с помощью рекурсии. ПУНКТ № 2 ТЗ

    public void displayBckwrdbyPrev(Link current) {
        while (current.next != null) {
            {
                current = current.next;
            }
        }
        while (current != null) {
            System.out.print("->" + current.Data);
            current = current.prev;
        }
    } // Вывод с помощью ссылки prev. ПУНКТ № 2 ТЗ

    public void swap(Link b, Link a) {
      //Отличный пример как не надо писать, однако...
        if (a == b) {
            return;
        }
        if ((a.next != b) && (b.next != a)) {
            Link p = b.prev;
            Link n = b.next;
            b.prev = a.prev;
            b.next = a.next;
            a.prev = p;
            a.next = n;
            if (a == first) {
                first = b;
                b.prev = null;
            } else {
                if (b == first) {
                    first = a;
                    a.prev = null;
                }
            }
            if (b.next != null) {
                b.next.prev = b;
            }
            if (b.prev != null) {
                b.prev.next = b;
            }
            if (a.next != null) {
                a.next.prev = a;
            }
            if (a.prev != null) {
                a.prev.next = a;
            }
        } else {
            if (b.next == a) {
                b.next = a.next;
                a.prev = b.prev;
                if (b == first) {
                    first = a;
                    a.prev = null;
                }
                if (b.next != null) {
                    b.next.prev = a;
                }
                if (a.prev != null) {
                    a.prev.next = a;
                }
                a.next = b;
                b.prev = a;
            } else {
                if (a.next == b) {
                    a.next = b.next;
                    b.prev = a.prev;
                    if (a == first) {
                        first = b;
                        b.prev = null;
                    }
                    if (a.next != null)
                        a.next.prev = a;
                    if (b.prev != null)
                        b.prev.next = b;
                    b.next = a;
                    a.prev = b;
                }
            }
        }
    }

    public void selectSort(LinkedList ourlist) {
        if (ourlist.isEmpty())
            System.out.println("//////СПИСОК ПУСТ//////");
        if (ourlist.size() == 1)
            System.out.println("//////СПИСОК УЖЕ ОТСОРТИРОВАНН//////");
        else {
            Link current;
            Link out = ourlist.getFirst();
            Link min;

            while (out.next != null) {
                min = out;
                current = out.next;

                while (current != null) {
                    if (((current.Data.getSecondname().compareTo
                            (min.Data.getSecondname()) < 0))) {
                        min = current;
                    }
                    if (current.next == null) {
                        break;
                    } else {
                        current = current.next;
                    }
                }
                swap(min, out);
                out = min.next;

            }
        }
    } // Сортировка выбором. ПУНКТ № 6 ТЗ

    public void inFilework(LinkedList theList) {
        Link current = first;
        File infile = new File("inlink.txt");
        if (infile.exists()) {
            infile.delete();
        }

        try {
            PrintWriter writer = new PrintWriter
                    (new BufferedWriter(new FileWriter(infile, true)));
            if (!infile.exists()) {
                infile.createNewFile();
            }
            while (current != null) {
                writer.print(current.Data);
                current = current.next;
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } // Ввод в txt через поток. ПУНКТ № 7 ТЗ

    public void WriteObject() {
        Link current = first;
        String DIRECTORY = "C:\\Users\\dk\\IdeaProjects\\juniordev\\serializ";

        try {
            final FileOutputStream fos = new FileOutputStream(DIRECTORY);
            final ObjectOutputStream oos = new ObjectOutputStream(fos);

            while (current.next != null) {
                oos.writeObject(current.Data);
                current = current.next;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(LinkedList.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LinkedList.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    } // Сериализация ПУНКТ. № 7 ТЗ

    public void ReadObject() {
        Link current = first;
        String FILENAME = "C:\\Users\\dk\\IdeaProjects\\juniordev\\serializ";

        try (FileInputStream fin = new FileInputStream(FILENAME)) {
            ObjectInputStream ois = new ObjectInputStream(fin);

            while (current.next != null){
            Person myPerson = (Person) ois.readObject();
            System.out.print(myPerson.toString());
                current=current.next;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(LinkedList.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(LinkedList.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    } // Десериализация ПУНКТ. № 8 ТЗ

}
