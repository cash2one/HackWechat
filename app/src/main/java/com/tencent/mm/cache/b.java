package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.Stack;

public final class b implements d<com.tencent.mm.t.b> {
    private Stack<com.tencent.mm.t.b> gBu;
    public Stack<com.tencent.mm.t.b> gBv;
    public int gBx;

    public final /* synthetic */ void add(Object obj) {
        com.tencent.mm.t.b bVar = (com.tencent.mm.t.b) obj;
        if (this.gBu != null) {
            this.gBu.push(bVar);
        }
    }

    public final /* synthetic */ Object pop() {
        return this.gBu.size() <= 0 ? null : (com.tencent.mm.t.b) this.gBu.pop();
    }

    public final void onCreate() {
        this.gBu = new Stack();
    }

    public final void onDestroy() {
        x.i("MicroMsg.DoodleCache", "[onDestroy]");
        if (this.gBu != null) {
            this.gBu.clear();
        }
        if (this.gBv != null) {
            this.gBv.clear();
        }
    }

    public final void aY(boolean z) {
        x.i("MicroMsg.DoodleCache", "[onSave] size:%s", new Object[]{Integer.valueOf(this.gBu.size())});
        if (this.gBv != null) {
            this.gBv.clear();
        }
        this.gBv = (Stack) this.gBu.clone();
        if (z) {
            this.gBu.clear();
        }
    }

    public final void xv() {
        x.i("MicroMsg.DoodleCache", "[onRestore] size:%s", new Object[]{Integer.valueOf(this.gBu.size())});
        this.gBu.clear();
        if (this.gBv != null) {
            x.i("MicroMsg.DoodleCache", "[onRestore] %s", new Object[]{Integer.valueOf(this.gBv.size())});
            this.gBu.addAll(this.gBv);
        }
    }

    public final void a(Canvas canvas, boolean z) {
        if (z) {
            canvas.drawColor(0, Mode.CLEAR);
            Iterator it = this.gBu.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.t.b) it.next()).draw(canvas);
            }
            return;
        }
        com.tencent.mm.t.b bVar = (this.gBu == null || this.gBu.size() <= 0) ? null : (com.tencent.mm.t.b) this.gBu.peek();
        if (bVar != null) {
            bVar.draw(canvas);
        }
    }

    public final void c(Canvas canvas) {
        Iterator it = this.gBu.iterator();
        while (it.hasNext()) {
            ((com.tencent.mm.t.b) it.next()).draw(canvas);
        }
    }

    public final int aZ(boolean z) {
        if (z) {
            if (this.gBu != null) {
                return this.gBu.size();
            }
            return 0;
        } else if (this.gBv != null) {
            return this.gBv.size();
        } else {
            return 0;
        }
    }

    public final void uP() {
        this.gBx++;
    }
}
