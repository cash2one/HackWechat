package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.a.f;
import com.tencent.mm.z.a.g;
import java.util.HashSet;
import java.util.Set;

public final class c {
    private static String qNX = "0";
    private static Set<Long> qNY = new HashSet();
    private static OnClickListener qNZ;
    private static boolean qNm = false;
    private static com.tencent.mm.sdk.b.c qNv = new 1();

    static /* synthetic */ void ay(Context context, String str) {
        m Ll = ae.bvv().Ll(str);
        if (Ll != null) {
            String str2 = Ll.field_userName;
            Intent intent = new Intent();
            intent.putExtra("sns_permission_userName", str2);
            intent.putExtra("sns_permission_snsinfo_svr_id", Ll.field_snsId);
            intent.putExtra("sns_permission_block_scene", 7);
            intent.setClass(context, SnsPermissionUI.class);
            context.startActivity(intent);
        }
    }

    static /* synthetic */ void l(long j, boolean z) {
        if (qNm) {
            g.Ij().ie("6").hil = 3;
            g.Ij().ie("6").result = (z ? 2 : 1) + "|" + j;
            f.a(g.Ij().ie("6"));
            x.d("MicroMsg.SellerABTestManager", "endABTestWhenFinishBlock, snsSvrId:%d, isBlock:%b, scene:%d, actionResult:%s", new Object[]{Long.valueOf(j), Boolean.valueOf(z), Integer.valueOf(3), r0});
        }
    }

    public static void btU() {
        if (g.Ij().ie("6") != null) {
            qNX = g.Ij().ie("6").value;
            x.d("MicroMsg.SellerABTestManager", "startABTest, value:%s", new Object[]{qNX});
            qNm = true;
            a.xef.b(qNv);
            qNZ = new OnClickListener() {
                public final void onClick(View view) {
                    if (view.getTag() instanceof m) {
                        m mVar = (m) view.getTag();
                        if (mVar != null && !bh.ov(mVar.bxW())) {
                            c.ay(view.getContext(), mVar.bxW());
                        }
                    }
                }
            };
        }
    }

    public static void btV() {
        qNZ = null;
        a.xef.c(qNv);
        if (qNm) {
            g.Ij().ie("6").hil = 2;
            g.Ij().ie("6").result = qNY.size();
            f.a(g.Ij().ie("6"));
            x.d("MicroMsg.SellerABTestManager", "endABTestWhenExitTimeline, scene:%d, result:%s", new Object[]{Integer.valueOf(2), qNY.size()});
        }
        qNX = "0";
        qNm = false;
        qNY.clear();
    }

    public static void b(View view, com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (qNm) {
            cVar.rOn = false;
            cVar.rOl = (ViewStub) view.findViewById(i.f.qFk);
            cVar.rOl.setVisibility(8);
        }
    }
}
