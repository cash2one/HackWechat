package com.tencent.mm.plugin.location.ui;

import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

class SimpleImageView$1 extends af {
    final /* synthetic */ SimpleImageView nUs;

    SimpleImageView$1(SimpleImageView simpleImageView) {
        this.nUs = simpleImageView;
    }

    public final void handleMessage(Message message) {
        byte[] bArr = (byte[]) message.obj;
        if (bArr == null || bArr.length == 0) {
            x.e("MicroMsg.SimpleImageView", "handleMsg fail, data is null");
            return;
        }
        Bitmap bitmap;
        Bitmap bl = d.bl(bArr);
        x.d("MicroMsg.SimpleImageView", "filePath  %s", new Object[]{SimpleImageView.a(this.nUs) + g.s(SimpleImageView.b(this.nUs).getBytes())});
        e.b(r2, bArr, bArr.length);
        if (bl == null || SimpleImageView.c(this.nUs) <= 0 || SimpleImageView.d(this.nUs) <= 0) {
            bitmap = bl;
        } else {
            bitmap = d.a(bl, SimpleImageView.d(this.nUs), SimpleImageView.c(this.nUs), true, false);
        }
        this.nUs.setImageBitmap(bitmap);
    }
}
