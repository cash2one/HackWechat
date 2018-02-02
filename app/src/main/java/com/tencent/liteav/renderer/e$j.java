package com.tencent.liteav.renderer;

import com.tencent.liteav.renderer.e.i;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import javax.microedition.khronos.opengles.GL10;

class e$j {
    private static String a = "GLThreadManager";
    private boolean b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f;
    private i g;

    private e$j() {
    }

    public synchronized void a(i iVar) {
        i.a(iVar, true);
        if (this.g == iVar) {
            this.g = null;
        }
        notifyAll();
    }

    public boolean b(i iVar) {
        if (this.g == iVar || this.g == null) {
            this.g = iVar;
            notifyAll();
            return true;
        }
        c();
        if (this.e) {
            return true;
        }
        if (this.g != null) {
            this.g.h();
        }
        return false;
    }

    public void c(i iVar) {
        if (this.g == iVar) {
            this.g = null;
        }
        notifyAll();
    }

    public synchronized boolean a() {
        return this.f;
    }

    public synchronized boolean b() {
        c();
        return !this.e;
    }

    public synchronized void a(GL10 gl10) {
        boolean z = true;
        synchronized (this) {
            if (!this.d) {
                c();
                String glGetString = gl10.glGetString(7937);
                if (this.c < WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                    this.e = !glGetString.startsWith("Q3Dimension MSM7500 ");
                    notifyAll();
                }
                if (this.e) {
                    z = false;
                }
                this.f = z;
                this.d = true;
            }
        }
    }

    private void c() {
        this.c = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        this.e = true;
        this.b = true;
    }
}
