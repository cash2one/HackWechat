package com.tencent.mm.plugin.tmassistant.a;

import com.tencent.mm.g.a.fy;
import com.tencent.mm.plugin.downloader.model.g$a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$1 extends c<fy> {
    final /* synthetic */ b sdZ;

    b$1(b bVar) {
        this.sdZ = bVar;
        this.xen = fy.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fy fyVar = (fy) bVar;
        x.i("MicroMsg.SubCoreTMAssistant", "addDownloadTask");
        a bFl = this.sdZ.bFl();
        g$a com_tencent_mm_plugin_downloader_model_g_a = new g$a();
        com_tencent_mm_plugin_downloader_model_g_a.xL(fyVar.fvP.fvR);
        com_tencent_mm_plugin_downloader_model_g_a.xM(fyVar.fvP.fvS);
        com_tencent_mm_plugin_downloader_model_g_a.ci(fyVar.fvP.fileSize);
        com_tencent_mm_plugin_downloader_model_g_a.xN(fyVar.fvP.fileName);
        com_tencent_mm_plugin_downloader_model_g_a.xO(fyVar.fvP.fvT);
        com_tencent_mm_plugin_downloader_model_g_a.ox(fyVar.fvP.fileType);
        com_tencent_mm_plugin_downloader_model_g_a.setAppId(fyVar.fvP.appId);
        com_tencent_mm_plugin_downloader_model_g_a.ep(fyVar.fvP.fvU);
        com_tencent_mm_plugin_downloader_model_g_a.eq(fyVar.fvP.fvV);
        com_tencent_mm_plugin_downloader_model_g_a.lsE.lsB = fyVar.fvP.fvW;
        com_tencent_mm_plugin_downloader_model_g_a.cu(fyVar.fvP.packageName);
        com_tencent_mm_plugin_downloader_model_g_a.er(fyVar.fvP.fvX);
        com_tencent_mm_plugin_downloader_model_g_a.lw(fyVar.fvP.scene);
        fyVar.fvQ.fmZ = bFl.a(com_tencent_mm_plugin_downloader_model_g_a.lsE);
        return true;
    }
}
