package com.tencent.mm.plugin.voip.ui;

import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

protected class d$c {
    ak ikI = new ak(new a(this) {
        final /* synthetic */ d$c sqr;

        {
            this.sqr = r1;
        }

        public final boolean uF() {
            int i = this.sqr.sqo[this.sqr.sqq % this.sqr.sqo.length];
            if (this.sqr.kO != null) {
                if (-1 == i) {
                    this.sqr.kO.setText(null);
                } else {
                    this.sqr.kO.setText(i);
                }
            }
            d$c com_tencent_mm_plugin_voip_ui_d_c = this.sqr;
            com_tencent_mm_plugin_voip_ui_d_c.sqq++;
            return true;
        }
    }, true);
    TextView kO;
    int[] sqo;
    private int sqp;
    int sqq;

    protected d$c() {
    }

    public final void a(TextView textView, int[] iArr) {
        if (iArr == null || textView == null) {
            x.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
            return;
        }
        bIg();
        this.sqq = 0;
        this.sqo = iArr;
        this.kO = textView;
        this.sqp = 500;
        if (this.ikI != null) {
            long j = (long) this.sqp;
            this.ikI.J(j, j);
        }
        x.j("MicroMsg.DynamicTextWrap", "start textview:" + textView, new Object[0]);
    }

    public final void bIg() {
        if (this.ikI != null) {
            this.ikI.TG();
        }
        x.j("MicroMsg.DynamicTextWrap", "stop textview: " + this.kO, new Object[0]);
        this.kO = null;
    }
}
