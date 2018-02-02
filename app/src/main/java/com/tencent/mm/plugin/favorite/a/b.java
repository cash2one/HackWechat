package com.tencent.mm.plugin.favorite.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public final class b implements i {
    private int height;
    private String mpy;
    private String url;
    private int width;

    public b(String str, String str2, int i, int i2) {
        this.mpy = str;
        this.url = str2;
        this.width = i;
        this.height = i2;
    }

    public final com.tencent.mm.platformtools.i.b We() {
        return null;
    }

    public final String Wf() {
        return j.aIE() + g.s(this.url.getBytes());
    }

    public final String Wg() {
        return this.url;
    }

    public final String Wh() {
        return this.mpy;
    }

    public final String Wi() {
        return this.mpy;
    }

    public final boolean Wj() {
        return true;
    }

    public final boolean Wk() {
        return false;
    }

    public final Bitmap Wl() {
        return BitmapFactory.decodeResource(ac.getContext().getResources(), R.g.bEk);
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        FileOutputStream fileOutputStream;
        Throwable e;
        if (a.ice == aVar) {
            try {
                x.v("MicroMsg.FavGetPicStrategy", "handlerBitmap get from net url:%s", new Object[]{this.url});
                File file = new File(j.aIE());
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (this.width > 0 && this.height > 0) {
                    bitmap = d.a(bitmap, this.width, this.height, true);
                }
                File file2 = new File(Wf());
                file2.createNewFile();
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        try {
                            x.printErrStackTrace("MicroMsg.FavGetPicStrategy", e, "", new Object[0]);
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return bitmap;
                        } catch (Throwable th) {
                            e = th;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw e;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileOutputStream = null;
                    x.printErrStackTrace("MicroMsg.FavGetPicStrategy", e, "", new Object[0]);
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return bitmap;
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e;
                }
            } catch (Throwable e4) {
                x.printErrStackTrace("MicroMsg.FavGetPicStrategy", e4, "", new Object[0]);
            }
        }
        return bitmap;
    }

    public final void Wm() {
    }

    public final void N(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }
}
