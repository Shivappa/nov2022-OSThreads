package synchronized_method;

public class Count {
    private int count;

    public int getValue(){
        return count;
    }

    public synchronized void incrementValue(int offset){
        this.count += offset;
    }

    public Count(){
        count = 0;
    }
}
