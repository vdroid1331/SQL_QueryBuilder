public interface SQLDropQuery {
    SQLDropQuery dropDatabase();
    SQLDropQuery dropTable();
    SQLDropQuery drop(String entity);
    String build();
}
