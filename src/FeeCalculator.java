import java.util.ArrayList;

public class FeeCalculator
{
    int numDaysWanted;
    int numRidesNeeded;

    ArrayList<String> feeDesc;
    ArrayList<Double> feePrice;
    ArrayList<Integer> numDaysValid;

    //Constructor
    FeeCalculator(int days, int rides)
    {
        feeDesc = new ArrayList<String>();
        feePrice = new ArrayList<Double>();
        numDaysValid = new ArrayList<Integer>();

        numDaysWanted = days;
        numRidesNeeded = rides;
    }

    //adding price To arrays
    public void addFeePrice(double price)
    {
        feePrice.add(price);
    }

    public void addFeeDesc(String desc)
    {
        feeDesc.add(desc);
    }

    public void addFeeDays(int daysValid)
    {
        numDaysValid.add(daysValid);
    }

    public double getPricePerRide(int index)
    {
        if (index >= feePrice.size())
        {
            System.out.println("fee index cannot be outside of array");
            throw new IllegalArgumentException();
        }
        int tempNumDays = numDaysWanted;
        double totalPrice = 0;
        while (tempNumDays > 0)
        {
            totalPrice += feePrice.get(index);
            tempNumDays -= numDaysValid.get(index);
        }

        return totalPrice / numRidesNeeded;
    }

    public String getMinPrice()
    {
        int minIndex = 0;

        for(int i = 0; i < feePrice.size(); i++)
        {
            if (feePrice.get(i) < feePrice.get(minIndex))
            {
                minIndex = i;
            }
        }
        String answerPart1 = "The minimum price per ride is " + feePrice.get(minIndex);
        String answerPart2 = ". The fee allowing this is:" + feeDesc.get(minIndex);

        return answerPart1 + answerPart2;
    }
}
