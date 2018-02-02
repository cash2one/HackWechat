package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.aqt;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ar {
    public static int[] rDQ = new int[]{0, 0, 1, 3, 6, 9};
    public static int[] rDR = new int[]{f.qAT};
    public static int[] rDS = new int[]{f.qAT, f.qAU, f.qAV};
    public static int[] rDT = new int[]{f.qAT, f.qAU, f.qAV, f.qAW, f.qAX, f.qAY};
    public static int[] rDU = new int[]{f.qAT, f.qAU, f.qAV, f.qAW, f.qAX, f.qAY, f.qAZ, f.qBa, f.qBb};
    static double rDV = -1.0d;
    static double rDW = -1.0d;
    static double rDX = -1.0d;
    static double rDY = -1.0d;
    static double rDZ = -1.0d;
    private Context context;
    private LinkedList<LinearLayout> rEa = new LinkedList();

    public ar(Context context) {
        this.context = context;
    }

    public ar(Context context, byte b) {
        this.context = context;
    }

    public final void a(PhotosContent photosContent, bnp com_tencent_mm_protocal_c_bnp, String str, int i, int i2, int i3, boolean z, an anVar, boolean z2) {
        int[] iArr = rDU;
        if (i2 == 2 || i2 == 11) {
            iArr = rDR;
        } else if (i2 == 3) {
            iArr = rDS;
        } else if (i2 == 4) {
            iArr = rDT;
        } else if (i2 == 5) {
            iArr = rDU;
        }
        List list = com_tencent_mm_protocal_c_bnp.wQo.vYd;
        if (rDV < 0.0d) {
            rDV = (double) b.b(this.context, 160.0f);
            rDW = (double) b.b(this.context, 200.0f);
            rDX = (double) b.b(this.context, 44.0f);
            rDY = (double) b.b(this.context, 66.0f);
            rDZ = (double) b.b(this.context, 300.0f);
        }
        int size = list.size();
        if (size == 0) {
            for (size = 0; size < iArr.length; size++) {
                ae.bvs().cu(photosContent.xy(size));
                photosContent.xy(size).position = i3;
            }
            photosContent.setVisibility(8);
            return;
        }
        photosContent.setVisibility(0);
        if (size == 1) {
            for (size = 1; size < iArr.length; size++) {
                View xy = photosContent.xy(size);
                xy.setVisibility(8);
                ae.bvs().cu(xy);
                photosContent.xy(size).position = i3;
            }
            photosContent.xy(0).setVisibility(0);
            a((aqr) list.get(0), photosContent.xy(0), str, i, i3, z, anVar, i2, z2);
        }
    }

    public final void a(PhotosContent photosContent, bnp com_tencent_mm_protocal_c_bnp, String str, int i, int i2, int i3, boolean z, an anVar, List<aqt> list) {
        int[] iArr = rDU;
        if (i2 == 2 || i2 == 11) {
            iArr = rDR;
        } else if (i2 == 3) {
            iArr = rDS;
        } else if (i2 == 4) {
            iArr = rDT;
        } else if (i2 == 5) {
            iArr = rDU;
        }
        List list2 = com_tencent_mm_protocal_c_bnp.wQo.vYd;
        if (rDV < 0.0d) {
            rDV = (double) b.b(this.context, 160.0f);
            rDW = (double) b.b(this.context, 200.0f);
            rDX = (double) b.b(this.context, 44.0f);
            rDY = (double) b.b(this.context, 66.0f);
            rDZ = (double) b.b(this.context, 300.0f);
        }
        int size = list2.size();
        if (size == 0) {
            for (size = 0; size < iArr.length; size++) {
                ae.bvs().cu(photosContent.xy(size));
                photosContent.xy(size).position = i3;
            }
            photosContent.setVisibility(8);
            return;
        }
        photosContent.xx(ae.bvD());
        photosContent.setVisibility(0);
        if (size == 1) {
            for (size = 1; size < iArr.length; size++) {
                View xy = photosContent.xy(size);
                xy.setVisibility(8);
                ae.bvs().cu(xy);
                photosContent.xy(size).position = i3;
            }
            photosContent.xy(0).setVisibility(0);
            if (list == null || list.size() <= 0) {
                a((aqr) list2.get(0), photosContent.xy(0), str, i, i3, z, anVar, i2, false);
                return;
            }
            a((aqr) list2.get(0), photosContent.xy(0), str, i, i3, z, anVar, i2, false, (aqt) list.get(0));
        } else if (size == 4) {
            List arrayList = new ArrayList();
            int length = iArr.length - 1;
            int i4 = 3;
            while (length >= 0) {
                View xy2 = photosContent.xy(length);
                xy2.position = i3;
                if (length == 0 || length == 1 || length == 3 || length == 4) {
                    xy2.setVisibility(0);
                    arrayList.add(xy2);
                    ap apVar = new ap();
                    apVar.fus = str;
                    size = i4 - 1;
                    apVar.index = i4;
                    apVar.rBS = arrayList;
                    apVar.rzb = z;
                    apVar.position = i3;
                    xy2.setTag(apVar);
                    a((aqr) list2.get(apVar.index), xy2, i, anVar);
                    i4 = size;
                } else {
                    xy2.setVisibility(8);
                    ae.bvs().cu(xy2);
                }
                length--;
            }
        } else {
            List arrayList2 = new ArrayList();
            for (size = iArr.length - 1; size >= 0; size--) {
                View xy3 = photosContent.xy(size);
                xy3.position = i3;
                if (size < list2.size()) {
                    xy3.setVisibility(0);
                    arrayList2.add(xy3);
                    ap apVar2 = new ap();
                    apVar2.fus = str;
                    apVar2.index = size;
                    apVar2.rBS = arrayList2;
                    apVar2.rzb = z;
                    apVar2.position = i3;
                    xy3.setTag(apVar2);
                    a((aqr) list2.get(apVar2.index), xy3, i, anVar);
                } else {
                    xy3.setVisibility(8);
                    ae.bvs().cu(xy3);
                }
            }
        }
    }

    private static void a(aqr com_tencent_mm_protocal_c_aqr, QFadeImageView qFadeImageView, int i, an anVar) {
        ae.bvs().b(com_tencent_mm_protocal_c_aqr, qFadeImageView, i, anVar);
    }

    private static void a(aqr com_tencent_mm_protocal_c_aqr, QFadeImageView qFadeImageView, String str, int i, int i2, boolean z, an anVar, int i3, boolean z2, aqt com_tencent_mm_protocal_c_aqt) {
        if (qFadeImageView == null) {
            x.e("MicroMsg.SnsMultiLineImageLineMgr", "");
            return;
        }
        double min;
        ap apVar = new ap();
        apVar.fus = str;
        apVar.index = 0;
        List arrayList = new ArrayList();
        arrayList.add(qFadeImageView);
        apVar.rBS = arrayList;
        apVar.rzb = z;
        apVar.position = i2;
        qFadeImageView.setTag(apVar);
        double d = 0.0d;
        double d2 = 0.0d;
        if (i3 == 11 && z2) {
            ae.bvs().c(com_tencent_mm_protocal_c_aqr, qFadeImageView, i, anVar);
        } else {
            ae.bvs().a(com_tencent_mm_protocal_c_aqr, qFadeImageView, i, anVar);
        }
        if (com_tencent_mm_protocal_c_aqr.wxH != null) {
            d = (double) com_tencent_mm_protocal_c_aqr.wxH.wyu;
            d2 = (double) com_tencent_mm_protocal_c_aqr.wxH.wyv;
        }
        if (d <= 0.0d || d2 <= 0.0d) {
            d = rDV;
            d2 = rDV;
        } else {
            min = Math.min(rDW / d, rDW / d2);
            d *= min;
            d2 *= min;
            if (d < rDX) {
                min = (1.0d * rDX) / d;
                d *= min;
                d2 *= min;
            }
            if (d2 < rDX) {
                min = (1.0d * rDX) / d2;
                d *= min;
                d2 *= min;
            }
            if (d > rDW) {
                d = rDW;
            }
            if (d2 > rDW) {
                d2 = rDW;
            }
        }
        if (d < 1.0d) {
            d = 1.0d;
        }
        if (d2 < 1.0d) {
            d2 = 1.0d;
        }
        if (com_tencent_mm_protocal_c_aqt == null || com_tencent_mm_protocal_c_aqt.wyu <= 0.0f || com_tencent_mm_protocal_c_aqt.wyv <= 0.0f) {
            min = d;
            d = d2;
        } else {
            min = (double) com_tencent_mm_protocal_c_aqt.wyu;
            d = (double) com_tencent_mm_protocal_c_aqt.wyv;
        }
        if (qFadeImageView.getLayoutParams() instanceof LayoutParams) {
            LayoutParams layoutParams = (LayoutParams) qFadeImageView.getLayoutParams();
            if (((double) layoutParams.width) != min || ((double) layoutParams.height) != d) {
                qFadeImageView.setLayoutParams(new LayoutParams((int) min, (int) d));
            }
        }
    }

    private static void a(aqr com_tencent_mm_protocal_c_aqr, QFadeImageView qFadeImageView, String str, int i, int i2, boolean z, an anVar, int i3, boolean z2) {
        a(com_tencent_mm_protocal_c_aqr, qFadeImageView, str, i, i2, z, anVar, i3, z2, new aqt());
    }
}
