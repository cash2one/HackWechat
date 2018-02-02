package android.support.v4.media;

import android.os.IBinder;
import android.support.v4.media.MediaBrowserServiceCompat.g;

class MediaBrowserServiceCompat$g$6 implements Runnable {
    final /* synthetic */ MediaBrowserServiceCompat$d uM;
    final /* synthetic */ g uQ;

    MediaBrowserServiceCompat$g$6(g gVar, MediaBrowserServiceCompat$d mediaBrowserServiceCompat$d) {
        this.uQ = gVar;
        this.uM = mediaBrowserServiceCompat$d;
    }

    public final void run() {
        IBinder asBinder = this.uM.asBinder();
        MediaBrowserServiceCompat.b(this.uQ.uz).remove(asBinder);
        MediaBrowserServiceCompat$b mediaBrowserServiceCompat$b = new MediaBrowserServiceCompat$b(this.uQ.uz);
        mediaBrowserServiceCompat$b.uE = this.uM;
        MediaBrowserServiceCompat.b(this.uQ.uz).put(asBinder, mediaBrowserServiceCompat$b);
    }
}
