import java.util.Objects;

public class GenericUpdateQuery implements  SQLUpdateQuery {

    protected String updateClause;
    protected String setClause;
    protected String whereCondition;

    GenericUpdateQuery() {
        this.updateClause = "";
        this.setClause = "";
        this.whereCondition = "";
    }


    @Override
    public SQLUpdateQuery update(String field) {
        this.updateClause = field;
        return this;
    }

    @Override
    public SQLUpdateQuery set(String setString) {
        this.setClause = setString;
        return this;
    }

    @Override
    public SQLUpdateQuery where(String condition) {
        this.whereCondition = condition;
        return this;
    }

    @Override
    public String build() {
        if (Objects.equals(this.updateClause, "")) {
            return "ERROR: NO TABLE GIVEN TO BE UPDATED";
        }
        if (Objects.equals(this.setClause, "")) {
            return "ERROR: NOTHING PROVIDED TO BE UPDATED";
        }
        String query =  "UPDATE " + this.updateClause + " SET " + this.setClause + (!Objects.equals(this.whereCondition, "") ? " WHERE " + this.whereCondition : "") + ";";
        this.clearQuery();
        return query;
    }

    @Override
    public void clearQuery() {
        this.updateClause = "";
        this.setClause = "";
        this.whereCondition = "";
    }
}
