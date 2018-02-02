package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.bf;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.ArrayList;

public class ProfileLabelView extends ProfileItemView {
    public TextView piu;
    public TextView vkQ;

    public ProfileLabelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProfileLabelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int bjK() {
        return R.i.dpG;
    }

    public final void init() {
        this.piu = (TextView) findViewById(R.h.bXz);
        this.vkQ = (TextView) findViewById(R.h.bXA);
        setClickable(true);
    }

    public final boolean bjL() {
        if (this.vkQ != null) {
            LayoutParams layoutParams = this.vkQ.getLayoutParams();
            layoutParams.width = a.aa(getContext(), R.f.bvb);
            this.vkQ.setLayoutParams(layoutParams);
        }
        String str;
        ArrayList arrayList;
        if (!com.tencent.mm.l.a.fZ(this.lFr.field_type)) {
            bf EZ;
            String str2 = this.lFr.field_encryptUsername;
            if (bh.ov(str2)) {
                ar.Hg();
                EZ = c.EZ().EZ(this.lFr.field_username);
            } else {
                ar.Hg();
                EZ = c.EZ().EZ(str2);
            }
            if (EZ != null) {
                str = EZ.field_contactLabels;
                arrayList = (ArrayList) com.tencent.mm.plugin.label.a.a.aUX().Dp(str);
                if (!(bh.ov(str) || arrayList == null || arrayList.size() <= 0)) {
                    this.piu.setText(i.a(getContext(), bh.d(arrayList, getContext().getResources().getString(R.l.dTT))));
                    return true;
                }
            }
            setVisibility(8);
            return false;
        } else if (q.gr(this.lFr.field_username)) {
            setVisibility(8);
            return false;
        } else {
            str = this.lFr.field_contactLabelIds;
            arrayList = (ArrayList) com.tencent.mm.plugin.label.a.a.aUX().Dq(str);
            if (bh.ov(str) || arrayList == null || arrayList.size() <= 0) {
                setVisibility(8);
                return false;
            }
            this.piu.setText(i.a(getContext(), bh.d(arrayList, getContext().getResources().getString(R.l.dTT))));
            return true;
        }
    }
}
