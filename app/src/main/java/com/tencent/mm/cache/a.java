package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Stack;

public final class a implements d<com.tencent.mm.t.a> {
    public Stack<com.tencent.mm.t.a> gBu;
    private Stack<com.tencent.mm.t.a> gBv;
    public Matrix gBw = new Matrix();
    private int gBx;

    public final /* synthetic */ void add(Object obj) {
        a((com.tencent.mm.t.a) obj);
    }

    public final /* synthetic */ Object pop() {
        return xw();
    }

    public final void onCreate() {
        x.i("MicroMsg.CropCache", "[onCreate]");
        this.gBu = new Stack();
    }

    public final void onDestroy() {
        if (this.gBu != null) {
            this.gBu.clear();
        }
        if (this.gBv != null) {
            this.gBv.clear();
        }
        this.gBw.reset();
    }

    public final void aY(boolean z) {
        x.i("MicroMsg.CropCache", "[onSave] size:%s", new Object[]{Integer.valueOf(this.gBu.size())});
        if (this.gBv != null) {
            this.gBv.clear();
        }
        this.gBv = (Stack) this.gBu.clone();
        if (z) {
            this.gBu.clear();
        }
    }

    public final void xv() {
        x.i("MicroMsg.CropCache", "[onRestore] size:%s", new Object[]{Integer.valueOf(this.gBu.size())});
        this.gBu.clear();
        if (this.gBv != null) {
            x.i("MicroMsg.CropCache", "[onRestore] %s", new Object[]{Integer.valueOf(this.gBv.size())});
            this.gBu.addAll(this.gBv);
        }
    }

    public final void a(Canvas canvas, boolean z) {
    }

    public final void c(Canvas canvas) {
    }

    public final com.tencent.mm.t.a xw() {
        if (this.gBu.size() > 0) {
            return (com.tencent.mm.t.a) this.gBu.pop();
        }
        x.e("MicroMsg.CropCache", "[pop]");
        return null;
    }

    public final void a(com.tencent.mm.t.a aVar) {
        if (this.gBu != null) {
            this.gBu.push(aVar);
        }
    }

    public final com.tencent.mm.t.a xx() {
        if (this.gBu == null || this.gBu.size() <= 0) {
            return null;
        }
        return (com.tencent.mm.t.a) this.gBu.peek();
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
