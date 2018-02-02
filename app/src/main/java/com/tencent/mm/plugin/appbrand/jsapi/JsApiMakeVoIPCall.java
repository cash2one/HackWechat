package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONObject;

public final class JsApiMakeVoIPCall extends a {
    public static final int CTRL_INDEX = 154;
    public static final String NAME = "makeVoIPCall";
    private j iqB;
    private int jcs;

    private static class StartVoIPCall extends MainProcessTask {
        public static final Creator<StartVoIPCall> CREATOR = new 2();
        private e jcL;
        private j jcM;
        private int jcN;
        private c jdt = new 1(this);
        public int status;

        public StartVoIPCall(e eVar, j jVar, int i) {
            this.jcL = eVar;
            this.jcM = jVar;
            this.jcN = i;
        }

        public StartVoIPCall(Parcel parcel) {
            f(parcel);
        }

        public final void Yr() {
            a.xef.b(this.jdt);
        }

        public final void Ys() {
            afj();
            x.i("MicroMsg.JsApiMakeVoIPCall", "makeVoIPCall = %d", new Object[]{Integer.valueOf(this.status)});
            if (this.status == 1) {
                this.jcM.E(this.jcN, this.jcL.e("cancel", null));
            } else if (this.status == 2) {
                this.jcM.E(this.jcN, this.jcL.e("ok", null));
            } else if (this.status == 3) {
                this.jcM.E(this.jcN, this.jcL.e("fail:network error", null));
            } else if (this.status == 4) {
                this.jcM.E(this.jcN, this.jcL.e("fail:param not match", null));
            } else {
                this.jcM.E(this.jcN, this.jcL.e("fail:unknow", null));
            }
        }

        public final void f(Parcel parcel) {
            this.status = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.status);
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        this.iqB = jVar;
        this.jcs = i;
        String optString = jSONObject.optString("context");
        String optString2 = jSONObject.optString("avatarUrl");
        boolean optBoolean = jSONObject.optBoolean("showOther");
        boolean optBoolean2 = jSONObject.optBoolean("allowBackCamera");
        String optString3 = jSONObject.optString("toUserName");
        String ou = bh.ou(jSONObject.optString("scene"));
        String ou2 = bh.ou(jSONObject.optString(DownloadSettingTable$Columns.TYPE));
        AppBrandSysConfig appBrandSysConfig = jVar.irP.iqx;
        if (bh.ov(optString3) && appBrandSysConfig != null) {
            optString3 = appBrandSysConfig.fnl;
        }
        if (bh.ov(jVar.mAppId) || bh.ov(optString3)) {
            x.e("MicroMsg.JsApiMakeVoIPCall", "appId or toUserName invalid!");
            jVar.E(i, e("fail", null));
            return;
        }
        x.d("MicroMsg.JsApiMakeVoIPCall", "allowBackCamera: %s, showOther: %s, avatarUrl: %s, context: %s, toUserName: %s", new Object[]{Boolean.valueOf(optBoolean2), Boolean.valueOf(optBoolean), optString2, optString, optString3});
        MainProcessTask startVoIPCall = new StartVoIPCall(this, jVar, i);
        startVoIPCall.afi();
        AppBrandMainProcessService.a(startVoIPCall);
        Intent intent = new Intent();
        intent.putExtra("voipCSBizId", optString3);
        intent.putExtra("voipCSAppId", jVar.mAppId);
        intent.putExtra("voipCSAllowBackCamera", optBoolean2 ? "1" : "0");
        intent.putExtra("voipCSShowOther", optBoolean ? "1" : "0");
        intent.putExtra("voipCSAvatarUrl", optString2);
        intent.putExtra("voipCSContext", optString);
        intent.putExtra("voipCSScene", ou);
        intent.putExtra("voipCSType", ou2);
        intent.putExtra("launch_from_appbrand", true);
        intent.setClassName(jVar.getContext(), jVar.getContext().getPackageName() + ".plugin.voip_cs.ui.VoipCSMainUI");
        AppBrandProcessProxyUI.m(jVar.getContext(), intent);
    }
}
