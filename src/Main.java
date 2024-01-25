public class Main {
    public static void main(String[] args) {

//        GenericSelectQuery SelectQuery = (GenericSelectQuery) new GenericSelectQuery().select(new String[]{"user.name", "courses.title"}).from("user").where("age > 10").orderBy("name").groupBy(new String[]{"name", "age"}).joinOn("courses", "id", "user_id");
        GenericSelectQuery SelectQuery = (GenericSelectQuery) new GenericSelectQuery()
                .select(new String[]{"user.name", "courses.title"})
                .from("user")
                .where("age > 10")
                .orderBy("name")
                .groupBy("user.name")
                .joinOn("courses", "id", "user_id");

        System.out.println(SelectQuery.build());

        GenericUpdateQuery UpdateQuery = (GenericUpdateQuery) new GenericUpdateQuery().update("user").set("name = 'Rick'").where("age > 10");
        System.out.println(UpdateQuery.build());


    }
}