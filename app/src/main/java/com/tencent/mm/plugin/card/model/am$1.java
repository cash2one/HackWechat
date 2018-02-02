package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;

class am$1 extends c<gz> {
    final /* synthetic */ am kMO;

    am$1(am amVar) {
        this.kMO = amVar;
        this.xen = gz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        final gz gzVar = (gz) bVar;
        x.i("MicroMsg.SubCoreCard.cardGetCountListener", "deal with card notify event GetCardCountEvent");
        if (gzVar instanceof gz) {
            am.a(this.kMO).postDelayed(new Runnable(this) {
                final /* synthetic */ am$1 kMQ;

                public final void run() {
                    if (ar.Hj()) {
                        boolean z = gzVar.fxh.fxi;
                        x.i("MicroMsg.SubCoreCard.cardGetCountListener", "GetCardCountEvent isForceGet is " + z);
                        boolean axf = l.axf();
                        boolean axh = l.axh();
                        if (axf && axh) {
                            x.i("MicroMsg.SubCoreCard.cardGetCountListener", "card entrance and share card entrance is open");
                            return;
                        }
                        if (z) {
                            ar.CG().a(new y(), 0);
                        } else {
                            int intValue;
                            ar.Hg();
                            Integer num = (Integer) com.tencent.mm.z.c.CU().get(282882, null);
                            if (num != null) {
                                intValue = num.intValue();
                            } else {
                                intValue = 0;
                            }
                            if (((int) (System.currentTimeMillis() / 1000)) - intValue >= 7200) {
                                ar.CG().a(new y(), 0);
                            }
                        }
                        if (axh) {
                            ar.Hg();
                            Long l = (Long) com.tencent.mm.z.c.CU().get(a.xor, Long.valueOf(0));
                            if (l != null && l.longValue() == 0) {
                                am.auH().auR();
                            }
                        }
                        if (axf) {
                            ar.Hg();
                            if (TextUtils.isEmpty((String) com.tencent.mm.z.c.CU().get(a.xoh, null))) {
                                am.auz();
                                com.tencent.mm.plugin.card.a.b.nF(1);
                            }
                        }
                    }
                }
            }, 10000);
        }
        return false;
    }
}
