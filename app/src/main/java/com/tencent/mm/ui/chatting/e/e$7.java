package com.tencent.mm.ui.chatting.e;

import android.database.Cursor;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.gridviewheaders.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Date;
import java.util.LinkedList;

class e$7 implements Runnable {
    final /* synthetic */ int htd;
    final /* synthetic */ e yHA;
    final /* synthetic */ boolean yHb;

    e$7(e eVar, boolean z, int i) {
        this.yHA = eVar;
        this.yHb = z;
        this.htd = i;
    }

    public final void run() {
        Cursor L;
        if (this.yHb) {
            e eVar;
            if (e.i(this.yHA) == -1) {
                eVar = this.yHA;
                ar.Hg();
                e.b(eVar, c.Fa().EP(e.j(this.yHA)));
            } else {
                eVar = this.yHA;
                ar.Hg();
                e.b(eVar, c.Fb().aq(e.j(this.yHA), e.i(this.yHA)));
            }
        }
        int k = (this.htd < 0 || e.k(this.yHA) - this.htd <= 200) ? 200 : e.k(this.yHA) - this.htd;
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "offset:%s limit:%s", new Object[]{Integer.valueOf(this.htd), Integer.valueOf(k)});
        LinkedList linkedList = new LinkedList();
        if (e.i(this.yHA) == -1) {
            ar.Hg();
            L = c.Fa().L(e.j(this.yHA), e.a(this.yHA).size() - e.l(this.yHA), k);
        } else {
            ar.Hg();
            L = c.Fb().b(e.j(this.yHA), e.i(this.yHA), e.a(this.yHA).size() - e.l(this.yHA), k);
        }
        if (L == null) {
            x.e("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] NULL == cursor ");
            return;
        }
        cf auVar;
        long j = 0;
        while (L.moveToNext()) {
            try {
                long b;
                auVar = new au();
                auVar.b(L);
                b = a.cxk().b(new Date(auVar.field_createTime));
                if (j != b) {
                    linkedList.add(new com.tencent.mm.ui.chatting.a.a.c(auVar.field_createTime));
                    e.m(this.yHA);
                }
                linkedList.add(new com.tencent.mm.ui.chatting.a.a.c(auVar));
                j = b;
            } finally {
                L.close();
            }
        }
        LinkedList linkedList2 = new LinkedList();
        if (linkedList.size() - e.l(this.yHA) == k) {
            Cursor k2;
            long j2 = ((com.tencent.mm.ui.chatting.a.a.c) linkedList.get(0)).hOG;
            a.cxk();
            b = a.gr(j2);
            x.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] list size:%s start:%s end:%s", new Object[]{Integer.valueOf(linkedList.size()), Long.valueOf(b), Long.valueOf(j2)});
            if (e.i(this.yHA) == -1) {
                ar.Hg();
                k2 = c.Fa().k(e.j(this.yHA), b, j2);
            } else {
                ar.Hg();
                k2 = c.Fb().a(e.j(this.yHA), e.i(this.yHA), b, j2);
            }
            Date date = new Date(j2);
            b = a.cxk().b(date);
            while (k2 != null) {
                try {
                    if (!k2.moveToNext()) {
                        break;
                    }
                    auVar = new au();
                    auVar.b(k2);
                    j2 = a.cxk().b(new Date(auVar.field_createTime));
                    if (b != j2 && a.cxk().b(date) != j2) {
                        linkedList2.add(new com.tencent.mm.ui.chatting.a.a.c(auVar.field_createTime));
                        e.m(this.yHA);
                        b = j2;
                    } else if (linkedList.size() > 0 && linkedList2.size() == 0) {
                        linkedList2.add(0, linkedList.remove(0));
                    }
                    linkedList2.add(new com.tencent.mm.ui.chatting.a.a.c(auVar));
                } catch (Throwable th) {
                    if (k2 != null) {
                        k2.close();
                    }
                }
            }
            if (k2 != null) {
                k2.close();
            }
        }
        int size = linkedList.size() + linkedList2.size();
        e.a(this.yHA).addAll(0, linkedList2);
        e.a(this.yHA).addAll(linkedList2.size(), linkedList);
        linkedList.clear();
        linkedList2.clear();
        e.n(this.yHA);
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] %s", new Object[]{Integer.valueOf(e.a(this.yHA).size())});
        ag.y(new 1(this, size));
    }
}
