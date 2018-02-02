package com.tencent.mm.y;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.y.g.a;
import java.util.Map;

public class c extends d {
    public String haV;

    public final d EJ() {
        return new c();
    }

    public final void a(StringBuilder stringBuilder, a aVar, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, int i, int i2) {
    }

    public final void a(Map<String, String> map, a aVar) {
        if (aVar.type == 2001) {
            this.haV = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.locallogoicon"));
        }
    }
}
