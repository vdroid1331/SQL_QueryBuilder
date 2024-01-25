public class Main {
    public static void main(String[] args) {

        GenericSelectQuery SelectQuery = (GenericSelectQuery) new GenericSelectQuery().select("name").from("user").where("age > 10").orderBy("name").groupBy("name");
        System.out.println(SelectQuery.build());

    }
}