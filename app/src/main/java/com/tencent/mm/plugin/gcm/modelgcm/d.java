package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.protocal.c.cj;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;

public final class d {

    public static class a extends com.tencent.mm.protocal.k.d implements b {
        public cj nyr = new cj();

        public final byte[] Hq() {
            this.nyr.wIV = k.a(this);
            return this.nyr.toByteArray();
        }

        public final int getCmdId() {
            return GameJsApiGetGameCommInfo.CTRL_BYTE;
        }

        public final int Hr() {
            return 624;
        }
    }
}
