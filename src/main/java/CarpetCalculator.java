import java.text.NumberFormat;
import java.util.ArrayList;

public class CarpetCalculator implements Calculatable {
    private float pricePerFoot;
    private float initialCost;
    private float discount = 0F;
    private final int HUNDRED_PERCENT = 100;
    private ArrayList<Room> roomList = new ArrayList<>();
    private NumberFormat currency = NumberFormat.getCurrencyInstance();
    public CarpetCalculator(float pricePerFoot) {
        this.pricePerFoot = pricePerFoot;
    }
    public CarpetCalculator(float pricePerFoot, float initialCost) {
        this.pricePerFoot = pricePerFoot;
        this.initialCost = initialCost;
    }
    @Override
    public void addRoom(Room room) {
        roomList.add(room);
    }
    @Override
    public String getTotalCost() {
        Float sum = initialCost;
        for(Room room : roomList){
            sum += (room.getLength()* room.getWidth())*pricePerFoot;
        }
        if(discount != 0){
            sum -= discount*sum;
        }
        return currency.format(sum);
    }
    @Override
    public void addPercentDiscount(float percentDiscount) {
        discount = (percentDiscount/ HUNDRED_PERCENT);
    }
}
