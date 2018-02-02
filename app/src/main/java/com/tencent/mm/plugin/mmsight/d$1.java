package com.tencent.mm.plugin.mmsight;

import java.io.File;

class d$1 implements Runnable {
    final /* synthetic */ int oqw;
    final /* synthetic */ String oqx;

    d$1(int i, String str) {
        this.oqw = i;
        this.oqx = str;
    }

    public final void run() {
        for (int bl = d.bl(); bl < this.oqw; bl++) {
            File file = new File(String.format("%s/tempvideo%s.mp4", new Object[]{this.oqx, Integer.valueOf(bl)}));
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(file.getAbsolutePath() + ".remux");
            if (file2.exists()) {
                file2.delete();
            }
            file2 = new File(file.getAbsoluteFile() + ".thumb");
            if (file2.exists()) {
                file2.delete();
            }
        }
        d.access$002(Math.max(this.oqw, 0));
    }
}
