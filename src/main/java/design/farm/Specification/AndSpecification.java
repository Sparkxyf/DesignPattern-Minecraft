package design.farm.Specification;

import design.farm.Farm;
import design.farm.FarmLand;

public class AndSpecification extends CompositeSpecification {
    //传递两个规格书进行and操作
    private ISpecification left;
    private ISpecification right;

    public AndSpecification(ISpecification _left,ISpecification _right){
        this.left = _left;
        this.right = _right;
    }
    //进行and运算
    @Override
    public boolean isSatisfiedBy(FarmLand item) {
        return left.isSatisfiedBy(item) && right.isSatisfiedBy(item);
    }
}
