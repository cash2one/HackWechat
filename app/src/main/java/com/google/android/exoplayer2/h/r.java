package com.google.android.exoplayer2.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.t;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class r {
    final ExecutorService aBH;
    b<? extends c> aBI;
    IOException atf;

    public interface c {
        void kq();

        boolean kr();

        void ks();
    }

    private static final class e extends Handler implements Runnable {
        private final d aBR;

        public e(d dVar) {
            this.aBR = dVar;
        }

        public final void run() {
            sendEmptyMessage(0);
        }

        public final void handleMessage(Message message) {
            this.aBR.kB();
        }
    }

    public r(String str) {
        this.aBH = t.ag(str);
    }

    public final <T extends c> long a(T t, a<T> aVar, int i) {
        Looper myLooper = Looper.myLooper();
        a.an(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new b(this, myLooper, t, aVar, i, elapsedRealtime).start(0);
        return elapsedRealtime;
    }

    public final boolean ic() {
        return this.aBI != null;
    }

    public final void ly() {
        this.aBI.al(false);
    }

    public final boolean a(d dVar) {
        boolean z = false;
        if (this.aBI != null) {
            this.aBI.al(true);
            if (dVar != null) {
                this.aBH.execute(new e(dVar));
            }
        } else if (dVar != null) {
            dVar.kB();
            z = true;
        }
        this.aBH.shutdown();
        return z;
    }

    public final void kc() {
        if (this.atf != null) {
            throw this.atf;
        } else if (this.aBI != null) {
            b bVar = this.aBI;
            int i = this.aBI.aBL;
            if (bVar.aBN != null && bVar.aBO > i) {
                throw bVar.aBN;
            }
        }
    }
}
