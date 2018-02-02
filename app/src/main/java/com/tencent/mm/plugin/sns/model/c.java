package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.bnq;
import com.tencent.mm.protocal.c.uo;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class c {
    public static void d(String str, long j, long j2, int i) {
        if (j2 != 0) {
            wk wkVar;
            wk Lo = ae.bvz().Lo(str);
            if (Lo == null) {
                wkVar = new wk();
            } else {
                wkVar = Lo;
            }
            if (j != 0 || !wkVar.wgK.isEmpty()) {
                if (j == 0) {
                    j = ((uo) wkVar.wgK.getFirst()).wcw;
                }
                uo uoVar = new uo();
                uoVar.wcw = j;
                uoVar.wcx = j2;
                bnq com_tencent_mm_protocal_c_bnq = new bnq();
                com_tencent_mm_protocal_c_bnq.wQw = j;
                com_tencent_mm_protocal_c_bnq.wQx = j2;
                com_tencent_mm_protocal_c_bnq.wQy = i;
                uoVar.wcy.add(com_tencent_mm_protocal_c_bnq);
                uo uoVar2 = uoVar;
                while (!wkVar.wgK.isEmpty()) {
                    uoVar = (uo) wkVar.wgK.getFirst();
                    if (A(uoVar2.wcx, uoVar.wcw) > 0) {
                        x.e("MicroMsg.FaultLogic", "has a fault: newerMin:" + uoVar2.wcx + " fault.Max" + uoVar.wcw);
                        break;
                    } else {
                        wkVar.wgK.removeFirst();
                        uoVar2 = a(uoVar, uoVar2);
                    }
                }
                wkVar.wgK.addFirst(uoVar2);
                while (wkVar.wgK.size() > 100) {
                    wkVar.wgK.removeLast();
                }
                if (wkVar.wgK.size() > 0) {
                    x.d("MicroMsg.FaultLogic", "min " + ((uo) wkVar.wgK.get(0)).wcx + " max " + ((uo) wkVar.wgK.get(0)).wcw);
                }
                k Lq = ae.bvz().Lq(str);
                try {
                    Lq.field_userName = str;
                    Lq.field_faultS = wkVar.toByteArray();
                    ae.bvz().c(Lq);
                } catch (Exception e) {
                }
                if (wkVar.wgK.size() > 1) {
                    x.d("MicroMsg.FaultLogic", "fault size : " + wkVar.wgK.size());
                    Iterator it = wkVar.wgK.iterator();
                    while (it.hasNext()) {
                        uoVar = (uo) it.next();
                        x.d("MicroMsg.FaultLogic", "min - max " + uoVar.wcx + " " + uoVar.wcw);
                    }
                }
            }
        }
    }

    private static uo a(uo uoVar, uo uoVar2) {
        uo uoVar3 = new uo();
        if (A(uoVar.wcw, uoVar2.wcw) > 0) {
            uoVar3.wcw = uoVar.wcw;
        } else {
            uoVar3.wcw = uoVar2.wcw;
        }
        if (A(uoVar.wcx, uoVar2.wcx) < 0) {
            uoVar3.wcx = uoVar.wcx;
        } else {
            uoVar3.wcx = uoVar2.wcx;
        }
        LinkedList linkedList = uoVar.wcy;
        Iterator it = uoVar2.wcy.iterator();
        while (it.hasNext()) {
            bnq com_tencent_mm_protocal_c_bnq = (bnq) it.next();
            if (linkedList.isEmpty()) {
                x.e("MicroMsg.FaultLogic", "fault's segments should not empty!!");
                linkedList.addFirst(com_tencent_mm_protocal_c_bnq);
            } else {
                long j = com_tencent_mm_protocal_c_bnq.wQx;
                int size = linkedList.size() - 1;
                while (size >= 0) {
                    if (A(j, ((bnq) linkedList.get(size)).wQw) <= 0) {
                        break;
                    }
                    size--;
                }
                size = -1;
                j = com_tencent_mm_protocal_c_bnq.wQw;
                int i = 0;
                while (i < linkedList.size()) {
                    if (A(j, ((bnq) linkedList.get(i)).wQx) >= 0) {
                        break;
                    }
                    i++;
                }
                i = linkedList.size();
                if (size == -1) {
                    linkedList.addFirst(com_tencent_mm_protocal_c_bnq);
                } else if (i == linkedList.size()) {
                    linkedList.addLast(com_tencent_mm_protocal_c_bnq);
                } else {
                    bnq com_tencent_mm_protocal_c_bnq2 = (bnq) linkedList.get(i);
                    if (A(com_tencent_mm_protocal_c_bnq.wQw, com_tencent_mm_protocal_c_bnq2.wQw) < 0) {
                        bnq com_tencent_mm_protocal_c_bnq3 = new bnq();
                        com_tencent_mm_protocal_c_bnq3.wQw = com_tencent_mm_protocal_c_bnq2.wQw;
                        j = com_tencent_mm_protocal_c_bnq.wQw;
                        com_tencent_mm_protocal_c_bnq3.wQx = j == Long.MAX_VALUE ? Long.MIN_VALUE : j + 1;
                        com_tencent_mm_protocal_c_bnq3.wQy = com_tencent_mm_protocal_c_bnq2.wQy;
                        linkedList.add(i, com_tencent_mm_protocal_c_bnq3);
                        int i2 = i + 1;
                        i = size + 1;
                        size = i2;
                    } else {
                        int i3 = i;
                        i = size;
                        size = i3;
                    }
                    com_tencent_mm_protocal_c_bnq2 = (bnq) linkedList.get(i);
                    if (A(com_tencent_mm_protocal_c_bnq.wQx, com_tencent_mm_protocal_c_bnq2.wQx) > 0) {
                        bnq com_tencent_mm_protocal_c_bnq4 = new bnq();
                        com_tencent_mm_protocal_c_bnq4.wQx = com_tencent_mm_protocal_c_bnq2.wQx;
                        com_tencent_mm_protocal_c_bnq4.wQw = eu(com_tencent_mm_protocal_c_bnq.wQx);
                        com_tencent_mm_protocal_c_bnq4.wQy = com_tencent_mm_protocal_c_bnq2.wQy;
                        linkedList.add(i + 1, com_tencent_mm_protocal_c_bnq4);
                    }
                    while (i >= size) {
                        linkedList.remove(i);
                        i--;
                    }
                    linkedList.add(size, com_tencent_mm_protocal_c_bnq);
                    if (linkedList.size() > 100) {
                        long j2 = ((bnq) linkedList.getLast()).wQx;
                        long j3 = ((bnq) linkedList.getLast()).wQw;
                        int i4 = ((bnq) linkedList.getLast()).wQy;
                        long j4 = j3;
                        while (linkedList.size() >= 100) {
                            int i5;
                            com_tencent_mm_protocal_c_bnq = (bnq) linkedList.removeLast();
                            j3 = com_tencent_mm_protocal_c_bnq.wQw;
                            if (com_tencent_mm_protocal_c_bnq.wQy < i4) {
                                i5 = com_tencent_mm_protocal_c_bnq.wQy;
                            } else {
                                i5 = i4;
                            }
                            i4 = i5;
                            j4 = j3;
                        }
                        bnq com_tencent_mm_protocal_c_bnq5 = new bnq();
                        com_tencent_mm_protocal_c_bnq5.wQw = j4;
                        com_tencent_mm_protocal_c_bnq5.wQx = j2;
                        com_tencent_mm_protocal_c_bnq5.wQy = i4;
                        linkedList.addLast(com_tencent_mm_protocal_c_bnq5);
                    }
                }
            }
        }
        uoVar3.wcy = linkedList;
        return uoVar3;
    }

    private static long A(long j, long j2) {
        if ((j <= 0 || j2 <= 0) && (j >= 0 || j2 >= 0)) {
            return j < 0 ? 1 : -1;
        } else {
            return j - j2;
        }
    }

    public static long eu(long j) {
        if (j == Long.MIN_VALUE) {
            return Long.MAX_VALUE;
        }
        return j - 1;
    }

    public static int a(long j, long j2, String str) {
        LinkedList linkedList = ae.bvz().Lo(str).wgK;
        x.i("MicroMsg.FaultLogic", "getLastReqTimeByMinId fault.count %s", new Object[]{Integer.valueOf(r0.wgK.size())});
        if (linkedList.isEmpty()) {
            return 0;
        }
        uo uoVar = (uo) linkedList.getFirst();
        if (j == 0 || A(uoVar.wcx, j) > 0) {
            x.e("MicroMsg.FaultLogic", "has a fault  minId:" + j2 + " fault.min:" + uoVar.wcx);
            return 0;
        } else if (j2 == 0 || A(uoVar.wcw, j2) >= 0) {
            LinkedList linkedList2 = uoVar.wcy;
            if (linkedList2.isEmpty()) {
                return 0;
            }
            Iterator it = linkedList2.iterator();
            int i = Integer.MAX_VALUE;
            while (it.hasNext()) {
                bnq com_tencent_mm_protocal_c_bnq = (bnq) it.next();
                if (j2 == 0 || A(j2, com_tencent_mm_protocal_c_bnq.wQx) >= 0) {
                    if (com_tencent_mm_protocal_c_bnq.wQy < i) {
                        i = com_tencent_mm_protocal_c_bnq.wQy;
                    }
                    if (A(j, com_tencent_mm_protocal_c_bnq.wQx) >= 0) {
                        if (i == Integer.MAX_VALUE) {
                            return 0;
                        }
                        return i;
                    }
                }
            }
            x.i("MicroMsg.FaultLogic", "should not to hear  minId:" + j);
            return 0;
        } else {
            x.e("MicroMsg.FaultLogic", ":" + j2 + " fault.max:" + uoVar.wcw);
            return 0;
        }
    }
}
