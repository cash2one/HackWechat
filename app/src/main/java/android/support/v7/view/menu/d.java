package android.support.v7.view.menu;

public class d<T> {
    public final T KO;

    d(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.KO = t;
    }
}
