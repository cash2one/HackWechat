package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class CardTextPreference extends Preference {
    private TextView Zv;
    private TextView kXS;
    public int kXT = 0;
    boolean kXU = true;
    Context mContext;

    public CardTextPreference(Context context) {
        super(context, null);
        this.mContext = context;
    }

    public CardTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    public CardTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutResource(R.i.dnt);
        this.mContext = context;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.kXS = (TextView) view.findViewById(16908304);
        this.Zv = (TextView) view.findViewById(16908310);
        axj();
        ee(this.kXU);
    }

    public final void axj() {
        if (this.kXS != null && this.kXT != 0) {
            this.kXS.setTextColor(this.kXT);
        }
    }

    public final void axk() {
        ee(false);
        this.kXU = false;
    }

    private void ee(boolean z) {
        if (this.Zv != null) {
            View view = this.Zv;
            Rect rect = new Rect();
            rect.left = view.getPaddingLeft();
            rect.right = view.getPaddingRight();
            rect.top = view.getPaddingTop();
            rect.bottom = view.getPaddingBottom();
            this.Zv.setSingleLine(z);
            if (!z) {
                rect.top = this.mContext.getResources().getDimensionPixelOffset(R.f.bvv);
                rect.bottom = this.mContext.getResources().getDimensionPixelOffset(R.f.bvv);
                view = this.Zv;
                if (view != null) {
                    view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                }
            }
        }
    }
}
