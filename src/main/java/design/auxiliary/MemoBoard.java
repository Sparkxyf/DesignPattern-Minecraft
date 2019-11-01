package design.auxiliary;
import design.home.message.*;

import java.util.Scanner;

public class MemoBoard {
    Originator originator = new Originator();
    Caretaker caretaker = new Caretaker();
    public void operation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("======================================");
        System.out.println("*          1. 查看最新留言            *");
        System.out.println("*           2. 查看留言版             *");
        System.out.println("*             3. 写留言               *");
        System.out.println("*              4. 退出                *");
        System.out.println("======================================");

        while(scanner.hasNext()){
            switch(scanner.next()){
                case "1":
                    if(originator.getRecord()==null){
                       System.out.println("留言版为空！");
                    }
                    else{
                        System.out.println(originator.getRecord());
                    }
                    break;
                case "2":
                    if(caretaker.count()==0){
                        System.out.println("留言版为空！");
                        break;
                    }
                    System.out.println("=================留言版==================");
                    for(int i=0;i<caretaker.count();i++){
                        originator.restoreMemento(caretaker.get(i));
                        System.out.println(originator.getRecord());
                    }
                    System.out.println("=========================================");
                    break;

                case "3":
                    System.out.println("请输入留言：");
                    String temp=scanner.next();
                    System.out.println("是否要保存当前留言?(Y/N)");
                    if(scanner.next().equals("Y")){
                        originator.setRecord(temp);
                        caretaker.add(originator.createMemento());
                    }
                    break;
                case "4":
                    System.out.println("退出");
                    SweetHome sweetHome=new SweetHome();
                    sweetHome.main();
            }
            System.out.println("======================================");
            System.out.println("*          1. 查看最新留言            *");
            System.out.println("*           2. 查看留言版             *");
            System.out.println("*             3. 写留言               *");
            System.out.println("*              4. 退出                *");
            System.out.println("======================================");
        }
        scanner.close();

    }
}
