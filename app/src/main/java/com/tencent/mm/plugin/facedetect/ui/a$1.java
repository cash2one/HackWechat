package com.tencent.mm.plugin.facedetect.ui;

class a$1 implements Runnable {
    final /* synthetic */ a miY;

    a$1(a aVar) {
        this.miY = aVar;
    }

    public final void run() {
        a.b(this.miY).setAnimationListener(new 1(this));
        a.a(this.miY).startAnimation(a.b(this.miY));
    }
}
