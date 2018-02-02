package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.music.model.d;
import com.tencent.mm.plugin.music.model.d.a;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public final class b extends e implements a {
    int count;
    af oJw = new af(Looper.getMainLooper());
    boolean oLO;
    final int oNk = com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 26);
    final int oNl = com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), GameJsApiLaunchApplication.CTRL_BYTE);
    HashMap<Integer, View> oNm = new HashMap();
    d oNn = new d();
    int oNo;
    int scene;

    public b(Context context, int i, boolean z) {
        super(context);
        this.scene = i;
        this.oLO = z;
    }

    public final int getCount() {
        return this.count;
    }

    public final View a(View view, ViewGroup viewGroup, int i) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.i.doA, viewGroup, false);
            aVar = new a(this);
            aVar.oNr = (MusicItemLayout) view.findViewById(R.h.cyi);
            aVar.oNw = (TextView) view.findViewById(R.h.cyj);
            aVar.oNy = (LyricView) view.findViewById(R.h.cuz);
            aVar.oNs = view.findViewById(R.h.bJN);
            aVar.oNt = view.findViewById(R.h.bJO);
            aVar.oNu = view.findViewById(R.h.bJP);
            aVar.oNv = (CdnImageView) view.findViewById(R.h.bJM);
            aVar.oNx = (TextView) view.findViewById(R.h.cys);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        List list = h.bdz().oJB;
        int size = (i - 100000) % list.size();
        if (size < 0) {
            size += list.size();
        }
        x.d("MicroMsg.Music.MusicMainAdapter", "play music index %d", new Object[]{Integer.valueOf(size)});
        com.tencent.mm.av.a Gx = h.bdA().Gx((String) list.get(size));
        this.oNm.put(Integer.valueOf(i), view);
        aVar.h(Gx, false);
        return view;
    }

    public final void tM(int i) {
        this.oNm.remove(Integer.valueOf(i));
    }

    public final int beG() {
        return h.bdz().oJB.size();
    }

    public final void C(final int i, final long j) {
        ag.y(new Runnable(this) {
            final /* synthetic */ b oNq;

            public final void run() {
                View view = (View) this.oNq.oNm.get(Integer.valueOf(i));
                if (view != null) {
                    ((a) view.getTag()).oNy.dQ(j);
                }
            }
        });
    }

    public final void a(com.tencent.mm.av.a aVar, int[] iArr) {
        for (Entry value : this.oNm.entrySet()) {
            a aVar2 = (a) ((View) value.getValue()).getTag();
            if (aVar2.fAA.field_musicId.equals(aVar.field_musicId)) {
                x.i("MicroMsg.Music.MusicMainAdapter", "onColorReady: %s", new Object[]{aVar2.fAA.field_songName});
                int i = iArr[0];
                int i2 = iArr[1];
                aVar2.oNr.setBackgroundColor(i);
                LyricView lyricView = aVar2.oNy;
                lyricView.oMU.setColor(i2);
                lyricView.oMU.setAlpha(255);
                lyricView.oMV.setColor(i2);
                lyricView.oMV.setAlpha(127);
                aVar2.oNv.setBackgroundColor(i);
                ShaderFactory com_tencent_mm_plugin_music_ui_b_a_1 = new b$a$1(aVar2, i);
                Drawable paintDrawable = new PaintDrawable();
                paintDrawable.setShape(new RectShape());
                paintDrawable.setShaderFactory(com_tencent_mm_plugin_music_ui_b_a_1);
                aVar2.oNt.setBackgroundDrawable(paintDrawable);
                com_tencent_mm_plugin_music_ui_b_a_1 = new 2(aVar2, (i & 16777215) | 1426063360);
                Drawable paintDrawable2 = new PaintDrawable();
                paintDrawable2.setShape(new RectShape());
                paintDrawable2.setShaderFactory(com_tencent_mm_plugin_music_ui_b_a_1);
                aVar2.oNu.setBackgroundDrawable(paintDrawable2);
                aVar2.oNw.setTextColor(i2);
                aVar2.oNx.setTextColor(i2);
                ((MusicMainUI) this.context).q(aVar);
            }
        }
    }
}
