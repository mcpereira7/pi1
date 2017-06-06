
import java.awt.Font;


public class TesteFonte {
    Font fonte;

    public TesteFonte() {
        this.fonte = new Font("Arial",Font.ITALIC, 10);
    }
    public static void main(String[] args) {
        System.out.println((char)27 + "[31m TEXTO\n");
    }
    
}
