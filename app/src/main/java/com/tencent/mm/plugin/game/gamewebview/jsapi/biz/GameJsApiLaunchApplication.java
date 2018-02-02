package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.g.a.iq;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.alv;
import com.tencent.mm.protocal.c.alw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public final class GameJsApiLaunchApplication extends a {
    public static final int CTRL_BYTE = 260;
    public static final String NAME = "launchApplication";

    private static class LaunchApplicationTask extends GameProcessActivityTask {
        public static final Creator<LaunchApplicationTask> CREATOR = new 3();
        public String appId;
        public String extInfo;
        public Bundle fqh;
        public Runnable jcI;
        public String jdm;
        public int showType;
        public boolean success;

        public final void a(Context context, GameProcessActivityTask.a aVar) {
            if (g.m(context, this.appId)) {
                IMediaObject wXAppExtendObject = new WXAppExtendObject();
                wXAppExtendObject.extInfo = this.extInfo;
                WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                wXMediaMessage.sdkVer = 620823552;
                wXMediaMessage.messageExt = this.extInfo;
                b iqVar = new iq();
                iqVar.fza.fzc = wXMediaMessage;
                iqVar.fza.appId = this.appId;
                iqVar.fza.showType = this.showType;
                iqVar.fza.context = context;
                iqVar.fza.fqh = this.fqh;
                iqVar.fza.fzd = new 1(this, iqVar, aVar);
                com.tencent.mm.sdk.b.a.xef.m(iqVar);
                if (!iqVar.fzb.fze) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.appId + "://" + this.jdm));
                    x.i("MicroMsg.GameJsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[]{r0});
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    List y = bh.y(context, intent);
                    if (!(y == null || y.isEmpty())) {
                        Object b;
                        if (TextUtils.isEmpty(intent.getPackage()) && y.size() == 1) {
                            b = g.b((ResolveInfo) y.get(0));
                        } else {
                            b = intent.getPackage();
                        }
                        if (!bh.ou(ac.getPackageName()).equals(b)) {
                            g.a(context, intent, null, new 2(this, aVar), this.fqh);
                            return;
                        }
                    }
                    this.success = false;
                    aVar.afh();
                    return;
                }
                return;
            }
            x.e("MicroMsg.GameJsApiLaunchApplication", "app is not installed, appid:[%s]", new Object[]{this.appId});
            this.success = false;
            aVar.afh();
        }

        public final void Ys() {
            if (this.jcI != null) {
                this.jcI.run();
            }
        }

        public final void f(Parcel parcel) {
            boolean z = true;
            this.showType = parcel.readInt();
            this.appId = parcel.readString();
            this.jdm = parcel.readString();
            this.extInfo = parcel.readString();
            this.fqh = parcel.readBundle();
            if (parcel.readByte() != (byte) 1) {
                z = false;
            }
            this.success = z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.showType);
            parcel.writeString(this.appId);
            parcel.writeString(this.jdm);
            parcel.writeString(this.extInfo);
            parcel.writeBundle(this.fqh);
            parcel.writeByte((byte) (this.success ? 1 : 0));
        }

        public LaunchApplicationTask(MMActivity mMActivity) {
            super(mMActivity);
        }

        private LaunchApplicationTask(Parcel parcel) {
            f(parcel);
        }
    }

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiLaunchApplication", "invoke");
        if (jSONObject == null) {
            x.e("MicroMsg.GameJsApiLaunchApplication", "data is null");
            dVar.E(i, a.e("launchApplication:fail", null));
            return;
        }
        Context aPh = dVar.aPh();
        String optString = jSONObject.optString("appID");
        String optString2 = jSONObject.optString("schemeUrl");
        String optString3 = jSONObject.optString("parameter");
        int optInt = jSONObject.optInt("alertType");
        x.i("MicroMsg.GameJsApiLaunchApplication", "appid : %s, scheme : %s, extinfo:[%s], parameter : %s", new Object[]{optString, optString2, jSONObject.optString("extInfo"), optString3});
        if (bh.ov(optString) && bh.ov(optString2)) {
            x.e("MicroMsg.GameJsApiLaunchApplication", "appid and scheme is null or nil");
            dVar.E(i, a.e("launchApplication:fail", null));
            return;
        }
        Object aPl = dVar.aPl();
        Bundle bundle = new Bundle();
        try {
            bundle.putString("current_page_url", URLEncoder.encode(dVar.aPk(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
        }
        bundle.putString("current_page_appid", aPl);
        if (!bh.ov(optString)) {
            a.a aVar = new a.a(dVar, i);
            com.tencent.mm.ae.b.a aVar2 = new com.tencent.mm.ae.b.a();
            aVar2.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
            aVar2.hmi = 1125;
            com.tencent.mm.bq.a com_tencent_mm_protocal_c_alv = new alv();
            com_tencent_mm_protocal_c_alv.fFm = aPl;
            com_tencent_mm_protocal_c_alv.wsO = optString;
            com_tencent_mm_protocal_c_alv.scene = dVar.mZq;
            com_tencent_mm_protocal_c_alv.url = dVar.aPk();
            com_tencent_mm_protocal_c_alv.wsP = optString2;
            com_tencent_mm_protocal_c_alv.liK = optInt;
            com_tencent_mm_protocal_c_alv.wsQ = 0;
            x.i("MicroMsg.GameJsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", new Object[]{aPl, optString, Integer.valueOf(com_tencent_mm_protocal_c_alv.scene), com_tencent_mm_protocal_c_alv.url, com_tencent_mm_protocal_c_alv.wsP, Integer.valueOf(com_tencent_mm_protocal_c_alv.liK)});
            aVar2.hmj = com_tencent_mm_protocal_c_alv;
            aVar2.hmk = new alw();
            com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar2.JZ(), new 2(this, aVar, optString2, aPh, bundle, optString, r8));
        } else if (TextUtils.isEmpty(aPl)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(optString2));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            List y = bh.y(aPh, intent);
            if (!(y == null || y.isEmpty())) {
                if (TextUtils.isEmpty(intent.getPackage()) && y.size() == 1) {
                    aPl = g.b((ResolveInfo) y.get(0));
                } else {
                    aPl = intent.getPackage();
                }
                if (!bh.ou(ac.getPackageName()).equals(aPl)) {
                    g.a(aPh, intent, null, new 1(this, dVar, i), bundle);
                    return;
                }
            }
            dVar.E(i, a.e("launchApplication:fail", null));
        } else {
            dVar.E(i, a.e("launchApplication:fail", null));
        }
    }
}
