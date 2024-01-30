
import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        // Создание HashMap для хранения телефонной книги
        Map<String, List<String>> phoneBook = new HashMap<>();

        // Добавляем записи в телефонную книгу
        addContact(phoneBook, "Иванов", "123456789");
        addContact(phoneBook, "Петров", "987654321");
        addContact(phoneBook, "Сидоров", "456789123");
        addContact(phoneBook, "Иванов", "657387393");
        addContact(phoneBook, "Петров", "745845458");

        // Выводим телефонную книгу, отсортированную по убыванию числа телефонов
        printPhoneBook(phoneBook);
    }

    // Метод для добавления контакта в телефонную книгу
    public static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        // Проверка, есть ли уже контакт с таким именем в телефонной книге
        if (phoneBook.containsKey(name)) {
            // Если контакт уже существует, добавляем новый номер телефона в список
            List<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            // Если контакта с таким именем еще нет, создаем новую запись в телефонной книге
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    // Метод для вывода телефонной книги, отсортированной по убыванию числа телефонов
    public static void printPhoneBook(Map<String, List<String>> phoneBook) {
        // Создание списка записей телефонной книги
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        // Сортировка списка записей по убыванию числа телефонов
        Collections.sort(entries, new Comparator<Map.Entry<String, List<String>>>() {
            @Override
            public int compare(Map.Entry<String, List<String>> entry1, Map.Entry<String, List<String>> entry2) {
                return entry2.getValue().size() - entry1.getValue().size();
            }
        });

        // Выводим отсортированной телефонной книги
        for (Map.Entry<String, List<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
