package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.support.v7.widget.RecyclerView;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class e$9 implements a {
    final /* synthetic */ e tVw;

    e$9(e eVar) {
        this.tVw = eVar;
    }

    public final boolean uF() {
        boolean z;
        x.d("NoteSelectManager", "onTimerExpired: ");
        RecyclerView a = e.a(this.tVw);
        boolean z2 = e.c(this.tVw) != null && e.c(this.tVw).tUD < ((float) e.a(this.tVw, a));
        if (e.c(this.tVw) == null || e.c(this.tVw).tUD <= ((float) e.d(this.tVw))) {
            z = false;
        } else {
            z = true;
        }
        if (e.cq() && a != null && e.c(this.tVw) != null && e.c(this.tVw).getType() == 1 && (z2 || z)) {
            if (z2 && a.canScrollVertically(-1)) {
                if (e.c(this.tVw).kTK == 3) {
                    e.e(this.tVw);
                }
                e.f(this.tVw);
                this.tVw.bXn();
                this.tVw.bXl();
                a.smoothScrollBy(0, -300);
            } else if (z && a.canScrollVertically(1)) {
                e.f(this.tVw);
                this.tVw.bXn();
                this.tVw.bXl();
                a.smoothScrollBy(0, 300);
            }
        } else if (e.g(this.tVw) != null) {
            e.g(this.tVw).TG();
        }
        return true;
    }
}
