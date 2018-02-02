package com.tencent.mm.plugin.webwx.a;

import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s$a$a;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.ax;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class a implements e, com.tencent.mm.modelvideo.s.a {
    private static int tOi = 1048576;
    private static int tOj = 26214400;
    private aw tOk = new aw();
    private HashMap<String, au> tOl = new HashMap();

    static /* synthetic */ void a(a aVar) {
        int i = 0;
        while (i < aVar.tOk.xzO.size()) {
            ax axVar = (ax) aVar.tOk.xzO.get(i);
            if (bh.by(axVar.xfY) > 259200) {
                aVar.tOk.xzO.remove(axVar);
                aVar.bVq();
                aVar.bVp();
                return;
            } else if (axVar.xzP == 0 || bh.by(axVar.xzP) >= 900) {
                ar.Hg();
                cf dH = c.Fa().dH(axVar.fqm);
                if (dH.field_msgSvrId == 0 || dH.cjs()) {
                    x.i("MicroMsg.MultiTerminalSyncMgr", "msg not exit or cleaned, msgLocalId:%d", new Object[]{Long.valueOf(axVar.fqm)});
                    aVar.tOk.xzO.remove(axVar);
                    aVar.bVq();
                    aVar.bVp();
                    return;
                }
                x.i("MicroMsg.MultiTerminalSyncMgr", "statusNotify sendCommand DownloadFile user:%s, msgSvrId:%d, msgLocalId:%d, path:%s", new Object[]{dH.field_talker, Long.valueOf(dH.field_msgSvrId), Long.valueOf(dH.field_msgId), dH.field_imgPath});
                if (dH.cje()) {
                    com.tencent.mm.aq.e bh = o.Pw().bh(dH.field_msgSvrId);
                    Map y = bi.y(dH.field_content, "msg");
                    i = y == null ? 0 : bh.getInt((String) y.get(".msg.img.$length"), 0);
                    if (bh.Pd() || i == 0 || i > tOj) {
                        i = 1;
                    } else if (i <= tOi || an.isWifi(ac.getContext())) {
                        x.i("MicroMsg.MultiTerminalSyncMgr", "autoDownload image, totalLen:%d", new Object[]{Integer.valueOf(i)});
                        g.MJ().hsy.add("image_" + dH.field_msgId);
                        o.Px().a(bh.hzP, dH.field_msgId, 0, Long.valueOf(dH.field_msgSvrId), R.g.bAF, new 4(aVar));
                        i = 2;
                    } else {
                        x.i("MicroMsg.MultiTerminalSyncMgr", "autoDownload image too big, totalLen:%d", new Object[]{Integer.valueOf(i)});
                        i = 3;
                    }
                } else if (dH.getType() == 43 || dH.getType() == 44 || dH.getType() == 62) {
                    r nF = t.nF(dH.field_imgPath);
                    int i2 = nF.hlp;
                    if (nF.status == 199 || i2 == 0 || i2 > tOj) {
                        i = 1;
                    } else if (i2 <= tOi || an.isWifi(ac.getContext())) {
                        x.i("MicroMsg.MultiTerminalSyncMgr", "autoDownload video, totalLen:%d", new Object[]{Integer.valueOf(i2)});
                        aVar.tOl.put(dH.field_imgPath, dH);
                        t.nB(dH.field_imgPath);
                        g.MJ().hsy.add("video_" + dH.field_msgId);
                        i = 2;
                    } else {
                        x.i("MicroMsg.MultiTerminalSyncMgr", "autoDownload video too big, totalLen:%d", new Object[]{Integer.valueOf(i2)});
                        i = 3;
                    }
                } else if (dH.aNc()) {
                    if (com.tencent.mm.y.g.a.fT(dH.field_content).type != 6) {
                        x.i("MicroMsg.MultiTerminalSyncMgr", "appMsg not support, subType:%d", new Object[]{Integer.valueOf(com.tencent.mm.y.g.a.fT(dH.field_content).type)});
                        i = 1;
                    } else {
                        b bVar;
                        com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(dH.field_content);
                        if (fT == null) {
                            x.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", new Object[]{dH.field_content});
                            bVar = null;
                        } else {
                            if (bh.ov(fT.fny) && !bh.ov(fT.hbi)) {
                                x.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", new Object[]{dH.field_content});
                                fT.fny = fT.hbi.hashCode();
                            }
                            String str = fT.fny;
                            bVar = l.af(str, dH.field_msgId);
                            if (bVar == null) {
                                l.e(str, dH);
                                bVar = l.af(str, dH.field_msgId);
                            }
                        }
                        if (bVar == null) {
                            x.i("MicroMsg.MultiTerminalSyncMgr", "attachInfo is null");
                            i = 1;
                        } else {
                            long j = bVar.field_totalLen;
                            if (bVar.aOC() || j == 0 || j > ((long) tOj)) {
                                i = 1;
                            } else if (j <= ((long) tOi) || an.isWifi(ac.getContext())) {
                                x.i("MicroMsg.MultiTerminalSyncMgr", "autoDownload attach, totalLen:%d", new Object[]{Long.valueOf(j)});
                                l.a(dH, null);
                                i = 2;
                            } else {
                                x.i("MicroMsg.MultiTerminalSyncMgr", "autoDownload attach too big, totalLen:%d", new Object[]{Long.valueOf(j)});
                                i = 3;
                            }
                        }
                    }
                } else {
                    x.i("MicroMsg.MultiTerminalSyncMgr", "msgType not support:%d", new Object[]{Integer.valueOf(dH.getType())});
                    i = 1;
                }
                if (i == 1) {
                    aVar.tOk.xzO.remove(axVar);
                    aVar.bVq();
                } else {
                    axVar.xzP = bh.Wo();
                    aVar.bVq();
                }
                aVar.bVp();
                return;
            } else {
                i++;
            }
        }
    }

    static /* synthetic */ void a(a aVar, long j) {
        ax axVar = new ax();
        axVar.fqm = j;
        axVar.xfY = bh.Wo();
        aVar.tOk.xzO.add(axVar);
        aVar.bVq();
        aVar.bVp();
    }

    static /* synthetic */ void b(a aVar, long j) {
        for (int i = 0; i < aVar.tOk.xzO.size(); i++) {
            ax axVar = (ax) aVar.tOk.xzO.get(i);
            if (axVar.fqm == j) {
                aVar.tOk.xzO.remove(axVar);
                aVar.bVq();
                return;
            }
        }
    }

    public a() {
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.Dk();
        byte[] e = com.tencent.mm.a.e.e(stringBuilder.append(com.tencent.mm.kernel.g.Dj().cachePath).append("syncmsgid.ini").toString(), 0, -1);
        if (!bh.bw(e)) {
            try {
                this.tOk.aF(e);
            } catch (Exception e2) {
                x.w("MicroMsg.MultiTerminalSyncMgr", "task parse Error");
            }
        }
        com.tencent.mm.modelvideo.o.TU().a(this, Looper.getMainLooper());
        com.tencent.mm.kernel.g.CG().a(221, this);
    }

    public final void fm(long j) {
        ar.Hg();
        if (((Boolean) c.CU().get(com.tencent.mm.storage.w.a.xtu, Boolean.valueOf(true))).booleanValue()) {
            new af(Looper.getMainLooper()).post(new 1(this, j));
        } else {
            x.i("MicroMsg.MultiTerminalSyncMgr", "autoSyncState close");
        }
    }

    public final void fn(long j) {
        new af(Looper.getMainLooper()).post(new 2(this, j));
    }

    public final void bVp() {
        new af(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ a tOm;

            {
                this.tOm = r1;
            }

            public final void run() {
                a.a(this.tOm);
            }
        });
    }

    private void bVq() {
        try {
            byte[] toByteArray = this.tOk.toByteArray();
            StringBuilder stringBuilder = new StringBuilder();
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.a.e.b(stringBuilder.append(com.tencent.mm.kernel.g.Dj().cachePath).append("syncmsgid.ini").toString(), toByteArray, toByteArray.length);
        } catch (IOException e) {
            x.w("MicroMsg.MultiTerminalSyncMgr", "task to file Error");
        }
    }

    public final void a(s$a$a com_tencent_mm_modelvideo_s_a_a) {
        au auVar = (au) this.tOl.get(com_tencent_mm_modelvideo_s_a_a.fileName);
        if (auVar != null) {
            r nF = t.nF(auVar.field_imgPath);
            if (nF == null) {
                return;
            }
            if (auVar.cjs() || nF.status == 199) {
                x.i("MicroMsg.MultiTerminalSyncMgr", "download video end: %d, status:%d", new Object[]{Long.valueOf(auVar.field_msgId), Integer.valueOf(nF.status)});
                fn(auVar.field_msgId);
                this.tOl.remove(auVar.field_imgPath);
            } else if (auVar.field_status == bc.CTRL_INDEX) {
                this.tOl.remove(auVar.field_imgPath);
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && (kVar instanceof ab)) {
            fn(((ab) kVar).fqm);
            x.i("MicroMsg.MultiTerminalSyncMgr", "download attach end: %d", new Object[]{Long.valueOf(r0)});
        }
    }
}
