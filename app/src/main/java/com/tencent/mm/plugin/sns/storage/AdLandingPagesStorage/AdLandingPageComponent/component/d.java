package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.pluginsdk.ui.d.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;

public final class d extends b {
    LinearLayout muI;
    private ImageView riS;
    private ImageView riT;
    private TextView riU;
    LinearLayout riV;
    int riW;

    public d(Context context, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d dVar, ViewGroup viewGroup) {
        super(context, dVar, viewGroup);
    }

    protected final int bjK() {
        return g.qGP;
    }

    protected final void bxa() {
        this.riU.setText((CharSequence) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.rji).rfX.get(0));
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.rji).rgS) {
            this.riS.setImageDrawable(a.b(this.context, e.qzW));
            this.riT.setImageDrawable(a.b(this.context, e.qzG));
            this.riU.setTextColor(WebView.NIGHT_MODE_COLOR);
            this.riV.setBackgroundResource(e.qyQ);
        } else {
            this.riS.setImageDrawable(a.b(this.context, e.qzV));
            this.riT.setImageDrawable(a.b(this.context, e.qzF));
            this.riU.setTextColor(-1);
            this.riV.setBackgroundResource(e.qyR);
        }
        this.riV.setPadding((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.rji).rgO, 0, (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.rji).rgP, 0);
        this.muI.setPadding(0, (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.rji).rgM, 0, (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.rji).rgN);
        a(this.riV);
        this.riV.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ d riX;

            {
                this.riX = r1;
            }

            public final void onClick(View view) {
                d dVar = this.riX;
                dVar.riW++;
                if (c.a.vup != null) {
                    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.riX.rji).rfX.size() > 1) {
                        c.a.vup.a(this.riX.context, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.riX.rji).rfX, new 1(this));
                    } else if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.riX.rji).rfX.size() > 0) {
                        AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity) this.riX.context, (String) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.riX.rji).rfX.get(0));
                    }
                }
            }
        });
    }

    public final View bwW() {
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.rji).rfX.isEmpty()) {
            return null;
        }
        View view = this.contentView;
        this.riS = (ImageView) view.findViewById(f.qCE);
        this.riT = (ImageView) view.findViewById(f.qzF);
        this.riU = (TextView) view.findViewById(f.caP);
        this.muI = (LinearLayout) view.findViewById(f.bYF);
        this.riV = (LinearLayout) view.findViewById(f.qCz);
        return this.contentView;
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
