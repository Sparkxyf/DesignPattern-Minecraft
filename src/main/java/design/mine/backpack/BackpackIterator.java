package design.mine.backpack;

import design.mine.tool.MiningTool;
import java.util.HashMap;

interface BackpackIterator {
     boolean hasNext();
     MiningTool next();
     HashMap<String, Integer> aggregation();
}
