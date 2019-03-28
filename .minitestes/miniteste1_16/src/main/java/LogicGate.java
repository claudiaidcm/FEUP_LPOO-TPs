public abstract class LogicGate {
    protected LogicVariable output;
    protected LogicVariable[] inputs;


    public LogicVariable getOutput() {
        return output;
    }

    public LogicVariable[] getInputs() {
        return inputs;
    }

    abstract String getSymbol();

    abstract void updateValue();

    abstract String getFormula();
}
