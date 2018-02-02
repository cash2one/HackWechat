package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.g.a.fs;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements a {
    public c(Context context) {
        b fsVar = new fs();
        fsVar.fvc.opType = 3;
        fsVar.fvc.context = context;
        com.tencent.mm.sdk.b.a.xef.m(fsVar);
    }

    public final void a(a.a aVar) {
        x.d("MicroMsg.FavImageServiceProxy", "attachThumb favLocalId %s", new Object[]{Long.valueOf(aVar.pGd)});
        b fsVar = new fs();
        fsVar.fvc.opType = 1;
        fsVar.fvc.fvf = aVar.fvf;
        fsVar.fvc.fve = aVar.fve;
        fsVar.fvc.fqk = aVar.pGd;
        fsVar.fvc.fvg = aVar.fvg;
        fsVar.fvc.width = aVar.width;
        fsVar.fvc.height = aVar.height;
        com.tencent.mm.sdk.b.a.xef.m(fsVar);
    }

    public final Bitmap a(h$a$c com_tencent_mm_plugin_record_ui_h_a_c) {
        b fsVar = new fs();
        fsVar.fvc.opType = 0;
        fsVar.fvc.fve = com_tencent_mm_plugin_record_ui_h_a_c.fve;
        fsVar.fvc.fqk = com_tencent_mm_plugin_record_ui_h_a_c.pGd;
        com.tencent.mm.sdk.b.a.xef.m(fsVar);
        x.d("MicroMsg.FavImageServiceProxy", "getThumb favLocalId %s, retBmp %s", new Object[]{Long.valueOf(com_tencent_mm_plugin_record_ui_h_a_c.pGd), fsVar.fvd.fvk});
        return fsVar.fvd.fvk;
    }

    public final Bitmap a(h$a$b com_tencent_mm_plugin_record_ui_h_a_b) {
        b fsVar = new fs();
        fsVar.fvc.opType = 2;
        fsVar.fvc.fvj = false;
        if (com_tencent_mm_plugin_record_ui_h_a_b.fvh) {
            fsVar.fvc.fve = com_tencent_mm_plugin_record_ui_h_a_b.fve;
            fsVar.fvc.fvh = com_tencent_mm_plugin_record_ui_h_a_b.fvh;
        } else {
            fsVar.fvc.fve = com_tencent_mm_plugin_record_ui_h_a_b.fve;
            fsVar.fvc.fqk = com_tencent_mm_plugin_record_ui_h_a_b.pGd;
            fsVar.fvc.maxWidth = com_tencent_mm_plugin_record_ui_h_a_b.maxWidth;
            fsVar.fvc.fvi = com_tencent_mm_plugin_record_ui_h_a_b.fvi;
        }
        com.tencent.mm.sdk.b.a.xef.m(fsVar);
        x.d("MicroMsg.FavImageServiceProxy", "getSuitableBigImg favLocalId %s, dataId %s, retBmp %s, fromCache", new Object[]{Long.valueOf(com_tencent_mm_plugin_record_ui_h_a_b.pGd), com_tencent_mm_plugin_record_ui_h_a_b.fve.mvG, fsVar.fvd.fvk, Boolean.valueOf(fsVar.fvc.fvh)});
        return fsVar.fvd.fvk;
    }

    public final void bmV() {
        b fsVar = new fs();
        fsVar.fvc.opType = 4;
        com.tencent.mm.sdk.b.a.xef.m(fsVar);
    }
}
