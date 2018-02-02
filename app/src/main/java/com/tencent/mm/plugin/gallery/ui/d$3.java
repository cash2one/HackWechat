package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mm.plugin.gallery.model.j;
import com.tencent.mm.sdk.platformtools.as.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class d$3 implements a {
    final /* synthetic */ d mTI;
    private Bitmap mTJ = null;
    final /* synthetic */ String mTK;

    d$3(d dVar, String str) {
        this.mTI = dVar;
        this.mTK = str;
    }

    public final boolean JC() {
        this.mTI.mTH = false;
        if (this.mTI.mTB.containsKey(this.mTK)) {
            int intValue = ((Integer) this.mTI.mTB.get(this.mTK)).intValue();
            if (this.mTI.aOu()) {
                d.a(this.mTI, intValue, this.mTJ);
            } else {
                this.mTI.mTD.put(intValue, this.mTJ);
            }
        }
        this.mTI.mTE.l(this.mTK, this.mTJ);
        this.mTJ = null;
        this.mTI.aOv();
        return false;
    }

    public final boolean JB() {
        if (this.mTI.mTG == null || TextUtils.isEmpty(this.mTK)) {
            return false;
        }
        String str = this.mTK;
        long Wq = bh.Wq();
        Bitmap Bv = j.Bv(str);
        x.v("MicroMsg.ImageAdapter", "test decode: %d filePath:%s", new Object[]{Long.valueOf(bh.bA(Wq)), str});
        this.mTJ = Bv;
        return true;
    }
}
