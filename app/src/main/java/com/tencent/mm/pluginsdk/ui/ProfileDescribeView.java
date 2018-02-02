package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class ProfileDescribeView extends ProfileItemView {
    public TextView vkG;
    public TextView vkH;

    public ProfileDescribeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProfileDescribeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int bjK() {
        return R.i.dpD;
    }

    public final void init() {
        this.vkG = (TextView) findViewById(R.h.bXs);
        this.vkH = (TextView) findViewById(R.h.bXt);
        setClickable(true);
    }

    public final boolean bjL() {
        if (this.vkH != null) {
            LayoutParams layoutParams = this.vkH.getLayoutParams();
            layoutParams.width = a.aa(getContext(), R.f.bvb);
            this.vkH.setLayoutParams(layoutParams);
        }
        if (this.lFr == null) {
            setVisibility(8);
            return false;
        }
        String str = this.lFr.fWy;
        if (bh.ov(this.lFr.fWz)) {
            boolean z = false;
        } else {
            int i = 1;
        }
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
            if (EZ == null || bh.ov(EZ.field_conDescription)) {
                setVisibility(8);
                return false;
            }
            this.vkG.setText(i.b(getContext(), bh.ou(EZ.field_conDescription), this.vkG.getTextSize()));
            return true;
        } else if (!bh.ov(str) && r0 != 0) {
            r0 = getContext().getResources().getDrawable(R.k.dxm);
            r0.setBounds(0, 0, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
            e eVar = new e(r0, 1);
            eVar.zsZ = (int) ((((float) r0.getIntrinsicHeight()) - this.vkG.getTextSize()) / 2.0f);
            r0 = new SpannableString("  " + str);
            r0.setSpan(eVar, 0, 1, 33);
            this.vkG.setText(i.b(getContext(), r0, this.vkG.getTextSize()));
            return true;
        } else if (!bh.ov(str) && r0 == 0) {
            this.vkG.setText(i.b(getContext(), bh.ou(str), this.vkG.getTextSize()));
            return true;
        } else if (bh.ov(str) && r0 != 0) {
            r0 = getContext().getResources().getDrawable(R.k.dxm);
            r0.setBounds(0, 0, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
            e eVar2 = new e(r0, 1);
            eVar2.zsZ = (int) ((((float) r0.getIntrinsicHeight()) - this.vkG.getTextSize()) / 2.0f);
            r0 = new SpannableString("  " + getContext().getString(R.l.dWh));
            r0.setSpan(eVar2, 0, 1, 33);
            this.vkG.setText(i.b(getContext(), r0, this.vkG.getTextSize()));
            return true;
        } else if (bh.ov(str) && r0 == 0) {
            setVisibility(8);
            return false;
        } else {
            setVisibility(8);
            return false;
        }
    }
}
