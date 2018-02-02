package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.t.d;
import com.tencent.mm.t.d.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Stack;

public final class g implements d<d> {
    public SparseArray<String> gBC;
    public HashMap<String, Bitmap> gBD;
    private Stack<d> gBu;
    private Stack<d> gBv;
    public int gBx;

    public final /* synthetic */ void add(Object obj) {
        a((d) obj);
    }

    public final /* synthetic */ Object pop() {
        if (this.gBu.size() > 0) {
            return (d) this.gBu.pop();
        }
        x.e("MicroMsg.MosaicCache", "[pop]");
        return null;
    }

    public final void onCreate() {
        x.i("MicroMsg.MosaicCache", "[onCreate]");
        this.gBu = new Stack();
        this.gBC = new SparseArray();
        this.gBD = new HashMap();
    }

    public final void onDestroy() {
        Iterator it;
        if (this.gBu != null) {
            it = this.gBu.iterator();
            while (it.hasNext()) {
                it.next();
                d.clear();
            }
            this.gBu.clear();
        }
        if (this.gBv != null) {
            it = this.gBv.iterator();
            while (it.hasNext()) {
                it.next();
                d.clear();
            }
            this.gBv.clear();
        }
        this.gBC.clear();
        for (Entry value : this.gBD.entrySet()) {
            Bitmap bitmap = (Bitmap) value.getValue();
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
        }
        this.gBD.clear();
    }

    public final void aY(boolean z) {
        x.i("MicroMsg.MosaicCache", "[onSave] size:%s", new Object[]{Integer.valueOf(this.gBu.size())});
        if (this.gBv != null) {
            this.gBv.clear();
        }
        this.gBv = (Stack) this.gBu.clone();
        if (z) {
            this.gBu.clear();
        }
    }

    public final void xv() {
        x.i("MicroMsg.MosaicCache", "[onRestore] size:%s", new Object[]{Integer.valueOf(this.gBu.size())});
        this.gBu.clear();
        if (this.gBv != null) {
            x.i("MicroMsg.MosaicCache", "[onRestore] %s", new Object[]{Integer.valueOf(this.gBv.size())});
            this.gBu.addAll(this.gBv);
        }
    }

    public final void a(Canvas canvas, boolean z) {
        if (!z) {
            d dVar = (this.gBu == null || this.gBu.size() <= 0) ? null : (d) this.gBu.peek();
            if (dVar != null && dVar.fjr == a.gNX) {
                dVar.draw(canvas);
            }
        }
    }

    public final void c(Canvas canvas) {
        Bitmap xC = xC();
        if (xC != null && !xC.isRecycled()) {
            canvas.drawBitmap(xC, 0.0f, 0.0f, null);
        }
    }

    public final Bitmap xC() {
        String str = (String) this.gBC.get(aZ(true));
        if (bh.ov(str)) {
            x.w("MicroMsg.MosaicCache", "[getCacheFromLocal] path is null");
            return null;
        }
        Bitmap bitmap;
        x.i("MicroMsg.MosaicCache", "[getCacheFromLocal] path:%s size:%s", new Object[]{str, Integer.valueOf(aZ(true))});
        if (this.gBD.containsKey(str)) {
            bitmap = (Bitmap) this.gBD.get(str);
        } else {
            bitmap = null;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            x.i("MicroMsg.MosaicCache", "");
            bitmap = com.tencent.mm.sdk.platformtools.d.UN(str);
            x.i("MicroMsg.MosaicCache", "[getCacheFromLocal] get from local!");
        }
        if (bitmap == null) {
            x.e("MicroMsg.MosaicCache", "[getCacheFromLocal] null == bitmap path:%s", new Object[]{str});
            return null;
        }
        Bitmap copy = bitmap.copy(Config.ARGB_8888, true);
        bitmap.recycle();
        return copy;
    }

    public final void a(d dVar) {
        if (this.gBu != null) {
            this.gBu.push(dVar);
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
