package com.tencent.mm.a;

import android.os.HandlerThread;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class b {
    static af fcF;
    File fcC;
    private ReentrantLock fcD = new ReentrantLock();
    private Condition fcE = this.fcD.newCondition();

    public b(final String str) {
        synchronized (b.class) {
            if (fcF == null) {
                HandlerThread handlerThread = new HandlerThread("I/O Worker");
                handlerThread.start();
                fcF = new af(handlerThread.getLooper());
            }
        }
        File file = new File(str);
        if (file.exists()) {
            this.fcC = file;
            return;
        }
        x.i("MicroMsg.ConcurrentFileBuilder", "create new file %s", str);
        fcF.post(new Runnable(this) {
            final /* synthetic */ b fcH;

            public final void run() {
                File file = new File(str);
                if (!file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    e.bU(str);
                    x.i("MicroMsg.ConcurrentFileBuilder", "make dir last %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    currentTimeMillis = System.currentTimeMillis();
                    try {
                        file.createNewFile();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ConcurrentFileBuilder", e, "", new Object[0]);
                        x.printErrStackTrace("MicroMsg.ConcurrentFileBuilder", e, "createNewFile", new Object[0]);
                    }
                    x.i("MicroMsg.ConcurrentFileBuilder", "make file last %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                this.fcH.fcD.lock();
                try {
                    this.fcH.fcC = file;
                    this.fcH.fcE.signal();
                    x.i("MicroMsg.ConcurrentFileBuilder", "notify file prepared %s", file.getAbsoluteFile());
                } finally {
                    this.fcH.fcD.unlock();
                }
            }
        });
    }

    public final File sV() {
        this.fcD.lock();
        while (this.fcC == null) {
            try {
                x.i("MicroMsg.ConcurrentFileBuilder", "getFile await");
                this.fcE.await();
            } catch (Exception e) {
            } finally {
                this.fcD.unlock();
            }
        }
        return this.fcC;
    }
}
