package com.tencent.mm.ui.chatting.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.az.n;
import com.tencent.mm.az.r;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class b {
    p fhr;
    private Bitmap yyE;
    private ImageView yyF;
    public final a yyG = new 1(this);

    public b(p pVar) {
        this.fhr = pVar;
    }

    public final void ctg() {
        if (this.yyE != null) {
            x.i("MicroMsg.ChattingUI.BackgroundImp", "recycle bitmap:%s", new Object[]{this.yyE.toString()});
            this.yyE.recycle();
        }
    }

    private int cth() {
        return this.fhr.csq().thisResources().getColor(R.e.brR);
    }

    public final void bSr() {
        if (this.fhr.csy() == null) {
            x.e("MicroMsg.ChattingUI.BackgroundImp", "initBackground, adapter is not initialized properly");
            return;
        }
        int intValue;
        com.tencent.mm.az.a lM = r.QI().lM(this.fhr.csi().field_username);
        if (lM == null) {
            ar.Hg();
            intValue = ((Integer) c.CU().get(12311, Integer.valueOf(-2))).intValue();
        } else {
            intValue = lM.hJl;
        }
        if (intValue == -2) {
            setBackgroundColor(cth());
            if (this.fhr.csy() == null) {
                this.fhr.csq().finish();
                return;
            } else {
                this.fhr.csy().bw(this.fhr.csq().getContext(), "chatting/purecolor_chat.xml");
                return;
            }
        }
        r.QH();
        int bn = n.bn(this.fhr.csq().getContext());
        if (intValue == 0) {
            switch (bn) {
                case 1:
                case 2:
                case 3:
                case 4:
                    intValue = R.g.bAY;
                    break;
                default:
                    intValue = -1;
                    break;
            }
            if (intValue != -1) {
                ctg();
                try {
                    this.yyE = BitmapFactory.decodeResource(this.fhr.csq().getMMResources(), intValue);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
                    throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e));
                } catch (Throwable th) {
                }
                if (this.yyE == null) {
                    x.e("MicroMsg.ChattingUI.BackgroundImp", "setBackground decodeFile fail, bm is null, resId = " + intValue);
                    setBackgroundColor(this.fhr.csq().getMMResources().getColor(R.e.brR));
                } else {
                    if (this.yyF == null) {
                        this.yyF = (ImageView) this.fhr.csq().findViewById(R.h.bTz);
                    }
                    this.yyF.setImageBitmap(this.yyE);
                }
                this.fhr.csy().bw(this.fhr.csq().getContext(), "chatting/reserved_chat.xml");
                return;
            }
            return;
        }
        String str;
        n QH = r.QH();
        if (intValue > 0) {
            this.fhr.csy().Za(QH.bh(intValue, 1) + "chat.xml");
            switch (bn) {
                case 1:
                    str = QH.bh(intValue, 1) + "horizontal_hdpi.jpg";
                    break;
                case 2:
                    str = QH.bh(intValue, 1) + "horizontal_ldpi.jpg";
                    break;
                case 3:
                    str = QH.bh(intValue, 1) + "vertical_hdpi.jpg";
                    break;
                case 4:
                    str = QH.bh(intValue, 1) + "vertical_ldpi.jpg";
                    break;
                default:
                    str = null;
                    break;
            }
        }
        this.fhr.csy().bw(this.fhr.csq().getContext(), "chatting/default_chat.xml");
        str = lM == null ? QH.Q("default", bn) : QH.Q(this.fhr.crz(), bn);
        ctg();
        this.yyE = j.op(str);
        if (this.yyE == null) {
            x.e("MicroMsg.ChattingUI.BackgroundImp", "setBackground decodeFile fail, bm is null, path = " + str);
            setBackgroundColor(cth());
            return;
        }
        if (this.yyF == null) {
            this.yyF = (ImageView) this.fhr.csq().findViewById(R.h.bTz);
        }
        this.yyF.setImageBitmap(this.yyE);
    }

    private void setBackgroundColor(int i) {
        ctg();
        if (this.yyF == null) {
            View findViewById = this.fhr.csq().findViewById(R.h.bTA);
            if (findViewById != null) {
                findViewById.setBackgroundColor(i);
                return;
            }
            return;
        }
        this.yyF.setImageDrawable(new ColorDrawable(i));
    }
}
