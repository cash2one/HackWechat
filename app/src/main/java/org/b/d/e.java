package org.b.d;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.b.g.c;

public final class e {
    public final List<d> Ayr;

    public e() {
        this.Ayr = new ArrayList();
    }

    public e(List<d> list) {
        this.Ayr = new ArrayList(list);
    }

    public e(Map<String, String> map) {
        this();
        for (Entry entry : map.entrySet()) {
            this.Ayr.add(new d((String) entry.getKey(), (String) entry.getValue()));
        }
    }

    public final String cKk() {
        if (this.Ayr.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (d dVar : this.Ayr) {
            stringBuilder.append('&').append(c.encode(dVar.aAM).concat("=").concat(c.encode(dVar.value)));
        }
        return stringBuilder.toString().substring(1);
    }

    public final void a(e eVar) {
        this.Ayr.addAll(eVar.Ayr);
    }

    public final void acD(String str) {
        if (str != null && str.length() > 0) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                this.Ayr.add(new d(c.decode(split2[0]), split2.length > 1 ? c.decode(split2[1]) : ""));
            }
        }
    }
}
