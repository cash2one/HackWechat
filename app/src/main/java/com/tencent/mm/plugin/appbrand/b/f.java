package com.tencent.mm.plugin.appbrand.b;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.media.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.AppBrandMusicClientService.StopBackgroundMusicTask;
import com.tencent.mm.plugin.appbrand.media.AppBrandMusicClientService.b;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.sdk.platformtools.x;

abstract class f extends g {
    int iHs = 0;
    private final b iHt = new 1(this);
    private final com.tencent.mm.plugin.appbrand.ui.banner.f iHu = new 2(this);
    final e irP;

    abstract void aau();

    f(h hVar, e eVar) {
        super(hVar);
        this.irP = eVar;
    }

    public void enter() {
        int i;
        super.enter();
        this.iHs = 0;
        String str = this.irP.mAppId;
        int i2 = this.irP.iqw.iGA;
        if (this.irP.iqx == null || !this.irP.iqx.iOE) {
            i = 0;
        } else {
            i = 1;
        }
        AppBrandMusicClientService appBrandMusicClientService;
        if (i == 0) {
            appBrandMusicClientService = AppBrandMusicClientService.jzy;
            if (!TextUtils.isEmpty(str)) {
                if (str.equalsIgnoreCase(appBrandMusicClientService.jzz)) {
                    MainProcessTask stopBackgroundMusicTask = new StopBackgroundMusicTask();
                    stopBackgroundMusicTask.appId = str;
                    AppBrandMainProcessService.a(stopBackgroundMusicTask);
                } else {
                    x.e("MicroMsg.AppBrandMusicClientService", "appId is diff, can't stop music");
                }
            }
        } else if (AppBrandMusicClientService.ti(str)) {
            ca(1);
            appBrandMusicClientService = AppBrandMusicClientService.jzy;
            b bVar = this.iHt;
            if (!(TextUtils.isEmpty(str) || bVar == null)) {
                if (appBrandMusicClientService.jzx.containsKey(str)) {
                    appBrandMusicClientService.jzx.remove(str);
                    appBrandMusicClientService.jzx.put(str, bVar);
                } else {
                    appBrandMusicClientService.jzx.put(str, bVar);
                }
            }
        }
        if (c.pe(str) == c.c.iqm || a.aM(str, i2)) {
            ca(2);
            a.d(this.iHu);
        }
        switch (3.iHw[c.pe(str).ordinal()]) {
            case 1:
                ca(16);
                break;
            case 2:
                ca(4);
                break;
            case 3:
                ca(8);
                break;
        }
        this.iHs = this.iHs;
        jA(0);
    }

    public void exit() {
        super.exit();
        this.iHs = 0;
        AppBrandMusicClientService appBrandMusicClientService = AppBrandMusicClientService.jzy;
        CharSequence charSequence = this.irP.mAppId;
        if (!TextUtils.isEmpty(charSequence) && appBrandMusicClientService.jzx.containsKey(charSequence)) {
            appBrandMusicClientService.jzx.remove(charSequence);
        }
        a.c(this.iHu);
    }

    private void ca(int i) {
        this.iHs |= i;
    }

    final void jA(int i) {
        this.iHs &= i ^ -1;
        if (this.iHs == 0) {
            aau();
        }
    }
}
