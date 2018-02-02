package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class JsApiChooseMedia$a$4 implements Runnable {
    final /* synthetic */ a jnj;

    JsApiChooseMedia$a$4(a aVar) {
        this.jnj = aVar;
    }

    public final void run() {
        if (new File(a.f(this.jnj)).exists()) {
            x.i("MicroMsg.JsApiChooseMedia", "take media local, the mVideoFilePath file exist, success");
            a.e(this.jnj).bjW = -1;
            a.e(this.jnj).type = SlookAirButtonRecentMediaAdapter.VIDEO_TYPE;
            AppBrandLocalVideoObject a = a.a(this.jnj, a.f(this.jnj));
            if (a == null) {
                x.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", a.f(this.jnj));
                a.e(this.jnj).bjW = -2;
                a.b(this.jnj, a.e(this.jnj));
                return;
            }
            a.b(this.jnj, a.f(this.jnj));
            String g = a.g(this.jnj);
            a.e(this.jnj).jnd = a.c(a.fus, g, a.duration, a.height, a.width, a.size);
            a.c(this.jnj, a.e(this.jnj));
            return;
        }
        x.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is %s, the file not exist, fail", a.f(this.jnj));
        a.e(this.jnj).bjW = -2;
        a.d(this.jnj, a.e(this.jnj));
    }
}
