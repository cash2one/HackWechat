package com.tencent.mm.ui.conversation;

import android.os.Bundle;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public class SettingCheckUnProcessWalletConvUI extends MMActivity {
    private ListView kGl;
    private int[] yXp = new int[2];
    private List<String> zah;
    private a zai;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eWi);
        setBackBtn(new 1(this));
        this.kGl = (ListView) findViewById(R.h.bYW);
        this.zah = getIntent().getStringArrayListExtra("key_conversation_list");
        if (this.zah != null && this.zah.size() > 0) {
            this.zai = new a(this);
            this.kGl.setAdapter(this.zai);
            this.kGl.setOnTouchListener(new 2(this));
            this.kGl.setOnItemClickListener(new 3(this));
            this.kGl.setOnItemLongClickListener(new 4(this));
        }
    }

    protected final int getLayoutId() {
        return R.i.drS;
    }
}
