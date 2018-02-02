package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.plugin.game.model.j;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.p.b;
import java.util.Map;

public class GameRegionSelectUI extends MMPreference {
    private f ilB;
    private a nuA;
    private Map<String, a> nuF;

    static /* synthetic */ void a(GameRegionSelectUI gameRegionSelectUI) {
        if (gameRegionSelectUI.nuA != null) {
            gameRegionSelectUI.getSharedPreferences("game_center_pref", 0).edit().putString("game_region_code", gameRegionSelectUI.nuA.fWv).commit();
            com.tencent.mm.plugin.game.d.a.a.aRT().nwU = true;
            j.aQe().fB(true);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ilB = this.yjd;
        initView();
    }

    protected void onDestroy() {
        com.tencent.mm.plugin.game.d.a.a.aRT().aRQ();
        super.onDestroy();
    }

    public final int XB() {
        return -1;
    }

    protected final void initView() {
        setMMTitle(R.l.emW);
        setBackBtn(new 1(this));
        a(0, getString(R.l.emV), new OnMenuItemClickListener(this) {
            final /* synthetic */ GameRegionSelectUI nuG;

            {
                this.nuG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i = 0;
                if (this.nuG.getSharedPreferences("game_center_pref", 0).getInt("game_region_confirm_mark", 0) != 1) {
                    i = 1;
                }
                if (i != 0) {
                    h.a(this.nuG, true, this.nuG.getString(R.l.emT), "", this.nuG.getString(R.l.emU), this.nuG.getString(R.l.emS), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 nuH;

                        {
                            this.nuH = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.nuH.nuG.getSharedPreferences("game_center_pref", 0).edit().putInt("game_region_confirm_mark", 1).commit();
                            GameRegionSelectUI.a(this.nuH.nuG);
                            Intent intent = new Intent();
                            a cK = g.cK(this.nuH.nuG);
                            if (cK != null) {
                                intent.putExtra("gameRegionName", g.a(cK));
                                this.nuH.nuG.setResult(-1, intent);
                            } else {
                                this.nuH.nuG.setResult(1);
                            }
                            this.nuH.nuG.finish();
                        }
                    }, new 2(this));
                } else {
                    GameRegionSelectUI.a(this.nuG);
                    Intent intent = new Intent();
                    a cK = g.cK(this.nuG);
                    if (cK != null) {
                        intent.putExtra("gameRegionName", g.a(cK));
                        this.nuG.setResult(-1, intent);
                    } else {
                        this.nuG.setResult(1);
                    }
                    this.nuG.finish();
                }
                return true;
            }
        }, b.xJz);
        this.ilB.removeAll();
        this.nuF = com.tencent.mm.plugin.game.d.a.a.aRT().aRS();
        a cK = g.cK(this);
        if (cK != null) {
            cK.nuE = true;
        }
        for (a cK2 : this.nuF.values()) {
            if (cK2 != null) {
                Preference gameRegionPreference = new GameRegionPreference(this);
                if (cK2 == null || bh.ov(cK2.fWv)) {
                    x.e("MicroMsg.GameRegionPreference", "setData region error");
                } else {
                    gameRegionPreference.nuA = cK2;
                    gameRegionPreference.setKey(cK2.fWv);
                }
                if (cK2.isDefault) {
                    this.ilB.a(gameRegionPreference, 0);
                } else {
                    this.ilB.a(gameRegionPreference);
                }
            }
        }
        this.ilB.a(new PreferenceCategory(this));
        this.ilB.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        if (!(preference instanceof GameRegionPreference)) {
            return false;
        }
        a aVar = ((GameRegionPreference) preference).nuA;
        if (aVar == null) {
            return false;
        }
        this.nuA = aVar;
        for (a aVar2 : this.nuF.values()) {
            aVar2.nuE = false;
        }
        aVar.nuE = true;
        fVar.notifyDataSetChanged();
        return true;
    }
}
