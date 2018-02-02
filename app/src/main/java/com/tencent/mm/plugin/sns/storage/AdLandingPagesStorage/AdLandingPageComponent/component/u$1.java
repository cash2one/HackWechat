package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.util.TypedValue;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d$a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class u$1 implements d$a {
    final /* synthetic */ u rkJ;

    u$1(u uVar) {
        this.rkJ = uVar;
    }

    public final void bxc() {
    }

    public final void bxd() {
    }

    public final void KY(String str) {
        try {
            this.rkJ.rkI.setImageBitmap(BitmapFactory.decodeFile(str));
            TextView textView = this.rkJ.imw;
            Paint paint = new Paint();
            String charSequence = textView.getText().toString();
            paint.setTextSize(textView.getTextSize());
            float measureText = (this.rkJ.rji.rgQ - paint.measureText(charSequence, 0, charSequence.length())) - TypedValue.applyDimension(1, 3.0f, this.rkJ.context.getResources().getDisplayMetrics());
            int i = (int) (measureText - (u.a(this.rkJ).value * measureText));
            LayoutParams layoutParams = (LayoutParams) this.rkJ.rkI.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, i, layoutParams.leftMargin);
            this.rkJ.rkI.setLayoutParams(layoutParams);
        } catch (Throwable e) {
            x.e("MicroMsg.Sns.AdLandingPageProcessBarComponent", "%s" + bh.i(e));
        }
    }
}
