package design.specification;

import design.farm.*;
import design.farm.Specification.HasMature;
import design.farm.Specification.HasProductThan;
import design.farm.Specification.ISpecification;
import org.junit.Test;
import java.util.ArrayList;

public class SpecificationTest {
    @Test
    public void test(){
        ArrayList<Farm> farmLandList = new ArrayList<>();
        farmLandList.add(new Farm());
        farmLandList.add(new Farm());
        farmLandList.add(new Farm());
        farmLandList.get(0).animals.add(new Cow());
        farmLandList.get(0).animals.add(new Cow());
        farmLandList.get(0).animals.add(new Cow());
        farmLandList.get(2).animals.add(new Chicken());
        Clock.getInstance().updateState(4);
        HasProductThan hasProductThan = new HasProductThan(1);
        HasMature hasMature = new HasMature();
        ISpecification spec1 = hasProductThan.and(hasMature.not());
        ISpecification spec2 = hasProductThan.and(hasMature.or(hasMature.not()));
        ISpecification spec3 = hasProductThan.and(hasMature);
        ISpecification spec4 = hasProductThan.not();

        System.out.println("spec1 example:");
        for(Farm farm: farmLandList){
            if (spec1.isSatisfiedBy(farm)) {
                System.out.println("*          "+
                        (farmLandList.indexOf(farm) + 1) +
                        ":" +
                        farm.stringify()+"          *");
            }
        }

        System.out.println("spec2 example:");
        for(Farm farm: farmLandList){
            if (spec2.isSatisfiedBy(farm)) {
                System.out.println("*          "+
                        (farmLandList.indexOf(farm) + 1) +
                        ":" +
                        farm.stringify()+"          *");
            }
        }

        System.out.println("spec3 example:");
        for(Farm farm: farmLandList){
            if (spec3.isSatisfiedBy(farm)) {
                System.out.println("*          "+
                        (farmLandList.indexOf(farm) + 1) +
                        ":" +
                        farm.stringify()+"          *");
            }
        }
        System.out.println("spec4 example:");
        for(Farm farm: farmLandList){
            if (spec4.isSatisfiedBy(farm)) {
                System.out.println("*          "+
                        (farmLandList.indexOf(farm) + 1) +
                        ":" +
                        farm.stringify()+"          *");
            }
        }
    }

}


