package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.js;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.media.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.d;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u.b;

public class JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask extends MainProcessTask {
    public static final Creator<JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask> CREATOR = new Creator<JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask[i];
        }
    };
    public int action;
    public String appId;
    public String frn;
    public String fvL;
    public int fvM;
    b iTl;
    private e jcL;
    public j jcM;
    public int jcN;
    f jeU;
    c.b jeV;
    public String jeW;
    private final com.tencent.mm.sdk.b.c jeX = new 2(this);
    private boolean jfx = false;

    public JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask(a aVar, j jVar, int i) {
        this.jcL = aVar;
        this.jcM = jVar;
        this.jcN = i;
    }

    public JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInMainProcess");
        if (this.jfx) {
            x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "send Preempted Event");
            this.jfx = false;
            com.tencent.mm.sdk.b.b jsVar = new js();
            jsVar.fAz.action = 10;
            jsVar.fAz.state = "preempted";
            jsVar.fAz.appId = this.appId;
            jsVar.fAz.fAB = true;
            com.tencent.mm.sdk.b.a.xef.m(jsVar);
        }
        String str = d.a.aio().jzA;
        if (!bh.ov(str)) {
            x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "remove listener preAppid is %s, appid is %s", new Object[]{str, this.appId});
            d.a.aio().sg(str);
        }
        d.a.aio().a(this.jeX, this.appId);
        d aio = d.a.aio();
        String str2 = this.appId;
        int i = this.fvM;
        String str3 = this.frn;
        String str4 = this.fvL;
        aio.jzA = str2;
        aio.fvM = i;
        aio.frn = str3;
        aio.fvL = str4;
    }

    public final void Ys() {
        if (this.jcM == null) {
            x.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "service is null, don't callback");
            return;
        }
        switch (this.action) {
            case 0:
            case 1:
                this.iTl.o("setBackgroundAudioState#isPlaying", Boolean.valueOf(true));
                AppBrandStickyBannerLogic.a.d(this.jeU);
                c.a(this.appId, this.jeV);
                AppBrandMusicClientService.jzy.jzz = this.appId;
                if (JsApiSetBackgroundAudioState.jfv > 0) {
                    JsApiSetBackgroundAudioState.jfv--;
                    this.jcM.irP.YE();
                }
                if (JsApiSetBackgroundAudioState.jfv == 0) {
                    JsApiSetBackgroundAudioState.jfv++;
                    this.jcM.irP.YD();
                    break;
                }
                break;
            case 2:
            case 3:
            case 4:
            case 7:
                this.iTl.o("setBackgroundAudioState#isPlaying", Boolean.valueOf(false));
                AppBrandStickyBannerLogic.a.c(this.jeU);
                c.b(this.appId, this.jeV);
                if (JsApiSetBackgroundAudioState.jfv > 0) {
                    JsApiSetBackgroundAudioState.jfv--;
                    this.jcM.irP.YE();
                }
                AppBrandMusicClientService.jzy.kT(this.action);
                break;
            case 10:
                AppBrandMusicClientService.jzy.kT(this.action);
                break;
            case 13:
                JsApiOperateBackgroundAudio.b.c(this.jcM);
                return;
            case 14:
                JsApiOperateBackgroundAudio.a.c(this.jcM);
                return;
        }
        x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInClientProcess callback action:%d, retJson:%s, lockCount:%d", new Object[]{Integer.valueOf(this.action), this.jeW, Integer.valueOf(JsApiSetBackgroundAudioState.jfv)});
        com.tencent.mm.plugin.appbrand.jsapi.f a = new JsApiOperateBackgroundAudio.c().a(this.jcM);
        a.mData = this.jeW;
        a.afs();
    }

    public final void f(Parcel parcel) {
        boolean z = true;
        this.appId = parcel.readString();
        this.jeW = parcel.readString();
        this.action = parcel.readInt();
        this.fvM = parcel.readInt();
        this.frn = parcel.readString();
        this.fvL = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.jfx = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.jeW);
        parcel.writeInt(this.action);
        parcel.writeInt(this.fvM);
        parcel.writeString(this.frn);
        parcel.writeString(this.fvL);
        parcel.writeInt(this.jfx ? 1 : 0);
    }
}
