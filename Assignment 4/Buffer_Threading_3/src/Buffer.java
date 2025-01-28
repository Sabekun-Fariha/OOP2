public class Buffer {

    private char[] buffer;
    private int size;
    private int count;

    public Buffer(int size){
        this.size = size;
        this.buffer = new char[size];
    }

    public synchronized void produce(char c) throws Exception{
        while(count == size){
            wait();
        }
        buffer[count] = c;
        count++;
        System.out.println("Produced: " + c );
        notify();
    }

    public synchronized char consume() throws Exception{

        while(count == 0){
            wait();
        }

        char c = buffer[count-1];
        count--;
        System.out.println("Consumed: " + c);
        notify();
        return c;
    }
}
