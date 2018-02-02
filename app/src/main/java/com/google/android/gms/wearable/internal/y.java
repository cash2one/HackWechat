package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.wearable.internal.an.f;
import com.google.android.gms.wearable.internal.x.a;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class y<T> {
    private final Map<T, ap<T>> beM = new HashMap();

    y() {
    }

    public final void a(ao aoVar) {
        synchronized (this.beM) {
            v fVar = new f();
            for (Entry entry : this.beM.entrySet()) {
                ap apVar = (ap) entry.getValue();
                if (apVar != null) {
                    apVar.bfi = null;
                    apVar.bfj = null;
                    apVar.bfk = null;
                    apVar.bfl = null;
                    apVar.bfm = null;
                    apVar.bfn = null;
                    apVar.bfo = null;
                    apVar.bfp = null;
                    if (aoVar.isConnected()) {
                        try {
                            ((x) aoVar.oK()).a(fVar, new RemoveListenerRequest(apVar));
                            if (Log.isLoggable("WearableClient", 2)) {
                                new StringBuilder("disconnect: removed: ").append(entry.getKey()).append("/").append(apVar);
                            }
                        } catch (RemoteException e) {
                            new StringBuilder("disconnect: Didn't remove: ").append(entry.getKey()).append("/").append(apVar);
                        }
                    } else {
                        continue;
                    }
                }
            }
            this.beM.clear();
        }
    }

    public final void u(IBinder iBinder) {
        synchronized (this.beM) {
            x t = a.t(iBinder);
            v fVar = new f();
            for (Entry entry : this.beM.entrySet()) {
                ap apVar = (ap) entry.getValue();
                try {
                    t.a(fVar, new AddListenerRequest(apVar));
                    if (Log.isLoggable("WearableClient", 2)) {
                        new StringBuilder("onPostInitHandler: added: ").append(entry.getKey()).append("/").append(apVar);
                    }
                } catch (RemoteException e) {
                    new StringBuilder("onPostInitHandler: Didn't add: ").append(entry.getKey()).append("/").append(apVar);
                }
            }
        }
    }
}
