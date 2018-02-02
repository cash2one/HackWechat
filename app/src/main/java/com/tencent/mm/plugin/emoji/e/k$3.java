package com.tencent.mm.plugin.emoji.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.aq.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.or;
import com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.ui.applet.o$a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.s;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class k$3 implements o$a {
    final /* synthetic */ MMActivity fgW;
    final /* synthetic */ int iGh;
    final /* synthetic */ String icx;
    final /* synthetic */ String jqG;
    final /* synthetic */ int lwG;
    final /* synthetic */ String lwH;
    final /* synthetic */ String lwI;
    final /* synthetic */ int lwJ;
    final /* synthetic */ String lwK;
    final /* synthetic */ String lww;

    k$3(String str, int i, int i2, String str2, String str3, String str4, String str5, int i3, String str6, MMActivity mMActivity) {
        this.lww = str;
        this.iGh = i;
        this.lwG = i2;
        this.icx = str2;
        this.jqG = str3;
        this.lwH = str4;
        this.lwI = str5;
        this.lwJ = i3;
        this.lwK = str6;
        this.fgW = mMActivity;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            String str2 = this.lww;
            int i2 = this.iGh;
            int i3 = this.lwG;
            String str3 = this.icx;
            String str4 = this.jqG;
            String str5 = this.lwH;
            String str6 = this.lwI;
            int i4 = this.lwJ;
            String str7 = this.lwK;
            x.d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.title = str3;
            wXMediaMessage.description = str4;
            IMediaObject wXEmojiPageSharedObject = new WXEmojiPageSharedObject();
            wXEmojiPageSharedObject.type = i2;
            wXEmojiPageSharedObject.tid = i3;
            wXEmojiPageSharedObject.title = str3;
            wXEmojiPageSharedObject.desc = str4;
            wXEmojiPageSharedObject.iconUrl = str5;
            wXEmojiPageSharedObject.secondUrl = str6;
            wXEmojiPageSharedObject.pageType = i4;
            wXEmojiPageSharedObject.url = str7;
            wXMediaMessage.mediaObject = wXEmojiPageSharedObject;
            o.Pv();
            Bitmap iG = c.iG(str5);
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
            a.xef.m(opVar);
            if (!TextUtils.isEmpty(str)) {
                opVar = new or();
                opVar.fGI.fGJ = str2;
                opVar.fGI.content = str;
                opVar.fGI.type = s.hp(str2);
                opVar.fGI.flags = 0;
                a.xef.m(opVar);
            }
            h.bu(this.fgW, this.fgW.getString(R.l.dGG));
        }
    }
}
