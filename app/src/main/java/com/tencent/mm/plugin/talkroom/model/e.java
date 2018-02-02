package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.mm.plugin.talkroom.a.a;
import com.tencent.mm.plugin.talkroom.a.b;
import com.tencent.mm.pluginsdk.q.l;
import com.tencent.mm.pluginsdk.q.m;
import com.tencent.mm.protocal.c.bnh;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class e implements m {
    private af handler;
    private final String path;
    private b sbf;
    private HashSet<l> sbg = new HashSet();

    public e() {
        File file = new File(b.bEE());
        if (!file.exists()) {
            file.mkdirs();
        }
        this.path = b.bEE() + "talkroomMemberList.info";
        this.handler = new af(Looper.getMainLooper());
        if (this.sbf != null) {
            return;
        }
        if (com.tencent.mm.a.e.bO(this.path)) {
            try {
                this.sbf = (b) new b().aF(com.tencent.mm.a.e.e(this.path, 0, -1));
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TalkRoomInfoListMgr", e, "", new Object[0]);
                this.sbf = new b();
                return;
            }
        }
        this.sbf = new b();
    }

    public final synchronized void a(l lVar) {
        this.sbg.add(lVar);
    }

    public final synchronized void b(l lVar) {
        this.sbg.remove(lVar);
    }

    public final synchronized boolean Mr(String str) {
        boolean z;
        Iterator it = this.sbf.saS.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.username.equals(str) && aVar.sceneType == 0) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public final synchronized boolean bEJ() {
        boolean z;
        Iterator it = this.sbf.saS.iterator();
        loop0:
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.sceneType == 0) {
                Iterator it2 = aVar.fAX.iterator();
                while (it2.hasNext()) {
                    if (q.FS().equals(((bnh) it2.next()).ksU)) {
                        z = true;
                        break loop0;
                    }
                }
                continue;
            }
        }
        z = false;
        return z;
    }

    public final synchronized LinkedList<bnh> Ms(String str) {
        LinkedList<bnh> linkedList;
        Iterator it = this.sbf.saS.iterator();
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

    public final synchronized void a(String str, LinkedList<bnh> linkedList, String str2, String str3, int i) {
        if (linkedList == null) {
            linkedList = new LinkedList();
        }
        x.i("MicroMsg.TalkRoomInfoListMgr", "updateList talk: %s,  size: %d", new Object[]{str, Integer.valueOf(linkedList.size())});
        LinkedList linkedList2 = (LinkedList) linkedList.clone();
        boolean isEmpty = linkedList2.isEmpty();
        Iterator it = this.sbf.saS.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.username.equals(str)) {
                if (isEmpty) {
                    this.sbf.saS.remove(aVar);
                } else {
                    aVar.fAX = linkedList2;
                    aVar.sceneType = i;
                }
                aVJ();
                N(str, str2, str3);
            }
        }
        if (!isEmpty) {
            aVar = new a();
            aVar.username = str;
            aVar.fAX = linkedList2;
            aVar.sceneType = i;
            this.sbf.saS.add(aVar);
        }
        aVJ();
        N(str, str2, str3);
    }

    private void N(String str, String str2, String str3) {
        Iterator it = this.sbg.iterator();
        while (it.hasNext()) {
            this.handler.post(new 1(this, (l) it.next(), str, str2, str3));
        }
    }

    private boolean aVJ() {
        if (this.sbf.saS.isEmpty()) {
            com.tencent.mm.loader.stub.b.deleteFile(this.path);
            return true;
        }
        try {
            byte[] toByteArray = this.sbf.toByteArray();
            com.tencent.mm.a.e.b(this.path, toByteArray, toByteArray.length);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomInfoListMgr", e, "", new Object[0]);
            return false;
        }
    }
}
