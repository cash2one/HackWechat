package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Message;
import com.tencent.mm.aq.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

class CdnImageView$1 extends af {
    final /* synthetic */ CdnImageView vnh;

    CdnImageView$1(CdnImageView cdnImageView) {
        this.vnh = cdnImageView;
    }

    public final void handleMessage(Message message) {
        String az = bh.az(message.getData().getString("k_url"), "");
        CdnImageView.a(this.vnh, bh.az(CdnImageView.a(this.vnh), ""));
        if (bh.ov(CdnImageView.a(this.vnh)) && bh.ov(az)) {
            this.vnh.setImageBitmap(null);
            this.vnh.y(null);
        } else if (CdnImageView.a(this.vnh).equals(az)) {
            byte[] byteArray = message.getData().getByteArray("k_data");
            if (byteArray == null || byteArray.length == 0) {
                x.e("MicroMsg.CdnImageView", "handleMsg fail, data is null");
                return;
            }
            Bitmap bl = d.bl(byteArray);
            o.Pv();
            c.g(CdnImageView.a(this.vnh), bl);
            if (CdnImageView.b(this.vnh)) {
                CdnImageView.a(this.vnh, bl);
            }
            if (bl != null && CdnImageView.c(this.vnh) > 0 && CdnImageView.d(this.vnh) > 0) {
                bl = d.a(bl, CdnImageView.d(this.vnh), CdnImageView.c(this.vnh), true, false);
            }
            if (!(bl == null || bh.ov(CdnImageView.e(this.vnh)))) {
                try {
                    d.a(bl, 100, CompressFormat.JPEG, CdnImageView.e(this.vnh), false);
                } catch (Exception e) {
                    x.e("MicroMsg.CdnImageView", "save image failed, %s", new Object[]{e.getMessage()});
                }
            }
            if (CdnImageView.f(this.vnh) && bl != null) {
                bl = d.a(bl, false, ((float) bl.getWidth()) * 0.5f);
            }
            this.vnh.setImageBitmap(bl);
            this.vnh.y(bl);
        } else {
            x.d("MicroMsg.CdnImageView", "hy: url not equal. abort this msg");
        }
    }
}
