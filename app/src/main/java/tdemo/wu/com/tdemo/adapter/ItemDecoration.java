package tdemo.wu.com.tdemo.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by MX on 2018/5/28.
 */

public class ItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public ItemDecoration(int space) {
        this.space = space;
    }


    @Override
    public void getItemOffsets(
            Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //        int position = parent.getChildLayoutPosition(view);
        //        if (spanSizeLookup.getSpanSize(position) < 4) {
        outRect.top = space;
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;
        //        }
    }
}
