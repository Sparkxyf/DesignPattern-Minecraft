package design.farm.Specification;

import design.farm.FarmLand;

public interface ISpecification
{
    boolean isSatisfiedBy(FarmLand candidate);
    ISpecification and(ISpecification spec);
    ISpecification or(ISpecification spec);
    ISpecification not();
}
