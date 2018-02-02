package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.x;

public class GameIndexWxagView extends LinearLayout implements OnClickListener {
    LayoutInflater DF = ((LayoutInflater) getContext().getSystemService("layout_inflater"));
    ViewGroup mContainer = this;
    int ndn;

    public GameIndexWxagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        x.i("MicroMsg.GameIndexWxagView", "initView finished");
    }

    public void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            if (aVar.nro != null) {
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1079;
                ((c) g.h(c.class)).a(getContext(), aVar.nro.ksU, aVar.nro.ngo, aVar.nro.nky, 0, aVar.nro.nkx, appBrandStatObject);
                ap.a(getContext(), 10, 1025, aVar.ner, 30, aVar.nro.ngo, this.ndn, null);
            }
        }
    }
}
