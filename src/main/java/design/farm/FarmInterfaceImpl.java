package design.farm;


import design.farm.CompositeEntity.PetCat;
import design.farm.CompositeEntity.PetClient;
import design.farm.Specification.HasMature;
import design.farm.Specification.HasProductThan;
import design.farm.Specification.ISpecification;
import design.farm.SubcribePublish.MessagePublisher;
import design.farm.SubcribePublish.MessageSubscriber;
import design.farm.SubcribePublish.NewsSubscriber;

import java.util.ArrayList;
import java.util.Scanner;

public class FarmInterfaceImpl implements FarmInterface {

    private ArrayList<FarmLand> farmLandList = new ArrayList<>();
    private PetClient petClient = new PetClient();
    private NewsSubscriber subscriber = new NewsSubscriber();
    @Override
    public void exec() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("*           1. 查看所有农场           *");
        System.out.println("*            2. 新建农场              *");
        System.out.println("*            3. 选择农场              *");
        System.out.println("*           4. 与流浪猫狗玩耍         *");
        System.out.println("*         5. 无聊地在瓜棚看报纸       *");
        System.out.println("*              6. 退出                *");
        System.out.println("======================================");
        System.out.println("请选择：");

        while(scanner.hasNext()) {
            switch (scanner.next()) {
                case "1":
                    System.out.println("======================================");
                    if(farmLandList.size()==0){
                        System.out.println("*         你的土地上没有农场          *");
                    }
                    else{
                        for(int i = 0; i< farmLandList.size(); ++i) {
                            System.out.println("*          "+
                                    (i + 1) +
                                            ":" +
                                            farmLandList.get(i).stringify()+"          *");
                        }
                    }

                    System.out.println("======================================");
                    System.out.println("*          输入序号查看农场           *");
                    System.out.println("*              输入0退出              *");
                    System.out.println("======================================");
                    System.out.println("请选择：");

                    while(scanner.hasNext()) {
                        String next = scanner.next();
                        try {
                            int cmd = Integer.parseInt(next);
                            if(cmd > farmLandList.size() || cmd < 0) {
                                throw new NumberFormatException();
                            }
                            if(cmd != 0){
                                farmLandList.get(cmd-1).exec();
                            }
                            break;
                        }
                        catch (NumberFormatException e) {
                            System.out.println("输入有误，请重试。");
                        }
                    }
                    break;
                case "2":

                    System.out.println("======================================");
                    System.out.println("*            1. 创建农场             *");
                    System.out.println("*            2. 创建鸡场              *");
                    System.out.println("*            3. 创建牛场              *");
                    System.out.println("*              4. 退出                *");
                    System.out.println("======================================");
                    System.out.println("请选择：");
                    if(scanner.hasNext()) {
                        FarmLand newFarmland;
                        switch (scanner.next()) {
                            case "1":
                                newFarmland = FarmlandAbstractFactory.getFactory(Field.class).createFarmland();
                                newFarmland.farms = this;
                                farmLandList.add(newFarmland);
                                System.out.println("添加成功");
                                break;
                            case "2":
                                newFarmland = FarmlandAbstractFactory.getFactory(Farm.class).createFarmland();
                                newFarmland.farms = this;
                                farmLandList.add(newFarmland);
                                Farm farm = (Farm)newFarmland;
                                farm.setBuyer("chicken");
                                System.out.println("添加成功");
                                break;
                            case "3":
                                newFarmland = FarmlandAbstractFactory.getFactory(Farm.class).createFarmland();
                                newFarmland.farms = this;
                                farmLandList.add(newFarmland);
                                Farm farm1 = (Farm)newFarmland;
                                farm1.setBuyer("cow");
                                System.out.println("添加成功");
                                break;
                            case "4":
                                break;
                            default:
                                System.out.println("输入有误");
                                continue;
                        }

                    }
                    break;
                case "3":
                    System.out.println("======================================");
                    System.out.println("*   请选择你想查看的农场包括的产品    *");
                    System.out.println("*              1. 成熟                *");
                    System.out.println("*              2. 未成熟              *");
                    System.out.println("*              3. 全部                *");
                    System.out.println("======================================");
                    if(scanner.hasNext()) {
                        String mature = scanner.next();
                        HasMature hasMature = new HasMature();
                        boolean isprinted = false;
                        System.out.println("======================================");
                        System.out.println("*     请输入您对农场产品数量的要求    *");
                        System.out.println("======================================");
                        if(scanner.hasNext()) {
                            Integer number = scanner.nextInt();
                            HasProductThan numberThan = new HasProductThan(number);
                            if(number<0){
                                System.out.println("输入有误");
                            }
                            else{
                                switch (mature) {
                                    case "1":
                                        ISpecification spec1 = numberThan.and(hasMature);
                                        System.out.println("======================================");

                                        for (FarmLand farmLand : farmLandList) {
                                            if (spec1.isSatisfiedBy(farmLand)) {
                                                System.out.println("*          "+
                                                        (farmLandList.indexOf(farmLand) + 1) +
                                                        ":" +
                                                        farmLand.stringify()+"          *");
                                                isprinted = true;
                                            }

                                        }
                                        if (!isprinted) {
                                            System.out.println("*    你的土地上没有符合要求的农场     *");
                                        }
                                        System.out.println("======================================");
                                        break;
                                    case "2":
                                        System.out.println("======================================");
                                        ISpecification spec2 = numberThan.and(hasMature.not());
                                        for (FarmLand farmLand : farmLandList) {
                                            if (spec2.isSatisfiedBy(farmLand)) {
                                                isprinted = true;
                                                System.out.println("*          "+
                                                        (farmLandList.indexOf(farmLand) + 1) +
                                                        ":" +
                                                        farmLand.stringify()+"          *");
                                            }
                                        }
                                        if (!isprinted) {
                                            System.out.println("*    你的土地上没有符合要求的农场     *");
                                        }
                                        System.out.println("======================================");
                                        break;
                                    case "3":
                                        System.out.println("======================================");
                                        ISpecification spec3 = numberThan.and(hasMature.or(hasMature.not()));
                                        for (FarmLand farmLand : farmLandList) {
                                            if (spec3.isSatisfiedBy(farmLand)) {
                                                isprinted = true;
                                                System.out.println("*          "+
                                                        (farmLandList.indexOf(farmLand) + 1) +
                                                        ":" +
                                                        farmLand.stringify()+"          *");
                                            }

                                        }
                                        if (!isprinted) {
                                            System.out.println("*    你的土地上没有符合要求的农场     *");
                                        }
                                        System.out.println("======================================");
                                        break;
                                    default:
                                        System.out.println("输入有误");
                                }
                            }

                        }
                    }
                    break;
                case "4":
                    System.out.println("你发现有一猫一狗总是在你的农场附近游荡，你决定！");
                    System.out.println("======================================");
                    System.out.println("*        1. 给它们取名字吧            *");
                    System.out.println("*        2. 远远地呼唤它们吧          *");
                    System.out.println("======================================");
                    if(scanner.hasNext()) {
                        switch (scanner.next()){
                            case "1":
                                String dogName="";
                                String catName="";
                                System.out.println("请输入狗狗的名字");
                                if(scanner.hasNext()) {
                                    dogName = scanner.next();
                                }
                                System.out.println("请输入猫猫的名字");
                                if(scanner.hasNext()) {
                                    catName = scanner.next();
                                }
                                petClient.setPetsName(dogName, catName);
                                break;
                            case "2":
                                petClient.printPetsName();
                        }

                    }
                    break;
                case "5":
                    System.out.println("======================================");
                    System.out.println("*         1. 查看今日推送             *");
                    System.out.println("*          2. 订阅新内容              *");
                    System.out.println("======================================");
                    if(scanner.hasNext()) {
                        switch (scanner.next()){
                            case "1":
                                System.out.println("======================================");
                                if(!subscriber.newsSub&&!subscriber.reportSub){
                                    System.out.println("很抱歉您未订阅任何内容");
                                }
                                else{
                                    MessagePublisher.instance().daily();
                                }
                                System.out.println("======================================");
                                break;
                            case "2":
                                System.out.println("======================================");
                                System.out.println("*          1. 每日快报                *");
                                System.out.println("*          2. 熊熊天气                *");
                                System.out.println("======================================");
                                if(scanner.hasNext()) {
                                    switch (scanner.next()) {
                                        case "1":
                                            if (subscriber.newsSub) {
                                                System.out.println("您已订阅了每日快报");
                                            } else {
                                                MessagePublisher.instance().register("新闻", subscriber);
                                                subscriber.newsSub = true;
                                                System.out.println("成功订阅了每日快报");
                                            }
                                            break;
                                        case "2":
                                            if (subscriber.reportSub) {
                                                System.out.println("您已订阅了熊熊天气");
                                            } else {
                                                MessagePublisher.instance().register("天气", subscriber);
                                                subscriber.reportSub = true;
                                                System.out.println("成功订阅了熊熊天气");
                                            }
                                            break;
                                        default:
                                            System.out.println("输入有误，请重试。");
                                    }
                                }
                                break;
                            default:
                                System.out.println("输入有误，请重试。");
                        }
                    }
                    break;
                case "6":
                    return;
                default:
                    System.out.println("输入有误，请重试。");
            }
            System.out.println("======================================");
            System.out.println("*           1. 查看所有农场           *");
            System.out.println("*            2. 新建农场              *");
            System.out.println("*            3. 选择农场              *");
            System.out.println("*           4. 与流浪猫狗玩耍         *");
            System.out.println("*         5. 无聊地在瓜棚看报纸       *");
            System.out.println("*              6. 退出                *");
            System.out.println("======================================");
            System.out.println("请选择：");
        }
    }
}
