package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.widget.AbsListView;
import com.tencent.mm.protocal.c.je;
import com.tencent.mm.protocal.c.jj;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class c extends b {
    protected int irz;
    protected String kFl;
    protected int kFn;
    private List<a> kFq = new ArrayList();
    private int kFr;
    private boolean kFs;
    protected boolean kFt;
    protected boolean kFu;
    int kFv;
    protected long[] kFw;
    protected b kFx;

    public c(Context context) {
        super(context);
        p(true, true);
        this.kFs = true;
        c(1);
    }

    public void c(String str, List<je> list) {
        this.kFq.clear();
        this.yjU.clear();
        ag.y(this.yjV);
        this.kFr = 0;
        this.kFl = str;
        if (list != null) {
            this.kFv = (int) (System.currentTimeMillis() / 1000);
            for (int i = 0; i < list.size(); i++) {
                je jeVar = (je) list.get(i);
                if (!(jeVar == null || jeVar.ngS == null || jeVar.ngS.size() <= 0)) {
                    a a = a(jeVar);
                    this.kFr += a(a);
                    this.kFq.add(a);
                    x.i("MicroMsg.BrandService.BizSearchResultAdapter", "type(%d) , count(%d) , offset(%d)", new Object[]{Long.valueOf(a.foe), Integer.valueOf(a.count), Integer.valueOf(this.kFr)});
                }
            }
            aso();
        }
        ag.y(this.yjV);
    }

    private a a(je jeVar) {
        a aVar = new a();
        aVar.kFC = new LinkedList();
        aVar.kFC.add(jeVar);
        aVar.foe = jeVar.vPp;
        aVar.count = jeVar.ngS.size();
        aVar.hEP = jeVar.vPq;
        aVar.kFz = new LinkedList();
        aVar.kFz.addAll(jeVar.ngS);
        aVar.kFy = jeVar.vPr;
        aVar.kFA = this.kFu;
        boolean z = this.kFt && aVar.hEP != 0;
        aVar.kFB = z;
        return aVar;
    }

    public void a(je jeVar, boolean z) {
        if ((this.kFs && jeVar == null) || jeVar.ngS == null) {
            x.e("MicroMsg.BrandService.BizSearchResultAdapter", "The content or content.ItemList is null or the mode do not support to append data.");
            return;
        }
        if (isEmpty()) {
            this.kFv = (int) (System.currentTimeMillis() / 1000);
        }
        a bN = bN(jeVar.vPp);
        if (bN != null) {
            if (bN.kFz == null) {
                bN.kFz = new LinkedList();
            }
            bN.kFz.addAll(jeVar.ngS);
            if (bN.kFC == null) {
                bN.kFC = new LinkedList();
            }
            bN.kFC.add(jeVar);
            bN.count += jeVar.ngS.size();
            this.kFr += jeVar.ngS.size();
        } else if (z) {
            this.kFq.add(a(jeVar));
            aso();
        } else {
            x.e("MicroMsg.BrandService.BizSearchResultAdapter", "The type(%d) do not exist.", new Object[]{Long.valueOf(jeVar.vPp)});
            return;
        }
        ag.y(this.yjV);
    }

    final a bN(long j) {
        int i = 0;
        while (i < this.kFq.size()) {
            if (((a) this.kFq.get(i)).foe == j) {
                break;
            }
            i++;
        }
        i = -1;
        if (i >= 0) {
            return (a) this.kFq.get(i);
        }
        return null;
    }

    protected final a ns(int i) {
        if (i >= 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.kFq.size(); i3++) {
                a aVar = (a) this.kFq.get(i3);
                i2 += a(aVar);
                if (i < i2) {
                    return aVar;
                }
            }
        }
        return null;
    }

    protected final je nt(int i) {
        int i2 = 0;
        if (i >= 0) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < this.kFq.size()) {
                a aVar = (a) this.kFq.get(i3);
                int a = a(aVar);
                i4 += a;
                if (i < i4) {
                    i4 = (aVar.kFA ? 1 : 0) + (i4 - a);
                    while (i2 < aVar.kFC.size()) {
                        je jeVar = (je) aVar.kFC.get(i2);
                        i4 += jeVar.ngS.size();
                        if (i < i4) {
                            return jeVar;
                        }
                        i2++;
                    }
                } else {
                    i3++;
                }
            }
        }
        return null;
    }

    private static int a(a aVar) {
        int i = 1;
        if (aVar == null) {
            return 0;
        }
        int i2 = (aVar.kFA ? 1 : 0) + aVar.count;
        if (!aVar.kFB) {
            i = 0;
        }
        return i2 + i;
    }

    private synchronized void aso() {
        boolean z = true;
        synchronized (this) {
            Map hashMap = new HashMap();
            for (int i = 0; i < this.kFq.size(); i++) {
                a aVar = (a) this.kFq.get(i);
                if (aVar != null) {
                    hashMap.put(Long.valueOf(aVar.foe), aVar);
                }
            }
            this.kFq.clear();
            this.kFr = 0;
            for (long valueOf : this.kFw) {
                aVar = (a) hashMap.get(Long.valueOf(valueOf));
                if (aVar != null) {
                    this.kFq.add(aVar);
                    this.kFr = a(aVar) + this.kFr;
                }
            }
            if (this.kFq.size() > 0) {
                aVar = (a) this.kFq.get(this.kFq.size() - 1);
                if (aVar.kFB == this.kFs) {
                    this.kFr = (aVar.kFB ? -1 : 1) + this.kFr;
                    if (this.kFs) {
                        z = false;
                    }
                    aVar.kFB = z;
                }
            }
            hashMap.clear();
        }
    }

    public final void p(boolean z, boolean z2) {
        this.kFu = z;
        this.kFt = z2;
    }

    public final void lw(int i) {
        this.irz = i;
    }

    public final void nu(int i) {
        this.kFn = i;
    }

    public final void c(long... jArr) {
        if (jArr != null && jArr.length > 0) {
            this.kFw = jArr;
        }
    }

    public int getCount() {
        return this.kFr;
    }

    public void asp() {
        c(null, null);
        this.kFv = 0;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    protected final a nv(int i) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.kFq.size(); i4++) {
            a aVar = (a) this.kFq.get(i4);
            int a = a(aVar);
            i3 += a;
            if (aVar.kFA && i == i3 - a) {
                je jeVar = aVar.kFC.size() == 0 ? null : (je) aVar.kFC.get(0);
                if (jeVar != null) {
                    return new d(jeVar.fon);
                }
            } else if (aVar.kFB && i == i3 - 1) {
                return new e(null, aVar.foe, aVar.count, this.kFl);
            } else {
                if (i < i3) {
                    i4 = (i - i3) + aVar.count;
                    if (aVar.kFB) {
                        i2 = 1;
                    }
                    i2 += i4;
                    jj jjVar = (jj) aVar.kFz.get(i2);
                    long j = aVar.foe;
                    b bVar = this.kFx;
                    if (jjVar == null) {
                        x.e("MicroMsg.BrandService.BizSearchResultAdapter", "data is null.");
                        return null;
                    }
                    a aVar2;
                    if (j == 1) {
                        x.v("MicroMsg.BrandService.BizSearchResultAdapter", "Create a BizContactDataItem.");
                        aVar2 = new a(jjVar);
                    } else {
                        aVar2 = j == 4 ? new g(jjVar) : j == 1073741824 ? new g(jjVar) : new g(jjVar);
                    }
                    if (!(aVar2 instanceof com.tencent.mm.plugin.brandservice.ui.base.a)) {
                        return aVar2;
                    }
                    com.tencent.mm.plugin.brandservice.ui.base.a aVar3 = (com.tencent.mm.plugin.brandservice.ui.base.a) aVar2;
                    aVar3.nz(i2);
                    aVar3.cR(i);
                    aVar3.a(bVar);
                    return aVar2;
                }
            }
        }
        return new g(null);
    }

    protected Object[] nw(int i) {
        a ns = ns(i);
        je nt = nt(i);
        if (nt != null) {
            Object obj = nt.vPs;
        } else {
            String str = "";
        }
        if (ns == null) {
            return null;
        }
        return new Object[]{this, ns.kFy, Integer.valueOf(this.kFn), obj};
    }

    public final void a(b bVar) {
        this.kFx = bVar;
    }
}
