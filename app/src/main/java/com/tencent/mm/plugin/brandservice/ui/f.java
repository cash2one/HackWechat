package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mm.plugin.brandservice.ui.base.a;
import com.tencent.mm.protocal.c.bbl;
import com.tencent.mm.protocal.c.bfd;
import com.tencent.mm.protocal.c.je;
import java.util.List;

public final class f extends c {
    List<bbl> kGP = null;
    private SparseArray<a> kGQ = new SparseArray();
    private int kGR;

    public final /* synthetic */ Object getItem(int i) {
        return ny(i);
    }

    public f(Context context) {
        super(context);
        a(new 1(this));
    }

    public final void c(String str, List<je> list) {
        super.c(str, list);
        this.kGR = super.getCount();
    }

    public final void a(je jeVar, boolean z) {
        super.a(jeVar, z);
        if (this.kGR == 0) {
            this.kGR = super.getCount();
        }
    }

    public final int getCount() {
        int count = super.getCount();
        if (count != 0 || this.kGP == null) {
            return count;
        }
        int i = count;
        for (bbl com_tencent_mm_protocal_c_bbl : this.kGP) {
            if (com_tencent_mm_protocal_c_bbl == null || com_tencent_mm_protocal_c_bbl.wHQ == null) {
                count = i;
            } else {
                count = i + com_tencent_mm_protocal_c_bbl.wHQ.size();
            }
            i = count;
        }
        return i;
    }

    public final void asp() {
        super.asp();
    }

    public final com.tencent.mm.ui.base.sortview.a ny(int i) {
        String str = null;
        int count = super.getCount();
        if (count != 0) {
            return super.ny(i);
        }
        a aVar = (a) this.kGQ.get(i);
        if (aVar != null || this.kGP.size() <= 0) {
            return aVar;
        }
        Object obj;
        for (bbl com_tencent_mm_protocal_c_bbl : this.kGP) {
            if (count == i) {
                String com_tencent_mm_protocal_c_bdo = com_tencent_mm_protocal_c_bbl.wHO == null ? null : com_tencent_mm_protocal_c_bbl.wHO.toString();
                obj = (bfd) com_tencent_mm_protocal_c_bbl.wHQ.get(0);
                str = com_tencent_mm_protocal_c_bdo;
            } else if (i < com_tencent_mm_protocal_c_bbl.wHQ.size() + count) {
                bfd com_tencent_mm_protocal_c_bfd = (bfd) com_tencent_mm_protocal_c_bbl.wHQ.get(i - count);
                break;
            } else {
                count = com_tencent_mm_protocal_c_bbl.wHQ.size() + count;
            }
        }
        obj = null;
        com.tencent.mm.ui.base.sortview.a bVar = new b(obj, str);
        bVar.nz(i);
        bVar.cR(i);
        this.kGQ.put(i, bVar);
        return bVar;
    }

    protected final Object[] nw(int i) {
        c.a ns = ns(i);
        je nt = nt(i);
        if (ns == null) {
            return super.nw(i);
        }
        Object[] objArr = new Object[4];
        objArr[0] = this;
        objArr[1] = ns.kFy;
        objArr[2] = Integer.valueOf(i < this.kGR ? 39 : 56);
        objArr[3] = nt != null ? nt.vPs : "";
        return objArr;
    }
}
