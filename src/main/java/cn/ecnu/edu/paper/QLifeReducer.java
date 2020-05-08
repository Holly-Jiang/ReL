package cn.ecnu.edu.paper;

import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.List;

public class QLifeReducer {
    public static void main(String[] args) {
        List<Instruction> I=new ArrayList<>();
        List<QItem> S=new ArrayList<>();
        QItem q1=new QItem(1,false);
        S.add(q1);
        I.add(new Instruction(1,"h",1,S,false));

        S=new ArrayList<>();
        QItem q2=new QItem(2,false);
        S.add(q2);
        I.add(new Instruction(2,"h",1,S,false));

        S=new ArrayList<>();
        QItem q3=new QItem(3,true);
        q2=new QItem(2,true);
        S.add(q2);
        S.add(q3);
        I.add(new Instruction(3,"cx",2,S,false));

        S=new ArrayList<>();
        S.add(q2);
        I.add(new Instruction(2,"h",1,S,false));

        S=new ArrayList<>();
        QItem q6=new QItem(6,false);
        S.add(q6);
        I.add(new Instruction(5,"h",1,S,false));


        System.out.println(stratify(I));
    }

    public static List<List<Instruction>> stratify(List<Instruction> I){
        List<List<Instruction>> B=new ArrayList<>();

        int index=0;
        while(index<I.size()){
            List<Instruction> b=new ArrayList<>();
            List<QItem> Q=new ArrayList<>();

            while(!Q.containsAll(I.get(index).getS())){
               Q.addAll(I.get(index).getS()) ;
               b.add(I.get(index));
               index++;
            }
            B.add(b);
        }
        return B;
    }
}
