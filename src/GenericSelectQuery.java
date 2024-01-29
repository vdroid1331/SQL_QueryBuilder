import java.util.Objects;


public class GenericSelectQuery implements SQLSelectQuery{
    protected String selectClause;
    protected String fromClause;
    protected String whereCondition;
    protected String orderByClause;
    protected String groupByClause;
    protected String joinedTable;
    protected String tableOneField;
    protected String tableTwoField;
    protected boolean isLeftJoin;


    public GenericSelectQuery() {
        this.selectClause = "";
        this.fromClause = "";
        this.whereCondition = "";
        this.orderByClause = "";
        this.groupByClause = "";
        this.joinedTable = "";
        this.tableOneField = "";
        this.tableTwoField  = "";
        this.isLeftJoin = false;
    }
    @Override
    public SQLSelectQuery select(String fields) {
        this.selectClause = fields;
        return this;
    }

    @Override
    public SQLSelectQuery select(String[] fields) {
        this.selectClause = String.join(", ", fields);
        return this;
    }

    @Override
    public SQLSelectQuery from(String fields) {
        this.fromClause = fields;
        return this;
    }

    @Override
    public SQLSelectQuery where(String condition) {
        this.whereCondition = condition;
        return this;
    }

    @Override
    public SQLSelectQuery orderBy(String condition) {
        if (!Objects.equals(this.orderByClause, "")) {
            this.orderByClause += ", " + condition;
        } else {
            this.orderByClause = condition;
        }
        return this;
    }

    @Override
    public SQLSelectQuery orderBy(String condition, boolean orderByAscending) {
        if (!Objects.equals(this.orderByClause, "")) {
            this.orderByClause += ", " + condition + " " + ((orderByAscending) ? "ASC" : "DESC");
        } else {
            this.orderByClause = condition;
        }
        return this;
    }

    @Override
    public SQLSelectQuery orderBy(String condition, String orderByMethod) {
        if (!Objects.equals(this.orderByClause, "")) {
            this.orderByClause += ", " + condition +  ((Objects.equals(orderByMethod, "ASC") || Objects.equals(orderByMethod, "DESC")) ? " " + orderByMethod : "");
        } else {
            this.orderByClause = condition;
        }
        return this;
    }

    @Override
    public SQLSelectQuery groupBy(String fields) {
        this.groupByClause = fields;
        return this;
    }

    @Override
    public SQLSelectQuery groupBy(String[] fields) {
        this.groupByClause = String.join(", ", fields);
        return this;
    }

    @Override
    public SQLSelectQuery fromAndJoin(String joinTableOne, String joinTableTwo, String firstTableField, String secondTableField) {
        this.fromClause = joinTableOne;
        this.joinOn(joinTableTwo, firstTableField, secondTableField);
        return this;
    }

    @Override
    public SQLSelectQuery joinOn(String joinTableTwo, String firstTableField, String secondTableField) {
        this.joinedTable = joinTableTwo;
        this.tableOneField = firstTableField;
        this.tableTwoField = secondTableField;
        return this;
    }

    @Override
    public SQLSelectQuery fromAndLeftJoin(String joinTableOne, String joinTableTwo, String firstTableField, String secondTableField) {
        this.isLeftJoin = true;
        this.fromAndJoin(joinTableOne, joinTableTwo, firstTableField, secondTableField);
        return this;
    }

    @Override
    public SQLSelectQuery leftJoinOn(String joinTableTwo, String firstTableField, String secondTableField) {
        this.isLeftJoin = true;
        this.joinOn(joinTableTwo, firstTableField, secondTableField);
        return this;
    }

    @Override
    public String build() {
        String query = "SELECT ";
        if (Objects.equals(this.selectClause, "")) {
            query += "*";
        } else {
            query += this.selectClause;
        }
        if (Objects.equals(this.fromClause, "")) {
            return "ERROR: NO TABLE GIVEN TO BE READ";
        }
        query += " FROM " + this.fromClause;
        if (!Objects.equals(this.joinedTable, "") && ((!Objects.equals(this.tableOneField, "")) && (!Objects.equals(this.tableTwoField, "")))) {
            String joinType = this.isLeftJoin ? "LEFT" : "INNER";
            query += " " + joinType +  " JOIN " + this.joinedTable + " ON " + this.fromClause + "." + this.tableOneField + " = " + this.joinedTable + "." + this.tableTwoField;
        } else {
            return "ERROR: INVALID JOIN";
        }
        if (!Objects.equals(this.whereCondition, "")) {
            query += " WHERE " + this.whereCondition;
        }

        if (!Objects.equals(this.groupByClause, "")) {
            String [] selectedParams = this.selectClause.split(", ");
            String [] groupByParams = this.groupByClause.split(", ");
            if (!ArrayComparison.allElementsPresent(selectedParams, groupByParams)) {
                return "ERROR: GROUP BY ARGUMENT NOT SELECTED";
            }
            query += " GROUP BY " + this.groupByClause;
        }
        if (!Objects.equals(this.orderByClause, "")) {
            query += " ORDER BY " + this.orderByClause;
        }
        query += ";";
        this.clearQuery();
        return query;
    }

    @Override
    public void clearQuery() {
        this.selectClause = "";
        this.fromClause = "";
        this.whereCondition = "";
        this.orderByClause = "";
        this.groupByClause = "";
        this.joinedTable = "";
        this.tableOneField = "";
        this.tableTwoField  = "";
    }

}
