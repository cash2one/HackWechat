package com.tencent.mm.plugin.scanner.a;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.mm.g.a.nl;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends c<nl> implements a {
    private boolean mQt;
    private d pTi;
    private p pTj;

    public m() {
        this.pTi = null;
        this.mQt = false;
        this.pTj = null;
        this.xen = nl.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        nl nlVar = (nl) bVar;
        p pVar = nlVar.fFv.fFz;
        if (!this.mQt || pVar == null) {
            this.pTj = pVar;
            this.mQt = true;
            if (this.pTi == null) {
                this.pTi = new d(this, 3, false);
            }
            if (this.pTi.pWI) {
                this.pTi.bpv();
            }
            int i = nlVar.fFv.width;
            int i2 = nlVar.fFv.height;
            Rect rect = nlVar.fFv.fFx;
            byte[] bArr = nlVar.fFv.fFw;
            int i3 = nlVar.fFv.fFy;
            String str = "MicroMsg.RecogQBarInYUVListener";
            String str2 = "hy: request scanning width: %d, height: %d, scanRect: %s, yuvLen: %d, rotate: %d";
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = rect;
            objArr[3] = Integer.valueOf(bArr != null ? bArr.length : 0);
            objArr[4] = Integer.valueOf(i3);
            x.i(str, str2, objArr);
            this.pTi.otW = i3 != 0;
            this.pTi.a(bArr, new Point(i, i2), i3, rect);
        } else {
            x.w("MicroMsg.RecogQBarInYUVListener", "hy: is decoding. direct return");
            pVar.F("", -1, -1);
        }
        return false;
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
        x.i("MicroMsg.RecogQBarInYUVListener", "hy: on decode success. result type: %d, result: %s, codeType: %d, codeVersion: %d", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.pTj != null) {
            this.pTj.F(str, i2, i3);
        }
        this.mQt = false;
    }

    public final void boH() {
        x.i("MicroMsg.RecogQBarInYUVListener", "hy: on qrcode decode failed");
        if (this.pTj != null) {
            this.pTj.F("", -2, -1);
        }
        this.mQt = false;
    }

    public final void D(Bundle bundle) {
    }
}
