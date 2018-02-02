package com.tencent.mm.modelmulti;

import android.database.Cursor;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.atj;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.protocal.c.om;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public final class t {
    private static ArrayList<bw> hHI = new ArrayList();
    private static ArrayList<x> hHJ = new ArrayList();

    static /* synthetic */ void lK(String str) {
        Throwable e;
        int i = 0;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        i++;
                        String[] split = readLine.split("###");
                        if (split == null || split.length != 3) {
                            String str2 = "MicroMsg.TestSyncAddMsg";
                            String str3 = "readMsgFromFile parse line %d failed : len:%d ";
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(i);
                            objArr[1] = Integer.valueOf(split == null ? -1 : split.length);
                            com.tencent.mm.sdk.platformtools.x.e(str2, str3, objArr);
                        } else {
                            bw bwVar = new bw();
                            bwVar.vGY = new bdo().UA(q.FS());
                            bwVar.ktm = 2;
                            bwVar.vHb = new bdn().bj(new byte[0]);
                            bwVar.ngq = bh.getInt(split[0], 0);
                            bwVar.vHa = bh.getInt(split[1], 0);
                            bwVar.vGZ = new bdo().UA(split[2]);
                            hHI.add(bwVar);
                        }
                    } else {
                        try {
                            bufferedReader.close();
                            return;
                        } catch (Exception e2) {
                            return;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
        } catch (Exception e4) {
            e = e4;
            bufferedReader = null;
            try {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.TestSyncAddMsg", "readMsgFromFile failed e:%s", e.getMessage());
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.TestSyncAddMsg", e, "", new Object[0]);
                try {
                    bufferedReader.close();
                } catch (Exception e5) {
                }
            } catch (Throwable th) {
                e = th;
                try {
                    bufferedReader.close();
                } catch (Exception e6) {
                }
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            bufferedReader.close();
            throw e;
        }
    }

    static /* synthetic */ void ub() {
        ar.Hg();
        Cursor c = c.EY().c(null, null, new ArrayList());
        while (c.moveToNext()) {
            x xVar = new x();
            xVar.b(c);
            hHJ.add(xVar);
        }
        c.close();
    }

    public static void bd(final int i, final int i2) {
        ar.Dm().F(new Runnable() {
            public final void run() {
                t.ub();
                t.lK(e.bnF + "/testaddmsg.txt");
                if (t.hHJ.size() <= 0 || t.hHI.size() <= 0) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.TestSyncAddMsg", "syncAddMsg get source failed cmd:%d contact:%d", Integer.valueOf(t.hHI.size()), Integer.valueOf(t.hHJ.size()));
                    return;
                }
                new ak(ar.Dm().oAt.getLooper(), new a(this) {
                    int hHM = i;
                    final /* synthetic */ AnonymousClass1 hHN;

                    {
                        this.hHN = r2;
                    }

                    public final boolean uF() {
                        if (this.hHM <= 0) {
                            return false;
                        }
                        this.hHM--;
                        b bVar = new b();
                        bVar.vBR.vRD = new om();
                        int eF = bh.eF(i2, 1);
                        for (int i = 0; i < eF; i++) {
                            bw bwVar = (bw) t.hHI.get(bh.eF(t.hHI.size() - 1, 0));
                            bwVar.vGX = new bdo().UA(((x) t.hHJ.get(bh.eF(t.hHJ.size() - 1, 0))).field_username);
                            bwVar.pbl = (int) bh.Wo();
                            bwVar.vHe = (long) Math.abs(((int) bh.Wp()) % 10000000);
                            try {
                                ol olVar = new ol();
                                olVar.vXq = new bdn();
                                olVar.vXq.bj(bwVar.toByteArray());
                                olVar.vXp = 5;
                                bVar.vBR.vRD.ksP.add(olVar);
                                om omVar = bVar.vBR.vRD;
                                omVar.ksO++;
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.TestSyncAddMsg", "syncAddMsg  loop:%d cnt:[%d,%d] cmdList:%d id:%d u:%s", Integer.valueOf(this.hHM), Integer.valueOf(i), Integer.valueOf(eF), Integer.valueOf(bVar.vBR.vRD.ksP.size()), Long.valueOf(bwVar.vHe), bwVar.vGX.wJF);
                            } catch (Throwable e) {
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.TestSyncAddMsg", e.getMessage());
                                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.TestSyncAddMsg", e, "", new Object[0]);
                            }
                        }
                        bVar.vBR.vPq = 0;
                        atj com_tencent_mm_protocal_c_atj = bVar.vBR;
                        ar.Hg();
                        com_tencent_mm_protocal_c_atj.vRA = n.N(bh.VD(bh.ou((String) c.CU().get(8195, new byte[0]))));
                        bVar.vBR.vJU = 0;
                        bVar.vBR.ktm = 0;
                        q.Qc().a(bVar, 0, bh.Wo());
                        return true;
                    }
                }, true).J(3000, 3000);
            }
        });
    }
}
