package com.tencent.mm.plugin.sns.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.or;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d$a;
import com.tencent.mm.plugin.sns.ui.SnsTransparentUI.1.1;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.s;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class SnsTransparentUI$1$1$1 implements d$a {
    final /* synthetic */ String gID;
    final /* synthetic */ WXMediaMessage rLc;
    final /* synthetic */ 1 rLd;

    SnsTransparentUI$1$1$1(1 1, WXMediaMessage wXMediaMessage, String str) {
        this.rLd = 1;
        this.rLc = wXMediaMessage;
        this.gID = str;
    }

    public final void bxc() {
    }

    public final void bxd() {
    }

    public final void KY(String str) {
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            this.rLd.rLb.rKZ.rjX.put(this.rLd.rLb.rKV, decodeFile);
            if (!(decodeFile == null || decodeFile.isRecycled())) {
                x.i("SnsTransparentUI", "thumb image is not null");
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                decodeFile.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                this.rLc.thumbData = byteArrayOutputStream.toByteArray();
            }
            b opVar = new op();
            opVar.fGx.fzc = this.rLc;
            opVar.fGx.toUser = this.rLd.fgO;
            opVar.fGx.fGy = 49;
            opVar.fGx.fGz = "";
            opVar.fGx.fGA = "";
            opVar.fGx.fGG = this.rLd.rLb.rKY;
            a.xef.m(opVar);
            if (!TextUtils.isEmpty(this.gID)) {
                opVar = new or();
                opVar.fGI.fGJ = this.rLd.fgO;
                opVar.fGI.content = this.gID;
                opVar.fGI.type = s.hp(this.rLd.fgO);
                opVar.fGI.flags = 0;
                a.xef.m(opVar);
            }
            h.bu(this.rLd.val$context, this.rLd.val$context.getString(j.dGG));
            this.rLd.rLb.rKZ.finish();
        } catch (Exception e) {
            x.e("SnsTransparentUI", "this has a error : " + e.toString());
            this.rLd.rLb.rKZ.finish();
        }
    }
}
