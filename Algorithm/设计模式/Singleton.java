
// DCL 
public class Singleton {
    private Singleton() {
    }

    private static volatile Singleton mInstance = null;

    public static Singleton getInstance() {

        if (mInstance == null) {
            synchronized (Singleton.class) {
                if (mInstance == null) {
                    mInstance = new Singleton();
                }
            }
        }
        return mInstance;
    }
}