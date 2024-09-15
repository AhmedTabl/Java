/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe318.lab7;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author atabl
 */
public class UserMain{
    
    public static void main(String[] args) {
        
        String command = "";
        String[] command_values;
        Scanner input = new Scanner(System.in);
        
        ArrayList elements = new ArrayList<>();
        

        do{
            
            command = input.nextLine();
            command_values = command.split(" ", 0);
            
            
            if(command_values[0].equals("r")){
                
                Node n1 = new Node(Integer.parseInt(command_values[1]));
                Node n2 = new Node(Integer.parseInt(command_values[2]));
               
                
                Resistor r = new Resistor(Double.parseDouble(command_values[3]), n1, n2);
                     
                elements.add(r);
                
                
            }else if(command_values[0].equals("v")){
                
                Node n1 = new Node(Integer.parseInt(command_values[1]));
                Node n2 = new Node(Integer.parseInt(command_values[2]));
                
                VoltageSrc v = new VoltageSrc(Double.parseDouble(command_values[3]), n1, n2);
                
                elements.add(v);
                
            }else if(command.equals("end")){
                
                System.out.print("All Done!");
                
            }else if(command.equals("spice")){
                
                for(Object obj: elements){
                    
                    System.out.println(obj.toString());
                }
                
            }
            
            
        }while(!command.equals("end"));
        
    }
    
}