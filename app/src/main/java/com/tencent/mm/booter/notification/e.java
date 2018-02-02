package com.tencent.mm.booter.notification;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.ag;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import java.util.Queue;

public final class e extends a {
    public c gzZ = new c();
    private Context mContext = ac.getContext();
    private NotificationManager sX = ((NotificationManager) this.mContext.getSystemService("notification"));

    public static void cancel() {
        ag j = ag.j(ac.getContext());
        Queue linkedList = new LinkedList();
        for (Integer num : b.xi().xk()) {
            if (!linkedList.contains(num)) {
                b.xi().a(j, num.intValue());
                linkedList.add(num);
            }
        }
    }
}
