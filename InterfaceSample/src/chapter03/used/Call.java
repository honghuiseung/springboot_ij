package chapter03.used;

public class Call {
    public static void main(String[] args) { //"main" + tab
        //Ctrl + Shift + F10
        //Calculator calculator = new AddCalc();
        Calculator calculator = new SubCalc();
        Integer result = calculator.calc(10,5);
        System.out.println("계산 결과는 (" + result + ") 입니다.");  //"s" + enter
    }
}
