package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import android.support.v4.app.ac.b;
import android.support.v4.app.z.d;
import android.support.v4.app.z.i;
import com.tencent.wcdb.FileUtils;

class z$l implements i {
    z$l() {
    }

    public Notification b(d dVar) {
        Notification notification = dVar.sx;
        notification.setLatestEventInfo(dVar.mContext, dVar.rY, dVar.rZ, dVar.sa);
        if (dVar.mPriority > 0) {
            notification.flags |= FileUtils.S_IWUSR;
        }
        return notification;
    }

    public Bundle a(Notification notification) {
        return null;
    }

    public Bundle a(b bVar) {
        return null;
    }
}
