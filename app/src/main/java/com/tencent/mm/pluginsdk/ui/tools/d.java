package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public final class d implements i {
    private int height = 0;
    private String mpy;
    private String url;
    private int width = 0;

    public d(String str, String str2) {
        this.mpy = str;
        this.url = str2;
    }

    public final String Wf() {
        return c.Fi() + "/" + g.s(this.url.getBytes());
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
        return BitmapFactory.decodeResource(ac.getContext().getResources(), com.tencent.mm.plugin.comm.a.d.bEk);
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        FileOutputStream fileOutputStream;
        Throwable e;
        if (a.ice == aVar) {
            try {
                x.v("MicroMsg.DefaultPicStrategy", "handlerBitmap get from net url:%s", new Object[]{this.url});
                if (this.width > 0 && this.height > 0) {
                    bitmap = com.tencent.mm.sdk.platformtools.d.a(bitmap, this.width, this.height, true);
                }
                File file = new File(Wf());
                file.createNewFile();
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        try {
                            x.printErrStackTrace("MicroMsg.DefaultPicStrategy", e, "", new Object[0]);
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
                    x.printErrStackTrace("MicroMsg.DefaultPicStrategy", e, "", new Object[0]);
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
                x.printErrStackTrace("MicroMsg.DefaultPicStrategy", e4, "", new Object[0]);
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

    public final b We() {
        return null;
    }
}
