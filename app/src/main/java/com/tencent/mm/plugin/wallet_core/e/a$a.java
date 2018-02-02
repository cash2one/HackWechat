package com.tencent.mm.plugin.wallet_core.e;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class a$a implements a {
    Bankcard sAg;
    String sVR;
    WeakReference<ImageView> sYC;
    WeakReference<View> sYD = null;
    WeakReference<ImageView> sYE = null;
    boolean sYF = false;

    a$a() {
    }

    public final void l(String str, Bitmap bitmap) {
        boolean z = true;
        x.d("MicroMsg.BankcardLogoHelper", "onGetPictureFinish " + str + ", bitmap = " + (bitmap == null));
        if (TextUtils.isEmpty(this.sVR)) {
            x.e("MicroMsg.BankcardLogoHelper", "mBankcardLogoUrl is empty");
        } else if (this.sYC != null) {
            String str2;
            ImageView imageView = (ImageView) this.sYC.get();
            String str3 = "MicroMsg.BankcardLogoHelper";
            String str4 = "onGetPictureFinish done notifyKey %s  bitmap is null? %s iv is null? %s iv tag: %s mBankcardLogoUrl %s, checkTagType: %s";
            Object[] objArr = new Object[6];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bitmap == null);
            if (imageView != null) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            if (imageView == null) {
                str2 = "";
            } else {
                str2 = imageView.getTag();
            }
            objArr[3] = str2;
            objArr[4] = this.sVR;
            objArr[5] = Boolean.valueOf(this.sYF);
            x.d(str3, str4, objArr);
            if (imageView != null && str != null && str.equals(this.sVR)) {
                if (!this.sYF) {
                    imageView.post(new 2(this, imageView, bitmap));
                    imageView.setTag(f.uyA, null);
                } else if (imageView.getTag(f.uyA) != null && this.sAg != null && this.sAg.field_bankcardType != null) {
                    str2 = (String) imageView.getTag(f.uyA);
                    if (!bh.ov(str2) && str2.equals(this.sAg.field_bankcardType)) {
                        imageView.post(new 1(this, imageView, bitmap));
                        imageView.setTag(f.uyA, null);
                    }
                }
            }
        }
    }
}
