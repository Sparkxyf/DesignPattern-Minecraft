package design.task.interpreter;

public class TaskDetail {

    private String[] weathers={"晴朗","多云"};
    private String[] days ={"星期一","星期二","星期三","星期四","星期五","星期六"};
    private TaskAbstractExpression weatherDay;
    public TaskDetail()
    {
        TaskAbstractExpression weather=new TaskTerminalExpression(weathers);
        TaskAbstractExpression day=new TaskTerminalExpression(days);
        weatherDay =new TaskNonTerminalExpression(weather,day);
    }
    public boolean free(String info)
    {
        boolean ok= weatherDay.interpret(info);
        if(ok){
            System.out.println("今天是"+info+"，请领取你的任务！");
            return true;
        }
        else{
            System.out.println("今天是"+info+"，您今天没有任务。");
            return false;
        }
    }

    public String getTaskDetail(String info)
    {
        boolean ok= weatherDay.interpret(info);
        if(ok){
            return "今天是"+info+"，请领取你的任务！";
        }
        else{
            return "今天是"+info+"，您今天没有任务。";
        }
    }



}
