package com.tencent.mm.modelvideo;

import com.tencent.mm.a.e;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelvideo.n.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class n$1 implements Runnable {
    final /* synthetic */ String gIn;
    final /* synthetic */ keep_SceneResult hUX;
    final /* synthetic */ n hUY;

    n$1(n nVar, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        this.hUY = nVar;
        this.gIn = str;
        this.hUX = com_tencent_mm_modelcdntran_keep_SceneResult;
    }

    public final void run() {
        a aVar = (a) n.a(this.hUY).remove(this.gIn);
        if (aVar != null) {
            com.tencent.mm.plugin.sight.base.a aVar2;
            int i;
            int bN = e.bN(aVar.hVj);
            com.tencent.mm.plugin.sight.base.a Js = d.Js(aVar.hVj);
            if (bh.ov(aVar.hVi)) {
                aVar2 = Js;
                i = bN;
            } else {
                aVar2 = d.Js(aVar.hVi);
                i = e.bN(aVar.hVi);
            }
            if (aVar2 == null || Js == null) {
                x.w("MicroMsg.SubCoreMediaRpt", "upload video but media info is null. %s", new Object[]{aVar.hVj});
                return;
            }
            StringBuffer stringBuffer;
            int eR = an.eR(ac.getContext());
            long j = this.hUX.field_startTime != 0 ? this.hUX.field_startTime : aVar.startTime;
            long Wp = this.hUX.field_endTime != 0 ? this.hUX.field_endTime : bh.Wp();
            String str = null;
            if (this.hUX.field_usedSvrIps != null) {
                stringBuffer = new StringBuffer();
                for (String append : this.hUX.field_usedSvrIps) {
                    stringBuffer.append(append).append("|");
                }
                str = stringBuffer.toString();
            }
            stringBuffer = new StringBuffer();
            stringBuffer.append(aVar.toUser).append(",").append(aVar.gjF).append(",");
            stringBuffer.append(eR).append(",").append(this.hUX.field_fileId).append(",");
            stringBuffer.append(this.hUX.field_mp4identifymd5).append(",").append(aVar.hVk).append(",");
            stringBuffer.append(j).append(",").append(Wp).append(",");
            stringBuffer.append(i).append(",").append(aVar2.mxs).append(",");
            stringBuffer.append(aVar2.videoBitrate / 1000).append(",").append(aVar2.huc / 1000).append(",");
            stringBuffer.append(aVar2.owg).append(",").append(aVar2.width).append(",");
            stringBuffer.append(aVar2.height).append(",").append(aVar.hVl).append(",");
            stringBuffer.append(bN).append(",").append(Js.mxs).append(",");
            stringBuffer.append(Js.videoBitrate / 1000).append(",").append(Js.huc / 1000).append(",");
            stringBuffer.append(Js.owg).append(",").append(Js.width).append(",");
            stringBuffer.append(Js.height).append(",").append(aVar.hVm).append(",");
            stringBuffer.append(str).append(",").append(aVar2.qsT).append(",").append(this.hUX.field_fileUrl);
            x.i("MicroMsg.SubCoreMediaRpt", "upload video rpt %s", new Object[]{stringBuffer.toString()});
            g.pQN.k(13794, stringBuffer.toString());
            n.bo(Js.videoBitrate, aVar.hVm);
        }
    }
}
