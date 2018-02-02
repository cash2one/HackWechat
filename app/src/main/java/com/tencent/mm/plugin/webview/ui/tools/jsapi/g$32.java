package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.os.RemoteException;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.dk;
import com.tencent.mm.plugin.webview.model.h;
import com.tencent.mm.protocal.c.akt;
import com.tencent.mm.protocal.c.aku;
import com.tencent.mm.protocal.c.akw;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class g$32 extends c<dk> {
    final /* synthetic */ g tIj;

    g$32(g gVar) {
        this.tIj = gVar;
        this.xen = dk.class.getName().hashCode();
    }

    private boolean a(dk dkVar) {
        if (dkVar != null && (dkVar instanceof dk)) {
            System.currentTimeMillis();
            g.m(this.tIj);
            g.a(this.tIj, System.currentTimeMillis());
            String str = dkVar.frY.frW;
            int i = dkVar.frY.frZ;
            int i2 = dkVar.frY.fsa & 65535;
            double d = dkVar.frY.fsc;
            double d2 = dkVar.frY.fsb;
            x.i("MicroMsg.MsgHandler", "[MsgHandler][IBeaconRangeResult],iBeacon = %s", new Object[]{str + "," + i + "," + i2 + "," + d});
            String str2 = str + "," + i + "," + i2;
            boolean z = false;
            List<aku> list;
            Iterator it;
            akw com_tencent_mm_protocal_c_akw;
            if (g.n(this.tIj).containsKey(str2)) {
                list = (List) g.o(this.tIj).get(str + "," + i);
                if (list != null) {
                    for (aku com_tencent_mm_protocal_c_aku : list) {
                        if (com_tencent_mm_protocal_c_aku != null && com_tencent_mm_protocal_c_aku.wrW != null && !com_tencent_mm_protocal_c_aku.wrW.isEmpty()) {
                            it = com_tencent_mm_protocal_c_aku.wrW.iterator();
                            while (it.hasNext()) {
                                com_tencent_mm_protocal_c_akw = (akw) it.next();
                                if (i2 >= com_tencent_mm_protocal_c_akw.wrX && i2 <= com_tencent_mm_protocal_c_akw.wrY) {
                                    z = true;
                                    continue;
                                    break;
                                }
                            }
                            continue;
                        }
                        if (z) {
                            break;
                        }
                    }
                }
            } else {
                akt com_tencent_mm_protocal_c_akt = new akt();
                com_tencent_mm_protocal_c_akt.ned = str;
                com_tencent_mm_protocal_c_akt.major = i;
                com_tencent_mm_protocal_c_akt.minor = i2;
                g.n(this.tIj).put(str2, com_tencent_mm_protocal_c_akt);
                if (g.o(this.tIj).containsKey(str + "," + i)) {
                    list = (List) g.o(this.tIj).get(str + "," + i);
                    if (list != null) {
                        for (aku com_tencent_mm_protocal_c_aku2 : list) {
                            boolean z2;
                            if (!(com_tencent_mm_protocal_c_aku2 == null || com_tencent_mm_protocal_c_aku2.wrW == null || com_tencent_mm_protocal_c_aku2.wrW.isEmpty())) {
                                Iterator it2 = com_tencent_mm_protocal_c_aku2.wrW.iterator();
                                while (it2.hasNext()) {
                                    com_tencent_mm_protocal_c_akw = (akw) it2.next();
                                    if (i2 >= com_tencent_mm_protocal_c_akw.wrX && i2 <= com_tencent_mm_protocal_c_akw.wrY) {
                                        z2 = true;
                                        break;
                                    }
                                }
                            }
                            z2 = z;
                            if (z2) {
                                z = z2;
                                break;
                            }
                            z = z2;
                        }
                    }
                }
                if (!z) {
                    g.p(this.tIj).add(com_tencent_mm_protocal_c_akt);
                    String str3 = null;
                    if (!(g.j(this.tIj) == null || g.j(this.tIj).pox == null)) {
                        Object obj = g.j(this.tIj).pox.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
                        str3 = bh.ou(g.q(this.tIj).PB(obj != null ? obj.toString() : ""));
                    }
                    if (!g.r(this.tIj)) {
                        g.a(this.tIj, true);
                        final k hVar = new h(g.p(this.tIj), bh.ou(str3));
                        g.p(this.tIj).clear();
                        ar.CG().a(1704, new e(this) {
                            final /* synthetic */ g$32 tIJ;

                            public final void a(int i, int i2, String str, k kVar) {
                                if (i == 0 && i2 == 0) {
                                    yy yyVar = (yy) hVar.hFi.hmh.hmo;
                                    if (yyVar.lOr == 0) {
                                        List<aku> list = yyVar.wiR;
                                        StringBuilder stringBuilder = new StringBuilder();
                                        for (aku com_tencent_mm_protocal_c_aku : list) {
                                            List list2;
                                            String str2 = com_tencent_mm_protocal_c_aku.ned + "," + com_tencent_mm_protocal_c_aku.major;
                                            if (g.o(this.tIJ.tIj).containsKey(str2)) {
                                                list2 = (List) g.o(this.tIJ.tIj).get(str2);
                                            } else {
                                                list2 = new ArrayList();
                                                g.o(this.tIJ.tIj).put(str2, list2);
                                            }
                                            list2.add(com_tencent_mm_protocal_c_aku);
                                            stringBuilder.append("{uuid:" + com_tencent_mm_protocal_c_aku.ned + ",major:" + com_tencent_mm_protocal_c_aku.major + ",minors:[");
                                            Iterator it = com_tencent_mm_protocal_c_aku.wrW.iterator();
                                            while (it.hasNext()) {
                                                akw com_tencent_mm_protocal_c_akw = (akw) it.next();
                                                stringBuilder.append(com_tencent_mm_protocal_c_akw.wrX + "-" + com_tencent_mm_protocal_c_akw.wrY + ",");
                                            }
                                            stringBuilder.append("]},");
                                        }
                                        x.d("MicroMsg.MsgHandler", "[MsgHandler][ibeacon check callback]" + stringBuilder.toString());
                                    }
                                }
                                ar.CG().b(1704, this);
                                g.a(this.tIJ.tIj, false);
                            }
                        });
                        ar.CG().a(hVar, 0);
                    }
                }
            }
            x.d("MicroMsg.MsgHandler", "[MsgHandler][ibeacon check and find] find:%s", new Object[]{String.valueOf(z) + "," + str2});
            try {
                if (g.tHA != -1) {
                    com.tencent.mm.plugin.webview.stub.e eVar = g.a(this.tIj, g.tHA).fBH;
                    if (eVar != null && z) {
                        Bundle bundle = new Bundle();
                        bundle.putString("uuid", str);
                        bundle.putInt("major", i);
                        bundle.putInt("minor", i2);
                        bundle.putDouble("accuracy", d2);
                        bundle.putDouble("rssi", d);
                        bundle.putFloat("heading", g.s(this.tIj));
                        eVar.n(40002, bundle);
                    }
                }
            } catch (RemoteException e) {
                x.i("MicroMsg.MsgHandler", "[MsgHandler]callback failure:%s", new Object[]{e.getMessage()});
            }
            x.i("MicroMsg.MsgHandler", "[MsgHandler]result iBeacon = %s,beaconMap.size:%d", new Object[]{g.n(this.tIj).get(str2), Integer.valueOf(g.n(this.tIj).size())});
        }
        return false;
    }
}
