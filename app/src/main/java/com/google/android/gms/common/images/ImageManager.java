package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.c.l;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public final class ImageManager {
    private static final Object aMC = new Object();
    private static HashSet<Uri> aMD = new HashSet();
    private final ExecutorService aME;
    private final b aMF;
    private final l aMG;
    private final Map<a, ImageReceiver> aMH;
    private final Map<Uri, ImageReceiver> aMI;
    private final Map<Uri, Long> aMJ;
    private final Context mContext;
    private final Handler mHandler;

    public interface a {
    }

    private final class c implements Runnable {
        private final Uri aMK;
        final /* synthetic */ ImageManager aMM;
        private final ParcelFileDescriptor aMN;

        public c(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.aMM = imageManager;
            this.aMK = uri;
            this.aMN = parcelFileDescriptor;
        }

        public final void run() {
            String str = "LoadBitmapFromDiskRunnable can't be executed in the main thread";
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                new StringBuilder("checkNotMainThread: current thread ").append(Thread.currentThread()).append(" IS the main thread ").append(Looper.getMainLooper().getThread()).append("!");
                throw new IllegalStateException(str);
            }
            boolean z = false;
            Bitmap bitmap = null;
            if (this.aMN != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.aMN.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    new StringBuilder("OOM while loading bitmap for uri: ").append(this.aMK);
                    z = true;
                }
                try {
                    this.aMN.close();
                } catch (IOException e2) {
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.aMM.mHandler.post(new d(this.aMM, this.aMK, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                new StringBuilder("Latch interrupted while posting ").append(this.aMK);
            }
        }
    }
}
