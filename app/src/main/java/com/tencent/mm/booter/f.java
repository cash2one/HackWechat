package com.tencent.mm.booter;

import com.tencent.mm.a.g;
import com.tencent.mm.a.k;
import com.tencent.mm.a.n;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.modelmulti.d;
import com.tencent.mm.network.aa;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;

public final class f {
    public static boolean a(int i, int i2, byte[] bArr, byte[] bArr2, long j) {
        x.i("MicroMsg.NotifySyncMgr", "dealWithNotify Here, MM should NOT bOotEd , opType:%d respType:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 1) {
            az(2);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            switch (i2) {
                case 138:
                    az(bArr == null ? 7 : (long) n.p(bArr, 0));
                    break;
                case 268369921:
                    if (bh.bw(bArr) || bArr.length <= 8) {
                        x.e("MicroMsg.NotifySyncMgr", "dkpush dealWithNotify respBuf error ");
                        break;
                    }
                    int p = n.p(bArr, 0);
                    int p2 = n.p(bArr, 4);
                    x.d("MicroMsg.NotifySyncMgr", "dkpush: flag:" + p + " bufLen:" + p2 + " dump:" + bh.O(bArr, 8));
                    if (p2 != bArr.length - 8) {
                        x.e("MicroMsg.NotifySyncMgr", "dkpush: respBuf length error len:" + bArr.length);
                        break;
                    }
                    Object obj = new byte[p2];
                    System.arraycopy(bArr, 8, obj, 0, p2);
                    e bVar = new b();
                    PByteArray pByteArray = new PByteArray();
                    PByteArray pByteArray2 = new PByteArray();
                    PInt pInt = new PInt();
                    PInt pInt2 = new PInt();
                    PInt pInt3 = new PInt(0);
                    PInt pInt4 = new PInt(255);
                    try {
                        boolean unpack = MMProtocalJni.unpack(pByteArray2, obj, bArr2, pByteArray, pInt, pInt2, pInt3, pInt4);
                        if (pInt3.value != 0) {
                            com.tencent.mm.sdk.b.b hcVar = new hc();
                            hcVar.fxm.fxn = pInt3.value;
                            boolean m = a.xef.m(hcVar);
                            x.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[]{Integer.valueOf(pInt3.value), Boolean.valueOf(m)});
                            pInt3.value = 0;
                        }
                        if (!unpack) {
                            x.e("MicroMsg.NotifySyncMgr", "unpack push resp failed");
                            break;
                        }
                        bVar.vBq = pInt4.value;
                        if (pInt.value != -13) {
                            p2 = bVar.E(pByteArray2.value);
                            x.d("MicroMsg.NotifySyncMgr", "bufToResp using protobuf ok");
                            bVar.vBp = p2;
                            bVar.vBo = (long) obj.length;
                            byte[] VD = bh.VD(ac.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", ""));
                            byte[] a = com.tencent.mm.platformtools.n.a(bVar.vBR.vRA);
                            if (!bh.bw(a) && ad.h(VD, a)) {
                                new d(bVar, p, j).a(aa.VQ(), new 1());
                                if (pInt3.value != 0) {
                                    com.tencent.mm.sdk.b.b hcVar2 = new hc();
                                    hcVar2.fxm.fxn = pInt3.value;
                                    boolean m2 = a.xef.m(hcVar2);
                                    x.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[]{Integer.valueOf(pInt3.value), Boolean.valueOf(m2)});
                                    pInt3.value = 0;
                                    break;
                                }
                            }
                            x.e("MicroMsg.NotifySyncMgr", "compareKeybuf syncKey failed");
                            break;
                        }
                        bVar.vBp = pInt.value;
                        x.e("MicroMsg.NotifySyncMgr", "unpack push resp failed session timeout");
                        break;
                    } catch (Throwable e) {
                        x.e("MicroMsg.NotifySyncMgr", "unpack push resp failed: %s", new Object[]{e});
                        x.printErrStackTrace("MicroMsg.NotifySyncMgr", e, "", new Object[0]);
                    }
                    break;
                case 1000000205:
                    com.tencent.mm.protocal.aa.b bVar2 = new com.tencent.mm.protocal.aa.b();
                    try {
                        bVar2.E(bArr);
                        az(bVar2.vBW);
                        break;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.NotifySyncMgr", e2, "", new Object[0]);
                        break;
                    }
                case 2147480001:
                    az(7);
                    break;
            }
            return true;
        }
    }

    private static void az(long j) {
        x.i("MicroMsg.NotifySyncMgr", "dealWithSelector, selector = " + j);
        if ((256 & j) != 0) {
            a.xef.m(new qg());
        }
        if (((-257 & j) & 2) != 0) {
            new d().a(aa.VQ(), new 2());
        }
    }

    public static byte[] a(PInt pInt, int i) {
        String fj = fj(i);
        int eh = eh(fj);
        for (int i2 = 1; i2 <= eh; i2++) {
            String str = fj + "/syncResp.bin" + i2;
            if (com.tencent.mm.a.e.bO(str)) {
                byte[] e = com.tencent.mm.a.e.e(str, 0, -1);
                if (bh.bw(e)) {
                    x.w("MicroMsg.NotifySyncMgr", "readFile getdata null, read again");
                    e = com.tencent.mm.a.e.e(str, 0, -1);
                }
                byte[] a = k.a(e, g.s((q.yE() + i).getBytes()).getBytes());
                x.i("MicroMsg.NotifySyncMgr", "readFile, index:[%d of %d], dump data:%s -> %s, key:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(eh), B(e), B(a), B(r6.getBytes())});
                if (!bh.bw(a)) {
                    pInt.value = i2;
                    return a;
                }
            }
        }
        return null;
    }

    public static void aL(int i, int i2) {
        String fj = fj(i2);
        int eh = eh(fj);
        com.tencent.mm.loader.stub.b.deleteFile(fj + "/syncResp.bin" + i);
        x.i("MicroMsg.NotifySyncMgr", "consumeData delIndex:%d, total index:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(eh)});
        if (i == eh) {
            com.tencent.mm.loader.stub.b.deleteFile(fj + "/syncResp.ini");
            x.i("MicroMsg.NotifySyncMgr", "consumeData: has consme all respdata");
        }
    }

    public static int eh(String str) {
        int i = 0;
        byte[] e = com.tencent.mm.a.e.e(str + "/syncResp.ini", i, -1);
        if (!bh.bw(e)) {
            try {
                i = Integer.parseInt(new String(e));
            } catch (NumberFormatException e2) {
            }
        }
        return i;
    }

    public static String fj(int i) {
        String str = w.gZK + g.s(("mm" + i).getBytes()) + "/pushSyncResp";
        com.tencent.mm.a.e.bS(str);
        return str;
    }

    public static String B(byte[] bArr) {
        if (bh.bw(bArr)) {
            return "buf is nullOrNil";
        }
        if (bArr.length == 1) {
            return "buf.len is 1: " + Integer.toHexString(bArr[0]);
        }
        return "buf last two[len:" + bArr.length + "]: %s, %s" + Integer.toHexString(bArr[bArr.length - 2] & 255) + ", " + Integer.toHexString(bArr[bArr.length - 1] & 255);
    }
}
