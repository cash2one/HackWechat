package com.tencent.mm.plugin.game.gamewebview.ui;

class d$25 implements Runnable {
    final /* synthetic */ d mZC;

    public d$25(d dVar) {
        this.mZC = dVar;
    }

    public final void run() {
        d.n(this.mZC).evaluateJavascript("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()", new 1(this));
    }
}
