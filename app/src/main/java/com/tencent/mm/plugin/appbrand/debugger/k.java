package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.mm.bq.a;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.protocal.c.bvj;
import com.tencent.mm.protocal.c.bvk;
import com.tencent.mm.protocal.c.bvl;
import com.tencent.mm.protocal.c.bvm;
import com.tencent.mm.protocal.c.bvn;
import com.tencent.mm.protocal.c.bvq;
import com.tencent.mm.protocal.c.bvs;
import com.tencent.mm.protocal.c.bvu;
import com.tencent.mm.protocal.c.bvv;
import com.tencent.mm.protocal.c.bvw;
import com.tencent.mm.protocal.c.bvz;
import com.tencent.mm.protocal.c.bwi;
import com.tencent.mm.protocal.c.bwj;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;

public final class k {
    Timer bnp;
    n iQA;
    p iQC;
    boolean iQP = false;
    private long iQQ;
    LinkedList<j> iQR = new LinkedList();
    private final int iQS = 5000;
    private int iQT = 0;
    private long iQU = 0;
    g iQx;
    d irQ;
    Context mContext;

    public final void D(int i, String str) {
        a com_tencent_mm_protocal_c_bvl = new bvl();
        com_tencent_mm_protocal_c_bvl.wWN = i;
        com_tencent_mm_protocal_c_bvl.fwv = str;
        a(o.a(com_tencent_mm_protocal_c_bvl, this.iQx, "callInterfaceResult"));
    }

    private synchronized void acp() {
        int i = 0;
        while (i < this.iQx.iQn.size()) {
            int acj = i == 0 ? this.iQx.acj() : ((bvn) this.iQx.iQn.get(i - 1)).hOH;
            int i2 = ((bvn) this.iQx.iQn.get(i)).hOH;
            if (acj - i2 != 1) {
                bB(acj + 1, i2 - 1);
            }
            i++;
        }
    }

    public final void bB(int i, int i2) {
        x.d("MicroMsg.RemoteDebugMsgMrg", "sync minSeq %d, maxSeq %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == 0 || i <= i2) {
            a com_tencent_mm_protocal_c_bwj = new bwj();
            com_tencent_mm_protocal_c_bwj.wXj = this.iQx.iPU;
            com_tencent_mm_protocal_c_bwj.wXv = i;
            com_tencent_mm_protocal_c_bwj.wXw = i2;
            this.iQA.a(o.a(1005, com_tencent_mm_protocal_c_bwj));
            this.iQx.iQe = System.currentTimeMillis();
        }
    }

    final void q(LinkedList<bvn> linkedList) {
        if (bh.cA(linkedList)) {
            x.w("MicroMsg.RemoteDebugMsgMrg", "handleMsg list is null");
            return;
        }
        Iterator it = r(linkedList).iterator();
        while (it.hasNext()) {
            bvn com_tencent_mm_protocal_c_bvn = (bvn) it.next();
            byte[] bArr = com_tencent_mm_protocal_c_bvn.vZC.oz;
            String str = com_tencent_mm_protocal_c_bvn.category;
            Object obj = -1;
            switch (str.hashCode()) {
                case -1680221061:
                    if (str.equals("callInterface")) {
                        obj = null;
                        break;
                    }
                    break;
                case -217209181:
                    if (str.equals("evaluateJavascriptResult")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 3441010:
                    if (str.equals("ping")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 95766211:
                    if (str.equals("domOp")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 1319027697:
                    if (str.equals("breakpoint")) {
                        obj = 3;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    bvk com_tencent_mm_protocal_c_bvk = (bvk) new bvk().aF(bArr);
                    x.i("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, method: %s, call_id %d", new Object[]{com_tencent_mm_protocal_c_bvk.wWL, Integer.valueOf(com_tencent_mm_protocal_c_bvk.wWN)});
                    String str2 = com_tencent_mm_protocal_c_bvk.wWL;
                    LinkedList linkedList2 = com_tencent_mm_protocal_c_bvk.wWM;
                    bvu com_tencent_mm_protocal_c_bvu = (bvu) this.iQx.iQj.get(str2);
                    if (com_tencent_mm_protocal_c_bvu != null) {
                        LinkedList linkedList3 = com_tencent_mm_protocal_c_bvu.wWM;
                        if (linkedList2.size() >= linkedList3.size()) {
                            LinkedList linkedList4 = new LinkedList();
                            for (int i = 0; i < linkedList3.size(); i++) {
                                if ("Number".equals(linkedList3.get(i))) {
                                    linkedList4.add(Integer.valueOf((String) linkedList2.get(i)));
                                } else if ("Boolean".equals(linkedList3.get(i))) {
                                    linkedList4.add(Boolean.valueOf((String) linkedList2.get(i)));
                                } else {
                                    linkedList4.add(linkedList2.get(i));
                                }
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            Method method = (Method) this.iQx.iQi.get(str2);
                            if (method == null) {
                                x.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface callMethod is null");
                                break;
                            }
                            Object invoke = linkedList4.size() == 0 ? method.invoke(this.irQ, new Object[0]) : linkedList4.size() == 1 ? method.invoke(this.irQ, new Object[]{linkedList4.get(0)}) : linkedList4.size() == 2 ? method.invoke(this.irQ, new Object[]{linkedList4.get(0), linkedList4.get(1)}) : linkedList4.size() == 3 ? method.invoke(this.irQ, new Object[]{linkedList4.get(0), linkedList4.get(1), linkedList4.get(2)}) : linkedList4.size() == 4 ? method.invoke(this.irQ, new Object[]{linkedList4.get(0), linkedList4.get(1), linkedList4.get(2), linkedList4.get(3)}) : linkedList4.size() == 5 ? method.invoke(this.irQ, new Object[]{linkedList4.get(0), linkedList4.get(1), linkedList4.get(2), linkedList4.get(3), linkedList4.get(4)}) : null;
                            String valueOf = String.valueOf(invoke);
                            if (!bh.ov(valueOf)) {
                                D(com_tencent_mm_protocal_c_bvk.wWN, valueOf);
                            }
                            l.a(str2, linkedList2, currentTimeMillis, com_tencent_mm_protocal_c_bvk.bke(), valueOf == null ? 0 : valueOf.length());
                            break;
                        }
                        x.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodArgValueList.size() < methodArgList.size()");
                        break;
                    }
                    x.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodWithArgs is null");
                    break;
                case 1:
                    bvs com_tencent_mm_protocal_c_bvs = (bvs) new bvs().aF(bArr);
                    x.i("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bvs.wWY)});
                    int i2 = com_tencent_mm_protocal_c_bvs.wWY;
                    String str3 = com_tencent_mm_protocal_c_bvs.fwv;
                    a aVar = (a) this.iQx.iQo.remove(Integer.valueOf(i2));
                    if (aVar == null) {
                        break;
                    }
                    ValueCallback valueCallback = aVar.iPR;
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(str3);
                    }
                    x.d("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback, callback id: " + i2 + " ret: " + str3);
                    l.a(aVar, com_tencent_mm_protocal_c_bvs.bke());
                    break;
                case 2:
                    bvv com_tencent_mm_protocal_c_bvv = (bvv) new bvv().aF(bArr);
                    a com_tencent_mm_protocal_c_bvw = new bvw();
                    com_tencent_mm_protocal_c_bvw.wXa = com_tencent_mm_protocal_c_bvv.wXa;
                    com_tencent_mm_protocal_c_bvw.wXb = l.acv();
                    x.i("MicroMsg.RemoteDebugMsgMrg", "onPing netType %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bvw.wXb)});
                    a(o.a(com_tencent_mm_protocal_c_bvw, this.iQx, "pong"));
                    break;
                case 3:
                    bvj com_tencent_mm_protocal_c_bvj = (bvj) new bvj().aF(bArr);
                    if (this.iQx.acl() != com_tencent_mm_protocal_c_bvj.wWJ) {
                        if (com_tencent_mm_protocal_c_bvj.wWJ) {
                            this.iQx.cv(true);
                        } else {
                            this.iQx.cv(false);
                        }
                        this.iQC.acx();
                        this.iQC.acA();
                        break;
                    }
                    break;
                case 4:
                    bvq com_tencent_mm_protocal_c_bvq = (bvq) new bvq().aF(bArr);
                    x.d("MicroMsg.RemoteDebugMsgMrg", "onDomOp");
                    if (com_tencent_mm_protocal_c_bvq.wWX == this.iQx.iPT.irP.iqC.aiT().aex().hashCode()) {
                        this.iQx.iPT.a("remoteDebugCommand", com_tencent_mm_protocal_c_bvq.wWW, null);
                        break;
                    } else {
                        x.w("MicroMsg.RemoteDebugMsgMrg", "onDomOp id not current webViewId %d/%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bvq.wWX), Integer.valueOf(this.iQx.iPT.irP.iqC.aiT().aex().hashCode())});
                        break;
                    }
                default:
                    break;
            }
        }
        x.i("MicroMsg.RemoteDebugMsgMrg", "handleMsg size %d, ack %d", new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(this.iQx.acj())});
        g gVar = this.iQx;
        gVar.iQq += (long) linkedList.size();
        acp();
    }

    private synchronized LinkedList<bvn> r(LinkedList<bvn> linkedList) {
        LinkedList<bvn> linkedList2;
        if (linkedList == null) {
            linkedList2 = null;
        } else {
            LinkedList<bvn> linkedList3 = new LinkedList();
            Collection linkedList4 = new LinkedList();
            this.iQx.iQn.addAll(linkedList);
            Collections.sort(this.iQx.iQn, new 1(this));
            int acj = this.iQx.acj();
            Iterator it = this.iQx.iQn.iterator();
            int i = acj;
            while (it.hasNext()) {
                bvn com_tencent_mm_protocal_c_bvn = (bvn) it.next();
                if (com_tencent_mm_protocal_c_bvn != null) {
                    if (com_tencent_mm_protocal_c_bvn.hOH > i) {
                        if (com_tencent_mm_protocal_c_bvn.hOH - i != 1) {
                            break;
                        }
                        linkedList3.add(com_tencent_mm_protocal_c_bvn);
                        i = com_tencent_mm_protocal_c_bvn.hOH;
                    } else {
                        linkedList4.add(com_tencent_mm_protocal_c_bvn);
                    }
                }
            }
            this.iQx.jR(i);
            this.iQx.iQn.removeAll(linkedList3);
            this.iQx.iQn.removeAll(linkedList4);
            x.d("MicroMsg.RemoteDebugMsgMrg", "getHandleMsgList size: %d", new Object[]{Integer.valueOf(linkedList3.size())});
            linkedList2 = linkedList3;
        }
        return linkedList2;
    }

    public final void a(j jVar) {
        if (!this.iQx.acn()) {
            synchronized (this.iQx.mLock) {
                if (System.currentTimeMillis() - this.iQx.iQb <= 16 || this.iQP) {
                    this.iQR.add(jVar);
                    long currentTimeMillis = System.currentTimeMillis();
                    synchronized (this.iQx.mLock) {
                        if (!this.iQP || currentTimeMillis - this.iQQ >= 32) {
                            this.iQQ = currentTimeMillis;
                            if (bh.cA(this.iQR)) {
                            } else {
                                this.iQP = true;
                                int currentTimeMillis2 = (int) (16 - (System.currentTimeMillis() - this.iQx.iQb));
                                if (currentTimeMillis2 <= 0) {
                                    currentTimeMillis2 = 16;
                                }
                                c.Dm().g(new 2(this), (long) currentTimeMillis2);
                            }
                        }
                    }
                    return;
                }
            }
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(jVar);
        a(linkedList, true);
    }

    final synchronized void a(LinkedList<j> linkedList, boolean z) {
        a(linkedList, z, false);
    }

    private synchronized void a(LinkedList<j> linkedList, boolean z, boolean z2) {
        if (!bh.cA(linkedList)) {
            a com_tencent_mm_protocal_c_bvz = new bvz();
            com_tencent_mm_protocal_c_bvz.wXj = this.iQx.iPU;
            com_tencent_mm_protocal_c_bvz.wXk = this.iQx.acj();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                com_tencent_mm_protocal_c_bvz.wWZ.add(((j) it.next()).iQG);
            }
            bvm a = o.a(1006, com_tencent_mm_protocal_c_bvz);
            if (!this.iQx.isBusy() || z2) {
                x.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg size %d", new Object[]{Integer.valueOf(linkedList.size())});
                this.iQA.a(a);
            } else {
                x.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg busy");
            }
            if (z) {
                s(linkedList);
            }
            int i = a.pK;
            g gVar = this.iQx;
            gVar.iQb = System.currentTimeMillis();
            gVar.iQd = System.currentTimeMillis();
            if (!this.iQx.isBusy()) {
                this.iQT = 0;
            }
            f fVar = new f();
            fVar.size = a.bke();
            fVar.iPS = System.currentTimeMillis();
            this.iQx.iQm.put(a.ned, fVar);
        }
    }

    private synchronized void s(LinkedList<j> linkedList) {
        x.d("MicroMsg.RemoteDebugMsgMrg", "addToSendingMsg");
        if (!bh.cA(linkedList)) {
            this.iQx.iQl.addAll(linkedList);
        }
    }

    public final synchronized void acq() {
        int i = 0;
        synchronized (this) {
            if (!this.iQx.isBusy()) {
                long currentTimeMillis = System.currentTimeMillis();
                LinkedList linkedList = new LinkedList();
                Iterator it = this.iQx.iQl.iterator();
                while (it.hasNext()) {
                    int i2;
                    j jVar = (j) it.next();
                    if (currentTimeMillis - jVar.iPS > 5000) {
                        jVar.iPS = System.currentTimeMillis();
                        linkedList.add(jVar);
                        i2 = jVar.iQH + i;
                        if (((long) i2) >= HardCoderJNI.ACTION_ALLOC_MEMORY || linkedList.size() > 800) {
                            x.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", new Object[]{Integer.valueOf(linkedList.size())});
                            a(linkedList, false);
                            linkedList.clear();
                            break;
                        }
                    } else {
                        i2 = i;
                    }
                    i = i2;
                }
                if (!bh.cA(linkedList)) {
                    x.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", new Object[]{Integer.valueOf(linkedList.size())});
                    a(linkedList, false);
                }
            }
        }
    }

    public final synchronized boolean acr() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.iQU < ((long) this.iQT)) {
            z = false;
        } else {
            j jVar;
            this.iQU = currentTimeMillis;
            if (this.iQT < 5000) {
                this.iQT += 1000;
            } else {
                this.iQT = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
            }
            LinkedList linkedList = new LinkedList();
            Iterator it = this.iQx.iQl.iterator();
            while (it.hasNext()) {
                jVar = (j) it.next();
                if (currentTimeMillis - jVar.iPS > 5000) {
                    jVar.iPS = System.currentTimeMillis();
                    linkedList.add(jVar);
                    a(linkedList, false, true);
                    z = true;
                    break;
                }
            }
            if (this.iQx.iQl.size() > 0) {
                jVar = (j) this.iQx.iQl.get(0);
                jVar.iPS = System.currentTimeMillis();
                linkedList.add(jVar);
                a(linkedList, false, true);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final void quit() {
        x.i("MicroMsg.RemoteDebugMsgMrg", "quit");
        a com_tencent_mm_protocal_c_bwi = new bwi();
        com_tencent_mm_protocal_c_bwi.wXj = this.iQx.iPU;
        this.iQA.a(o.a(1004, com_tencent_mm_protocal_c_bwi));
    }

    public final synchronized void bC(int i, int i2) {
        x.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg with min max");
        Collection linkedList = new LinkedList();
        Iterator it = this.iQx.iQl.iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            if (jVar.iQG == null) {
                linkedList.add(jVar);
            } else if (jVar.iQG.hOH >= i && jVar.iQG.hOH <= i2) {
                linkedList.add(jVar);
            }
        }
        this.iQx.iQl.removeAll(linkedList);
    }

    public final synchronized void acs() {
        x.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg");
        Collection linkedList = new LinkedList();
        Iterator it = this.iQx.iQl.iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            if (jVar.iQG == null) {
                linkedList.add(jVar);
            } else if (jVar.iQG.hOH <= this.iQx.ack()) {
                linkedList.add(jVar);
            }
        }
        this.iQx.iQl.removeAll(linkedList);
    }

    public final void act() {
        x.i("MicroMsg.RemoteDebugMsgMrg", "onClose");
        if (this.bnp != null) {
            this.bnp.cancel();
        }
    }
}
