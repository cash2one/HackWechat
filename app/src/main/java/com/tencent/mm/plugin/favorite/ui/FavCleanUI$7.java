package com.tencent.mm.plugin.favorite.ui;

class FavCleanUI$7 implements Runnable {
    final /* synthetic */ FavCleanUI msh;

    FavCleanUI$7(FavCleanUI favCleanUI) {
        this.msh = favCleanUI;
    }

    public final void run() {
        if (FavCleanUI.e(this.msh) != null) {
            FavCleanUI.e(this.msh).aJt();
        }
        this.msh.aJf();
    }
}
