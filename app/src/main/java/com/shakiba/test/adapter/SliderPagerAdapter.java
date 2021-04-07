package com.shakiba.test.adapter;

import android.app.Activity;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.shakiba.test.R;
import com.shakiba.test.model.CategoryModel;

import java.util.List;

public class SliderPagerAdapter extends PagerAdapter {

    public Activity mContext;
    private List<CategoryModel> mMyPlayListModelList;
    private LayoutInflater inflater;
    private boolean isMultiScr;


    public SliderPagerAdapter(Activity context, List<CategoryModel> myPlayListModelList, boolean isMultiScr) {
        this.mContext = context;
        mMyPlayListModelList = myPlayListModelList;
        if (context !=null){
            this.inflater = LayoutInflater.from(context);
        }
        this.isMultiScr = isMultiScr;
    }


    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.item_slider_home, view, false);
        assert imageLayout != null;
        final ImageView sliderImage = (ImageView) imageLayout.findViewById(R.id.round_image_slider);
        final TextView sliderText = (TextView) imageLayout.findViewById(R.id.text_view_slider_playlist_name);
        sliderImage.setImageDrawable(mMyPlayListModelList.get(position).getImageView());
        sliderText.setText(mMyPlayListModelList.get(position).getTextView());
        view.addView(imageLayout, 0);
        return imageLayout;
    }


    @Override
    public int getCount() {
        return mMyPlayListModelList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

}

