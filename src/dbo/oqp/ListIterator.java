package dbo.oqp;

public class ListIterator  {
    private Link current = null;
    private Link previous = null;
    private LinkedList ourList;

    public ListIterator(LinkedList list) {
        ourList = list;
        reset();
    }

    public Link deleteCurrent(Link current) {
        if (current.prev == null) {
            ourList.setFirst(current.next);
            reset();
        } else {
            current.prev.next = current.next;
            if (atEnd())
                reset();
            else
                current = current.next;
        }
        return current;
    }

    public Link getNext() {
        return current.next;
    } // Элемент с заданным индексом смещается. ПУНКТ № 3 ТЗ

    public boolean atEnd() {
        return (current.next == null);
    }

    public boolean insertIndex(Person dd, int key) {
        current = ourList.getFirst();

        if (ourList.isEmpty()) {
            return false;
        }
        while (current.Data.getIndex() != key) {
            current = current.next;
            if (current == null)
                return false;
        }
        Link newLink = new Link(dd);
        if (current.prev == null) {
            newLink.next = current;
            ourList.setFirst(newLink);
            current.prev = newLink;
        } else {
            newLink.next = current;
            current.prev.next = newLink;
            newLink.prev = current.prev;
            current.prev = newLink;
        }
        return true;
    }

    public void reset() {
        current = ourList.getFirst();
        previous = null;
    }

    public void insert(Person dd) {
        Link newLink = new Link(dd);
        if (ourList.isEmpty()) {
            ourList.setFirst(newLink);
            current = newLink;
        }
        else {
            current.next = newLink;
            newLink.prev = current;
            current=current.next;
        }
    }

    public void delName(String key) {
        current = ourList.getFirst();
        while (current.Data.getSecondname() != key) {
            current = current.next;
        }
        deleteCurrent(current);
        reset();
    } // ПУНКТ № 5 ТЗ

    public void delIndex(int key) {
        current = ourList.getFirst();
        while (current.Data.getIndex() != key) {
            current = current.next;
        }
        deleteCurrent(current);
        reset();
    }  // ПУНКТ № 4 ТЗ

    public void initializeIndex() {
        current = ourList.getFirst();
        int id = -1;
        while (current != null) {
            ++id;
            current.Data.setIndex(id);
            current = current.next;
        }

    } // ПЕРЕИНДЕКСАЦИЯ (НАЧИНАЕТСЯ С 0)

}