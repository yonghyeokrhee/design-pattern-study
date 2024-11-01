public class Beverage {

    double milkCost = 0.10;
    double soyCost = 0.15;
    double mochaCost = 0.20;
    double whipCost = 0.10;


    public double cost(){

            double condimentCost = 0.0;
            if (hasMilk()) {
                condimentCost += milkCost;
                              
            }
            if (hasSoy()){
                condimentCost += soyCost;
            }
            if (hasMocha()){
                condimentCost += mochaCost;
            }
            if (hasWhip()){
                condimentCost += whipCost;
            }

            return condimentCost;
        }

    public boolean hasMilk(){return false;};
    public boolean hasMocha(){return false;};
    public boolean hasSoy(){return false;};
    public boolean hasWhip(){return false;};

    }   