package com.tencent.mm.plugin.appbrand.r.a;

import java.nio.ByteBuffer;
import javax.net.ssl.SSLException;

class a$a implements Runnable {
    final /* synthetic */ a jTB;

    private a$a(a aVar) {
        this.jTB = aVar;
    }

    public final void run() {
        while (!Thread.interrupted()) {
            ByteBuffer byteBuffer;
            try {
                byteBuffer = (ByteBuffer) this.jTB.jTr.jTb.take();
                this.jTB.jTu.write(byteBuffer.array(), 0, byteBuffer.limit());
                this.jTB.jTu.flush();
            } catch (InterruptedException e) {
                try {
                    for (ByteBuffer byteBuffer2 : this.jTB.jTr.jTb) {
                        this.jTB.jTu.write(byteBuffer2.array(), 0, byteBuffer2.limit());
                        this.jTB.jTu.flush();
                    }
                } catch (Exception e2) {
                    a aVar = this.jTB;
                    if (e2 instanceof SSLException) {
                        aVar.b(e2);
                    }
                    aVar.jTr.alP();
                    return;
                } finally {
                    a.d(this.jTB);
                }
            }
        }
        a.d(this.jTB);
    }
}
