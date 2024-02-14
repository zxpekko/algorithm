package searchingforpoison;

import org.junit.Test;

import java.util.List;
import java.util.Random;

/**
 * @Author:zxp
 * @Description:Searching for poison.
 * @Date:12:43 2023/7/18
 */
public class SearchingForPoison {
    public static void main(String[] args) {
        Mouse[] mice=new Mouse[7];
        for(int i=0;i<7;i++){
            Mouse mouse=new Mouse();
            mouse.setId(i);
            mouse.setDead(false);
            mice[i]=mouse;
        }//生成七只老鼠对象，用于样本毒性测试
        Random random = new Random();
        int PoisonNumber=random.nextInt(100);//随机生成有毒药瓶的编号
//        System.out.println("生成的毒药瓶的编号；"+PoisonNumber);
        String StrPoisonNumber=Integer.toBinaryString(PoisonNumber);
        while (StrPoisonNumber.length()<7){
            StrPoisonNumber="0"+StrPoisonNumber;
        }//补齐位数
        MedicineBottle[] medicineBottles=new MedicineBottle[100];
        for(int i=0;i<100;i++){
            MedicineBottle medicineBottle = new MedicineBottle();
            String id=Integer.toBinaryString(i);
            while (id.length()<7){
                id="0"+id;
            }
            medicineBottle.setId(id);
            if(i==PoisonNumber){
                medicineBottle.setPoison(true);
            }
            else {
                medicineBottle.setPoison(false);
            }
            medicineBottles[i]=medicineBottle;
        }//生成一百个药瓶对象，并将有毒那瓶的isPoison设置为true
        Mouse[] delivery = utils.Delivery(mice, medicineBottles);//将药瓶中的药按照规则分配给七只老鼠。
        List<Integer> poisonNumber = utils.getPoisonNumber(delivery, StrPoisonNumber);
        String str="0000000";
        char[] chars = str.toCharArray();
        for(int i=0;i< poisonNumber.size();i++){
            chars[poisonNumber.get(i)]='1';
        }
//        System.out.println(poisonNumber);
        String s = new String(chars);
//        System.out.println(s);
        int i = Integer.parseInt(s,2);
        System.out.println("有毒的药瓶编号为:"+i);
    }


    @Test
    public void test(){
        String s = Integer.toBinaryString(100);
        System.out.println(s);
        Random random = new Random();
        int i = random.nextInt(100);
        System.out.println(i);
        char j='1';
        if(j=='1'){
            System.out.println("d");
        }
        System.out.println(Integer.parseInt("1010100",2));
    }
}
