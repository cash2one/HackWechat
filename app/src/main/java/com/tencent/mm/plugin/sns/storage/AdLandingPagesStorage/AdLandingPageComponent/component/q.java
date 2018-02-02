package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import org.json.JSONArray;
import org.json.JSONObject;

public final class q extends a {
    private h rja;
    LinearLayout rkt;

    public q(Context context, r rVar, ViewGroup viewGroup) {
        super(context, rVar, viewGroup);
    }

    public final void bwH() {
        super.bwH();
        for (i bwH : this.rja.bxH()) {
            bwH.bwH();
        }
    }

    public final void X(int i, int i2, int i3) {
        super.X(i, i2, i3);
        for (i X : this.rja.bxH()) {
            X.X(i, i2, i3);
        }
    }

    public final void bwI() {
        super.bwI();
        for (i bwI : this.rja.bxH()) {
            bwI.bwI();
        }
    }

    public final void bwG() {
        super.bwG();
        for (i bwG : this.rja.bxH()) {
            bwG.bwG();
        }
    }

    protected final void bxa() {
        if (((r) this.rji).rgJ == 0) {
            this.rkt.setOrientation(1);
        } else if (((r) this.rji).rgJ == 1) {
            this.rkt.setOrientation(0);
        }
        if (this.rja == null) {
            this.rja = new h(((r) this.rji).rgI, this.context, ((r) this.rji).bgColor, this.rkt);
            this.rja.layout();
            return;
        }
        this.rja.bP(((r) this.rji).rgI);
    }

    public final View bwW() {
        View view = this.contentView;
        this.rkt = (LinearLayout) view.findViewById(f.qDJ);
        return view;
    }

    protected final int bjK() {
        return g.qGQ;
    }

    public final boolean s(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        if (super.S(jSONObject)) {
            jSONArray.put(jSONObject);
        }
        for (i iVar : this.rja.bxH()) {
            JSONObject jSONObject2 = new JSONObject();
            if (iVar != null && iVar.S(jSONObject2)) {
                jSONArray.put(jSONObject2);
            }
        }
        return true;
    }
}
