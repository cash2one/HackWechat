package com.tencent.mm.plugin.sns.ui;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.bh;

class bf$1 implements a {
    final /* synthetic */ SpannableString rMo;
    final /* synthetic */ int rMp;
    final /* synthetic */ bf rMq;

    bf$1(bf bfVar, SpannableString spannableString, int i) {
        this.rMq = bfVar;
        this.rMo = spannableString;
        this.rMp = i;
    }

    public final void bxc() {
    }

    public final void bxd() {
    }

    public final void KY(String str) {
        if (!bh.ov(str)) {
            Drawable createFromPath = Drawable.createFromPath(str);
            if (createFromPath != null) {
                createFromPath.setBounds(0, 0, (int) (((double) this.rMq.rMj.getTextSize()) * 1.3d), (int) (((double) this.rMq.rMj.getTextSize()) * 1.3d));
                this.rMo.setSpan(new ImageSpan(createFromPath, 0), this.rMp, this.rMp + 3, 33);
                this.rMq.rMj.setText(this.rMo);
            }
        }
    }
}
