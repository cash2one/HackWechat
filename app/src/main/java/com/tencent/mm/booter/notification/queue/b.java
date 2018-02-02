package com.tencent.mm.booter.notification.queue;

import android.os.Build.VERSION;
import android.support.v4.app.ag;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class b implements Iterable<NotificationItem> {
    public NotificationQueue gAn;
    public a gAo;
    public int mark;

    private static final class a {
        private static final b gAp = new b();
    }

    public static final b xi() {
        return a.gAp;
    }

    private b() {
        this.mark = -1;
        this.gAn = new NotificationQueue();
        this.gAo = new a();
        restore();
    }

    public final void restore() {
        this.gAn.restore();
        this.gAo.restore();
    }

    public final int size() {
        NotificationQueue notificationQueue = this.gAn;
        if (notificationQueue.gAm == null) {
            notificationQueue.restore();
        }
        return notificationQueue.gAm.size();
    }

    public final NotificationItem xj() {
        for (int i = 0; i < size(); i++) {
            NotificationQueue notificationQueue = this.gAn;
            if (notificationQueue.gAm == null) {
                notificationQueue.restore();
            }
            NotificationItem notificationItem = (NotificationItem) notificationQueue.gAm.get(i);
            if (notificationItem.gAe) {
                if (this.gAo.aV(notificationItem.id)) {
                    x.d("MicroMsg.NotificationAppMsgQueue", "remove: [%s]", new Object[]{notificationItem.toString()});
                }
                this.gAn.c(notificationItem);
                return notificationItem;
            }
        }
        return null;
    }

    public final void remove(int i) {
        this.gAo.aV(i);
        NotificationItem fq = this.gAn.fq(i);
        if (fq != null) {
            fq.clear();
        }
    }

    public final Queue<Integer> xk() {
        Queue<Integer> linkedList = new LinkedList();
        for (int i = 4097; i < 4102; i++) {
            linkedList.add(Integer.valueOf(i));
        }
        linkedList.addAll(xl());
        return linkedList;
    }

    private Queue<Integer> xl() {
        Queue<Integer> linkedList = new LinkedList();
        Queue<NotificationItem> linkedList2 = new LinkedList();
        NotificationQueue notificationQueue = this.gAn;
        if (notificationQueue.gAm == null) {
            notificationQueue.restore();
        }
        linkedList2.addAll(notificationQueue.gAm);
        for (NotificationItem notificationItem : linkedList2) {
            if (notificationItem.gAe) {
                linkedList.add(Integer.valueOf(notificationItem.id));
                x.d("MicroMsg.Notification.Queue", "remove allcustom: %d", new Object[]{Integer.valueOf(notificationItem.id)});
            }
        }
        linkedList2.clear();
        Queue<com.tencent.mm.booter.notification.queue.a.a> linkedList3 = new LinkedList();
        a aVar = this.gAo;
        if (aVar.gAj == null) {
            aVar.restore();
        }
        linkedList3.addAll(aVar.gAj);
        for (com.tencent.mm.booter.notification.queue.a.a aVar2 : linkedList3) {
            if (aVar2.gAe) {
                linkedList.add(Integer.valueOf(aVar2.gAk));
                x.d("MicroMsg.Notification.Queue", "remove allcustom: %d", new Object[]{Integer.valueOf(aVar2.gAk)});
            }
        }
        linkedList3.clear();
        return linkedList;
    }

    public final int getId(String str) {
        if (t.ov(str)) {
            return -1;
        }
        Iterator it = this.gAo.iterator();
        while (it.hasNext()) {
            com.tencent.mm.booter.notification.queue.a.a aVar = (com.tencent.mm.booter.notification.queue.a.a) it.next();
            if (aVar.userName.equals(str)) {
                return aVar.gAk;
            }
        }
        return -1;
    }

    public final void cancel(int i) {
        a(ag.j(ac.getContext()), i);
    }

    public final void a(ag agVar, int i) {
        ag.ta.a(agVar.sX, null, i);
        if (VERSION.SDK_INT <= 19) {
            agVar.a(new android.support.v4.app.ag.a(agVar.mContext.getPackageName(), i, null));
        }
        remove(i);
    }

    public final int er(String str) {
        int id = getId(str);
        return id > 0 ? id : aX(true);
    }

    public final int aX(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = this.gAo.iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + ((com.tencent.mm.booter.notification.queue.a.a) it.next()).gAk + ",";
        }
        int i = z ? 4097 : 4102;
        while (str.contains(String.valueOf(i))) {
            i++;
        }
        if (i >= 4102 && z) {
            i = 4097;
        }
        x.d("MicroMsg.Notification.Queue", "create id spend: %d, id: %d, isCustomControl: %B", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(i), Boolean.valueOf(z)});
        return i;
    }

    public final Iterator<NotificationItem> iterator() {
        NotificationQueue notificationQueue = this.gAn;
        if (notificationQueue.gAm == null) {
            notificationQueue.restore();
        }
        return notificationQueue.gAm.iterator();
    }
}
