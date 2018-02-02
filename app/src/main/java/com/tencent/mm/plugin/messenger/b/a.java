package com.tencent.mm.plugin.messenger.b;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ba;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class a implements e {
    private Map<String, b> opf = new HashMap();
    private Map<String, com.tencent.mm.plugin.messenger.a.e.a> opg = new HashMap();
    private com.tencent.mm.aq.a.d.a<Long, CharSequence> oph = new com.tencent.mm.aq.a.d.a(200);
    private com.tencent.mm.aq.a.d.a<Long, CharSequence> opi = new com.tencent.mm.aq.a.d.a(500);
    public m opj = new 1(this);

    static /* synthetic */ boolean d(com.tencent.mm.ae.d.a aVar) {
        if (aVar == null || aVar.hmq == null) {
            x.e("MicroMsg.SysMsgTemplateImp", "hy: addMsgInfo or addMsgInfo.addMsg is null! should not happen");
            return false;
        }
        bw bwVar = aVar.hmq;
        String a = n.a(bwVar.vGZ);
        String a2 = n.a(bwVar.vGX);
        au F = ((h) g.h(h.class)).aZi().F(a2, bwVar.vHe);
        boolean z = F.field_msgId > 0;
        F.ap(bwVar.vHe);
        if (!(aVar.hmr && aVar.hmt)) {
            F.aq(ba.n(a2, (long) bwVar.pbl));
        }
        F.setType(570425393);
        F.setContent(a);
        F.eR(0);
        F.dS(a2);
        F.dY(bwVar.vHc);
        ba.a(F, aVar);
        if (z) {
            ((h) g.h(h.class)).aZi().b(bwVar.vHe, F);
            return true;
        }
        ba.i(F);
        return true;
    }

    public final void a(String str, b bVar) {
        x.i("MicroMsg.SysMsgTemplateImp", "hy: adding template listener: %s", str);
        this.opf.put(str, bVar);
    }

    public final void Eo(String str) {
        x.i("MicroMsg.SysMsgTemplateImp", "hy: removing template listener: %s", str);
        this.opf.remove(str);
    }

    public final void a(String str, com.tencent.mm.plugin.messenger.a.e.a aVar) {
        x.i("MicroMsg.SysMsgTemplateImp", "hy: adding digest listener: %s", str);
        this.opg.put(str, aVar);
    }

    public final void Ep(String str) {
        x.i("MicroMsg.SysMsgTemplateImp", "hy: removing digest listener: %s", str);
        this.opg.remove(str);
    }

    public final CharSequence a(String str, Bundle bundle, WeakReference<Context> weakReference, WeakReference<TextView> weakReference2) {
        if (bh.ov(str)) {
            x.w("MicroMsg.SysMsgTemplateImp", "hy: request translate content is null!");
            return null;
        }
        Map y = bi.y(str, "sysmsg");
        if (y == null) {
            x.i("MicroMsg.SysMsgTemplateImp", "hy: not retrieved sysmsg from new xml!");
            return null;
        }
        String str2 = (String) y.get(".sysmsg.$type");
        if (!bh.ov(str2) && "sysmsgtemplate".equals(str2)) {
            return a(y, bundle, weakReference, 0, weakReference2);
        }
        x.w("MicroMsg.SysMsgTemplateImp", "hy: not acceptable sysmsg: %s", str2);
        return null;
    }

    public final CharSequence Eq(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.SysMsgTemplateImp", "hy: [digest] request translate content is null!");
            return null;
        }
        Map y = bi.y(str, "sysmsg");
        if (y == null) {
            x.i("MicroMsg.SysMsgTemplateImp", "hy: [digest] not retrieved sysmsg from new xml!");
            return null;
        }
        String str2 = (String) y.get(".sysmsg.$type");
        if (!bh.ov(str2) && "sysmsgtemplate".equals(str2)) {
            return a(y, null, null, 1, null);
        }
        x.w("MicroMsg.SysMsgTemplateImp", "hy: [digest] not acceptable sysmsg: %s", str2);
        return null;
    }

    private CharSequence a(Map<String, String> map, Bundle bundle, WeakReference<Context> weakReference, int i, WeakReference<TextView> weakReference2) {
        String str = ".sysmsg.sysmsgtemplate.content_template";
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            String str2 = str + ((i2 == 0 ? "" : Integer.valueOf(i2)));
            if (bh.ov((String) map.get(str2))) {
                break;
            }
            String str3 = (String) map.get(str2 + ".$type");
            Object obj = ("tmpl_type_profile".equals(str3) || "tmpl_type_profilewithrevoke".equals(str3) || "tmpl_type_profilewithrevokeqrcode".equals(str3) || "tmpl_type_wxappnotifywithview".equals(str3)) ? 1 : null;
            if (obj == null) {
                x.w("MicroMsg.SysMsgTemplateImp", "hy: non supported type: %s", str3);
                arrayList.add(h(str2, map));
            }
            x.v("MicroMsg.SysMsgTemplateImp", "hy: rawTemplate : %s", (String) map.get(str2 + ".template"));
            ArrayList Fc = b.Fc(str3);
            str2 = "MicroMsg.SysMsgTemplateImp";
            String str4 = "hy: parsed %d models";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(Fc == null ? 0 : Fc.size());
            x.d(str2, str4, objArr);
            if (Fc == null || Fc.size() == 0) {
                arrayList.add(new SpannableString(""));
            } else {
                ArrayList arrayList2 = new ArrayList();
                Iterator it = Fc.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.plugin.messenger.b.b.a aVar = (com.tencent.mm.plugin.messenger.b.b.a) it.next();
                    if (aVar.type == 0) {
                        arrayList2.add(new SpannableString(i.a(ac.getContext(), aVar.content)));
                    } else if (aVar.type == 1) {
                        int i3 = 0;
                        while (true) {
                            String str5 = str + ".link_list.link";
                            if (i3 != 0) {
                                str4 = str5 + i3;
                            } else {
                                str4 = str5;
                            }
                            if (bh.ov((String) map.get(str4))) {
                                break;
                            }
                            if (aVar.content.equals((String) map.get(str4 + ".$name"))) {
                                str5 = (String) map.get(str4 + ".$type");
                                if (i == 0) {
                                    b bVar = (b) this.opf.get(str5);
                                    if (!Fb(str5) || bVar == null) {
                                        String str6 = "MicroMsg.SysMsgTemplateImp";
                                        String str7 = "alvinluo not support link type: %s or listener == null: %b";
                                        Object[] objArr2 = new Object[2];
                                        objArr2[0] = bh.az(str5, "");
                                        objArr2[1] = Boolean.valueOf(bVar == null);
                                        x.i(str6, str7, objArr2);
                                        arrayList2.add(h(str4, map));
                                    } else {
                                        obj = bVar.a(map, str4, bundle, weakReference);
                                        z(obj);
                                        if (obj == null || obj.length() == 0) {
                                            obj = new SpannableString("");
                                        }
                                        arrayList2.add(obj);
                                    }
                                } else if (i == 1) {
                                    com.tencent.mm.plugin.messenger.a.e.a aVar2 = (com.tencent.mm.plugin.messenger.a.e.a) this.opg.get(str5);
                                    if (!Fb(str5) || aVar2 == null) {
                                        arrayList2.add(h(str4, map));
                                    } else {
                                        arrayList2.add(bh.ou(aVar2.g(map, str4)));
                                    }
                                } else {
                                    x.e("MicroMsg.SysMsgTemplateImp", "hy: not supported digest type");
                                }
                            }
                            i3++;
                        }
                    } else {
                        x.e("MicroMsg.SysMsgTemplateImp", "hy: invalid! should not get here");
                    }
                }
                x.v("MicroMsg.SysMsgTemplateImp", "hy: concatedvalue is %s", H(arrayList2));
                arrayList.add(r3);
            }
            i2++;
        }
        if (arrayList.size() != 0) {
            return H(arrayList);
        }
        x.w("MicroMsg.SysMsgTemplateImp", "hy: not handled");
        return new SpannableString("");
    }

    private static void z(CharSequence charSequence) {
        int i = 0;
        if (charSequence != null && charSequence.length() > 0 && (charSequence instanceof Spanned)) {
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
            if (clickableSpanArr != null && clickableSpanArr.length > 0) {
                int length = clickableSpanArr.length;
                while (i < length) {
                    if (clickableSpanArr[i] instanceof com.tencent.mm.ui.base.a.a) {
                        i++;
                    } else {
                        throw new IllegalArgumentException("hy: actively throw Exception!!! all clickable spans must be instance of com.tencent.mm.ui.base.span.IPressableSpan!");
                    }
                }
            }
        }
    }

    private static CharSequence H(ArrayList<CharSequence> arrayList) {
        CharSequence spannableString = new SpannableString("");
        Iterator it = arrayList.iterator();
        CharSequence charSequence = spannableString;
        while (it.hasNext()) {
            spannableString = (CharSequence) it.next();
            charSequence = TextUtils.concat(new CharSequence[]{charSequence, spannableString});
        }
        return charSequence;
    }

    private static CharSequence h(String str, Map<String, String> map) {
        if ((bh.getInt((String) map.get(new StringBuilder().append(str).append(".$hidden").toString()), 0) == 1 ? 1 : 0) != 0) {
            x.v("MicroMsg.SysMsgTemplateImp", "hy: hide");
            return new SpannableString("");
        }
        return new SpannableString(i.a(ac.getContext(), bh.ou((String) map.get(str + ".plain"))));
    }

    private static boolean Fb(String str) {
        if ("link_profile".equals(str) || "link_revoke".equals(str) || "link_revoke_qrcode".equals(str) || "link_plain".equals(str) || "link_view_wxapp".equals(str)) {
            return true;
        }
        return false;
    }
}
