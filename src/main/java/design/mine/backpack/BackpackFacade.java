package design.mine.backpack;

import design.mine.tool.*;

interface BackpackFacade {
    void addTool(MiningTool t);
    void removeTool(int index);
    void addMineral(String name, int num);
    void removeMineral(String name, int num);
}
