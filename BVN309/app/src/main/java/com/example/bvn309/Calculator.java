package com.example.bvn309;

import java.util.Stack;

public class Calculator{
    private String input;
    Stack<Float> numbers;
    Stack<Character> maths;
    private float result;

    public Calculator(String input){
        this.input = input;
        numbers = new Stack<>();
        maths = new Stack<>();
        pushQueue();
    }

    public float getResult(){
        //
        System.out.println(input);
        System.out.println(numbers);
        System.out.println(maths);
        //

        //
        return calculating(numbers,maths);
    }

    public void pushQueue(){
        StringBuffer number = new StringBuffer();
        for(int i = 0; i < input.length(); i++){
            char current = input.charAt(i);
            if(!isNumber(current)){
                maths.push(current);
                numbers.push(Float.parseFloat(number.toString()));
                number = new StringBuffer();
            }else{
                number.append(current);
                if(i==input.length() - 1)
                    numbers.push(Float.parseFloat(number.toString()));
            }
        }
    }

    public boolean isNumber(Character e){
        if(e.equals('.')||e.equals('0')||e.equals('1')||e.equals('2')||e.equals('3')||e.equals('4')||e.equals('5')||e.equals('6')||e.equals('7')||e.equals('8')||e.equals('9'))
            return true;
        return false;
    }

    public float calculating(Stack<Float> numbers, Stack<Character> maths){
        if(numbers.size()==1)
            return numbers.pop();
        //
        Character mathe = maths.pop();
        //
        if(mathe.equals('+'))
            return numbers.pop() + calculating(numbers, maths);
        if(mathe.equals('-'))
            return -numbers.pop() + calculating(numbers, maths);
        //
        float temp = numbers.pop();
        //
        if(mathe.equals('*')){
            if(!maths.isEmpty()&&maths.peek().equals('/'))
                numbers.push(numbers.pop()/temp);
            else
                numbers.push(numbers.pop()*temp);
        }
        if(mathe.equals('/')){
            if(!maths.isEmpty()&&maths.peek().equals('/'))
                numbers.push(numbers.pop()*temp);
            else
                numbers.push(numbers.pop()/temp);
        }
        return calculating(numbers, maths);
    }
}
