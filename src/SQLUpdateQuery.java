public interface SQLUpdateQuery {
    SQLUpdateQuery update(String field);
    SQLUpdateQuery set(String setString);
    SQLUpdateQuery where(String condition);
    String build();
}
