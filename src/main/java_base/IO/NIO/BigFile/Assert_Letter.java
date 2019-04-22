package IO.NIO.BigFile;

import java.util.ArrayList;

/**
 * Created by LD on 2019/3/19.
 */
public class Assert_Letter {
    public static void main(String[] args) {
       // Assert_letter_today(4,"C");
       // Assert_letter(2, 45,"B", true);
    }

    private void ArrListAdd(ArrayList Arr, String A) {
        Arr.add(A);
    }

    private void ArrListAdd(ArrayList Arr, String A, String B) {
        Arr.add(A);
        Arr.add(B);
    }

    private void ArrListAdd(ArrayList Arr, String A, String B, String C) {
        Arr.add(A);
        Arr.add(B);
        Arr.add(C);
    }

    private void ArrListAdd(ArrayList Arr, String A, String B, String C, String D) {
        Arr.add(A);
        Arr.add(B);
        Arr.add(C);
        Arr.add(D);
    }

    public boolean Assert_letter_today(int diff_hour, String letter) {
            ArrayList<String> list = new ArrayList();
            if (diff_hour==-1000) {                                          //不同时间段对应的不同档位
                ArrListAdd(list, "A", "B");
            } else if (diff_hour==-2000) {
                ArrListAdd(list, "A", "B", "C");
            } else if (diff_hour==-3000) {
                ArrListAdd(list, "C", "D", "E", "F");
            } else if (diff_hour==-4000) {
                ArrListAdd(list, "E", "F", "G", "H");
            }
        System.out.print("letter="+letter);
        System.out.println("res="+list.contains(letter));
        return list.contains(letter);
    }

    public boolean Assert_letter(int type, int diff_day, String letter, boolean AM) {
        ArrayList<String> list = new ArrayList();
        if (type == 1) {
            if (diff_day <= 7) {                        //天数判断，7天内逻辑
                switch (diff_day) {
                    case 2:
                        if (AM == true) {
                            ArrListAdd(list, "B");
                        } else {
                            ArrListAdd(list, "F", "G", "H");
                        }
                        break;
                    case 3:
                        if (AM == true) {
                            ArrListAdd(list, "B", "C");
                        } else {
                            ArrListAdd(list, "H", "I", "J", "K");
                        }
                        break;
                    case 4:
                        if (AM == true) {
                            ArrListAdd(list, "B", "C");
                        } else {
                            ArrListAdd(list, "H", "I", "J");
                        }
                        break;
                    case 5:
                        if (AM == true) {
                            ArrListAdd(list, "B");
                        } else {
                            ArrListAdd(list, "G", "H", "I", "J");
                        }
                        break;
                    case 6:
                        if (AM == true) {
                            ArrListAdd(list, "B");
                        } else {
                            ArrListAdd(list, "G", "H", "I", "J");
                        }
                        break;
                    case 7:
                        if (AM == true) {
                            ArrListAdd(list, "B");
                        } else {
                            ArrListAdd(list, "G", "H", "I");
                        }
                        break;


                }
            } else {
                switch ((diff_day - 1) / 7 + 1) {                   //周数判断，从第8天开始算第二周
                    case 2:                                         //第二周
                        if (AM == true) {
                            ArrListAdd(list, "A", "B");
                        } else {
                            ArrListAdd(list, "G", "H", "I");
                        }
                        break;
                    case 3:                                         //第三周
                        if (AM == true) {
                            ArrListAdd(list, "A", "B");
                        } else {
                            ArrListAdd(list, "F", "G", "H");
                        }
                        break;
                    case 4:
                        if (AM == true) {
                            ArrListAdd(list, "A");
                        } else {
                            ArrListAdd(list, "D", "E", "F");
                        }
                        break;
                    case 5:
                        if (AM == true) {
                            ArrListAdd(list, "A");
                        } else {
                            ArrListAdd(list, "C", "D", "E");
                        }
                        break;
                    case 6:
                        if (AM == true) {
                            ArrListAdd(list, "A");
                        } else {
                            ArrListAdd(list, "B", "C", "E");
                        }
                        break;
                    case 7:
                        if (AM == true) {
                            ArrListAdd(list, "A");
                        } else {
                            ArrListAdd(list, "A");
                        }
                        break;
                    default:
                        System.out.println("The Date is out of 7 week!!!");
                        break;
                }
            }
        } else {                                             //第二类
            if (diff_day <= 7) {
                switch (diff_day) {
                    case 2:
                        if (AM == true) {
                            System.out.println("AM");
                            ArrListAdd(list, "B","C");
                        } else {
                            System.out.println("PM");
                            ArrListAdd(list, "H", "I", "J", "K");
                        }
                        break;
                    case 3:
                        if (AM == true) {
                            ArrListAdd(list, "B", "C");
                        } else {
                            ArrListAdd(list, "F", "G", "H", "I");
                        }
                        break;
                    case 4:
                        if (AM == true) {
                            ArrListAdd(list, "B", "C");
                        } else {
                            ArrListAdd(list, "F", "G", "H");
                        }
                        break;
                    case 5:
                        if (AM == true) {
                            ArrListAdd(list, "B");
                        } else {
                            ArrListAdd(list, "D", "E", "F", "G");
                        }
                        break;
                    case 6:
                        if (AM == true) {
                            ArrListAdd(list, "B");
                        } else {
                            ArrListAdd(list, "D", "E", "F", "G");
                        }
                        break;
                    case 7:
                        if (AM == true) {
                            ArrListAdd(list, "B");
                        } else {
                            ArrListAdd(list,"D", "E", "F");
                        }
                        break;


                }
            } else {
                switch ((diff_day - 1) / 7 + 1) {                   //周判断，从第8天开始算第二周
                    case 2:                                 //第二周
                        if (AM == true) {
                            ArrListAdd(list, "A", "B");
                        } else {
                            ArrListAdd(list, "C", "D", "E", "F");
                        }
                        break;
                    case 3:
                        if (AM == true) {
                            ArrListAdd(list, "A", "B");
                        } else {
                            ArrListAdd(list, "C", "D", "E", "F");
                        }
                        break;
                    case 4:
                        if (AM == true) {
                            ArrListAdd(list, "A");
                        } else {
                            ArrListAdd(list,"B", "C", "D");
                        }
                        break;
                    case 5:
                        if (AM == true) {
                            ArrListAdd(list, "A");
                        } else {
                            ArrListAdd(list,"B", "C", "D");
                        }
                        break;
                    case 6:
                        if (AM == true) {
                            ArrListAdd(list,"A");
                        } else {
                            ArrListAdd(list,"A", "B","D");
                        }
                        break;
                    case 7:
                        if (AM == true) {
                            ArrListAdd(list, "A");
                        } else {
                            ArrListAdd(list, "A");
                        }
                        break;
                    default:
                        System.out.println("The Date is out of 7 week!!!");
                        break;
                }
            }
        }
        System.out.print("letter="+letter+","+"AM="+AM+",");
        System.out.println("res="+list.contains(letter));
        return list.contains(letter);
        }

}

