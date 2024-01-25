public class Main {
    public static void main(String[] args) {

//        GenericSelectQuery SelectQuery = (GenericSelectQuery) new GenericSelectQuery().select(new String[]{"user.name", "courses.title"}).from("user").where("age > 10").orderBy("name").groupBy(new String[]{"name", "age"}).joinOn("courses", "id", "user_id");
        GenericSelectQuery SelectQuery = (GenericSelectQuery) new GenericSelectQuery()
                .select(new String[]{"user.name", "courses.title"})
                .from("user")
                .where("age > 10")
                .orderBy("name")
                .groupBy("name, age")
                .joinOn("courses", "id", "user_id");

        System.out.println(SelectQuery.build());


    }
}