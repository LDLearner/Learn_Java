package Hibao_fakeData;

/**
 * Created by LD on 2019/3/21.
 */
public class Assert_Num {
    public static void main(String[] args) {

    }
    static int times=0;
    public static void Assert_Num(String letter,String playNum,String commentNum,String collectNum,String shareNum,String fansNum,String videolastNumint) {

        switch (letter){
            case "A":
                getRes(playNum,0,5,videolastNumint);
                getRes(commentNum,0,0,videolastNumint);
                getRes(collectNum,0,0,videolastNumint);
                getRes(shareNum,0,0,videolastNumint);
                getRes(fansNum,0,0,videolastNumint);
            break;
            case "B":
                getRes(playNum,5,50,videolastNumint);
                getRes(commentNum,0,0,videolastNumint);
                getRes(collectNum,0,2,videolastNumint);
                getRes(shareNum,0,2,videolastNumint);
                getRes(fansNum,0,0,videolastNumint);
                break;
            case "C":
                getRes(playNum,30,80,videolastNumint);
                getRes(commentNum,0,0,videolastNumint);
                getRes(collectNum,0,3,videolastNumint);
                getRes(shareNum,0,3,videolastNumint);
                getRes(fansNum,0,0,videolastNumint);
                break;
            case "D":
                getRes(playNum,50,100,videolastNumint);
                getRes(commentNum,0,3,videolastNumint);
                getRes(collectNum,1,5,videolastNumint);
                getRes(shareNum,1,5,videolastNumint);
                getRes(fansNum,0,2,videolastNumint);
                break;
            case "E":
                getRes(playNum,80,160,videolastNumint);
                getRes(commentNum,0,5,videolastNumint);
                getRes(collectNum,1,6,videolastNumint);
                getRes(shareNum,1,6,videolastNumint);
                getRes(fansNum,0,5,videolastNumint);
                break;
            case "F":
                getRes(playNum,120,300,videolastNumint);
                getRes(commentNum,0,5,videolastNumint);
                getRes(collectNum,1,10,videolastNumint);
                getRes(shareNum,1,10,videolastNumint);
                getRes(fansNum,1,5,videolastNumint);
                break;
            case "G":
                getRes(playNum,300,500,videolastNumint);
                getRes(commentNum,1,6,videolastNumint);
                getRes(collectNum,1,15,videolastNumint);
                getRes(shareNum,1,15,videolastNumint);
                getRes(fansNum,1,6,videolastNumint);
                break;
            case "H":
                getRes(playNum,580,650,videolastNumint);
                getRes(commentNum,1,10,videolastNumint);
                getRes(collectNum,2,15,videolastNumint);
                getRes(shareNum,2,15,videolastNumint);
                getRes(fansNum,2,6,videolastNumint);
                break;
            case "I":
                getRes(playNum,500,800,videolastNumint);
                getRes(commentNum,3,20,videolastNumint);
                getRes(collectNum,3,20,videolastNumint);
                getRes(shareNum,3,20,videolastNumint);
                getRes(fansNum,2,7,videolastNumint);
                break;
            case "J":
                getRes(playNum,700,1000,videolastNumint);
                getRes(commentNum,4,20,videolastNumint);
                getRes(collectNum,4,20,videolastNumint);
                getRes(shareNum,4,20,videolastNumint);
                getRes(fansNum,2,8,videolastNumint);
                break;
            case "K":
                getRes(playNum,900,1500,videolastNumint);
                getRes(commentNum,5,25,videolastNumint);
                getRes(collectNum,10,25,videolastNumint);
                getRes(shareNum,10,25,videolastNumint);
                getRes(fansNum,2,10,videolastNumint);
                break;

        }
        times=0;
    }

    public static boolean getRes(String StrNum,int min,int max,String StrLastNum) {
        times++;
        boolean res=false;
        int num=Integer.parseInt(StrNum);
        int lastNum=Integer.parseInt(StrLastNum);
        if(lastNum==1||lastNum==3||lastNum==5){
            res=max>=num&&num>=min;
           // System.out.println(res);
        }
        else if (lastNum==7||lastNum==9){
            res=(int)Math.floor(max*0.8)>=num&&num>=(int)Math.floor(min*0.8);
           // System.out.println(res);
        }
        else if (lastNum==2||lastNum==4||lastNum==6){
            res=(int)Math.floor(max*0.5)>=num&&num>=(int)Math.floor(min*0.5);
           // System.out.println(res);

        }
        else if (lastNum==8||lastNum==0){
            res=(int)Math.floor(max*0.3)>=num&&num>=(int)Math.floor(min*0.3);
           // System.out.println(res);
        }
        if(res==false){
            switch (times){
                case 1:
                    System.out.println("The Num is Error!!!"+"lastNum="+lastNum+","+"view="+StrNum);
                    break;
                case 2:
                    System.out.println("The Num is Error!!!"+"lastNum="+lastNum+","+"commentNum="+StrNum);
                    break;
                case 3:
                    System.out.println("The Num is Error!!!"+"lastNum="+lastNum+","+"collectNum="+StrNum);
                    break;
                case 4:
                    System.out.println("The Num is Error!!!"+"lastNum="+lastNum+","+"shareNum="+StrNum);
                    break;
                case 5:
                    System.out.println("The Num is Error!!!"+"lastNum="+lastNum+","+"fansNum="+StrNum);
                    break;
            }
            ReadFile.errortimes++;
        }

        return res;
    }

}
