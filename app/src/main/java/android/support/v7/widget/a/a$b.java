package android.support.v7.widget.a;

import android.support.v4.view.o;
import android.support.v7.widget.RecyclerView$t;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

class a$b extends SimpleOnGestureListener {
    final /* synthetic */ a aaZ;

    private a$b(a aVar) {
        this.aaZ = aVar;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        View p = this.aaZ.p(motionEvent);
        if (p != null) {
            RecyclerView$t aP = this.aaZ.Va.aP(p);
            if (aP != null && a$a.a(this.aaZ.aaM, this.aaZ.Va, aP) && o.c(motionEvent, 0) == this.aaZ.fu) {
                int b = o.b(motionEvent, this.aaZ.fu);
                float d = o.d(motionEvent, b);
                float e = o.e(motionEvent, b);
                this.aaZ.aaE = d;
                this.aaZ.aaF = e;
                a aVar = this.aaZ;
                this.aaZ.aaJ = 0.0f;
                aVar.aaI = 0.0f;
                this.aaZ.aaM.hi();
                this.aaZ.d(aP, 2);
            }
        }
    }
}
