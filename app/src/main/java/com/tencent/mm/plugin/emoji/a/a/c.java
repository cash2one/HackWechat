package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.storage.ak;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class c implements Cloneable, Iterable<f> {
    HashMap<String, ak> luI;
    protected HashMap<String, ak> luJ;
    public boolean luK;
    protected ArrayList<f> mItemList;

    public /* synthetic */ Object clone() {
        return aAJ();
    }

    public void clear() {
        if (this.mItemList != null) {
            this.mItemList.clear();
            this.mItemList = null;
        }
        if (this.luI != null) {
            this.luI.clear();
            this.luI = null;
        }
        if (this.luJ != null) {
            this.luJ.clear();
            this.luJ = null;
        }
    }

    public c(f fVar) {
        this(fVar == null ? null : fVar.lxC);
    }

    public c() {
        this.luI = new HashMap();
        this.luJ = new HashMap();
        this.luK = q.Ge();
    }

    public c(List<f> list) {
        this();
        if (list != null) {
            this.mItemList = new ArrayList();
            this.mItemList.addAll(list);
        }
    }

    public final int size() {
        return this.mItemList == null ? 0 : this.mItemList.size();
    }

    public final f oJ(int i) {
        if (this.mItemList == null || this.mItemList.size() <= i || i < 0 || this.mItemList == null) {
            return null;
        }
        return (f) this.mItemList.get(i);
    }

    public final f xU(String str) {
        if (this.mItemList != null) {
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                so soVar = fVar.luN;
                if (soVar != null && soVar.vIR != null && soVar.vIR.equals(str)) {
                    return fVar;
                }
            }
        }
        return null;
    }

    public final c aAJ() {
        try {
            c cVar = (c) super.clone();
            try {
                if (this.mItemList == null) {
                    return cVar;
                }
                cVar.mItemList = (ArrayList) this.mItemList.clone();
                return cVar;
            } catch (CloneNotSupportedException e) {
                return cVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public void notifyDataSetChanged() {
        if (this.mItemList != null) {
            this.luJ = i.aBE().lwM.ckg();
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                so soVar = fVar.luN;
                if (soVar != null) {
                    if (a.d(soVar)) {
                        fVar.eQ(a.aCY() ? 7 : 3);
                    } else {
                        String str = soVar.vIR;
                        fVar.a(this.luK, xY(str), xW(str));
                    }
                }
            }
            aAK();
        }
    }

    public final void xV(String str) {
        f xU = xU(str);
        if (xU != null) {
            xU.eQ(-1);
            xU.a(this.luK, xY(str), xW(str));
        }
    }

    public final boolean xW(String str) {
        return this.luJ == null ? false : this.luJ.containsKey(str);
    }

    public final ak xX(String str) {
        ak xY = xY(str);
        if (xY != null) {
            return xY;
        }
        xY = new ak(str);
        this.luI.put(str, xY);
        return xY;
    }

    public final ak xY(String str) {
        return (ak) this.luI.get(str);
    }

    public Iterator<f> iterator() {
        return new a(this, (byte) 0);
    }

    public void aAK() {
        if (this.mItemList != null && i.aBG().lxA != null) {
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                so soVar = fVar.luN;
                if (soVar != null) {
                    Integer num = (Integer) i.aBG().lxA.get(soVar.vIR);
                    int intValue = num == null ? -1 : num.intValue();
                    if (intValue >= 0) {
                        fVar.eQ(6);
                        fVar.sm = intValue;
                    }
                    if (intValue < 0 && fVar.mStatus == 6) {
                        fVar.eQ(3);
                    }
                }
            }
        }
    }
}
