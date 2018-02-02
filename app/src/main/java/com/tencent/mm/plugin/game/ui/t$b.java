package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.ui.t.c;
import com.tencent.mm.protocal.c.wv;
import com.tencent.mm.protocal.c.ww;
import java.util.LinkedList;

public class t$b {
    public int actionType;
    public String appId;
    public String fod;
    public long hVE;
    public String hhi;
    public String iIj;
    public String iconUrl;
    public String name;
    public String nvg;
    public ww nvh;
    public String nvi;
    public LinkedList<String> nvj;
    public int nvk;
    public int nvl;
    public boolean nvm = false;
    public boolean nvn = false;
    public c nvo;
    public int type;

    public static t$b an(int i, String str) {
        t$b com_tencent_mm_plugin_game_ui_t_b = new t$b();
        com_tencent_mm_plugin_game_ui_t_b.type = i;
        com_tencent_mm_plugin_game_ui_t_b.name = str;
        com_tencent_mm_plugin_game_ui_t_b.nvo = new c();
        return com_tencent_mm_plugin_game_ui_t_b;
    }

    public static t$b a(wv wvVar) {
        t$b com_tencent_mm_plugin_game_ui_t_b = new t$b();
        com_tencent_mm_plugin_game_ui_t_b.type = 2;
        com_tencent_mm_plugin_game_ui_t_b.name = wvVar.fon;
        com_tencent_mm_plugin_game_ui_t_b.iIj = wvVar.nfe;
        com_tencent_mm_plugin_game_ui_t_b.iconUrl = wvVar.pbP;
        com_tencent_mm_plugin_game_ui_t_b.nvi = wvVar.wgR;
        com_tencent_mm_plugin_game_ui_t_b.nvk = wvVar.whm;
        com_tencent_mm_plugin_game_ui_t_b.nvl = wvVar.whn;
        com_tencent_mm_plugin_game_ui_t_b.appId = wvVar.ngo;
        com_tencent_mm_plugin_game_ui_t_b.hhi = wvVar.niZ;
        com_tencent_mm_plugin_game_ui_t_b.hVE = (long) wvVar.bZN;
        com_tencent_mm_plugin_game_ui_t_b.nvo = new c(wvVar.wgR, (byte) 0);
        return com_tencent_mm_plugin_game_ui_t_b;
    }
}
