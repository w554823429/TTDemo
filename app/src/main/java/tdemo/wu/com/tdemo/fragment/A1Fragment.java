package tdemo.wu.com.tdemo.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wenld.multitypeadapter.MultiTypeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import tdemo.wu.com.tdemo.R;
import tdemo.wu.com.tdemo.adapter.ItemDecoration;
import tdemo.wu.com.tdemo.adapter.ItemVIew01;
import tdemo.wu.com.tdemo.adapter.ItemVIew02;
import tdemo.wu.com.tdemo.bean.Bean1;
import tdemo.wu.com.tdemo.bean.Bean2;

/**
 * A simple {@link Fragment} subclass.
 */
public class A1Fragment extends BaseFragment {

    private static final int SPAN_COUNT = 1;
    private MultiTypeAdapter adapter;
    List<Object> items;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private static A1Fragment fragmetnta1;

    public static A1Fragment getA1Fragmetnt() {
        if (fragmetnta1 == null) {
            fragmetnta1 = new A1Fragment();
        }
        return fragmetnta1;
    }

    @Override
    int getLayoutResources() {
        return R.layout.fragment_a1;
    }

    @Override
    void initView() {
        adapter = new MultiTypeAdapter();
        adapter.register(Bean1.class, new ItemVIew01());
        adapter.register(Bean2.class, new ItemVIew02());
        final GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                Object item = items.get(position);
                if (item instanceof Bean1) {
                    return 1;
                }
                if (item instanceof Bean2) {
                    return 1;
                }
                return SPAN_COUNT;
            }
        };
        layoutManager.setSpanSizeLookup(spanSizeLookup);
        recyclerView.setLayoutManager(layoutManager);
        int space = getResources().getDimensionPixelSize(R.dimen.normal_space);
        recyclerView.addItemDecoration(new ItemDecoration(space));
        recyclerView.setAdapter(adapter);
        items = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            items.add(new Bean2("type1_" + i));
        }
        for (int i = 0; i < 4; i++) {
            items.add(new Bean1("type2_" + i));
        }
        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }

}
