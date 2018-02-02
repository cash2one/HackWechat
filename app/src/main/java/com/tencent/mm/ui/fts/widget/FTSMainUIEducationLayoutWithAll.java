package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bc.b;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONArray;
import org.json.JSONObject;

public class FTSMainUIEducationLayoutWithAll extends FTSMainUIEducationLayout {
    public FTSMainUIEducationLayoutWithAll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FTSMainUIEducationLayoutWithAll(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void cxh() {
        dr(getContext().getResources().getString(R.l.eIV), b.a(null, getContext().getString(R.l.eIV), getContext()));
    }

    private void dr(String str, int i) {
        LinearLayout linearLayout = (LinearLayout) inflate(getContext(), R.i.djd, null);
        linearLayout.findViewById(R.h.cQJ).setOnClickListener(this.qdi);
        ((TextView) linearLayout.findViewById(R.h.cQJ)).setText(str);
        this.zee.add(linearLayout);
        this.zef.put(Integer.valueOf(i), (TextView) linearLayout.findViewById(R.h.cQJ));
        addView(linearLayout);
    }

    protected final boolean ai(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray == null) {
            return false;
        }
        int aa;
        if (w.eL(ac.getContext()).equalsIgnoreCase("en")) {
            aa = a.aa(getContext(), R.f.but);
        } else {
            aa = a.aa(getContext(), R.f.bvK);
        }
        int i = 0;
        Object obj = null;
        JSONObject jSONObject2 = null;
        String str = null;
        String str2 = null;
        while (i < optJSONArray.length()) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (i % 3 == 0) {
                str2 = optJSONObject.optString("hotword");
            } else if (i % 3 == 1) {
                str = optJSONObject.optString("hotword");
                JSONObject jSONObject3 = optJSONObject;
                optJSONObject = jSONObject2;
            } else {
                a(str2, jSONObject2, str, obj, optJSONObject.optString("hotword"), optJSONObject, aa);
                obj = null;
                optJSONObject = null;
                str = null;
                str2 = null;
            }
            i++;
            jSONObject2 = optJSONObject;
        }
        if (!(str2 == null || jSONObject2 == null)) {
            a(str2, jSONObject2, str, obj, null, null, aa);
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("all");
        if (optJSONArray2 == null || optJSONArray2.length() == 0) {
            cxh();
        } else {
            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(0);
            dr(optJSONObject2.optString("hotword"), optJSONObject2.optInt("businessType"));
        }
        return true;
    }
}
