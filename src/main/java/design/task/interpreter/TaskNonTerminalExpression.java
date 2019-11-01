package design.task.interpreter;

import com.sun.xml.internal.ws.api.FeatureConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class TaskNonTerminalExpression  implements  TaskAbstractExpression{

    @Getter @Setter
    private TaskAbstractExpression city=null;

    @Getter @Setter
    private TaskAbstractExpression person=null;

    public boolean interpret(String info)
    {
        String s[]=info.split("的");
        return city.interpret(s[0])&&person.interpret(s[1]);
    }
}
