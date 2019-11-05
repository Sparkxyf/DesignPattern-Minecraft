package design.farm.Specification;

import design.farm.FarmLand;

public abstract class CompositeSpecification implements ISpecification{
    //是否满足条件有实现类实现
    public abstract boolean isSatisfiedBy(FarmLand item);
    //and操作
    public ISpecification and(ISpecification spec) {
        return new AndSpecification(this,spec);
    }
    //not操作
    public ISpecification not() {
        return new NotSpecification(this);
    }
    //or操作
    public ISpecification or(ISpecification spec) {
        return new OrSpecification(this,spec);
    }
}
