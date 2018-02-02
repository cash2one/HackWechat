package com.tencent.mm.plugin.gallery.ui;

import android.os.Bundle;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;

@a(19)
public class SelectAlbumPreviewFolderUI extends MMActivity implements g.a {
    ArrayList<AlbumItem> mTa = new ArrayList(0);
    private a mUN;
    private RecyclerView mUO;
    AlbumItem mUP;
    private String mUQ;

    static /* synthetic */ String d(SelectAlbumPreviewFolderUI selectAlbumPreviewFolderUI) {
        if (c.aNE().aOi() == 1) {
            return selectAlbumPreviewFolderUI.getString(R.l.ekV);
        }
        return c.aNE().aOi() == 3 ? selectAlbumPreviewFolderUI.getString(R.l.ekW) : selectAlbumPreviewFolderUI.getString(R.l.ekX);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c.aNE().b(this);
        c.aNE().a(this);
        c.aNE().aOj();
        this.mUO = (RecyclerView) findViewById(R.h.ciQ);
        this.mUN = new a(this, this);
        this.mUO.a(new LinearLayoutManager());
        this.mUO.a(this.mUN);
        this.mUQ = getIntent().getStringExtra("select_folder_name");
        this.mUP = new AlbumItem("", 0);
        this.mUP.mRc = new ImageMediaItem();
        setMMTitle(bh.ou(getString(R.l.dEY)));
        setBackBtn(new 1(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        c.aNE().b(this);
    }

    protected final int getLayoutId() {
        return R.i.drD;
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public final void x(ArrayList<AlbumItem> arrayList) {
        new af(Looper.getMainLooper()).post(new 2(this, arrayList));
    }
}
