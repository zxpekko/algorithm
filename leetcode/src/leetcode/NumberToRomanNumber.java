package leetcode;

/**
 * @Author:zxp
 * @Description:
 * @Date:15:37 2023/7/9
 */
public class NumberToRomanNumber {
    public static void main(String[] args) {
        NumberToRomanNumber numberToRomanNumber = new NumberToRomanNumber();
        String s = numberToRomanNumber.intToRoman(58);
        System.out.println(s);
    }
    public String intToRoman(int num){
        if(num>=1&&num<=9){
            if(num==4){
                return "IV";
            }
            else if (num==9) {
                return "IX";
            }
            else if(num<4){
                String str="";
                for(int i=0;i<num;i++){
                    str+="I";
                }
                return str;
            }
            else {
                int shengyu=num%5;
//                StringBuilder str= new StringBuilder("V");
                String str="V";
                for(int i=0;i<shengyu;i++){
//                    str.append("I");
                    str+="I";
                }
                return str;
            }
        }
        else if(num>=10&&num<=99){
            int shiwei=getShiwei(num);
            if(shiwei==4){
                int gewei=getSingle(num);
                if(gewei==4){
                    return "XLIV";
                }
                else if(gewei==9){
                    return "XLIX";
                }
                else if(gewei<4){
//                    StringBuilder str= new StringBuilder("XL");
                    String str="XL";
                    for(int i=0;i<gewei;i++){
//                        str.append("I");
                        str+="I";
                    }
                    return str;
                }
                else {
                    int shengyu=gewei%5;
                    String str="XLV";
                    for(int i=0;i<shengyu;i++){
                        str+="I";
                    }
                    return str;
                }
            }
            else if(shiwei==9){
                int gewei=getSingle(num);
                if(gewei==4){
                    return "XCIV";
                }
                else if(gewei==9){
                    return "XCIX";
                }
                else if(gewei<4){
                    String str="XC";
                    for(int i=0;i<gewei;i++){
                        str+="I";
                    }
                    return str;
                }
                else{
                    int shengyu=gewei%5;
                    String str="XCV";
                    for(int i=0;i<shengyu;i++){
                        str+="I";
                    }
                    return str;
                }
            }
            else if(shiwei<4){
                String str="";
                int gewei=getSingle(num);
                for(int i=0;i<shiwei;i++){
                    str+="X";
                }
                if(gewei==4){
                    str+="IV";
                }
                else if(gewei==9){
                    str+="IX";
                }
                else if(gewei<4){
                    for(int i=0;i<gewei;i++){
                        str+="I";
                    }
                }
                else {
                    int shengyu=gewei%5;
                    str+="V";
                    for(int i=0;i<shengyu;i++){
                        str+="I";
                    }
                }
                return str;
            }
            else {
                int shiweishengyu=shiwei%5;
                String str="L";
                for(int i=0;i<shiweishengyu;i++){
                    str+="X";
                }
                int gewei=getSingle(num);
                if(gewei==4){
                    str+="IV";
                }
                else if(gewei==9){
                    str+="IX";
                }
                else if(gewei<4){
                    for(int i=0;i<gewei;i++){
                        str+="I";
                    }
                }
                else{
                    int shengyu=gewei%5;
                    str+="V";
                    for(int i=0;i<shengyu;i++){
                        str+="I";
                    }
                }
                return str;
            }
        }
        else if(num>=100&&num<=999){
            int baiwei=getBaiwei(num);
            if(baiwei==4){
                String str="CD";
                int shiwei=getShiwei(num);
                if(shiwei==4){
                    str+="XL";
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweishengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweishengyu;i++){
                            str+="I";
                        }
                    }
                }
                else if(shiwei==9){
                    str+="XC";
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if (gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                else if(shiwei<4){
                    for(int i=0;i<shiwei;i++){
                        str+="X";
                    }
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                else {
                    int shiweiShengyu=shiwei%5;
                    str+="L";
                    for(int i=0;i<shiweiShengyu;i++){
                        str+="X";
                    }
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                return str;
            }
            else if(baiwei==9){
                String str="CM";
                int shiwei=getShiwei(num);
                if(shiwei==4){
                    str+="XL";
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweishengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweishengyu;i++){
                            str+="I";
                        }
                    }
                }
                else if(shiwei==9){
                    str+="XC";
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if (gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                else if(shiwei<4){
                    for(int i=0;i<shiwei;i++){
                        str+="X";
                    }
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                else {
                    int shiweiShengyu=shiwei%5;
                    str+="L";
                    for(int i=0;i<shiweiShengyu;i++){
                        str+="X";
                    }
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                return str;
            }
            else if(baiwei<4){
                String str="";
                for(int i=0;i<baiwei;i++){
                    str+="C";
                }
                int shiwei=getShiwei(num);
                if(shiwei==4){
                    str+="XL";
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweishengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweishengyu;i++){
                            str+="I";
                        }
                    }
                }
                else if(shiwei==9){
                    str+="XC";
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if (gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                else if(shiwei<4){
                    for(int i=0;i<shiwei;i++){
                        str+="X";
                    }
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                else {
                    int shiweiShengyu=shiwei%5;
                    str+="L";
                    for(int i=0;i<shiweiShengyu;i++){
                        str+="X";
                    }
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                return str;
            }
            else {
                int baiweiShengyu=baiwei%5;
                String str="D";
                for(int i=0;i<baiweiShengyu;i++){
                    str+="C";
                }
                int shiwei=getShiwei(num);
                if(shiwei==4){
                    str+="XL";
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweishengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweishengyu;i++){
                            str+="I";
                        }
                    }
                }
                else if(shiwei==9){
                    str+="XC";
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if (gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                else if(shiwei<4){
                    for(int i=0;i<shiwei;i++){
                        str+="X";
                    }
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                else {
                    int shiweiShengyu=shiwei%5;
                    str+="L";
                    for(int i=0;i<shiweiShengyu;i++){
                        str+="X";
                    }
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                return str;
            }
        }
        else {
            String str="";
            int qianwei=getQianwei(num);
            for(int i=0;i<qianwei;i++){
                str+="M";
            }

            int baiwei=getBaiwei(num);
//            System.out.println(baiwei);
            if(baiwei==4){
                str+="CD";
                int shiwei=getShiwei(num);
                if(shiwei==4){
                    str+="XL";
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweishengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweishengyu;i++){
                            str+="I";
                        }
                    }
                }
                else if(shiwei==9){
                    str+="XC";
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if (gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                else if(shiwei<4){
                    for(int i=0;i<shiwei;i++){
                        str+="X";
                    }
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                else {
                    int shiweiShengyu=shiwei%5;
                    str+="L";
                    for(int i=0;i<shiweiShengyu;i++){
                        str+="X";
                    }
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                return str;
            }
            else if(baiwei==9){
                str+="CM";
                int shiwei=getShiwei(num);
                if(shiwei==4){
                    str+="XL";
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweishengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweishengyu;i++){
                            str+="I";
                        }
                    }
                }
                else if(shiwei==9){
                    str+="XC";
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if (gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                else if(shiwei<4){
                    for(int i=0;i<shiwei;i++){
                        str+="X";
                    }
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                else {
                    int shiweiShengyu=shiwei%5;
                    str+="L";
                    for(int i=0;i<shiweiShengyu;i++){
                        str+="X";
                    }
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                return str;
            }
            else if(baiwei<4){
//                String str="";
                for(int i=0;i<baiwei;i++){
                    str+="C";
                }
                int shiwei=getShiwei(num);
                if(shiwei==4){
                    str+="XL";
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweishengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweishengyu;i++){
                            str+="I";
                        }
                    }
                }
                else if(shiwei==9){
                    str+="XC";
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if (gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                else if(shiwei<4){
                    for(int i=0;i<shiwei;i++){
                        str+="X";
                    }
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                else {
                    int shiweiShengyu=shiwei%5;
                    str+="L";
                    for(int i=0;i<shiweiShengyu;i++){
                        str+="X";
                    }
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                return str;
            }
            else {
//                System.out.println("大于5");
                int baiweiShengyu=baiwei%5;
                str+="D";
                for(int i=0;i<baiweiShengyu;i++){
                    str+="C";
                }
                int shiwei=getShiwei(num);
                if(shiwei==4){
                    str+="XL";
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweishengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweishengyu;i++){
                            str+="I";
                        }
                    }
                }
                else if(shiwei==9){
                    str+="XC";
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if (gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                else if(shiwei<4){
                    for(int i=0;i<shiwei;i++){
                        str+="X";
                    }
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                else {
                    int shiweiShengyu=shiwei%5;
                    str+="L";
                    for(int i=0;i<shiweiShengyu;i++){
                        str+="X";
                    }
                    int gewei=getSingle(num);
                    if(gewei==4){
                        str+="IV";
                    }
                    else if(gewei==9){
                        str+="IX";
                    }
                    else if(gewei<4){
                        for(int i=0;i<gewei;i++){
                            str+="I";
                        }
                    }
                    else {
                        int geweiShengyu=gewei%5;
                        str+="V";
                        for(int i=0;i<geweiShengyu;i++){
                            str+="I";
                        }
                    }
                }
                return str;
            }


        }
    }
    public int getSingle(int num){
        return num%10;
    }
    public int getShiwei(int num){
        return num/10%10;
    }
    public int getBaiwei(int num){
        return num/100%10;
    }
    public int getQianwei(int num){
        return num/1000;
    }

}
