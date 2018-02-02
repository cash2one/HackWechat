package com.tencent.mm.plugin.gallery.ui;

import java.util.ArrayList;

class SelectAlbumPreviewFolderUI$2 implements Runnable {
    final /* synthetic */ SelectAlbumPreviewFolderUI mUR;
    final /* synthetic */ ArrayList mUS;

    SelectAlbumPreviewFolderUI$2(SelectAlbumPreviewFolderUI selectAlbumPreviewFolderUI, ArrayList arrayList) {
        this.mUR = selectAlbumPreviewFolderUI;
        this.mUS = arrayList;
    }

    public final void run() {
        SelectAlbumPreviewFolderUI.a(this.mUR).addAll(this.mUS);
        SelectAlbumPreviewFolderUI.b(this.mUR).UR.notifyChanged();
    }
}
