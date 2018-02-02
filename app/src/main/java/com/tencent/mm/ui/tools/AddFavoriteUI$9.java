package com.tencent.mm.ui.tools;

class AddFavoriteUI$9 implements Runnable {
    final /* synthetic */ AddFavoriteUI zgJ;

    AddFavoriteUI$9(AddFavoriteUI addFavoriteUI) {
        this.zgJ = addFavoriteUI;
    }

    public final void run() {
        AddFavoriteUI.c(this.zgJ).sendEmptyMessage(0);
    }
}
