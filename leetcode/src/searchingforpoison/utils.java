package searchingforpoison;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:30 2023/7/18
 */
public class utils {
    public static boolean isDead(Mouse mouse,String StrPoisonNumber){
        int id=mouse.getId();
        List<MedicineBottle> drugDelivery = mouse.getDrugDelivery();
        char c = StrPoisonNumber.charAt(id);
        for(int i=0;i< drugDelivery.size();i++){
            MedicineBottle medicineBottle = drugDelivery.get(i);
            String BottleId = medicineBottle.getId();
            char c1 = BottleId.charAt(id);
            if(c1=='1'&&c=='1'){
                mouse.setDead(true);
                return true;
            }
        }
        mouse.setDead(false);
        return false;
    }
//    public static boolean isDead(Mouse mouse,String StrPoisonNumber,int methodNumber){//非上帝视角，单纯的让老鼠dead。
//        return false;
//    }
    public static Mouse[] Delivery(Mouse[] mice,MedicineBottle[] medicineBottles){
        for(int i=0;i< mice.length;i++){
            Mouse mouse = mice[i];
            int id=mouse.getId();
            List<MedicineBottle> drugDelivery = mouse.getDrugDelivery();
            for(int j=0;j< medicineBottles.length;j++){
                if(medicineBottles[j].getId().charAt(id)=='1'){
                    drugDelivery.add(medicineBottles[j]);
//                    System.out.println("添加");
                }
            }
//            System.out.println(drugDelivery.size());
        }
        return mice;
    }
    public static List<Integer> getPoisonNumber(Mouse[] delivery,String StrPoisonNumber){
        List<Integer> result=new ArrayList<>();
        for(int i=0;i< delivery.length;i++){
            Mouse mouse = delivery[i];
            boolean dead = isDead(mouse, StrPoisonNumber);
            if(dead==true){
                result.add(i);
            }
        }
        return result;
    }
}
