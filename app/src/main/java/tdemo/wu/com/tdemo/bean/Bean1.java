package tdemo.wu.com.tdemo.bean;

import android.support.annotation.DrawableRes;

import java.io.Serializable;

/**
 * Created by MX on 2018/5/28.
 */

public class Bean1 implements Serializable {
    public String title;
    public @DrawableRes
    int imgRes;
    public String imgUrl = "http://upload-images.jianshu.io/upload_images/1599843-6bccd8b6bf4a90b7.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240";

    public Bean1(String title) {
        this.title=title;
    }
}
