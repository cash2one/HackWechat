package com.tencent.mm.plugin.emoji.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.aq.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.or;
import com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.s;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class k$1 implements a {
    final /* synthetic */ MMActivity fgW;
    final /* synthetic */ String jKh;
    final /* synthetic */ String lwA;
    final /* synthetic */ int lwB;
    final /* synthetic */ String lww;
    final /* synthetic */ String lwx;
    final /* synthetic */ String lwy;
    final /* synthetic */ String lwz;

    public k$1(String str, String str2, String str3, String str4, String str5, String str6, int i, MMActivity mMActivity) {
        this.lww = str;
        this.lwx = str2;
        this.lwy = str3;
        this.lwz = str4;
        this.jKh = str5;
        this.lwA = str6;
        this.lwB = i;
        this.fgW = mMActivity;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            String str2 = this.lww;
            String str3 = this.lwx;
            String str4 = this.lwy;
            String str5 = this.lwz;
            String str6 = this.jKh;
            String str7 = this.lwA;
            int i2 = this.lwB;
            x.d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.title = str4;
            wXMediaMessage.description = str5;
            IMediaObject wXEmojiSharedObject = new WXEmojiSharedObject();
            wXEmojiSharedObject.packageflag = i2;
            wXEmojiSharedObject.packageid = str3;
            wXEmojiSharedObject.thumburl = str6;
            wXEmojiSharedObject.url = str7;
            wXMediaMessage.mediaObject = wXEmojiSharedObject;
            o.Pv();
            Bitmap iG = c.iG(str6);
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
            g.pQN.h(10993, new Object[]{Integer.valueOf(0), str3});
            h.bu(this.fgW, this.fgW.getString(R.l.dGG));
        }
    }
}
