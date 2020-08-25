import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseListener;
import java.io.IOException;


public class Mouse {

    Robot robot = new Robot();
    PointerInfo a = MouseInfo.getPointerInfo();
    Point p = a.getLocation();
    int x = (int) p.getX();
    int y = (int) p.getY();


    public Mouse() throws AWTException {
    }


    public static void main(String[] args) throws AWTException, IOException {
        String command = "Runtime runtime = Runtime.getRuntime();\n" +
                "    runtime.exec(\"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe\");";
        Runtime runtime = Runtime.getRuntime();
        runtime.exec(command);
        new Mouse();
        }
    public void Mouse() throws AWTException{
        robot.setAutoDelay(40);
        robot.setAutoWaitForIdle(true);
        robot.delay(4000);

        moveMouse(x, y-50);
        moveMouse(x+50, y+50);
        moveMouse(x-50, y);
        moveMouse(x-50, y-50);
        System.exit(0);



    }

    private void moveMouse(int x, int y){
        robot.mouseMove(x, y);
        robot.delay(500);
        leftClick();
        type("d");
        robot.delay(10000);
    }

    private void type (int d){
        robot.delay(40);
        robot.keyPress(d);
        robot.keyRelease(d);
    }

    private void type (String s){
        byte[] bytes = s.getBytes();
        for (byte b : bytes){
            int num = b;
            if (num > 96 && num < 123) num = num-32;
            robot.delay(40);
            robot.keyPress(num);
            robot.keyRelease(num);
        }
    }

    private void leftClick()
    {
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(200);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(200);
    }






}


