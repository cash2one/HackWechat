package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ca;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.z.u;

class ProductUI$6 implements d {
    final /* synthetic */ ProductUI pWr;

    ProductUI$6(ProductUI productUI) {
        this.pWr = productUI;
    }

    public final void cn(int i, int i2) {
        if (ProductUI.a(this.pWr) != null) {
            Intent intent;
            switch (i2) {
                case -1:
                    h.a(this.pWr.mController.xIM, this.pWr.mController.xIM.getString(R.l.dEx), null, null, this.pWr.mController.xIM.getString(R.l.dEw), new d(this) {
                        final /* synthetic */ ProductUI$6 pWt;

                        {
                            this.pWt = r1;
                        }

                        public final void cn(int i, int i2) {
                            switch (i2) {
                                case -1:
                                    b caVar = new ca();
                                    caVar.fqi.fqk = this.pWt.pWr.getIntent().getLongExtra("key_favorite_local_id", -1);
                                    a.xef.m(caVar);
                                    x.d("MicroMsg.scanner.ProductUI", "do del fav product, local id %d, result %B", new Object[]{Long.valueOf(caVar.fqi.fqk), Boolean.valueOf(caVar.fqj.fpW)});
                                    if (caVar.fqj.fpW) {
                                        this.pWt.pWr.finish();
                                        return;
                                    }
                                    return;
                                default:
                                    x.d("MicroMsg.scanner.ProductUI", "do del cancel");
                                    return;
                            }
                        }
                    });
                    return;
                case 0:
                    g.pQN.h(11446, new Object[]{ProductUI.a(this.pWr).field_productid, Integer.valueOf(2)});
                    if (ProductUI.c(this.pWr) == 3) {
                        g.pQN.h(10651, new Object[]{Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0)});
                    }
                    intent = new Intent();
                    intent.putExtra("KContentObjDesc", ProductUI.a(this.pWr).field_subtitle);
                    intent.putExtra("Ksnsupload_title", ProductUI.a(this.pWr).field_title);
                    intent.putExtra("Ksnsupload_link", ProductUI.a(this.pWr).field_shareurl);
                    intent.putExtra("Ksnsupload_appname", n.J(this.pWr, ProductUI.a(this.pWr).field_type));
                    intent.putExtra("Ksnsupload_appid", i.vD(ProductUI.a(this.pWr).field_functionType));
                    intent.putExtra("Ksnsupload_imgurl", ProductUI.a(this.pWr).field_thumburl);
                    x.i("MicroMsg.scanner.ProductUI", "product.field_thumburl : " + ProductUI.a(this.pWr).field_thumburl);
                    if (ProductUI.m(this.pWr) != null) {
                        intent.putExtra("KsnsUpload_imgPath", ProductUI.m(this.pWr).Wf());
                    } else {
                        x.e("MicroMsg.scanner.ProductUI", "imgGetStrategy is null");
                    }
                    intent.putExtra("Ksnsupload_type", 3);
                    intent.putExtra("KUploadProduct_UserData", n.c(ProductUI.a(this.pWr)));
                    intent.putExtra("KUploadProduct_subType", ProductUI.a(this.pWr).field_type);
                    String hz = u.hz("scan_product");
                    u.GK().t(hz, true).o("prePublishId", "scan_product");
                    intent.putExtra("reportSessionId", hz);
                    com.tencent.mm.bm.d.b(this.pWr, "sns", ".ui.SnsUploadUI", intent);
                    return;
                case 1:
                    g.pQN.h(11446, new Object[]{ProductUI.a(this.pWr).field_productid, Integer.valueOf(1)});
                    String a = i.a(this.pWr.mController.xIM, ProductUI.a(this.pWr));
                    Intent intent2 = new Intent();
                    intent2.putExtra("Retr_Msg_content", a);
                    intent2.putExtra("Retr_Msg_Type", 2);
                    if (ProductUI.m(this.pWr) != null) {
                        intent2.putExtra("Retr_Msg_thumb_path", ProductUI.m(this.pWr).Wf());
                    } else {
                        x.e("MicroMsg.scanner.ProductUI", "imgGetStrategy is null");
                    }
                    intent2.putExtra("Retr_go_to_chattingUI", false);
                    intent2.putExtra("Retr_show_success_tips", true);
                    com.tencent.mm.plugin.scanner.b.ifs.l(intent2, this.pWr);
                    if (ProductUI.c(this.pWr) == 3) {
                        g.pQN.h(10651, new Object[]{Integer.valueOf(10), Integer.valueOf(1), Integer.valueOf(0)});
                        return;
                    }
                    return;
                case 2:
                    g.pQN.h(11446, new Object[]{ProductUI.a(this.pWr).field_productid, Integer.valueOf(3)});
                    ProductUI.p(this.pWr);
                    return;
                case 3:
                    intent = new Intent();
                    intent.putExtra("key_fav_scene", 2);
                    intent.putExtra("key_fav_item_id", this.pWr.getIntent().getLongExtra("key_favorite_local_id", -1));
                    com.tencent.mm.bm.d.b(this.pWr.mController.xIM, "favorite", ".ui.FavTagEditUI", intent);
                    return;
                case 4:
                    intent = new Intent();
                    intent.putExtra("rawUrl", ProductUI.a(this.pWr).field_exposeurl);
                    com.tencent.mm.bm.d.b(this.pWr.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                default:
                    return;
            }
        }
    }
}
