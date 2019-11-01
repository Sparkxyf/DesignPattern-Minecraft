package design.mine.backpack;

import java.io.IOException;
import java.util.Scanner;

public class BackpackMediatorImpl implements BackpackMediator {
    private void displaySmelter() throws IOException {
        System.out.println("熔炉室是制造采矿工具的地方，消耗一定量的矿石就能造出对应的工具。（按回车键返回）");
        while (true){
            if (System.in.read() == '\n')
                break;
        }
    }

    private void displayMine() throws IOException {
        System.out.println("矿区有铜矿山、铁矿山、铝矿山和钻石宝山，在不同的矿山只能用对应的工具才能采矿。（按回车键返回）");
        while (true){
            if (System.in.read() == '\n')
                break;
        }
    }

    @Override
    public void welcome() {
        try {
            while (true) {
                System.out.println("欢迎来到矿区！需要看看吗？\n1-了解矿山  2-了解熔炉室  3-直接进入");
                Scanner scanner = new Scanner(System.in);
                int code = scanner.nextInt();
                if (code == 1)
                    displayMine();
                else if (code == 2)
                    displaySmelter();
                else
                    break;
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public int navigation(){
        System.out.println("来到了矿区，要干什么？\n1-去钻石宝山  2-去铁矿山  3--去铜矿山  4-去铝矿山  5--去熔炉室  6--查看背包  0--离开");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}


