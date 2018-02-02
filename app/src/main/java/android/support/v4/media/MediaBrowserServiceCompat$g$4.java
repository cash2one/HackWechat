package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserServiceCompat.g;

class MediaBrowserServiceCompat$g$4 implements Runnable {
    final /* synthetic */ MediaBrowserServiceCompat$d uM;
    final /* synthetic */ g uQ;
    final /* synthetic */ String uR;
    final /* synthetic */ Bundle uy;

    MediaBrowserServiceCompat$g$4(g gVar, MediaBrowserServiceCompat$d mediaBrowserServiceCompat$d, String str, Bundle bundle) {
        this.uQ = gVar;
        this.uM = mediaBrowserServiceCompat$d;
        this.uR = str;
        this.uy = bundle;
    }

    public final void run() {
        MediaBrowserServiceCompat$b mediaBrowserServiceCompat$b = (MediaBrowserServiceCompat$b) MediaBrowserServiceCompat.b(this.uQ.uz).get(this.uM.asBinder());
        if (mediaBrowserServiceCompat$b == null) {
            new StringBuilder("removeSubscription for callback that isn't registered id=").append(this.uR);
        } else if (!MediaBrowserServiceCompat.a(this.uR, mediaBrowserServiceCompat$b, this.uy)) {
            new StringBuilder("removeSubscription called for ").append(this.uR).append(" which is not subscribed");
        }
    }
}
