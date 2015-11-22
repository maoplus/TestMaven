package powermock;

class Demo {
    private Computer coumputer;
    
    public Computer getCoumputer() {
        return coumputer;
    }
    
    public void prtName(int price) throws Exception {
        if (price > 10000) {
            throw new Exception("That's too expensive");
        }
        System.out.println(coumputer.getName() + " cost " + price);
    }
    
    public void setCoumputer(Computer coumputer) {
        this.coumputer = coumputer;
    }
    
}