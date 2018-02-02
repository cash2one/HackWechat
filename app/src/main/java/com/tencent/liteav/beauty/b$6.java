package com.tencent.liteav.beauty;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.b.v;

class b$6 implements Runnable {
    final /* synthetic */ Bitmap a;
    final /* synthetic */ float b;
    final /* synthetic */ float c;
    final /* synthetic */ float d;
    final /* synthetic */ b e;

    b$6(b bVar, Bitmap bitmap, float f, float f2, float f3) {
        this.e = bVar;
        this.a = bitmap;
        this.b = f;
        this.c = f2;
        this.d = f3;
    }

    public void run() {
        if (this.a != null) {
            a.a().e();
        }
        if (this.a == null) {
            TXCLog.i("TXCFilterDrawer", "Cancel WaterMark");
            if (b.b(this.e) != null) {
                b.b(this.e).d();
                b.a(this.e, null);
                return;
            }
            return;
        }
        if (b.b(this.e) == null) {
            if (b.c(this.e) <= 0 || b.d(this.e) <= 0) {
                TXCLog.e("TXCFilterDrawer", "output Width and Height is error!");
                return;
            }
            b.a(this.e, new v());
            b.b(this.e).a(true);
            if (b.b(this.e).a()) {
                b.b(this.e).a(b.c(this.e), b.d(this.e));
            } else {
                TXCLog.e("TXCFilterDrawer", "mWatermarkFilter.init failed!");
                b.b(this.e).d();
                b.a(this.e, null);
                return;
            }
        }
        b.b(this.e).c(true);
        b.b(this.e).a(this.a, this.b, this.c, this.d);
    }
}
