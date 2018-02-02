package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.s.a;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.protocal.c.bmf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.d;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;

public final class h extends a implements a, ak.a, d.a {
    private d jtl;
    private HashMap<String, i.a> yEI;
    private boolean yEJ;

    public h(b bVar) {
        super(bVar);
        this.yEJ = false;
        this.yEJ = false;
        this.yEI = new HashMap();
        o.TU().a(this, Looper.getMainLooper());
        this.jtl = new d();
    }

    public final boolean a(j jVar, au auVar, int i) {
        super.a(jVar, auVar, i);
        o.TU();
        Bitmap b = b.b(s.nu(auVar.field_imgPath), 1.0f);
        if (this.yEI != null) {
            this.yEI.put(auVar.field_imgPath, new i.a(auVar, i));
        }
        a(jVar, false);
        ((View) jVar.cvk().yGd).setVisibility(8);
        jVar.cvk().yGe.setImageBitmap(b);
        jVar.cvk().yGe.setVisibility(0);
        jVar.cvk().yGh.setVisibility(8);
        r nF = t.nF(auVar.field_imgPath);
        jVar.yGh.setTag(nF);
        bmf com_tencent_mm_protocal_c_bmf = nF == null ? null : nF.hVQ;
        if (com_tencent_mm_protocal_c_bmf == null) {
            jVar.mwd.setVisibility(8);
        } else if (com.tencent.mm.platformtools.t.ov(com_tencent_mm_protocal_c_bmf.hdo)) {
            x.i("MicroMsg.ImageGallerySightHandler", " there is no attachurl, show more info btn");
            CharSequence charSequence = com_tencent_mm_protocal_c_bmf.hdr;
            String str = com_tencent_mm_protocal_c_bmf.hds;
            if (bh.ov(charSequence) || bh.ov(str)) {
                jVar.mwd.setVisibility(8);
            } else {
                jVar.mwd.setText(charSequence);
                jVar.mwd.setVisibility(0);
                jVar.mwd.setTag(auVar);
            }
        } else {
            jVar.mwd.setVisibility(0);
            jVar.mwd.setText(this.yCR.yCS.getString(R.l.ePM, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bmf.weC)}));
            String string = this.yCR.yCS.getString(R.l.ePM);
            if (com_tencent_mm_protocal_c_bmf.weC / 60 > 0) {
                string = string + this.yCR.yCS.getString(R.l.ePO, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bmf.weC / 60)});
            }
            if (com_tencent_mm_protocal_c_bmf.weC % 60 > 0) {
                string = string + this.yCR.yCS.getString(R.l.ePP, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bmf.weC % 60)});
            }
            jVar.mwd.setText(string + this.yCR.yCS.getString(R.l.ePN));
            jVar.mwd.setTag(auVar);
        }
        if (jVar.cvk().yGd instanceof VideoSightView) {
            m.a(jVar.mwd, (VideoSightView) jVar.cvk().yGd);
        }
        return true;
    }

    public final void cuG() {
        SparseArray sparseArray = this.yCR.yeR;
        for (int i = 0; i < sparseArray.size(); i++) {
            int keyAt = sparseArray.keyAt(i);
            if (!(sparseArray.get(keyAt) == null || ((View) sparseArray.get(keyAt)).getTag() == null)) {
                j jVar = (j) ((View) sparseArray.get(keyAt)).getTag();
                if (jVar.yGc != null && jVar.cvk().yGc.getVisibility() == 0) {
                    jVar.cvk().yGd.a(null);
                    if (((View) jVar.cvk().yGd).getVisibility() == 0 && jVar != null) {
                        a(jVar, false);
                        if (jVar.cvk().yGd != null) {
                            jVar.cvk().yGd.stop();
                        }
                        x.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
                        this.jtl.bx(false);
                        this.yCR.yCS.mController.xIM.getWindow().clearFlags(FileUtils.S_IWUSR);
                    }
                }
            }
        }
    }

    public final void Ga(int i) {
        au FL = this.yCR.FL(i);
        j FJ = FJ(i);
        if (FL != null && FJ != null) {
            r nF = t.nF(FL.field_imgPath);
            if (nF != null) {
                if (FL.field_isSend == 0) {
                    if (nF.status == 113 || nF.status == 111 || nF.status == MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                        a(nF, FJ);
                        return;
                    } else if (nF.status == bc.CTRL_INDEX) {
                        a(nF, FJ);
                        return;
                    }
                }
                a(FL, FJ);
            }
        }
    }

    private void a(r rVar, j jVar) {
        if (rVar != null) {
            t.nD(rVar.getFileName());
            jVar.cvk().yGg.setVisibility(0);
            jVar.cvk().yGg.setProgress(t.f(rVar));
            o.TU().a(this, Looper.getMainLooper());
        }
    }

    private void a(au auVar, j jVar) {
        if (!this.yEJ) {
            jVar.cvk().yGh.setVisibility(8);
            o.TU();
            String nt = s.nt(auVar.field_imgPath);
            if (auVar.cjs()) {
                Toast.makeText(this.yCR.yCS, R.l.eTa, 0).show();
            } else if (nt == null || !e.bO(nt)) {
                Toast.makeText(this.yCR.yCS, R.l.eTa, 0).show();
            } else {
                this.yCR.yCS.mController.xIM.getWindow().addFlags(FileUtils.S_IWUSR);
                Boolean bool = (Boolean) jVar.yGb.get(nt);
                if (bool == null || !bool.booleanValue()) {
                    ((View) jVar.cvk().yGd).setTag(nt);
                    jVar.cvk().yGf.setVisibility(8);
                    jVar.cvk().yGd.stop();
                    if (this.yCR.yCS.gm(auVar.field_msgId) == 3) {
                        jVar.cvk().yGd.setMute(true);
                    } else {
                        jVar.cvk().yGd.setMute(false);
                    }
                    jVar.cvk().yGd.setVideoPath(nt);
                    if (jVar.cvk().yGd.k(this.yCR.yCS.mController.xIM, false)) {
                        ((View) jVar.cvk().yGd).setVisibility(0);
                        jVar.cvk().yGe.setVisibility(8);
                    } else {
                        jVar.cvk().yGf.setVisibility(0);
                        jVar.cvk().yGf.setOnClickListener(new 1(this, jVar));
                        ((View) jVar.cvk().yGd).setVisibility(8);
                        jVar.cvk().yGe.setVisibility(0);
                    }
                    x.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool requestFocus");
                    this.jtl.a(this);
                }
                ((View) jVar.cvk().yGd).setVisibility(0);
            }
        }
    }

    private static void a(j jVar, boolean z) {
        if (jVar != null) {
            jVar.cvk().yGg.setVisibility(8);
            if (z) {
                jVar.cvk().yGe.setVisibility(8);
                ((View) jVar.cvk().yGd).setVisibility(0);
                return;
            }
            jVar.cvk().yGe.setVisibility(0);
            ((View) jVar.cvk().yGd).setVisibility(8);
        }
    }

    public final boolean uF() {
        if (this.yCR != null) {
            j cuz = this.yCR.cuz();
            if (!(cuz == null || cuz.yGc == null || cuz.cvk().yGc.getVisibility() != 0)) {
                a(cuz, true);
            }
        }
        return false;
    }

    private boolean a(i.a aVar) {
        if (aVar == null) {
            return false;
        }
        o.TU().a(this);
        if (this.yCR.yCS.cuT() == aVar.pos) {
            j FJ = FJ(aVar.pos);
            if (FJ != null) {
                FJ.cvk().yGg.setVisibility(8);
            }
            return true;
        }
        this.yCR.FS(aVar.pos);
        return false;
    }

    public final void detach() {
        cuG();
        this.yCR.yCS.mController.xIM.getWindow().clearFlags(FileUtils.S_IWUSR);
        this.yEJ = true;
        super.detach();
        this.yEI.clear();
        this.yEI = null;
        o.TU().a(this);
        x.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
        this.jtl.bx(true);
    }

    public final void a(a.a aVar) {
        String str = aVar.fileName;
        if (!com.tencent.mm.platformtools.t.ov(str) && this.yEI != null) {
            i.a aVar2 = (i.a) this.yEI.get(str);
            if (aVar2 != null) {
                au auVar = aVar2.fnB;
                if (auVar != null && auVar.field_imgPath != null && auVar.field_imgPath.equals(str)) {
                    r nF = t.nF(auVar.field_imgPath);
                    if (nF == null) {
                        return;
                    }
                    if (!auVar.cjs() && nF.status != bc.CTRL_INDEX) {
                        int f = t.f(nF);
                        j FJ = FJ(aVar2.pos);
                        if (this.yCR.yCS.cuT() == aVar2.pos && FJ != null) {
                            FJ.cvk().yGg.setVisibility(0);
                            FJ.cvk().yGg.setProgress(f);
                        } else if (FJ == null) {
                            return;
                        }
                        if (f >= FJ.cvl().yGg.zua && a(aVar2)) {
                            a(auVar, FJ);
                        }
                    } else if (a(aVar2)) {
                        Toast.makeText(this.yCR.yCS, R.l.eTa, 0).show();
                    }
                }
            }
        }
    }
}
