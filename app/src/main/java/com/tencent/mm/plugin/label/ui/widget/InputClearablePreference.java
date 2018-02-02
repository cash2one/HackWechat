package com.tencent.mm.plugin.label.ui.widget;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.MMEditText;

public class InputClearablePreference extends Preference {
    private String jUJ;
    public String jey;
    public String nQh;
    public String nQi;
    public int nQj;
    private int nQk;
    public boolean nQl;
    public MMEditText nQm;
    private ImageView nQn;
    public TextView nQo;
    private int nQp;
    public a nQq;

    static /* synthetic */ void a(InputClearablePreference inputClearablePreference, boolean z) {
        if (inputClearablePreference.nQn == null) {
            return;
        }
        if (z) {
            inputClearablePreference.nQn.setVisibility(0);
        } else {
            inputClearablePreference.nQn.setVisibility(8);
        }
    }

    public InputClearablePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputClearablePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void setText(String str) {
        this.jUJ = str;
        if (this.nQm != null && !bh.ov(str)) {
            this.nQm.setText(i.c(this.mContext, this.jUJ, this.nQp));
            Dx(this.jUJ);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.nQp = a.aa(this.mContext, R.f.bvs);
        this.nQm = (MMEditText) view.findViewById(R.h.cdj);
        this.nQn = (ImageView) view.findViewById(R.h.caK);
        this.nQo = (TextView) view.findViewById(R.h.ceL);
        if (this.nQm != null) {
            if (this.nQk > 0) {
                this.nQm.setFilters(new InputFilter[]{new LengthFilter(this.nQk), new b(this)});
            } else {
                this.nQm.setFilters(new InputFilter[]{new b(this)});
            }
        }
        this.nQm.addTextChangedListener(new 1(this));
        x.d("MicroMsg.Label.InputClearablePreference", "mText %s", new Object[]{this.jUJ});
        setText(this.jUJ);
        if (!bh.ov(this.jUJ)) {
            this.nQm.setSelection(this.jUJ.length());
        }
        if (this.nQl) {
            new af().postDelayed(new 4(this), 0);
        }
        this.nQm.setHint(this.nQh);
        this.nQn.setOnClickListener(new 2(this));
        if (this.nQo != null) {
            this.nQo.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ InputClearablePreference nQr;

                {
                    this.nQr = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (this.nQr.nQm != null) {
                        this.nQr.nQm.clearFocus();
                    }
                    return false;
                }
            });
        }
    }

    private void Dx(String str) {
        boolean z = true;
        if (!bh.ov(str)) {
            int ZY = h.ZY(str);
            boolean z2 = ZY > this.nQj;
            int aY = h.aY(this.nQj, "");
            int aZ = h.aZ(this.nQj, str);
            if (this.nQo != null) {
                if (z2) {
                    this.nQo.setText(String.format(this.jey, new Object[]{Integer.valueOf(aY), Integer.valueOf(aZ)}));
                    this.nQo.setVisibility(0);
                } else {
                    this.nQo.setVisibility(8);
                }
            }
            if (this.nQq != null) {
                a aVar = this.nQq;
                if (ZY > this.nQj) {
                    z = false;
                }
                aVar.gi(z);
            }
        }
    }

    public final void gk(boolean z) {
        if (this.nQo == null) {
            return;
        }
        if (z) {
            this.nQo.setText(this.nQi);
            this.nQo.setVisibility(0);
            return;
        }
        this.nQo.setVisibility(8);
    }
}
