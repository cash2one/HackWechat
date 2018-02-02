package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.gridviewheaders.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends BaseAdapter implements e {
    private SimpleDateFormat lpS = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private Context mContext;
    int mRI = 9;
    com.tencent.mm.plugin.gallery.stub.a mRJ = null;
    ArrayList<MediaItem> mRK = new ArrayList();
    ArrayList<MediaItem> mRL = new ArrayList();
    private b mRM;
    int mRN;
    LinkedList<a> mRO = new LinkedList();
    boolean mRP = false;
    private OnClickListener mRQ = new 2(this);

    public interface b {
        void K(int i, int i2, int i3);
    }

    public final /* synthetic */ Object getItem(int i) {
        return qs(i);
    }

    public a(Context context, b bVar) {
        this.mContext = context;
        this.mRM = bVar;
    }

    public final void a(a aVar) {
        if (aVar == null) {
            x.w("MicroMsg.AlbumAdapter", "addHeader error, header is null");
            return;
        }
        this.mRO.remove(aVar);
        this.mRO.add(aVar);
    }

    public final ArrayList<String> aOm() {
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = this.mRL.iterator();
        while (it.hasNext()) {
            arrayList.add(((MediaItem) it.next()).hOo);
        }
        return arrayList;
    }

    public final void y(ArrayList<String> arrayList) {
        x.d("MicroMsg.AlbumAdapter", "before set selected paths, selected[%s]", new Object[]{this.mRL});
        this.mRL.clear();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                MediaItem a = MediaItem.a(0, 0, str, str, "");
                if (c.aNG() != null) {
                    int indexOf = c.aNG().indexOf(a);
                    if (indexOf >= 0) {
                        a = (MediaItem) c.aNG().get(indexOf);
                        if (a != null && a.getType() == 2) {
                            this.mRL.add(MediaItem.a(2, 0, str, "", ""));
                        }
                    }
                }
                x.d("MicroMsg.AlbumAdapter", "media item no exist on preview items.");
                int i = 1;
                long j = 0;
                String str2 = str;
                this.mRL.add(MediaItem.a(i, j, str2, "", ""));
            }
        }
        x.d("MicroMsg.AlbumAdapter", "after set selected paths, selected[%s]", new Object[]{this.mRL});
    }

    public final ArrayList<MediaItem> qr(int i) {
        ArrayList<MediaItem> arrayList = new ArrayList();
        Iterator it = this.mRK.iterator();
        while (it.hasNext()) {
            MediaItem mediaItem = (MediaItem) it.next();
            if (mediaItem.getType() == i) {
                arrayList.add(mediaItem);
            }
        }
        return arrayList;
    }

    public final int getCount() {
        return this.mRO.size() + this.mRK.size();
    }

    public final int getViewTypeCount() {
        return this.mRO.size() + 1;
    }

    public final int getItemViewType(int i) {
        return i < this.mRO.size() ? i : this.mRO.size();
    }

    public final MediaItem qs(int i) {
        if (i < this.mRO.size()) {
            x.i("MicroMsg.AlbumAdapter", "get header, pos[%d]", new Object[]{Integer.valueOf(i)});
            return null;
        }
        int size = i - this.mRO.size();
        if (size < this.mRK.size()) {
            return (MediaItem) this.mRK.get(size);
        }
        x.w("MicroMsg.AlbumAdapter", "get item error, media items size[%d], adjustPos[%d]", new Object[]{Integer.valueOf(this.mRK.size()), Integer.valueOf(size)});
        MediaItem imageMediaItem = new ImageMediaItem();
        imageMediaItem.mRg = bh.Wp();
        return imageMediaItem;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        x.v("MicroMsg.AlbumAdapter", "duanyi getview index[%d] header size[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mRO.size())});
        if (i < this.mRO.size()) {
            x.i("MicroMsg.AlbumAdapter", "position[%d], get header view", new Object[]{Integer.valueOf(i)});
            return ((a) this.mRO.get(i)).getView();
        }
        View inflate;
        d dVar;
        int size = i - this.mRO.size();
        MediaItem mediaItem = (MediaItem) this.mRK.get(size);
        x.i("MicroMsg.AlbumAdapter", "addtime:%s", new Object[]{Long.valueOf(mediaItem.mRg)});
        if (view == null || !(view.getTag() instanceof d)) {
            String str = "MicroMsg.AlbumAdapter";
            String str2 = "converview is null?[%B]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(view == null);
            x.d(str, str2, objArr);
            inflate = LayoutInflater.from(this.mContext).inflate(R.i.drk, viewGroup, false);
            d dVar2 = new d((byte) 0);
            dVar2.mRX = (ImageView) inflate.findViewById(R.h.cvC);
            dVar2.mRY = (ImageView) inflate.findViewById(R.h.cvF);
            dVar2.mRZ = (RelativeLayout) inflate.findViewById(R.h.cVe);
            dVar2.mSa = (TextView) inflate.findViewById(R.h.cVf);
            dVar2.mSc = (CheckBox) inflate.findViewById(R.h.cvv);
            dVar2.mSb = (TextView) inflate.findViewById(R.h.cKY);
            dVar2.mSd = inflate.findViewById(R.h.cvw);
            dVar2.mSe = (ImageView) inflate.findViewById(R.h.cvA);
            dVar2.mSd.setOnClickListener(this.mRQ);
            dVar2.mSd.setTag(R.h.cvv, dVar2.mSc);
            dVar2.mSd.setTag(R.h.cKY, dVar2.mSb);
            dVar2.mSd.setTag(R.h.cvA, dVar2.mSe);
            if (c.aNE().aOh() == 0 || c.aNE().aOh() == 5 || c.aNE().aOh() == 10 || c.aNE().aOh() == 11) {
                dVar2.mSc.setVisibility(8);
                dVar2.mSb.setVisibility(8);
                dVar2.mSd.setVisibility(8);
                dVar2.mSe.setVisibility(8);
            }
            dVar2.mSf = (ImageView) inflate.findViewById(R.h.cnD);
            dVar2.mSg = (ImageView) inflate.findViewById(R.h.cdh);
            inflate.setTag(dVar2);
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
            inflate = view;
        }
        if (mediaItem == null) {
            x.e("MicroMsg.AlbumAdapter", "get item failed");
            return inflate;
        }
        dVar.mRX.setVisibility(0);
        if (mediaItem.getType() == 2) {
            dVar.mRZ.setVisibility(0);
            c.a(dVar.mSa, (VideoMediaItem) mediaItem);
        } else {
            dVar.mRZ.setVisibility(8);
        }
        if (mediaItem.mMimeType.equalsIgnoreCase("edit")) {
            dVar.mSg.setVisibility(0);
        } else {
            dVar.mSg.setVisibility(8);
        }
        str2 = mediaItem.aNV();
        String str3 = mediaItem.hOo;
        if (bh.ov(str2) && bh.ov(str3)) {
            x.e("MicroMsg.AlbumAdapter", "null or nil filepath: " + size);
            return inflate;
        }
        dVar.mSd.setTag(R.h.cvw, Integer.valueOf(size));
        int i2 = R.l.eAc;
        if (mediaItem.getType() == 2) {
            i2 = R.l.cVz;
        }
        x.d("MicroMsg.AlbumAdapter", "thumbFilaPath: %s | origFilePath: %s | contentDescription %s", new Object[]{str2, str3, viewGroup.getContext().getString(i2, new Object[]{Integer.valueOf((i + 1) - this.mRO.size()), this.lpS.format(new Date(mediaItem.mRg))})});
        dVar.mRY.setContentDescription(r2);
        h.a(dVar.mRY, mediaItem.getType(), str2, str3, mediaItem.mRf, -1, new 1(this, dVar.mRX));
        if (this.mRP) {
            if (mediaItem.getType() == 2) {
                dVar.mSc.setVisibility(8);
                dVar.mSb.setVisibility(8);
                dVar.mSd.setVisibility(8);
                dVar.mSe.setVisibility(8);
            } else if (this.mRL.contains(mediaItem)) {
                dVar.mSc.setChecked(true);
                dVar.mSb.setText((mediaItem == null ? -1 : this.mRL.indexOf(mediaItem)));
                dVar.mSe.setBackgroundResource(R.e.bsK);
                dVar.mSd.setVisibility(0);
                dVar.mSc.setVisibility(0);
                dVar.mSe.setVisibility(0);
            } else {
                dVar.mSb.setVisibility(8);
                dVar.mSc.setChecked(false);
                dVar.mSe.setBackgroundResource(R.e.bsQ);
                dVar.mSc.setVisibility(0);
                dVar.mSd.setVisibility(0);
                dVar.mSe.setVisibility(0);
            }
        } else if (this.mRL.contains(mediaItem)) {
            dVar.mSc.setChecked(true);
            dVar.mSe.setVisibility(0);
            dVar.mSe.setBackgroundResource(R.e.bsK);
        } else {
            dVar.mSc.setChecked(false);
            dVar.mSb.setVisibility(8);
            dVar.mSe.setVisibility(0);
            dVar.mSe.setBackgroundResource(R.e.bsQ);
        }
        if ((c.aNE().aOh() == 3 || c.aNE().aOh() == 11) && mediaItem != null && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            dVar.mSf.setVisibility(0);
        } else {
            dVar.mSf.setVisibility(8);
        }
        return inflate;
    }

    public final long om(int i) {
        if (i < this.mRO.size()) {
            x.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", new Object[]{Integer.valueOf(i)});
            i = this.mRO.size();
        }
        x.v("MicroMsg.AlbumAdapter", "getHeaderId, adjust pos[%d], date[%d] date[%s], headerID[%d]", new Object[]{Integer.valueOf(i), Long.valueOf(qs(i).mRg), r1, Long.valueOf(com.tencent.mm.ui.gridviewheaders.a.cxk().b(new Date(qs(i).mRg)))});
        return com.tencent.mm.ui.gridviewheaders.a.cxk().b(new Date(qs(i).mRg));
    }

    public final String qt(int i) {
        if (i < this.mRO.size()) {
            x.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", new Object[]{Integer.valueOf(i)});
            i = this.mRO.size();
        }
        return com.tencent.mm.ui.gridviewheaders.a.cxk().a(new Date(qs(i).mRg), this.mContext);
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        View textView;
        if (i < this.mRO.size()) {
            x.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", new Object[]{Integer.valueOf(i)});
            i = this.mRO.size();
        }
        if (view == null || view.getParent() != null) {
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            textView = new TextView(this.mContext);
            textView.setBackgroundResource(R.g.bDp);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.bvS);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.f.bvS);
            textView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            textView.setTextColor(this.mContext.getResources().getColor(R.e.bsp));
            textView.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(R.f.bvs));
            textView.setTypeface(null, 1);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = view;
        }
        x.v("MicroMsg.AlbumAdapter", "getHeaderView, adjust pos[%d], date[%d] date[%s], headerStr[%s]", new Object[]{Integer.valueOf(i), Long.valueOf(r0.mRg), new Date(qs(i).mRg), com.tencent.mm.ui.gridviewheaders.a.cxk().a(new Date(qs(i).mRg), this.mContext)});
        ((TextView) textView).setText(r3);
        return textView;
    }
}
