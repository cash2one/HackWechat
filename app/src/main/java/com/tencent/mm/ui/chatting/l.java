package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.bizchat.BizChatSelectConversationUI;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.u;
import java.util.LinkedList;
import java.util.List;

public final class l {
    private static r yrA = null;
    private static a yrL;

    public static void a(a aVar, List<au> list, boolean z, s sVar, x xVar) {
        if (aVar == null) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, fragment is null");
        } else if (list == null || list.isEmpty()) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, select item empty");
        } else {
            a aVar2 = new a((byte) 0);
            yrL = aVar2;
            aVar2.yrI = new LinkedList(list);
            yrL.ypn = z;
            yrL.fEL = xVar.field_username;
            yrL.yrT = true;
            Context context = aVar.getContext();
            if (context != null) {
                com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(context);
                lVar.zlt = new p.a() {
                    public final void a(ImageView imageView, MenuItem menuItem) {
                        b.b(imageView, menuItem.getTitle(), false);
                    }
                };
                lVar.zlu = new 2(context);
                lVar.rKC = new 3(com.tencent.mm.pluginsdk.model.app.p.m(context, "com.tencent.wework") ? i.crq() : i.crp());
                lVar.rKD = new 4(list, context, aVar, xVar, sVar);
                lVar.bBX();
            }
        }
    }

    public static void a(final String str, final u uVar, List<au> list) {
        Context context = uVar.getContext();
        if (context != null) {
            d jS = f.jS(str);
            if (jS != null) {
                String string;
                boolean Lg = jS.Lg();
                if (yrL.yrT) {
                    boolean db = i.db(list);
                    if (Lg) {
                        Object obj;
                        if (list == null || list.isEmpty()) {
                            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to bizchat msg error, selected item empty");
                            obj = 1;
                        } else {
                            for (au auVar : list) {
                                if (!auVar.cjg() && !auVar.ciW() && !auVar.cje() && !auVar.aNe() && !i.aq(auVar)) {
                                    int i = 1;
                                    break;
                                }
                            }
                            obj = null;
                        }
                        yrL.yrI = new LinkedList(list);
                        if (db || r0 != null) {
                            string = context.getString(R.l.ebS);
                            if (string != null) {
                                h.a(context, string, "", new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        l.a(str, uVar);
                                    }
                                }, null);
                            } else {
                                a(str, uVar);
                            }
                        }
                    } else if (db) {
                        string = context.getString(R.l.ebT);
                        if (string != null) {
                            a(str, uVar);
                        } else {
                            h.a(context, string, "", /* anonymous class already generated */, null);
                        }
                    }
                }
                string = null;
                if (string != null) {
                    h.a(context, string, "", /* anonymous class already generated */, null);
                } else {
                    a(str, uVar);
                }
            }
        }
    }

    public static void a(String str, u uVar) {
        d jS = f.jS(str);
        if (jS != null) {
            Intent intent;
            if (jS.Lg()) {
                intent = new Intent(uVar.getContext(), BizChatSelectConversationUI.class);
                intent.putExtra("enterprise_biz_name", str);
                intent.putExtra("biz_chat_scene", 2);
                intent.putExtra("enterprise_extra_params", yrL.yrT);
                uVar.startActivityForResult(intent, 225);
            } else if (jS.Le()) {
                intent = new Intent();
                intent.putExtra("enterprise_biz_name", str);
                intent.putExtra("enterprise_scene", 1);
                com.tencent.mm.bm.d.a(uVar, "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent, 225);
            }
        }
    }

    public static mt bv(Context context, String str) {
        com.tencent.mm.sdk.b.b mtVar = new mt();
        mtVar.fEE.type = 6;
        mtVar.fEE.fEK = yrL.yrI;
        mtVar.fEE.toUser = str;
        mtVar.fEE.fEL = yrL.fEL;
        mtVar.fEE.context = context;
        com.tencent.mm.sdk.b.a.xef.m(mtVar);
        yrL.fEg = mtVar.fEF.fEg;
        yrL.yrJ = mtVar.fEF.fEN;
        return mtVar;
    }

    public static void a(a aVar, s sVar, String str, long j) {
        Context context = aVar.getContext();
        if (!t.ov(str) && str.length() > 0) {
            context.getString(R.l.dGO);
            yrA = h.a(context, context.getString(R.l.eKa), false, null);
            s.ytO.c(new b(aVar, context, str, j, yrL));
        }
        if (sVar != null) {
            sVar.crR();
        }
    }
}
