package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelappbrand.o;
import com.tencent.mm.protocal.c.cbr;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.viewitems.q.a;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class q$a$2 implements d {
    final /* synthetic */ au heR;
    final /* synthetic */ View jLA;
    final /* synthetic */ String tIq;
    final /* synthetic */ a yLW;

    q$a$2(a aVar, View view, au auVar, String str) {
        this.yLW = aVar;
        this.jLA = view;
        this.heR = auVar;
        this.tIq = str;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        x.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", Integer.valueOf(menuItem.getItemId()), Integer.valueOf(i));
        switch (menuItem.getItemId()) {
            case 1:
                ar.CG().a(1198, new e(this) {
                    final /* synthetic */ q$a$2 yLX;

                    {
                        this.yLX = r1;
                    }

                    public final void a(int i, int i2, String str, k kVar) {
                        ar.CG().b(1198, (e) this);
                        x.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(false));
                        if (q.d(this.yLX.yLW.yLH) != null) {
                            q.d(this.yLX.yLW.yLH).dismiss();
                            q.a(this.yLX.yLW.yLH, null);
                        }
                        if (i != 0 || i2 != 0) {
                            u.makeText(this.yLX.jLA.getContext(), R.l.ezu, 0).show();
                        } else if (this.yLX.heR != this.yLX.jLA.getTag()) {
                            x.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", Long.valueOf(this.yLX.heR.field_msgId));
                        } else {
                            cbr Jf = ((o) kVar).Jf();
                            if (Jf == null) {
                                u.makeText(this.yLX.jLA.getContext(), R.l.ezu, 0).show();
                                return;
                            }
                            String str2 = Jf.xaL;
                            x.d("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", this.yLX.tIq);
                            try {
                                x.i("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", str2, q.b(this.yLX.yLW.yLH), String.format("https://mp.weixin.qq.com/mp/infringement?from=8&username=%s&template_id=%s&template_msg_id=%s1#wechat_redirect", new Object[]{this.yLX.tIq, URLEncoder.encode(q.b(this.yLX.yLW.yLH), ProtocolPackage.ServerEncoding), URLEncoder.encode(str2, ProtocolPackage.ServerEncoding)}));
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", r1);
                                com.tencent.mm.bm.d.b(q.c(this.yLX.yLW.yLH).getContext(), "webview", ".ui.tools.WebViewUI", intent);
                            } catch (UnsupportedEncodingException e) {
                                x.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                                u.makeText(this.yLX.jLA.getContext(), R.l.ezy, 0).show();
                            }
                        }
                    }
                });
                k oVar = new o(this.heR.field_content);
                q qVar = this.yLW.yLH;
                Context context = this.jLA.getContext();
                this.jLA.getResources().getString(R.l.dGO);
                q.a(qVar, h.a(context, this.jLA.getResources().getString(R.l.dHc), true, new 2(this, oVar)));
                ar.CG().a(oVar, 0);
                return;
            default:
                return;
        }
    }
}
