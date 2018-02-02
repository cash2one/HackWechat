package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.widget.g;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class WalletBalanceManagerUI$12 implements OnMenuItemClickListener {
    final /* synthetic */ List nbC;
    final /* synthetic */ WalletBalanceManagerUI szV;
    final /* synthetic */ JSONObject szX;

    WalletBalanceManagerUI$12(WalletBalanceManagerUI walletBalanceManagerUI, JSONObject jSONObject, List list) {
        this.szV = walletBalanceManagerUI;
        this.szX = jSONObject;
        this.nbC = list;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g gVar = new g(this.szV.mController.xIM, g.ztp, false);
        gVar.rKC = new c(this) {
            final /* synthetic */ WalletBalanceManagerUI$12 szY;

            {
                this.szY = r1;
            }

            public final void a(n nVar) {
                JSONArray optJSONArray = this.szY.szX.optJSONArray("balance_menu_item");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            WalletBalanceManagerUI$a walletBalanceManagerUI$a = new WalletBalanceManagerUI$a();
                            walletBalanceManagerUI$a.title = optJSONObject.optString("title");
                            walletBalanceManagerUI$a.szZ = optJSONObject.optInt("jump_type", 0);
                            walletBalanceManagerUI$a.sAa = optJSONObject.optString("jump_h5_url");
                            walletBalanceManagerUI$a.sAb = optJSONObject.optString("tinyapp_username");
                            walletBalanceManagerUI$a.sAc = optJSONObject.optString("tinyapp_path");
                            nVar.add(0, i, 0, walletBalanceManagerUI$a.title);
                            this.szY.nbC.add(walletBalanceManagerUI$a);
                        }
                    }
                }
            }
        };
        gVar.rKD = new 2(this);
        gVar.bUk();
        return false;
    }
}
