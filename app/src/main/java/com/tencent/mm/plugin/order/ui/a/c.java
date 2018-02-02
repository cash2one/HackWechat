package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.Preference;

public final class c extends Preference {
    Bitmap hkT = null;
    OnClickListener mOnClickListener;
    private View mView = null;
    private TextView oXZ;
    private ImageView pcN;
    String pcO = "";

    public c(Context context) {
        super(context);
        setLayoutResource(g.uCT);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.oXZ = (TextView) view.findViewById(f.uqf);
        this.pcN = (ImageView) view.findViewById(f.uqe);
        this.oXZ.setText(this.pcO);
        this.pcN.setImageBitmap(this.hkT);
        this.pcN.setOnClickListener(this.mOnClickListener);
        if (this.pcO != null && this.pcO.length() > 48) {
            this.oXZ.setTextSize(0, (float) a.aa(this.mContext, d.bvs));
        }
    }
}
