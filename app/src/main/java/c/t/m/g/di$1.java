package c.t.m.g;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import c.t.m.g.di.a;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

class di$1 implements Runnable {
    private /* synthetic */ Handler a;
    private /* synthetic */ di b;

    di$1(di diVar, Handler handler) {
        this.b = diVar;
        this.a = handler;
    }

    public final void run() {
        a aVar;
        Looper looper;
        this.b.a.clear();
        di diVar = this.b;
        Handler handler = this.a;
        LinkedBlockingQueue linkedBlockingQueue = diVar.a;
        a aVar2 = null;
        while (diVar.g) {
            try {
                aVar = (a) linkedBlockingQueue.take();
                try {
                    if (a.d != aVar) {
                        int length;
                        new StringBuilder("request:").append(aVar.b);
                        long currentTimeMillis = System.currentTimeMillis();
                        Bundle a = diVar.b.a(a.c(aVar), a.a(aVar));
                        String string = a.getString("result");
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        new StringBuilder("cost:").append(currentTimeMillis2).append("request:").append(string);
                        diVar.c++;
                        diVar.d += (long) a.a(aVar).length;
                        byte[] a2 = j.a(string.getBytes());
                        long j = diVar.e;
                        if (a2 != null) {
                            length = a2.length;
                        } else {
                            length = 0;
                        }
                        diVar.e = j + ((long) length);
                        Message obtainMessage = handler.obtainMessage();
                        obtainMessage.arg1 = (int) currentTimeMillis2;
                        aVar.c = currentTimeMillis;
                        if (!diVar.h && diVar.g && handler.getLooper().getThread().isAlive() && 1 == a.b(aVar)) {
                            obtainMessage.obj = Pair.create(string, aVar);
                            obtainMessage.what = 4999;
                            obtainMessage.sendToTarget();
                        }
                        if (a.b(aVar) == 1 && diVar.b.b.o == 0) {
                            diVar.b.b.o = currentTimeMillis2;
                            diVar.b.b.p = a.getString("req_key");
                        }
                        aVar2 = aVar;
                    } else {
                        return;
                    }
                } catch (InterruptedException e) {
                    aVar2 = aVar;
                } catch (IOException e2) {
                    new StringBuilder("cost:").append(System.currentTimeMillis() - 0).append(",run: io error");
                    diVar.b(aVar);
                    looper = handler != null ? handler.getLooper() : null;
                    handler.sendEmptyMessageDelayed(4998, 0);
                    aVar2 = aVar;
                } catch (Throwable th) {
                    aVar2 = aVar;
                }
            } catch (InterruptedException e3) {
                aVar = aVar2;
                aVar2 = aVar;
            } catch (IOException e4) {
                aVar = aVar2;
                new StringBuilder("cost:").append(System.currentTimeMillis() - 0).append(",run: io error");
                diVar.b(aVar);
                if (handler != null) {
                }
                if (looper != null && looper.getThread().isAlive()) {
                    handler.sendEmptyMessageDelayed(4998, 0);
                }
                aVar2 = aVar;
            } catch (Throwable th2) {
                aVar = aVar2;
                aVar2 = aVar;
            }
        }
    }
}
