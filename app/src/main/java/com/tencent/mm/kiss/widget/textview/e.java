package com.tencent.mm.kiss.widget.textview;

import android.text.Layout.Alignment;
import android.text.TextPaint;

public final class e {
    private final d[] gTK = new d[3];
    private final Object mLock = new Object();
    private int wt;

    public final d Ed() {
        d dVar = null;
        synchronized (this.mLock) {
            if (this.wt > 0) {
                int i = this.wt - 1;
                dVar = this.gTK[i];
                this.gTK[i] = null;
                this.wt--;
            }
        }
        return dVar;
    }

    public final boolean a(d dVar) {
        synchronized (this.mLock) {
            boolean z;
            for (int i = 0; i < this.wt; i++) {
                if (this.gTK[i] == dVar) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                throw new IllegalStateException("Already in the pool!");
            }
            dVar.gTx = null;
            dVar.gTy = null;
            dVar.gTz = 0;
            dVar.gTA = 0;
            dVar.gTB = new TextPaint();
            dVar.width = 0;
            dVar.gTC = Alignment.ALIGN_NORMAL;
            dVar.gravity = 51;
            dVar.gTD = null;
            dVar.gTE = 0;
            dVar.maxLines = Integer.MAX_VALUE;
            dVar.gTF = null;
            dVar.gTG = 0.0f;
            dVar.gTH = 1.0f;
            dVar.gTI = false;
            dVar.maxLength = 0;
            dVar.gTJ = null;
            if (this.wt < this.gTK.length) {
                this.gTK[this.wt] = dVar;
                this.wt++;
                return true;
            }
            return false;
        }
    }
}
