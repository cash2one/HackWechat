package com.tencent.mm.plugin.favorite;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ab$b;
import com.tencent.mm.z.ab.a;
import com.tencent.mm.z.q;
import com.tencent.mm.z.u;
import java.util.ArrayList;

public final class d implements p {
    public static n ifs;
    public static m ift;

    public final void a(n nVar) {
        ifs = nVar;
    }

    public static void j(Intent intent, Context context) {
        intent.putExtra("geta8key_scene", 14);
        ifs.j(intent, context);
    }

    public static void a(long j, ux uxVar, String str, String str2, ArrayList<String> arrayList, Context context) {
        if (uxVar != null && context != null) {
            Intent intent = new Intent();
            intent.putExtra("KFavLocSigleView", true);
            intent.putExtra("map_view_type", 2);
            intent.putExtra("kFavInfoLocalId", j);
            intent.putExtra("kwebmap_slat", uxVar.lat);
            intent.putExtra("kwebmap_lng", uxVar.lng);
            intent.putExtra("kPoiName", uxVar.fDu);
            intent.putExtra("Kwebmap_locaion", uxVar.label);
            if (uxVar.fzv >= 0) {
                intent.putExtra("kwebmap_scale", uxVar.fzv);
            }
            intent.putExtra("kisUsername", str);
            intent.putExtra("kwebmap_from_to", true);
            intent.putExtra("kRemark", str2);
            intent.putExtra("kTags", arrayList);
            intent.putExtra("kFavCanDel", true);
            intent.putExtra("kFavCanRemark", true);
            ifs.o(intent, context);
        }
    }

    public static void c(String str, Context context) {
        if (bh.ov(str)) {
            x.w("MicroMsg.FavApplication", "share image to timeline fail, filePath is null");
            return;
        }
        Intent intent = new Intent();
        String str2 = "fav_" + q.FS() + "_0";
        String hz = u.hz(str2);
        u.GK().t(hz, true).o("prePublishId", str2);
        intent.putExtra("reportSessionId", hz);
        ifs.a(str, intent, context);
    }

    public static void d(String str, Context context) {
        if (bh.ov(str)) {
            x.w("MicroMsg.FavApplication", "share image to friend fail, imgPath is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        ifs.l(intent, context);
    }

    public static void a(String str, String str2, Context context) {
        if (bh.ov(str)) {
            x.w("MicroMsg.FavApplication", "save image fail, path is null");
        } else if (!com.tencent.mm.platformtools.d.a(str, context, R.l.dXO)) {
            Toast.makeText(context, str2, 1).show();
        }
    }

    public static String getAppName(Context context, String str) {
        ab$b com_tencent_mm_z_ab_b = a.hfJ;
        if (com_tencent_mm_z_ab_b != null) {
            return com_tencent_mm_z_ab_b.l(context, str);
        }
        return "";
    }

    public final void a(m mVar) {
        ift = mVar;
    }

    public static String dg(long j) {
        if (j == 0) {
            return "0KB";
        }
        if ((((double) j) * 1.0d) / 1048576.0d >= 1.0d) {
            return String.format("%dMB", new Object[]{Integer.valueOf((int) ((((double) j) * 1.0d) / 1048576.0d))});
        } else if ((((double) j) * 1.0d) / 1024.0d < 1.0d) {
            return "1KB";
        } else {
            return String.format("%dKB", new Object[]{Integer.valueOf((int) ((((double) j) * 1.0d) / 1024.0d))});
        }
    }
}
