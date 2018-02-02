package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class c extends b {
    private int rQk;
    private boolean rQl;
    private boolean rQm;
    a rQn;
    private HashMap<String, Bitmap> rvV = new HashMap();
    boolean rvY;

    public c(Context context, List<?> list, int i, boolean z, a aVar) {
        super(context, 4);
        super.bZ(ca(list));
        this.rQk = 9;
        this.rQl = z;
        this.rQn = aVar;
        bCo();
        bCp();
    }

    private List<d> ca(List<?> list) {
        List<d> arrayList = new ArrayList(list.size());
        int i = 0;
        for (Object next : list) {
            d dVar = new d(this, (byte) 0);
            dVar.data = next;
            int i2 = i + 1;
            dVar.id = i;
            arrayList.add(dVar);
            i = i2;
        }
        return arrayList;
    }

    private void bCo() {
        for (int i = 0; i < this.rQj; i++) {
            d dVar = new d(this, (byte) 0);
            dVar.data = "";
            dVar.id = getCount();
            dVar.id = getCount();
            add(i, dVar);
        }
    }

    public final void bCp() {
        x.v("DynamicGridAdapter", "showAddImg %s, getCount %d, getHeaderCount %d, maxShowCount %d， showing %s", new Object[]{Boolean.valueOf(this.rQl), Integer.valueOf(getCount()), Integer.valueOf(this.rQj), Integer.valueOf(this.rQk), Boolean.valueOf(this.rQm)});
        if (!this.rQl || bCq() >= this.rQk) {
            this.rQm = false;
        } else if (!this.rQm) {
            this.rQm = true;
            add("");
        }
    }

    public final void clear() {
        super.clear();
        this.rQm = false;
    }

    public final void bZ(List<?> list) {
        super.bZ(ca(list));
        bCo();
        bCp();
    }

    public final int bCq() {
        return (getCount() - this.rQj) - (this.rQm ? 1 : 0);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(i$g.qHK, viewGroup, false);
            b bVar2 = new b(this, view, (byte) 0);
            view.setTag(f.qCx, bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag(f.qCx);
        }
        Object obj = getItem(i).toString();
        ImageView imageView = bVar.fvf;
        if (TextUtils.isEmpty(obj)) {
            imageView.setBackgroundColor(0);
            imageView.setBackgroundDrawable(null);
            imageView.setImageDrawable(null);
            imageView.setBackgroundResource(e.qzI);
            imageView.setContentDescription(bVar.fvf.getContext().getString(j.qKf));
            if (i > 0) {
                bVar.view.setTag(Integer.valueOf(-1));
            } else if (i < bVar.rQo.rQj) {
                bVar.view.setTag(Integer.valueOf(Integer.MAX_VALUE));
            }
        } else {
            bVar.view.setTag(Integer.valueOf(i - bVar.rQo.rQj));
            imageView.setBackgroundDrawable(null);
            imageView.setTag(obj);
            imageView.setContentDescription(bVar.fvf.getContext().getString(j.qLc));
            Bitmap bitmap = (Bitmap) bVar.rQo.rvV.get(obj);
            if (i.m(bitmap)) {
                imageView.setImageBitmap(bitmap);
            } else {
                new c(bVar.rQo, imageView, obj).m(new String[]{""});
            }
        }
        if (i < this.rQj) {
            bVar.fvf.setVisibility(4);
        } else {
            bVar.fvf.setVisibility(0);
            view.setVisibility(0);
        }
        return view;
    }

    public final int getItemViewType(int i) {
        if (TextUtils.isEmpty(getItem(i).toString())) {
            return 1;
        }
        return 0;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    public final boolean xR(int i) {
        if (i < this.rQj) {
            return false;
        }
        if (!this.rQm) {
            return super.xR(i);
        }
        if (i != getCount() - 1) {
            return true;
        }
        return false;
    }

    public final boolean xS(int i) {
        if (i < this.rQj) {
            return false;
        }
        if (!this.rQm) {
            return super.xS(i);
        }
        if (i != getCount() - 1) {
            return true;
        }
        return false;
    }

    public final void dH(int i, int i2) {
        super.dH(i, i2);
        if (this.rQn != null) {
            this.rQn.dD(i - this.rQj, i2 - this.rQj);
        }
    }
}
