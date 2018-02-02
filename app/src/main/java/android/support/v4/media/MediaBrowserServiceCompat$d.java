package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.session.MediaSessionCompat.Token;
import java.util.List;

interface MediaBrowserServiceCompat$d {
    void a(String str, Token token, Bundle bundle);

    void a(String str, List<MediaItem> list, Bundle bundle);

    IBinder asBinder();

    void bv();
}
