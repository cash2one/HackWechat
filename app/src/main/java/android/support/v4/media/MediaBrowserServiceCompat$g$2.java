package android.support.v4.media;

import android.support.v4.media.MediaBrowserServiceCompat.d;
import android.support.v4.media.MediaBrowserServiceCompat.g;

class MediaBrowserServiceCompat$g$2 implements Runnable {
    final /* synthetic */ d uM;
    final /* synthetic */ g uQ;

    MediaBrowserServiceCompat$g$2(g gVar, d dVar) {
        this.uQ = gVar;
        this.uM = dVar;
    }

    public final void run() {
        MediaBrowserServiceCompat.b(this.uQ.uz).remove(this.uM.asBinder());
    }
}
