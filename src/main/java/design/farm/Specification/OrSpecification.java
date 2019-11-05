package design.farm.Specification;

import design.farm.FarmLand;

public class OrSpecification extends CompositeSpecification {
    //左右两个规格书
    private ISpecification left;
    private ISpecification right;

    public OrSpecification(ISpecification _left,ISpecification _right){
        this.left = _left;
        this.right = _right;
    }
    //or运算
    @Override
    public boolean isSatisfiedBy(FarmLand item) {
        return left.isSatisfiedBy(item) || right.isSatisfiedBy(item);
    }
}
