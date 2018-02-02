package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserServiceCompat.b;
import android.support.v4.media.MediaBrowserServiceCompat.d;
import android.support.v4.media.MediaBrowserServiceCompat.g;

class MediaBrowserServiceCompat$g$3 implements Runnable {
    final /* synthetic */ d uM;
    final /* synthetic */ g uQ;
    final /* synthetic */ String uR;
    final /* synthetic */ Bundle uy;

    MediaBrowserServiceCompat$g$3(g gVar, d dVar, String str, Bundle bundle) {
        this.uQ = gVar;
        this.uM = dVar;
        this.uR = str;
        this.uy = bundle;
    }

    public final void run() {
        b bVar = (b) MediaBrowserServiceCompat.b(this.uQ.uz).get(this.uM.asBinder());
        if (bVar == null) {
            new StringBuilder("addSubscription for callback that isn't registered id=").append(this.uR);
        } else {
            MediaBrowserServiceCompat.a(this.uQ.uz, this.uR, bVar, this.uy);
        }
    }
}
