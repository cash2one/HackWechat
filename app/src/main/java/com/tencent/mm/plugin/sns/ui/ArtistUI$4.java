package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ArtistUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ ArtistUI rqX;

    ArtistUI$4(ArtistUI artistUI) {
        this.rqX = artistUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.rqX.finish();
        return true;
    }
}
