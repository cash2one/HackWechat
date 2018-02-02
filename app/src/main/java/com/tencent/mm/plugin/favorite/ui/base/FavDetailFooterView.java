package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.g;

public class FavDetailFooterView extends TextView {
    public FavDetailFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FavDetailFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void F(f fVar) {
        if (fVar != null) {
            if (fVar.field_edittime > 0) {
                setText(getContext().getString(R.l.eeX) + g.e(getContext(), fVar.field_edittime * 1000));
            } else {
                setText(getContext().getString(R.l.egN) + g.e(getContext(), fVar.field_updateTime));
            }
        }
    }
}
