package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.media.d.a;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u.b;
import org.json.JSONObject;

class JsApiOperateMusicPlayer$OperateMusicPlayer extends MainProcessTask {
    public static final Creator<JsApiOperateMusicPlayer$OperateMusicPlayer> CREATOR = new 7();
    public int action;
    public String errorMsg;
    public String fBZ;
    public String fFm;
    b iTl;
    private e jcL;
    private j jcM;
    private int jcN;
    public boolean jeA = false;
    f jeU;
    c.b jeV;
    public String jeW;
    private final com.tencent.mm.sdk.b.c jeX = new 6(this);

    public JsApiOperateMusicPlayer$OperateMusicPlayer(e eVar, j jVar, int i) {
        this.jcL = eVar;
        this.jcM = jVar;
        this.jcN = i;
    }

    public JsApiOperateMusicPlayer$OperateMusicPlayer(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        try {
            JSONObject jSONObject = new JSONObject(this.fBZ);
            String optString = jSONObject.optString("operationType");
            final String optString2 = jSONObject.optString("dataUrl");
            if (bh.ov(optString)) {
                this.action = -1;
                this.jeA = true;
                this.errorMsg = "operationType is null or nil";
                afp();
            } else if (a.aio().br(this.fFm, optString)) {
                if (com.tencent.mm.av.b.Qr() && !com.tencent.mm.av.b.Qq() && optString.equalsIgnoreCase("play")) {
                    asv Qs = com.tencent.mm.av.b.Qs();
                    if (Qs == null || !(bh.ov(optString2) || optString2.equals(Qs.wAo))) {
                        x.i("MicroMsg.JsApiOperateMusicPlayer", "data url has changed ,restart play");
                    } else if (a.aio().br(this.fFm, "resume")) {
                        x.i("MicroMsg.JsApiOperateMusicPlayer", "same appid %s, change play to resume", new Object[]{this.fFm});
                        optString = "resume";
                    } else {
                        x.i("MicroMsg.JsApiOperateMusicPlayer", "not same not same appid ,restart play");
                    }
                }
                if (optString.equalsIgnoreCase("play")) {
                    final String optString3 = jSONObject.optString("title");
                    final String optString4 = jSONObject.optString("singer");
                    final String optString5 = jSONObject.optString("epname");
                    final String optString6 = jSONObject.optString("coverImgUrl");
                    if (bh.ov(optString2)) {
                        this.action = -1;
                        this.jeA = true;
                        this.errorMsg = "dataUrl is null or nil";
                        afp();
                        return;
                    }
                    x.i("MicroMsg.JsApiOperateMusicPlayer", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s", new Object[]{optString3, optString4, optString5, optString6, optString2, optString2, optString2});
                    com.tencent.mm.av.b.Qo();
                    optString = a.aio().jzA;
                    if (!bh.ov(optString)) {
                        x.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[]{optString, this.fFm});
                        a.aio().sg(optString);
                    }
                    final String str = optString2;
                    final String str2 = optString2;
                    ag.h(new Runnable(this) {
                        final /* synthetic */ JsApiOperateMusicPlayer$OperateMusicPlayer jfe;

                        public final void run() {
                            asv a = ((com.tencent.mm.av.a.a) g.h(com.tencent.mm.av.a.a.class)).a(optString6, optString6, optString3, optString4, str, str2, optString2, (this.jfe.fFm + optString2 + optString6).hashCode(), com.tencent.mm.compatible.util.e.bnF, com.tencent.mm.plugin.n.c.Fi() + optString6.hashCode(), optString5, "");
                            a.wAB = true;
                            com.tencent.mm.av.b.b(a);
                            a.aio().a(this.jfe.jeX, this.jfe.fFm);
                            a.aio().jzA = this.jfe.fFm;
                            a.aio().jzB = a.vVZ;
                            x.i("MicroMsg.JsApiOperateMusicPlayer", "startPlayMusic");
                            this.jfe.action = -1;
                            this.jfe.errorMsg = "";
                            this.jfe.jeA = false;
                            this.jfe.afp();
                        }
                    }, 500);
                } else if (optString.equalsIgnoreCase("resume")) {
                    optString = a.aio().jzA;
                    if (!bh.ov(optString)) {
                        x.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[]{optString, this.fFm});
                        a.aio().sg(optString);
                    }
                    a.aio().a(this.jeX, this.fFm);
                    a.aio().jzA = this.fFm;
                    asv Qs2 = com.tencent.mm.av.b.Qs();
                    if (Qs2 != null) {
                        a.aio().jzB = Qs2.vVZ;
                    }
                    if (com.tencent.mm.av.c.Qu()) {
                        ag.h(new 2(this), 500);
                        return;
                    }
                    x.i("MicroMsg.JsApiOperateMusicPlayer", "resume fail");
                    this.action = -1;
                    this.jeA = true;
                    this.errorMsg = "resume play fail";
                    afp();
                } else if (optString.equalsIgnoreCase("pause")) {
                    if (com.tencent.mm.av.c.Qv()) {
                        ag.h(new 3(this), 500);
                        return;
                    }
                    x.i("MicroMsg.JsApiOperateMusicPlayer", "pause fail");
                    this.action = -1;
                    this.jeA = true;
                    this.errorMsg = "pause play fail";
                    afp();
                } else if (optString.equalsIgnoreCase("seek")) {
                    if (com.tencent.mm.av.b.if(bh.getInt(bh.bY(jSONObject.optString("position")), -1) * 1000)) {
                        ag.h(new 4(this), 500);
                        return;
                    }
                    x.i("MicroMsg.JsApiOperateMusicPlayer", "seek fail");
                    this.action = -1;
                    this.jeA = true;
                    this.errorMsg = "seek fail";
                    afp();
                } else if (!optString.equalsIgnoreCase("stop")) {
                    this.action = -1;
                    this.jeA = true;
                    afp();
                } else if (com.tencent.mm.av.c.Qw()) {
                    ag.h(new 5(this), 500);
                } else {
                    x.i("MicroMsg.JsApiOperateMusicPlayer", "stop fail");
                    this.action = -1;
                    this.jeA = false;
                    this.errorMsg = "stop play fail";
                    afp();
                }
            } else {
                x.i("MicroMsg.JsApiOperateMusicPlayer", "appid not match cannot operate");
                this.action = -1;
                this.jeA = true;
                this.errorMsg = "appid not match cannot operate";
                afp();
            }
        } catch (Exception e) {
            x.e("MicroMsg.JsApiOperateMusicPlayer", e.toString());
            this.action = -1;
            this.jeA = true;
            this.errorMsg = "data is null";
            afp();
        }
    }

    public final void Ys() {
        String str;
        x.i("MicroMsg.JsApiOperateMusicPlayer", "runInClientProcess(action : %s)", new Object[]{Integer.valueOf(this.action)});
        j jVar = this.jcM;
        int i = this.jcN;
        e eVar = this.jcL;
        if (this.jeA) {
            str = "fail" + (TextUtils.isEmpty(this.errorMsg) ? "" : ":" + this.errorMsg);
        } else {
            str = "ok";
        }
        jVar.E(i, eVar.e(str, null));
        com.tencent.mm.plugin.appbrand.jsapi.f a;
        switch (this.action) {
            case 0:
                x.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPlay in");
                a = new JsApiOperateMusicPlayer.c((byte) 0).a(this.jcM);
                a.mData = this.jeW;
                a.afs();
                this.iTl.o("Music#isPlaying", Boolean.valueOf(true));
                AppBrandStickyBannerLogic.a.d(this.jeU);
                c.a(this.jcM.mAppId, this.jeV);
                return;
            case 1:
                x.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicResume in");
                this.iTl.o("Music#isPlaying", Boolean.valueOf(true));
                AppBrandStickyBannerLogic.a.d(this.jeU);
                c.a(this.jcM.mAppId, this.jeV);
                return;
            case 2:
                x.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicStop in");
                a = new JsApiOperateMusicPlayer$a().a(this.jcM);
                a.mData = this.jeW;
                a.afs();
                break;
            case 3:
                x.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPause in");
                a = new JsApiOperateMusicPlayer$b().a(this.jcM);
                a.mData = this.jeW;
                a.afs();
                this.iTl.o("Music#isPlaying", Boolean.valueOf(false));
                AppBrandStickyBannerLogic.a.c(this.jeU);
                c.b(this.jcM.mAppId, this.jeV);
                return;
            case 4:
                x.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicError in");
                this.jcM.h("onMusicError", this.jeW, 0);
                this.iTl.o("Music#isPlaying", Boolean.valueOf(false));
                AppBrandStickyBannerLogic.a.c(this.jeU);
                c.b(this.jcM.mAppId, this.jeV);
                return;
            case 7:
                break;
            default:
                return;
        }
        x.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicEnd in");
        this.iTl.o("Music#isPlaying", Boolean.valueOf(false));
        AppBrandStickyBannerLogic.a.c(this.jeU);
        c.b(this.jcM.mAppId, this.jeV);
    }

    public final void f(Parcel parcel) {
        this.fBZ = parcel.readString();
        this.fFm = parcel.readString();
        this.jeA = parcel.readByte() != (byte) 0;
        this.jeW = parcel.readString();
        this.action = parcel.readInt();
        this.errorMsg = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fBZ);
        parcel.writeString(this.fFm);
        parcel.writeByte(this.jeA ? (byte) 1 : (byte) 0);
        parcel.writeString(this.jeW);
        parcel.writeInt(this.action);
        parcel.writeString(this.errorMsg);
    }
}
