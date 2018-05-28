package tdemo.wu.com.tdemo.adapter;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wenld.multitypeadapter.base.MultiItemView;
import com.wenld.multitypeadapter.base.ViewHolder;

import tdemo.wu.com.tdemo.R;
import tdemo.wu.com.tdemo.bean.Bean1;

/**
 * Created by MX on 2018/5/28.
 */

public class ItemVIew01 extends MultiItemView<Bean1> {
    @NonNull
    @Override
    public int getLayoutId() {
        return R.layout.item_one;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Bean1 item, int position) {
        holder.setText(R.id.tv_item01, item.title);
        ImageView iv = holder.getView(R.id.iv_item01);

        Glide.with(iv.getContext())
                .load(item.imgUrl)
                                .placeholder(R.mipmap.s) // can also be a drawable
                //                .error(R.mipmap.cheese) // will be displayed if the image cannot be loaded
//                .centerCrop()
                .into(iv);

    }
}
