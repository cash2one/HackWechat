package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.location.a.a;
import com.tencent.mm.plugin.location.a.b;
import com.tencent.mm.pluginsdk.q.q;
import com.tencent.mm.pluginsdk.q.r;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p implements r {
    private List<q> avD = new LinkedList();
    private af handler;
    private b nSa;
    private final String path;

    public p() {
        File file = new File(l.aVy());
        if (!file.exists()) {
            file.mkdirs();
        }
        this.path = l.aVy() + "trackroominfolist.info";
        this.handler = new af(Looper.getMainLooper());
        if (this.nSa != null) {
            return;
        }
        if (e.bO(this.path)) {
            try {
                this.nSa = (b) new b().aF(e.e(this.path, 0, -1));
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TrackRoomListMgr", e, "", new Object[0]);
                this.nSa = new b();
                return;
            }
        }
        this.nSa = new b();
    }

    public final synchronized void a(q qVar) {
        this.avD.add(qVar);
    }

    public final synchronized void b(q qVar) {
        this.avD.remove(qVar);
    }

    public final synchronized LinkedList<String> DA(String str) {
        LinkedList<String> linkedList;
        Iterator it = this.nSa.nQu.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.username.equals(str)) {
                linkedList = (LinkedList) aVar.fAX.clone();
                break;
            }
        }
        linkedList = new LinkedList();
        return linkedList;
    }

    public final synchronized a DB(String str) {
        a aVar;
        Iterator it = this.nSa.nQu.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar.username.equals(str)) {
                break;
            }
        }
        aVar = null;
        return aVar;
    }

    public final synchronized void a(String str, LinkedList<String> linkedList, double d, double d2, String str2, String str3, String str4) {
        if (linkedList == null) {
            linkedList = new LinkedList();
        }
        x.i("MicroMsg.TrackRoomListMgr", "updateList talk: %s,  size: %d %f %f", new Object[]{str, Integer.valueOf(linkedList.size()), Double.valueOf(d), Double.valueOf(d2)});
        LinkedList linkedList2 = (LinkedList) linkedList.clone();
        boolean isEmpty = linkedList2.isEmpty();
        Iterator it = this.nSa.nQu.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.username.equals(str)) {
                if (isEmpty) {
                    this.nSa.nQu.remove(aVar);
                } else {
                    aVar.fAX = linkedList2;
                    aVar.nQt = str2;
                    aVar.latitude = d;
                    aVar.longitude = d2;
                }
                aVJ();
                N(str, str3, str4);
            }
        }
        if (!isEmpty) {
            aVar = new a();
            aVar.username = str;
            aVar.fAX = linkedList2;
            aVar.nQt = str2;
            aVar.latitude = d;
            aVar.longitude = d2;
            this.nSa.nQu.add(aVar);
        }
        aVJ();
        N(str, str3, str4);
    }

    private void N(String str, String str2, String str3) {
        for (final q qVar : this.avD) {
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            this.handler.post(new Runnable(this) {
                final /* synthetic */ p nSe;

                public final void run() {
                    qVar.Rl(str4);
                }
            });
        }
    }

    private boolean aVJ() {
        x.d("MicroMsg.TrackRoomListMgr", "infoFile infolist size %d", new Object[]{Integer.valueOf(this.nSa.nQu.size())});
        if (this.nSa.nQu.isEmpty()) {
            com.tencent.mm.loader.stub.b.deleteFile(this.path);
            return true;
        }
        try {
            byte[] toByteArray = this.nSa.toByteArray();
            e.b(this.path, toByteArray, toByteArray.length);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TrackRoomListMgr", e, "", new Object[0]);
            return false;
        }
    }

    public final boolean DC(String str) {
        return DA(str).size() > 0;
    }

    public final boolean aVK() {
        Iterator it = this.nSa.nQu.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            x.d("MicroMsg.TrackRoomListMgr", "info :" + aVar.fAX.size());
            Iterator it2 = aVar.fAX.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                x.d("MicroMsg.TrackRoomListMgr", "member :" + str);
                if (str.equals(com.tencent.mm.z.q.FS())) {
                    x.i("MicroMsg.TrackRoomListMgr", "now is sharing location..");
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean de(String str, String str2) {
        return DA(str).contains(str2);
    }

    public final String aVL() {
        if (this.nSa != null) {
            return this.nSa.nQv;
        }
        return "";
    }

    public final void DD(String str) {
        if (this.nSa != null) {
            this.nSa.nQv = str;
        }
        aVJ();
    }
}
