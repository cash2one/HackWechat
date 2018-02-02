package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView$a;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.a.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem$MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class f extends RecyclerView$a<a> implements OnClickListener {
    private Context mContext;
    private ArrayList<String> mTQ;
    private boolean mTi;
    private int mUB;
    private int mUC;
    private Drawable mUD;
    a mUE = new a(new 1(this));
    c mUu;
    private int mUv;
    ArrayList<String> mUw = new ArrayList();
    b mUx;
    private int mUy = -1;
    private int mUz = -1;

    public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.i.dps, viewGroup, false));
    }

    public final /* synthetic */ void a(t tVar, int i, List list) {
        a aVar = (a) tVar;
        if (list.isEmpty()) {
            a(aVar, i);
            return;
        }
        GalleryItem$MediaItem a = a(i, aVar);
        if (a != null) {
            c(aVar.mRX, a.hOo, i);
        }
    }

    public final void cE(int i, int i2) {
        this.mUC = i;
        this.mUB = i2;
    }

    public f(Context context, ArrayList<String> arrayList, int i, boolean z) {
        this.mContext = context;
        this.mTQ = arrayList;
        this.mUw.addAll(arrayList);
        this.mUv = i;
        this.mTi = z;
        this.mUD = context.getResources().getDrawable(R.g.divider);
    }

    private void a(a aVar, int i) {
        GalleryItem$MediaItem a = a(i, aVar);
        if (a == null) {
            x.e("MicroMsg.PreviewSelectedImageAdapter", "get item failed");
            return;
        }
        LayoutParams layoutParams = aVar.mUL.getLayoutParams();
        int i2 = this.mUv;
        layoutParams.width = i2;
        layoutParams.height = i2;
        c(aVar.mRX, a.hOo, i);
        aVar.mUL.setOnClickListener(this);
        if (this.mTi) {
            aVar.mUL.setTag(Integer.valueOf(aVar.mUM));
        } else {
            aVar.mUL.setTag(a.hOo);
        }
        if (a.getType() == 2) {
            aVar.mRZ.setVisibility(0);
            int round = Math.round(((float) ((long) ((VideoMediaItem) a).hOr)) / 1000.0f);
            aVar.mSa.setText(String.format(Locale.CHINA, "%d:%02d", new Object[]{Integer.valueOf(round / 60), Integer.valueOf(round % 60)}));
        } else {
            aVar.mRZ.setVisibility(8);
        }
        String aNV = a.aNV();
        String str = a.hOo;
        if (bh.ov(aNV) && bh.ov(str)) {
            x.e("MicroMsg.PreviewSelectedImageAdapter", "null or nil filepath: " + i);
            return;
        }
        h.a(aVar.mRY, a.getType(), aNV, str, a.mRf, this.mUv, new 2(this, aVar));
        if ((c.aNE().aOh() == 3 || c.aNE().aOh() == 11) && a != null && a.mMimeType.equalsIgnoreCase("image/gif")) {
            aVar.mSf.setVisibility(0);
        } else {
            aVar.mSf.setVisibility(8);
        }
        if (a.mMimeType.equalsIgnoreCase("edit")) {
            aVar.mSg.setVisibility(0);
        } else {
            aVar.mSg.setVisibility(8);
        }
        aVar.mUK.setVisibility(8);
    }

    private void c(ImageView imageView, String str, int i) {
        if (i == this.mUC && this.mTQ.contains(str)) {
            x.i("MicroMsg.PreviewSelectedImageAdapter", "show select box");
            imageView.setVisibility(0);
            imageView.setBackground(null);
            imageView.setImageDrawable(this.mUD);
        } else if (i == this.mUC && !this.mTQ.contains(str)) {
            x.i("MicroMsg.PreviewSelectedImageAdapter", "no show select box");
            imageView.setVisibility(0);
            imageView.setBackgroundColor(-1090519041);
            imageView.setImageDrawable(this.mUD);
        } else if (i != this.mUC && this.mTQ.contains(str)) {
            imageView.setVisibility(8);
            imageView.setBackground(null);
            imageView.setImageDrawable(null);
        } else if (!(i == this.mUC || this.mTQ.contains(str))) {
            imageView.setVisibility(0);
            imageView.setBackgroundColor(-1090519041);
            imageView.setImageDrawable(null);
        }
        if (this.mUB != i) {
            return;
        }
        if (!bh.ov(this.mUu.kC(this.mUB)) && this.mUu.kC(this.mUB).equals(str)) {
            imageView.setVisibility(0);
        } else if (!bh.ov(this.mUu.kC(this.mUB)) && !this.mUu.kC(this.mUB).equals(str)) {
            imageView.setVisibility(8);
        }
    }

    public final int getItemCount() {
        return this.mUw.size();
    }

    public final void onClick(View view) {
        if (this.mUx == null) {
            return;
        }
        if (this.mTi) {
            this.mUx.qB(((Integer) view.getTag()).intValue());
        } else {
            this.mUx.qB(this.mUw.indexOf(view.getTag()));
        }
    }

    private GalleryItem$MediaItem a(int i, a aVar) {
        if (i < 0 || i >= this.mUw.size()) {
            x.w("MicroMsg.PreviewSelectedImageAdapter", "error position %d, imagePaths size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mUw.size())});
            return null;
        }
        String str = (String) this.mUw.get(i);
        GalleryItem$MediaItem a;
        int indexOf;
        Iterator it;
        GalleryItem$MediaItem galleryItem$MediaItem;
        if (this.mTi) {
            if (this.mUu.mRK == null) {
                return null;
            }
            a = GalleryItem$MediaItem.a(0, 0, str, str, "");
            indexOf = this.mUu.mRK.indexOf(a);
            if (indexOf >= 0) {
                aVar.mUM = indexOf;
                return (GalleryItem$MediaItem) this.mUu.mRK.get(indexOf);
            }
            it = c.aNJ().iterator();
            while (it.hasNext()) {
                galleryItem$MediaItem = (GalleryItem$MediaItem) it.next();
                if (galleryItem$MediaItem.equals(a)) {
                    x.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[]{galleryItem$MediaItem.hOo});
                    return galleryItem$MediaItem;
                }
            }
            return null;
        } else if (c.aNG() != null) {
            a = GalleryItem$MediaItem.a(0, 0, str, str, "");
            indexOf = c.aNG().indexOf(a);
            if (indexOf >= 0) {
                return (GalleryItem$MediaItem) c.aNG().get(indexOf);
            }
            it = c.aNJ().iterator();
            while (it.hasNext()) {
                galleryItem$MediaItem = (GalleryItem$MediaItem) it.next();
                if (galleryItem$MediaItem.equals(a)) {
                    x.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[]{galleryItem$MediaItem.hOo});
                    return galleryItem$MediaItem;
                }
            }
            return null;
        } else {
            return GalleryItem$MediaItem.a(1, 0, str, str, "");
        }
    }
}
