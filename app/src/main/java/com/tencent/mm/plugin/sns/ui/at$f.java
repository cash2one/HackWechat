package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

abstract class at$f {
    OnClickListener rFL = new 4(this);
    OnClickListener rFM = new 5(this);
    OnClickListener rFN = new OnClickListener(this) {
        final /* synthetic */ at$f rFP;

        {
            this.rFP = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() != null) {
                x.d("MicroMsg.SnsphotoAdapter", "snssight click");
                this.rFP.rFO = (a) view.getTag();
                this.rFP.dG(this.rFP.rFO.qQY, this.rFP.rFO.position + 2);
            }
        }
    };
    public a rFO = new a();
    OnClickListener rqx = new 1(this);
    OnClickListener rqy = new 2(this);
    OnClickListener rqz = new 3(this);

    public abstract void dF(int i, int i2);

    public abstract void dG(int i, int i2);

    public abstract void xJ(int i);
}
