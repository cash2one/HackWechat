package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.sns.i$e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;

public final class g extends b {
    private LinearLayout muI;
    private ImageView riT;
    private TextView riU;
    private LinearLayout riV;
    int riW;
    h rjd;
    private View rje;
    private ImageView rjf;

    public g(Context context, h hVar, ViewGroup viewGroup) {
        super(context, hVar, viewGroup);
        this.rjd = hVar;
    }

    public final View bwW() {
        View view = this.contentView;
        this.rjf = (ImageView) view.findViewById(f.qCE);
        this.riT = (ImageView) view.findViewById(f.qzF);
        this.riU = (TextView) view.findViewById(f.caP);
        this.riV = (LinearLayout) view.findViewById(f.qCz);
        this.muI = (LinearLayout) view.findViewById(f.bYF);
        this.rje = this.riV;
        return this.contentView;
    }

    protected final void bxa() {
        this.riU.setText(this.rjd.rfZ.nQz);
        if (this.rjd.rgS) {
            this.rjf.setImageDrawable(a.b(this.context, i$e.qzj));
            this.riT.setImageDrawable(a.b(this.context, i$e.qzG));
            this.riU.setTextColor(WebView.NIGHT_MODE_COLOR);
            this.riV.setBackgroundResource(i$e.qyQ);
        } else {
            this.rjf.setImageDrawable(a.b(this.context, i$e.qzi));
            this.riT.setImageDrawable(a.b(this.context, i$e.qzF));
            this.riU.setTextColor(-1);
            this.riV.setBackgroundResource(i$e.qyR);
        }
        this.riV.setPadding((int) this.rjd.rgO, 0, (int) this.rjd.rgP, 0);
        this.muI.setPadding(0, (int) this.rjd.rgM, 0, (int) this.rjd.rgN);
        a(this.riV);
        OnClickListener 1 = new 1(this);
        if (this.rje != null) {
            this.rje.setOnClickListener(1);
        }
    }

    protected final int bjK() {
        return com.tencent.mm.plugin.sns.i.g.qGP;
    }

    public final boolean S(JSONObject jSONObject) {
        if (!super.S(jSONObject)) {
            return false;
        }
        try {
            jSONObject.put("clickCount", this.riW);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("AdLandingBorderedComp", e, "", new Object[0]);
            return false;
        }
    }
}
