package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.DisplayMetrics;
import com.tencent.mm.platformtools.b;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.j.a.a;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.io.InputStream;
import java.util.Map;
import junit.framework.Assert;

public final class c {
    a zas;

    c(a aVar) {
        this.zas = aVar;
    }

    public final int a(d dVar) {
        boolean z = true;
        Assert.assertTrue(dVar != null);
        if (dVar.zau == null) {
            z = false;
        }
        Assert.assertTrue(z);
        Drawable a = a(this.zas.vip, dVar.zat.getContext());
        if (a == null) {
            return -1;
        }
        dVar.zat.setBackgroundDrawable(a);
        dVar.zau.setVisibility(this.zas.vik ? 0 : 8);
        return 0;
    }

    private static Drawable a(Map<String, String> map, Context context) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        String str = (String) map.get(displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        if (str == null) {
            b bVar = new b();
            displayMetrics = context.getResources().getDisplayMetrics();
            Configuration configuration = context.getResources().getConfiguration();
            String str2 = "";
            str = displayMetrics.density < 1.0f ? str2 + "LDPI" : displayMetrics.density >= DownloadHelper.SAVE_FATOR ? str2 + "HDPI" : str2 + "MDPI";
            str = (String) map.get(str + (configuration.orientation == 2 ? "_L" : "_P"));
        }
        if (t.ou(str).length() <= 0) {
            return null;
        }
        a.a Sc = a.Sc(str);
        if (Sc == a.a.vit) {
            return null;
        }
        str = a.Sb(str);
        if (t.ou(str).length() <= 0) {
            return null;
        }
        try {
            Bitmap a;
            float density;
            if (Sc == a.a.vir) {
                InputStream open = context.getAssets().open(str);
                density = com.tencent.mm.bv.a.getDensity(context);
                b bVar2 = new b();
                a = d.a(open, density);
            } else {
                float density2 = com.tencent.mm.bv.a.getDensity(context);
                b bVar3 = new b();
                density = 160.0f * density2;
                a = d.c(str, density2);
                if (a != null) {
                    a.setDensity((int) density);
                }
            }
            if (a == null) {
                x.e("MicroMsg.ADListView.Message", "get Bitmap failed type:" + Sc + " path:" + str);
                return null;
            }
            byte[] ninePatchChunk = a.getNinePatchChunk();
            if (ninePatchChunk != null && NinePatch.isNinePatchChunk(ninePatchChunk)) {
                return new NinePatchDrawable(a, ninePatchChunk, new Rect(), null);
            }
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a, displayMetrics2.widthPixels, (displayMetrics2.widthPixels * a.getHeight()) / a.getWidth(), true);
            if (createScaledBitmap != null) {
                if (a != createScaledBitmap) {
                    x.i("MicroMsg.ADListView.Message", "recycle bitmap:%s", new Object[]{a});
                    a.recycle();
                }
                a = createScaledBitmap;
            }
            Drawable bitmapDrawable = new BitmapDrawable(a);
            bitmapDrawable.setTargetDensity(displayMetrics2);
            return bitmapDrawable;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ADListView.Message", e, "", new Object[0]);
            return null;
        }
    }
}
