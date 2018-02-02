package com.tencent.mm.modelvideo;

import com.tencent.mm.by.h.d;
import com.tencent.mm.g.a.jj;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.p;
import com.tencent.rtmp.TXLivePushConfig;
import java.util.HashMap;

public class n implements ap {
    public HashMap<String, a> hUV = new HashMap();
    private c<jj> hUW = new 3(this);

    static /* synthetic */ void bo(int i, int i2) {
        int i3;
        int i4;
        switch (i2) {
            case 1:
                i3 = 101;
                i4 = 107;
                break;
            case 2:
                i3 = 111;
                i4 = 117;
                break;
            case 4:
                i3 = 131;
                i4 = 137;
                break;
            case 5:
                i3 = 121;
                i4 = 127;
                break;
            default:
                return;
        }
        g.pQN.a(422, (long) bh.e((Integer) g.a(i / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600, MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN}, i3, i4)), 1, false);
        x.i("MicroMsg.SubCoreMediaRpt", "rptIdkey [%d] bitrate [%d] sendScene [%d]", new Object[]{Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public n() {
        a.xef.b(this.hUW);
    }

    public static n TS() {
        return (n) p.s(n.class);
    }

    public final void a(String str, String str2, String str3, String str4, String str5, int i, int i2) {
        a aVar = (a) this.hUV.get(str2);
        if (aVar == null) {
            aVar = new a(this);
        }
        aVar.hVi = str;
        aVar.hVj = str2;
        aVar.toUser = str3;
        aVar.gjF = str4;
        aVar.hVk = str5;
        aVar.hVm = i;
        aVar.hVl = i2;
        aVar.startTime = bh.Wp();
        this.hUV.put(str2, aVar);
        x.i("MicroMsg.SubCoreMediaRpt", "note video upload path[%s, %s] toUser %s msgSource %s snsInfoId %s sendScene %d cpStatus %d", new Object[]{str, str2, str3, str4, str5, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final void a(keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, String str) {
        if (com_tencent_mm_modelcdntran_keep_SceneResult != null && !bh.ov(str)) {
            com.tencent.mm.kernel.g.Dm().F(new 1(this, str, com_tencent_mm_modelcdntran_keep_SceneResult));
        }
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
    }
}
