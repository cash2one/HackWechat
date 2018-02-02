package android.support.v4.media;

import android.support.v4.media.MediaBrowserServiceCompat.g;
import android.support.v4.os.ResultReceiver;

class MediaBrowserServiceCompat$g$5 implements Runnable {
    final /* synthetic */ ResultReceiver uA;
    final /* synthetic */ g uQ;
    final /* synthetic */ String uS;

    MediaBrowserServiceCompat$g$5(g gVar, String str, ResultReceiver resultReceiver) {
        this.uQ = gVar;
        this.uS = str;
        this.uA = resultReceiver;
    }

    public final void run() {
        MediaBrowserServiceCompat.a(this.uQ.uz, this.uS, this.uA);
    }
}
