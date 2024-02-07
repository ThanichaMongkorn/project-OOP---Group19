package Plan;



public class ClassPlan {
    private String action;

    public ClassPlan(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "action='" + action + '\'' +
                '}';
    }
}