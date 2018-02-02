package com.tencent.mm.ipcinvoker;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.mm.ipcinvoker.b.a.a;
import com.tencent.mm.ipcinvoker.b.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseIPCService extends Service {
    private volatile boolean gMb;
    private volatile boolean gMc;
    private a gMd = new a(this) {
        final /* synthetic */ BaseIPCService gMe;

        {
            this.gMe = r1;
        }

        public final void a(Bundle bundle, String str, b bVar) {
            if (str == null || str.length() == 0) {
                x.e("IPC.BaseIPCService", "invokeAsync failed, class is null or nil.");
                return;
            }
            a aVar = (a) o.d(str, a.class);
            if (aVar == null) {
                x.e("IPC.BaseIPCService", "invokeAsync failed, can not newInstance by class %s.", new Object[]{str});
                return;
            }
            if (bundle != null) {
                bundle.setClassLoader(BaseIPCService.class.getClassLoader());
            }
            n.post(new 1(this, aVar, bundle, bVar));
        }

        public final Bundle d(Bundle bundle, String str) {
            if (str == null || str.length() == 0) {
                x.e("IPC.BaseIPCService", "invokeAsync failed, class is null or nil.");
                return null;
            }
            l lVar = (l) o.d(str, l.class);
            if (lVar == null) {
                x.e("IPC.BaseIPCService", "invokeSync failed, can not newInstance by class %s.", new Object[]{str});
                return null;
            }
            if (bundle != null) {
                bundle.setClassLoader(BaseIPCService.class.getClassLoader());
            }
            return lVar.j(bundle);
        }
    };

    public abstract String Br();

    public IBinder onBind(Intent intent) {
        x.i("IPC.BaseIPCService", "onBind(%s), killSelf(%s)", new Object[]{intent, Boolean.valueOf(this.gMb)});
        if (this.gMb) {
            x.i("IPC.BaseIPCService", "need to kill self, return null Binder object.");
            return null;
        }
        k Bv = k.Bv();
        String Bu = e.Bu();
        if (!(Bu == null || Bu.length() == 0 || this == null)) {
            Bv.gMH.put(Bu, this);
        }
        this.gMc = true;
        return this.gMd;
    }

    public boolean onUnbind(Intent intent) {
        x.i("IPC.BaseIPCService", "onUnbind(%s)", new Object[]{intent});
        boolean onUnbind = super.onUnbind(intent);
        this.gMc = false;
        return onUnbind;
    }

    public final void bs(boolean z) {
        if (!this.gMc || z) {
            x.i("IPC.BaseIPCService", "kill self(%s)", new Object[]{Br()});
            this.gMb = true;
            b.Bs().Bt();
            b Bs = b.Bs();
            x.i("IPC.IPCBridgeManager", "releaseAllIPCBridge");
            if (!Bs.gMl.isEmpty()) {
                synchronized (Bs.gMl) {
                    if (Bs.gMl.isEmpty()) {
                    } else {
                        Set<String> hashSet = new HashSet(Bs.gMl.keySet());
                        if (!hashSet.isEmpty()) {
                            for (String fg : hashSet) {
                                Bs.fg(fg);
                            }
                        }
                    }
                }
            }
            stopSelf();
            k Bv = k.Bv();
            Bv.gMH.remove(Br());
            n.h(new 2(this));
            return;
        }
        x.i("IPC.BaseIPCService", "abort kill self(%s), the service was connected by other process.", new Object[]{Br()});
    }
}
