package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.ui.b.a;

class AuthorizedGameListUI$1 implements a {
    final /* synthetic */ AuthorizedGameListUI nkT;

    AuthorizedGameListUI$1(AuthorizedGameListUI authorizedGameListUI) {
        this.nkT = authorizedGameListUI;
    }

    public final void qN(int i) {
        if (i <= 0) {
            AuthorizedGameListUI.a(this.nkT).setVisibility(8);
            AuthorizedGameListUI.b(this.nkT).setVisibility(0);
            return;
        }
        AuthorizedGameListUI.a(this.nkT).setVisibility(0);
        AuthorizedGameListUI.b(this.nkT).setVisibility(8);
    }
}
