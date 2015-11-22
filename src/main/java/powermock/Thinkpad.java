package powermock;

public class Thinkpad extends Computer {
    
    public void prtChild() {
        super.prtParent();
        System.out.println("child");
    }
}
