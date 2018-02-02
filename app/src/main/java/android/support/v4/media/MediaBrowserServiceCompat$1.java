package android.support.v4.media;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserServiceCompat.b;
import java.util.List;

class MediaBrowserServiceCompat$1 extends MediaBrowserServiceCompat$c<List<MediaBrowserCompat$MediaItem>> {
    final /* synthetic */ b uw;
    final /* synthetic */ String ux;
    final /* synthetic */ Bundle uy;
    final /* synthetic */ MediaBrowserServiceCompat uz;

    MediaBrowserServiceCompat$1(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj, b bVar, String str, Bundle bundle) {
        this.uz = mediaBrowserServiceCompat;
        this.uw = bVar;
        this.ux = str;
        this.uy = bundle;
        super(obj);
    }

    final /* synthetic */ void a(Object obj, int i) {
        List list = null;
        if (MediaBrowserServiceCompat.b(this.uz).get(this.uw.uE.asBinder()) == this.uw) {
            List list2;
            if ((i & 1) != 0) {
                Bundle bundle = this.uy;
                int i2 = bundle.getInt("android.media.browse.extra.PAGE", -1);
                int i3 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                if (!(i2 == -1 && i3 == -1)) {
                    int i4 = i3 * (i2 - 1);
                    int i5 = i4 + i3;
                    if (i2 <= 0 || i3 <= 0 || i4 >= list.size()) {
                        list2 = list;
                        this.uw.uE.a(this.ux, list2, this.uy);
                    }
                    if (i5 > list.size()) {
                        i5 = list.size();
                    }
                    list2 = list.subList(i4, i5);
                    this.uw.uE.a(this.ux, list2, this.uy);
                }
            }
            list2 = list;
            try {
                this.uw.uE.a(this.ux, list2, this.uy);
            } catch (RemoteException e) {
                new StringBuilder("Calling onLoadChildren() failed for id=").append(this.ux).append(" package=").append(this.uw.uC);
            }
        }
    }
}
