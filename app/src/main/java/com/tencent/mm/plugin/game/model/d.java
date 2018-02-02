package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.c.cg;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;

public final class d extends f {
    public int fFj = 0;
    public String fop = "";
    public int fwH = 0;
    public int hts = 0;
    public String iKm = "";
    public String naP = "";
    public String naQ = "";
    public String naR = "#929292";
    public String naS = "";
    public String naT = "";
    public boolean naU = false;
    public String naV = "";
    public String naW = "";
    public String naX = "";
    public LinkedList<String> naY = new LinkedList();
    public String naZ = "";
    public String name = "";
    public LinkedList<String> nba = new LinkedList();
    public boolean nbb = false;
    public boolean nbc = false;
    public String nbd = "";
    public String nbe = "#fca28a";
    public String nbf = "";
    public String nbg = "#222222";
    public String nbh = "";
    public boolean nbi = false;
    public String nbj = "";
    public long nbk = 0;
    public cg nbl;
    public int position = 1;
    public int scene = 0;
    public int status = 0;
    public int type = 0;
    public int versionCode = 0;

    public final boolean aPT() {
        return ((this.hts != 1 && this.hts != 2) || this.nbl == null || bh.ov(this.nbl.niY)) ? false : true;
    }
}
