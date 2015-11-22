package powermock;

public class Computer {
    private String  name;
    private String  cpu;
    private Boolean hasSSD;
    
    public Boolean getHasSSD() {
        return hasSSD;
    }
    
    public void setHasSSD(Boolean hasSSD) {
        this.hasSSD = hasSSD;
    }
    
    public Computer withName(String name) {
        this.name = name;
        return this;
    }
    
    public static String getPrice() {
        return "$900";
    }
    
    public void prtParent() {
        System.out.println("parent");
    }
    
    public Computer withCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }
    
    public String getCpu() {
        
        return cpu;
    }
    
    public void getException() {
        int a = 2;
        int b = 2;
        int c = b / 0;
    }
    
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
}
