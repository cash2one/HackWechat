package com.tencent.mm.platformtools;

import android.graphics.Bitmap;
import com.tencent.mm.platformtools.j.b;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.as.a;
import com.tencent.mm.sdk.platformtools.x;

class j$b$b implements a {
    public Bitmap hkT = null;
    private i icq;

    public j$b$b(i iVar) {
        if (j.c(iVar)) {
            this.icq = iVar;
            return;
        }
        throw new IllegalArgumentException("from sdcard, picture strategy here must be validity");
    }

    public final boolean JB() {
        boolean z = false;
        this.hkT = b.op(this.icq.Wf());
        if (this.hkT != null) {
            this.hkT = b.ici.a(this.icq, this.hkT);
        }
        String str = "MicroMsg.MMPictureLogic";
        String str2 = "get url[%s] from[%s] result[%B]";
        Object[] objArr = new Object[3];
        objArr[0] = this.icq.Wg();
        objArr[1] = this.icq.Wf();
        if (this.hkT != null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
        return true;
    }

    public final boolean JC() {
        if (this.hkT == null) {
            x.d("MicroMsg.MMPictureLogic", "can not find bitmap on sdCard, url=%s, try to download it", new Object[]{this.icq.Wg()});
            if (b.a(b.ici) == null || b.a(b.ici).cfT()) {
                b.a(b.ici, new as(1, "readerapp-pic-logic-download", 3));
            }
            b.a(b.ici).c(new b.a(this.icq));
        } else {
            b.a(b.ici, this.icq.Wg(), this.icq.Wh(), this.hkT);
            this.hkT = null;
        }
        return false;
    }
}
