package android.support.v4.media;

import android.app.Service;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.e.a;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import java.util.ArrayList;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    private final a<IBinder, b> ut = new a();
    private final f uu = new f(this, (byte) 0);
    Token uv;

    private class g {
        final /* synthetic */ MediaBrowserServiceCompat uz;

        private g(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            this.uz = mediaBrowserServiceCompat;
        }
    }

    public abstract a bu();

    static /* synthetic */ void a(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, b bVar, Bundle bundle) {
        List list = (List) bVar.uG.get(str);
        List<Bundle> arrayList = list == null ? new ArrayList() : list;
        for (Bundle a : arrayList) {
            if (a.a(bundle, a)) {
                return;
            }
        }
        arrayList.add(bundle);
        bVar.uG.put(str, arrayList);
        c 1 = new 1(mediaBrowserServiceCompat, str, bVar, str, bundle);
        if (bundle != null) {
            1.ur = 1;
        }
        if (!1.isDone()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + bVar.uC + " id=" + str);
        }
    }

    static /* synthetic */ void a(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, ResultReceiver resultReceiver) {
        c 2 = new 2(mediaBrowserServiceCompat, str, resultReceiver);
        if (2.uJ) {
            throw new IllegalStateException("sendResult() called twice for: " + 2.uH);
        }
        2.uJ = true;
        2.a(null, 2.ur);
        if (!2.isDone()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }

    static /* synthetic */ boolean a(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, int i) {
        if (str == null) {
            return false;
        }
        for (String equals : mediaBrowserServiceCompat.getPackageManager().getPackagesForUid(i)) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean a(String str, b bVar, Bundle bundle) {
        List<Bundle> list = (List) bVar.uG.get(str);
        if (list == null) {
            return false;
        }
        boolean z;
        for (Bundle bundle2 : list) {
            if (a.a(bundle, bundle2)) {
                list.remove(bundle2);
                z = true;
                break;
            }
        }
        z = false;
        if (list.size() != 0) {
            return z;
        }
        bVar.uG.remove(str);
        return z;
    }
}
