package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.AttributeSet;
import com.tencent.mm.a.g;
import com.tencent.mm.aq.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.e.a;

public class CdnImageView extends MMImageView implements a {
    private static final String sYn = (e.bnF + "wallet/images/");
    private af handler;
    private int mvv;
    private int nUr;
    private String url;
    private String vne;
    public boolean vnf;
    public boolean vng;

    static /* synthetic */ void a(CdnImageView cdnImageView, Bitmap bitmap) {
        if (bitmap != null) {
            try {
                x.d("MicroMsg.CdnImageView", "useSdcardCache, path: %s", new Object[]{cdnImageView.caP()});
                d.a(bitmap, 100, CompressFormat.PNG, r0, false);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CdnImageView", e, "saveBitmapToLocalCache error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public CdnImageView(Context context) {
        this(context, null);
    }

    public CdnImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CdnImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.url = null;
        this.vng = false;
        this.handler = new 1(this);
    }

    public void y(Bitmap bitmap) {
    }

    public final void setUrl(String str) {
        i(str, 0, 0, -1);
    }

    public final void V(String str, int i, int i2) {
        i(str, i, i2, -1);
    }

    public final void i(String str, int i, int i2, int i3) {
        Bitmap UN;
        this.url = str;
        this.nUr = i;
        this.mvv = i2;
        this.vne = null;
        if (!bh.ov(this.vne)) {
            UN = d.UN(this.vne);
            if (UN != null && UN.getWidth() > 0 && UN.getHeight() > 0) {
                setImageBitmap(UN);
                y(UN);
                return;
            }
        }
        if (str == null || str.length() == 0) {
            setVisibility(8);
        } else if (str.startsWith("http")) {
            o.Pv();
            UN = c.iG(str);
            if (UN != null) {
                if (this.nUr > 0 && this.mvv > 0) {
                    UN = d.a(UN, this.nUr, this.mvv, true, false);
                }
                if (this.vnf && UN != null) {
                    UN = d.a(UN, false, ((float) UN.getWidth()) * 0.5f);
                }
                setImageBitmap(UN);
                y(UN);
            } else if (!this.vng || !caQ()) {
                if (i3 > 0) {
                    setImageResource(i3);
                } else {
                    setImageBitmap(null);
                }
                com.tencent.mm.sdk.f.e.post(new a(str, this.handler), "CdnImageView_download");
            }
        } else if (com.tencent.mm.a.e.bO(str)) {
            UN = (this.nUr <= 0 || this.mvv <= 0) ? d.UN(str) : d.d(str, this.nUr, this.mvv, true);
            if (UN == null) {
                setVisibility(8);
                return;
            }
            if (this.vnf && UN != null) {
                UN = d.a(UN, false, ((float) UN.getWidth()) * 0.5f);
            }
            setImageBitmap(UN);
            y(UN);
        } else {
            setVisibility(8);
        }
    }

    private String caP() {
        if (!bh.ov(this.vne)) {
            return this.vne;
        }
        FileOp.mh(sYn);
        return sYn + g.s(this.url.getBytes());
    }

    private boolean caQ() {
        try {
            String caP = caP();
            x.d("MicroMsg.CdnImageView", "useSdcardCache, path: %s", new Object[]{caP});
            if (FileOp.bO(caP)) {
                Bitmap UN = d.UN(caP);
                x.d("MicroMsg.CdnImageView", "get bitmap from cache path: %s", new Object[]{UN});
                if (UN != null) {
                    if (this.nUr > 0 && this.mvv > 0) {
                        UN = d.a(UN, this.mvv, this.nUr, true, false);
                    }
                    if (this.vnf && UN != null) {
                        UN = d.a(UN, false, ((float) UN.getWidth()) * 0.5f);
                    }
                    setImageBitmap(UN);
                    y(UN);
                    return true;
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CdnImageView", e, "setBitmapFromLocalCache error: %s", new Object[]{e.getMessage()});
        }
        return false;
    }
}
