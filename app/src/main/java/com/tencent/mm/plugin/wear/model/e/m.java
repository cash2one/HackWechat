package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.protocal.c.bma;
import com.tencent.mm.protocal.c.byj;
import com.tencent.mm.protocal.c.bzd;
import com.tencent.mm.protocal.c.bze;
import com.tencent.mm.protocal.c.bzf;
import com.tencent.mm.protocal.c.bzg;
import com.tencent.mm.protocal.c.bzk;
import com.tencent.mm.protocal.c.caj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class m extends a {
    public final List<Integer> bOG() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11022));
        arrayList.add(Integer.valueOf(11023));
        arrayList.add(Integer.valueOf(11025));
        arrayList.add(Integer.valueOf(11024));
        arrayList.add(Integer.valueOf(11026));
        arrayList.add(Integer.valueOf(11029));
        return arrayList;
    }

    protected final boolean zC(int i) {
        switch (i) {
            case 11023:
            case 11025:
                return true;
            default:
                return false;
        }
    }

    protected final byte[] n(int i, byte[] bArr) {
        switch (i) {
            case 11022:
                bzg com_tencent_mm_protocal_c_bzg = new bzg();
                try {
                    com_tencent_mm_protocal_c_bzg.aF(bArr);
                } catch (IOException e) {
                }
                a.bOt().thN.a(new a(com_tencent_mm_protocal_c_bzg));
                a.bOt().thJ.NJ(com_tencent_mm_protocal_c_bzg.wYG);
                com.tencent.mm.plugin.wear.model.c.a.ee(2, com_tencent_mm_protocal_c_bzg.rYW);
                com.tencent.mm.plugin.wear.model.c.a.zA(2);
                break;
            case 11023:
                bzf com_tencent_mm_protocal_c_bzf = new bzf();
                try {
                    com_tencent_mm_protocal_c_bzf.aF(bArr);
                } catch (IOException e2) {
                }
                f.aZh().A(com_tencent_mm_protocal_c_bzf.wYG, com_tencent_mm_protocal_c_bzf.weY, s.hp(com_tencent_mm_protocal_c_bzf.wYG));
                ar.Hg();
                c.Fd().Xa(com_tencent_mm_protocal_c_bzf.wYG);
                com.tencent.mm.plugin.wear.model.c.a.ee(3, com_tencent_mm_protocal_c_bzf.rYW);
                com.tencent.mm.plugin.wear.model.c.a.zA(5);
                break;
            case 11024:
                bzd com_tencent_mm_protocal_c_bzd = new bzd();
                try {
                    com_tencent_mm_protocal_c_bzd.aF(bArr);
                } catch (IOException e3) {
                }
                ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().m(ac.getContext(), com_tencent_mm_protocal_c_bzd.wYG, com_tencent_mm_protocal_c_bzd.vZU);
                ar.Hg();
                c.Fd().Xa(com_tencent_mm_protocal_c_bzd.wYG);
                com.tencent.mm.plugin.wear.model.c.a.ee(7, com_tencent_mm_protocal_c_bzd.rYW);
                com.tencent.mm.plugin.wear.model.c.a.zA(3);
                break;
            case 11025:
                bze com_tencent_mm_protocal_c_bze = new bze();
                try {
                    com_tencent_mm_protocal_c_bze.aF(bArr);
                } catch (IOException e4) {
                }
                f.aZh().A(com_tencent_mm_protocal_c_bze.wYG, com_tencent_mm_protocal_c_bze.weY, s.hp(com_tencent_mm_protocal_c_bze.wYG));
                ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().m(ac.getContext(), com_tencent_mm_protocal_c_bze.wYG, com_tencent_mm_protocal_c_bze.vZU);
                ar.Hg();
                c.Fd().Xa(com_tencent_mm_protocal_c_bze.wYG);
                com.tencent.mm.plugin.wear.model.c.a.ee(8, com_tencent_mm_protocal_c_bze.rYW);
                com.tencent.mm.plugin.wear.model.c.a.zA(4);
                break;
            case 11026:
                bzk com_tencent_mm_protocal_c_bzk = new bzk();
                try {
                    com_tencent_mm_protocal_c_bzk.aF(bArr);
                } catch (IOException e5) {
                }
                a.bOt();
                byj com_tencent_mm_protocal_c_byj = a.bOt().thH.thY.tiP;
                if (com_tencent_mm_protocal_c_byj != null) {
                    x.i("MicroMsg.Wear.WearBizLogic", "receive step count %d | time %s", Integer.valueOf(com_tencent_mm_protocal_c_bzk.wZg), n.ag("yyyy-MM-dd HH:mm:ss", com_tencent_mm_protocal_c_bzk.wZh / 1000));
                    caj com_tencent_mm_protocal_c_caj = new caj();
                    bma com_tencent_mm_protocal_c_bma = new bma();
                    com_tencent_mm_protocal_c_bma.ktL = com_tencent_mm_protocal_c_bzk.wZg > 0 ? com_tencent_mm_protocal_c_bzk.wZg : 0;
                    com_tencent_mm_protocal_c_bma.waZ = (int) (com_tencent_mm_protocal_c_bzk.wZh / 1000);
                    Calendar instance = Calendar.getInstance();
                    instance.setTimeInMillis(com_tencent_mm_protocal_c_bzk.wZh);
                    com_tencent_mm_protocal_c_bma.wPB = instance.get(1);
                    com_tencent_mm_protocal_c_bma.wPC = instance.get(2) + 1;
                    com_tencent_mm_protocal_c_bma.wPD = instance.get(5);
                    com_tencent_mm_protocal_c_bma.wPE = instance.get(11);
                    com_tencent_mm_protocal_c_bma.wPF = instance.get(12);
                    com_tencent_mm_protocal_c_bma.wPG = instance.get(13);
                    com_tencent_mm_protocal_c_caj.wZU.add(com_tencent_mm_protocal_c_bma);
                    b tlVar = new tl();
                    try {
                        tlVar.fMa.data = com_tencent_mm_protocal_c_caj.toByteArray();
                    } catch (IOException e6) {
                    }
                    tlVar.fMa.fpr = 4;
                    tlVar.fMa.ffq = com_tencent_mm_protocal_c_byj.wYz;
                    tlVar.fMa.frg = "gh_43f2581f6fd6";
                    com.tencent.mm.sdk.b.a.xef.m(tlVar);
                    break;
                }
                x.e("MicroMsg.Wear.WearBizLogic", "logicRequest is null");
                break;
            case 11029:
                if (a.bOt().thH.bOy() && com.tencent.mm.k.g.zY().getInt("WearLuckyBlock", 0) == 0) {
                    long j = 0;
                    try {
                        j = Long.valueOf(new String(bArr)).longValue();
                    } catch (Exception e7) {
                    }
                    b tjVar = new tj();
                    tjVar.fLO.action = 1;
                    tjVar.fLO.fpG = j;
                    com.tencent.mm.sdk.b.a.xef.a(tjVar, Looper.getMainLooper());
                    com.tencent.mm.plugin.wear.model.c.a.ee(11, 0);
                    com.tencent.mm.plugin.wear.model.c.a.zA(11);
                    break;
                }
                return null;
                break;
        }
        return null;
    }
}
