import java.util.Scanner;

public class BMI_algorithm {
    public static double calc(double height, double weight){
        if(height>0 &&weight>0){
            return weight/Math.pow(height,2);
        }
        else {
            return -1;
        }
    }
    public static String status(double height, double weight){
        if(calc(height, weight)>35){
            return "Extreme Obese";
        } else if (calc(height, weight)>=30) {
            return "Obese";
        } else if (calc(height, weight)>=25) {
            return "Overweight";
        } else if (calc(height, weight)>=18.5) {
            return "Normal";
        } else if (calc(height, weight)>15) {
            return "Underweight";
        } else if (calc(height, weight)>=0) {
            return "Anorexic";
        } else {
            return "error, invalid values";
        }
    }
    public static double idealWeight(double height, double weight, double age, double slimness){
        double idealw=0;
        if(height>0 &&weight>0 && age>0 &&(slimness==0.9 || slimness==1 || slimness==1.1)){
            idealw=height-100+(age/10)*0.9*slimness;
            if(idealw>0){
                return idealw;
            }
            else {
                return -1;
            }
        }
        else {
            return -1;
        }

    }
}
