package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.aq.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.or;
import com.tencent.mm.opensdk.modelmsg.WXDesignerSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.s;
import com.tencent.mm.z.u;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class k {

    static class AnonymousClass2 implements a {
        final /* synthetic */ MMActivity fgW;
        final /* synthetic */ String jqG;
        final /* synthetic */ String jwu;
        final /* synthetic */ String lwA;
        final /* synthetic */ String lwC;
        final /* synthetic */ String lwD;
        final /* synthetic */ int lwE;
        final /* synthetic */ String lwF;

        public AnonymousClass2(String str, String str2, String str3, int i, String str4, String str5, String str6, MMActivity mMActivity) {
            this.lwC = str;
            this.lwD = str2;
            this.jqG = str3;
            this.lwE = i;
            this.lwA = str4;
            this.jwu = str5;
            this.lwF = str6;
            this.fgW = mMActivity;
        }

        public final void a(boolean z, String str, int i) {
            if (z) {
                String str2 = this.lwC;
                String str3 = this.lwD;
                String str4 = this.jqG;
                int i2 = this.lwE;
                String str5 = this.lwA;
                String str6 = this.jwu;
                String str7 = this.lwF;
                x.d("MicroMsg.emoji.EmojiSharedMgr", "shareToFriend");
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.title = str3;
                wXMediaMessage.description = str4;
                IMediaObject wXDesignerSharedObject = new WXDesignerSharedObject();
                wXDesignerSharedObject.designerUIN = i2;
                wXDesignerSharedObject.thumburl = str7;
                wXDesignerSharedObject.url = str5;
                wXDesignerSharedObject.designerName = str6;
                wXDesignerSharedObject.designerRediretctUrl = str7;
                wXMediaMessage.mediaObject = wXDesignerSharedObject;
                o.Pv();
                Bitmap iG = c.iG(str7);
                if (!(iG == null || iG.isRecycled())) {
                    x.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    iG.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                }
                b opVar = new op();
                opVar.fGx.fzc = wXMediaMessage;
                opVar.fGx.toUser = str2;
                opVar.fGx.fGy = 49;
                opVar.fGx.fGz = str2;
                opVar.fGx.fGA = "";
                com.tencent.mm.sdk.b.a.xef.m(opVar);
                if (!TextUtils.isEmpty(str)) {
                    opVar = new or();
                    opVar.fGI.fGJ = str2;
                    opVar.fGI.content = str;
                    opVar.fGI.type = s.hp(str2);
                    opVar.fGI.flags = 0;
                    com.tencent.mm.sdk.b.a.xef.m(opVar);
                }
                h.bu(this.fgW, this.fgW.getString(R.l.dGG));
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, int i) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_title", str);
        intent.putExtra("KContentObjDesc", str2);
        intent.putExtra("Ksnsupload_imgurl", str3);
        intent.putExtra("Ksnsupload_link", str4);
        intent.putExtra("KUploadProduct_UserData", str5);
        intent.putExtra("Ksnsupload_type", i);
        String hz = u.hz("emoje_stroe");
        u.GK().t(hz, true).o("prePublishId", "emoje_stroe");
        intent.putExtra("reportSessionId", hz);
        d.a(context, "sns", ".ui.SnsUploadUI", intent, false);
    }

    public static void cu(Context context) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra(com.tencent.mm.ui.u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
        intent.putExtra(com.tencent.mm.ui.u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqm);
        d.a(context, ".ui.transmit.SelectConversationUI", intent, 2002);
    }

    public static void a(MMActivity mMActivity, String str, int i, int i2, String str2, String str3, String str4, String str5, int i3, String str6) {
        e.b(mMActivity.mController, str2, str4, str3, "", mMActivity.getString(R.l.dGA), new 3(str, i, i2, str2, str3, str4, str5, i3, str6, mMActivity));
    }
}
