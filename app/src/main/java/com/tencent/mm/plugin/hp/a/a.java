package com.tencent.mm.plugin.hp.a;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.h.p;
import com.tencent.mm.protocal.c.bns;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public final class a {

    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ String nAA;
        final /* synthetic */ String nAB;
        final /* synthetic */ b nAC;
        final /* synthetic */ Context val$context;

        public AnonymousClass1(String str, Context context, String str2, b bVar) {
            this.nAA = str;
            this.val$context = context;
            this.nAB = str2;
            this.nAC = bVar;
        }

        public final void run() {
            if (e.bO(this.nAA)) {
                boolean z = false;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                int b = b.b(p.el(this.val$context), this.nAB, this.nAA, this.nAC.nBr);
                SharePatchFileUtil.ag(new File(this.nAB));
                x.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk use :%d second retCode:%d", new Object[]{Long.valueOf((System.currentTimeMillis() - currentTimeMillis) / 1000), Integer.valueOf(b)});
                int i = b;
            }
            if (i == 0) {
                if (com.tencent.mm.c.a.ch(this.nAA)) {
                    String string;
                    x.i("MicroMsg.Tinker.CTinkerInstaller", "checkApk:%s", new Object[]{Boolean.valueOf(com.tencent.mm.c.a.ch(this.nAA))});
                    Context context = ac.getContext();
                    if (bh.ov(this.nAC.aSK())) {
                        string = context.getString(R.l.eSe);
                    } else {
                        string = this.nAC.aSK();
                    }
                    bns com_tencent_mm_protocal_c_bns = new bns();
                    com_tencent_mm_protocal_c_bns.nBq = this.nAC.nBq;
                    com_tencent_mm_protocal_c_bns.title = context.getString(R.l.ejp);
                    com_tencent_mm_protocal_c_bns.wQB = context.getString(R.l.epy);
                    com_tencent_mm_protocal_c_bns.nwc = context.getString(R.l.eRQ);
                    com_tencent_mm_protocal_c_bns.nBr = this.nAC.nBr;
                    com_tencent_mm_protocal_c_bns.nBs = this.nAC.nBs;
                    com_tencent_mm_protocal_c_bns.jIM = this.nAC.fileSize;
                    com_tencent_mm_protocal_c_bns.nBo = this.nAC.nBo;
                    com_tencent_mm_protocal_c_bns.fel = this.nAC.nBp;
                    com_tencent_mm_protocal_c_bns.versionCode = this.nAC.versionCode;
                    com_tencent_mm_protocal_c_bns.wQA = this.nAA;
                    com_tencent_mm_protocal_c_bns.fpb = string;
                    p.a(com_tencent_mm_protocal_c_bns);
                    if (this.nAC.nBm.intValue() == 3) {
                        g.pQN.a(614, 58, 1, false);
                    }
                    x.d("MicroMsg.Tinker.CTinkerInstaller", "boots download success.");
                } else {
                    x.i("MicroMsg.Tinker.CTinkerInstaller", "md5 is no equal.");
                }
            } else {
                x.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk failed.");
            }
            switch (i) {
                case -2:
                    g.pQN.a(614, 53, 1, false);
                    x.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed apk md5 no equal.");
                    return;
                case -1:
                    g.pQN.a(614, 52, 1, false);
                    x.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed sdcard full.");
                    return;
                default:
                    return;
            }
        }
    }
}
