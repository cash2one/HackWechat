package com.tencent.mm.ui.conversation;

import android.content.res.ColorStateList;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.bv.a;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.r;
import java.util.HashMap;

class SettingCheckUnProcessWalletConvUI$a extends BaseAdapter {
    private final int yWR;
    private final int yWS;
    private float yno = -1.0f;
    protected float ynp = -1.0f;
    private float ynq = -1.0f;
    private ColorStateList[] ynr = new ColorStateList[5];
    private HashMap<String, a> yns;
    final /* synthetic */ SettingCheckUnProcessWalletConvUI zaj;

    public final /* synthetic */ Object getItem(int i) {
        return Gt(i);
    }

    public SettingCheckUnProcessWalletConvUI$a(SettingCheckUnProcessWalletConvUI settingCheckUnProcessWalletConvUI) {
        this.zaj = settingCheckUnProcessWalletConvUI;
        this.ynr[0] = a.Z(settingCheckUnProcessWalletConvUI, R.e.bsO);
        this.ynr[1] = a.Z(settingCheckUnProcessWalletConvUI, R.e.btl);
        this.ynr[3] = a.Z(settingCheckUnProcessWalletConvUI, R.e.btv);
        this.ynr[2] = a.Z(settingCheckUnProcessWalletConvUI, R.e.btj);
        this.ynr[2] = a.Z(settingCheckUnProcessWalletConvUI, R.e.btj);
        this.ynr[4] = a.Z(settingCheckUnProcessWalletConvUI, R.e.btb);
        if (a.ey(settingCheckUnProcessWalletConvUI)) {
            this.yWS = settingCheckUnProcessWalletConvUI.getResources().getDimensionPixelSize(R.f.buC);
            this.yWR = settingCheckUnProcessWalletConvUI.getResources().getDimensionPixelSize(R.f.buD);
        } else {
            this.yWS = settingCheckUnProcessWalletConvUI.getResources().getDimensionPixelSize(R.f.buB);
            this.yWR = settingCheckUnProcessWalletConvUI.getResources().getDimensionPixelSize(R.f.buE);
        }
        this.yno = (float) a.aa(settingCheckUnProcessWalletConvUI, R.f.bvK);
        this.ynp = (float) a.aa(settingCheckUnProcessWalletConvUI, R.f.bvs);
        this.ynq = (float) a.aa(settingCheckUnProcessWalletConvUI, R.f.bvW);
        this.yns = new HashMap();
    }

    public final int getCount() {
        return SettingCheckUnProcessWalletConvUI.d(this.zaj).size();
    }

    public final ae Gt(int i) {
        String str = (String) SettingCheckUnProcessWalletConvUI.d(this.zaj).get(i);
        ar.Hg();
        return c.Fd().WY(str);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            View inflate;
            b bVar2 = new b(this, (byte) 0);
            if (a.ey(this.zaj)) {
                inflate = View.inflate(this.zaj, R.i.dfc, null);
            } else {
                inflate = View.inflate(this.zaj, R.i.dfb, null);
            }
            bVar2.iip = (ImageView) inflate.findViewById(R.h.bLL);
            bVar2.ynw = (NoMeasuredTextView) inflate.findViewById(R.h.cAn);
            bVar2.yXn = (NoMeasuredTextView) inflate.findViewById(R.h.cPc);
            bVar2.ynx = (NoMeasuredTextView) inflate.findViewById(R.h.cTR);
            bVar2.yny = (NoMeasuredTextView) inflate.findViewById(R.h.csx);
            bVar2.kBL = (TextView) inflate.findViewById(R.h.cRX);
            bVar2.kBL.setBackgroundResource(s.gd(this.zaj));
            bVar2.ynz = (ImageView) inflate.findViewById(R.h.cpt);
            bVar2.ynB = inflate.findViewById(R.h.bLO);
            bVar2.ynA = (ImageView) inflate.findViewById(R.h.cQy);
            bVar2.yXo = (ImageView) inflate.findViewById(R.h.cua);
            inflate.setTag(bVar2);
            bVar2.yny.O(this.ynp);
            bVar2.ynx.O(this.ynq);
            bVar2.ynw.O(this.yno);
            bVar2.yXn.O(this.ynp);
            bVar2.yny.setTextColor(this.ynr[0]);
            bVar2.ynx.setTextColor(this.ynr[4]);
            bVar2.ynw.setTextColor(this.ynr[3]);
            bVar2.yXn.setTextColor(this.ynr[0]);
            bVar2.yny.ygb = true;
            bVar2.ynx.ygb = false;
            bVar2.ynw.ygb = true;
            bVar2.yXn.ygb = true;
            bVar2.ynx.Eg();
            view = inflate;
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        aj Gt = Gt(i);
        if (Gt != null) {
            b.a(bVar.iip, Gt.field_username);
            bVar.iip.getDrawable();
            String str = Gt.field_username;
            a aVar = (a) this.yns.get(str);
            if (aVar == null) {
                String str2;
                int i2;
                a aVar2 = new a(this, (byte) 0);
                aVar2.yXe = -1;
                aVar2.yXd = -1;
                aVar2.yXi = false;
                aVar2.yXk = false;
                aVar2.yXj = false;
                aVar2.tRV = com.tencent.mm.z.s.eV(Gt.field_username);
                boolean z = aVar2.tRV && aVar2.yXj && Gt.field_unReadCount > 0;
                aVar2.yXh = z;
                aVar2.kTK = 0;
                if (vP(Gt.field_msgType) == 34 && Gt.field_isSend == 0 && !t.ov(Gt.field_content)) {
                    str2 = Gt.field_content;
                    if (str.equals("qmessage") || str.equals("floatbottle")) {
                        String[] split = str2.split(":");
                        if (split != null && split.length > 3) {
                            str2 = split[1] + ":" + split[2] + ":" + split[3];
                        }
                    }
                    if (!new n(str2).hVA) {
                        aVar2.kTK = 1;
                    }
                }
                str2 = r.gu(str);
                if (aVar2.tRV && str2 == null) {
                    aVar2.nickName = this.zaj.getString(R.l.dSN);
                } else {
                    aVar2.nickName = i.b(this.zaj, r.gu(str), bVar.ynw.gu.getTextSize());
                }
                aVar2.yXa = h(Gt);
                aVar2.yXb = c(Gt, (int) bVar.yny.gu.getTextSize(), aVar2.yXh);
                aVar2.yXl = Gt.field_attrflag;
                switch (Gt.field_status) {
                    case 0:
                        i2 = -1;
                        break;
                    case 1:
                        i2 = R.k.dze;
                        break;
                    case 2:
                        i2 = -1;
                        break;
                    case 5:
                        i2 = R.k.dzd;
                        break;
                    default:
                        i2 = -1;
                        break;
                }
                aVar2.yXc = i2;
                aVar2.yXf = com.tencent.mm.z.s.a(Gt);
                ar.Hg();
                aVar2.ynt = c.Fd().g(Gt);
                aVar2.yXg = false;
                aVar2.vfW = w.cfe();
                this.yns.put(str, aVar2);
                aVar = aVar2;
            }
            if (aVar.yXa == null) {
                aVar.yXa = h(Gt);
            }
            if (aVar.yXh || com.tencent.mm.z.s.hd(Gt.field_parentRef)) {
                bVar.yny.setTextColor(this.ynr[0]);
            } else {
                bVar.yny.setTextColor(this.ynr[aVar.kTK]);
            }
            if (str.toLowerCase().endsWith("@t.qq.com")) {
                bVar.ynw.ET(R.g.bDb);
                bVar.ynw.mu(true);
            } else {
                bVar.ynw.mu(false);
            }
            int i3 = aVar.yXc;
            if (i3 != -1) {
                bVar.yny.ES(i3);
                bVar.yny.mt(true);
            } else {
                bVar.yny.mt(false);
            }
            bVar.ynw.setText(aVar.nickName);
            bVar.yXn.setVisibility(8);
            LayoutParams layoutParams = bVar.ynx.getLayoutParams();
            if (aVar.yXa.length() > 9) {
                if (layoutParams.width != this.yWS) {
                    layoutParams.width = this.yWS;
                    bVar.ynx.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.width != this.yWR) {
                layoutParams.width = this.yWR;
                bVar.ynx.setLayoutParams(layoutParams);
            }
            x.v("MicroMsg.SettingCheckUnProcessWalletConvUI", "layout update time width %d", new Object[]{Integer.valueOf(layoutParams.width)});
            bVar.ynx.setText(aVar.yXa);
            bVar.yny.setText(aVar.yXb);
            if (aVar.tRV && aVar.yXj) {
                bVar.ynz.setVisibility(0);
            } else if (aVar.yXg) {
                bVar.ynz.setVisibility(0);
            } else {
                bVar.ynz.setVisibility(8);
            }
            b.a(bVar.iip, str);
            if (!aVar.yXf && aVar.ynt && ar.Hj()) {
                ar.Hg();
                c.Fd().f(Gt);
            }
            if (!aVar.ynt || Gt.field_conversationTime == -1) {
                view.findViewById(R.h.bYX).setBackgroundResource(R.g.bBx);
            } else {
                view.findViewById(R.h.bYX).setBackgroundResource(R.g.bBw);
            }
            bVar.ynA.setVisibility(8);
        }
        return view;
    }

    private static int vP(String str) {
        int i = 1;
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    private CharSequence h(ae aeVar) {
        if (aeVar.field_status == 1) {
            return this.zaj.getString(R.l.euA);
        }
        return aeVar.field_conversationTime == Long.MAX_VALUE ? "" : com.tencent.mm.pluginsdk.h.n.c(this.zaj, aeVar.field_conversationTime, true);
    }

    private CharSequence c(ae aeVar, int i, boolean z) {
        CharSequence replace;
        if (t.ov(aeVar.field_editingMsg) || (aeVar.field_atCount > 0 && aeVar.field_unReadCount > 0)) {
            CharSequence charSequence = aeVar.field_digest;
            if (charSequence != null && charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                return new SpannableString(i.e(this.zaj, charSequence, (float) i));
            }
            int i2;
            String str;
            String str2 = aeVar.field_username;
            if (str2.equals("qqmail")) {
                ar.Hg();
                if (t.e((Integer) c.CU().get(17, null)) == 1) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i2 == 0) {
                    return this.zaj.getString(R.l.eMu);
                }
            }
            if (str2.equals("tmessage")) {
                ar.Hg();
                bc EY = c.Fg().EY("@t.qq.com");
                if (EY == null || !EY.isEnable()) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                if (i2 == 0) {
                    return this.zaj.getString(R.l.eMu);
                }
            }
            if (aeVar.field_msgType != null && (aeVar.field_msgType.equals("47") || aeVar.field_msgType.equals("1048625"))) {
                str2 = YW(aeVar.field_digest);
                str = "";
                if (str2 != null) {
                    return "[" + str2 + "]";
                }
                if (aeVar.field_digest != null && aeVar.field_digest.contains(":")) {
                    str = aeVar.field_digest.substring(0, aeVar.field_digest.indexOf(":"));
                    str2 = YW(aeVar.field_digest.substring(aeVar.field_digest.indexOf(":") + 1).replace(" ", ""));
                    if (str2 != null) {
                        str2 = "[" + str2 + "]";
                        return t.ov(str) ? str2 : str + ": " + str2;
                    }
                }
                str2 = this.zaj.getString(R.l.dEG);
                aeVar.dF(t.ov(str) ? str2 : str + ": " + str2);
            }
            if (!t.ov(aeVar.field_digest)) {
                if (t.ov(aeVar.field_digestUser)) {
                    str = aeVar.field_digest;
                } else {
                    str = (aeVar.field_isSend == 0 && com.tencent.mm.z.s.eV(aeVar.field_username)) ? r.L(aeVar.field_digestUser, aeVar.field_username) : r.gu(aeVar.field_digestUser);
                    try {
                        str = String.format(aeVar.field_digest, new Object[]{str});
                    } catch (Exception e) {
                    }
                }
                replace = str.replace('\n', ' ');
                if (aeVar.field_atCount > 0 || aeVar.field_unReadCount <= 0) {
                    if (!z && aeVar.field_unReadCount > 1) {
                        replace = this.zaj.getString(R.l.eug, new Object[]{Integer.valueOf(aeVar.field_unReadCount), replace});
                    } else if (aeVar.field_unReadCount > 1 && com.tencent.mm.z.s.hd(aeVar.field_parentRef)) {
                        replace = this.zaj.getString(R.l.eug, new Object[]{Integer.valueOf(aeVar.field_unReadCount), replace});
                    }
                    return i.c(this.zaj, replace, i);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.zaj.getString(R.l.eud));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder.append(" ").append(i.c(this.zaj, replace, i));
                return spannableStringBuilder;
            }
            str = h.a(aeVar.field_isSend, aeVar.field_username, aeVar.field_content, vP(aeVar.field_msgType), this.zaj);
            replace = str.replace('\n', ' ');
            if (aeVar.field_atCount > 0) {
            }
            if (!z) {
            }
            replace = this.zaj.getString(R.l.eug, new Object[]{Integer.valueOf(aeVar.field_unReadCount), replace});
            return i.c(this.zaj, replace, i);
        }
        replace = new SpannableStringBuilder(this.zaj.getString(R.l.euh));
        replace.setSpan(new ForegroundColorSpan(-5569532), 0, replace.length(), 33);
        replace.append(" ").append(i.c(this.zaj, aeVar.field_editingMsg, i));
        return replace;
    }

    private static String YW(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().xZ(str);
    }
}
