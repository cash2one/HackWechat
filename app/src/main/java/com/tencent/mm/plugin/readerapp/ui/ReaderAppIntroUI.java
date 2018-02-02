package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.readerapp.a.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.bf;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public class ReaderAppIntroUI extends MMActivity {
    private int fEj = 0;

    protected final int getLayoutId() {
        return R.i.dqm;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        ImageView imageView = (ImageView) findViewById(R.h.cFM);
        TextView textView = (TextView) findViewById(R.h.cFN);
        this.fEj = getIntent().getIntExtra(DownloadSettingTable$Columns.TYPE, 0);
        if (this.fEj == 20) {
            setMMTitle(R.l.eoI);
            imageView.setImageResource(R.g.bFe);
            textView.setText(R.l.dWb);
        }
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ ReaderAppIntroUI pAL;

            {
                this.pAL = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pAL.finish();
                return true;
            }
        });
        addIconOptionMenu(0, R.k.dvc, new OnMenuItemClickListener(this) {
            final /* synthetic */ ReaderAppIntroUI pAL;

            {
                this.pAL = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                a.ifs.d(new Intent().putExtra("Contact_User", bf.gT(this.pAL.fEj)), this.pAL);
                this.pAL.finish();
                return true;
            }
        });
    }
}
