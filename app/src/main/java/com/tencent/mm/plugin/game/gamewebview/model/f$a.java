package com.tencent.mm.plugin.game.gamewebview.model;

import android.os.Bundle;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

final class f$a implements e, h<Bundle, IPCRunCgiRespWrapper> {
    private i<IPCRunCgiRespWrapper> mXR;

    private f$a() {
    }

    public final /* synthetic */ void a(Object obj, i iVar) {
        Bundle bundle = (Bundle) obj;
        ar.CG().a(233, this);
        this.mXR = iVar;
        String string = bundle.getString("geta8key_data_req_url");
        if (!bh.ov(bundle.getString("k_share_url"))) {
            ak.eL(string, bundle.getString("k_share_url"));
        }
        ar.CG().a(!bh.ov(string) ? new l(string, bundle.getString("geta8key_data_username"), bundle.getInt("geta8key_data_scene"), bundle.getInt("geta8key_data_reason"), bundle.getInt("geta8key_data_flag"), bundle.getString("geta8key_data_net_type"), bundle.getInt("geta8key_session_id", 0), "", bundle.getString("key_function_id"), bundle.getInt("key_wallet_region", 0), new byte[0]) : new l(bundle.getString("geta8key_data_appid"), bundle.getString("geta8key_data_scope"), bundle.getString("geta8key_data_state"), bundle.getInt("geta8key_session_id", 0)), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.GameWebViewGetA8KeyHelp", "onSceneEnd");
        ar.CG().b(233, this);
        if (this.mXR != null) {
            IPCRunCgiRespWrapper iPCRunCgiRespWrapper = new IPCRunCgiRespWrapper();
            iPCRunCgiRespWrapper.errType = i;
            iPCRunCgiRespWrapper.errCode = i2;
            iPCRunCgiRespWrapper.fnL = str;
            iPCRunCgiRespWrapper.gJQ = (b) kVar.hmG;
            this.mXR.as(iPCRunCgiRespWrapper);
        }
        this.mXR = null;
    }
}
