package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.or;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.r;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.s;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class SnsTransparentUI$1 implements a {
    final /* synthetic */ String rKT;
    final /* synthetic */ String rKU;
    final /* synthetic */ String rKV;
    final /* synthetic */ String rKW;
    final /* synthetic */ String rKX;
    final /* synthetic */ String rKY;
    final /* synthetic */ SnsTransparentUI rKZ;

    SnsTransparentUI$1(SnsTransparentUI snsTransparentUI, String str, String str2, String str3, String str4, String str5, String str6) {
        this.rKZ = snsTransparentUI;
        this.rKT = str;
        this.rKU = str2;
        this.rKV = str3;
        this.rKW = str4;
        this.rKX = str5;
        this.rKY = str6;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i2 == -1) {
            String str;
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("Select_Conv_User");
            }
            if (str == null || str.length() == 0) {
                x.e("SnsTransparentUI", "mmOnActivityResult fail, toUser is null");
                this.rKZ.finish();
                return;
            }
            x.i("SnsTransparentUI", "doTransimt snsAdNativeLadingPagesUI is ok");
            final String str2 = this.rKT;
            final Context context = this.rKZ;
            r.a.voy.a(((MMActivity) context).mController, this.rKU, this.rKV, this.rKW, context.getResources().getString(j.dGA), new o.a(this) {
                final /* synthetic */ SnsTransparentUI$1 rLb;

                public final void a(boolean z, String str, int i) {
                    if (z) {
                        WXMediaMessage wXMediaMessage = new WXMediaMessage();
                        wXMediaMessage.title = this.rLb.rKU;
                        wXMediaMessage.description = this.rLb.rKW;
                        IMediaObject wXWebpageObject = new WXWebpageObject();
                        wXWebpageObject.canvasPageXml = str2;
                        wXWebpageObject.webpageUrl = this.rLb.rKX;
                        wXMediaMessage.mediaObject = wXWebpageObject;
                        if (SnsTransparentUI.a(this.rLb.rKZ).containsKey(this.rLb.rKV)) {
                            Bitmap bitmap = (Bitmap) SnsTransparentUI.a(this.rLb.rKZ).get(this.rLb.rKV);
                            if (!(bitmap == null || bitmap.isRecycled())) {
                                x.i("SnsTransparentUI", "thumb image is not null");
                                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                            }
                            b opVar = new op();
                            opVar.fGx.fzc = wXMediaMessage;
                            opVar.fGx.toUser = str;
                            opVar.fGx.fGy = 49;
                            opVar.fGx.fGz = "";
                            opVar.fGx.fGA = "";
                            opVar.fGx.fGG = this.rLb.rKY;
                            com.tencent.mm.sdk.b.a.xef.m(opVar);
                            if (!TextUtils.isEmpty(str)) {
                                opVar = new or();
                                opVar.fGI.fGJ = str;
                                opVar.fGI.content = str;
                                opVar.fGI.type = s.hp(str);
                                opVar.fGI.flags = 0;
                                com.tencent.mm.sdk.b.a.xef.m(opVar);
                            }
                            h.bu(context, context.getString(j.dGG));
                            this.rLb.rKZ.finish();
                            return;
                        }
                        ab.UZ(this.rLb.rKV);
                        d.a("adId", this.rLb.rKV, false, 1000000001, 0, new 1(this, wXMediaMessage, str));
                        return;
                    }
                    this.rLb.rKZ.finish();
                }
            });
            return;
        }
        this.rKZ.finish();
    }
}
