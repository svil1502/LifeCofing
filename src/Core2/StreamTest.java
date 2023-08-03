package Core2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) throws IOException {
        //Способы создания стрима

        //<<из коллекции

        Collection<String> collection = Arrays.asList("a1", "a2", "a3");
        Stream<String> streamFromCollection = collection.stream();
        //дальше можно отфильтровать
        //streamFromCollection.filter(x -> x!= "a1").forEach(System.out::println);
        //собрать в список
        // System.out.println(streamFromCollection.collect(Collectors.toList()));
        System.out.println(streamFromCollection.count());
        Collection<Integer> list = Arrays.asList(1, 2, 3);
        Stream<Integer> streamInt = list.stream();
        streamInt.map(x -> x * 2).sorted().forEach(System.out::println);

        //>>

        //<<из значений

        Stream <String> streamFromValues = Stream.of("1", "2", "3");

        //>>

        //<<из массива

        String[] array = {"a1", "a2", "a3"};
        Stream <String> streamFromArray = Arrays.stream(array);

        //>>

        //<<из файла
        System.out.println("============");
        Stream <String> streamFromFile = Files.lines(Paths.get("fileforstream"));
        streamFromFile.forEach(System.out::println);
        //>>

        //<<из строки
        System.out.println("============");
        IntStream streamFromString = "123".chars();
        streamFromString.forEach(System.out::println);
        //>>

        //<<Stream.builder
        System.out.println("============");
        Stream<Object> streamFromStringBuilder = Stream.builder().add("a1").add("a2").build();
        streamFromStringBuilder.forEach(System.out::println);
        //>>

        //<<создание параллельного стрима
        System.out.println("============//<<создание параллельного стрима");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 11);
        Stream<Integer> parstream = numbers.parallelStream();
        int sum = parstream
                .map(x -> x*x)
                .filter(x -> x > 10)
                .reduce(0, Integer::sum);
        System.out.println(sum);
        //>>

        //<<создание бесконечного стрима,  ограничение конечным числом
        System.out.println("============//<<создание бесконечного стрима");
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> naturals = Stream.iterate(1, n -> n + 1);
        randoms.limit(5).forEach(System.out::println);
        naturals.limit(5).collect(Collectors.toList());
         //>>

        //<< Результат работы стрима можно положить в коллекцию через метод collect()
        Stream<Integer> naturalscol = Stream.iterate(1, n -> n + 1);
        List<Integer> result = naturalscol.limit(5).collect(Collectors.toList());
        System.out.println(result);

        List<String> strings = Arrays.asList("a", "b", "c");

        List<String> resultabc = strings.stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(resultabc);
       /*
        Основные коллекторы, которые можно использовать в collect:

        toList(), toSet(), toMap()
        joining() - соединение в строку
        summarizingInt(), averagingInt() - статистика по числам
        Таким образом, collect позволяет гибко преобразовать stream в нужный тип коллекции.

        */
        // В Set
        Set<Integer> set = naturalscol.limit(5).collect(Collectors.toSet());

        // В Map
        List<String> names = Arrays.asList("Иван", "Мария", "Петр");

        Map<String, Integer> nameLengths =
                names.stream()
                           .collect(Collectors.toMap(
                                name -> name,
                                name -> name.length()));
        //>>

    }
}
