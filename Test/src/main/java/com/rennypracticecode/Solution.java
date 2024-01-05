package com.rennypracticecode;

import java.util.*;
class Solution{

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        //hashmap of all parenthesis pairs, but backwards for checking if a mate exists later.
        //this hashmap is later used to see if the closing parenthesis has a open parenthesis mate already
        //in the stack we create below. If it does have a mate, the opening parenthesis is popped of the
        //stack, emptying it again. All opening parenthesis are auto added to the stack, as they will
        //fulfill the conditions of the if statement in the iteration.
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(']', '[');
        hashMap.put('}', '{');
        hashMap.put(')', '(');

        while (sc.hasNext()) {
            String input=sc.next();
            //Complete the code

            //empty stack (remember first in first out)
            //this stack must still be empty at the end of iteration for all the pairs to be balanced.
            Stack<Character> stack = new Stack<Character>();

            //turns the line of input into a char array and iterates through each character
            for(Character c : input.toCharArray()){

                //checks the hashmap has c as a key (checking if it's a closing parenthesis), && checks
                //that the stack we created earlier isn't
                //empty (it can't have a matching opening mate if the stack is empty),
                //&& checks that stack has the matching value to the key (to see if it has an opening
                //parenthesis mate that came before it)
                if(hashMap.containsKey(c) &&
                        stack.size() > 0 &&
                        stack.peek().equals(hashMap.get(c))){

                    //if these conditions are met, it pops the 'c' value off the stack
                    //to empty the stack out again if it had a pair
                    stack.pop();

                } else {

                    //else the 'c' value is added to the stack
                    //if the hashMap doesn't contain c as a key,
                    //if the stack is equal to zero,
                    //if the stack doesn't contain the value to the key,
                    //the stack must be empty at the end of iteration for all the
                    //parenthesis pairs to be balanced. if it is not empty, that
                    //indicates that either a closing parenthesis came before an
                    //opening one or that a parenthesis didn't have a mate at all.
                    stack.push(c);
                }

            }

            //the stack must be empty at the end of iteration for all the
            //parenthesis pairs to be balanced and to print true.
            // if it is not empty, that indicates that either a closing parenthesis came before an
            //opening one or that a parenthesis didn't have a mate at all and must print false since
            //it's unbalanced.
            if(stack.size() == 0){
                System.out.println("true");
            } else {
                System.out.println("false");
            }


        }

    }
}


