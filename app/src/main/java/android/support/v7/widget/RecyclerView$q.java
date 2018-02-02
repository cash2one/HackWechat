package android.support.v7.widget;

import android.util.SparseArray;

public class RecyclerView$q {
    int VF = 1;
    private SparseArray<Object> VG;
    int VH = 0;
    int VI = 0;
    int VJ = 0;
    boolean VK = false;
    boolean VL = false;
    boolean VM = false;
    boolean VN = false;
    boolean VO = false;
    boolean VP = false;
    int Vv = -1;

    final void bu(int i) {
        if ((this.VF & i) == 0) {
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.VF));
        }
    }

    public final int getItemCount() {
        return this.VL ? this.VI - this.VJ : this.VH;
    }

    public final String toString() {
        return "State{mTargetPosition=" + this.Vv + ", mData=" + this.VG + ", mItemCount=" + this.VH + ", mPreviousLayoutItemCount=" + this.VI + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.VJ + ", mStructureChanged=" + this.VK + ", mInPreLayout=" + this.VL + ", mRunSimpleAnimations=" + this.VM + ", mRunPredictiveAnimations=" + this.VN + '}';
    }
}
