package com.tencent.mm.ui.tools.a;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.qq.taf.jce.JceStruct;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends a {
    public int hX = JceStruct.JCE_MAX_STRING_LENGTH;
    private int mHeight = 2048;
    private int mWidth = 2048;
    private String oja;
    public int znI = 0;
    public int znJ = 0;
    public int znK = 0;
    private a znL;

    private b(String str) {
        this.oja = str;
    }

    public static b aac(String str) {
        return new b(str);
    }

    public final b GM(int i) {
        this.mWidth = i;
        this.mHeight = i;
        return this;
    }

    public final void a(a aVar) {
        this.znL = aVar;
        ccj();
    }

    protected final int adc() {
        boolean z;
        if (bh.ov(this.oja)) {
            x.w("MicroMsg.ImageBoundaryCheck", "dz[check image but path is null or nil]");
        }
        this.znI = e.bN(this.oja);
        String str = this.oja;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        this.znJ = options.outWidth;
        this.znK = options.outHeight;
        if (this.znI <= this.hX) {
            if (!(this.znI < 0)) {
                z = true;
                if (this.znJ > this.mWidth || this.znK > this.mHeight) {
                    x.d("MicroMsg.ImageBoundaryCheck", "dz[over width or height] width = %d, height = %d", new Object[]{Integer.valueOf(this.znJ), Integer.valueOf(this.znK)});
                    z = false;
                }
                if (z) {
                    return 1;
                }
                x.i("MicroMsg.ImageBoundaryCheck", "dz[status ok]");
                return 0;
            }
        }
        x.d("MicroMsg.ImageBoundaryCheck", "dz[over size] size = %d", new Object[]{Integer.valueOf(this.znI)});
        z = false;
        x.d("MicroMsg.ImageBoundaryCheck", "dz[over width or height] width = %d, height = %d", new Object[]{Integer.valueOf(this.znJ), Integer.valueOf(this.znK)});
        z = false;
        if (z) {
            return 1;
        }
        x.i("MicroMsg.ImageBoundaryCheck", "dz[status ok]");
        return 0;
    }

    protected final void ccj() {
        if (this.znL == null) {
            x.w("MicroMsg.ImageBoundaryCheck", "dz[callback is null]");
            return;
        }
        switch (adc()) {
            case 0:
                this.znL.a(this);
                return;
            case 1:
                this.znL.aCH();
                return;
            default:
                return;
        }
    }
}
