package com.tencent.mm.plugin.masssend.ui;

import android.graphics.Bitmap;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class MassSendMsgUI$8 implements TextWatcher {
    final /* synthetic */ MassSendMsgUI onR;

    MassSendMsgUI$8(MassSendMsgUI massSendMsgUI) {
        this.onR = massSendMsgUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String valueOf = String.valueOf(charSequence);
        String substring = valueOf.substring(i, i + i3);
        if ((MassSendMsgUI.a(this.onR) == null || !MassSendMsgUI.a(this.onR).isShowing()) && p.UP(substring)) {
            Bitmap d = d.d(substring, 300, 300, false);
            if (d == null) {
                x.e("MicroMsg.MassSendMsgUI", "showAlert fail, bmp is null");
                return;
            }
            View imageView = new ImageView(this.onR);
            imageView.setImageBitmap(d);
            int dimensionPixelSize = this.onR.getResources().getDimensionPixelSize(R.f.bvv);
            imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            MassSendMsgUI.a(this.onR, h.a(this.onR, this.onR.getString(R.l.dSW), imageView, this.onR.getString(R.l.dFU), this.onR.getString(R.l.dEn), new 1(this, substring), null));
            String str = valueOf.substring(0, i) + valueOf.substring(i + i3);
            MassSendMsgUI.b(this.onR).p(str, -1, false);
            MassSendMsgUI.Em(str);
        }
    }

    public final void afterTextChanged(Editable editable) {
    }
}
