import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            list.add(random.nextInt(100));
        }

        // сначала все числа умножить на 2
        // отсортировать те числа, которые меньше 50
        //отнять 10 и поделить на 4


        System.out.println(list);

        List<Integer> firstStep = new ArrayList<>();


        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            value *= 2;
            firstStep.add(value);
        }

        System.out.println(firstStep);


        List<Integer> secondStep = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= 50) {
                secondStep.add(firstStep.get(i));
            }
        }

        System.out.println(secondStep);

        System.out.println("------------------");

        List<Integer> thirdStep = new ArrayList<>();


        for (int i = 0; i < secondStep.size(); i++) {
            int value = secondStep.get(i);
            value -= 10;
            value /= 4;
            thirdStep.add(value);
        }

        System.out.println(thirdStep);



        System.out.println("-----------------");

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int value= list.get(i);
            value *= 2;
            if (value > 50) {
                value -= 10;
                value /= 4;
                answer.add(value);

            }
        }
        System.out.println(answer);

        System.out.println("----------------------------");

        List<Integer> result = list.stream()
                .map((x) -> x * 2)
                .filter((x) -> x >= 50)
                .map((x) -> (x - 10) / 4)
                .toList();


        System.out.println(result);

        // метод map -  изменить любым образом все элементы стрима
        // filter() -  фильтрует элементы, оставляет только те, которые совпадают с условием
        //distinct() -удаляет одинаковые
        //sorted() сортирует стрим
        //limit() -  оставляет только первые пять элементов
        //skip - пропустить все элементы
        // peek - сделать что-то с каждым элементом, при этом не изменяя их


        // терминальные
        // foreach() - произвести любые действия с элементами и завершить стрим
        // toList() - превращает стрим в лист
        //count - получить количество элементов в стриме
        //reduce - сжимает стрим до одного элемента
        //findFirst  находит первое значение из текущего стрима и отдает
        //findAny - отдает любой элемент
        // min max  найти наибольшее и наименьшее
        //anyMatch   возвращает true  если хотя бы один элемент совпадает по условию
        //allMatch   возвращает true  если все элементы совпадают  по условию
        // преобразовать в коллекцию


       List<String> answerList = list.stream()
               .map(x -> x.toString())
               .map(x -> x + "qwerty")
               .toList();

        System.out.println(answerList);


        List<Integer> result1 =  list.stream()
                .filter(x -> x % 2 == 0)
                .sorted()
                .distinct()
                .skip(5)
                .limit(5)
                .peek(x -> x = x + 1)
                .toList();

        System.out.println(result1);

        long x = list.stream()
                .filter(y -> y > 20)
                .count();
        System.out.println(x);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(2);

        Optional<Integer> sum = list.stream().reduce((a, b) -> a + b);



        Optional<Integer> optional = set.stream().reduce((a, b) -> a + b);
        int resultInt = optional.get();
        System.out.println(resultInt);

        Optional<Integer> optionalInteger = list.stream().findFirst();
        if (optionalInteger.isPresent()) {
            System.out.println(optionalInteger.get());
        }

        Optional<Integer> any = list.stream().findAny();   // обертка над обьектом, которая позволяет избежать null
        if (any.isPresent()) {                            //  метод isPresent  проверяет есть ли там какой-то обьект, или там null
            System.out.println(any.get());
        }


        Optional<Integer> min = list.stream().min(Comparator.naturalOrder());

        if (min.isPresent()) {
            System.out.println(min.get());
        }

       boolean anyMatch =  list.stream().anyMatch(integer -> integer > 5);
        System.out.println(anyMatch);

        boolean fullMatch = list.stream().allMatch(integer -> integer > 5);


//        Object[] array = list.stream().toArray();


      Set<Integer> collectSet =   list.stream().collect(Collectors.toSet());









    }
}
