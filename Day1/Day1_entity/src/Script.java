import java.awt.*;

/**
 * @Auther: zhaoss
 * @Date: 2020/12/21 - 12 - 21 - 19:48
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class Script {
    public static void main(String[] args) {
        //创建一个机器人 Robot
        try {
            Robot robot = new Robot();
            //1.为了让我们打开浏览器 让机器人休眠片刻
            robot.delay(5000);
            //2.通过机器人获取指定位置的颜色  所有的颜色都是由三元色不同的配制调配而成
            Color color = robot.getPixelColor(680, 500);//获取指定坐标的颜色
            //3.将颜色转为色值
            int code = color.getRed();
            System.out.println(code);
            if(code==254){

            }

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
