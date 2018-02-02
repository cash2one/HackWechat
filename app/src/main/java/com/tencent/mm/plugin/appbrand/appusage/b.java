package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.protocal.c.aiv;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.protocal.c.cax;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class b extends j {
    private static volatile b iIM = null;

    static /* synthetic */ void a(b bVar, int i, int i2, long j, boolean z, Bundle bundle) {
        if (g.Dh().Cy()) {
            Object obj = (1 == i || 3 == i) ? 1 : null;
            if (obj != null) {
                long longValue = ((Long) g.Dj().CU().get(a.xrO, Long.valueOf(-1))).longValue();
                int i3 = (z || longValue <= 0) ? Integer.MAX_VALUE : (int) longValue;
                final int i4 = i2;
                final int i5 = i;
                final Bundle bundle2 = bundle;
                final long j2 = j;
                new p(bVar, i, i2, i3) {
                    final /* synthetic */ b iIN;

                    protected final /* synthetic */ void a(int i, int i2, String str, bdf com_tencent_mm_protocal_c_bdf, k kVar) {
                        aiv com_tencent_mm_protocal_c_aiv = (aiv) com_tencent_mm_protocal_c_bdf;
                        if (g.Dh().Cy()) {
                            String str2;
                            if (com_tencent_mm_protocal_c_aiv == null) {
                                str2 = "null";
                            } else {
                                Locale locale = Locale.US;
                                String str3 = "%d %d %d";
                                Object[] objArr = new Object[3];
                                objArr[0] = Integer.valueOf(com_tencent_mm_protocal_c_aiv.wqr == null ? -1 : com_tencent_mm_protocal_c_aiv.wqr.size());
                                objArr[1] = Integer.valueOf(com_tencent_mm_protocal_c_aiv.wqs == null ? -1 : com_tencent_mm_protocal_c_aiv.wqs.size());
                                objArr[2] = Integer.valueOf(com_tencent_mm_protocal_c_aiv.status);
                                str2 = String.format(locale, str3, objArr);
                            }
                            x.i("MicroMsg.AppBrandHistoryLogic", "onCgiBack, errType %d, errCode %d, errMsg %s, resp %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2});
                            if (com_tencent_mm_protocal_c_aiv != null && i == 0 && i2 == 0) {
                                if ((i4 & 4) > 0 && !g.aaO() && (com_tencent_mm_protocal_c_aiv.status & 8) > 0) {
                                    g.aaP();
                                }
                                g.Dj().CU().a(a.xrN, Boolean.valueOf((com_tencent_mm_protocal_c_aiv.status & 4) > 0));
                                a.jB(com_tencent_mm_protocal_c_aiv.status);
                                if (!bh.cA(com_tencent_mm_protocal_c_aiv.wqs)) {
                                    n Zm = f.Zm();
                                    List<cax> list = com_tencent_mm_protocal_c_aiv.wqs;
                                    c aVar = new n.a();
                                    List linkedList = new LinkedList();
                                    List linkedList2 = new LinkedList();
                                    long dz = Zm.iGs.dz(Thread.currentThread().getId());
                                    for (cax com_tencent_mm_protocal_c_cax : list) {
                                        if (!bh.ov(com_tencent_mm_protocal_c_cax.username)) {
                                            aVar.field_brandId = com_tencent_mm_protocal_c_cax.username;
                                            aVar.field_versionType = com_tencent_mm_protocal_c_cax.vOu;
                                            aVar.field_scene = 2;
                                            if (Zm.iKa.b(aVar, new String[0])) {
                                                aVar.field_updateTime = Math.max((long) com_tencent_mm_protocal_c_cax.vUc, aVar.field_updateTime);
                                                if (Zm.iKa.c(aVar, new String[0])) {
                                                    linkedList2.add(String.valueOf(aVar.field_recordId));
                                                }
                                            } else {
                                                aVar.field_updateTime = (long) com_tencent_mm_protocal_c_cax.vUc;
                                                if (Zm.a(aVar)) {
                                                    linkedList.add(String.valueOf(aVar.field_recordId));
                                                }
                                            }
                                        }
                                    }
                                    Zm.iGs.fS(dz);
                                    if (!bh.cA(linkedList)) {
                                        Zm.b("batch", 2, linkedList);
                                    }
                                    if (!bh.cA(linkedList2)) {
                                        Zm.b("batch", 3, linkedList2);
                                    }
                                    if (!bh.cA(com_tencent_mm_protocal_c_aiv.wqs)) {
                                        int i3 = ((cax) com_tencent_mm_protocal_c_aiv.wqs.getFirst()).vUc;
                                        Iterator it = com_tencent_mm_protocal_c_aiv.wqs.iterator();
                                        int i4 = i3;
                                        while (it.hasNext()) {
                                            i4 = Math.min(i4, ((cax) it.next()).vUc);
                                        }
                                        if (i4 > 0) {
                                            g.Dj().CU().a(a.xrO, Long.valueOf((long) i4));
                                        }
                                    }
                                    l.a(i5, bundle2, com_tencent_mm_protocal_c_aiv.wqs);
                                }
                                k.a(i5, i, i2, (com.tencent.mm.ae.b) kVar.hmG);
                            }
                            this.iIN.b("batch", 3, Long.valueOf(j2));
                        }
                    }
                }.JV();
            }
        }
    }

    private b() {
    }

    public static b aaH() {
        if (iIM == null) {
            synchronized (b.class) {
                if (iIM == null) {
                    iIM = new b();
                }
            }
        }
        return iIM;
    }

    public static void release() {
        iIM = null;
    }

    public final void a(long j, boolean z, Bundle bundle) {
        com.tencent.mm.plugin.appbrand.q.c.Dm().F(new 3(this, z, j, bundle));
    }

    public static boolean aaI() {
        if (g.Dh().Cy()) {
            return ((Boolean) g.Dj().CU().get(a.xrN, Boolean.valueOf(false))).booleanValue();
        }
        return false;
    }
}
