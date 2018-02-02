package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.or;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.1.1;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.s;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class SnsAdNativeLandingTestUI$1$1$1 implements a {
    final /* synthetic */ String fgO;
    final /* synthetic */ 1 ryK;
    final /* synthetic */ Context val$context;

    SnsAdNativeLandingTestUI$1$1$1(1 1, String str, Context context) {
        this.ryK = 1;
        this.fgO = str;
        this.val$context = context;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.title = "test title";
            wXMediaMessage.description = "test desc";
            IMediaObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.canvasPageXml = "<xml></xml>";
            wXWebpageObject.webpageUrl = "http://www.baidu.com/";
            wXMediaMessage.mediaObject = wXWebpageObject;
            Bitmap bitmap = ac.getBitmap("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
            if (!(bitmap == null || bitmap.isRecycled())) {
                x.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "thumb image is not null");
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
            }
            b opVar = new op();
            opVar.fGx.fzc = wXMediaMessage;
            opVar.fGx.toUser = this.fgO;
            opVar.fGx.fGy = 49;
            opVar.fGx.fGz = "";
            opVar.fGx.fGA = "";
            com.tencent.mm.sdk.b.a.xef.m(opVar);
            if (!TextUtils.isEmpty(str)) {
                b orVar = new or();
                orVar.fGI.fGJ = this.fgO;
                orVar.fGI.content = str;
                orVar.fGI.type = s.hp(this.fgO);
                orVar.fGI.flags = 0;
                com.tencent.mm.sdk.b.a.xef.m(orVar);
            }
            h.bu(this.val$context, this.val$context.getString(j.dGG));
        }
    }
}
