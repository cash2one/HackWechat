package com.tencent.mm.plugin.game.gamewebview.ipc;

import com.tencent.mm.plugin.base.model.d.a;

class AddShortcutTask$1 implements a {
    final /* synthetic */ AddShortcutTask mVM;

    AddShortcutTask$1(AddShortcutTask addShortcutTask) {
        this.mVM = addShortcutTask;
    }

    public final void dO(boolean z) {
        this.mVM.success = z;
        this.mVM.afp();
    }
}
