package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.aq.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.or;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.s;
import com.tencent.mm.z.u;
import com.tencent.mm.z.u$b;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class GameJsApiSendAppMessage$SendAppMessageTask extends GameProcessActivityTask {
    public static final Creator<GameJsApiSendAppMessage$SendAppMessageTask> CREATOR = new 2();
    String appId;
    String description;
    String extInfo;
    String fGz;
    String fIG;
    String jIW;
    String jqV;
    String mXf;
    String mXg;
    String mXh;
    Bundle mXi;
    int scene;
    String thumbUrl;
    String title;
    String toUser;
    String verifyAppId;

    public final void a(Context context, a aVar) {
        b cfVar;
        switch (this.scene) {
            case 1:
                x.i("MicroMsg.GameJsApiSendAppMessage", "favoriteUrl");
                cfVar = new cf();
                com.tencent.mm.plugin.webview.model.b.a aVar2 = new com.tencent.mm.plugin.webview.model.b.a();
                aVar2.url = this.mXg;
                aVar2.thumbUrl = this.thumbUrl;
                aVar2.title = this.title;
                aVar2.desc = this.description;
                aVar2.fFm = this.appId;
                if (this.mXi != null) {
                    String hz = u.hz(bh.ou(this.mXi.getString("KPublisherId")));
                    u$b t = u.GK().t(hz, true);
                    t.o("sendAppMsgScene", Integer.valueOf(2));
                    t.o("preChatName", this.mXi.getString("preChatName"));
                    t.o("preMsgIndex", Integer.valueOf(this.mXi.getInt("preMsgIndex")));
                    t.o("prePublishId", this.mXi.getString("prePublishId"));
                    t.o("preUsername", this.mXi.getString("preUsername"));
                    t.o("getA8KeyScene", Integer.valueOf(this.mXi.getInt("getA8KeyScene")));
                    t.o("referUrl", this.mXi.getString("referUrl"));
                    if (!bh.ov(null)) {
                        t.o("adExtStr", null);
                    }
                    cfVar.fqp.fqu = hz;
                }
                if (context != null && (context instanceof MMActivity)) {
                    cfVar.fqp.activity = (Activity) context;
                    cfVar.fqp.fqw = 36;
                }
                cfVar.fqp.fqy = new 1(this, aVar);
                com.tencent.mm.plugin.webview.model.b.a(cfVar, aVar2);
                com.tencent.mm.sdk.b.a.xef.m(cfVar);
                return;
            default:
                x.i("MicroMsg.GameJsApiSendAppMessage", "sendToFriend");
                if (bh.ov(this.toUser)) {
                    x.e("MicroMsg.GameJsApiSendAppMessage", "toUser is null");
                    return;
                }
                o.Pv();
                Bitmap iG = c.iG(this.thumbUrl);
                IMediaObject wXWebpageObject = new WXWebpageObject();
                wXWebpageObject.webpageUrl = this.mXg;
                wXWebpageObject.extInfo = this.extInfo;
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.mediaObject = wXWebpageObject;
                wXMediaMessage.title = this.title;
                wXMediaMessage.description = this.description;
                if (!(iG == null || iG.isRecycled())) {
                    x.i("MicroMsg.GameJsApiSendAppMessage", "thumb image is not null");
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    iG.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                }
                f aZ = g.aZ(this.appId, true);
                b opVar = new op();
                opVar.fGx.fzc = wXMediaMessage;
                opVar.fGx.appId = this.appId;
                opVar.fGx.appName = aZ == null ? "" : aZ.field_appName;
                opVar.fGx.toUser = this.toUser;
                opVar.fGx.fGy = 2;
                if (bh.ov(this.fGz)) {
                    opVar.fGx.fGB = null;
                } else {
                    opVar.fGx.fGz = this.fGz;
                    opVar.fGx.fGA = this.mXf;
                }
                opVar.fGx.fGC = this.fIG;
                opVar.fGx.fGF = this.mXh;
                opVar.fGx.fqu = u.hz(this.mXh);
                opVar.fGx.fGD = this.jIW;
                opVar.fGx.fGE = this.verifyAppId;
                com.tencent.mm.sdk.b.a.xef.m(opVar);
                if (!bh.ov(this.jqV)) {
                    cfVar = new or();
                    cfVar.fGI.fGJ = this.toUser;
                    cfVar.fGI.content = this.jqV;
                    cfVar.fGI.type = s.hp(this.toUser);
                    cfVar.fGI.flags = 0;
                    com.tencent.mm.sdk.b.a.xef.m(cfVar);
                }
                aVar.afh();
                return;
        }
    }

    public final void f(Parcel parcel) {
        this.scene = parcel.readInt();
        this.appId = parcel.readString();
        this.fGz = parcel.readString();
        this.mXf = parcel.readString();
        this.jqV = parcel.readString();
        this.toUser = parcel.readString();
        this.thumbUrl = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.mXg = parcel.readString();
        this.extInfo = parcel.readString();
        this.fIG = parcel.readString();
        this.jIW = parcel.readString();
        this.verifyAppId = parcel.readString();
        this.mXh = parcel.readString();
        this.mXi = parcel.readBundle();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.scene);
        parcel.writeString(this.appId);
        parcel.writeString(this.fGz);
        parcel.writeString(this.mXf);
        parcel.writeString(this.jqV);
        parcel.writeString(this.toUser);
        parcel.writeString(this.thumbUrl);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.mXg);
        parcel.writeString(this.fIG);
        parcel.writeString(this.jIW);
        parcel.writeString(this.verifyAppId);
        parcel.writeString(this.mXh);
        parcel.writeString(this.extInfo);
        parcel.writeBundle(this.mXi);
    }

    public GameJsApiSendAppMessage$SendAppMessageTask(Context context) {
        super(context);
    }

    private GameJsApiSendAppMessage$SendAppMessageTask(Parcel parcel) {
        f(parcel);
    }
}
