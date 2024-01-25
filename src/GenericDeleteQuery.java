import java.util.Objects;

public class GenericDeleteQuery implements SQLDeleteQuery{

    protected String tableName;
    protected String condition;
    @Override
    public SQLDeleteQuery where(String condition) {
        this.condition = condition;
        return this;
    }

    @Override
    public SQLDeleteQuery delete(String tableName) {
        this.tableName = tableName;
        return this;
    }

    @Override
    public String build() {
        if (Objects.equals(this.tableName, "")) {
            return "ERROR: NO TABLE NAME PROVIDED TO DROP";
        } else {
            if (Objects.equals(this.condition, "")) {
                return "DELETE * FROM " + this.tableName + ";";
            } else {
                return "DELETE FROM " + this.tableName + " WHERE " + this.condition + ";";
            }
        }
    }
}
