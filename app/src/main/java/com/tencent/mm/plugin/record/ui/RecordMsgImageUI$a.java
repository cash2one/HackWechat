package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.util.LinkedList;
import java.util.List;

class RecordMsgImageUI$a extends BaseAdapter {
    long fqm;
    List<uq> kFz;
    f pGp;

    private RecordMsgImageUI$a() {
        this.kFz = new LinkedList();
        this.fqm = -1;
    }

    public final /* synthetic */ Object getItem(int i) {
        return vt(i);
    }

    public final int getCount() {
        return this.kFz.size();
    }

    public final uq vt(int i) {
        return (uq) this.kFz.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        f fVar = this.pGp;
        uq vt = vt(i);
        long j = this.fqm;
        Bitmap a = fVar.a(vt, j, false, false);
        if (a == null) {
            x.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", Boolean.valueOf(fVar.a(vt, j)));
            h.a(vt, j, r0);
        }
        if (a == null) {
            x.w("MicroMsg.ShowImageUI", "get image fail");
            if (view == null || (view instanceof MultiTouchImageView)) {
                view = View.inflate(viewGroup.getContext(), R.i.dsF, null);
            }
            ((ImageView) view.findViewById(R.h.cpk)).setImageResource(R.k.dyt);
            view.setLayoutParams(new LayoutParams(-1, -1));
        } else {
            Context context = viewGroup.getContext();
            if (view == null || !(view instanceof MultiTouchImageView)) {
                view = new MultiTouchImageView(context, a.getWidth(), a.getHeight());
            } else {
                MultiTouchImageView multiTouchImageView = (MultiTouchImageView) view;
                multiTouchImageView.eS(a.getWidth(), a.getHeight());
            }
            l.k(view, a.getWidth(), a.getHeight());
            view.setLayoutParams(new LayoutParams(-1, -1));
            view.setImageBitmap(a);
            view.yfr = true;
        }
        return view;
    }
}
