package com.tencent.mm.ui;

import android.content.Context;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.tencent.mm.by.a.a;
import com.tencent.mm.by.a.e;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public abstract class f<K, T extends a> extends BaseAdapter {
    public String TAG;
    public Context context;
    private int nSj;
    private int pageSize;
    private boolean xEA;
    private e xEB;
    public K xEC;
    public boolean xEr;
    public c xEs;
    private HashMap<K, b<K, T>> xEt;
    protected a xEu;
    public int xEv;
    public int xEw;
    public boolean xEx;
    int xEy;
    private boolean xEz;

    public static class b<K, T> {
        public K object;
        public int xEF;
        public T xEG = null;

        public b(K k, int i, T t) {
            this.object = k;
            this.xEF = i;
        }

        public final int hashCode() {
            int i;
            int i2 = (this.xEF + 31) * 31;
            if (this.object == null) {
                i = 0;
            } else {
                i = this.object.hashCode();
            }
            return i + i2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.xEF != bVar.xEF) {
                return false;
            }
            if (this.object == null) {
                if (bVar.object != null) {
                    return false;
                }
                return true;
            } else if (this.object.equals(bVar.object)) {
                return true;
            } else {
                return false;
            }
        }
    }

    private interface d {
        void cmc();
    }

    public abstract SparseArray<K>[] a(HashSet<b<K, T>> hashSet, SparseArray<K>[] sparseArrayArr);

    public abstract ArrayList<T> ah(ArrayList<K> arrayList);

    public abstract T ckX();

    public abstract com.tencent.mm.by.a.d<K> clX();

    static /* synthetic */ boolean a(f fVar, HashMap hashMap) {
        for (b bVar : hashMap.values()) {
            if (bVar == null || bVar.xEF == 5) {
                if (bVar == fVar.xEC) {
                }
            }
            return false;
        }
        return true;
    }

    public /* synthetic */ Object getItem(int i) {
        return DC(i);
    }

    public final void a(a aVar) {
        this.xEu = aVar;
    }

    public final void clU() {
        this.xEu = null;
    }

    public f(Context context) {
        this(true, context);
        this.pageSize = 5000;
        x.i(this.TAG, "newCursor setPageSize %d", new Object[]{Integer.valueOf(5000)});
    }

    private f(boolean z, Context context) {
        this.TAG = "MicroMsg.CursorDataAdapter";
        this.xEr = true;
        this.xEv = 1000;
        this.xEw = 3000;
        this.xEx = true;
        this.nSj = 0;
        this.xEy = 0;
        this.xEC = null;
        this.context = context;
        this.xEz = true;
    }

    private f(Context context, int i, int i2) {
        this.TAG = "MicroMsg.CursorDataAdapter";
        this.xEr = true;
        this.xEv = 1000;
        this.xEw = 3000;
        this.xEx = true;
        this.nSj = 0;
        this.xEy = 0;
        this.xEC = null;
        this.context = context;
        this.xEz = true;
        this.xEA = false;
        this.xEv = 800;
        this.xEw = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
    }

    public f(Context context, byte b) {
        this(context, 800, MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN);
    }

    private void a(c cVar) {
        lP(false);
        this.xEs = cVar;
        this.xEs.getCount();
        clV();
    }

    private void a(com.tencent.mm.by.a.d<K> dVar) {
        lP(true);
        if (this.xEs == null || this.xEs.xCa != dVar) {
            if (!(this.xEs == null || this.xEs.isClosed())) {
                this.xEs.close();
                this.xEs = null;
            }
            this.xEs = new c(this, dVar);
            this.xEs.getCount();
            clV();
            notifyDataSetChanged();
        }
    }

    private void clV() {
        if (this.xEz) {
            int i = this.xEs.ckP() ? 1 : 2;
            if (!(i == this.xEy || this.xEy == 0)) {
                if (this.xEB != null && this.xEB.cmh()) {
                    a(new c(this, clX()), true, false);
                }
                x.i(this.TAG, "newcursor change update stats  %d ", new Object[]{Integer.valueOf(i)});
            }
            this.xEy = i;
        }
    }

    public boolean ckP() {
        if (this.xEs == null) {
            return false;
        }
        return this.xEs.ckP();
    }

    public int getCount() {
        if (this.xEs == null) {
            long currentTimeMillis = System.currentTimeMillis();
            a(clX());
            x.i(this.TAG, "newcursor createCursor last : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
        bh("getcount", false);
        return this.xEs.getCount();
    }

    public final int clW() {
        if (this.xEs == null) {
            return 0;
        }
        com.tencent.mm.by.a.d dVar = this.xEs.xCa;
        if (dVar == null) {
            return 0;
        }
        if (dVar instanceof e) {
            return ((e) dVar).xBR[0].getCount();
        }
        throw new RuntimeException("the cursor is not instanceof MergeHeapCursor ,please call getCount() instead ");
    }

    public final void bh(String str, boolean z) {
        if (this.nSj == 0) {
            int i = 1;
        } else {
            boolean z2 = false;
        }
        if (i == 0 && (this.xEx | z) != 0) {
            if (!z) {
                x.i(this.TAG, "newcursor cache needRefresh : needRefreshInfront :%b from : %s %s", new Object[]{Boolean.valueOf(this.xEx), str, bh.cgy()});
            }
            lO(false);
        }
    }

    public final T DC(int i) {
        if (this.xEs == null) {
            a(clX());
        }
        bh("getItem", false);
        this.xEs.xCa.moveToPosition(i);
        T DC = this.xEs.xCa.DC(i);
        if (DC != null) {
            DC.chK();
        } else {
            x.e(this.TAG, "newcursor getItem error %d", new Object[]{Integer.valueOf(i)});
        }
        return DC;
    }

    public long getItemId(int i) {
        return 0;
    }

    public final T ce(K k) {
        if (this.xEs == null) {
            return null;
        }
        return this.xEs.xCa.ce(k);
    }

    public final SparseArray<K>[] clY() {
        if (this.xEs == null) {
            return null;
        }
        SparseArray[] ckN = this.xEs.ckN();
        SparseArray<K>[] sparseArrayArr = new SparseArray[ckN.length];
        for (int i = 0; i < sparseArrayArr.length; i++) {
            sparseArrayArr[i] = new SparseArray();
            for (int i2 = 0; i2 < ckN[i].size(); i2++) {
                sparseArrayArr[i].put(i2, ckN[i].get(i2));
            }
        }
        return sparseArrayArr;
    }

    private void clZ() {
        this.xEt.clear();
        this.xEt.put(this.xEC, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void lO(boolean z) {
        int i;
        if (this.xEA || z) {
            if ((this.xEB == null || !this.xEB.cmh()) && cma() == 0) {
                i = 0;
            } else {
                i = true;
            }
            if (i != 0) {
                int cma = cma();
                if (this.xEB != null) {
                    i = this.xEB.cmj();
                    x.i(this.TAG, "newcursor mWorkerHandler.isHandingMsg,type is %d ", new Object[]{Integer.valueOf(i)});
                    if (i != 0) {
                        this.xEB.cmf();
                    }
                }
                i = cma;
                x.i(this.TAG, "newcursor ensureNewState  refreshstatus is %d ", new Object[]{Integer.valueOf(i)});
                this.nSj = 0;
                if (i == 2) {
                    a(new c(this, clX()), true, true);
                } else {
                    cmb();
                }
            }
        } else {
            i = cma();
            if (i == 0) {
                x.i(this.TAG, "newcursor need not change ");
                return;
            }
            if (i == 2) {
                x.i(this.TAG, "newcursor enqueueMessage resetcursor ");
                this.xEt.clear();
            }
            if (this.xEB == null) {
                this.xEB = new e(this);
            }
            this.xEB.DL(i);
        }
        this.nSj = 0;
    }

    private int cma() {
        if (this.xEt == null || this.xEt.size() == 0) {
            return 0;
        }
        if (this.xEt.containsKey(this.xEC)) {
            return 2;
        }
        return 1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void p(K k, int i) {
        if (this.xEs != null) {
            if (this.xEt == null) {
                this.xEt = new HashMap();
            }
            boolean containsKey = this.xEt.containsKey(this.xEC);
            if (i == 5 || !this.xEz || i == 1) {
                if (i != 5) {
                    clZ();
                } else if (!containsKey) {
                    this.xEt.put(k, new b(k, i, null));
                }
                x.i(this.TAG, "newcursor syncHandle is true ,changeType is %d  ", new Object[]{Integer.valueOf(i)});
                containsKey = true;
            } else if (containsKey) {
                x.i(this.TAG, "newcursor need reset ,return ");
                return;
            } else if (this.xEy != 1) {
                clZ();
                containsKey = false;
            } else if (this.xEs.cd(k) || i == 2) {
                HashMap hashMap = this.xEt;
                b bVar = new b(k, i, null);
                if (bVar.xEF == 2 && this.xEs.cd(bVar.object)) {
                    bVar.xEF = 3;
                }
                b bVar2 = (b) hashMap.get(k);
                if (bVar2 != null) {
                    hashMap.remove(bVar2);
                    switch (bVar.xEF) {
                        case 2:
                            switch (bVar2.xEF) {
                                case 2:
                                    x.i(this.TAG, "newcursor processEvent last insert, now insert, impossible");
                                    bVar.xEF = 2;
                                    break;
                                case 5:
                                    bVar.xEF = 3;
                                    break;
                                default:
                                    x.i(this.TAG, "newcursor processEvent last update, now insert, impossible");
                                    bVar.xEF = 2;
                                    break;
                            }
                        case 5:
                            switch (bVar2.xEF) {
                                case 2:
                                    break;
                                case 5:
                                    x.i(this.TAG, "newcursor processEvent last delete, now delete, impossible");
                                    bVar.xEF = 5;
                                    break;
                                default:
                                    bVar.xEF = 5;
                                    break;
                            }
                        default:
                            switch (bVar2.xEF) {
                                case 2:
                                    bVar.xEF = 2;
                                    break;
                                case 5:
                                    x.i(this.TAG, "newcursor processEvent last delete, now update, impossible");
                                    break;
                            }
                            bVar.xEF = 3;
                            break;
                    }
                }
                hashMap.put(k, bVar);
                if (!this.xEs.xCa.DB(hashMap.size())) {
                    x.i(this.TAG, "newcursor events size exceed limit :size is :  %d", new Object[]{Integer.valueOf(hashMap.size())});
                    hashMap.clear();
                    hashMap.put(this.xEC, null);
                }
                x.i(this.TAG, "newcursor add event events size %d", new Object[]{Integer.valueOf(this.xEt.size())});
                containsKey = false;
            } else {
                x.i(this.TAG, "newcursor event pass ");
                containsKey = false;
            }
            this.nSj = cma();
            String str = this.TAG;
            String str2 = "newcursor refreshStatus: %d ,hasLoadedAllDataStatus %b changeType :%d ";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(this.nSj);
            objArr[1] = Boolean.valueOf(this.xEy == 1);
            objArr[2] = Integer.valueOf(i);
            x.i(str, str2, objArr);
            if (containsKey) {
                x.i(this.TAG, "newcursor event is refresh sync ");
                lO(true);
            } else if (this.xEr && this.xEx) {
                lO(false);
            }
        }
    }

    public void pause() {
        this.xEr = false;
        x.i(this.TAG, "new cursor pasue");
    }

    private void a(d dVar) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.xEu != null) {
            this.xEu.Xw();
        }
        dVar.cmc();
        notifyDataSetChanged();
        if (this.xEu != null) {
            this.xEu.Xv();
        }
        if (this.xEB != null) {
            this.xEB.cmi();
        }
        x.i(this.TAG, "newcursor update callback last :%d ", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    private void cmb() {
        if (this.xEs == null || this.xEs.isClosed() || this.xEt.size() != 0) {
            a(new 1(this));
        } else {
            x.i(this.TAG, "events size is 0  ");
        }
    }

    private void a(final c cVar, boolean z, boolean z2) {
        if (z) {
            if (this.xEB != null && this.xEB.cmh()) {
                this.xEB.cmf();
            }
            if (this.xEt != null) {
                this.xEt.clear();
            }
        }
        if (z2) {
            a(new d(this) {
                final /* synthetic */ f xED;

                public final void cmc() {
                    this.xED.a(cVar);
                }
            });
        } else {
            a((c) cVar);
        }
    }

    public final void a(SparseArray<K>[] sparseArrayArr) {
        SparseArray[] ckN = this.xEs.ckN();
        for (int i = 0; i < ckN.length; i++) {
            ckN[i].clear();
            for (int i2 = 0; i2 < sparseArrayArr[i].size(); i2++) {
                ckN[i].put(i2, sparseArrayArr[i].get(i2));
            }
        }
    }

    public final void lP(boolean z) {
        if (this.xEs != null) {
            this.xEs.close();
            this.xEs = null;
        }
        if (z && this.xEB != null) {
            this.xEB.quit();
            this.xEB = null;
            if (this.xEt != null) {
                this.xEt.clear();
                x.i(this.TAG, "newcursor closeCursor,clear events");
            }
        }
        this.nSj = 0;
        this.xEy = 0;
    }
}
