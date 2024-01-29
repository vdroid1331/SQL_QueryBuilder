public class Main {
    public static void main(String[] args) {


        DB pgsql = new DB("PGSQL");

        System.out.println(pgsql.createQuery.create("users").addIntField("age").addVariableCharField("name", 20).build());
        System.out.println(pgsql.insertQuery.insert("users").insertFields("(name, age)").insertValues("('Vinayak', '22')").build());
        System.out.println(pgsql.selectQuery.select(new String[]{"user.name", "courses.title"})
                .from("user")
                .where("age > 10")
                .orderBy("name")
                .groupBy("user.name")
                .joinOn("courses", "id", "user_id").build());
        System.out.println(pgsql.selectQuery.select(new String[]{"user.name", "courses.title"})
                .from("user")
                .orderBy("name")
                .groupBy("user.name")
                .joinOn("courses", "id", "user_id").build());
        System.out.println(pgsql.selectQuery.select(new String[]{"user.name", "courses.title"})
                .from("user")
                .where("age < 10")
                .orderBy("name")
                .groupBy("user.name")
                .leftJoinOn("courses", "id", "user_id").build());

        System.out.println(pgsql.updateQuery.update("users").set("name='VINAYAK'").where("name='Vinayak'").build());
        System.out.println(pgsql.deleteQuery.delete("users").where("name='VINAYAK'").build());
        System.out.println(pgsql.dropQuery.dropTable().drop("users").build());



//        DB sqlite = new DB("sqlite");


    }
}