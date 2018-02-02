package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.g.d;
import com.tencent.mm.plugin.sns.g.e;
import com.tencent.mm.plugin.sns.g.f;
import com.tencent.mm.protocal.c.bje;
import com.tencent.mm.protocal.c.bjf;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class ac {
    String gze = "";
    private String path;
    private d qVj;
    private List<Integer> qVk = new Vector();
    private Map<String, Integer> qVl = new HashMap();
    private List<Integer> qVm = new Vector();
    private Map<Integer, Integer> qVn = new HashMap();

    public static boolean Kh(String str) {
        if (str != null && str.startsWith("_AD_TAG_")) {
            return true;
        }
        return false;
    }

    public ac(String str) {
        this.path = str;
        if (!buY()) {
            this.qVj = new d();
        }
        this.qVk.clear();
        this.qVl.clear();
    }

    public final synchronized void buW() {
        if (!ah(this.qVj.raJ)) {
            if (!ah(this.qVj.raK) && !ah(this.qVj.raL) && !ah(this.qVj.raM)) {
                f fVar;
                long j;
                while (!this.qVj.raN.isEmpty()) {
                    fVar = (f) this.qVj.raN.getFirst();
                    if (bh.by((long) fVar.raQ) <= 21600) {
                        j = fVar.raS;
                        g.Dk();
                        g.Di().gPJ.a(new q(j, 1), 0);
                        break;
                    }
                    this.qVj.raN.removeFirst();
                }
                while (!this.qVj.raO.isEmpty()) {
                    fVar = (f) this.qVj.raO.getFirst();
                    if (bh.by((long) fVar.raQ) <= 21600) {
                        j = fVar.raS;
                        g.Dk();
                        g.Di().gPJ.a(new q(j, 5), 0);
                        break;
                    }
                    this.qVj.raO.removeFirst();
                }
            }
        }
    }

    private static boolean ah(LinkedList<e> linkedList) {
        while (!linkedList.isEmpty()) {
            e eVar = (e) linkedList.getFirst();
            if (bh.by((long) eVar.raQ) > 21600) {
                linkedList.removeFirst();
            } else {
                if (Kh(eVar.raP)) {
                    g.Dk();
                    g.Di().gPJ.a(new j(eVar.qTH, eVar.raP, eVar.raR), 0);
                } else {
                    g.Dk();
                    g.Di().gPJ.a(new n(eVar.qTH, eVar.raP), 0);
                }
                return true;
            }
        }
        return false;
    }

    public final synchronized boolean eC(long j) {
        boolean z;
        Iterator it = this.qVj.raN.iterator();
        while (it.hasNext()) {
            if (((f) it.next()).raS == j) {
                z = false;
                break;
            }
        }
        z = true;
        return z;
    }

    public final synchronized void eD(long j) {
        f fVar = new f();
        fVar.raS = j;
        fVar.raQ = (int) bh.Wo();
        this.qVj.raN.add(fVar);
        buX();
    }

    final synchronized void eE(long j) {
        Object obj;
        Iterator it = this.qVj.raN.iterator();
        while (it.hasNext()) {
            obj = (f) it.next();
            if (obj.raS == j) {
                break;
            }
        }
        obj = null;
        if (obj != null) {
            this.qVj.raN.remove(obj);
        }
        buX();
    }

    private static boolean a(LinkedList<bjk> linkedList, String str, int i) {
        if (bh.ov(str)) {
            return true;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bjk com_tencent_mm_protocal_c_bjk = (bjk) it.next();
            if (str.equals(com_tencent_mm_protocal_c_bjk.nje) && i == com_tencent_mm_protocal_c_bjk.pbl) {
                return true;
            }
        }
        return false;
    }

    public final synchronized bjv c(bjv com_tencent_mm_protocal_c_bjv) {
        if (bh.ov(this.gze)) {
            this.gze = q.FS();
        }
        if (!(this.qVj.raJ.size() == 0 && this.qVj.raK.size() == 0)) {
            e eVar;
            bjk com_tencent_mm_protocal_c_bjk;
            long j = com_tencent_mm_protocal_c_bjv.vPO;
            Iterator it = this.qVj.raJ.iterator();
            while (it.hasNext()) {
                eVar = (e) it.next();
                bjk a = a(eVar.qTH);
                if (eVar.qTH.vPO == j && !a(com_tencent_mm_protocal_c_bjv.wNa, a.nje, a.pbl)) {
                    com_tencent_mm_protocal_c_bjv.wNa.add(a);
                    com_tencent_mm_protocal_c_bjv.wMY++;
                }
            }
            Iterator it2 = com_tencent_mm_protocal_c_bjv.wNa.iterator();
            while (it2.hasNext()) {
                com_tencent_mm_protocal_c_bjk = (bjk) it2.next();
                if (com_tencent_mm_protocal_c_bjk.vIy.equals(this.gze)) {
                    Object obj = null;
                    Iterator it3 = this.qVj.raO.iterator();
                    while (it3.hasNext()) {
                        Object obj2;
                        if (((f) it3.next()).raS == j) {
                            com_tencent_mm_protocal_c_bjv.wNa.remove(com_tencent_mm_protocal_c_bjk);
                            com_tencent_mm_protocal_c_bjv.wMY--;
                            obj2 = 1;
                        } else {
                            obj2 = obj;
                        }
                        obj = obj2;
                    }
                    if (obj != null) {
                        break;
                    }
                }
            }
            it = this.qVj.raK.iterator();
            while (it.hasNext()) {
                eVar = (e) it.next();
                if (eVar.qTH.vPO == j) {
                    com_tencent_mm_protocal_c_bjk = a(eVar.qTH);
                    if (!a(com_tencent_mm_protocal_c_bjv.wNd, com_tencent_mm_protocal_c_bjk.nje, com_tencent_mm_protocal_c_bjk.pbl)) {
                        com_tencent_mm_protocal_c_bjv.wNd.add(com_tencent_mm_protocal_c_bjk);
                        com_tencent_mm_protocal_c_bjv.wNb++;
                    }
                }
            }
        }
        return com_tencent_mm_protocal_c_bjv;
    }

    public static bjk a(bjf com_tencent_mm_protocal_c_bjf) {
        bje com_tencent_mm_protocal_c_bje = com_tencent_mm_protocal_c_bjf.wMD;
        bje com_tencent_mm_protocal_c_bje2 = com_tencent_mm_protocal_c_bjf.wME;
        bjk com_tencent_mm_protocal_c_bjk = new bjk();
        com_tencent_mm_protocal_c_bjk.nje = com_tencent_mm_protocal_c_bje.nje;
        com_tencent_mm_protocal_c_bjk.pbl = com_tencent_mm_protocal_c_bje.pbl;
        com_tencent_mm_protocal_c_bjk.wvW = com_tencent_mm_protocal_c_bje.wMt;
        com_tencent_mm_protocal_c_bjk.vHW = com_tencent_mm_protocal_c_bje.vHW;
        com_tencent_mm_protocal_c_bjk.ktN = com_tencent_mm_protocal_c_bje.ktN;
        com_tencent_mm_protocal_c_bjk.vIy = com_tencent_mm_protocal_c_bje.wFM;
        com_tencent_mm_protocal_c_bjk.wMw = com_tencent_mm_protocal_c_bje.wMw;
        com_tencent_mm_protocal_c_bjk.wMz = com_tencent_mm_protocal_c_bje.wMz;
        com_tencent_mm_protocal_c_bjk.wMB = com_tencent_mm_protocal_c_bje.wMB;
        com_tencent_mm_protocal_c_bjk.wMQ = com_tencent_mm_protocal_c_bje2.wFM;
        com_tencent_mm_protocal_c_bjk.wMy = com_tencent_mm_protocal_c_bje2.wMy;
        com_tencent_mm_protocal_c_bjk.wMv = com_tencent_mm_protocal_c_bje2.wMv;
        return com_tencent_mm_protocal_c_bjk;
    }

    public final boolean a(String str, bjf com_tencent_mm_protocal_c_bjf) {
        return a(str, com_tencent_mm_protocal_c_bjf, "");
    }

    public final synchronized boolean a(String str, bjf com_tencent_mm_protocal_c_bjf, String str2) {
        boolean z = true;
        synchronized (this) {
            e eVar = new e();
            eVar.raP = str;
            eVar.qTH = com_tencent_mm_protocal_c_bjf;
            eVar.raQ = (int) bh.Wo();
            eVar.raR = str2;
            switch (com_tencent_mm_protocal_c_bjf.wMD.ktN) {
                case 1:
                    this.qVj.raJ.add(eVar);
                    if (eG(com_tencent_mm_protocal_c_bjf.vPO)) {
                        z = false;
                        break;
                    }
                    break;
                case 2:
                    this.qVj.raK.add(eVar);
                    break;
                case 3:
                    this.qVj.raL.add(eVar);
                    break;
                case 5:
                    this.qVj.raM.add(eVar);
                    break;
                case 7:
                    this.qVj.raJ.add(eVar);
                    if (eG(com_tencent_mm_protocal_c_bjf.vPO)) {
                        z = false;
                        break;
                    }
                    break;
                case 8:
                    this.qVj.raK.add(eVar);
                    break;
            }
            if (!buX()) {
                x.e("MicroMsg.SnsAsyncQueueMgr", "error listToFile");
            }
        }
        return z;
    }

    public final void c(long j, int i, String str) {
        ai.bvO();
        d(j, i, str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void d(long j, int i, String str) {
        switch (i) {
            case 1:
                a(j, this.qVj.raJ, str);
            case 2:
                a(j, this.qVj.raK, str);
            case 3:
                a(j, this.qVj.raL, str);
                buX();
            case 5:
                a(j, this.qVj.raM, str);
                buX();
            case 7:
                a(j, this.qVj.raJ, str);
                buX();
            case 8:
                a(j, this.qVj.raK, str);
                buX();
        }
        buX();
    }

    private static void a(long j, LinkedList<e> linkedList, String str) {
        a(j, linkedList, str, false);
    }

    private static boolean a(long j, LinkedList<e> linkedList, String str, boolean z) {
        Object obj;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            obj = (e) it.next();
            if (obj.qTH.vPO == j && (z || obj.raP.equals(str))) {
                break;
            }
        }
        obj = null;
        if (obj == null) {
            return false;
        }
        linkedList.remove(obj);
        return true;
    }

    public final synchronized boolean eF(long j) {
        boolean z = true;
        synchronized (this) {
            f fVar = new f();
            fVar.raS = j;
            fVar.raQ = (int) bh.Wo();
            this.qVj.raO.add(fVar);
            buX();
            if (a(j, this.qVj.raJ, "", true)) {
                z = false;
            }
        }
        return z;
    }

    final synchronized boolean eG(long j) {
        boolean z;
        Object obj;
        Iterator it = this.qVj.raO.iterator();
        while (it.hasNext()) {
            obj = (f) it.next();
            if (obj.raS == j) {
                break;
            }
        }
        obj = null;
        if (obj != null) {
            this.qVj.raO.remove(obj);
            z = true;
        } else {
            z = false;
        }
        buX();
        return z;
    }

    private synchronized boolean buX() {
        boolean z = false;
        synchronized (this) {
            try {
                byte[] toByteArray = this.qVj.toByteArray();
                if (FileOp.b(this.path, toByteArray, toByteArray.length) == 0) {
                    z = true;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", e, "listToFile failed: " + this.path, new Object[0]);
                FileOp.deleteFile(this.path);
            }
        }
        return z;
    }

    private synchronized boolean buY() {
        boolean z;
        byte[] d = FileOp.d(this.path, 0, -1);
        if (d == null) {
            z = false;
        } else {
            try {
                this.qVj = (d) new d().aF(d);
                z = true;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsAsyncQueueMgr", e, "", new Object[0]);
                FileOp.deleteFile(this.path);
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean wA(int i) {
        return this.qVk.contains(Integer.valueOf(i));
    }

    public final synchronized boolean wB(int i) {
        boolean z;
        if (this.qVk.contains(Integer.valueOf(i))) {
            z = false;
        } else {
            this.qVk.add(Integer.valueOf(i));
            z = true;
        }
        return z;
    }

    public final synchronized boolean wC(int i) {
        this.qVk.remove(Integer.valueOf(i));
        return true;
    }

    public final synchronized boolean isDownloading(String str) {
        return this.qVl.containsKey(str);
    }

    public final synchronized boolean Ki(String str) {
        boolean z = false;
        synchronized (this) {
            if (!this.qVl.containsKey(str)) {
                this.qVl.put(str, Integer.valueOf(0));
                z = true;
            }
        }
        return z;
    }

    public final synchronized boolean Kj(String str) {
        this.qVl.remove(str);
        return true;
    }

    public final synchronized int buZ() {
        return this.qVl.size();
    }

    public final synchronized boolean wD(int i) {
        boolean z;
        if (this.qVm.contains(Integer.valueOf(i))) {
            z = false;
        } else {
            this.qVm.add(Integer.valueOf(i));
            z = true;
        }
        return z;
    }

    public final synchronized boolean wE(int i) {
        this.qVm.remove(Integer.valueOf(i));
        this.qVn.remove(Integer.valueOf(i));
        return true;
    }

    public final synchronized boolean du(int i, int i2) {
        this.qVn.put(Integer.valueOf(i), Integer.valueOf(i2));
        return true;
    }

    public final synchronized boolean wF(int i) {
        this.qVn.remove(Integer.valueOf(i));
        return true;
    }

    public final synchronized int wG(int i) {
        int intValue;
        if (this.qVn.containsKey(Integer.valueOf(i))) {
            intValue = ((Integer) this.qVn.get(Integer.valueOf(i))).intValue();
        } else {
            intValue = -1;
        }
        return intValue;
    }
}
