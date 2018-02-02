package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.ag.b;

class ag$c implements b {
    ag$c() {
    }

    public void a(NotificationManager notificationManager, String str, int i) {
        notificationManager.cancel(i);
    }

    public void a(NotificationManager notificationManager, String str, int i, Notification notification) {
        notificationManager.notify(i, notification);
    }

    public int bm() {
        return 1;
    }
}
