package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.common.images.a.a;
import com.google.android.gms.common.images.a.b;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

final class ImageManager$d implements Runnable {
    private final CountDownLatch aKy;
    private final Uri aMK;
    final /* synthetic */ ImageManager aMM;
    private boolean aMO;
    private final Bitmap mBitmap;

    public ImageManager$d(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
        this.aMM = imageManager;
        this.aMK = uri;
        this.mBitmap = bitmap;
        this.aMO = z;
        this.aKy = countDownLatch;
    }

    private void a(ImageManager$ImageReceiver imageManager$ImageReceiver, boolean z) {
        ArrayList a = imageManager$ImageReceiver.aML;
        int size = a.size();
        for (int i = 0; i < size; i++) {
            a aVar = (a) a.get(i);
            if (z) {
                aVar.a(ImageManager.b(this.aMM), this.mBitmap);
            } else {
                ImageManager.d(this.aMM).put(this.aMK, Long.valueOf(SystemClock.elapsedRealtime()));
                aVar.a(ImageManager.b(this.aMM), ImageManager.c(this.aMM));
            }
            if (!(aVar instanceof b)) {
                ImageManager.a(this.aMM).remove(aVar);
            }
        }
    }

    public final void run() {
        String str = "OnBitmapLoadedRunnable must be executed in the main thread";
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            new StringBuilder("checkMainThread: current thread ").append(Thread.currentThread()).append(" IS NOT the main thread ").append(Looper.getMainLooper().getThread()).append("!");
            throw new IllegalStateException(str);
        }
        boolean z = this.mBitmap != null;
        if (ImageManager.h(this.aMM) != null) {
            if (this.aMO) {
                ImageManager.h(this.aMM).trimToSize(-1);
                System.gc();
                this.aMO = false;
                ImageManager.g(this.aMM).post(this);
                return;
            } else if (z) {
                ImageManager.h(this.aMM).put(new a(this.aMK), this.mBitmap);
            }
        }
        ImageManager$ImageReceiver imageManager$ImageReceiver = (ImageManager$ImageReceiver) ImageManager.e(this.aMM).remove(this.aMK);
        if (imageManager$ImageReceiver != null) {
            a(imageManager$ImageReceiver, z);
        }
        this.aKy.countDown();
        synchronized (ImageManager.oB()) {
            ImageManager.oC().remove(this.aMK);
        }
    }
}
