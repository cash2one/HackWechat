package com.tencent.mm.plugin.exdevice.model;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.y;
import com.tencent.mm.av.c;
import com.tencent.mm.bv.a;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.or;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.IOException;
import java.util.List;

public final class ac {
    private Context context;
    boolean hnr;
    boolean lNA;
    Dialog lNB;
    private View lNu;
    private TextView lNv;
    private TextView lNw;
    private TextView lNx;
    private TextView lNy;
    private View lNz;
    private int width;

    public static final String cw(Context context) {
        return new File(context.getCacheDir(), "sport_share_bitmap.jpg").getAbsolutePath();
    }

    public final void a(Context context, String str, String str2, String str3, a aVar) {
        if (!this.lNA) {
            this.lNA = true;
            this.hnr = false;
            if (this.lNB == null && !bh.ov(str3)) {
                context.getString(R.l.dGO);
                this.lNB = h.a(context, context.getString(R.l.edL), true, new 1(this));
                this.lNB.show();
            }
            this.context = context;
            this.width = 1280;
            if (this.width > a.eA(context)) {
                this.width = a.eA(context);
            }
            this.lNu = LayoutInflater.from(context).inflate(R.i.dhk, null);
            this.lNv = (TextView) this.lNu.findViewById(R.h.cfw);
            this.lNw = (TextView) this.lNu.findViewById(R.h.cfu);
            this.lNx = (TextView) this.lNu.findViewById(R.h.cfF);
            this.lNy = (TextView) this.lNu.findViewById(R.h.cfE);
            this.lNz = this.lNu.findViewById(R.h.bMP);
            this.lNv.setText(str);
            this.lNx.setText(str2);
            b.a((ImageView) this.lNu.findViewById(R.h.bLD), q.FS(), 0.5f, false);
            ImageView imageView = (ImageView) this.lNu.findViewById(R.h.bMN);
            this.lNu.setLayoutParams(new LayoutParams(-1, -1));
            this.lNu.measure(MeasureSpec.makeMeasureSpec(this.width, 1073741824), MeasureSpec.makeMeasureSpec(this.width, 1073741824));
            this.lNu.layout(0, 0, this.width, this.width);
            if (bh.ov(str3)) {
                imageView.setImageResource(R.e.brW);
                aVar.yU(v(null));
                this.lNA = false;
                return;
            }
            ad.aEn().a(str3, imageView, new 2(this, aVar));
        }
    }

    final String v(Bitmap bitmap) {
        int[] o;
        if (bitmap != null) {
            o = c.o(bitmap);
        } else {
            o = new int[]{-1, WebView.NIGHT_MODE_COLOR};
        }
        ShaderFactory 3 = new 3(this, o);
        Drawable paintDrawable = new PaintDrawable();
        paintDrawable.setShape(new RectShape());
        paintDrawable.setShaderFactory(3);
        this.lNz.setBackgroundDrawable(paintDrawable);
        this.lNv.setTextColor(o[1]);
        this.lNw.setTextColor(o[1]);
        this.lNx.setTextColor(o[1]);
        this.lNy.setTextColor(o[1]);
        Bitmap createBitmap = Bitmap.createBitmap(this.width, this.width, Config.ARGB_8888);
        this.lNu.draw(new Canvas(createBitmap));
        File file = new File(cw(this.context));
        if (file.exists()) {
            file.delete();
        }
        try {
            d.a(createBitmap, 100, CompressFormat.JPEG, file.getAbsolutePath(), true);
        } catch (IOException e) {
        }
        return file.getAbsolutePath();
    }

    public static boolean a(Context context, String str, String str2, String str3, String str4) {
        y.Mf();
        List hs = e.hs(1);
        String str5 = hs.size() > 0 ? (String) hs.get(0) : null;
        IMediaObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(str2);
        String gu = r.gu(str5);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.title = gu;
        wXMediaMessage.description = str4;
        wXMediaMessage.setThumbImage(d.decodeFile(str2, null));
        com.tencent.mm.sdk.b.b opVar = new op();
        opVar.fGx.fzc = wXMediaMessage;
        opVar.fGx.appId = "wx7fa037cc7dfabad5";
        opVar.fGx.appName = context.getString(R.l.edR);
        opVar.fGx.toUser = str;
        opVar.fGx.fGy = 2;
        if (bh.ov(str5)) {
            opVar.fGx.fGB = null;
        } else {
            opVar.fGx.fGz = str5;
            opVar.fGx.fGA = gu;
        }
        boolean m = com.tencent.mm.sdk.b.a.xef.m(opVar);
        if (!bh.ov(str3)) {
            com.tencent.mm.sdk.b.b orVar = new or();
            orVar.fGI.fGJ = str;
            orVar.fGI.content = str3;
            orVar.fGI.type = s.hp(str);
            orVar.fGI.flags = 0;
            com.tencent.mm.sdk.b.a.xef.m(orVar);
        }
        return m;
    }
}
