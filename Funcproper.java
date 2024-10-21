/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package funcproper;

import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class Funcproper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean program = true;
        double radius = 0;
        double base = 0;
        double height = 0;
        RUNNING:
        do {

            JOptionPane.showMessageDialog(null, "Let's calculate shapes!!!");
            boolean correct = true;
            OPERATIONS:
            do {
                int operation = JOptionPane.showOptionDialog(
                        null,
                        "What do you want calculate?",
                        "Let's get started",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        new String[]{"Area of a circle", "Area of a rectangle", "Area of a triangle", "Volume of a sphere", "volume of a cylinder"},
                        null);
                switch (operation) {
                    case -1: {
                        break RUNNING;
                    }
                    case 0: {
                        JOptionPane.showMessageDialog(null, "Provide the radius of the circle");
                        radius = getvalue();
                        double circlearea = getcirclearea(radius);
                        JOptionPane.showMessageDialog(null, "Circlearea" + circlearea);
                        break;
                    }
                    case 1: {
                        JOptionPane.showMessageDialog(null, "Provide the base of the rectangle");
                        base = getvalue();
                        JOptionPane.showMessageDialog(null, "Provide the height of the rectangle");
                        height = getvalue();
                        double arearectangle = getrectanglearea(base, height);
                        JOptionPane.showMessageDialog(null, "Rectanglearea" + arearectangle);
                        break;

                    }
                    case 2: {
                        JOptionPane.showMessageDialog(null, "Provide the base of the triangle");
                        base = getvalue();
                        JOptionPane.showMessageDialog(null, "Provide the height of the triangle");
                        height = getvalue();
                        double trianglearea = gettrianglearea(base, height);
                        JOptionPane.showMessageDialog(null, "trianglearea" + trianglearea);
                        break;

                    }
                    case 3: {
                        JOptionPane.showMessageDialog(null, "Provide the radius of the sphere");
                        radius = getvalue();
                        double spherevolume = getspherevolume(radius);
                        JOptionPane.showMessageDialog(null, "spherevolume" + spherevolume);
                        break;

                    }
                    case 4: {
                        JOptionPane.showMessageDialog(null, "Provide the radius of the cylinder's base");
                        radius = getvalue();
                        JOptionPane.showMessageDialog(null, "Provide the height of the cylinder");
                        height = getvalue();
                        double cylindervolume = getcylindervolume(radius, height);
                        JOptionPane.showMessageDialog(null, "cylindervolume" + cylindervolume);
                        break;

                    }
                }
                int more = JOptionPane.showConfirmDialog(null, "Do you want to do another calculation?", "again?", JOptionPane.YES_NO_OPTION);
                switch (more) {
                    case -1: {
                        break RUNNING;
                    }
                    case 0: {
                        break;
                    }
                    case 1: {
                        break OPERATIONS;
                    }
                }

            } while (correct);
            int nextCustomerOption = JOptionPane.showConfirmDialog(null, "Next user?", "", JOptionPane.YES_NO_OPTION);
            switch (nextCustomerOption) {
                case 0 -> {
                    break;
                }
                case 1 -> {
                    break RUNNING;
                }
                case -1 -> {
                    break RUNNING;
                }
            }

        } while (program);
        JOptionPane.showMessageDialog(null, "Thank you for using Karl's program.");
    }
//getting value and making sure its valid//

    public static double getvalue() {
        double value = 0;
        boolean correctvalue = true;
        String val = JOptionPane.showInputDialog("Enter the value");
        value = Double.parseDouble(val);
        if (value <= 0) {
            VALUE:
            do {
                int changeinput = JOptionPane.showOptionDialog(
                        null,
                        "what do you want to do?",
                        "You entered an invalid value",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        new String[]{"correct the value", "set to no value", "Exit program"},
                        null);
                switch (changeinput) {
                    case -1: {
                        value = -1;
                        break VALUE;
                    }
                    case 0: {
                        String correction = JOptionPane.showInputDialog("Enter the value");
                        value = Double.parseDouble(correction);
                        if (value <= 0) {
                            break;
                        }
                        break VALUE;
                    }
                    case 1: {
                        value = 0;
                        break VALUE;
                    }
                    case 2: {
                        value = -1;
                        break VALUE;
                    }
                }
            } while (correctvalue);

        }
        return value;
    }

    public static double getcirclearea(double a) {
        double areacircle = Math.PI * a * a;
        return areacircle;
    }

    public static double getrectanglearea(double a, double b) {
        double arearectangle = a * b;
        return arearectangle;
    }

    public static double gettrianglearea(double a, double b) {
        double trianglearea = (a * b) / 2;
        return trianglearea;
    }

    public static double getspherevolume(double a) {
        double volume = (4 * Math.PI * a * a * a) / 3;
        return volume;
    }

    public static double getcylindervolume(double a, double b) {
        double volume = Math.PI * a * a * b;
        return volume;
    }
}
