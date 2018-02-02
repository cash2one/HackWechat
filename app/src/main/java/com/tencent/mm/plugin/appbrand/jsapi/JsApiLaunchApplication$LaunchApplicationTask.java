package com.tencent.mm.plugin.appbrand.jsapi;

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
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.List;

class JsApiLaunchApplication$LaunchApplicationTask extends AppBrandProxyTransparentUIProcessTask {
    public static final Creator<JsApiLaunchApplication$LaunchApplicationTask> CREATOR = new 2();
    public String appId;
    public String extInfo;
    public Bundle fqh;
    public Runnable jcI;
    public String jdm;
    public int showType;
    public boolean success;

    public final void a(Context context, a aVar) {
        boolean a;
        if (!g.m(context, this.appId)) {
            x.e("MicroMsg.JsApiLaunchApplication", "app is not installed, appid:[%s]", new Object[]{this.appId});
            this.success = false;
            aVar.afh();
        }
        Object jsApiLaunchApplication$a = new JsApiLaunchApplication$a(new 1(this, aVar));
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
        iqVar.fza.fzd = jsApiLaunchApplication$a;
        com.tencent.mm.sdk.b.a.xef.m(iqVar);
        boolean z = iqVar.fzb.fze;
        if (!z) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.appId + "://" + this.jdm));
            x.i("MicroMsg.JsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[]{r0});
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
                    jsApiLaunchApplication$a.hns = false;
                    jsApiLaunchApplication$a.jdp = false;
                    jsApiLaunchApplication$a.jdq = false;
                    jsApiLaunchApplication$a.fze = false;
                    a = g.a(context, intent, null, jsApiLaunchApplication$a, this.fqh);
                    jsApiLaunchApplication$a.cH(a);
                }
            }
        }
        a = z;
        jsApiLaunchApplication$a.cH(a);
    }

    public final void Ys() {
        x.i("MicroMsg.JsApiLaunchApplication", "runInClientProcess");
        if (this.jcI != null) {
            x.i("MicroMsg.JsApiLaunchApplication", "runInClientProcess asyncCallback != null");
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

    public JsApiLaunchApplication$LaunchApplicationTask(MMActivity mMActivity) {
        super(mMActivity);
    }

    private JsApiLaunchApplication$LaunchApplicationTask(Parcel parcel) {
        f(parcel);
    }
}
