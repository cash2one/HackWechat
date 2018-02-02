package android.support.v7.widget;

import android.database.Observable;

class RecyclerView$b extends Observable<RecyclerView$c> {
    RecyclerView$b() {
    }

    public final boolean fQ() {
        return !this.mObservers.isEmpty();
    }

    public final void notifyChanged() {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$c) this.mObservers.get(size)).onChanged();
        }
    }

    public final void U(int i, int i2) {
        b(i, i2, null);
    }

    public final void b(int i, int i2, Object obj) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$c) this.mObservers.get(size)).c(i, i2, obj);
        }
    }

    public final void W(int i, int i2) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$c) this.mObservers.get(size)).Z(i, i2);
        }
    }

    public final void X(int i, int i2) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$c) this.mObservers.get(size)).aa(i, i2);
        }
    }

    public final void V(int i, int i2) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$c) this.mObservers.get(size)).ab(i, i2);
        }
    }
}
