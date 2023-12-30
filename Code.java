import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import java.util.*;

public class Code extends Application 
{
    private String str;
    private double result;

    private static int Precedence (String s)
    {
        if(s.equals("+") || s.equals("-"))
            return 1;
        else if(s.equals("x") || s.equals("/"))
            return 2;
        else 
            return -1;
    }

    private String InfixToPostfix(String str)
    {
        String postfix = new String("");
        Stack<String> stack =new Stack<String>();
          
        int i = 0;

        for(int j = 0; j < str.length(); j++)
        {
            if(str.charAt(j) == '+' || str.charAt(j) == '-' || str.charAt(j) == 'x' || str.charAt(j) == '/')
            {
                postfix += str.substring(i, j) + " ";

                while (!stack.isEmpty() && Precedence(str.charAt(j) + "") <= Precedence(stack.peek()))
                    postfix += stack.pop() + " ";

                stack.push(str.charAt(j) + "");

                i = j + 1;
            }
            else if(j == (str.length()-1))
            {
                postfix += str.substring(i, j+1) + " ";
            }  
        }
       
        while (!stack.isEmpty())
        {
            postfix += stack.pop() + " ";
        }

        return postfix;
    }

    private double EvaluatePostfix(String str)
    {
        result = 0.0;
        Stack<Double> stack = new Stack<Double>();
        
        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
             
            if(Character.isDigit(ch))
            {
                int j = i;
                for(; j < str.length(); j++)
                {
                    if(str.charAt(j) == ' ')
                        break;
                }
                        
                stack.push(Double.parseDouble(str.substring(i, j)));
                ch = str.charAt(j);
                i = j;
            }
            else if(ch != ' ')
            {
                double num1 = stack.pop();
                double num2 = stack.pop();
                
                if(ch == '+')
                    stack.push(num2 + num1);
                else if(ch == '-')
                    stack.push(num2 - num1);
                else if(ch == 'x')
                    stack.push(num2 * num1);
                else if(ch == '/')
                {
                    try
                    {
                        stack.push(num2 / num1);
                    }
                    catch(ArithmeticException ae)
                    {
                        System.out.println("Exception caught:" + ae.getMessage());
                        ae.printStackTrace();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Exception caught:" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        }
        result = (stack.pop()).doubleValue();
        return result;   
    }

    public void start(Stage myStage)
    {
        myStage.setTitle("JavaFX Calculator");

        TextField text = new TextField();
        text.setPrefColumnCount(22);
        text.setEditable(false);

        str = "";

        Button b1 = new Button("      7      ");
      
        b1.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent ae) 
            {
                if((text.getText()).equals(""))
                    str = "";

                str = str + "7";
                text.setText(str);
               
            }
        });

        Button b2 = new Button("      8      ");
        b2.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent ae) 
            {
                if((text.getText()).equals(""))
                    str = "";
                    
                str = str + "8";
                text.setText(str);
            }               
        });

        Button b3 = new Button("      9      ");
        b3.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent ae) 
            {
                if((text.getText()).equals(""))
                    str = "";

                str = str + "9";
                text.setText(str);
            }
        });

        Button b4 = new Button("      +      ");
        b4.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent ae) 
            {
                if((text.getText()).equals(""))
                    text.setText("Error");
                else
                {
                    str = str + "+";
                    text.setText(str);
                }
            }
        });

        Button b5 = new Button("      4      ");
        b5.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent ae) 
            {
                if((text.getText()).equals(""))
                    str = "";
                    
                str = str + "4";
                text.setText(str);
            }
        });

        Button b6 = new Button("      5      ");
        b6.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent ae) 
            {
                if((text.getText()).equals(""))
                    str = "";
                    
                str = str + "5";
                text.setText(str);
            }
        });

        Button b7 = new Button("      6      ");
        b7.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent ae) 
            {
                if((text.getText()).equals(""))
                    str = "";
                    
                str = str + "6";
                text.setText(str);
            }
        });

        Button b8 = new Button("      -      ");
        b8.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent ae) 
            {
                if((text.getText()).equals(""))
                    text.setText("Error");
                else
                {
                    str = str + "-";
                    text.setText(str);
                }
            }
        });

        Button b9 = new Button("      1      ");
        b9.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent ae) 
            {
                if((text.getText()).equals(""))
                    str = "";
                    
                str = str + "1";
                text.setText(str);
            }
        });

        Button b10 = new Button("      2      ");
        b10.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent ae) 
            {
                if((text.getText()).equals(""))
                    str = "";
                    
                str = str + "2";
                text.setText(str);
            }
        });

        Button b11 = new Button("      3      ");
        b11.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent ae) 
            {
                if((text.getText()).equals(""))
                    str = "";
                    
                str = str + "3";
                text.setText(str);
            }
        });

        Button b12 = new Button("      x      ");
        b12.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent ae) 
            {
                if((text.getText()).equals(""))
                    text.setText("Error");
                else
                {
                    str = str + "x";
                    text.setText(str);
                }
            }
        });

        Button b13 = new Button("      C      ");
        b13.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent ae) 
            {
                text.setText("");
                str = "";
                result = 0.0;
            }
        });

        Button b14 = new Button("      0      ");
        b14.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent ae) 
            {
                if((text.getText()).equals(""))
                    str = "";
                    
                str = str + "0";
                text.setText(str);
            }
        });

        Button b15 = new Button("      =      ");
        b15.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent ae) 
            {
                if((text.getText()).equals(""))
                    text.setText("Error");
                else
                    text.setText(EvaluatePostfix(InfixToPostfix(str)) + "");
            }
        });

        Button b16 = new Button("      /      ");
        b16.setOnAction(new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent ae) 
            {
                if((text.getText()).equals(""))
                    text.setText("Error");
                else
                {
                    str = str + "/";
                    text.setText(str);
                }
            }
        });

        FlowPane rootNode = new FlowPane(5, 7);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.setPadding(new Insets(10, 10, 10, 10));  

        Scene myScene = new Scene(rootNode, 285, 180);
        myStage.setScene(myScene);

        rootNode.getChildren().add(text);
        rootNode.getChildren().addAll(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16);
        myStage.show();
    }

    public static void main(String[] args)  
    {
        launch(args);
    }
}
