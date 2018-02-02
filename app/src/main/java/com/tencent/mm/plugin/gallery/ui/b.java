package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class b extends BaseAdapter {
    private Context mContext;
    private int mRx;
    ArrayList<AlbumItem> mTa;
    AlbumItem mTb;
    String mTc = "";
    private int mTd = 0;

    private static class a {
        public TextView iir;
        public ImageView mRY;
        public TextView mTe;
        public ImageView mTf;
        public ImageView myj;

        private a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return qw(i);
    }

    public b(Context context, int i) {
        this.mContext = context;
        this.mTa = new ArrayList();
        this.mRx = i;
        this.mTb = new AlbumItem("", 0);
        this.mTb.mRc = new ImageMediaItem();
        this.mTd = context.getResources().getDimensionPixelSize(R.f.bvS);
    }

    public final int getCount() {
        return this.mTa.size() + 1;
    }

    public final AlbumItem qw(int i) {
        if (i == 0) {
            return this.mTb;
        }
        return (AlbumItem) this.mTa.get(i - 1);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        x.i("MicroMsg.GalleryAdapter", "duanyi test getview:" + i);
        AlbumItem qw = qw(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.i.drl, viewGroup, false);
            a aVar2 = new a();
            aVar2.mRY = (ImageView) view.findViewById(R.h.ciS);
            aVar2.iir = (TextView) view.findViewById(R.h.ciP);
            aVar2.myj = (ImageView) view.findViewById(R.h.cVe);
            aVar2.mTe = (TextView) view.findViewById(R.h.ciO);
            aVar2.mTf = (ImageView) view.findViewById(R.h.ciR);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (this.mTc.equals(qw.mRb)) {
            aVar.mTf.setVisibility(0);
        } else {
            aVar.mTf.setVisibility(4);
        }
        if (i == 0) {
            aVar.mRY.setImageResource(R.g.bEF);
            if (qw.mRc != null) {
                h.a(aVar.mRY, qw.mRc.getType(), qw.aNV(), qw.mRc.hOo, qw.aNW());
            }
            if (c.aNE().aOi() == 1) {
                aVar.iir.setText(R.l.ekV);
            } else if (c.aNE().aOi() == 3) {
                aVar.iir.setText(R.l.ekW);
            } else {
                aVar.iir.setText(R.l.ekX);
            }
            aVar.mRY.setVisibility(0);
            aVar.iir.setVisibility(0);
            aVar.mTe.setVisibility(8);
        } else {
            aVar.mRY.setVisibility(0);
            aVar.iir.setVisibility(0);
            aVar.iir.setText(qw.mRb);
            aVar.mTe.setVisibility(0);
            aVar.mTe.setText(this.mContext.getString(R.l.ele, new Object[]{Integer.valueOf(qw.ftF)}));
            if (!(aVar.myj == null || qw.mRc == null)) {
                aVar.myj.setVisibility(qw.mRc.getType() == 2 ? 0 : 8);
            }
            String aNV = qw.aNV();
            if (!bh.ov(aNV) && qw.mRc != null) {
                h.a(aVar.mRY, qw.mRc.getType(), aNV, qw.mRc.hOo, qw.aNW());
            } else if (qw.mRc == null || qw.mRc.getType() != 2) {
                x.e("MicroMsg.GalleryAdapter", "get folder failed");
                aVar.mRY.setVisibility(8);
                aVar.iir.setVisibility(8);
            } else {
                h.a(aVar.mRY, qw.mRc.getType(), null, qw.mRc.hOo, qw.aNW());
            }
        }
        return view;
    }
}
