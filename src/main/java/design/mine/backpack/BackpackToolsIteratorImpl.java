package design.mine.backpack;

import design.mine.tool.*;

import java.util.HashMap;

public class BackpackToolsIteratorImpl implements BackpackIterator {
    private MiningToolsCompositeImpl list;
    private int length;
    private int curPos;

    public BackpackToolsIteratorImpl(MiningToolsCompositeImpl toolsList){
        list = toolsList;
        length = list.getMiningToolsList().size();
        curPos = 0;
    }

    @Override
    public boolean hasNext() {
        if (curPos < length - 1)
            return true;
        else {
            curPos = 0;
            return false;
        }
    }

    @Override
    public MiningTool next() {
        if (curPos >= list.getMiningToolsList().size())
            return null;
        curPos++;
        return list.getMiningToolsList().get(curPos);
    }

    @Override
    public HashMap<String, Integer> aggregation() {
        curPos = 0;
        int length1 = 0, length2 = 0, length3 = 0, length4 = 0;
        HashMap<String, Integer> toolCount = new HashMap<>();
        if (list.getMiningToolsList().size() != 0) {
            MiningTool cur = list.getMiningToolsList().get(curPos);
            while (true) {
                switch (cur.getName()) {
                    case "钻石镐":
                        length1++;
                        break;
                    case "铁镐":
                        length2++;
                        break;
                    case "铜镐":
                        length3++;
                        break;
                    case "铝镐":
                        length4++;
                        break;
                    default:
                        break;
                }
                if (!hasNext())
                    break;
                else
                    cur = next();
            }
        }
        toolCount.put("钻石镐", length1);
        toolCount.put("铁镐", length2);
        toolCount.put("铜镐", length3);
        toolCount.put("铝镐", length4);

        System.out.println("信息整合完毕。");
        return toolCount;
    }
}
