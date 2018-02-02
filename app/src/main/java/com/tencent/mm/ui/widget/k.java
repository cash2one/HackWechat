package com.tencent.mm.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;

public class k implements DragSortListView$h {
    private ListView Fv;
    private ImageView lIo;
    private Bitmap zwl;
    int zwm = WebView.NIGHT_MODE_COLOR;

    public k(ListView listView) {
        this.Fv = listView;
    }

    public final View GV(int i) {
        View childAt = this.Fv.getChildAt((this.Fv.getHeaderViewsCount() + i) - this.Fv.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.zwl = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.lIo == null) {
            this.lIo = new ImageView(this.Fv.getContext());
        }
        this.lIo.setBackgroundColor(this.zwm);
        this.lIo.setPadding(0, 0, 0, 0);
        this.lIo.setImageBitmap(this.zwl);
        this.lIo.setLayoutParams(new LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.lIo;
    }

    public void g(Point point) {
    }

    public final void dN(View view) {
        ((ImageView) view).setImageDrawable(null);
        x.i("MicroMsg.SimpleFloatViewManager", "bitmap recycle %s", new Object[]{this.zwl.toString()});
        this.zwl.recycle();
        this.zwl = null;
    }
}
