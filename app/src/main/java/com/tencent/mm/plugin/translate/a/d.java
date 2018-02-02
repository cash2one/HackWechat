package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.translate.a.c.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;

public final class d implements e {
    public int index;
    public SparseArray<c> sgj = null;
    public boolean sgk = false;
    public b sgl;
    a sgm;
    public ak sgn = new ak(new 1(this), false);
    long start;

    public d(int i, a aVar) {
        this.index = i;
        this.sgm = aVar;
    }

    public final void bFB() {
        this.sgl = null;
        this.sgk = false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.sgl != kVar) {
            x.e("MicroMsg.WorkingTranslate", "not my translate work");
            return;
        }
        int size;
        this.sgn.TG();
        x.d("MicroMsg.WorkingTranslate", "translate take time : %s", Long.valueOf(System.currentTimeMillis() - this.start));
        String str2 = "MicroMsg.WorkingTranslate";
        String str3 = "errType : %s, errCode : %s, errMsg : %s, translatedMsg.size() : %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        if (((b) kVar).sgb != null) {
            size = ((b) kVar).sgb.size();
        } else {
            size = 0;
        }
        objArr[3] = Integer.valueOf(size);
        x.d(str2, str3, objArr);
        bFB();
        this.sgm.a(i2, this.sgj, ((b) kVar).sgb);
    }
}
