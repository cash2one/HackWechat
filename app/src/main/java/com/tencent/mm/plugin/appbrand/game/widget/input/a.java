package com.tencent.mm.plugin.appbrand.game.widget.input;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.widget.input.l;
import com.tencent.mm.plugin.appbrand.widget.input.s;
import com.tencent.mm.plugin.appbrand.widget.input.u;

public final class a extends u {
    private static final int jau = g.itH;
    private a jav;
    private WAGamePanelInputEditText jaw;
    public OnClickListener jax;

    public final /* bridge */ /* synthetic */ EditText aeY() {
        return (WAGamePanelInputEditText) super.aeY();
    }

    protected final /* synthetic */ View aeZ() {
        View aVar = new a(getContext());
        this.jaw = (WAGamePanelInputEditText) aVar.findViewById(g.ivP);
        aVar.afa().setOnClickListener(new 1(this));
        this.jYF = this.jaw;
        this.jav = aVar;
        return aVar;
    }

    private a(Context context) {
        super(context);
        lZ(jau);
    }

    public static a bF(View view) {
        return (a) view.getRootView().findViewById(jau);
    }

    public static a bG(View view) {
        l bS = l.bS(view);
        if (bS.jXF == null || !(bS.jXF instanceof s)) {
            bS.jXF = new s();
        }
        a bF = bF(view);
        if (bF != null) {
            return bF;
        }
        View aVar = new a(view.getContext());
        bS.bT(aVar);
        return aVar;
    }

    protected final void aeV() {
        this.jav.cF(false);
    }

    protected final void aeW() {
        int i;
        int i2 = 0;
        if ((this.jaw.getInputType() & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) > 0) {
            i = 1;
        } else {
            i = 0;
        }
        View afa = this.jav.afa();
        if (i == 0) {
            i2 = 8;
        }
        afa.setVisibility(i2);
    }

    public final WAGamePanelInputEditText aeX() {
        return (WAGamePanelInputEditText) super.aeY();
    }

    public final void show() {
        this.jYF = this.jaw;
        this.jaw.requestFocus();
        super.show();
    }
}
