package com.tencent.mm.plugin.nearlife.ui;

import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

class LogoImageView$1 extends af {
    final /* synthetic */ LogoImageView oQM;

    LogoImageView$1(LogoImageView logoImageView) {
        this.oQM = logoImageView;
    }

    public final void handleMessage(Message message) {
        byte[] bArr = (byte[]) message.obj;
        if (bArr == null || bArr.length == 0) {
            x.e("MicroMsg.LogoImageView", "handleMsg fail, data is null");
            return;
        }
        Bitmap bitmap;
        Bitmap bl = d.bl(bArr);
        x.d("MicroMsg.LogoImageView", "filePath  %s", new Object[]{LogoImageView.a(this.oQM) + g.s(LogoImageView.b(this.oQM).getBytes())});
        e.b(r2, bArr, bArr.length);
        if (bl == null || LogoImageView.c(this.oQM) <= 0 || LogoImageView.d(this.oQM) <= 0) {
            bitmap = bl;
        } else {
            bitmap = d.a(bl, LogoImageView.d(this.oQM), LogoImageView.c(this.oQM), true, false);
        }
        this.oQM.setImageBitmap(bitmap);
    }
}
