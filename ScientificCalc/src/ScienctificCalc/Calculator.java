//declares the package name for the code
package ScienctificCalc;
// import the package which provides classes for creating GUI in Java.
import javax.swing.*;
import java.awt.*;
//import the package for handling user interactions with GUI components
import java.awt.event.*;
//import the class which provides mathematical functions
import java.lang.Math;
//imports the constant DIALOG_INPUT from the Font class
import static java.awt.Font.DIALOG_INPUT;

public class Calculator extends Calculations implements ActionListener {

    // Fields for storing input, memory, and GUI components:

    // Stores the current user input as a string
    public String inputBuffer = "";

    // Stores a numerical value for memory operations
    public double memory = 0.0;

    // The main window of the calculator application
    JFrame frame;

    // The text field where numbers and expressions are displayed
    JTextField textfield;

    // Arrays to hold different types of buttons for efficient organization
    JButton[] numberButtons = new JButton[12];
    JButton[] functionButtons = new JButton[5];
    JButton[] complexButtons = new JButton[36];

    // Individual buttons for basic arithmetic operations and the decimal point
    JButton addButton, subButton, mulButton, divButton, equButton;
    JButton decButton;

    // Buttons for miscellaneous functions
    JButton delButton, clrButton, negButton, obracButton, cbracButton, mcButton, mpButton, mnButton,
            mrButton, pnButton, modButton, secButton, pow2Button, pow3Button, powxButton, poweButton,
            pow10Button, xButton, recButton, sinButton, cosButton, tanButton, eButton, r2Button, r3Button,
            rxButton, lnButton, logButton, xeButton, EEButton, radButton, sinhButton, coshButton, tanhButton,
            piButton, randButton;

    // A panel to hold and organize the buttons within the calculator window
    JPanel panel;


    // Creates a new font
    Font textfont = new Font(DIALOG_INPUT, Font.PLAIN, 25);
    Font myfont = new Font("SansSerif", Font.PLAIN, 16);

    // Creates a new color orange
    Color orangeColor = new Color(243, 128, 6);
    // Creates a light gray color
    Color lgray = new Color(103, 102, 103);
    // Creates a dark gray color
    Color dgray = new Color(57, 53, 59, 247);



    // Constructor of the Calculator class, responsible for initializing the GUI elements
    Calculator() {

        // Creates the main window of the calculator
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets the default close operation to exit the application
        frame.setSize(610, 400); // Sets the initial size of the window

        // Use a flexible layout manager for automatic resizing
        frame.setLayout(new BorderLayout());

        // Creates the text field where numbers and expressions will be displayed
        textfield = new JTextField();
        textfield.setBounds(40, 5, 600, 100); // Sets the position and size of the text field (note: this line might be ignored due to BorderLayout)
        textfield.setFont(textfont);
        textfield.setEditable(false); // Makes the text field read-only to prevent direct editing
        textfield.setBackground(Color.BLACK);
        textfield.setForeground(Color.WHITE);
        textfield.setHorizontalAlignment(JButton.RIGHT); // Aligns text to the right for better readability

        // Creates individual buttons for various operations and functions
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("C");
        obracButton = new JButton("(");
        cbracButton = new JButton(")");
        mcButton = new JButton("mc");
        mpButton = new JButton("m+");
        mnButton = new JButton("m-");
        mrButton = new JButton("mr");
        pnButton = new JButton("+/-");
        modButton = new JButton("%");
        secButton = new JButton("2nd");
        pow2Button = new JButton("x^2");
        pow3Button = new JButton("x^3");
        powxButton = new JButton("x^y");
        poweButton = new JButton("e^x");
        pow10Button = new JButton("10^x");
        xButton = new JButton("x");
        recButton = new JButton("1/x");
        r2Button = new JButton("2√x");
        r3Button = new JButton("3√x");
        rxButton = new JButton("x√y");
        lnButton = new JButton("ln");
        logButton = new JButton("log");
        xeButton = new JButton("x!");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        eButton = new JButton("e");
        EEButton = new JButton("EE");
        radButton = new JButton("Rad");
        sinhButton = new JButton("sinh");
        coshButton = new JButton("cosh");
        tanhButton = new JButton("tanh");
        piButton = new JButton("π");
        randButton = new JButton("Rand");

       // Organizes buttons into arrays for easier management
        //function buttons
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = equButton;

        //complex buttons
        complexButtons[0] = delButton;
        complexButtons[1] = clrButton;
        complexButtons[2] = mrButton;
        complexButtons[3] = delButton;
        complexButtons[4] = obracButton;
        complexButtons[5] = cbracButton;
        complexButtons[6] = mcButton;
        complexButtons[7] = mpButton;
        complexButtons[8] = mnButton;
        complexButtons[9] = pnButton;
        complexButtons[10] = modButton;
        complexButtons[11] = secButton;
        complexButtons[12] = pow2Button;
        complexButtons[13] = pow3Button;
        complexButtons[14] = powxButton;
        complexButtons[15] = poweButton;
        complexButtons[16] = pow10Button;
        complexButtons[17] = xButton;
        complexButtons[18] = recButton;
        complexButtons[19] = sinButton;
        complexButtons[20] = cosButton;
        complexButtons[21] = tanButton;
        complexButtons[22] = eButton;
        complexButtons[23] = r2Button;
        complexButtons[24] = r3Button;
        complexButtons[25] = rxButton;
        complexButtons[26] = lnButton;
        complexButtons[27] = logButton;
        complexButtons[28] = xeButton;
        complexButtons[29] = EEButton;
        complexButtons[30] = sinhButton;
        complexButtons[31] = coshButton;
        complexButtons[32] = tanhButton;
        complexButtons[33] = radButton;
        complexButtons[34] = piButton;
        complexButtons[35] = randButton;

       // Assigns the decimal point button to the numberButtons array
        numberButtons[11] = decButton;

        // Function Buttons:
        for (int i = 0; i < 5; i++) {
            functionButtons[i].addActionListener(this);//Attaches ActionListener for event handling
            // create a consistent visual style for these buttons.
            functionButtons[i].setFont(myfont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(orangeColor);
            functionButtons[i].setSize(30, 10);
            functionButtons[i].setForeground(Color.WHITE);
            functionButtons[i].setBorder(BorderFactory.createEmptyBorder());
        }

        for (int i = 0; i < 12; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));//Creates number buttons with labels from 0 to 9
            numberButtons[i].addActionListener(this);//Attaches ActionListener for event handling
            //consistent appearance.
            numberButtons[i].setFont(myfont);
            numberButtons[i].setBackground(lgray);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setForeground(Color.WHITE);
            numberButtons[i].setBorder(BorderFactory.createEmptyBorder());

        }
       //For decButton to match other number buttons.
        decButton.setBackground(lgray);
        decButton.setForeground(Color.WHITE);

       //Set size for the number buttons
        for (int i = 1; i < 12; i++) {
            numberButtons[i].setSize(30,10);
        }
        //Adjusts size for the number 0 button to be larger,
        numberButtons[0].setSize(60,10);


        for (int i = 0; i < 36; i++) {
            complexButtons[i].addActionListener(this);//Attaches ActionListener for event handling
            ////consistent appearance.
            complexButtons[i].setFont(myfont);
            complexButtons[i].setFocusable(false);
            complexButtons[i].setBackground(dgray);
            complexButtons[i].setSize(30, 10);
            complexButtons[i].setForeground(Color.WHITE);
            complexButtons[i].setBorder(BorderFactory.createEmptyBorder());

        }

      //Create a JPanel to hold the buttons, acting as a container for organizing them.
        panel = new JPanel();
        panel.setBounds(40, 70, 600, 300);
        panel.setLayout(new GridLayout(5, 9, 2, 2));
        panel.setBackground(Color.BLACK);

//Adds the buttons to the panel, starting the button arrangement.
        panel.add(obracButton);
        panel.add(cbracButton);
        panel.add(mcButton);
        panel.add(mpButton);
        panel.add(mnButton);
        panel.add(mrButton);
        panel.add(clrButton);
        panel.add(pnButton);
        panel.add(modButton);
        panel.add(divButton);
        panel.add(secButton);
        panel.add(pow2Button);
        panel.add(pow3Button);
        panel.add(powxButton);
        panel.add(poweButton);
        panel.add(pow10Button);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(recButton);
        panel.add(r2Button);
        panel.add(r3Button);
        panel.add(rxButton);
        panel.add(lnButton);
        panel.add(logButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(xeButton);
        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(tanButton);
        panel.add(eButton);
        panel.add(EEButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(radButton);
        panel.add(sinhButton);
        panel.add(coshButton);
        panel.add(tanhButton);
        panel.add(piButton);
        panel.add(randButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(equButton);

       //Adding Components to the Frame
        frame.add(textfield, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        // Creates a new instance of the Calculator class
        Calculator calc;
        calc = new Calculator();
    }

    // This method calculates the factorial of a non-negative integer n.
    private double factorial(int n) {
        // Base cases: If n is 0 or 1, the factorial is 1.
        if (n == 0 || n == 1) {
            return 1;
        }
        // Initialize the result variable to 1.
        double result = 1;
        // Use a loop to calculate the factorial from 2 to n
        for (int i = 2; i <= n; i++) {
            // Multiply the current result by the current iterator value (i).
            result *= i;
        }
       return result;
    }


    public void actionPerformed(ActionEvent e) {
        // Retrieves the text associated with the button that was clicked
        String command= e.getActionCommand();
        // Performs different actions based on the clicked button
        switch (command) {
            case "=":
                // Evaluates the current expression and displays the result
                evaluateExpression();
                break;
            case "C":
                // Clears the current entry in the text field
                clearEntry();
                break;
            case "π":
                // Adds the value of pi to the input
                addToInput(Math.PI);
                break;
            case "e":
                // Adds the value of e to the input
                addToInput(Math.E);
                break;
            //Other cases with different function buttons
            case "x^2":
                addToInput("^2");
                break;
            case "x^3":
                addToInput("^3");
                break;
            case "x^y":
                addToInput("^");
                break;
            case "e^x":
                addToInput("exp(");
                break;
            case "10^x":
                addToInput("10^x(");
                break;
            case "sin":
                addToInput("sin(");
                break;
            case "cos":
                addToInput("cos(");
                break;
            case "tan":
                addToInput("tan(");
                break;
            case "2√x":
                addToInput("sqrt(");
                break;
            case "3√x":
                addToInput("cbrt(");
                break;
            case "log":
                addToInput("log(");
                break;
            case "ln":
                addToInput("ln(");
                break;
            case "1/x":
                addToInput("1/");
                break;
            case "log10":
                addToInput("log10(");
                break;
            case "mc":
                // Clears the calculator's memory
                memoryClear();
                break;
            case "mr":
                // Recalls the value stored in memory
                memoryRecall();
                break;
            case "ms":
                memoryStore();
                break;
            case "m+":
                // Adds the current value to the memory
                memoryAdd();
                break;
            case "m-":
                // Subtracts the current value from the memory
                memorySubtract();
                break;
            case "EE":
                addToInput("E"); // Assuming EE means E (scientific notation)
                break;
            case "x!": // Handle factorial button
                try {
                    // Get the current value in the text field and try to parse it as a double
                    double value = Double.parseDouble(textfield.getText());
                    int n = (int) value; // Ensure integer for factorial
                    // Check for negative input
                    if (n < 0) {
                        textfield.setText("Error: Factorial not defined for negative numbers");
                    } else {
                        // Calculate the factorial using the factorial method
                        double result = factorial(n);
                        // Display the calculated factorial in the text field
                        textfield.setText(Double.toString(result));
                    }
                } catch (NumberFormatException ex) {
                    // Handle invalid input
                    textfield.setText("Invalid input for factorial");
                }
                break;
            default:
                addToInput(command);
                break;
        }

    }

    @Override
    // Adds a string to the current input buffer and updates the text field
    public void addToInput(String s) {
        inputBuffer += s;
        textfield.setText(inputBuffer);
    }

    @Override
    // Adds a double to the current input buffer and updates the text field
    public void addToInput(double d) {
        inputBuffer += d;
        textfield.setText(inputBuffer);
    }
    @Override
    // Evaluates the current expression and displays the result or an error message
    public void evaluateExpression() {
        try {
            String expression = inputBuffer.replaceAll("e\\^", "exp");// Replace "e^" with "exp" for evaluation
            // Evaluate the expression using the eval method
            double result = eval(expression);

            textfield.setText(Double.toString(result)); // Display the result in the text field
            inputBuffer = "";// Clear the input buffer for the next expression
        } catch (Exception ex) {
            // Handle any errors during evaluatio
            textfield.setText("Error");
            inputBuffer = "";// Clear the input buffer after an error
        }
    }


    @Override
    // Clears the current input in the text field and the input buffer
    public void clearEntry() {
        inputBuffer = "";
        textfield.setText("");
    }

    @Override
    // Clears the calculator's memory
    public void memoryClear() {
        // Reset the memory value to 0
        memory = 0.0;
    }
    @Override
    // Recalls the value stored in memory
    public void memoryRecall() {
        // Add the memory value to the input buffer and text field
        addToInput(memory);
    }
    @Override
    // Stores the current value in the text field into the calculator's memory
    public void memoryStore() {
        try {
            // Parse the text field value as a double and store it in memory
            memory = Double.parseDouble(textfield.getText());
        } catch (NumberFormatException e) {
            // Handle invalid input
            textfield.setText("Invalid Memory Value");
        }
    }

    @Override
    // Adds the current value in the text field to the value in memory
    public void memoryAdd() {
        try {
            double value = Double.parseDouble(textfield.getText());
            // Add it to the current memory value
            memory += value;
        } catch (NumberFormatException e) {
            textfield.setText("Invalid Memory Value");// Handle invalid input
        }
    }
    @Override
    // Subtracts the current value in the text field from the value in memory
    public void memorySubtract() {
        try {
            double value = Double.parseDouble(textfield.getText());
            // Subtract it from the current memory value
            memory -= value;
        } catch (NumberFormatException e) {
            textfield.setText("Invalid Memory Value");// Handle invalid input
        }
    }
    @Override
    public double eval(final String str) {
        return new Object() {
            // Variable declarations:
            int pos = -1, ch; // Initialized to track position and current character

            void nextChar() {
                // Update position and current character
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }
            // This method consumes (skips) the next character if it matches the given character, and returns a boolean indicating success
            boolean eat(int charToEat) {
                // Skip any whitespace characters before checking for the target character.
                while (ch == ' ') nextChar();
                // Check if the current character matches the target character.
                if (ch == charToEat) {
                    // Consume the character by moving to the next one.
                    nextChar();
                    return true;// Indicate successful consumption.
                }
                // Character mismatch, don't consume and return false.
                return false;
            }
           // Main parsing method: Parse -  converting data from one format to another
            double parse() {
                //Advance to the first character
                nextChar();
                //Parse the entire expression
                double x = parseExpression();
                //Ensure all characters have been parsed
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                //Return parse result
                return x;
            }

            double parseExpression() {
                // Parse the first term
                double x = parseTerm();
                // Repeatedly parse terms connected by operators
                for (; ; ) { //until no more operators are found.
                    if (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else if (eat('%')) x %= parseTerm();
                    else return x;//Return the result
                }
            }

            double parseTerm() {
                // Parse the first factor
                double x = parseFactor();
                // Repeatedly parse factors connected by operators
                for (; ; ) { // until no more operators are found.
                    if (eat('*')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else return x;
                }
            }

            double parseFactor() {
                double x;
                //Tracks the starting position of the current factor within the string.
                int startPos = this.pos;
                //Checks the sign and applies the sign accordingly
                if (eat('+')) {
                    return parseFactor();
                } else if (eat('-')) {
                    return -parseFactor();
                    //Calls parseExpression() to process the expression within the parentheses and stores the result in x.
                } else if (eat('(')) {
                    x = parseExpression();
                    eat(')');
                    //Checks if the current character is a digit or a decimal point.
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    //convert the substring from startPos to current position to a double value and stores it in x.
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                    //Checks if the current character is a letter (function name)
                } else if (ch >= 'a' && ch <= 'z') {
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    //Stores the function name in func
                    String func = str.substring(startPos, this.pos);
                    // Get the value of the factor from parseFactor()
                    x = parseFactor();
                    // Apply mathematical functions based on the parsed function name
                    if (func.equals("ln")) x = Math.log(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else if (func.equals("sinh")) x = Math.sinh(x);
                    else if (func.equals("cosh")) x = Math.cosh(x);
                    else if (func.equals("tanh")) x = Math.tanh(x);
                    else if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("cbrt")) x = Math.cbrt(x);
                    else if (func.equals("exp")) x = Math.exp(x);
                    else if (func.equals("log")) x = Math.log10(x);
                    else if (func.equals("x^2")) x = Math.pow(x, 2);
                    else if (func.equals("x^3")) x = Math.pow(x, 3);
                    else if (func.equals("1/x")) x = 1 / x;
                    else if (func.equals("x^y")) {
                        eat('^');// Consume the '^' operator
                        double y = parseFactor();
                        x = Math.pow(x, y);// Calculate x raised to the power of y
                    } else if (func.equals("e^x")) {
                        eat('^');// Consume the '^' operator
                        double b = parseFactor();
                        x = Math.pow(Math.E, b);// Calculate e raised to the power of b
                    } else if (func.equals("x√y")) {
                        eat('√');// Consume the '√' operator
                        double y = parseFactor();
                        x = Math.pow(x, 1.0 / y);// Calculate the y-th root of x
                    } else if (func.equals("mod")) {
                        eat('%');// Consume the '%' operator
                        x %= parseFactor();// Calculate x modulo the result of parseFactor()
                        // Factorial function
                    } else if (func.equals("x!")) {
                        int n = (int) x;// Ensure x is an integer for factorial calculation
                        x = factorial(n);
                    } else throw new RuntimeException("Unknown function: " + func);// Handle unrecognized functions
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);// Handle unexpected characters
                }

               // if (eat('^')) x = Math.pow(x, parseFactor());

                return x;

            }

        }.parse();
    }







}
