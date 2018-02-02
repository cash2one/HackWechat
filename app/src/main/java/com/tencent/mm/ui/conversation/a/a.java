package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class a extends b {
    int abP = 0;
    private View kpZ = null;
    b zan;
    private d zao;
    a zap;

    public interface a {
        void OH(String str);

        void fO(String str, String str2);
    }

    public a(Context context) {
        super(context);
        if (this.view != null) {
            this.kpZ = this.view.findViewById(R.h.bJz);
            this.zao = new d();
            this.zao.zat = this.kpZ;
            this.zao.zau = (Button) this.view.findViewById(R.h.bIY);
            this.zao.zau.setOnClickListener(new 1(this));
            this.kpZ.setOnClickListener(new 2(this));
        }
    }

    public final int getLayoutId() {
        return R.i.dad;
    }

    public final void destroy() {
        if (g.Dh().Cy()) {
            ar.Hg();
            c.CU().b(this.zan);
        }
    }

    public final void setVisibility(int i) {
        if (this.kpZ != null) {
            this.kpZ.setVisibility(i);
        }
    }

    public final void release() {
        this.zan = null;
    }

    public final boolean alg() {
        this.zan = new b((Context) this.voC.get());
        this.zap = new 3(this);
        com.tencent.mm.pluginsdk.j.a.a em = com.tencent.mm.pluginsdk.j.a.a.em(ac.getContext());
        if (this.zan != null) {
            if (em != null) {
                this.zan.zar = em;
                this.zan.Xy();
                int i = (this.zan == null || this.zan.getCount() <= 0 || this.zan.Gu(0).a(this.zao) != 0) ? 0 : 1;
                if (i != 0) {
                    x.i("MicroMsg.ADBanner", "refreshAndReturnIsVisible[true]");
                    setVisibility(0);
                    return true;
                }
            }
            setVisibility(8);
        }
        setVisibility(8);
        return false;
    }
}
