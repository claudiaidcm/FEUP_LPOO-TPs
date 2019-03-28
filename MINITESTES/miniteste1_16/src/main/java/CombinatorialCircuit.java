import java.util.ArrayList;
import java.util.List;

public class CombinatorialCircuit {
    List<LogicVariable> variables = new ArrayList<LogicVariable>();

    public CombinatorialCircuit() {
    }

    public boolean addVariable(LogicVariable variable)
    {
        for(LogicVariable variable_tmp : variables)
        {
            if(variable_tmp.equals(variable))
                return false;
        }

        variables.add(variable);
        return true;
    }

    public LogicVariable getVariableByName(String name)
    {
        for(LogicVariable variable_tmp : variables)
        {
            if(variable_tmp.getName().equals(name))
                return variable_tmp;
        }

        return null;
    }

}
