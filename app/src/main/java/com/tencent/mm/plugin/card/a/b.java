package com.tencent.mm.plugin.card.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.ak;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.s;
import com.tencent.mm.plugin.card.model.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b implements e {
    public byte[] gSF = new byte[0];
    public List<ak> kIs = am.auB().aux();
    public List<ak> kIt = new ArrayList();
    private s kIu;
    public List<WeakReference<d>> kIv = new ArrayList();

    public b() {
        x.i("MicroMsg.BatchGetCardMgr", "<init>, init pending list size = %d", new Object[]{Integer.valueOf(this.kIs.size())});
        ar.CG().a(559, this);
    }

    public final void detach() {
        this.kIs.clear();
        this.kIt.clear();
        if (this.kIu != null) {
            ar.CG().c(this.kIu);
        }
        ar.CG().b(559, this);
    }

    public final void atO() {
        if (this.kIs.size() == 0) {
            x.i("MicroMsg.BatchGetCardMgr", "getNow, no pending cardinfo ,no need to get");
        } else if (this.kIu != null) {
            x.i("MicroMsg.BatchGetCardMgr", "getNow, already doing scene, not trigger now");
        } else {
            LinkedList linkedList = new LinkedList();
            if (this.kIs.size() <= 10) {
                linkedList.addAll(this.kIs);
            } else {
                linkedList.addAll(this.kIs.subList(0, 10));
            }
            this.kIu = new s(linkedList);
            ar.CG().a(this.kIu, 0);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 0;
        x.i("MicroMsg.BatchGetCardMgr", "onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.kIu = null;
        List<ak> list = ((s) kVar).kLT;
        al auB;
        if (i == 0 && i2 == 0) {
            String str2 = "MicroMsg.BatchGetCardMgr";
            String str3 = "onSceneEnd, batch get succ, remove succ id list, size = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
            x.i(str2, str3, objArr);
            if (list != null) {
                synchronized (this.gSF) {
                    this.kIs.removeAll(list);
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            ar.Hg();
            long dz = c.EV().dz(Thread.currentThread().getId());
            auB = am.auB();
            if (list == null || list.size() == 0) {
                x.e("MicroMsg.PendingCardIdInfoStorage", "deleteList fail, list is empty");
            } else {
                for (ak akVar : list) {
                    if (akVar != null) {
                        auB.a(akVar, new String[0]);
                    }
                }
            }
            ar.Hg();
            c.EV().fS(dz);
            x.i("MicroMsg.BatchGetCardMgr", "onSceneEnd do transaction use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            atO();
            if (this.kIv != null) {
                while (i3 < this.kIv.size()) {
                    WeakReference weakReference = (WeakReference) this.kIv.get(i3);
                    if (weakReference != null) {
                        d dVar = (d) weakReference.get();
                        if (dVar != null) {
                            dVar.atM();
                        }
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        x.e("MicroMsg.BatchGetCardMgr", "onSceneEnd fail, stop batch get, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        synchronized (this.gSF) {
            if (list != null) {
                if (list.size() > 0) {
                    this.kIs.removeAll(list);
                    this.kIt.addAll(list);
                }
            }
        }
        auB = am.auB();
        if (list == null || list.size() == 0) {
            x.e("MicroMsg.PendingCardIdInfoStorage", "increaseRetryCount fail, list is empty");
            return;
        }
        for (ak akVar2 : list) {
            if (akVar2 != null) {
                akVar2.field_retryCount++;
                auB.c(akVar2, new String[0]);
            }
        }
    }

    public static void nF(int i) {
        ar.CG().a(new w(i), 0);
    }
}
