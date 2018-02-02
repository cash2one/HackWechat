package com.tencent.mm.plugin.card.sharecard.a;

import android.os.Looper;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.h;
import com.tencent.mm.plugin.card.sharecard.model.n;
import com.tencent.mm.plugin.card.sharecard.model.o;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a implements e {
    public byte[] gSF = new byte[0];
    public List<n> kIs = am.auJ().aux();
    public List<n> kIt = new ArrayList();
    private List<WeakReference<d>> kIv = new ArrayList();
    public com.tencent.mm.plugin.card.sharecard.model.e kMT;
    private int kMU = 0;
    public int kMV = 5;
    public af mHandler = new af(Looper.getMainLooper());
    private Runnable mRunnable = new 1(this);

    public a() {
        x.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr <init>, init pending list size = %d", new Object[]{Integer.valueOf(this.kIs.size())});
        ar.CG().a(903, this);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void atO() {
        Object linkedList = new LinkedList();
        synchronized (this.gSF) {
            if (this.kIs.size() == 0) {
                x.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr getNow, no pending cardinfo ,no need to get");
                return;
            }
            linkedList.addAll(this.kIs);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.kMT = null;
        List<n> E;
        o auJ;
        if (i == 0 && i2 == 0) {
            E = E(((com.tencent.mm.plugin.card.sharecard.model.e) kVar).kLT);
            x.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, batch get succ, remove succ id list, size = %d", new Object[]{Integer.valueOf(E.size())});
            synchronized (this.gSF) {
                this.kIs.removeAll(E);
            }
            long currentTimeMillis = System.currentTimeMillis();
            ar.Hg();
            long dz = c.EV().dz(Thread.currentThread().getId());
            auJ = am.auJ();
            if (E.size() == 0) {
                x.e("MicroMsg.ShareCardSyncItemInfoStorage", "deleteList fail, share card list is empty");
            } else {
                for (n nVar : E) {
                    if (nVar != null) {
                        auJ.a(nVar, new String[0]);
                    }
                }
            }
            ar.Hg();
            c.EV().fS(dz);
            x.i("MicroMsg.ShareCardBatchGetCardMgr", "onSceneEnd do transaction use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            atO();
            asi();
            return;
        }
        x.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd fail, stop batch get, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        E = E(((com.tencent.mm.plugin.card.sharecard.model.e) kVar).kLS);
        synchronized (this.gSF) {
            if (E.size() > 0) {
                this.kIs.removeAll(E);
                this.kIt.addAll(E);
            }
        }
        auJ = am.auJ();
        if (E.size() == 0) {
            x.e("MicroMsg.ShareCardSyncItemInfoStorage", "increaseRetryCount fail, share card list is empty");
            return;
        }
        for (n nVar2 : E) {
            if (nVar2 != null) {
                nVar2.field_retryCount++;
                auJ.c(nVar2, new String[0]);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ArrayList<n> E(LinkedList<String> linkedList) {
        ArrayList<n> arrayList = new ArrayList();
        LinkedList linkedList2 = new LinkedList();
        synchronized (this.gSF) {
            if (this.kIs.size() == 0) {
                x.e("MicroMsg.ShareCardBatchGetCardMgr", "getSuccessShareCardSyncItem pendingList size is 0");
                return arrayList;
            }
            linkedList2.addAll(this.kIs);
        }
    }

    public final void auR() {
        int i;
        x.i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene");
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int i2 = currentTimeMillis - this.kMU;
        if (this.kMV <= 0) {
            i = 5;
        } else {
            i = this.kMV;
        }
        if (i2 >= i) {
            ar.CG().a(new h(), 0);
        } else {
            x.i("MicroMsg.ShareCardBatchGetCardMgr", "sync interval is " + i2);
            this.mHandler.removeCallbacks(this.mRunnable);
            this.mHandler.postDelayed(this.mRunnable, (long) (i * 1000));
        }
        this.kMU = currentTimeMillis;
    }

    public final void asi() {
        if (this.kIv != null) {
            for (int i = 0; i < this.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kIv.get(i);
                if (weakReference != null) {
                    d dVar = (d) weakReference.get();
                    if (dVar != null) {
                        dVar.atM();
                    }
                }
            }
        }
    }

    public final void a(d dVar) {
        if (this.kIv == null) {
            this.kIv = new ArrayList();
        }
        if (dVar != null) {
            this.kIv.add(new WeakReference(dVar));
        }
    }

    public final void b(d dVar) {
        if (this.kIv != null && dVar != null) {
            for (int i = 0; i < this.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kIv.get(i);
                if (weakReference != null) {
                    d dVar2 = (d) weakReference.get();
                    if (dVar2 != null && dVar2.equals(dVar)) {
                        this.kIv.remove(weakReference);
                        return;
                    }
                }
            }
        }
    }
}
