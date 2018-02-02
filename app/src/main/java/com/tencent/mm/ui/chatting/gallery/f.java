package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.as;
import java.util.HashMap;
import java.util.LinkedList;

public final class f {
    private as hqc = new as(1, "chatting-image-gallery-preload-loader");
    protected com.tencent.mm.a.f<String, Bitmap> mTE = new com.tencent.mm.a.f(4, new 1(this));
    private boolean mTH = false;
    public LinkedList<String> tj = new LinkedList();
    protected HashMap<String, Long> yEC = new HashMap();
    private int yi = 0;

    private static final class a {
        public static f yEE = new f();
    }

    public final void aOt() {
        this.mTE.a(new 2(this));
    }
}
