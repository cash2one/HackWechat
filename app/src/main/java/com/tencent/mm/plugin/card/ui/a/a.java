package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.e$a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.q;

public class a implements g {
    protected b kIK;
    protected e$a kRo;
    boolean kVW = false;
    private boolean kVX = false;
    private boolean kVY = false;
    private boolean kVZ = false;
    private boolean kWa = false;
    private boolean kWb = false;
    private boolean kWc = false;
    private boolean kWd = false;
    private boolean kWe = false;
    private boolean kWf = false;
    protected MMActivity kaY;

    public a(MMActivity mMActivity) {
        this.kaY = mMActivity;
    }

    public final void a(b bVar, e$a com_tencent_mm_plugin_card_ui_e_a) {
        this.kIK = bVar;
        this.kRo = com_tencent_mm_plugin_card_ui_e_a;
        awu();
    }

    public final void release() {
        this.kIK = null;
        this.kRo = null;
        this.kaY = null;
    }

    public final String awo() {
        String str = "";
        if (!TextUtils.isEmpty(this.kIK.atB().vSg)) {
            return this.kIK.atB().vSg;
        }
        if (this.kIK.atC().vRg == 0) {
            return getString(R.l.dOQ);
        }
        if (this.kIK.atC().vRh != 0) {
            return str;
        }
        if (TextUtils.isEmpty(this.kIK.atB().vRN)) {
            return getString(R.l.dNy);
        }
        return this.kIK.atB().vRN;
    }

    private String getString(int i) {
        return this.kaY.getString(i);
    }

    public final boolean awp() {
        if (this.kIK.atC().status == 0 || this.kIK.atC().status == 1 || this.kIK.atC().status == 2) {
            return true;
        }
        return false;
    }

    public final boolean awq() {
        return this.kRo.kFm == 3 || ((this.kRo.kFm == 6 && this.kIK.atC().vRd == 0) || this.kRo.kFm == 4 || this.kRo.kFm == 5 || this.kRo.kFm == 15);
    }

    private boolean awr() {
        return !TextUtils.isEmpty(this.kIK.atC().code);
    }

    protected final boolean aws() {
        return !this.kIK.isAcceptable() && (l.nY(this.kRo.kFm) || l.nZ(this.kRo.kFm) || this.kRo.kFm == 23);
    }

    protected final boolean awt() {
        return !this.kIK.aty() && this.kRo.kFm == 6;
    }

    protected void awu() {
        x.i("MicroMsg.CardBaseShowLogic", "updateAcceptState()");
        if (l.nY(this.kRo.kFm) || l.nZ(this.kRo.kFm)) {
            if (this.kIK.isAcceptable()) {
                this.kVX = true;
                this.kVY = true;
                this.kWd = true;
                this.kWb = true;
                this.kWc = true;
            } else if (this.kIK.isAcceptable()) {
                this.kVX = false;
                this.kVY = false;
                this.kWb = false;
            } else {
                this.kVX = true;
                this.kVY = false;
                if (this.kIK.atw()) {
                    this.kWe = true;
                    this.kWb = true;
                    this.kWa = true;
                } else {
                    this.kWb = false;
                }
                this.kWc = true;
            }
        } else if (this.kRo.kFm == 6) {
            if (this.kIK.aty()) {
                this.kVX = true;
                this.kVY = true;
                this.kWb = false;
            } else if (this.kIK.atx()) {
                this.kWe = true;
                this.kWb = true;
                this.kVZ = true;
                this.kWa = true;
            } else {
                this.kVX = false;
                this.kVY = false;
                this.kWb = false;
                this.kVZ = true;
            }
        } else if (l.oa(this.kRo.kFm)) {
            this.kVX = false;
            this.kVY = false;
            this.kVZ = true;
            if (this.kIK.atx()) {
                this.kWe = true;
                this.kWb = true;
                this.kWa = true;
            } else {
                this.kWf = true;
            }
        } else if (this.kRo.kFm == 23) {
            if (this.kIK.isAcceptable()) {
                this.kVX = true;
                this.kVY = true;
                this.kWb = false;
                this.kWc = true;
            } else {
                this.kVX = true;
                this.kVY = false;
                this.kWb = false;
                this.kWc = true;
            }
            if (!(TextUtils.isEmpty(this.kRo.kQw) || this.kRo.kQw.equals(q.FS()) || this.kIK.atA())) {
                x.i("MicroMsg.CardBaseShowLogic", " detail page");
                this.kVX = false;
                this.kVY = false;
                this.kVZ = true;
                if (this.kIK.atx()) {
                    this.kWe = true;
                    this.kWb = true;
                    this.kWa = true;
                }
            }
        }
        if (this.kIK.atw()) {
            this.kVX = false;
            this.kVY = false;
            x.i("MicroMsg.CardBaseShowLogic", "need direct jump!");
        } else {
            x.i("MicroMsg.CardBaseShowLogic", "not need direct jump!");
        }
        if (this.kVW) {
            this.kVX = false;
            this.kVY = false;
            x.i("MicroMsg.CardBaseShowLogic", "updateAcceptView to gone!");
        } else if (this.kVX) {
            this.kVW = false;
            x.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is false!");
        } else {
            this.kVW = true;
            x.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is true");
        }
        x.i("MicroMsg.CardBaseShowLogic", "mIsAcceptedCard:" + this.kVW);
    }

    public final boolean avT() {
        return this.kVW;
    }

    public boolean awv() {
        return this.kVX;
    }

    public final boolean aww() {
        return this.kVY;
    }

    public final boolean awx() {
        return this.kVZ;
    }

    public final boolean awy() {
        return this.kWa;
    }

    public final boolean awz() {
        return this.kWb;
    }

    public final boolean awA() {
        return this.kWd;
    }

    public final boolean awB() {
        return this.kWe;
    }

    public final boolean awC() {
        return this.kWf;
    }

    public boolean awD() {
        return true;
    }

    public boolean awE() {
        return false;
    }

    public boolean awF() {
        return false;
    }

    public boolean awG() {
        return (this.kRo.kFm == 6 && (!this.kIK.atx() || this.kIK.aty())) || this.kRo.kFm == 5 || (this.kRo.kFm == 23 && this.kIK.atA());
    }

    public boolean awH() {
        return false;
    }

    public boolean awI() {
        return true;
    }

    public boolean awJ() {
        return (awr() && awp() && awq()) || this.kVW;
    }

    public boolean awK() {
        return false;
    }

    public boolean awL() {
        return !this.kIK.atx();
    }

    public boolean awM() {
        return (this.kIK.atB().vSa == null || this.kIK.atB().vSa.vZa == null || this.kIK.atB().vSa.vZa.size() <= 0 || TextUtils.isEmpty((CharSequence) this.kIK.atB().vSa.vZa.get(0))) ? false : true;
    }

    public boolean awN() {
        if (this.kIK.atC().vRf == null || this.kIK.atC().vRf.size() <= 0 || ((!awp() || !awq()) && !this.kVW)) {
            return false;
        }
        return true;
    }

    public boolean awO() {
        return false;
    }

    public final boolean awP() {
        return (this.kIK.atC().vRj == null || TextUtils.isEmpty(this.kIK.atC().vRj.title)) ? false : true;
    }

    public boolean awQ() {
        return (this.kIK.atC().vRm == null || TextUtils.isEmpty(this.kIK.atC().vRm.title)) ? false : true;
    }

    public boolean awR() {
        return this.kIK.atB().vRW != null;
    }

    public boolean awS() {
        if (TextUtils.isEmpty(this.kIK.atB().vRT)) {
            return false;
        }
        return true;
    }

    public boolean awT() {
        return false;
    }

    public boolean awU() {
        return false;
    }

    public final void awV() {
        int i;
        int i2 = 1;
        String str = "MicroMsg.CardBaseShowLogic";
        String str2 = "printStatus, isValidCode:%d, getUnacceptWording:%s, isAcceptedCard:%d, acceptViewVisible:%d, acceptViewEnabled:%d, isShowConsumedBtn:%d, isConsumedBtnEnabled:%d, enableOptionMenu:%d, isShareLogoVisible:%d, addShareMenu:%d, addMenu:%d, addInvalidCardMenu:%d ";
        Object[] objArr = new Object[12];
        if (awr()) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        objArr[1] = awo();
        objArr[2] = Integer.valueOf(this.kVW ? 1 : 0);
        objArr[3] = Integer.valueOf(awv() ? 1 : 0);
        objArr[4] = Integer.valueOf(this.kVY ? 1 : 0);
        objArr[5] = Integer.valueOf(this.kVZ ? 1 : 0);
        objArr[6] = Integer.valueOf(this.kWa ? 1 : 0);
        objArr[7] = Integer.valueOf(this.kWb ? 1 : 0);
        objArr[8] = Integer.valueOf(this.kWc ? 1 : 0);
        objArr[9] = Integer.valueOf(this.kWd ? 1 : 0);
        objArr[10] = Integer.valueOf(this.kWe ? 1 : 0);
        if (!this.kWf) {
            i2 = 0;
        }
        objArr[11] = Integer.valueOf(i2);
        x.i(str, str2, objArr);
    }
}
