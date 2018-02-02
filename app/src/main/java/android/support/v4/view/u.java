package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class u {
    private final DataSetObservable xB = new DataSetObservable();
    private DataSetObserver xC;

    public abstract boolean a(View view, Object obj);

    public abstract int getCount();

    public Object b(ViewGroup viewGroup, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void e(Object obj) {
    }

    public void aX() {
    }

    public Parcelable aY() {
        return null;
    }

    public void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public int k(Object obj) {
        return -1;
    }

    public void notifyDataSetChanged() {
        synchronized (this) {
            if (this.xC != null) {
                this.xC.onChanged();
            }
        }
        this.xB.notifyChanged();
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.xB.registerObserver(dataSetObserver);
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.xB.unregisterObserver(dataSetObserver);
    }

    final void a(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.xC = dataSetObserver;
        }
    }

    public CharSequence bL() {
        return null;
    }
}
