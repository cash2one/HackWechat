package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e extends a {
    private List<i> ayR = new ArrayList();
    private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e riZ;
    private h rja;

    public e(Context context, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e eVar, ViewGroup viewGroup) {
        super(context, eVar, viewGroup);
        this.riZ = eVar;
    }

    protected final void bxa() {
        if (this.rja == null) {
            this.rja = new h(this.riZ.ayR, this.context, 0, (FrameLayout) this.contentView);
            this.rja.layout();
            return;
        }
        this.rja.bP(this.riZ.ayR);
    }

    protected final View bxb() {
        return new FrameLayout(this.context);
    }

    public final void bwH() {
        super.bwH();
        for (i bwH : this.ayR) {
            bwH.bwH();
        }
    }

    public final void bwI() {
        super.bwI();
        for (i bwI : this.ayR) {
            bwI.bwI();
        }
    }

    public final void X(int i, int i2, int i3) {
        super.X(i, i2, i3);
        for (i X : this.ayR) {
            X.X(i, i2, i3);
        }
    }

    public final void bwG() {
        super.bwG();
        for (i bwG : this.ayR) {
            bwG.bwG();
        }
    }

    public final boolean s(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        if (super.S(jSONObject)) {
            jSONArray.put(jSONObject);
        }
        for (i iVar : this.ayR) {
            JSONObject jSONObject2 = new JSONObject();
            if (iVar != null && iVar.S(jSONObject2)) {
                jSONArray.put(jSONObject2);
            }
        }
        return true;
    }

    public final void a(s sVar) {
        if (sVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e) {
            this.riZ = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e) sVar;
        }
        super.a(sVar);
    }
}
