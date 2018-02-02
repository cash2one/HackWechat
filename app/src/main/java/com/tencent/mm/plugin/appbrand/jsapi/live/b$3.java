package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements d {
    final /* synthetic */ AppBrandLivePlayerView jkV;
    final /* synthetic */ b jkW;

    b$3(b bVar, AppBrandLivePlayerView appBrandLivePlayerView) {
        this.jkW = bVar;
        this.jkV = appBrandLivePlayerView;
    }

    public final void afA() {
        j ss;
        l lVar = this.jkV.jkO;
        lVar.jlp = lVar.jll.isPlaying();
        if (lVar.jlp && lVar.jlv) {
            if (lVar.jkS && lVar.jlm != null) {
                lVar.jlm.onPlayEvent(6000, new Bundle());
            }
            ss = lVar.ss("pause");
        } else {
            ss = new j();
        }
        x.i("MicroMsg.AppBrandLivePlayerView", "onBackground code:%d info:%s", new Object[]{Integer.valueOf(ss.errorCode), ss.jlh});
    }
}
