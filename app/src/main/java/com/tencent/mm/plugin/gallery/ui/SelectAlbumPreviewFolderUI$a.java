package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.RecyclerView.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.ui.SelectAlbumPreviewFolderUI.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class SelectAlbumPreviewFolderUI$a extends a<b> implements OnClickListener {
    Context mContext;
    final /* synthetic */ SelectAlbumPreviewFolderUI mUR;

    public final /* synthetic */ RecyclerView$t a(ViewGroup viewGroup, int i) {
        return new b(this.mUR, LayoutInflater.from(this.mContext).inflate(R.i.drl, viewGroup, false));
    }

    public final /* synthetic */ void a(RecyclerView$t recyclerView$t, int i) {
        b bVar = (b) recyclerView$t;
        SelectAlbumPreviewFolderUI selectAlbumPreviewFolderUI = this.mUR;
        AlbumItem albumItem = i == 0 ? selectAlbumPreviewFolderUI.mUP : (AlbumItem) selectAlbumPreviewFolderUI.mTa.get(i - 1);
        bVar.mUL.setOnClickListener(this);
        bVar.mUL.setTag(albumItem);
        if (SelectAlbumPreviewFolderUI.c(this.mUR) == null || !(SelectAlbumPreviewFolderUI.c(this.mUR).equals(albumItem.mRb) || (SelectAlbumPreviewFolderUI.c(this.mUR).equals(SelectAlbumPreviewFolderUI.d(this.mUR)) && i == 0))) {
            bVar.mTf.setVisibility(4);
        } else {
            bVar.mTf.setVisibility(0);
        }
        if (i == 0) {
            bVar.mRY.setImageResource(R.g.bEF);
            if (albumItem.mRc != null) {
                h.a(bVar.mRY, albumItem.mRc.getType(), albumItem.aNV(), albumItem.mRc.hOo, albumItem.aNW());
            }
            bVar.iir.setText(SelectAlbumPreviewFolderUI.d(this.mUR));
            bVar.mRY.setVisibility(0);
            bVar.iir.setVisibility(0);
            bVar.mTe.setVisibility(8);
            return;
        }
        bVar.mRY.setVisibility(0);
        bVar.iir.setVisibility(0);
        bVar.iir.setText(albumItem.mRb);
        bVar.mTe.setVisibility(0);
        bVar.mTe.setText(this.mContext.getString(R.l.ele, new Object[]{Integer.valueOf(albumItem.ftF)}));
        if (!(bVar.myj == null || albumItem.mRc == null)) {
            bVar.myj.setVisibility(albumItem.mRc.getType() == 2 ? 0 : 8);
        }
        String aNV = albumItem.aNV();
        if (!bh.ov(aNV) && albumItem.mRc != null) {
            h.a(bVar.mRY, albumItem.mRc.getType(), aNV, albumItem.mRc.hOo, albumItem.aNW());
        } else if (albumItem.mRc == null || albumItem.mRc.getType() != 2) {
            x.e("MicroMsg.SelectAlbumPreviewFolderUI", "get folder failed");
            bVar.mRY.setVisibility(8);
            bVar.iir.setVisibility(8);
        } else {
            h.a(bVar.mRY, albumItem.mRc.getType(), null, albumItem.mRc.hOo, albumItem.aNW());
        }
    }

    public SelectAlbumPreviewFolderUI$a(SelectAlbumPreviewFolderUI selectAlbumPreviewFolderUI, Context context) {
        this.mUR = selectAlbumPreviewFolderUI;
        this.mContext = context;
    }

    public final int getItemCount() {
        return SelectAlbumPreviewFolderUI.a(this.mUR).size() + 1;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.mUR, AlbumPreviewUI.class);
        intent.putExtra("select_folder_name", (AlbumItem) view.getTag());
        intent.setFlags(67108864);
        this.mUR.setResult(-1, intent);
        this.mUR.finish();
    }
}
