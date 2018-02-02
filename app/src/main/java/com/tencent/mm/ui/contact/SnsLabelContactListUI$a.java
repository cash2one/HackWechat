package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.l.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

class SnsLabelContactListUI$a extends BaseAdapter {
    private Context context = null;
    private ar rzI = null;
    private Map<Integer, a> yUN = new HashMap();
    private ColorStateList yUO;
    private ColorStateList yUP;

    public SnsLabelContactListUI$a(Context context, List<String> list) {
        XmlResourceParser xml;
        XmlResourceParser xml2;
        Throwable e;
        XmlResourceParser xmlResourceParser = null;
        this.context = context;
        this.yUN.clear();
        com.tencent.mm.z.ar.Hg();
        this.rzI = c.EY();
        int i = 0;
        for (String str : list) {
            a aVar = new a();
            aVar.setUsername(str);
            int i2 = i + 1;
            this.yUN.put(Integer.valueOf(i), aVar);
            i = i2;
        }
        try {
            xml = context.getResources().getXml(R.e.bth);
            try {
                xml2 = context.getResources().getXml(R.e.bti);
                try {
                    this.yUO = ColorStateList.createFromXml(context.getResources(), xml);
                    this.yUP = ColorStateList.createFromXml(context.getResources(), xml2);
                    if (xml != null) {
                        xml.close();
                    }
                    if (xml2 != null) {
                        xml2.close();
                    }
                } catch (XmlPullParserException e2) {
                    e = e2;
                    xmlResourceParser = xml;
                    try {
                        x.printErrStackTrace("MicroMsg.SnsLabelContactListUI", e, "", new Object[0]);
                        if (xmlResourceParser != null) {
                            xmlResourceParser.close();
                        }
                        if (xml2 == null) {
                            xml2.close();
                        }
                    } catch (Throwable th) {
                        e = th;
                        xml = xmlResourceParser;
                        if (xml != null) {
                            xml.close();
                        }
                        if (xml2 != null) {
                            xml2.close();
                        }
                        throw e;
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.SnsLabelContactListUI", e, "", new Object[0]);
                        if (xml != null) {
                            xml.close();
                        }
                        if (xml2 == null) {
                            xml2.close();
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        if (xml != null) {
                            xml.close();
                        }
                        if (xml2 != null) {
                            xml2.close();
                        }
                        throw e;
                    }
                }
            } catch (XmlPullParserException e4) {
                e = e4;
                xml2 = null;
                xmlResourceParser = xml;
                x.printErrStackTrace("MicroMsg.SnsLabelContactListUI", e, "", new Object[0]);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
                if (xml2 == null) {
                    xml2.close();
                }
            } catch (IOException e5) {
                e = e5;
                xml2 = null;
                x.printErrStackTrace("MicroMsg.SnsLabelContactListUI", e, "", new Object[0]);
                if (xml != null) {
                    xml.close();
                }
                if (xml2 == null) {
                    xml2.close();
                }
            } catch (Throwable th3) {
                e = th3;
                xml2 = null;
                if (xml != null) {
                    xml.close();
                }
                if (xml2 != null) {
                    xml2.close();
                }
                throw e;
            }
        } catch (XmlPullParserException e6) {
            e = e6;
            xml2 = null;
            x.printErrStackTrace("MicroMsg.SnsLabelContactListUI", e, "", new Object[0]);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            if (xml2 == null) {
                xml2.close();
            }
        } catch (IOException e7) {
            e = e7;
            xml2 = null;
            xml = null;
            x.printErrStackTrace("MicroMsg.SnsLabelContactListUI", e, "", new Object[0]);
            if (xml != null) {
                xml.close();
            }
            if (xml2 == null) {
                xml2.close();
            }
        } catch (Throwable th4) {
            e = th4;
            xml2 = null;
            xml = null;
            if (xml != null) {
                xml.close();
            }
            if (xml2 != null) {
                xml2.close();
            }
            throw e;
        }
    }

    public final int getCount() {
        return this.yUN.size();
    }

    public final Object getItem(int i) {
        if (i < 0) {
            return null;
        }
        a aVar = (a) this.yUN.get(Integer.valueOf(i));
        if (aVar.field_showHead != 0) {
            return aVar;
        }
        com.tencent.mm.storage.x WO = this.rzI.WO(aVar.field_username);
        if (WO == null) {
            return aVar;
        }
        this.yUN.put(Integer.valueOf(i), WO);
        return WO;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        SnsLabelContactListUI.c cVar;
        if (view == null) {
            view = View.inflate(this.context, R.i.deO, null);
            SnsLabelContactListUI.c cVar2 = new SnsLabelContactListUI.c((byte) 0);
            cVar2.nJd = (TextView) view.findViewById(R.h.bYz);
            cVar2.ldx = (MaskLayout) view.findViewById(R.h.bYx);
            cVar2.kEZ = (TextView) view.findViewById(R.h.bYB);
            cVar2.yUR = (TextView) view.findViewById(R.h.bYv);
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (SnsLabelContactListUI.c) view.getTag();
        }
        getItem(i);
        a aVar = (a) getItem(i);
        cVar.nJd.setVisibility(8);
        cVar.kEZ.setTextColor(!s.hn(aVar.field_username) ? this.yUO : this.yUP);
        b.b((ImageView) cVar.ldx.view, aVar.field_username, true);
        cVar.yUR.setVisibility(8);
        cVar.ldx.setVisibility(0);
        cVar.kEZ.setText(i.b(this.context, aVar.AQ(), cVar.kEZ.getTextSize()));
        cVar.kEZ.setVisibility(0);
        return view;
    }
}
