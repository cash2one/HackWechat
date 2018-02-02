package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a$a;
import com.tencent.mm.plugin.facedetect.a$d;
import com.tencent.mm.plugin.facedetect.a$e;
import com.tencent.mm.plugin.facedetect.a$g;
import com.tencent.mm.plugin.facedetect.a$h;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.plugin.facedetect.d.b.a;
import com.tencent.mm.plugin.facedetect.d.b.b;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.views.FaceNumberItemView;
import com.tencent.mm.plugin.facedetect.views.FaceNumberView;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class d implements b {
    boolean kMn;
    private View ltS;
    private String mhL;
    private int mhM;
    a mhN;
    String[] mhO;
    int mhP;
    int mhQ;
    private FaceNumberView mhR;
    private long mhS;
    private long mhT;
    boolean mhU;
    boolean mhV;
    boolean mhW;
    boolean mhX;
    private Animation mhY;
    private Animation mhZ;
    private a$b mhm;
    boolean mhx;
    private AnimationSet mia;
    private Animation mib;
    final Object mic;
    boolean mid;
    a mie;
    af mif;
    private CountDownTimer mig;
    Runnable mih;

    static /* synthetic */ void a(d dVar) {
        dVar.mhQ = 0;
        synchronized (dVar.mic) {
            dVar.mhW = false;
        }
        dVar.aHc();
        dVar.mhX = true;
        if (dVar.mhP == 0) {
            x.i("MicroMsg.NumberFaceMotion", "hy: triggered start record");
            a aVar = dVar.mhN;
            Runnable 6 = new 6(dVar);
            x.i("MicroMsg.FaceVoiceRecordLogic", "start record");
            e.b(new a.a(aVar, 6, (byte) 0), "FaceVoice_record", 10);
            g gVar = f.mgf.mgg.mil;
            if (gVar.mgj == null) {
                x.e("MicroMsg.FaceDetectNativeManager", "hy: startRecord not init");
            } else {
                gVar.mgj.engineStartRecord();
            }
        }
        ag.h(new 7(dVar), 2000);
    }

    static /* synthetic */ void b(d dVar) {
        long bA = bh.bA(dVar.mhT);
        x.i("MicroMsg.NumberFaceMotion", "hy: delta after request");
        if (bA < 0) {
            x.w("MicroMsg.NumberFaceMotion", "hy: too fast. regard as fake");
        } else if (bA < 1000) {
            x.w("MicroMsg.NumberFaceMotion", "hy: too fast. wait until normal");
            ag.h(new 8(dVar), 1000 - bA);
        } else {
            dVar.aHd();
        }
    }

    public d(String str) {
        this.mhL = null;
        this.mhM = 0;
        this.mhN = null;
        this.mhO = null;
        this.mhP = 0;
        this.mhQ = 0;
        this.ltS = null;
        this.mhR = null;
        this.mhx = false;
        this.mhS = -1;
        this.mhT = -1;
        this.mhU = false;
        this.mhV = false;
        this.mhW = false;
        this.mhX = false;
        this.mic = new Object();
        this.kMn = false;
        this.mid = false;
        this.mie = null;
        this.mif = new 1(this, Looper.getMainLooper());
        this.mig = new 2(this);
        this.mih = new 3(this);
        this.mhm = new 9(this);
        this.mhN = new a();
        this.mhN.mhm = this.mhm;
        this.mhY = AnimationUtils.loadAnimation(ac.getContext(), a$a.bqB);
        this.mhZ = AnimationUtils.loadAnimation(ac.getContext(), a$a.mcp);
        this.mib = AnimationUtils.loadAnimation(ac.getContext(), a$a.bpZ);
        this.mib.setDuration(250);
        this.mib.setFillAfter(true);
        this.mhL = str;
        this.mhM = this.mhL == null ? 0 : this.mhL.length();
        aHb();
        if (aHa()) {
            this.mia = (AnimationSet) AnimationUtils.loadAnimation(ac.getContext(), a$a.mcq);
        } else {
            this.mia = (AnimationSet) AnimationUtils.loadAnimation(ac.getContext(), a$a.mcr);
        }
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) ac.getResources().getDimensionPixelSize(c.mcw));
        translateAnimation.setDuration((long) ac.getContext().getResources().getInteger(com.tencent.mm.plugin.facedetect.a.f.mdB));
        this.mia.addAnimation(translateAnimation);
        x.i("MicroMsg.NumberFaceMotion", "hy: starting read number: %s", this.mhL);
    }

    private boolean aHa() {
        return this.mhM >= 6;
    }

    private void aHb() {
        int i = 0;
        if (bh.ov(this.mhL) || !aHa()) {
            this.mhO = new String[1];
            this.mhO[0] = this.mhL;
            return;
        }
        x.i("MicroMsg.NumberFaceMotion", "hy: data too long. need to split into %d rounds", Integer.valueOf(2));
        this.mhO = new String[2];
        int i2 = this.mhM / 2;
        while (i < 2) {
            this.mhO[i] = this.mhL.substring(i2 * i, (i + 1) * i2);
            i++;
        }
    }

    public final boolean aGU() {
        return this.mhx;
    }

    private TextView aGZ() {
        if (this.ltS != null) {
            return (TextView) this.ltS.findViewById(a$e.mdu);
        }
        return null;
    }

    public final void a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2) {
        x.d("MicroMsg.NumberFaceMotion", "hy: on number init motion");
        this.ltS = LayoutInflater.from(context).inflate(a$g.mdF, viewGroup2);
        this.mhR = (FaceNumberView) this.ltS.findViewById(a$e.mdo);
        cu(this.mhO.length, -1);
        aGZ().startAnimation(this.mhY);
        if (this.mhR != null) {
            this.mhR.setVisibility(0);
            this.mhR.startAnimation(this.mhY);
            this.mhP = 0;
            eU(false);
            this.mhQ = -1;
            aHc();
            this.mhS = bh.Wq();
            this.mhT = bh.Wq();
            this.kMn = false;
        }
    }

    private static String pz(int i) {
        switch (i) {
            case 1:
                return ac.getContext().getString(a$h.med);
            case 2:
                return ac.getContext().getString(a$h.mee);
            case 3:
                return ac.getContext().getString(a$h.meg);
            case 4:
                return ac.getContext().getString(a$h.meh);
            default:
                x.e("MicroMsg.NumberFaceMotion", "hy: unknown length!!");
                return "";
        }
    }

    private void cu(int i, int i2) {
        x.i("MicroMsg.NumberFaceMotion", "alvinluo groupIndex: %d, itemDataLength: %d", Integer.valueOf(i2), Integer.valueOf(i));
        if (aGZ() == null) {
            return;
        }
        if (i == 1) {
            aGZ().setText(ac.getContext().getString(a$h.mek));
            return;
        }
        CharSequence string;
        TextView aGZ = aGZ();
        if (i2 == -1) {
            String string2;
            Context context = ac.getContext();
            int i3 = a$h.mej;
            Object[] objArr = new Object[1];
            switch (i) {
                case 2:
                    string2 = ac.getContext().getString(a$h.mef);
                    break;
                default:
                    string2 = pz(i);
                    break;
            }
            objArr[0] = string2;
            string = context.getString(i3, objArr);
        } else {
            string = ac.getContext().getString(a$h.mei, new Object[]{pz(this.mhP + 1)});
        }
        aGZ.setText(string);
        if (i2 > 0) {
            x.i("MicroMsg.NumberFaceMotion", "alvinluo start %d group number", Integer.valueOf(i2 + 1));
            g gVar = f.mgf.mgg.mil;
            if (gVar.mgj == null) {
                x.e("MicroMsg.FaceDetectNativeManager", "hy: startRecord not init");
            } else {
                gVar.mgj.engineGroupChange();
            }
        }
    }

    final void eU(boolean z) {
        if (this.mhR != null) {
            cu(this.mhO.length, this.mhP);
            FaceNumberView faceNumberView = this.mhR;
            int length = this.mhO[this.mhP].length();
            if (length > 12) {
                x.e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed max length: %d", Integer.valueOf(length));
            } else if (length <= 0) {
                x.e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed min length: %d", Integer.valueOf(length));
            } else if (length == faceNumberView.mnd) {
                x.i("MicroMsg.Facing.MMPwdInputView", "hy: already correct length. quit");
                faceNumberView.zP(null);
            } else {
                faceNumberView.mnb.removeAllViews();
                faceNumberView.mnd = length;
                faceNumberView.mnc = new FaceNumberItemView[faceNumberView.mnd];
                for (int i = 0; i < length; i++) {
                    int i2;
                    int dimensionPixelSize;
                    FaceNumberItemView faceNumberItemView = (FaceNumberItemView) FaceNumberView.inflate(faceNumberView.getContext(), a$g.mdH, null);
                    faceNumberItemView.setImageResource(a$d.mcO);
                    if (i == 0) {
                        i2 = 3;
                        dimensionPixelSize = (faceNumberView.getResources().getDimensionPixelSize(c.mcy) + com.tencent.mm.bv.a.fromDPToPix(faceNumberView.getContext(), 48)) / 2;
                    } else if (i == length - 1) {
                        i2 = 5;
                        dimensionPixelSize = (faceNumberView.getResources().getDimensionPixelSize(c.mcy) + com.tencent.mm.bv.a.fromDPToPix(faceNumberView.getContext(), 48)) / 2;
                    } else {
                        i2 = 17;
                        dimensionPixelSize = faceNumberView.getResources().getDimensionPixelSize(c.mcy);
                    }
                    x.i("MicroMsg.FaceNumberItemView", "hy: setting gravity");
                    faceNumberItemView.mmU = i2;
                    faceNumberView.mnc[i] = faceNumberItemView;
                    faceNumberView.mnb.addView(faceNumberItemView, new LayoutParams(dimensionPixelSize, faceNumberView.getResources().getDimensionPixelSize(c.mcx)));
                }
            }
            this.mhX = false;
            if (z) {
                this.mhY.setAnimationListener(new 4(this));
                if (this.ltS != null) {
                    this.ltS.startAnimation(this.mhY);
                    return;
                }
                return;
            }
            ag.h(new 5(this), 500);
        }
    }

    final void aHc() {
        if (this.mhR == null) {
            return;
        }
        if (this.mhP >= 0) {
            this.mhR.zP(this.mhO[this.mhP].substring(0, this.mhQ + 1));
        } else {
            this.mhR.zP(null);
        }
    }

    public final boolean aGV() {
        this.mhV = true;
        return this.mid;
    }

    public final boolean a(FaceCharacteristicsResult faceCharacteristicsResult) {
        this.mhV = true;
        return this.mid;
    }

    public final boolean b(FaceCharacteristicsResult faceCharacteristicsResult) {
        this.mhV = false;
        return this.mid;
    }

    public final void aGW() {
        this.kMn = true;
        this.mid = false;
        a aVar = this.mhN;
        aVar.mhn = true;
        x.i("MicroMsg.FaceVoiceRecordLogic", "hy: face start reset");
        synchronized (aVar) {
            if (aVar.fkb != null) {
                aVar.fkb.vi();
                aVar.fkb = null;
            }
            if (aVar.hYu != null) {
                aVar.hYu.vE();
                aVar.hYu = null;
            }
            if (aVar.hYA != null) {
                try {
                    aVar.hYA.release();
                    aVar.hYA = null;
                    aVar.hYW = true;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", e, "mVoiceSilentDetectAPI.release error", new Object[0]);
                }
            }
            aVar.hYp = 0;
        }
        a aVar2 = this.mhN;
        x.i("MicroMsg.FaceVoiceRecordLogic", "hy: recycling voice.");
        aVar2.mhm = null;
        this.mhN.aGS();
        if (com.tencent.mm.plugin.facedetect.e.a.aHt().mkZ && com.tencent.mm.plugin.facedetect.e.a.aHt().isStarted()) {
            this.mhN.mhp.remove(com.tencent.mm.plugin.facedetect.e.a.aHt().aHu());
            if (this.mhx) {
                com.tencent.mm.plugin.facedetect.e.a.aHt().a(null);
            } else {
                com.tencent.mm.plugin.facedetect.e.a.aHt().aHv();
            }
        }
        this.mig.cancel();
        this.mif.removeCallbacksAndMessages(null);
        if (this.mhR != null) {
            FaceNumberView faceNumberView = this.mhR;
            if (faceNumberView.mnc != null && faceNumberView.mnc.length > 0) {
                for (FaceNumberItemView aHG : faceNumberView.mnc) {
                    aHG.aHG();
                }
            }
        }
        if (this.ltS != null) {
            this.mhx = false;
            this.mhS = -1;
            this.ltS = null;
            this.mhR = null;
        }
    }

    public final b aGX() {
        return new b(90004, "user cancelled in processing");
    }

    public final a aGY() {
        return this.mie;
    }

    final void aHd() {
        this.mig.start();
    }
}
