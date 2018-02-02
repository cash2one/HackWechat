package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.protocal.c.io;
import com.tencent.mm.protocal.c.vu;
import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    vu pLI = null;
    io pLJ;

    class a implements Comparator {
        final /* synthetic */ a pLK;

        a(a aVar) {
            this.pLK = aVar;
        }

        public final int compare(Object obj, Object obj2) {
            return ((vu) obj).wfI - ((vu) obj2).wfI > 0 ? -1 : 1;
        }
    }

    public final void bnC() {
        x.i("MicroMsg.FavorInfoPicked", "cleanBusiF2FFavor");
        this.pLJ = null;
        this.pLI = null;
    }

    public final List<vv> bnD() {
        if (this.pLJ != null) {
            return this.pLJ.vON;
        }
        return new LinkedList();
    }

    public final boolean bnE() {
        if (this.pLJ != null) {
            return true;
        }
        return false;
    }

    public final boolean bnF() {
        if (this.pLJ == null || this.pLJ.vON == null || this.pLJ.vON.size() <= 0) {
            return false;
        }
        return true;
    }

    public final void It(String str) {
        this.pLI = null;
        if (str == null) {
            this.pLI = null;
        } else if (this.pLJ == null) {
            x.e("MicroMsg.FavorInfoPicked", "error setSelectFavorComposeId currentFavorResp is null");
            this.pLI = null;
        } else {
            Iterator it = this.pLJ.vOO.iterator();
            while (it.hasNext()) {
                vu vuVar = (vu) it.next();
                if (str.equals(vuVar.wfE)) {
                    this.pLI = vuVar;
                    return;
                }
            }
        }
    }

    public final boolean a(List<vv> list, vv vvVar) {
        if (this.pLJ == null) {
            x.e("MicroMsg.FavorInfoPicked", "error setFavorInfoList currentFavorResp is null");
            return false;
        }
        CharSequence bigInteger;
        if (vvVar != null) {
            bigInteger = new BigInteger(Long.toBinaryString(vvVar.wfN), 2).toString();
        } else {
            bigInteger = null;
        }
        List<vu> linkedList = new LinkedList();
        Iterator it = this.pLJ.vOO.iterator();
        while (it.hasNext()) {
            vu vuVar = (vu) it.next();
            if (vvVar == null || (!bh.ov(r1) && vuVar.wfE.contains(r1))) {
                linkedList.add(vuVar);
            }
        }
        List linkedList2 = new LinkedList();
        for (vu vuVar2 : linkedList) {
            if (a((List) list, vuVar2)) {
                linkedList2.add(vuVar2);
            }
        }
        if (linkedList2.size() > 0) {
            Collections.sort(linkedList2, new a(this));
            this.pLI = (vu) linkedList2.get(0);
            return true;
        }
        this.pLI = null;
        return false;
    }

    private static boolean a(List<vv> list, vu vuVar) {
        if (vuVar.vON.size() == 0) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (vv vvVar : list) {
            hashSet.add(Long.valueOf(vvVar.wfN));
        }
        Iterator it = vuVar.vON.iterator();
        while (it.hasNext()) {
            if (!hashSet.contains(Long.valueOf(((vv) it.next()).wfN))) {
                return false;
            }
        }
        return true;
    }
}
