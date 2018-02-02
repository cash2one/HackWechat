package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class aa {
    public static b gxR;
    private static int xfi;
    public static Map<Integer, aa> xfk = new HashMap();
    private static boolean xfm = false;
    public static boolean xfn;
    public long hjC = 0;
    private final boolean hkw;
    public long suO = 0;
    public final int xfj;
    private final a xfl;

    public static void a(b bVar) {
        xfm = true;
        gxR = bVar;
    }

    protected final void finalize() {
        TG();
        super.finalize();
    }

    public aa(a aVar) {
        Assert.assertTrue("bumper not initialized", xfm);
        this.xfl = aVar;
        this.hkw = true;
        if (xfi >= 8192) {
            xfi = 0;
        }
        int i = xfi + 1;
        xfi = i;
        this.xfj = i;
    }

    public static long cfn() {
        xfn = false;
        List linkedList = new LinkedList();
        Set<Integer> hashSet = new HashSet();
        hashSet.addAll(xfk.keySet());
        long j = Long.MAX_VALUE;
        for (Integer num : hashSet) {
            long j2;
            aa aaVar = (aa) xfk.get(num);
            if (aaVar != null) {
                long bA = bh.bA(aaVar.hjC);
                if (bA < 0) {
                    bA = 0;
                }
                if (bA > aaVar.suO) {
                    if (aaVar.xfl.uF() && aaVar.hkw) {
                        j = aaVar.suO;
                    } else {
                        linkedList.add(num);
                    }
                    aaVar.hjC = bh.Wq();
                } else if (aaVar.suO - bA < j) {
                    j2 = aaVar.suO - bA;
                    j = j2;
                }
            }
            j2 = j;
            j = j2;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            xfk.remove(linkedList.get(i));
        }
        if (!(xfn || j != Long.MAX_VALUE || gxR == null)) {
            gxR.cancel();
            x.v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
        }
        return j;
    }

    public final void TG() {
        xfk.remove(Integer.valueOf(this.xfj));
    }

    public static boolean fG(long j) {
        x.d("MicroMsg.MAlarmHandler", "check need prepare: check=" + j);
        long j2 = Long.MAX_VALUE;
        for (Entry value : xfk.entrySet()) {
            long j3;
            aa aaVar = (aa) value.getValue();
            if (aaVar != null) {
                long bA = bh.bA(aaVar.hjC);
                if (bA < 0) {
                    bA = 0;
                }
                if (bA > aaVar.suO) {
                    j2 = aaVar.suO;
                } else if (aaVar.suO - bA < j2) {
                    j3 = aaVar.suO - bA;
                    j2 = j3;
                }
            }
            j3 = j2;
            j2 = j3;
        }
        return j2 > j;
    }
}
