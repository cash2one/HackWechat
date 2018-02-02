package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public abstract class k extends a {
    int riW = 0;

    public k(Context context, s sVar, ViewGroup viewGroup) {
        super(context, sVar, viewGroup);
    }

    protected final void bxk() {
        this.riW++;
    }

    public final boolean S(JSONObject jSONObject) {
        if (!super.S(jSONObject)) {
            return false;
        }
        try {
            jSONObject.put("clickCount", this.riW);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Sns.AdLandingPageBtnBaseComp", e, "", new Object[0]);
            return false;
        }
    }
}
