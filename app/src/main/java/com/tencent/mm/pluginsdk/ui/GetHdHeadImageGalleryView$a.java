package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.ui.base.MultiTouchImageView;

class GetHdHeadImageGalleryView$a extends BaseAdapter {
    final /* synthetic */ GetHdHeadImageGalleryView vjL;

    private GetHdHeadImageGalleryView$a(GetHdHeadImageGalleryView getHdHeadImageGalleryView) {
        this.vjL = getHdHeadImageGalleryView;
    }

    public final int getCount() {
        return 1;
    }

    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            a aVar2 = new a(this);
            view = View.inflate(this.vjL.getContext(), f.lnV, null);
            aVar2.nrd = (ProgressBar) view.findViewById(e.lnO);
            aVar2.fyg = (ImageView) view.findViewById(e.lnN);
            aVar2.vjM = view.findViewById(e.lnP);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        view.setLayoutParams(new LayoutParams(-1, -1));
        if (GetHdHeadImageGalleryView.d(this.vjL) != null) {
            aVar.nrd.setVisibility(8);
            aVar.fyg.setVisibility(8);
            aVar.vjM.setVisibility(8);
            view = new MultiTouchImageView(this.vjL.getContext(), GetHdHeadImageGalleryView.d(this.vjL).getWidth(), GetHdHeadImageGalleryView.d(this.vjL).getHeight());
            view.setLayoutParams(new LayoutParams(-1, -1));
            view.setImageBitmap(GetHdHeadImageGalleryView.d(this.vjL));
            view.aE(2.0f);
            view.yfr = true;
            return view;
        }
        aVar.nrd.setVisibility(0);
        aVar.vjM.setVisibility(0);
        if (GetHdHeadImageGalleryView.e(this.vjL) != null) {
            aVar.fyg.setVisibility(0);
            aVar.fyg.setImageBitmap(GetHdHeadImageGalleryView.e(this.vjL));
            return view;
        }
        aVar.fyg.setVisibility(8);
        return view;
    }
}
