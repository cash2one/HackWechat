package com.tencent.mm.plugin.gallery.ui;

class ImageFolderMgrView$4 implements Runnable {
    final /* synthetic */ ImageFolderMgrView mTz;

    ImageFolderMgrView$4(ImageFolderMgrView imageFolderMgrView) {
        this.mTz = imageFolderMgrView;
    }

    public final void run() {
        ImageFolderMgrView.d(this.mTz).notifyDataSetChanged();
    }

    public final String toString() {
        return super.toString() + "|onQueryAlbumFinished";
    }
}
