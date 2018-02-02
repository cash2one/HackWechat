package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.m;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.e.b.a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class c extends v {
    private Bitmap feJ = null;
    Context mContext;
    ArrayList<MediaItem> mRK = new ArrayList();
    ArrayList<String> mTh = new ArrayList();
    boolean mTi;
    HashSet<String> mTj = new HashSet();
    int mTk = -1;
    View mTl = null;
    boolean mTm = false;
    private HashMap<String, WeakReference<b>> mTn = new HashMap();
    public e mTo = new e(this);
    public d mTp = new d(this);

    static class b {
        MultiTouchImageView mTr;
        TextView mTs;
        ImageView myj;

        b() {
        }
    }

    public final /* synthetic */ Object e(int i, View view) {
        b bVar;
        String str;
        MediaItem mediaItem;
        String str2;
        MultiTouchImageView multiTouchImageView;
        long Wq = bh.Wq();
        if (view == null) {
            view = View.inflate(this.mContext, R.i.dlH, null);
            b bVar2 = new b();
            bVar2.mTr = (MultiTouchImageView) view.findViewById(R.h.image);
            bVar2.myj = (ImageView) view.findViewById(R.h.cVe);
            bVar2.mTs = (TextView) view.findViewById(R.h.cUY);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        String str3;
        if (this.mTi) {
            MediaItem mediaItem2 = (MediaItem) this.mRK.get(i);
            str3 = mediaItem2.hOo;
            str = mediaItem2.mld;
            mediaItem = mediaItem2;
            str2 = str3;
        } else {
            str3 = (String) this.mTh.get(i);
            if (com.tencent.mm.plugin.gallery.model.c.aNG() != null) {
                int indexOf = com.tencent.mm.plugin.gallery.model.c.aNG().indexOf(MediaItem.a(0, 0, str3, str3, ""));
                if (indexOf >= 0) {
                    mediaItem = (MediaItem) com.tencent.mm.plugin.gallery.model.c.aNG().get(indexOf);
                    str = null;
                    str2 = str3;
                }
            }
            mediaItem = null;
            str = null;
            str2 = str3;
        }
        if (mediaItem == null || mediaItem.getType() != 2) {
            if (com.tencent.mm.plugin.gallery.model.c.aNE().aOh() == 3 && mediaItem != null && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                bVar.mTs.setText(this.mContext.getString(R.l.ekY, new Object[]{bh.bx(new File(str2).length())}));
                bVar.mTs.setVisibility(0);
            } else {
                bVar.mTs.setVisibility(8);
            }
            bVar.myj.setVisibility(8);
            bVar.myj.setOnClickListener(null);
        } else {
            bVar.mTs.setVisibility(8);
            bVar.myj.setVisibility(0);
            bVar.myj.setOnClickListener(new a(this, str2));
            if (com.tencent.mm.plugin.gallery.model.c.aNE().aOh() == 4) {
                Runnable mVar = new m(mediaItem.hOo, i, (VideoMediaItem) mediaItem, null);
                if (e.V(mVar)) {
                    x.d("MicroMsg.ImageAdapter", "analysis of path[%s] has already been added in ThreadPool", new Object[]{Integer.valueOf(16842794)});
                } else {
                    e.post(mVar, "video_analysis");
                }
            }
        }
        MultiTouchImageView multiTouchImageView2;
        if (com.tencent.mm.plugin.gallery.model.c.aNE().aOh() != 3 || (!(mediaItem == null && p.UR(str2)) && (mediaItem == null || !mediaItem.mMimeType.equalsIgnoreCase("image/gif")))) {
            Bitmap bitmap;
            com.tencent.mm.plugin.gallery.model.c.aNF().aNU();
            if (this.mTp.mTE.bt(str2)) {
                bitmap = (Bitmap) this.mTp.mTE.get(str2);
                if (!bitmap.isRecycled()) {
                    a(bVar.mTr, bitmap);
                }
            }
            bitmap = com.tencent.mm.plugin.gallery.model.c.aND().Br(bh.ov(str) ? str2 : str);
            if (bitmap == null) {
                multiTouchImageView = bVar.mTr;
                if (this.feJ == null || this.feJ.isRecycled()) {
                    this.feJ = BitmapFactory.decodeResource(this.mContext.getResources(), R.g.bEF);
                }
                a(multiTouchImageView, this.feJ);
            } else {
                a(bVar.mTr, bitmap);
            }
            if (!this.mTj.contains(str2)) {
                this.mTj.add(str2);
                d dVar = this.mTp;
                multiTouchImageView2 = bVar.mTr;
                if (!dVar.tj.contains(str2)) {
                    int hashCode = multiTouchImageView2.hashCode();
                    dVar.qz(hashCode);
                    dVar.mTB.put(str2, Integer.valueOf(hashCode));
                    dVar.mTC.put(hashCode, str2);
                    dVar.mTA.put(hashCode, new WeakReference(multiTouchImageView2));
                    dVar.tj.add(str2);
                    dVar.aOv();
                }
            }
        } else {
            multiTouchImageView = bVar.mTr;
            multiTouchImageView.yfy = true;
            try {
                multiTouchImageView.yfz = com.tencent.mm.ui.e.b.c.fP(str2, str2);
                multiTouchImageView.setImageDrawable(multiTouchImageView.yfz);
                if (multiTouchImageView.yfz != null) {
                    multiTouchImageView.eS(multiTouchImageView.yfz.getIntrinsicWidth(), multiTouchImageView.yfz.getIntrinsicHeight());
                }
            } catch (Exception e) {
                multiTouchImageView.yfy = false;
            }
            multiTouchImageView2 = bVar.mTr;
            if (multiTouchImageView2.yfy && multiTouchImageView2.yfz != null) {
                ((a) multiTouchImageView2.yfz).stop();
                ((a) multiTouchImageView2.yfz).start();
            }
            bVar.mTr.aE(1.0f);
            bVar.mTr.rCd = false;
            if (VERSION.SDK_INT == 20) {
                bVar.mTr.setLayerType(1, null);
            } else {
                l.k(bVar.mTr, bVar.mTr.getWidth(), bVar.mTr.getHeight());
            }
            bVar.mTr.requestLayout();
            bVar.mTr.cpV();
        }
        x.v("MicroMsg.ImageAdapter", "test getview: %d position:%d", new Object[]{Long.valueOf(bh.bA(Wq)), Integer.valueOf(i)});
        return view;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public final void B(ArrayList<String> arrayList) {
        this.mTh.clear();
        this.mTh = new ArrayList();
        this.mTh.addAll(arrayList);
        reset();
        notifyDataSetChanged();
    }

    public final Object b(ViewGroup viewGroup, int i) {
        if (this.mTi) {
            return super.b(viewGroup, i);
        }
        x.i("MicroMsg.ImageAdapter", "[instantiateItem] position:%s %s", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mTk)});
        if (i != this.mTk || !this.mTm) {
            return super.b(viewGroup, i);
        }
        x.d("MicroMsg.ImageAdapter", "[isSwap-instantiateItem]");
        this.yeQ.put(this.mTl, Integer.valueOf(this.mTk));
        this.yeR.put(this.mTk, this.mTl);
        this.mTk = -1;
        this.mTm = false;
        return this.mTl;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        if (this.mTi) {
            super.a(viewGroup, i, obj);
        } else if (obj == null) {
            x.e("MicroMsg.ImageAdapter", "[destroyItem] position:%s", new Object[]{Integer.valueOf(i)});
        } else {
            if (this.mTl != null) {
                x.i("MicroMsg.ImageAdapter", "[destroyItem] position:%s object:%s lastVisableView:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(obj.hashCode()), Integer.valueOf(this.mTl.hashCode())});
            }
            if (obj == this.mTl && this.mTm) {
                x.d("MicroMsg.ImageAdapter", "[isSwap-destroyItem]");
                return;
            }
            super.a(viewGroup, i, obj);
            viewGroup.removeView((View) obj);
        }
    }

    public final int getCount() {
        if (this.mTi) {
            return this.mRK.size();
        }
        return this.mTh.size();
    }

    public final MultiTouchImageView qx(int i) {
        View EQ = super.EQ(i);
        if (EQ == null) {
            x.e("MicroMsg.ImageAdapter", "position : %s getMultiTouchImageViewByPosition is null", new Object[]{Integer.valueOf(i)});
            return null;
        } else if (EQ == null || EQ.getVisibility() == 8) {
            return null;
        } else {
            EQ = EQ.findViewById(R.h.image);
            if (EQ == null) {
                return null;
            }
            return (MultiTouchImageView) EQ;
        }
    }

    public final String kC(int i) {
        if (this.mTi) {
            if (i >= 0 && i < this.mRK.size()) {
                return ((MediaItem) this.mRK.get(i)).hOo;
            }
            x.w("MicroMsg.ImageAdapter", "error position %d, mediaitems size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mRK.size())});
            return "";
        } else if (i >= 0 && i < this.mTh.size()) {
            return (String) this.mTh.get(i);
        } else {
            x.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mTh.size())});
            return "";
        }
    }

    public final MediaItem qy(int i) {
        if (this.mTi) {
            if (i >= 0 && i < this.mRK.size()) {
                return (MediaItem) this.mRK.get(i);
            }
            x.w("MicroMsg.ImageAdapter", "error position %d mediaitems size", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mRK.size())});
            return null;
        } else if (i < 0 || i >= this.mTh.size()) {
            x.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mTh.size())});
            return null;
        } else {
            String str = (String) this.mTh.get(i);
            if (com.tencent.mm.plugin.gallery.model.c.aNG() == null) {
                return null;
            }
            int indexOf = com.tencent.mm.plugin.gallery.model.c.aNG().indexOf(MediaItem.a(0, 0, str, str, ""));
            if (indexOf >= 0) {
                return (MediaItem) com.tencent.mm.plugin.gallery.model.c.aNG().get(indexOf);
            }
            return null;
        }
    }

    @TargetApi(11)
    static void a(MultiTouchImageView multiTouchImageView, Bitmap bitmap) {
        multiTouchImageView.aE(4.5f);
        multiTouchImageView.rCd = false;
        if (VERSION.SDK_INT == 20) {
            multiTouchImageView.setLayerType(1, null);
        } else {
            l.k(multiTouchImageView, bitmap.getWidth(), bitmap.getHeight());
        }
        multiTouchImageView.eS(bitmap.getWidth(), bitmap.getHeight());
        multiTouchImageView.setImageBitmap(bitmap);
        multiTouchImageView.requestLayout();
    }

    public final void release() {
        detach();
        this.mTn.clear();
        this.mTj.clear();
    }

    public final void detach() {
        super.detach();
        d dVar = this.mTp;
        dVar.mTG = null;
        dVar.mTA.clear();
        dVar.mTD.clear();
        dVar.mTC.clear();
        dVar.mTB.clear();
        dVar.aOt();
    }
}
