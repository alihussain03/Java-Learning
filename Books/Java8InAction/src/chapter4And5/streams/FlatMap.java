package chapter4And5.streams;


public class FlatMap {

  public static void main(String arg[]) {
   /* Stream a = Stream.of("first", "stream");
    Stream b = Stream.of("Second", "Stream = ");

    Stream c = Stream.of(a, b);
    System.out.println(c.toList().get(0));

    Stream d = Stream.of(a, b).flatMap(stream -> stream);
    d.toList().forEach(System.out::println);

    Path book = Paths.get("C:\\Ali Hussain\\Personal\\Learning\\JAVA8\\Java8Learning\\Book");
    try (Stream<String> lines = Files.lines(book);) {
      List<String> collect = lines
          // .flatMap(s -> s.split(" "))
          .flatMap(line -> Arrays.stream(line.split(" ")))
          .collect(Collectors.toList());
      collect.forEach(System.out::println);
      //  lines.toList().forEach(System.out::println);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }*/
  }

}
