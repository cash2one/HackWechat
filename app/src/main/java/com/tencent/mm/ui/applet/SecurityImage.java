package com.tencent.mm.ui.applet;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;

public class SecurityImage extends LinearLayout {
    private i pyk = null;
    public String xPq = null;
    public String xPr = null;
    public int xPt = 0;
    ProgressBar xWo = null;
    ImageView xWp = null;
    Button xWq = null;
    EditText xWr = null;
    b xWs;

    public SecurityImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(int i, byte[] bArr, String str, String str2) {
        md(true);
        this.xPq = str;
        this.xPr = str2;
        this.xPt = i;
        Bitmap bl = d.bl(bArr);
        if (bl != null) {
            x.i("MicroMsg.SecurityImage", "dkwt setSecImg sid:%s key:%s imgBuf:%d [%d %d]", new Object[]{str, str2, Integer.valueOf(bArr.length), Integer.valueOf(bl.getWidth()), Integer.valueOf(bl.getHeight())});
            this.xPq = str;
            this.xPr = str2;
            this.xPt = i;
            if (bl != null) {
                this.xWp.setImageBitmap(bl);
                return;
            } else {
                x.e("MicroMsg.SecurityImage", "setSecImg failed, decode failed");
                return;
            }
        }
        String str3 = "MicroMsg.SecurityImage";
        String str4 = "dkwt setSecImg ERROR sid:%s key:%s imgBuf:%d";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        x.e(str3, str4, objArr);
    }

    public final String coF() {
        return this.xWr == null ? "" : this.xWr.getText().toString().trim();
    }

    public final void dismiss() {
        if (this.pyk != null) {
            this.pyk.dismiss();
            this.pyk = null;
        }
    }

    private void md(boolean z) {
        int i = 0;
        this.xWp.setAlpha(z ? 255 : 40);
        this.xWp.setBackgroundColor(z ? 0 : -5592406);
        ProgressBar progressBar = this.xWo;
        if (z) {
            i = 4;
        }
        progressBar.setVisibility(i);
    }
}
