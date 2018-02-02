package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.t.e;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public final class c implements d<com.tencent.mm.t.c> {
    public Stack<com.tencent.mm.t.c> gBu;
    public Stack<com.tencent.mm.t.c> gBv;
    private int gBx;

    public final /* synthetic */ void add(Object obj) {
        a((com.tencent.mm.t.c) obj);
    }

    public final /* synthetic */ Object pop() {
        return xy();
    }

    public final void onCreate() {
        x.i("MicroMsg.EmojiAndTextCache", "[onCreate]");
        this.gBu = new Stack();
    }

    public final void onDestroy() {
        Iterator it;
        x.i("MicroMsg.EmojiAndTextCache", "[onDestroy]");
        if (this.gBu != null) {
            it = this.gBu.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.t.c) it.next()).clear();
            }
            this.gBu.clear();
        }
        if (this.gBv != null) {
            it = this.gBv.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.t.c) it.next()).clear();
            }
            this.gBv.clear();
        }
    }

    public final void aY(boolean z) {
        x.i("MicroMsg.EmojiAndTextCache", "[onSave] size:%s isExit:%s", new Object[]{Integer.valueOf(this.gBu.size()), Boolean.valueOf(z)});
        if (this.gBv != null) {
            this.gBv.clear();
        }
        this.gBv = new Stack();
        Iterator it = this.gBu.iterator();
        while (it.hasNext()) {
            this.gBv.push(((com.tencent.mm.t.c) it.next()).BM());
        }
        x.i("MicroMsg.EmojiAndTextCache", "[onSave] mLastStack size:%s", new Object[]{Integer.valueOf(this.gBv.size())});
        if (z) {
            this.gBu.clear();
            it = this.gBv.iterator();
            while (it.hasNext()) {
                com.tencent.mm.t.c cVar = (com.tencent.mm.t.c) it.next();
                x.d("MicroMsg.EmojiItem", "[recycleBitmap]");
                if (!(cVar.gNE == null || cVar.gNE.isRecycled())) {
                    cVar.gNE.recycle();
                }
            }
        }
    }

    public final void xv() {
        x.i("MicroMsg.EmojiAndTextCache", "[onRestore] size:%s isExit:%s", new Object[]{Integer.valueOf(this.gBu.size()), Boolean.valueOf(false)});
        this.gBu.clear();
        if (this.gBv != null) {
            x.i("MicroMsg.EmojiAndTextCache", "[onRestore] %s", new Object[]{Integer.valueOf(this.gBv.size())});
            this.gBu.addAll(this.gBv);
        }
        x.i("MicroMsg.EmojiAndTextCache", "[onRestore] mCurStack size:%s ", new Object[]{Integer.valueOf(this.gBu.size())});
        Iterator it = this.gBu.iterator();
        while (it.hasNext()) {
            ((com.tencent.mm.t.c) it.next()).BH();
        }
    }

    public final void a(Canvas canvas, boolean z) {
        com.tencent.mm.t.c cVar;
        if (z) {
            canvas.drawColor(0, Mode.CLEAR);
            Iterator it = this.gBu.iterator();
            while (it.hasNext()) {
                cVar = (com.tencent.mm.t.c) it.next();
                if (!cVar.gNI) {
                    cVar.draw(canvas);
                }
            }
            return;
        }
        cVar = xz();
        if (cVar != null && !cVar.gNI) {
            cVar.draw(canvas);
        }
    }

    public final void c(Canvas canvas) {
        Iterator it = this.gBu.iterator();
        while (it.hasNext()) {
            com.tencent.mm.t.c cVar = (com.tencent.mm.t.c) it.next();
            cVar.setSelected(false);
            cVar.draw(canvas);
        }
    }

    public final com.tencent.mm.t.c xy() {
        return (com.tencent.mm.t.c) this.gBu.pop();
    }

    public final com.tencent.mm.t.c xz() {
        if (this.gBu == null || this.gBu.size() <= 0) {
            return null;
        }
        return (com.tencent.mm.t.c) this.gBu.peek();
    }

    public final void a(com.tencent.mm.t.c cVar) {
        if (this.gBu != null) {
            this.gBu.push(cVar);
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

    public final void b(com.tencent.mm.t.c cVar) {
        if (cVar != null) {
            this.gBu.remove(this.gBu.indexOf(cVar));
            this.gBu.push(cVar);
        }
    }

    public final ListIterator<com.tencent.mm.t.c> xA() {
        return this.gBu.listIterator(this.gBu.size());
    }

    public final int[] xB() {
        int[] iArr = new int[2];
        if (this.gBv != null) {
            Iterator it = this.gBv.iterator();
            while (it.hasNext()) {
                if (((com.tencent.mm.t.c) it.next()) instanceof e) {
                    iArr[1] = iArr[1] + 1;
                } else {
                    iArr[0] = iArr[0] + 1;
                }
            }
        }
        return iArr;
    }
}
