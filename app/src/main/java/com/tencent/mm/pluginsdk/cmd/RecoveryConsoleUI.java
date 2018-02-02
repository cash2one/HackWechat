package com.tencent.mm.pluginsdk.cmd;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.pluginsdk.cmd.b.a;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecoveryConsoleUI extends MMActivity implements OnItemClickListener {
    List<Map<String, String>> ltR;
    ListView pch;
    List<a> vcH;
    SimpleAdapter vcI;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Recovery Console");
        this.vcH = b.bYi();
        this.ltR = new ArrayList(this.vcH.size());
        for (a aVar : this.vcH) {
            HashMap hashMap = new HashMap();
            hashMap.put("title", getString(aVar.vcM));
            this.ltR.add(hashMap);
        }
        this.vcI = new SimpleAdapter(this, this.ltR, f.dnt, new String[]{"title"}, new int[]{16908310});
        this.pch = (ListView) findViewById(16908298);
        this.pch.setAdapter(this.vcI);
        this.pch.setOnItemClickListener(this);
    }

    protected final int getLayoutId() {
        return f.cwn;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a aVar = (a) this.vcH.get(i);
        if (aVar.vcN != null) {
            aVar.vcN.a(this, aVar.fMn.split(" +"));
        } else {
            b.aU(this, aVar.fMn);
        }
    }
}
