package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;

public final class MediaBrowserCompat {

    private static class ItemReceiver extends ResultReceiver {
        protected final void onReceiveResult(int i, Bundle bundle) {
            bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            if (i == 0 && bundle != null && bundle.containsKey("media_item")) {
                bundle.getParcelable("media_item");
            }
        }
    }
}
