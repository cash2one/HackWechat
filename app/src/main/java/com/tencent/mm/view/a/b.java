package com.tencent.mm.view.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.tencent.mm.bx.e;
import com.tencent.mm.plugin.m.a$h;
import com.tencent.mm.plugin.m.a.d;
import com.tencent.mm.plugin.m.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;
import com.tencent.mm.view.f.a;

public final class b extends a {
    public b(Context context, a aVar) {
        super(context, aVar);
    }

    public final int getCount() {
        return this.zEl;
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = v.fv(this.mContext).inflate(f.lJB, null);
            a aVar2 = this.zDu;
            if (aVar2.zGB == 0) {
                aVar2.zGB = aVar2.cAT() / aVar2.aat("TAG_DEFAULT_TAB");
            }
            view.setLayoutParams(new LayoutParams(aVar2.zGB, this.zDu.zGy));
            aVar = new a(this, view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == getCount() - 1) {
            aVar.jCP.setImageResource(d.bBE);
            aVar.jCP.setContentDescription(this.mContext.getString(a$h.dYq));
        } else {
            int i2 = ((this.zEl - 1) * this.zEm) + i;
            if (i2 > this.kFr - 1) {
                aVar.jCP.setImageDrawable(null);
                aVar.jCP.setContentDescription("");
                x.i("MicroMsg.emoji.DefaultSmileyAdapter", "real position is bigger real count.");
            } else {
                Drawable mf = e.chc().mf(i2);
                aVar.jCP.setImageDrawable(mf);
                CharSequence text = e.chc().getText(i2);
                if (bh.ov(text)) {
                    text = view.getResources().getString(a$h.eaY);
                }
                aVar.jCP.setContentDescription(text);
                if (mf == null) {
                    x.i("MicroMsg.emoji.DefaultSmileyAdapter", "drawable is null. realPosition:%d description:%s", new Object[]{Integer.valueOf(i2), text});
                }
            }
        }
        return view;
    }
}
