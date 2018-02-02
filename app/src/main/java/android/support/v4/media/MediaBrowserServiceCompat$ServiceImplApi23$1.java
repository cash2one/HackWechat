package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.os.ResultReceiver;

class MediaBrowserServiceCompat$ServiceImplApi23$1 extends ResultReceiver {
    protected final void onReceiveResult(int i, Bundle bundle) {
        MediaBrowserCompat$MediaItem mediaBrowserCompat$MediaItem = (MediaBrowserCompat$MediaItem) bundle.getParcelable("media_item");
        if (mediaBrowserCompat$MediaItem != null) {
            mediaBrowserCompat$MediaItem.writeToParcel(Parcel.obtain(), 0);
        }
    }
}
