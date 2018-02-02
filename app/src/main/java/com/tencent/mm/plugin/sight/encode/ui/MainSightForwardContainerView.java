package com.tencent.mm.plugin.sight.encode.ui;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sight.encode.a.b;
import com.tencent.mm.plugin.sight.encode.a.b.3;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

public class MainSightForwardContainerView extends RelativeLayout implements OnItemClickListener, a {
    private int mDuration;
    private boolean mIsPause;
    private boolean mIsPlaying;
    public View oiS;
    private Dialog qwA;
    private boolean qwB;
    public String qwC;
    private boolean qwD;
    public String qwE;
    public float qwF;
    private b qwG;
    private boolean qwH;
    public MMFragmentActivity qwI;
    private boolean qwJ;
    private c qwK;
    private boolean qwL;
    private MediaPlayer qwM;
    public MainSightSelectContactView qwu;
    public SightCameraView qwv;
    public b qww;
    public View qwx;
    public View qwy;
    public View qwz;

    public MainSightForwardContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qwA = null;
        this.mIsPlaying = false;
        this.qwB = true;
        this.qwC = "";
        this.qwD = false;
        this.qwE = "";
        this.mDuration = 1;
        this.qwF = 1.0f;
        this.mIsPause = false;
        this.qwG = new b();
        this.qwH = false;
        this.qwJ = false;
        this.qwK = new 5(this);
        this.qwL = false;
    }

    public MainSightForwardContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void aBM() {
        a.xef.c(this.qwK);
    }

    public final void btw() {
        boolean z = true;
        x.i("MicroMsg.MainSightContainerView", "toggle play video, path %s, mute %B, playing %B", new Object[]{this.qwE, Boolean.valueOf(this.qwB), Boolean.valueOf(this.mIsPlaying)});
        if (!this.qwv.isPlaying()) {
            this.qwB = true;
        }
        this.qwv.aB(this.qwE, this.qwB);
        if (this.qwB) {
            ii(true);
        } else {
            ii(false);
        }
        this.mIsPlaying = true;
        if (this.qwB) {
            z = false;
        }
        this.qwB = z;
    }

    public final boolean AI() {
        return !this.qwB;
    }

    private void ig(boolean z) {
        if (this.qwv != null) {
            this.qwv.ig(z);
        }
    }

    public final void ih(boolean z) {
        if (!this.qwD) {
            this.qwD = true;
            bh.hideVKB(this);
            this.mIsPlaying = false;
            this.qwB = true;
            x.d("MicroMsg.MainSightContainerView", "dismiss sight view");
            this.qwJ = false;
            this.qwv.btJ();
            if (this.qww != null && z) {
                this.qww.bty();
            }
            if (this.qwu != null) {
                View view = this.qwu;
                view.qwD = true;
                bh.hideVKB(view);
                view.qxi.btC();
                view.qxs.clear();
                view.qxr.clear();
                view.Fv.setAdapter(null);
                view.Fv.clearAnimation();
                view.setVisibility(8);
            }
            as(0.85f);
            btx();
            ii(false);
            this.qwC = "";
            aBM();
        }
    }

    public final void ii(boolean z) {
        if (this.qwH != z) {
            this.qwH = z;
            if (!z) {
                this.qwy.setVisibility(8);
                this.oiS.setVisibility(8);
            } else if (this.qwy.getVisibility() != 0) {
                this.qwv.postDelayed(new 4(this), 100);
            }
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = i - 1;
        if (MainSightSelectContactView.wo(i2) && this.mIsPlaying) {
            btw();
        } else if (c.Jw(this.qwu.hC(i2))) {
            this.qwu.qxi.btB();
        } else if (!c.Jv(this.qwu.hC(i2))) {
            x.d("MicroMsg.MainSightContainerView", "on item click Item : %d", new Object[]{Integer.valueOf(i2)});
            MainSightSelectContactView mainSightSelectContactView = this.qwu;
            if (i2 >= 0 && i2 <= mainSightSelectContactView.qxk.getCount()) {
                com.tencent.mm.ui.contact.a.a Gm = mainSightSelectContactView.qxk.Gm(i2);
                if (Gm != null) {
                    if (mainSightSelectContactView.qxs.contains(Gm.jLe.field_username)) {
                        mainSightSelectContactView.qxs.remove(Gm.jLe.field_username);
                    } else {
                        mainSightSelectContactView.qxs.add(Gm.jLe.field_username);
                    }
                    c.qwS = mainSightSelectContactView.qxs.isEmpty();
                    c.qwT = !mainSightSelectContactView.qxs.isEmpty();
                }
            }
            mainSightSelectContactView = this.qwu;
            if (mainSightSelectContactView.qxk != null) {
                mainSightSelectContactView.qxk.notifyDataSetChanged();
            }
            if (!AI()) {
                btw();
            } else if (this.qwu.btI()) {
                if (this.oiS.getVisibility() == 0) {
                    this.oiS.setVisibility(8);
                    this.oiS.startAnimation(AnimationUtils.loadAnimation(this.qwI, R.a.bqa));
                }
            } else if (this.oiS.getVisibility() != 0) {
                this.oiS.setVisibility(0);
                this.oiS.startAnimation(AnimationUtils.loadAnimation(this.qwI, R.a.bpZ));
            }
            if (this.qwu.qxi.btA()) {
                mainSightSelectContactView = this.qwu;
                boolean contains = mainSightSelectContactView.qxk.Gm(i2) == null ? false : mainSightSelectContactView.qxk.Gm(i2).jLe == null ? false : mainSightSelectContactView.qxs.contains(mainSightSelectContactView.qxk.Gm(i2).jLe.field_username);
                if (contains) {
                    this.qwu.qxi.btB();
                }
            }
        } else if (c.qwS) {
            this.qwJ = true;
            this.qwv.btJ();
            Context context = this.qwI;
            String Jp = d.Jp(this.qwE);
            String str = this.qwE;
            String str2 = this.qwC;
            x.i("MicroMsg.SightRecorderHelper", "share video path %s, thumb path %s", new Object[]{str, Jp});
            if (!e.bO(Jp)) {
                try {
                    com.tencent.mm.sdk.platformtools.d.a(d.R(str, 320, 240), 60, CompressFormat.JPEG, Jp, true);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SightRecorderHelper", e, "", new Object[0]);
                    x.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
                }
            }
            Intent intent = new Intent();
            intent.putExtra("KSightPath", str);
            intent.putExtra("KSightThumbPath", Jp);
            intent.putExtra("sight_md5", str2);
            intent.putExtra("KSightDraftEntrance", false);
            intent.putExtra("Ksnsupload_source", 0);
            intent.putExtra("KSnsPostManu", true);
            intent.putExtra("KTouchCameraTime", bh.Wo());
            com.tencent.mm.bm.d.b(context, "sns", ".ui.SightUploadUI", intent, 5985);
            if (this.qwL) {
                g.pQN.h(11442, new Object[]{Integer.valueOf(3), Integer.valueOf(3)});
            } else {
                g.pQN.h(11442, new Object[]{Integer.valueOf(1), Integer.valueOf(3)});
            }
        }
    }

    public final void aPD() {
        String str = "MicroMsg.MainSightContainerView";
        String str2 = "do send to friend, loadingDialog null %B";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.qwA == null);
        x.i(str, str2, objArr);
        if (!bh.ov(this.qwE) && !this.qwu.btI()) {
            String str3;
            boolean z;
            List<String> btH = this.qwu.btH();
            g.pQN.h(11443, new Object[]{Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(btH.size())});
            b.a 6 = new 6(this, btH);
            if (btH.size() == 1) {
                b bVar = this.qwG;
                String str4 = this.qwE;
                int i = this.mDuration;
                str3 = this.qwC;
                str2 = (String) btH.get(0);
                if (bh.ov(str4)) {
                    x.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
                    b.a(6, -1);
                } else if (bh.ov(str2)) {
                    x.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser null");
                    b.a(6, -1);
                } else if (!e.bO(str4) || e.bN(str4) <= 0) {
                    x.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                    h.bu(ac.getContext(), ac.getContext().getString(com.tencent.mm.plugin.ah.a.h.sdE));
                } else {
                    x.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[]{str3, com.tencent.mm.a.g.bV(str4)});
                    if (bh.az(str3, "").equals(com.tencent.mm.a.g.bV(str4))) {
                        com.tencent.mm.kernel.g.Dk();
                        if (com.tencent.mm.kernel.g.Dm().F(new 3(bVar, str2, 6, str4, i)) < 0) {
                            x.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                            b.a(6, -1);
                        }
                    } else {
                        x.e("MicroMsg.SightRecorderHelper", "error md5, return");
                        b.a(6, -1);
                    }
                }
            } else {
                b bVar2 = this.qwG;
                String str5 = this.qwE;
                int i2 = this.mDuration;
                String str6 = this.qwC;
                if (bh.ov(str5)) {
                    x.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
                    b.a(6, -1);
                } else if (btH.isEmpty()) {
                    x.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser list empty");
                    b.a(6, -1);
                } else if (!e.bO(str5) || e.bN(str5) <= 0) {
                    x.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                    h.bu(ac.getContext(), ac.getContext().getString(com.tencent.mm.plugin.ah.a.h.sdE));
                } else {
                    x.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[]{str6, com.tencent.mm.a.g.bV(str5)});
                    if (bh.az(str6, "").equals(com.tencent.mm.a.g.bV(str5))) {
                        com.tencent.mm.kernel.g.Dk();
                        if (com.tencent.mm.kernel.g.Dm().F(new b$4(bVar2, str5, btH, str6, 6, i2)) < 0) {
                            x.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                            b.a(6, -1);
                        }
                    } else {
                        x.e("MicroMsg.SightRecorderHelper", "error md5, return");
                        b.a(6, -1);
                    }
                }
            }
            if (this.qwu.btH().size() > 1 || this.qww == null) {
                z = true;
            } else {
                this.qww.Ju((String) this.qwu.btH().get(0));
                z = false;
            }
            if (this.qwI != null) {
                try {
                    AssetFileDescriptor openFd = this.qwI.getAssets().openFd("sight_send_song.wav");
                    this.qwM = new j();
                    this.qwM.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                    openFd.close();
                    this.qwM.setOnCompletionListener(new 7(this));
                    this.qwM.setLooping(false);
                    this.qwM.prepare();
                    this.qwM.start();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MainSightContainerView", e, "", new Object[0]);
                }
            }
            ih(z);
            for (String str32 : btH) {
                if (str32.toLowerCase().endsWith("@chatroom")) {
                    g.pQN.h(11442, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
                } else {
                    g.pQN.h(11442, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
                }
            }
        }
    }

    public final void onPause() {
        if (!this.qwJ) {
            this.qwv.setVisibility(0);
            ii(false);
            this.qwv.btJ();
            this.mIsPause = true;
        }
    }

    public final void onResume() {
        if (!this.qwD) {
            a.xef.c(this.qwK);
            a.xef.b(this.qwK);
        } else {
            aBM();
        }
        if (this.mIsPause) {
            btw();
            this.mIsPause = false;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && !this.qwD && this.qwu != null) {
            x.d("MicroMsg.MainSightContainerView", "change size l: %d, t: %d, r: %d, b: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            this.qwu.btF();
        }
    }

    @TargetApi(11)
    public final void as(float f) {
        float min = Math.min(1.0f, Math.max(0.0f, f));
        if (com.tencent.mm.compatible.util.d.fM(11)) {
            this.qwx.setAlpha(min);
        } else {
            Animation alphaAnimation = new AlphaAnimation(min, min);
            alphaAnimation.setDuration(0);
            alphaAnimation.setFillAfter(true);
            this.qwx.startAnimation(alphaAnimation);
        }
        x.d("MicroMsg.MainSightContainerView", "set alpha: %f", new Object[]{Float.valueOf(min)});
        if (min <= 0.0f) {
            this.qwx.setVisibility(8);
            Animation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(500);
            this.qwx.startAnimation(alphaAnimation2);
            return;
        }
        this.qwx.setVisibility(0);
    }

    public final void btx() {
        this.qwz.setVisibility(8);
    }

    public final void if(boolean z) {
        if (z) {
            this.qwz.setVisibility(0);
            ig(true);
            return;
        }
        btx();
        ig(AI());
    }

    public final void btu() {
        this.qwv.setVisibility(0);
        ii(true);
    }

    public final void btv() {
        this.qwv.setVisibility(4);
        ii(false);
    }

    public final int btt() {
        int height = getHeight();
        if (height <= 0) {
            return getResources().getDisplayMetrics().heightPixels;
        }
        return height;
    }
}
