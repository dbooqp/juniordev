package dbo.oqp;
/*

~ Отсутствует интерфейс взаимодействия с пользователем через консоль.
~ Каждое изменение списка должно сопровождаться переиндексацией (iter.initializeIndex();).

*/
class Main {
    public static void main(String[] args) {
        LinkedList theList = new LinkedList();
        ListIterator iter = theList.getIterator();

                // -> БЛОК СОЗДАНИЯ ОБЪЕКТОВ ТИПА PERSON
        Person pr1 = new Person(0, "Борисов", "1987", 180);
        Person pr2 = new Person(0, "Иванов", "1995", 185);
        Person pr3 = new Person(0, "Захаров", "1983", 182);
        Person pr4 = new Person(0, "Сидоров", "1980", 191);
        Person pr5 = new Person(0, "Петров", "1996", 174);
        Person pr6 = new Person(0, "Гаврилин", "1979", 169);
        Person pr7 = new Person(0, "Иванов", "1983", 203);
        Person pr8 = new Person(0, "Богатова", "1985", 188);
        Person pr9 = new Person(0, "Гаврилин", "1996", 167);


                // -> БЛОК ВСТАВКИ ОБЕКТОВ ТИПА PERSON (СОЗДАНИЕ *ПОЛУДВУСВЯЗАННОГО* СПИСКА)
        iter.insert(pr1);
        iter.insert(pr2);
        iter.insert(pr3);
        iter.insert(pr4);
        iter.insert(pr5);
        iter.insert(pr6);
        iter.insert(pr7);
        iter.insert(pr8);
        iter.insert(pr9);
        iter.initializeIndex();

                // -> БЛОК ВЫВОДА НА ЭКРАН ВСЕХ ЭЛЕМЕНТОВ СПИСКА
        theList.displayFrwrd(theList.getFirst()); // - В ПРЯМОМ НАПРАВЛЕНИЕ
        //theList.displayBckwrd(theList.getFirst()); // - В ОБРАТНОМ НАПРАВЛЕНИИ (РЕВЁРС)
        //theList.displayBckwrdRecursion(theList.getFirst()); // - В ОБРАТНОМ НАПРАВЛЕНИИ(РЕКУРССИЯ)
        //theList.displayBckwrdbyPrev(theList.getFirst()); // - В ОББРАТНОМ НАПРАВЛЕНИИ (ССЫЛКА PREV)

                // -> ДОБАВЛЕНИЕ ЭЛЕМЕНТА В СПИСОК ПО ИНДЕКСУ
        //iter.insertIndex(pr6,1);
        //iter.initializeIndex();

                // -> УДАЛЕНИЕ ЭЛЕМЕНТА ИЗ СПИСКА ПО ИНДЕКСУ
        //iter.delIndex(2);
        //iter.initializeIndex();

                // -> УДАЛЕНИЕ ЭЛЕМЕНТА ИЗ СПИСКА С ЗАДАННОЙ ФАМИЛИЕЙ
        //iter.delName("Гаврилин");
        //iter.initializeIndex();

                // -> СОРТИРОВКА ЭЛЕМЕНТОВ СПИСКА ПО ФАМАЛИИ
        //theList.selectSort(theList);
        //iter.initializeIndex();

                //-> СОХРАНЕНИЕ СПИСКА В ФАЙЛ TXT ЧЕРЕЗ ПОТОК
        //theList.inFilework(theList);

                // -> СОХРАНЕНИЕ СПИСКА В ФАЙЛ ПОСРЕДСТВОМ СЕРИАЛИЗАЦИИ
        //theList.WriteObject();

                // -> ЗАГРУЗКА СПИСКА ИЗ ФАЙЛ ПОСРЕДСТВОМ СЕРИАЛИЗАЦИИ
        //theList.ReadObject();
    }
}
