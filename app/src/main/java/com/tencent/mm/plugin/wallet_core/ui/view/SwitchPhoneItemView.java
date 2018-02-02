package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class SwitchPhoneItemView extends RelativeLayout {
    private TextView sXv;
    private TextView sXw;
    ImageView sXx;
    private int sXy;

    public SwitchPhoneItemView(Context context) {
        this(context, 0);
    }

    public SwitchPhoneItemView(Context context, int i) {
        super(context);
        this.sXy = 0;
        this.sXy = i;
        cd(context);
    }

    public SwitchPhoneItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sXy = 0;
        cd(context);
    }

    public SwitchPhoneItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sXy = 0;
        cd(context);
    }

    private void cd(Context context) {
        View inflate;
        if (this.sXy > 0) {
            inflate = inflate(context, this.sXy, this);
        } else {
            inflate = inflate(context, a$g.uFU, this);
        }
        this.sXv = (TextView) inflate.findViewById(f.uty);
        this.sXw = (TextView) inflate.findViewById(f.utv);
        this.sXx = (ImageView) inflate.findViewById(f.utu);
    }

    public final void a(CharSequence charSequence, CharSequence charSequence2) {
        if (bh.M(charSequence)) {
            this.sXv.setVisibility(8);
        } else {
            if (charSequence.toString().startsWith("86")) {
                x.i("SwitchPhoneItemView", "cut 86 prefix");
                charSequence = charSequence.subSequence(2, charSequence.length());
            }
            this.sXv.setText(charSequence);
        }
        if (bh.M(charSequence2)) {
            this.sXw.setVisibility(8);
            return;
        }
        this.sXw.setMaxLines(2);
        this.sXw.setSelected(true);
        this.sXw.setEllipsize(TruncateAt.MIDDLE);
        this.sXw.setText(charSequence2);
        this.sXw.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
