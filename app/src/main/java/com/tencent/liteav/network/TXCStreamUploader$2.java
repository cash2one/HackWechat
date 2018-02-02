package com.tencent.liteav.network;

import com.tencent.liteav.basic.f.b;
import java.util.Iterator;

class TXCStreamUploader$2 extends Thread {
    final /* synthetic */ boolean a;
    final /* synthetic */ String b;
    final /* synthetic */ TXCStreamUploader c;

    TXCStreamUploader$2(TXCStreamUploader tXCStreamUploader, String str, boolean z, String str2) {
        this.c = tXCStreamUploader;
        this.a = z;
        this.b = str2;
        super(str);
    }

    public void run() {
        while (TXCStreamUploader.access$200(this.c) != 0) {
            try {
                sleep(100, 0);
            } catch (InterruptedException e) {
            }
        }
        synchronized (TXCStreamUploader.access$300(this.c)) {
            TXCStreamUploader.access$402(this.c, this.a);
            TXCStreamUploader tXCStreamUploader = this.c;
            TXCStreamUploader tXCStreamUploader2 = this.c;
            String access$500 = TXCStreamUploader.access$500(this.c);
            String str = this.b;
            boolean z = this.a;
            int i = TXCStreamUploader.access$600(this.c).e;
            int i2 = TXCStreamUploader.access$600(this.c).d;
            int i3 = TXCStreamUploader.access$600(this.c).a;
            int i4 = TXCStreamUploader.access$600(this.c).c;
            int i5 = TXCStreamUploader.access$600(this.c).h;
            int i6 = TXCStreamUploader.access$600(this.c).m ? this.a ? 3 : 2 : 1;
            TXCStreamUploader.access$202(tXCStreamUploader, TXCStreamUploader.access$700(tXCStreamUploader2, access$500, str, z, i, i2, i3, i4, i5, 16, i6));
            if (TXCStreamUploader.access$200(this.c) != 0) {
                TXCStreamUploader.access$800(this.c, TXCStreamUploader.access$200(this.c), TXCStreamUploader.access$600(this.c).j, TXCStreamUploader.access$600(this.c).h, TXCStreamUploader.access$600(this.c).i);
                Object obj = null;
                Iterator it = TXCStreamUploader.access$900(this.c).iterator();
                while (it.hasNext()) {
                    Object obj2;
                    b bVar = (b) it.next();
                    if (obj == null && bVar.b == 0) {
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                    if (obj2 != null) {
                        if (TXCStreamUploader.access$1000(this.c) == 0) {
                            TXCStreamUploader.access$1002(this.c, bVar.h - 3600000);
                        }
                        TXCStreamUploader.access$1100(this.c, TXCStreamUploader.access$200(this.c), bVar.a, bVar.b, bVar.e, bVar.g - TXCStreamUploader.access$1000(this.c), bVar.h - TXCStreamUploader.access$1000(this.c));
                    }
                    obj = obj2;
                }
                TXCStreamUploader.access$900(this.c).removeAllElements();
            }
        }
        TXCStreamUploader.access$1200(this.c, TXCStreamUploader.access$200(this.c));
        synchronized (TXCStreamUploader.access$300(this.c)) {
            TXCStreamUploader.access$1300(this.c, TXCStreamUploader.access$200(this.c));
            TXCStreamUploader.access$202(this.c, 0);
        }
    }
}
