package com.tencent.e.a;

import com.tencent.e.d;
import com.tencent.e.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    public HashMap<String, Object> AmL = new HashMap();
    public Object AmM = new Object();
    c AmN;

    public final void a(d dVar, String[] strArr) {
        if (dVar != null && strArr != null) {
            synchronized (this.AmM) {
                for (Object obj : strArr) {
                    if (obj != null) {
                        Object obj2 = this.AmL.get(obj);
                        if (obj2 == null) {
                            this.AmL.put(obj, dVar);
                        } else if (obj2 instanceof d) {
                            d dVar2 = (d) obj2;
                            if (dVar2 == dVar) {
                                return;
                            }
                            LinkedList linkedList = new LinkedList();
                            linkedList.add(dVar2);
                            linkedList.add(dVar);
                            this.AmL.put(obj, linkedList);
                        } else if (obj2 instanceof List) {
                            LinkedList linkedList2 = (LinkedList) obj2;
                            if (linkedList2.indexOf(dVar) >= 0) {
                                return;
                            }
                            linkedList2.add(dVar);
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }

    public final void c(String str, int i, Object obj) {
        LinkedList linkedList = null;
        d dVar = this.AmN;
        e cHr = dVar.cHr();
        if (cHr == null) {
            cHr = dVar.cHq();
        } else {
            cHr.reset();
        }
        e eVar = (e) cHr;
        eVar.fAM = str;
        eVar.AmP = i;
        eVar.arg1 = 0;
        eVar.arg2 = 0;
        eVar.obj = obj;
        if (eVar != null && eVar.fAM != null) {
            d dVar2;
            System.currentTimeMillis();
            String str2 = eVar.fAM;
            synchronized (this.AmM) {
                Object obj2 = this.AmL.get(str2);
                if (obj2 != null) {
                    if (obj2 instanceof d) {
                        dVar2 = (d) obj2;
                    } else if (obj2 instanceof List) {
                        linkedList = (LinkedList) ((LinkedList) obj2).clone();
                        obj2 = null;
                    }
                }
                dVar2 = null;
            }
            if (dVar2 != null) {
                dVar2.dJ(str2, eVar.AmP);
            }
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).dJ(str2, eVar.AmP);
                }
            }
            dVar = this.AmN;
            synchronized (dVar.mLock) {
                if (dVar.qur < dVar.Amx.length) {
                    dVar.Amx[dVar.qur] = eVar;
                    dVar.qur++;
                }
            }
        }
    }
}
