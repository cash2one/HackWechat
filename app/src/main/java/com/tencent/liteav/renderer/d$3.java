package com.tencent.liteav.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import java.nio.ByteBuffer;

class d$3 implements Runnable {
    final /* synthetic */ ByteBuffer a;
    final /* synthetic */ Bitmap b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ d e;

    d$3(d dVar, ByteBuffer byteBuffer, Bitmap bitmap, int i, int i2) {
        this.e = dVar;
        this.a = byteBuffer;
        this.b = bitmap;
        this.c = i;
        this.d = i2;
    }

    public void run() {
        this.a.position(0);
        this.b.copyPixelsFromBuffer(this.a);
        Matrix matrix = new Matrix();
        matrix.setScale(1.0f, -1.0f);
        Bitmap createBitmap = Bitmap.createBitmap(this.b, 0, 0, this.c, this.d, matrix, false);
        if (d.b(this.e) != null) {
            d.b(this.e).onTakePhotoComplete(createBitmap);
            d.a(this.e, null);
        }
        this.b.recycle();
    }
}
