package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.order.a.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.preference.Preference;

public final class d extends Preference {
    String lRA;
    String mName;
    OnClickListener mOnClickListener;
    private View mView = null;

    public d(Context context) {
        super(context);
        setLayoutResource(g.uCU);
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
        ImageView imageView = (ImageView) view.findViewById(f.uqh);
        TextView textView = (TextView) view.findViewById(f.uqi);
        imageView.setImageBitmap(null);
        if (!bh.ov(this.lRA)) {
            a aVar = new a();
            b.bit();
            aVar.hDD = b.aWR();
            aVar.hDA = true;
            aVar.hDX = true;
            aVar.hDY = true;
            o.PA().a(this.lRA, imageView, aVar.PK());
        }
        textView.setText(this.mName);
        view.findViewById(f.uqg).setOnClickListener(this.mOnClickListener);
    }
}
