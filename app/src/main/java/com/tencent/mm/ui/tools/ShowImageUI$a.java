package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.c;
import com.tencent.mm.plugin.gif.e;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;

class ShowImageUI$a extends BaseAdapter {
    String imagePath;
    final /* synthetic */ ShowImageUI zmY;

    private ShowImageUI$a(ShowImageUI showImageUI) {
        this.zmY = showImageUI;
    }

    public final int getCount() {
        return 1;
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (p.UR(this.imagePath)) {
            Context context = viewGroup.getContext();
            String str = this.imagePath;
            e eVar = new e(str);
            if (view == null || !(view instanceof MMAnimateView)) {
                view = new MMAnimateView(context);
            } else {
                MMAnimateView mMAnimateView = (MMAnimateView) view;
            }
            view.cQ(str, str);
            view.a(str, new 1(this, view));
            if (view.getDrawable() != null && (view.getDrawable() instanceof c)) {
                ((c) view.getDrawable()).stop();
            }
            if (view.getDrawable() != null && (view.getDrawable() instanceof c)) {
                ((c) view.getDrawable()).start();
            }
        } else {
            Bitmap op = j.op(this.imagePath);
            if (op == null) {
                x.w("MicroMsg.ShowImageUI", "get image fail");
                if (view == null || (view instanceof MultiTouchImageView)) {
                    view = View.inflate(viewGroup.getContext(), R.i.dsF, null);
                }
                ((ImageView) view.findViewById(R.h.cpk)).setImageResource(R.k.dyt);
                view.setLayoutParams(new LayoutParams(-1, -1));
            } else {
                Context context2 = viewGroup.getContext();
                if (view == null || !(view instanceof MultiTouchImageView)) {
                    view = new MultiTouchImageView(context2, op.getWidth(), op.getHeight());
                } else {
                    MultiTouchImageView multiTouchImageView = (MultiTouchImageView) view;
                    multiTouchImageView.eS(op.getWidth(), op.getHeight());
                }
                view.setLayoutParams(new LayoutParams(-1, -1));
                view.setImageBitmap(op);
                view.yfr = true;
            }
        }
        return view;
    }
}
