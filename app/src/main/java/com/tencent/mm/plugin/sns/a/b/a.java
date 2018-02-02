package com.tencent.mm.plugin.sns.a.b;

import android.view.View;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bg;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public String fus = "";
    long hOu = 0;
    public String hOv = "";
    private String iTh = "";
    boolean kMn = false;
    public int lXR = 0;
    int position = 0;
    long qOA = 0;
    private int qOB = -10086;
    private int qOC = -10086;
    long qOD = 0;
    int qOE = 0;
    int qOF = -1;
    int qOG = -1;
    int qOH = 0;
    int qOI = 0;
    int qOJ = 0;
    private boolean qOK = false;
    private int qOL = 0;
    boolean qOb = false;
    public bjv qOc;
    public View qOd;
    public View qOe;
    public int qOf = 0;
    public int qOg = 0;
    public int qOh;
    private View qOi;
    private int qOj = 0;
    private com.tencent.mm.plugin.sns.storage.a qOk = null;
    b qOl;
    int qOm = -10086;
    private int qOn = -10086;
    int qOo = -10086;
    private int qOp = -10086;
    long qOq = 0;
    long qOr = 0;
    private int qOs = -10086;
    private int qOt = -10086;
    long qOu = 0;
    private int qOv = -10086;
    private int qOw = -10086;
    long qOx = 0;
    private int qOy = -10086;
    private int qOz = -10086;
    public int sceneType = 1;

    public a(com.tencent.mm.plugin.sns.storage.a aVar, String str, long j, View view, int i, View view2, int i2, int i3, bjv com_tencent_mm_protocal_c_bjv, int i4, b bVar) {
        this.position = i4;
        this.qOd = view;
        this.qOc = com_tencent_mm_protocal_c_bjv;
        this.qOl = bVar;
        this.qOk = aVar;
        this.sceneType = i3;
        this.iTh = aVar == null ? "" : bh.az(aVar.iTh, "");
        this.hOv = aVar == null ? "" : bh.az(aVar.qZM, "");
        this.fus = str;
        this.hOu = j;
        this.qOh = i;
        this.qOi = view2;
        this.qOj = i2;
        if (this.qOd != null) {
            this.qOe = this.qOd.findViewById(f.qBh);
        }
        initView();
    }

    private void initView() {
        if (this.lXR == 0 && this.qOd != null) {
            BackwardSupportUtil.b.b(this.qOd.getContext(), 50.0f);
            this.lXR = this.qOd.getHeight();
            if (this.qOe != null) {
                this.qOf = this.qOe.getHeight();
            }
            if (this.lXR != 0) {
                int i = 0;
                if (this.qOi != null) {
                    i = this.qOi.getBottom();
                }
                this.lXR -= this.qOf;
                this.qOg = this.lXR / 2;
                this.qOh = (this.qOh - i) - this.qOj;
                x.i("MicroMsg.AdViewStatic", "viewHeight " + this.lXR + " SCREEN_HEIGHT: " + this.qOh + " abottom: " + i + " stHeight: " + this.qOj + " commentViewHeight:" + this.qOf);
            }
        }
    }

    public final void btW() {
        boolean z = true;
        if (this.qOd != null) {
            initView();
            if (!this.kMn && this.lXR > 0) {
                int bottom;
                int i;
                this.qOb = true;
                int top = this.qOd.getTop();
                int bottom2 = this.qOd.getBottom() - this.qOf;
                if (!this.qOK) {
                    int[] iArr = new int[2];
                    this.qOd.getLocationOnScreen(iArr);
                    if (this.qOi != null) {
                        bottom = this.qOi.getBottom();
                    } else {
                        bottom = 0;
                    }
                    this.qOL = top - ((iArr[1] - bottom) - this.qOj);
                    this.qOK = true;
                }
                top -= this.qOL;
                bottom2 -= this.qOL;
                if (top < 0 || bottom2 > this.qOh) {
                    this.qOJ = 0;
                } else {
                    this.qOJ = 1;
                }
                if (this.qOm == -10086 && this.qOn == -10086) {
                    this.qOm = top;
                    this.qOn = bottom2;
                }
                this.qOo = top;
                this.qOp = bottom2;
                if (top < 0) {
                    i = top + this.lXR;
                    int i2 = this.lXR - i;
                    if (i < this.qOg || this.qOs != -10086) {
                        boolean z2 = true;
                    } else {
                        this.qOs = top;
                        this.qOt = bottom2;
                        this.qOu = System.currentTimeMillis();
                        x.i("MicroMsg.AdViewStatic", "up first touch half" + i + " top " + top + " viewhieght " + this.lXR + " inscreenval: " + i + " outscreenval: " + i2);
                        bottom = 0;
                    }
                    if (i2 >= this.qOg && this.qOv == -10086 && r0 != 0 && this.qOu > 0) {
                        this.qOv = top;
                        this.qOw = bottom2;
                        this.qOx = System.currentTimeMillis();
                        x.i("MicroMsg.AdViewStatic", "down first touch half" + i + " bottom " + bottom2 + " viewhieght " + this.lXR + " inscreenval: " + i + " outscreenval: " + i2);
                    }
                }
                if (bottom2 > this.qOh) {
                    bottom = bottom2 - this.qOh;
                    i = this.lXR - bottom;
                    if (i >= this.qOg && this.qOs == -10086) {
                        this.qOs = top;
                        this.qOt = bottom2;
                        this.qOu = System.currentTimeMillis();
                        x.i("MicroMsg.AdViewStatic", "up first touch half" + bottom + " top " + top + " viewhieght " + this.lXR + " inscreenval: " + i + " outscreenval: " + bottom);
                        z = false;
                    }
                    if (bottom >= this.qOg && this.qOv == -10086 && r2 && this.qOu > 0) {
                        this.qOv = top;
                        this.qOw = bottom2;
                        this.qOx = System.currentTimeMillis();
                        x.i("MicroMsg.AdViewStatic", "down first touch half" + bottom + " bottom " + bottom2 + " viewhieght " + this.lXR + " inscreenval: " + i + " outscreenval: " + bottom);
                    }
                }
                if (top < 0 || bottom2 > this.qOh) {
                    if (this.qOD == 0 && this.qOA != 0) {
                        this.qOB = top;
                        this.qOC = bottom2;
                        this.qOD = System.currentTimeMillis();
                    }
                } else if (this.qOA == 0) {
                    this.qOy = top;
                    this.qOz = bottom2;
                    this.qOA = System.currentTimeMillis();
                }
                if (top < 0) {
                    bottom = -top;
                    if (this.qOF == -1 || this.qOF > bottom) {
                        this.qOF = bottom;
                    }
                } else {
                    this.qOF = 0;
                }
                if (bottom2 > this.qOh) {
                    bottom = bottom2 - this.qOh;
                    if (this.qOG == -1 || this.qOG > bottom) {
                        this.qOG = bottom;
                    }
                } else {
                    this.qOG = 0;
                }
                bottom = this.lXR;
                if (top < 0) {
                    bottom += top;
                }
                if (bottom2 > this.qOh) {
                    bottom -= bottom2 - this.qOh;
                }
                if (this.qOE == -1 || this.qOE < bottom) {
                    this.qOE = bottom;
                }
            }
        }
    }

    public final bg btX() {
        bg bgVar = new bg();
        m eR = ae.bvv().eR(this.hOu);
        if (eR != null) {
            bjv n = ai.n(eR);
            if (n != null) {
                bgVar.vGx = n.wNd.size();
                bgVar.csU = n.wNa.size();
                return bgVar;
            }
        }
        if (this.qOc == null) {
            return null;
        }
        bgVar.vGx = this.qOc.wNc;
        bgVar.csU = this.qOc.wMZ;
        return bgVar;
    }
}
