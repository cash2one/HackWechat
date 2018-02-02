package com.tencent.mm.ui.tools;

class AddFavoriteUI$1 implements Runnable {
    final /* synthetic */ AddFavoriteUI zgJ;

    AddFavoriteUI$1(AddFavoriteUI addFavoriteUI) {
        this.zgJ = addFavoriteUI;
    }

    public final void run() {
        AddFavoriteUI.a(this.zgJ).sendEmptyMessage(0);
    }
}
