package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.bop;
import com.tencent.mm.protocal.c.boq;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public final class c implements a {
    public ArrayList<a> gLv;
    public int kIS;
    public final d[] sgc;
    public Queue<c> sgd;
    public HashMap<String, Integer> sge;

    private c() {
        this.kIS = 0;
        this.gLv = new ArrayList(1);
        this.sgd = new LinkedList();
        this.sge = new HashMap();
        this.sgc = new d[1];
    }

    private void b(int i, SparseArray<c> sparseArray) {
        Iterator it = this.gLv.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(i, sparseArray);
        }
    }

    public final void bFA() {
        x.d("MicroMsg.TranslateServiceManager", "current waitings : %s", Integer.valueOf(this.sgd.size()));
        if (this.sgd.size() != 0 && this.kIS <= this.sgc.length) {
            for (int i = 0; i < this.sgc.length; i++) {
                if (this.sgc[i] == null) {
                    this.sgc[i] = new d(i, this);
                    ar.CG().a(631, this.sgc[i]);
                }
                if (!this.sgc[i].sgk) {
                    Object obj;
                    d dVar = this.sgc[i];
                    Queue queue = this.sgd;
                    if (dVar.sgk) {
                        obj = null;
                    } else {
                        dVar.sgj = new SparseArray();
                        if (queue.size() == 0) {
                            obj = null;
                        } else {
                            dVar.sgk = true;
                            LinkedList linkedList = new LinkedList();
                            int i2 = 0;
                            while (i2 < WXMediaMessage.TITLE_LENGTH_LIMIT && queue.size() > 0) {
                                c cVar = (c) queue.peek();
                                int length = cVar.fJq.getBytes().length;
                                if (i2 == 0 || i2 + length <= WXMediaMessage.TITLE_LENGTH_LIMIT) {
                                    queue.poll();
                                    bop com_tencent_mm_protocal_c_bop = new bop();
                                    com_tencent_mm_protocal_c_bop.wQZ = cVar.sgg;
                                    com_tencent_mm_protocal_c_bop.wRa = cVar.fJq;
                                    if (cVar.type == 1 || s.eV(cVar.bhd)) {
                                        com_tencent_mm_protocal_c_bop.wRb = cVar.bhd;
                                    }
                                    switch (cVar.type) {
                                        case 0:
                                            com_tencent_mm_protocal_c_bop.rYW = 1;
                                            break;
                                        case 1:
                                            com_tencent_mm_protocal_c_bop.rYW = 4;
                                            break;
                                        case 2:
                                            com_tencent_mm_protocal_c_bop.rYW = 2;
                                            break;
                                        case 3:
                                            com_tencent_mm_protocal_c_bop.rYW = 3;
                                            break;
                                    }
                                    x.d("MicroMsg.WorkingTranslate", "eventMsg.type: %d, msg.Scene:%d, id: %s", Integer.valueOf(cVar.type), Integer.valueOf(com_tencent_mm_protocal_c_bop.rYW), cVar.id);
                                    linkedList.add(com_tencent_mm_protocal_c_bop);
                                    dVar.sgj.put(cVar.sgg, cVar);
                                }
                                i2 += length;
                            }
                            dVar.sgl = new b(linkedList);
                            ar.CG().a(dVar.sgl, 0);
                            dVar.start = System.currentTimeMillis();
                            dVar.sgn.J(60000, 60000);
                            obj = 1;
                        }
                    }
                    if (obj != null) {
                        this.kIS++;
                    }
                }
            }
        }
    }

    public final boolean Mx(String str) {
        return this.sge.containsKey(str);
    }

    public final void a(int i, SparseArray<c> sparseArray, LinkedList<boq> linkedList) {
        int i2;
        HashMap hashMap;
        this.kIS--;
        if (linkedList == null || sparseArray.size() != linkedList.size()) {
            x.d("MicroMsg.TranslateServiceManager", "originals.size() != translatedMsg.size()");
            HashMap hashMap2 = new HashMap();
            for (i2 = 0; i2 < sparseArray.size(); i2++) {
                hashMap2.put(((c) sparseArray.valueAt(i2)).id, Integer.valueOf(((c) sparseArray.valueAt(i2)).sgg));
            }
            hashMap = hashMap2;
        } else {
            hashMap = null;
        }
        c cVar;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                boq com_tencent_mm_protocal_c_boq = (boq) it.next();
                cVar = (c) sparseArray.get(com_tencent_mm_protocal_c_boq.wQZ);
                String str = com_tencent_mm_protocal_c_boq.wRc;
                if (cVar.type == 1) {
                    str = ba.T(str, cVar.sgh);
                    cVar.fJq = ba.T(cVar.fJq, cVar.sgh);
                }
                cVar.fJw = str;
                cVar.ret = com_tencent_mm_protocal_c_boq.vJU;
                cVar.fHV = com_tencent_mm_protocal_c_boq.wRd;
                this.sge.remove(cVar.id);
                if (hashMap != null) {
                    hashMap.remove(cVar.id);
                }
            }
        } else {
            for (i2 = 0; i2 < sparseArray.size(); i2++) {
                cVar = (c) sparseArray.valueAt(i2);
                if (cVar.type == 1) {
                    cVar.fJq = ba.T(cVar.fJq, cVar.sgh);
                }
            }
        }
        if (hashMap != null && hashMap.size() > 0) {
            for (Entry key : hashMap.entrySet()) {
                this.sge.remove(key.getKey());
                x.d("MicroMsg.TranslateServiceManager", "we found missing translate, msgId : %s, clientId : %s", key.getKey(), key.getValue());
            }
        }
        b(i, sparseArray);
        bFA();
    }
}
