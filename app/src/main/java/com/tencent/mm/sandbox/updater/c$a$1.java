package com.tencent.mm.sandbox.updater;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sandbox.updater.c.a;
import com.tencent.mm.sdk.platformtools.af;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class c$a$1 extends OutputStream {
    private af handler = new af(Looper.getMainLooper());
    private ByteArrayOutputStream xcO = new ByteArrayOutputStream();
    final /* synthetic */ a xcP;

    c$a$1(a aVar) {
        this.xcP = aVar;
    }

    public final void write(byte[] bArr, int i, int i2) {
        this.xcO.write(bArr, i, i2);
        if (this.xcO.size() >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || a.a(this.xcP) + this.xcO.size() >= a.b(this.xcP)) {
            int size = this.xcO.size();
            int a = e.a(this.xcP.xcI.baW(), this.xcO.toByteArray(), size);
            this.xcO.reset();
            if (a != 0) {
                throw new IOException("appendToFile failed :" + a);
            }
            a.a(this.xcP, a.a(this.xcP) + size);
            this.handler.post(new 1(this, size));
            if (this.xcP.xcI.hEW) {
                throw new IOException("manual force cancel!");
            }
        }
    }

    public final void write(int i) {
        throw new IOException("unexpected operation");
    }
}
