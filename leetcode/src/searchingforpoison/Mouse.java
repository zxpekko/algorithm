package searchingforpoison;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:42 2023/7/18
 */
public class Mouse {
    private int id;
    private boolean isDead;
    private List<MedicineBottle> DrugDelivery=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public List<MedicineBottle> getDrugDelivery() {
        return DrugDelivery;
    }

    public void setDrugDelivery(List<MedicineBottle> drugDelivery) {
        DrugDelivery = drugDelivery;
    }
}
