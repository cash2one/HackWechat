package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserServiceCompat.b;
import android.support.v4.media.MediaBrowserServiceCompat.d;
import android.support.v4.media.MediaBrowserServiceCompat.g;

class MediaBrowserServiceCompat$g$1 implements Runnable {
    final /* synthetic */ d uM;
    final /* synthetic */ String uN;
    final /* synthetic */ Bundle uO;
    final /* synthetic */ int uP;
    final /* synthetic */ g uQ;

    MediaBrowserServiceCompat$g$1(g gVar, d dVar, String str, Bundle bundle, int i) {
        this.uQ = gVar;
        this.uM = dVar;
        this.uN = str;
        this.uO = bundle;
        this.uP = i;
    }

    public final void run() {
        IBinder asBinder = this.uM.asBinder();
        MediaBrowserServiceCompat.b(this.uQ.uz).remove(asBinder);
        b bVar = new b(this.uQ.uz, (byte) 0);
        bVar.uC = this.uN;
        bVar.uD = this.uO;
        bVar.uE = this.uM;
        bVar.uF = this.uQ.uz.bu();
        if (bVar.uF == null) {
            new StringBuilder("No root for client ").append(this.uN).append(" from service ").append(getClass().getName());
            try {
                this.uM.bv();
                return;
            } catch (RemoteException e) {
                new StringBuilder("Calling onConnectFailed() failed. Ignoring. pkg=").append(this.uN);
                return;
            }
        }
        try {
            MediaBrowserServiceCompat.b(this.uQ.uz).put(asBinder, bVar);
            if (this.uQ.uz.uv != null) {
                this.uM.a(bVar.uF.uB, this.uQ.uz.uv, bVar.uF.mExtras);
            }
        } catch (RemoteException e2) {
            new StringBuilder("Calling onConnect() failed. Dropping client. pkg=").append(this.uN);
            MediaBrowserServiceCompat.b(this.uQ.uz).remove(asBinder);
        }
    }
}
