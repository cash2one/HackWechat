package com.tencent.mm.booter.notification.queue;

import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.k.f;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a implements Serializable, Iterable<a> {
    LinkedList<a> gAj;

    public static class a implements Serializable {
        public long fqm = -1;
        public boolean gAe = false;
        public int gAk;
        public int gAl = 0;
        public int gzM;
        public String userName = "";

        public a(int i, long j, String str, int i2, boolean z, int i3) {
            a(i, j, str, i2, z, i3);
        }

        public a(int i, boolean z) {
            this.gAk = i;
            this.gAe = z;
        }

        public final void a(int i, long j, String str, int i2, boolean z, int i3) {
            this.gAk = i;
            this.fqm = j;
            this.userName = str;
            this.gzM = i2;
            this.gAe = z;
            this.gAl = i3;
        }

        public final String toString() {
            return this.userName + " id:" + this.fqm + " unReadCount:" + this.gzM + "　notificationId:" + this.gAk;
        }
    }

    public final String toString() {
        Iterator it = this.gAj.iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + ((a) it.next()).toString() + ";  ";
        }
        return str;
    }

    public final synchronized void restore() {
        try {
            this.gAj = (LinkedList) c.es(f.zm().getString("com.tencent.preference.notification.key.queue", ""));
            if (this.gAj == null) {
                this.gAj = new LinkedList();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NotificationAppMsgQueue", e, "", new Object[0]);
            if (this.gAj == null) {
                this.gAj = new LinkedList();
            }
        } catch (Throwable th) {
            if (this.gAj == null) {
                this.gAj = new LinkedList();
            }
        }
        x.i("MicroMsg.NotificationAppMsgQueue", "restore size:%d, %s", new Object[]{Integer.valueOf(this.gAj.size()), toString()});
    }

    private synchronized void save() {
        if (this.gAj != null) {
            x.d("MicroMsg.NotificationAppMsgQueue", "save: size: %d", new Object[]{Integer.valueOf(this.gAj.size())});
            if (this.gAj.isEmpty()) {
                f.zm().edit().putString("com.tencent.preference.notification.key.queue", "").apply();
                x.i("MicroMsg.NotificationAppMsgQueue", "reset size:%d, %s", new Object[]{Integer.valueOf(this.gAj.size()), toString()});
            } else {
                try {
                    f.zm().edit().putString("com.tencent.preference.notification.key.queue", c.a(new LinkedList(this.gAj))).apply();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NotificationAppMsgQueue", e, "", new Object[0]);
                }
                x.i("MicroMsg.NotificationAppMsgQueue", "save size:%d, %s", new Object[]{Integer.valueOf(this.gAj.size()), toString()});
            }
        }
    }

    public final synchronized void b(NotificationItem notificationItem) {
        Object obj = 1;
        synchronized (this) {
            if (notificationItem != null) {
                if (this.gAj == null) {
                    restore();
                }
                aV(notificationItem.id);
                if (!notificationItem.gAe || t.ov(notificationItem.gAb)) {
                    this.gAj.add(new a(notificationItem.id, notificationItem.gAe));
                    x.d("MicroMsg.NotificationAppMsgQueue", "add: [%s]", new Object[]{notificationItem.toString()});
                } else {
                    Iterator it = this.gAj.iterator();
                    while (it.hasNext()) {
                        Object obj2;
                        a aVar = (a) it.next();
                        if (aVar.userName.equals(notificationItem.gAb)) {
                            aVar.a(notificationItem.id, notificationItem.gAc, notificationItem.gAb, notificationItem.gAd, notificationItem.gAe, notificationItem.gAf);
                            obj2 = null;
                        } else {
                            obj2 = obj;
                        }
                        obj = obj2;
                    }
                    if (obj != null) {
                        this.gAj.add(new a(notificationItem.id, notificationItem.gAc, notificationItem.gAb, notificationItem.gAd, notificationItem.gAe, notificationItem.gAf));
                        x.d("MicroMsg.NotificationAppMsgQueue", "add: [%s]", new Object[]{notificationItem.toString()});
                    }
                }
                save();
            }
        }
    }

    public final synchronized List<Integer> fp(int i) {
        List<Integer> arrayList;
        if (this.gAj == null) {
            restore();
        }
        arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!((aVar.gAl & i) == 0 || arrayList.contains(Integer.valueOf(aVar.gAk)))) {
                arrayList.add(Integer.valueOf(aVar.gAk));
            }
        }
        return arrayList;
    }

    public final synchronized boolean aV(int i) {
        boolean z;
        if (i == -1) {
            z = false;
        } else {
            if (this.gAj == null) {
                restore();
            }
            LinkedList linkedList = new LinkedList();
            Iterator it = this.gAj.iterator();
            Object obj = null;
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.gAk != i) {
                    linkedList.add(aVar);
                } else {
                    obj = 1;
                }
            }
            if (obj != null) {
                this.gAj = linkedList;
                save();
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean eq(String str) {
        boolean z;
        x.i("MicroMsg.NotificationAppMsgQueue", "remove username: %s", new Object[]{str});
        if (t.ov(str)) {
            z = false;
        } else {
            if (this.gAj == null) {
                restore();
            }
            Iterator it = this.gAj.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (str.equals(aVar.userName)) {
                    this.gAj.remove(aVar);
                    save();
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    public final Iterator<a> iterator() {
        if (this.gAj == null) {
            restore();
        }
        return this.gAj.iterator();
    }
}
