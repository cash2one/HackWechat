package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;

class ag$d extends ag$c {
    ag$d() {
    }

    public final void a(NotificationManager notificationManager, String str, int i) {
        notificationManager.cancel(null, i);
    }

    public final void a(NotificationManager notificationManager, String str, int i, Notification notification) {
        notificationManager.notify(null, i, notification);
    }
}
