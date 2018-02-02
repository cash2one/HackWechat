package com.tencent.mm.modelstat;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;

class c$c {
    long hQs;
    float hQt;
    int hQu;
    String hQv;
    ArrayList<Pair<String, Boolean>> hQw;
    ArrayList<Pair<String, String>> hQx;
    int id;
    String name;

    private c$c() {
        this.hQw = new ArrayList();
        this.hQx = new ArrayList();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ReportConfigEvent{");
        stringBuilder.append("id=" + this.id);
        stringBuilder.append(", name='" + this.name + "'");
        stringBuilder.append(", expireTime=" + this.hQs);
        stringBuilder.append(", rate=" + this.hQt);
        stringBuilder.append(", logId=" + this.hQu);
        stringBuilder.append(", pagesType='" + this.hQv + "'");
        stringBuilder.append(", pageList=[");
        Iterator it = this.hQw.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            stringBuilder.append("{" + ((String) pair.first) + "," + pair.second + "}");
            stringBuilder.append(",");
        }
        stringBuilder.append("]");
        stringBuilder.append(", specialPVPages=[");
        it = this.hQx.iterator();
        while (it.hasNext()) {
            pair = (Pair) it.next();
            stringBuilder.append("{" + ((String) pair.first) + "," + ((String) pair.second) + "}");
            stringBuilder.append(",");
        }
        stringBuilder.append("]}");
        return stringBuilder.toString();
    }
}
