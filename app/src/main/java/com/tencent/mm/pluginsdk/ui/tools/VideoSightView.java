package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.util.AttributeSet;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.ah.a.h;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.3;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.c;
import com.tencent.mm.pluginsdk.ui.tools.f.d;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public class VideoSightView extends SightPlayImageView implements f {
    protected int duration = 0;
    private boolean kTc = false;
    protected String qtl;
    private boolean rmt;
    public boolean rmu = true;

    public VideoSightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public VideoSightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public VideoSightView(Context context) {
        super(context);
        init();
    }

    protected void init() {
        if (bh.az(q.gGe.gFv, "").equals("other")) {
            x.i("MicroMsg.VideoSightView", "init::use other player");
        } else {
            ia(true);
        }
        a(new 1(this));
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        x.v("MicroMsg.VideoSightView", "ashutest::on layout changed %B, %d %d %d %d %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(this.quH)});
        if (this.quH && i3 - i > 0) {
            wj(i3 - i);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.rmu) {
            wj(getResources().getDisplayMetrics().widthPixels);
        }
    }

    public boolean isPlaying() {
        return this.quA.bsK();
    }

    public final void setVideoPath(String str) {
        String str2 = "MicroMsg.VideoSightView";
        String str3 = "set sight path %s, callback null ? %B";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(this.quG == null);
        x.i(str2, str3, objArr);
        this.duration = 0;
        this.qtl = str;
        if (this.quG != null) {
            this.quG.hX();
        }
    }

    public void stop() {
        this.quA.clear();
    }

    public void pause() {
        aA(this.qtl, true);
    }

    public final void cP(boolean z) {
        if (this.quA != null) {
            this.quA.nDu = z;
        }
    }

    public final void a(a aVar) {
        this.quG = aVar;
    }

    public int getCurrentPosition() {
        x.v("MicroMsg.VideoSightView", "get current position");
        return 0;
    }

    public int getDuration() {
        int duration = super.getDuration();
        x.v("MicroMsg.VideoSightView", "get duration " + duration);
        return duration;
    }

    public final void onDetach() {
        com.tencent.mm.sdk.b.a.xef.c(this.quA.bsN());
    }

    public boolean start() {
        return k(getContext(), false);
    }

    public final boolean k(Context context, boolean z) {
        boolean z2 = false;
        if (this.qtl == null) {
            x.e("MicroMsg.VideoSightView", "start::use path is null!");
            return false;
        } else if (bh.az(q.gGe.gFv, "").equals("other") || !b.Jt(this.qtl)) {
            x.i("MicroMsg.VideoSightView", "start::use other player, path %s, has called %B", new Object[]{this.qtl, Boolean.valueOf(this.rmt)});
            if (this.rmt && !z) {
                return false;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(new File(this.qtl)), "video/*");
            try {
                context.startActivity(Intent.createChooser(intent, context.getString(h.sdA)));
            } catch (Exception e) {
                x.e("MicroMsg.VideoSightView", "startActivity fail, activity not found");
                com.tencent.mm.ui.base.h.bu(context, context.getResources().getString(h.eTc));
            }
            this.rmt = true;
            return false;
        } else {
            aA(this.qtl, false);
            if (!this.kTc) {
                z2 = true;
            }
            ia(z2);
            return true;
        }
    }

    public double btg() {
        if (this.quA == null) {
            return 0.0d;
        }
        b bVar = this.quA;
        return bVar.qtN != -1.0d ? bVar.qtN : bVar.qtK;
    }

    public void q(double d) {
        if (this.quA != null) {
            b bVar = this.quA;
            x.v("MicroMsg.SightPlayController", "seekToFrame now %f %s", new Object[]{Double.valueOf(d), bh.cgy().toString()});
            o.c(new 3(bVar, d), 0);
        }
    }

    public void id(boolean z) {
        if (z) {
            a(new 2(this));
        } else {
            a(null);
        }
    }

    public final long bth() {
        return 0;
    }

    public final void setMute(boolean z) {
        this.kTc = z;
        ia(!this.kTc);
    }

    public final void c(double d, boolean z) {
        q(d);
    }

    public final void a(e eVar) {
    }

    public final void a(c cVar) {
    }

    public final void a(f.b bVar) {
    }

    public final void a(d dVar) {
    }
}
