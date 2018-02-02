package com.tencent.mm.ui.contact;

import android.os.Looper;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.a.c;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class q extends m {
    private int count = 0;
    private String fDj;
    private af handler = new af(Looper.getMainLooper());
    private a mMa;
    private e mMb;
    private List<j> mOf = null;
    private List<j> onh = null;
    private int yQQ = Integer.MAX_VALUE;
    private int yQR = Integer.MAX_VALUE;
    private List<String> yTn;
    private int yTo = Integer.MAX_VALUE;
    private int yTp = Integer.MAX_VALUE;
    private int yTq = Integer.MAX_VALUE;
    private boolean yTr = true;
    private int yTs = Integer.MAX_VALUE;
    private boolean yTt = true;
    private int yTu = Integer.MAX_VALUE;
    private List<j> yTv = null;
    private List<j> yTw = null;
    private List<Integer> yTx;
    private k yTy = new k(this) {
        final /* synthetic */ q yTA;

        {
            this.yTA = r1;
        }

        public final void b(h hVar) {
            switch (hVar.bjW) {
                case -3:
                case -2:
                case -1:
                    if (hVar.mJc.fDj.equals(this.yTA.fDj)) {
                        q.c(this.yTA);
                        return;
                    }
                    return;
                case 0:
                    if (this.yTA.mMa != null && this.yTA.mMa.equals(this.yTA.mMa)) {
                        this.yTA.cwi();
                        this.yTA.mMb = hVar.mMb;
                        q.a(this.yTA, hVar.mMc);
                        this.yTA.yTv = hVar.mMc;
                        d.aS(hVar.mMc);
                        this.yTA.f(hVar.mJc.fDj, q.c(this.yTA), true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    protected k yTz = new 2(this);

    static /* synthetic */ void a(q qVar, List list) {
        if (qVar.yTn != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                j jVar = (j) list.get(size);
                if (!qVar.yTn.contains(jVar.mLs)) {
                    int i = jVar.type;
                    Object obj = (i == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || i == 131075 || i == 131076) ? 1 : null;
                    if (obj != null) {
                    }
                }
                list.remove(size);
            }
        }
    }

    static /* synthetic */ boolean c(q qVar) {
        if (qVar.yTx.size() <= 0) {
            return true;
        }
        HashSet hashSet = new HashSet();
        if (qVar.yTv != null) {
            for (j jVar : qVar.yTv) {
                hashSet.add(jVar.mLs);
            }
        }
        int intValue = ((Integer) qVar.yTx.remove(0)).intValue();
        g gVar = new g();
        gVar.fDj = qVar.fDj;
        gVar.mLU = new int[]{intValue};
        gVar.mLX = hashSet;
        gVar.mLZ = qVar.yTz;
        gVar.handler = qVar.handler;
        if (intValue == 131075) {
            gVar.mLR = 32;
            gVar.mLY = com.tencent.mm.plugin.fts.a.c.a.mMy;
        } else {
            gVar.mLR = 16;
            gVar.mLY = b.mMz;
        }
        qVar.mMa = ((m) com.tencent.mm.kernel.g.k(m.class)).search(2, gVar);
        return false;
    }

    public q(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, int i) {
        super(mMBaseSelectContactUI, z, i);
        this.yTn = list;
        this.yTx = new ArrayList();
        x.i("MicroMsg.MMSearchContactAdapter", "Create!");
        WT();
    }

    public void bo(String str, boolean z) {
        if (this.ySU != null) {
            this.ySU.r(str, getCount(), z);
        }
    }

    public void a(String str, int[] iArr, boolean z) {
        clearTask();
        this.fDj = str;
        this.yTx.clear();
        for (int valueOf : iArr) {
            this.yTx.add(Integer.valueOf(valueOf));
        }
        HashSet hashSet = new HashSet();
        if (!z) {
            hashSet.add("filehelper");
        }
        x.i("MicroMsg.MMSearchContactAdapter", "doSearch: query=%s", new Object[]{this.fDj});
        g gVar = new g();
        gVar.fDj = str;
        gVar.mLU = iArr;
        gVar.mLW = 3;
        gVar.mLZ = this.yTy;
        gVar.handler = this.handler;
        gVar.scene = 1;
        gVar.mLX = hashSet;
        this.mMa = ((m) com.tencent.mm.kernel.g.k(m.class)).search(1, gVar);
    }

    private void clearTask() {
        if (this.mMa != null) {
            ((m) com.tencent.mm.kernel.g.k(m.class)).cancelSearchTask(this.mMa);
            this.mMa = null;
        }
    }

    private void cwi() {
        this.yTp = Integer.MAX_VALUE;
        this.yTq = Integer.MAX_VALUE;
        this.yTr = true;
        this.yTs = Integer.MAX_VALUE;
        this.yQQ = Integer.MAX_VALUE;
        this.yTt = true;
        this.yTu = Integer.MAX_VALUE;
        this.yQR = Integer.MAX_VALUE;
        this.yTv = null;
        this.onh = null;
        this.mOf = null;
        this.yTw = null;
        this.mMb = null;
        clearCache();
        notifyDataSetChanged();
    }

    private void WT() {
        x.i("MicroMsg.MMSearchContactAdapter", "initData!");
        this.fDj = null;
        cwi();
        clearTask();
        clearCache();
    }

    public final void aaS() {
        WT();
    }

    private void f(String str, boolean z, boolean z2) {
        int dt = dt(this.yTv);
        int dt2 = dt(this.onh);
        int dt3 = dt(this.mOf);
        int dt4 = dt(this.yTw);
        if (dt > 0) {
            this.yTp = 0;
            dt = (dt + 1) + 0;
        } else {
            this.yTp = Integer.MAX_VALUE;
            dt = 0;
        }
        if (dt2 > 0) {
            this.yTq = dt;
            if (dt2 <= 3 || (dt3 <= 0 && dt4 <= 0)) {
                this.yTs = Integer.MAX_VALUE;
                dt += dt2 + 1;
            } else if (this.yTr) {
                dt += 4;
                this.yTs = dt;
                dt++;
            } else {
                dt += dt2 + 1;
                this.yTs = dt;
                dt++;
            }
        } else {
            this.yTq = Integer.MAX_VALUE;
        }
        if (this.mMb.mLC.length <= 1 || btz()) {
            this.yTo = Integer.MAX_VALUE;
        } else {
            this.yTo = dt;
            dt++;
        }
        if (dt3 > 0) {
            this.yQQ = dt;
            if (dt3 <= 3 || dt4 <= 0) {
                this.yTu = Integer.MAX_VALUE;
                dt += dt3 + 1;
            } else if (this.yTt) {
                dt += 4;
                this.yTu = dt;
                dt++;
            } else {
                dt += dt3 + 1;
                this.yTu = dt;
                dt++;
            }
        } else {
            this.yQQ = Integer.MAX_VALUE;
        }
        if (dt4 > 0) {
            this.yQR = dt;
            dt += dt4 + 1;
        } else {
            this.yQR = Integer.MAX_VALUE;
        }
        x.i("MicroMsg.MMSearchContactAdapter", "setCount %d", new Object[]{Integer.valueOf(dt)});
        this.count = dt;
        if (z2) {
            bo(str, z);
        }
        clearCache();
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.count;
    }

    private static int dt(List<? extends Object> list) {
        return list == null ? 0 : list.size();
    }

    public com.tencent.mm.ui.contact.a.a jb(int i) {
        com.tencent.mm.ui.contact.a.a fVar;
        if (i == this.yTo) {
            fVar = new f(i);
            fVar.rVq = true;
        } else if (i == this.yTp) {
            fVar = eZ(com.tencent.mm.plugin.selectcontact.a.h.mPj, i);
        } else if (i == this.yTq) {
            fVar = eZ(com.tencent.mm.plugin.selectcontact.a.h.ekt, i);
        } else if (i == this.yQQ) {
            fVar = eZ(com.tencent.mm.plugin.selectcontact.a.h.moA, i);
        } else if (i == this.yQR) {
            fVar = eZ(com.tencent.mm.plugin.selectcontact.a.h.qfF, i);
        } else if (i == this.yTs) {
            fVar = s(com.tencent.mm.plugin.selectcontact.a.h.ekt, i, this.yTr);
        } else if (i == this.yTu) {
            fVar = s(com.tencent.mm.plugin.selectcontact.a.h.moA, i, this.yTt);
        } else if (i > this.yQR) {
            r2 = (i - this.yQR) - 1;
            r1 = new com.tencent.mm.ui.contact.a.d(i);
            r1.iVU = (j) this.yTw.get(r2);
            r1.ySW = btz();
            r1.rVq = true;
            r1.mPy = r2 + 1;
            r1.cC(r1.iVU.type, r1.iVU.mLr);
            fVar = r1;
        } else if (i > this.yQQ) {
            r2 = (i - this.yQQ) - 1;
            r1 = new c(i);
            r1.iVU = (j) this.mOf.get(r2);
            r1.ySW = btz();
            r1.rVq = true;
            r1.mPy = r2 + 1;
            r1.cC(r1.iVU.type, r1.iVU.mLr);
            fVar = r1;
        } else if (i > this.yTq) {
            r2 = (i - this.yTq) - 1;
            r1 = new com.tencent.mm.ui.contact.a.d(i);
            r1.iVU = (j) this.onh.get(r2);
            r1.ySW = btz();
            r1.rVq = true;
            r1.mPy = r2 + 1;
            r1.cC(r1.iVU.type, r1.iVU.mLr);
            fVar = r1;
        } else if (i > this.yTp) {
            r2 = (i - this.yTp) - 1;
            j jVar = (j) this.yTv.get(r2);
            if (jVar.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || jVar.type == 131076) {
                r1 = new com.tencent.mm.ui.contact.a.d(i);
                r1.iVU = jVar;
                r1.ySW = btz();
                r1.yVc = true;
                r1.rVq = true;
                r1.mPy = r2 + 1;
                r1.cC(r1.iVU.type, r1.iVU.mLr);
                fVar = r1;
            } else if (jVar.type == 131075) {
                r1 = new c(i);
                r1.iVU = jVar;
                r1.ySW = btz();
                r1.yVc = true;
                r1.rVq = true;
                r1.mPy = r2 + 1;
                r1.cC(r1.iVU.type, r1.iVU.mLr);
                fVar = r1;
            } else {
                x.e("MicroMsg.MMSearchContactAdapter", "createTopHitsDataItem return unkown type %d", new Object[]{Integer.valueOf(jVar.type)});
                fVar = null;
            }
        } else {
            x.e("MicroMsg.MMSearchContactAdapter", "unkown position=%d", new Object[]{Integer.valueOf(i)});
            fVar = null;
        }
        if (fVar != null) {
            fVar.fDj = this.fDj;
            fVar.mMb = this.mMb;
            fVar.scene = this.scene;
        }
        return fVar;
    }

    private static com.tencent.mm.ui.contact.a.a s(int i, int i2, boolean z) {
        com.tencent.mm.ui.contact.a.a iVar = new i(i2);
        iVar.mPo = i;
        iVar.mPp = z;
        return iVar;
    }

    private com.tencent.mm.ui.contact.a.a eZ(int i, int i2) {
        com.tencent.mm.ui.contact.a.a gVar = new com.tencent.mm.ui.contact.a.g(i2);
        gVar.mPH = this.ySV.getActivity().getResources().getString(i);
        return gVar;
    }

    public void finish() {
        super.finish();
        x.i("MicroMsg.MMSearchContactAdapter", "finish!");
        WT();
    }

    protected boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        int i = aVar.position + 1;
        int[] iArr = new int[]{this.yTp, this.yTq, this.yQQ, this.yQR};
        for (int i2 = 0; i2 < 4; i2++) {
            if (i == iArr[i2]) {
                return true;
            }
        }
        return false;
    }

    public final boolean Gn(int i) {
        int headerViewsCount = i - this.ySV.btG().getHeaderViewsCount();
        if (headerViewsCount == this.yTs) {
            if (this.yTr) {
                headerViewsCount = this.ySV.btG().getSelectedItemPosition();
                this.yTr = false;
                f(this.fDj, true, false);
                this.ySV.btG().setSelection(headerViewsCount);
                return true;
            }
            this.yTr = true;
            f(this.fDj, true, false);
            this.ySV.btG().setSelection(this.yTs);
            return true;
        } else if (headerViewsCount != this.yTu) {
            com.tencent.mm.ui.contact.a.a Gm = Gm(headerViewsCount);
            if (!(Gm == null || !Gm.rVq || this.yTo == Integer.MAX_VALUE)) {
                if (Gm.position == this.yTo) {
                    u.Go(1);
                    return false;
                }
                u.Go(0);
            }
            return false;
        } else if (this.yTt) {
            headerViewsCount = this.ySV.btG().getSelectedItemPosition();
            this.yTt = false;
            f(this.fDj, true, false);
            this.ySV.btG().setSelection(headerViewsCount);
            return true;
        } else {
            this.yTt = true;
            f(this.fDj, true, false);
            this.ySV.btG().setSelection(this.yTu);
            return true;
        }
    }
}
