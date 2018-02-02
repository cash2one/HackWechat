package android.support.v7.widget;

import android.support.v4.os.e;
import android.support.v7.widget.RecyclerView.t;
import android.view.ViewGroup;
import java.util.List;

public abstract class RecyclerView$a<VH extends t> {
    public final RecyclerView$b UR = new RecyclerView$b();
    public boolean US = false;

    public abstract VH a(ViewGroup viewGroup, int i);

    public abstract void a(VH vh, int i);

    public abstract int getItemCount();

    public void a(VH vh, int i, List<Object> list) {
        a((t) vh, i);
    }

    public final VH d(ViewGroup viewGroup, int i) {
        e.beginSection("RV CreateView");
        VH a = a(viewGroup, i);
        a.VX = i;
        e.endSection();
        return a;
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public final void fP() {
        if (this.UR.fQ()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.US = true;
    }

    public long getItemId(int i) {
        return -1;
    }

    public void a(VH vh) {
    }

    public final void a(RecyclerView$c recyclerView$c) {
        this.UR.registerObserver(recyclerView$c);
    }

    public final void b(RecyclerView$c recyclerView$c) {
        this.UR.unregisterObserver(recyclerView$c);
    }

    public final void bj(int i) {
        this.UR.U(i, 1);
    }

    public final void b(int i, Object obj) {
        this.UR.b(i, 1, obj);
    }

    public final void U(int i, int i2) {
        this.UR.U(i, i2);
    }

    public final void b(int i, int i2, Object obj) {
        this.UR.b(i, i2, obj);
    }

    public final void bk(int i) {
        this.UR.W(i, 1);
    }

    public final void V(int i, int i2) {
        this.UR.V(i, i2);
    }

    public final void W(int i, int i2) {
        this.UR.W(i, i2);
    }

    public final void bl(int i) {
        this.UR.X(i, 1);
    }

    public final void X(int i, int i2) {
        this.UR.X(i, i2);
    }
}
