package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.sdk.platformtools.af;
import java.io.OutputStream;

public final class ar extends l<g, String, Boolean> {
    private String fileName;
    private OutputStream hlF = null;
    private String hlG;
    private String mediaId;
    private String qTQ;
    private String qTU = "";

    public final /* synthetic */ Object buP() {
        return Boolean.valueOf(true);
    }

    public final /* synthetic */ void n(Object[] objArr) {
        g[] gVarArr = (g[]) objArr;
        super.n(gVarArr);
        g gVar = gVarArr[0];
        if (gVar != null) {
            this.mediaId = gVar.mediaId;
            this.qTQ = am.r(ae.getAccSnsPath(), this.mediaId);
            this.qTU = i.aE(gVar.requestType, this.mediaId);
            this.hlG = "sns_tmpt_" + this.mediaId;
            this.fileName = "snst_" + this.mediaId;
        }
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        Boolean bool = (Boolean) obj;
        super.onPostExecute(bool);
        bool.booleanValue();
        ae.bvq().JW(this.qTU);
    }

    public final af buO() {
        return ae.bvh();
    }
}
