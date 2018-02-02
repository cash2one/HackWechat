package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a$d;
import com.tencent.mm.plugin.facedetect.a$h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public final class a {
    static c miX = new c();
    RelativeLayout miM = null;
    Button miN = null;
    ImageView miO = null;
    TextView miP = null;
    TextView miQ = null;
    Button miR = null;
    Button miS = null;
    TextView miT = null;
    Animation miU = null;
    Animation miV = null;
    WeakReference<FaceDetectPrepareUI> miW = null;

    a(FaceDetectPrepareUI faceDetectPrepareUI) {
        this.miW = new WeakReference(faceDetectPrepareUI);
    }

    public final void dismiss() {
        miX.cancel();
        if (this.miM.getVisibility() == 0) {
            ag.y(new 1(this));
        }
    }

    public final void w(Bitmap bitmap) {
        this.miM.setBackgroundDrawable(new BitmapDrawable(bitmap));
    }

    public final void a(b bVar) {
        if (miX != null) {
            miX.cancel();
        }
        if (bVar != null) {
            x.i("MicroMsg.FaceDetectJumper", "hy: request show conf: %s", bVar.toString());
            if (bVar.mje) {
                this.miR.setVisibility(0);
                this.miR.setText(bVar.mjn);
                this.miR.setOnClickListener(bVar.mju);
            } else {
                this.miR.setVisibility(4);
            }
            if (bVar.mjb) {
                this.miN.setVisibility(0);
                this.miN.setText(bVar.mjl);
                this.miN.setOnClickListener(bVar.mjr);
            } else {
                this.miN.setVisibility(4);
            }
            if (bVar.mjf) {
                this.miS.setVisibility(0);
                this.miS.setText(bVar.mjm);
                this.miS.setOnClickListener(bVar.mjs);
            } else {
                this.miS.setVisibility(4);
            }
            if (bVar.mjc) {
                this.miP.setVisibility(0);
                if (bVar.mjg) {
                    this.miQ.setVisibility(0);
                    int i = bVar.mji;
                    CharSequence charSequence = bVar.mjk;
                    if (bh.ov(charSequence) || i >= charSequence.length() || i < 0) {
                        x.e("MicroMsg.FaceDetectJumper", "hy: invalid showing one by one");
                        this.miP.setText(charSequence);
                        this.miQ.setText("");
                    } else {
                        miX.cancel();
                        c cVar = miX;
                        WeakReference weakReference = new WeakReference(this.miP);
                        WeakReference weakReference2 = new WeakReference(this.miQ);
                        cVar.mjx = charSequence;
                        cVar.mjy = i;
                        cVar.mjv = weakReference;
                        cVar.mjw = weakReference2;
                        miX.start();
                    }
                } else {
                    this.miQ.setVisibility(4);
                    this.miP.setText(bVar.mjk);
                }
            } else {
                this.miP.setVisibility(4);
                this.miQ.setVisibility(4);
            }
            if (bVar.mjd) {
                this.miO.setVisibility(0);
                this.miO.setImageResource(bVar.mjo);
            } else {
                this.miO.setVisibility(4);
            }
            if (bVar.mjh) {
                this.miT.setVisibility(0);
                this.miT.setText(bVar.mjp);
                this.miT.setOnClickListener(bVar.mjt);
            } else {
                this.miT.setVisibility(4);
            }
            if (bVar.mjj != null) {
                this.miM.setBackgroundDrawable(new BitmapDrawable(bVar.mjj));
            }
            if (this.miM.getVisibility() != 0) {
                this.miM.setVisibility(0);
                this.miM.startAnimation(this.miU);
                this.miU.setAnimationListener(new 2(this, bVar));
            }
        }
    }

    public final boolean aHh() {
        return this.miM.getVisibility() != 8;
    }

    public static b pA(int i) {
        return a(i, null, null, null, null, null, null);
    }

    public static b a(int i, String str, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(i, str, str2, null, str3, onClickListener, onClickListener2);
    }

    public static b a(int i, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        boolean z = true;
        b bVar = new b();
        bVar.mjo = i;
        bVar.mjk = str;
        bVar.mjb = str2 != null;
        bVar.mjl = str2;
        bVar.mjf = false;
        bVar.mjm = null;
        if (str4 == null) {
            z = false;
        }
        bVar.mje = z;
        bVar.mjn = str4;
        bVar.mjh = false;
        bVar.mjp = null;
        bVar.mjr = onClickListener;
        bVar.mjs = null;
        bVar.mju = onClickListener2;
        bVar.mjt = null;
        return bVar;
    }

    public static b a(b bVar, String str, OnClickListener onClickListener) {
        bVar.mjh = str != null;
        bVar.mjp = str;
        bVar.mjt = onClickListener;
        return bVar;
    }

    public static b a(Context context, OnClickListener onClickListener) {
        b a = a(a$d.mcC, context.getString(a$h.mdZ), null, context.getString(a$h.dEn), null, onClickListener);
        a.mjg = true;
        a.mji = context.getString(a$h.mdZ).length() - 3;
        return a;
    }
}
