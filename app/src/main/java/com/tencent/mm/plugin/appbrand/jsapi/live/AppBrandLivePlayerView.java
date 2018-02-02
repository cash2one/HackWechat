package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.smtt.sdk.WebView;

public class AppBrandLivePlayerView extends TXCloudVideoView {
    l jkO;
    a jkP;
    b jkQ;
    int jkR;
    boolean jkS;

    public AppBrandLivePlayerView(Context context) {
        super(context);
        init(context);
    }

    public AppBrandLivePlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public final void sW() {
        j jVar;
        l lVar = this.jkO;
        if (lVar.gNe) {
            lVar.jll.stopPlay(true);
            lVar.jll.setPlayListener(null);
            jVar = new j();
        } else {
            jVar = new j(-3, "uninited livePlayer");
        }
        x.i("MicroMsg.AppBrandLivePlayerView", "onDestroy code:%d info:%s", new Object[]{Integer.valueOf(jVar.errorCode), jVar.jlh});
    }

    final void cM(boolean z) {
        if (this.jkS && this.jkQ != null) {
            this.jkQ.e(z, this.jkR);
        }
    }

    private void init(Context context) {
        this.jkO = new l(context);
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
    }
}
