package design.task.interpreter;

import design.task.Task;

import java.util.HashSet;
import java.util.Set;

public class TaskTerminalExpression implements TaskAbstractExpression{


    private Set<String> set= new HashSet<String>();
    public TaskTerminalExpression(String[] data)
    {
        for(int i=0;i<data.length;i++)set.add(data[i]);
    }
    public boolean interpret(String info)
    {
        if(set.contains(info))
        {
            return true;
        }
        return false;
    }
}
