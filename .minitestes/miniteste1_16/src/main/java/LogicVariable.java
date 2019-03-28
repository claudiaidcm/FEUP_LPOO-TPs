public class LogicVariable {

    private String name;
    private boolean value = true;
    private LogicGate logicGate = null;

    public LogicVariable(String name, Boolean value) {
        this.name = name;
        this.value = value;
    }

    public LogicVariable(String name) {
        this.name = name;
    }

    public void setLogicGate(LogicGate logicGate)
    {
        this.logicGate = logicGate;
    }

    public LogicGate getCalculatedBy()
    {
        return this.logicGate;
    }

    public String getName() {
        return name;
    }

    public Boolean getValue() {

        if (logicGate != null)
            logicGate.updateValue();

        return value;
    }


    public String getFormula()
    {
        if(this.logicGate == null)
            return name;

        return logicGate.getFormula();
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // are the references equal
        if (o == null) return false; // is the other object null
        if (getClass() != o.getClass()) return false; // both objects the same class
        LogicVariable p = (LogicVariable) o; // cast the other object
        return p.getName() == name; // actual comparison
    }
}
