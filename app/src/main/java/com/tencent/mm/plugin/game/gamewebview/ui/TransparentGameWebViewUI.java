package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.ui.base.a;

@a(1)
public class TransparentGameWebViewUI extends GameWebViewUI {
    protected final void initView() {
        super.initView();
        this.mYs.setBackgroundColor(0);
    }
}
