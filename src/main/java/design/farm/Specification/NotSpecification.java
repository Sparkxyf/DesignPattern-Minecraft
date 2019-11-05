package design.farm.Specification;

import design.farm.FarmLand;

public class NotSpecification extends CompositeSpecification{
    //传递一个规格书
    private ISpecification spec;

    public NotSpecification(ISpecification _spec){
        this.spec = _spec;
    }
    //not操作
    @Override
    public boolean isSatisfiedBy(FarmLand item) {
        return !spec.isSatisfiedBy(item);
    }
}
