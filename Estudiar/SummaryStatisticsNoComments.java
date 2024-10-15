package es.ua.dlsi.prog3.p1;

import java.util.ArrayList;


public class SummaryStatistics{
    private int id; 
    private ArrayList<Integer> values;
    private static int NEXT_ID = 1;    

    public SummaryStatistics(){
        this.id = NEXT_ID;
        NEXT_ID++;
        this.values = new ArrayList<Integer>();
    }
    
    public SummaryStatistics(ArrayList<Integer> values){
        this.id = NEXT_ID;
        NEXT_ID++;
        this.values = new ArrayList<Integer>(values);
    }

    public SummaryStatistics(SummaryStatistics s){
        this.id = NEXT_ID;
        NEXT_ID++;
        this.values = new ArrayList<Integer>(s.values); /**Se realiza una copia profunda de la lista de valores, ya que al ser de tipo primitivo, se copia el valor y no la referencia, siendo así inmutables por defecto.*/
    }

    public void add(int value){
        this.values.add(value);    
    }

    public int getId(){
        return this.id;
    }

    public Integer getAverage(){
        if(this.values.size() == 0){return null;}
        int sum = 0;
        for(int i = 0; i < this.values.size(); i++){
            sum += this.values.get(i);
        }
        return sum / this.values.size();
    }

    public Integer getMax(){
        if(this.values.size() == 0){return null;}
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < this.values.size(); i++){
            max = Math.max(max, this.values.get(i));
        }
        return max;
    }

    public Integer getMin(){
        if(this.values.size() == 0){return null;}
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < this.values.size(); i++){
            min = Math.min(min, this.values.get(i));
        }
        return min;
    }

    public int getSize(){
        return this.values.size();
    }

    public static int COUNT_INSTANCES(){
        return NEXT_ID - 1;
    }
}

