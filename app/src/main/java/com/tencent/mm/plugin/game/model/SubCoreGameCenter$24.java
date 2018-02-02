package com.tencent.mm.plugin.game.model;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.mb;
import com.tencent.mm.g.a.tv;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import java.util.GregorianCalendar;

class SubCoreGameCenter$24 extends c<mb> {
    final /* synthetic */ SubCoreGameCenter nfd;

    SubCoreGameCenter$24(SubCoreGameCenter subCoreGameCenter) {
        this.nfd = subCoreGameCenter;
        this.xen = mb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = true;
        mb mbVar = (mb) bVar;
        if (bh.ov(mbVar.fDH.content)) {
            SubCoreGameCenter.aRe();
            ar.Hg();
            long longValue = ((Long) com.tencent.mm.z.c.CU().get(a.xpL, Long.valueOf(0))).longValue();
            t dv = longValue != 0 ? SubCoreGameCenter.aRd().dv(longValue) : null;
            if (dv != null) {
                boolean z2;
                dv.aQm();
                if (System.currentTimeMillis() / 1000 <= dv.field_receiveTime + dv.ncQ.ndm) {
                    b tvVar;
                    switch (dv.ncQ.kOC) {
                        case 0:
                            z2 = true;
                            break;
                        case 1:
                            tvVar = new tv();
                            tvVar.fMD.fpr = 2;
                            tvVar.fMD.fME = dv.ncQ.ndl;
                            com.tencent.mm.sdk.b.a.xef.m(tvVar);
                            if (!tvVar.fMD.fMF) {
                                z2 = false;
                                break;
                            }
                            z2 = true;
                            break;
                        case 2:
                            tvVar = new tv();
                            tvVar.fMD.fpr = 4;
                            tvVar.fMD.fME = dv.ncQ.ndl;
                            com.tencent.mm.sdk.b.a.xef.m(tvVar);
                            if (tvVar.fMD.fMG <= 0) {
                                z2 = false;
                                break;
                            }
                            z2 = true;
                            break;
                        default:
                            z2 = false;
                            break;
                    }
                }
                z2 = true;
                if (dv.ncw > 0) {
                    if (an.isWifi(ac.getContext())) {
                        x.i("MicroMsg.GameWifiStrategy", "WifiStrategy:isInWifi");
                    } else {
                        GregorianCalendar gregorianCalendar = new GregorianCalendar();
                        int i = gregorianCalendar.get(11);
                        gregorianCalendar.get(12);
                        int i2 = i >= 21 ? 3 : i < 12 ? 0 : i < 14 ? 1 : i < 18 ? 0 : 2;
                        x.i("MicroMsg.GameWifiStrategy", "WifiStrategy:inWhichTimeRange = " + i2);
                        if (i2 != 0) {
                            if (i2 != 3) {
                                if (i2 == 1) {
                                    x.i("MicroMsg.GameWifiStrategy", "WifiStrategy:randomHide p = %s, randomNum = %s", new Object[]{Integer.valueOf(((((new GregorianCalendar().get(11) - 12) << 1) + 1) * 10) + 50), Integer.valueOf(bh.eF(100, 0))});
                                    if (((((new GregorianCalendar().get(11) - 12) << 1) + 1) * 10) + 50 <= bh.eF(100, 0)) {
                                    }
                                } else if (i2 == 2) {
                                    gregorianCalendar = new GregorianCalendar();
                                    x.i("MicroMsg.GameWifiStrategy", "WifiStrategy:randomHide p = %s, randomNum = %s", new Object[]{Integer.valueOf((((gregorianCalendar.get(12) > 30 ? 1 : 0) + (gregorianCalendar.get(11) - 18)) * 10) + 50), Integer.valueOf(bh.eF(100, 0))});
                                    if ((((gregorianCalendar.get(12) > 30 ? 1 : 0) + (gregorianCalendar.get(11) - 18)) * 10) + 50 <= bh.eF(100, 0)) {
                                    }
                                }
                            }
                        }
                        if (!z && z2) {
                            SubCoreGameCenter.aRd().aQv();
                        }
                    }
                    z = false;
                    SubCoreGameCenter.aRd().aQv();
                } else if (z2) {
                    SubCoreGameCenter.aRd().aQv();
                }
                SubCoreGameCenter.aRe().a(mbVar);
            }
        } else {
            String str = mbVar.fDH.content;
            if (str != null && str.startsWith("//gamemsg:")) {
                new bw().vGZ = n.os(str.substring(10));
                str = str.substring(10);
                if (!bh.ov(str)) {
                    if (str.equals("jumpnative")) {
                        Intent intent = new Intent();
                        intent.putExtra("from_find_more_friend", true);
                        d.b(ac.getContext(), "game", ".ui.tab.GameRouteUI", intent);
                    } else if (str.equals("jumpLibrary")) {
                        d.b(ac.getContext(), "game", ".ui.GameLibraryUI", new Intent());
                    } else if (str.contains("jumpDetail:")) {
                        str = str.substring(11, str.length());
                        Intent intent2 = new Intent();
                        intent2.putExtra("game_app_id", str);
                        d.b(ac.getContext(), "game", ".ui.GameDetailUI2", intent2);
                    }
                }
            }
        }
        return false;
    }
}
