package design.mine.tool;

import java.util.ArrayList;

public class MiningToolsCompositeImpl implements MiningToolsComposite {
    private ArrayList<MiningTool> miningToolsList = new ArrayList<>();

    public ArrayList<MiningTool> getMiningToolsList(){
        return miningToolsList;
    }

    @Override
    public void add(MiningTool t) {
        System.out.println("工具列表增加了一个工具。");
        miningToolsList.add(t);
    }

    @Override
    public void remove(int index) {
        System.out.println("工具列表减少了一个工具。");
        miningToolsList.remove(index);
    }
}
