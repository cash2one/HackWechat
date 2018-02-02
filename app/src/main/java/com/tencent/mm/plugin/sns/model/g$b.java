package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.lucky.a.a;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class g$b extends h<String, Integer, Boolean> {
    String aAM = "";
    private aqr fHC;
    private String hTs;
    private n har = null;
    private String path;
    final /* synthetic */ g qTk;
    private int qTw = 0;

    public final /* synthetic */ Object buP() {
        g.a(this.qTk, true);
        System.currentTimeMillis();
        if (!g.h(this.qTk)) {
            x.i("MicroMsg.ImageLoader", "doInBackground pass" + this.path);
            return Boolean.valueOf(false);
        } else if (g.f(this.qTk).bt(this.aAM)) {
            x.i("MicroMsg.ImageLoader", "doInBackGroundgetKey");
            return Boolean.valueOf(false);
        } else {
            FileOp.mj(this.hTs);
            long currentTimeMillis = System.currentTimeMillis();
            if (FileOp.bO(this.path)) {
                x.d("MicroMsg.ImageLoader", "doInBackground file exist:%s", new Object[]{this.path});
            } else {
                R(i.e(this.fHC), i.l(this.fHC), i.f(this.fHC));
            }
            long Wq = bh.Wq();
            if (this.qTw == 5) {
                if (!FileOp.bO(this.path)) {
                    R(i.e(this.fHC), i.l(this.fHC), i.f(this.fHC));
                }
                boolean bO = FileOp.bO(this.hTs + i.e(this.fHC));
                boolean bO2 = FileOp.bO(this.hTs + i.l(this.fHC));
                boolean bO3 = FileOp.bO(this.hTs + i.f(this.fHC));
                this.har = i.JK(this.path);
                if (this.har == null) {
                    x.i("MicroMsg.ImageLoader", "error path %s", new Object[]{this.path});
                    this.har = a.dX(this.hTs + i.f(this.fHC), this.path);
                    x.i("MicroMsg.ImageLoader", "abc a" + bO + " b" + bO2 + " c" + bO3 + " d" + FileOp.bO(this.path));
                }
            } else if (this.qTw == 4) {
                this.har = i.JK(this.path);
                if (this.har == null) {
                    x.i("MicroMsg.ImageLoader", "error path %s", new Object[]{this.path});
                    this.har = a.dX(this.hTs + i.e(this.fHC), this.path);
                }
            } else {
                this.har = i.JM(this.path);
            }
            long bA = bh.bA(Wq);
            int me = (int) FileOp.me(this.path);
            if (bh.bA(g.i(this.qTk)) > 60000) {
                g.pQN.h(11696, new Object[]{Integer.valueOf(4), Long.valueOf(bA), Integer.valueOf(me), Thread.currentThread().getName(), ae.bvJ(), e.bnD});
                g.b(this.qTk, bh.Wq());
            }
            if (this.har == null) {
                x.i("MicroMsg.ImageLoader", "mediaid %s is fail and delete it", new Object[]{this.fHC.nGJ});
                FileOp.deleteFile(this.hTs + i.f(this.fHC));
                FileOp.deleteFile(this.path);
                g.pQN.a(150, 2, 1, true);
            }
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            g.pQN.a(150, 0, 1, true);
            g.pQN.a(150, 1, currentTimeMillis, true);
            x.i("MicroMsg.ImageLoader", "doInBackground decode %s and " + (this.har == null) + " " + this.har + " %d ", new Object[]{this.path, Long.valueOf(System.currentTimeMillis() - Wq)});
            return Boolean.valueOf(true);
        }
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        super.onPostExecute((Boolean) obj);
        g.buN();
        this.qTk.qTi.remove(this.aAM);
        this.qTk.b(this.aAM, this.har);
        g.a(this.qTk, false);
        g.g(this.qTk);
    }

    public g$b(g gVar, String str, String str2, String str3, aqr com_tencent_mm_protocal_c_aqr, int i) {
        this.qTk = gVar;
        gVar.qTi.add(str);
        this.aAM = str;
        this.path = str2;
        this.hTs = str3;
        this.fHC = com_tencent_mm_protocal_c_aqr;
        this.qTw = i;
        g.buL();
        x.d("MicroMsg.ImageLoader", "peddingCount %d ", new Object[]{Integer.valueOf(g.buM())});
    }

    private void R(String str, String str2, String str3) {
        FileOp.bO(this.hTs + str3);
        if (!FileOp.bO(this.hTs + str)) {
            if (!FileOp.bO(this.hTs + str2)) {
                str2 = i.m(this.fHC);
            }
            if (!r.a(this.hTs, str2, str, (float) ae.bvE())) {
                x.i("MicroMsg.ImageLoader", "delete %s", new Object[]{str2});
                FileOp.deleteFile(this.hTs + str2);
            }
            x.i("MicroMsg.ImageLoader", "createUserThumb %s -> %s, result:%b", new Object[]{this.hTs + str2, this.hTs + str, Boolean.valueOf(r0)});
        }
        r.b(this.hTs, str, str3, (float) ae.bvD());
    }

    public final af buO() {
        return ae.aNR();
    }
}
