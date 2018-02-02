package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.am;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public final class a implements com.tencent.mm.z.bs.a {
    c rVG = new 1(this);

    public final void a(com.tencent.mm.ae.d.a aVar) {
        x.i("MicroMsg.JDSysMsgNotifyLsn", "receivemsg jd");
        bw bwVar = aVar.hmq;
        if (bwVar == null) {
            x.e("MicroMsg.JDSysMsgNotifyLsn", "onPreAddMessage cmdAM is null");
            return;
        }
        final b bVar = new b();
        bVar.KV(n.a(bwVar.vGZ));
        x.i("MicroMsg.JDSysMsgNotifyLsn", "bizType " + bh.az(bVar.rVJ, ""));
        if (bh.ov(bVar.rVJ)) {
            x.e("MicroMsg.JDSysMsgNotifyLsn", "bizTye is null or nil");
        } else if (bh.ov(bVar.rVK)) {
            x.e("MicroMsg.JDSysMsgNotifyLsn", "activity id is null");
        } else if (!bVar.a(c.bDO().bDT())) {
            x.i("MicroMsg.JDSysMsgNotifyLsn", "fo zu baoyou! the activityid is same");
        } else if (!c.bDW()) {
            x.e("MicroMsg.JDSysMsgNotifyLsn", "no entrance, ignore msg");
        } else if (bVar.rVJ.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            bwVar.vHd = null;
            if (bh.ov(bVar.rVU) || bh.ov(bVar.jumpUrl) || bh.ov(bVar.rVV) || bh.ov(bVar.rVW) || bh.ov(bVar.rVT)) {
                x.e("MicroMsg.JDSysMsgNotifyLsn", "invalid params");
            } else if (bVar.bDH()) {
                x.i("MicroMsg.JDSysMsgNotifyLsn", "ingore msg due to msg is expired");
            } else {
                c bDO = c.bDO();
                String str = bVar.rVK;
                if (bh.ov(str) ? false : bDO.rVZ.containsKey(str)) {
                    x.i("MicroMsg.JDSysMsgNotifyLsn", "activity id already show, " + bVar.rVK);
                } else if (bVar.a(c.bDO().bDT())) {
                    bDO = c.bDO();
                    str = bVar.rVK;
                    if (!bh.ov(str)) {
                        bDO.rVZ.put(str, Integer.valueOf(1));
                    }
                    x.i("MicroMsg.JDSysMsgNotifyLsn", "add activity id" + bVar.rVK);
                    new af(Looper.getMainLooper()).post(new Runnable(this) {
                        final /* synthetic */ a rVH;

                        public final void run() {
                            a aVar = this.rVH;
                            b bVar = bVar;
                            ar.Hg();
                            int intValue = ((Integer) com.tencent.mm.z.c.CU().get(15, Integer.valueOf(0))).intValue();
                            if (ar.CG().foreground && 1 == intValue) {
                                String ck;
                                JDRemindDialog.a(ac.getContext(), bVar.rVU, bVar.rVV, bVar.rVW, c.ck(bVar.jumpUrl, 5), bVar.rVK);
                                g.pQN.h(11178, new Object[]{ck, c.bDO().bDT().rVK, Integer.valueOf(5)});
                                return;
                            }
                            ck = c.ck(bVar.jumpUrl, 4);
                            Bundle bundle = new Bundle();
                            bundle.putString("activity_id", bVar.rVK);
                            bundle.putString("jump_url", ck);
                            ((am) ar.getNotification()).a(37, ac.getContext().getString(R.l.dGq), bVar.rVT, ck, "bizjd", bundle);
                            com.tencent.mm.sdk.b.a.xef.b(aVar.rVG);
                            g.pQN.h(11178, new Object[]{ck, c.bDO().bDT().rVK, Integer.valueOf(4)});
                        }
                    });
                } else {
                    x.i("MicroMsg.JDSysMsgNotifyLsn", "the remind activitid is same");
                }
            }
            c.b(bVar);
        } else if (bVar.rVJ.equals("1")) {
            c.b(bVar);
        } else if (bVar.rVJ.equals("2")) {
            c.b(bVar);
        }
        ar.Hg();
        com.tencent.mm.z.c.CU().lH(true);
    }
}
