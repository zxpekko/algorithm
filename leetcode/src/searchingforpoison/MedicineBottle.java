package searchingforpoison;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:43 2023/7/18
 */
public class MedicineBottle {
    private String id;
    private boolean isPoison;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPoison() {
        return isPoison;
    }

    public void setPoison(boolean poison) {
        isPoison = poison;
    }
}
