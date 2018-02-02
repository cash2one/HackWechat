package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;

class CardGiftImageUI$a extends BaseAdapter {
    final /* synthetic */ CardGiftImageUI kSh;

    private CardGiftImageUI$a(CardGiftImageUI cardGiftImageUI) {
        this.kSh = cardGiftImageUI;
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
        Bitmap op = j.op(CardGiftImageUI.b(this.kSh));
        if (op == null) {
            x.w("MicroMsg.CardGiftImageUI", "get image fail");
            if (view != null && !(view instanceof MultiTouchImageView)) {
                return view;
            }
            view = View.inflate(viewGroup.getContext(), R.i.dsF, null);
            ((ImageView) view.findViewById(R.h.cpk)).setImageResource(R.k.dyt);
            view.setLayoutParams(new LayoutParams(-1, -1));
            return view;
        }
        Context context = viewGroup.getContext();
        if (view == null || !(view instanceof MultiTouchImageView)) {
            view = new MultiTouchImageView(context, op.getWidth(), op.getHeight());
        } else {
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) view;
            multiTouchImageView.eS(op.getWidth(), op.getHeight());
        }
        view.setLayoutParams(new LayoutParams(-1, -1));
        view.setImageBitmap(op);
        view.yfr = true;
        return view;
    }
}
