package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.V8Locker;
import com.eclipsesource.v8.V8ScriptException;
import com.tencent.mm.sdk.platformtools.x;

class h$1 extends Thread {
    final /* synthetic */ h jwA;

    h$1(h hVar) {
        this.jwA = hVar;
    }

    public final void run() {
        while (this.jwA.Vx) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                if (this.jwA.iqR) {
                    continue;
                } else {
                    h hVar = this.jwA;
                    synchronized (hVar.jwm) {
                        if (hVar.Vx) {
                            V8Locker locker = hVar.jwm.getLocker();
                            locker.acquire();
                            while (true) {
                                Runnable runnable = (Runnable) hVar.jwy.poll();
                                if (runnable == null) {
                                    break;
                                }
                                try {
                                    runnable.run();
                                } catch (V8ScriptException e2) {
                                    x.e("J2V8", "V8 Script Error: %s", new Object[]{e2});
                                    if (hVar.jwz != null) {
                                        hVar.jwz.aJ(e2.getJSMessage(), e2.getJSStackTrace());
                                    }
                                }
                            }
                            locker.release();
                        }
                    }
                }
            }
        }
    }
}
