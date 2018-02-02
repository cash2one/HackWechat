package android.support.design.widget;

import android.support.v4.view.z;
import android.view.View;

class BottomSheetBehavior$b implements Runnable {
    final /* synthetic */ BottomSheetBehavior fy;
    private final int fz;
    private final View mView;

    public BottomSheetBehavior$b(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
        this.fy = bottomSheetBehavior;
        this.mView = view;
        this.fz = i;
    }

    public final void run() {
        if (BottomSheetBehavior.j(this.fy) == null || !BottomSheetBehavior.j(this.fy).cL()) {
            BottomSheetBehavior.b(this.fy, this.fz);
        } else {
            z.a(this.mView, (Runnable) this);
        }
    }
}
