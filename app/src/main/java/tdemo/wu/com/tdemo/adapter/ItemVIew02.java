package tdemo.wu.com.tdemo.adapter;

import android.support.annotation.NonNull;

import com.wenld.multitypeadapter.base.MultiItemView;
import com.wenld.multitypeadapter.base.ViewHolder;

import tdemo.wu.com.tdemo.R;
import tdemo.wu.com.tdemo.bean.Bean2;

/**
 * Created by MX on 2018/5/28.
 */

public class ItemVIew02 extends MultiItemView<Bean2> {

    @NonNull
    @Override
    public int getLayoutId() {
        return R.layout.item_two;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Bean2 item, int position) {
        holder.setText(R.id.tv_item01, item.title);
        if (position  == 0 || position == 2 || position == 4|| position == 6 || position == 9) {
            holder.setBackgroundColor(R.id.tv_item01, 0xFF48F745);
        } else {
            holder.setBackgroundColor(R.id.tv_item01, 0xFFFF4081);
        }
    }
}
