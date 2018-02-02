package com.tencent.mm.booter.notification.queue;

import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.k.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public final class NotificationQueue {
    public ParcelNotificationQueue gAm;

    private void save() {
        if (this.gAm != null) {
            x.d("MicroMsg.NotificationCustomQueue", "jacks save: %d", new Object[]{Integer.valueOf(this.gAm.size())});
            if (this.gAm.isEmpty()) {
                f.zm().edit().putString("com.tencent.preference.notification.queue", "").apply();
                if (this.gAm == null) {
                    restore();
                }
                x.d("MicroMsg.NotificationCustomQueue", "jacks _reset: %d", new Object[]{Integer.valueOf(this.gAm.size())});
            }
        }
    }

    public final synchronized void restore() {
        x.d("MicroMsg.NotificationCustomQueue", "jacks _restore");
        if (this.gAm == null) {
            this.gAm = new ParcelNotificationQueue();
        }
        x.d("MicroMsg.NotificationCustomQueue", "jacks _restore: %d", new Object[]{Integer.valueOf(this.gAm.size())});
    }

    public final synchronized boolean c(NotificationItem notificationItem) {
        boolean remove;
        if (this.gAm == null) {
            restore();
        }
        remove = this.gAm.remove(notificationItem);
        if (remove) {
            save();
        }
        return remove;
    }

    public final synchronized NotificationItem fq(int i) {
        NotificationItem notificationItem;
        if (this.gAm == null) {
            restore();
        }
        Iterator it = this.gAm.iterator();
        while (it.hasNext()) {
            notificationItem = (NotificationItem) it.next();
            if (notificationItem.id == i) {
                break;
            }
        }
        notificationItem = null;
        if (notificationItem != null && this.gAm.remove(notificationItem)) {
            save();
        }
        return notificationItem;
    }

    public final synchronized boolean d(NotificationItem notificationItem) {
        boolean add;
        if (this.gAm == null) {
            restore();
        }
        add = this.gAm.add(notificationItem);
        if (add) {
            save();
        }
        return add;
    }
}
