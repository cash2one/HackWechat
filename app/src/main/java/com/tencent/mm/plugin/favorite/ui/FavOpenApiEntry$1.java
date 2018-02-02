package com.tencent.mm.plugin.favorite.ui;

import com.tencent.mm.sdk.platformtools.ak.a;

class FavOpenApiEntry$1 implements a {
    final /* synthetic */ FavOpenApiEntry msF;

    FavOpenApiEntry$1(FavOpenApiEntry favOpenApiEntry) {
        this.msF = favOpenApiEntry;
    }

    public final boolean uF() {
        if (this.msF.getWindow() != null && this.msF.getWindow().getDecorView() != null && this.msF.getWindow().getDecorView().getWindowToken() != null) {
            FavOpenApiEntry.a(this.msF, FavOpenApiEntry.c(this.msF).message);
            return false;
        } else if (FavOpenApiEntry.a(this.msF) >= 10) {
            return false;
        } else {
            FavOpenApiEntry.b(this.msF);
            return true;
        }
    }
}
