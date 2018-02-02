package com.tencent.mm.plugin.messenger.foundation;

import android.text.TextUtils;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.protocal.c.px;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.vending.b.b;
import com.tencent.mm.z.s;

public final class a implements p {
    private static final a oop = new a((byte) 0);

    public static b a(com.tencent.mm.plugin.messenger.foundation.a.b bVar) {
        return oop.aE(bVar);
    }

    public final void a(ol olVar, byte[] bArr, boolean z, r rVar) {
        switch (olVar.vXp) {
            case 2:
            case 17:
                arp com_tencent_mm_protocal_c_arp = (arp) new arp().aF(bArr);
                String str = "";
                if (!z) {
                    bArr = null;
                }
                a(com_tencent_mm_protocal_c_arp, str, bArr, false, z);
                return;
            case 4:
                px pxVar = (px) new px().aF(bArr);
                String a = n.a(pxVar.vYI);
                x.i("MicroMsg.ContactSyncExtension", "processDelContact user:%s", new Object[]{a});
                ((h) g.h(h.class)).Fd().WX(a);
                s.gH(a);
                com.tencent.mm.plugin.messenger.foundation.a.s.b(4, pxVar);
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(arp com_tencent_mm_protocal_c_arp, String str, byte[] bArr, boolean z, boolean z2) {
        if (com_tencent_mm_protocal_c_arp == null) {
            x.f("MicroMsg.ContactSyncExtension", "unable to parse mod contact");
            return;
        }
        String a = n.a(com_tencent_mm_protocal_c_arp.vYI);
        String ou = bh.ou(com_tencent_mm_protocal_c_arp.wzi);
        if (bh.ov(a) && bh.ov(ou)) {
            x.e("MicroMsg.ContactSyncExtension", "processModContact user is null user:%s enuser:%s", new Object[]{a, ou});
            return;
        }
        x.i("MicroMsg.ContactSyncExtension", "username %s mobileHash %s mobileFullHash %s", new Object[]{com_tencent_mm_protocal_c_arp.vYI, com_tencent_mm_protocal_c_arp.wzl, com_tencent_mm_protocal_c_arp.wzm});
        af WO = ((h) g.h(h.class)).EY().WO(a);
        if (WO == null || !a.equals(WO.field_encryptUsername)) {
            af cig;
            long j;
            int i;
            String str2;
            if (WO != null) {
                cig = WO.cig();
            }
            cig = WO;
            WO = null;
            if (WO == null) {
                WO = new com.tencent.mm.storage.x(a);
            }
            WO.setUsername(a);
            WO.cZ(com_tencent_mm_protocal_c_arp.hvy);
            WO.setType(com_tencent_mm_protocal_c_arp.vXM & com_tencent_mm_protocal_c_arp.vXN);
            if (z && cig != null && ((int) cig.gJd) > 0) {
                x.w("MicroMsg.ContactSyncExtension", "processModContact Fuck GETCONTACT can't give the REAL_TYPE (mariohuang), user:%s old:%d get:%d", new Object[]{a, Integer.valueOf(cig.field_type), Integer.valueOf(WO.field_type)});
                WO.setType(WO.field_type | cig.field_type);
            }
            if (!bh.ov(ou)) {
                WO.di(ou);
            } else if (cig != null && ((int) cig.gJd) > 0) {
                WO.di(cig.field_encryptUsername);
            }
            if (cig == null) {
                j = 0;
            } else {
                j = (long) ((int) cig.gJd);
            }
            WO.gJd = j;
            WO.dc(n.a(com_tencent_mm_protocal_c_arp.wsB));
            WO.dd(n.a(com_tencent_mm_protocal_c_arp.vYw));
            WO.de(n.a(com_tencent_mm_protocal_c_arp.vYx));
            WO.eD(com_tencent_mm_protocal_c_arp.hvt);
            WO.eG(com_tencent_mm_protocal_c_arp.vXS);
            WO.db(n.a(com_tencent_mm_protocal_c_arp.wzc));
            WO.eH(com_tencent_mm_protocal_c_arp.vXW);
            WO.eI(com_tencent_mm_protocal_c_arp.hvx);
            WO.dv(RegionCodeDecoder.ah(com_tencent_mm_protocal_c_arp.hvC, com_tencent_mm_protocal_c_arp.hvu, com_tencent_mm_protocal_c_arp.hvv));
            WO.dp(com_tencent_mm_protocal_c_arp.hvw);
            WO.ez(com_tencent_mm_protocal_c_arp.wvf);
            WO.du(com_tencent_mm_protocal_c_arp.wvg);
            WO.setSource(com_tencent_mm_protocal_c_arp.vHW);
            WO.ey(com_tencent_mm_protocal_c_arp.wvj);
            WO.df(com_tencent_mm_protocal_c_arp.wvi);
            if (s.ht(com_tencent_mm_protocal_c_arp.wvh)) {
                WO.dt(com_tencent_mm_protocal_c_arp.wvh);
            }
            if (WO.cid()) {
                WO.eK((int) bh.Wo());
            }
            if (!TextUtils.isEmpty(str)) {
                WO.dD(str);
            }
            WO.da(n.a(com_tencent_mm_protocal_c_arp.wyH));
            WO.dg(n.a(com_tencent_mm_protocal_c_arp.wyJ));
            WO.dh(n.a(com_tencent_mm_protocal_c_arp.wyI));
            WO.dj(com_tencent_mm_protocal_c_arp.vYL);
            WO.dw(com_tencent_mm_protocal_c_arp.vIO);
            WO.dx(com_tencent_mm_protocal_c_arp.wzs);
            if (bh.bw(bArr)) {
                ((h) g.h(h.class)).EY().WT(a);
            } else {
                ((h) g.h(h.class)).EY().w(a, bArr);
            }
            WO.eB(com_tencent_mm_protocal_c_arp.wzr);
            if (!(com_tencent_mm_protocal_c_arp.wzn == null || com_tencent_mm_protocal_c_arp.wzn.vHl == null)) {
                WO.dy(com_tencent_mm_protocal_c_arp.wzn.vHl.vLU);
                WO.dz(com_tencent_mm_protocal_c_arp.wzn.vHl.vLV);
                WO.dA(com_tencent_mm_protocal_c_arp.wzn.vHl.vLW);
            }
            if (!(cig == null || com.tencent.mm.l.a.fZ(cig.field_type))) {
                com.tencent.mm.l.a.fZ(WO.field_type);
            }
            if (s.hn(a)) {
                WO.Ap();
            }
            if (WO.cia()) {
                WO.As();
            }
            WO.dB(com_tencent_mm_protocal_c_arp.fWD);
            WO.eM(com_tencent_mm_protocal_c_arp.wzw);
            String str3 = "MicroMsg.ContactSyncExtension";
            String str4 = "processModContact:user[%s,%s] id:%d nick:%s pin:%s delflag:%d type:%d [%d,%d] contype:%d notify:%d region[%s,%s,%s] src:%d LabelIDList:%s fromGetContactService:%b remark_Description:(%s,%s,%s)";
            Object[] objArr = new Object[20];
            objArr[0] = a;
            objArr[1] = ou;
            objArr[2] = Integer.valueOf((int) WO.gJd);
            objArr[3] = WO.field_nickname;
            objArr[4] = WO.vR();
            objArr[5] = Integer.valueOf(WO.field_deleteFlag);
            objArr[6] = Integer.valueOf(WO.field_type);
            objArr[7] = Integer.valueOf(com_tencent_mm_protocal_c_arp.vXM);
            objArr[8] = Integer.valueOf(com_tencent_mm_protocal_c_arp.vXN);
            objArr[9] = Integer.valueOf(WO.fWk);
            objArr[10] = Integer.valueOf(WO.fWn);
            objArr[11] = com_tencent_mm_protocal_c_arp.hvC;
            objArr[12] = com_tencent_mm_protocal_c_arp.hvu;
            objArr[13] = com_tencent_mm_protocal_c_arp.hvv;
            objArr[14] = Integer.valueOf(WO.getSource());
            objArr[15] = WO.field_contactLabelIds;
            objArr[16] = Boolean.valueOf(z);
            objArr[17] = Boolean.valueOf(com_tencent_mm_protocal_c_arp.vIO == null);
            if (com_tencent_mm_protocal_c_arp.vIO == null) {
                i = 0;
            } else {
                i = com_tencent_mm_protocal_c_arp.vIO.length();
            }
            objArr[18] = Integer.valueOf(i);
            if (com_tencent_mm_protocal_c_arp.vIO == null) {
                str2 = "";
            } else {
                str2 = bh.VT(com_tencent_mm_protocal_c_arp.vIO);
            }
            objArr[19] = str2;
            x.i(str3, str4, objArr);
            oop.a(WO, cig, com_tencent_mm_protocal_c_arp, bArr, z2);
            if (bh.ov(ou)) {
                ((h) g.h(h.class)).EY().Q(WO);
            } else {
                ((h) g.h(h.class)).EY().b(ou, WO);
            }
            oop.b(WO, cig, com_tencent_mm_protocal_c_arp, bArr, z2);
            if ((WO.field_type & 2048) != 0) {
                if (cig == null || (cig.field_type & 2048) != (WO.field_type & 2048)) {
                    ((h) g.h(h.class)).Fd().Xd(WO.field_username);
                    return;
                }
                return;
            } else if (cig == null || (cig.field_type & 2048) != (WO.field_type & 2048)) {
                ((h) g.h(h.class)).Fd().Xe(WO.field_username);
                return;
            } else {
                return;
            }
        }
        x.w("MicroMsg.ContactSyncExtension", "cat's replace user with stranger  user:%s", new Object[]{a});
    }
}
