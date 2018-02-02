package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.smtt.sdk.WebView;

public class AppBrandLivePusherView extends TXCloudVideoView {
    m jkT;
    ITXLivePushListener jkU;

    public AppBrandLivePusherView(Context context) {
        super(context);
        init(context);
    }

    public AppBrandLivePusherView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public final void u(Bundle bundle) {
        j jVar;
        m mVar = this.jkT;
        if (bundle == null) {
            jVar = new j(-1, "invalid params");
        } else {
            m.c(i.NAME, bundle);
            if (mVar.gNe) {
                mVar.c(bundle, false);
                String string = bundle.getString("pushUrl", mVar.jlA);
                if (!(string == null || string.isEmpty() || mVar.jlA == null || mVar.jlA.equalsIgnoreCase(string) || !mVar.jly.isPushing())) {
                    x.i("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
                    mVar.jly.stopCameraPreview(true);
                    mVar.jly.stopPusher();
                }
                mVar.jlA = string;
                if (!(!bundle.getBoolean("autopush", false) || mVar.jlA == null || mVar.jlA.isEmpty() || mVar.jly.isPushing())) {
                    x.i("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
                    mVar.jlj.setVisibility(0);
                    if (mVar.jlI) {
                        mVar.jly.startCameraPreview(mVar.jlj);
                    }
                    mVar.jly.startPusher(mVar.jlA);
                }
                jVar = new j();
            } else {
                jVar = new j(-3, "uninited livePusher");
            }
        }
        x.i("MicroMsg.AppBrandLivePusherView", "onUpdate code:%d info:%s", new Object[]{Integer.valueOf(jVar.errorCode), jVar.jlh});
    }

    public final boolean sr(String str) {
        x.i("MicroMsg.AppBrandLivePusherView", "onOperate code:%d info:%s", new Object[]{Integer.valueOf(r2.errorCode), this.jkT.st(str).jlh});
        if (this.jkT.st(str).errorCode == 0) {
            return true;
        }
        return false;
    }

    public final void sW() {
        j jVar;
        m mVar = this.jkT;
        if (mVar.gNe) {
            mVar.jly.stopCameraPreview(true);
            mVar.jly.stopPusher();
            mVar.jly.setPushListener(null);
            jVar = new j();
        } else {
            jVar = new j(-3, "uninited livePusher");
        }
        x.i("MicroMsg.AppBrandLivePusherView", "onDestroy code:%d info:%s", new Object[]{Integer.valueOf(jVar.errorCode), jVar.jlh});
    }

    private void init(Context context) {
        this.jkT = new m(context);
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
    }
}
