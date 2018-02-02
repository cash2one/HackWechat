package com.tencent.mm.plugin.card.ui.view;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bs.a.a;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public abstract class g extends i {
    String code;
    private Bitmap inI;
    protected b kIK;
    private Bitmap kNH;
    private OnLongClickListener kNQ = new 1(this);
    private j kRf;
    private ViewGroup kWs;
    private ab kWt;
    private ViewStub kWu;
    MMActivity kaY;

    public abstract ab axb();

    public abstract ab axc();

    public abstract ab axd();

    public abstract String e(c cVar);

    public abstract boolean h(b bVar);

    public final void initView() {
        this.kaY = this.kWz.avL();
        this.kRf = this.kWz.avR();
        this.kIK = this.kWz.avI();
        if (this.kIK == null) {
            x.e("MicroMsg.CardBaseCodeView", "initView failure! cardInfo is null!");
            return;
        }
        switch (this.kIK.atC().vRe) {
            case 0:
                this.kWt = axd();
                break;
            case 1:
                this.kWt = axc();
                break;
            case 2:
                this.kWt = axb();
                break;
            default:
                this.kWt = axb();
                break;
        }
        if (this.kWt == null) {
            x.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
            return;
        }
        switch (this.kIK.atC().vRe) {
            case 0:
                if (this.kWu == null) {
                    this.kWu = (ViewStub) findViewById(R.h.bQf);
                    break;
                }
                break;
            case 1:
                if (this.kWu == null) {
                    this.kWu = (ViewStub) findViewById(R.h.bPI);
                    break;
                }
                break;
            case 2:
                if (this.kWu == null) {
                    this.kWu = (ViewStub) findViewById(R.h.bRN);
                    break;
                }
                break;
            default:
                if (this.kWu == null) {
                    this.kWu = (ViewStub) findViewById(R.h.bRN);
                    break;
                }
                break;
        }
        if (this.kWu == null) {
            x.e("MicroMsg.CardBaseCodeView", "initTargetView failure! viewStub is null!");
        } else if (this.kWt == null) {
            x.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
        } else if (this.kWt.getLayoutId() == 0) {
            x.e("MicroMsg.CardBaseCodeView", "initTargetView failure! codeContainer.getLayoutId()  is 0!");
        } else {
            this.kWu.setLayoutResource(this.kWt.getLayoutId());
            if (this.kWs == null) {
                this.kWs = (ViewGroup) this.kWu.inflate();
            }
        }
        if (this.kWs == null) {
            x.e("MicroMsg.CardBaseCodeView", "iniView failure! targetView is null!");
        }
    }

    public final void d(b bVar) {
        if (bVar == null) {
            x.e("MicroMsg.CardBaseCodeView", "updateCardInfo failure! mCardInfo is null!");
        } else {
            this.kIK = bVar;
        }
    }

    public final void destroy() {
        super.destroy();
        this.kaY = null;
        this.kRf = null;
        this.kIK = null;
        this.kWs = null;
        this.kWt = null;
        l.u(this.inI);
        l.u(this.kNH);
    }

    public final void update() {
        if (this.kIK == null) {
            x.e("MicroMsg.CardBaseCodeView", "update  failure! mCardInfo is null!");
        } else if (this.kWt == null) {
            x.e("MicroMsg.CardBaseCodeView", "update failure! codeContainer is null!");
        } else if (this.kWs == null) {
            x.e("MicroMsg.CardBaseCodeView", "update failure! targetView is null!");
        } else {
            this.kRf.awg();
            d(c.CARDCODEREFRESHACTION_ENTERCHANGE);
            this.kWt.c(this.kWs, this.kIK);
        }
    }

    public final void d(c cVar) {
        int i = 1;
        if (this.kIK == null) {
            x.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode mCardInfo  is null ! cannot show code view");
        } else if (cVar == null) {
            x.e("MicroMsg.CardBaseCodeView", "updateCodeView failure!refreshReason is null!");
        } else if (this.kWt.i(this.kIK)) {
            this.kWt.d(this.kWs);
            x.i("MicroMsg.CardBaseCodeView", "updateCodeView from refreshReason = %s", new Object[]{Integer.valueOf(cVar.action)});
            this.code = e(cVar);
            if (com.tencent.pb.common.c.g.AA(this.code)) {
                x.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode is empty! cannot show code view");
                return;
            }
            View view;
            String str;
            ImageView imageView;
            switch (this.kIK.atC().vRe) {
                case 0:
                    view = this.kWs;
                    str = this.code;
                    TextView textView = (TextView) view.findViewById(R.h.bWC);
                    textView.setText(m.wW(str));
                    textView.setOnLongClickListener(this.kNQ);
                    String str2 = this.kIK.atB().hbM;
                    if (!com.tencent.pb.common.c.g.AA(str2)) {
                        textView.setTextColor(l.wO(str2));
                    }
                    if (str.length() <= 12) {
                        textView.setTextSize(1, 33.0f);
                        return;
                    } else if (str.length() > 12 && str.length() <= 16) {
                        textView.setTextSize(1, 30.0f);
                        return;
                    } else if (str.length() > 16 && str.length() <= 20) {
                        textView.setTextSize(1, 24.0f);
                        return;
                    } else if (str.length() > 20 && str.length() <= 40) {
                        textView.setTextSize(1, 18.0f);
                        return;
                    } else if (str.length() > 40) {
                        textView.setVisibility(8);
                        return;
                    } else {
                        return;
                    }
                case 1:
                    view = this.kWs;
                    String str3 = this.code;
                    try {
                        imageView = (ImageView) view.findViewById(R.h.bWm);
                        l.u(this.kNH);
                        if (str3 != null && str3.length() > 0) {
                            this.kNH = a.b(this.kaY, str3, 5, 0);
                        }
                        a(imageView, this.kNH);
                        imageView.setOnClickListener(this.kWz.avM());
                        this.kRf.kNH = this.kNH;
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.CardBaseCodeView", e, "", new Object[0]);
                        return;
                    }
                case 2:
                    view = this.kWs;
                    str = this.code;
                    try {
                        imageView = (ImageView) view.findViewById(R.h.bWv);
                        l.u(this.inI);
                        if (!(this.kIK == null || this.kIK.atB() == null)) {
                            i = this.kIK.atB().vSp;
                        }
                        this.inI = a.b(this.kaY, str, 0, i);
                        a(imageView, this.inI);
                        imageView.setOnClickListener(this.kWz.avM());
                        this.kRf.inI = this.inI;
                        j jVar = this.kRf;
                        if (jVar.inJ != null && jVar.inJ.isShowing()) {
                            jVar.inK.setImageBitmap(jVar.inI);
                            return;
                        }
                        return;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.CardBaseCodeView", e2, "", new Object[0]);
                        return;
                    }
                default:
                    return;
            }
        } else {
            x.e("MicroMsg.CardBaseCodeView", "updateCodeView failure! can not get qrcode! refreshReason = %s", new Object[]{Integer.valueOf(cVar.action)});
            awZ();
        }
    }

    public final void awZ() {
        if (this.kWt != null && this.kIK != null && this.kWs != null) {
            this.kWt.a(this.kWs, this.kIK);
        }
    }

    public final void axa() {
        if (this.kIK == null || this.kWt == null || this.kWs == null) {
            x.e("MicroMsg.CardBaseCodeView", "onScreenShot is error! mCardInfo or codeContainer or targetView is null ");
            return;
        }
        this.kWt.b(this.kWs, this.kIK);
        if (this.kIK.atC().vRe == 2 && this.kRf != null) {
            j jVar = this.kRf;
            if (jVar.inJ != null && jVar.inJ.isShowing()) {
                jVar.inJ.dismiss();
            }
        }
    }

    public final void awW() {
        if (this.kWs != null) {
            this.kWs.setVisibility(8);
        }
    }

    private static void a(ImageView imageView, Bitmap bitmap) {
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
