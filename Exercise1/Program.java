package Exercise1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* 
 * Задание 1.
 * 1. Реализуйте структуру телефонной книги с помощью HashMap
   Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.
 *
*/

public class Program {
    public static void main(String[] args) {
        Map<String, Set<String>> phoneBook = new HashMap<>();
        
        addNumber(phoneBook, "Иванов", "123-4567");
        addNumber(phoneBook, "Петров", "234-5678");
        addNumber(phoneBook, "Иванов", "345-6789");
        addNumber(phoneBook, "Сидоров", "456-78910");
        addNumber(phoneBook, "Петров", "567-891011");

        Set<Map.Entry<String, Set<String>>> entries = phoneBook.entrySet();
        List<Map.Entry<String, Set<String>>> list = new ArrayList<>(entries);
        Collections.sort(list, (o1, o2) -> o2.getValue().size() - o1.getValue().size());

        for (Map.Entry<String, Set<String>> entry : list) {
            System.out.print(entry.getKey() + ": ");
            for (String number : entry.getValue()) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    private static void addNumber(Map<String, Set<String>> phoneBook, String name, String number) {
        Set<String> numbers = phoneBook.get(name);
        if (numbers == null) {
            numbers = new HashSet<>();
            phoneBook.put(name, numbers);
        }
        numbers.add(number);
    }   
}
