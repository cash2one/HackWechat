package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.il;
import com.tencent.mm.modelmulti.m;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends b {
    private TextView iiq;
    private ImageView jCP;
    private View kpZ = null;
    boolean zbB = false;
    private c zbC;
    private boolean zbp = false;

    public o(Context context) {
        super(context);
        if (!this.zbp && this.view != null) {
            this.kpZ = this.view.findViewById(R.h.cSy);
            this.iiq = (TextView) this.view.findViewById(R.h.cSw);
            this.jCP = (ImageView) this.view.findViewById(R.h.cSx);
            this.zbp = true;
            this.zbC = new c<il>(this) {
                final /* synthetic */ o zbD;

                {
                    this.zbD = r2;
                    this.xen = il.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    if (((il) bVar).fyT.fxw) {
                        this.zbD.zbB = false;
                        this.zbD.alg();
                    } else {
                        x.i("MicroMsg.TryNewInitBanner", "summerinit onSceneEnd -1 show tryNewInitBanner[%s]", new Object[]{this.zbD});
                        this.zbD.zbB = true;
                        this.zbD.alg();
                    }
                    return false;
                }
            };
            a.xef.b(this.zbC);
        }
    }

    public final int getLayoutId() {
        return R.i.dtj;
    }

    public final boolean alg() {
        if (!this.zbB) {
            x.i("MicroMsg.TryNewInitBanner", "summerinit update but initFailed[%b] just ret update false", new Object[]{Boolean.valueOf(this.zbB)});
            this.kpZ.setVisibility(8);
            return false;
        } else if (m.PZ()) {
            boolean z;
            this.iiq.setText(R.l.dKs);
            this.jCP.setVisibility(0);
            this.kpZ.setOnClickListener(new 2(this));
            this.kpZ.setVisibility(0);
            String str = "MicroMsg.TryNewInitBanner";
            String str2 = "summerinit update set visible [%b]";
            Object[] objArr = new Object[1];
            if (this.kpZ.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            return true;
        } else {
            x.i("MicroMsg.TryNewInitBanner", "summerinit update but not need init just update false");
            this.zbB = false;
            this.kpZ.setVisibility(8);
            return false;
        }
    }

    public final void setVisibility(int i) {
        if (this.kpZ != null) {
            this.kpZ.setVisibility(i);
        }
    }

    public final void destroy() {
        a.xef.c(this.zbC);
    }
}
