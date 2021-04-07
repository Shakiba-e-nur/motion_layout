package com.shakiba.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.shakiba.test.adapter.SliderPagerAdapter;
import com.shakiba.test.databinding.ActivityMainBinding;
import com.shakiba.test.model.CategoryModel;
import com.tmall.ultraviewpager.UltraViewPager;
import com.tmall.ultraviewpager.transformer.UltraDepthScaleTransformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;
    private List<CategoryModel> list=new ArrayList<>();
    private SliderPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        getLifecycle().addObserver(mBinding.mainImageView);
        mBinding.mainImageView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);
                String videoId = "SHJTbFJEJj0";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
        CategoryModel categoryModel=new CategoryModel(getResources().getDrawable(R.drawable.item1),"Item1");
        CategoryModel categoryModel1=new CategoryModel(getResources().getDrawable(R.drawable.item2),"Item2");
        CategoryModel categoryModel2=new CategoryModel(getResources().getDrawable(R.drawable.item3),"Item3");
        CategoryModel categoryModel3=new CategoryModel(getResources().getDrawable(R.drawable.item1),"Item4");
        list.add(categoryModel);
        list.add(categoryModel1);
        list.add(categoryModel2);
        list.add(categoryModel3);
        initSliderViewPager();
    }
    /**
     * Init slider update view pager
     */
    private void initSliderViewPager() {

        mBinding.viewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        if (list !=null){
            adapter = new SliderPagerAdapter(MainActivity.this, list, true);
        }
        mBinding.viewPager.setAdapter(adapter);
        mBinding.viewPager.setMultiScreen(0.5f);
        mBinding.viewPager.setItemRatio(1.0f);
        mBinding.viewPager.setRatio(2.0f);
        mBinding.viewPager.setInfiniteLoop(true);
        mBinding.viewPager.setAutoScroll(2000);
        mBinding.viewPager.setPageTransformer(false, new UltraDepthScaleTransformer());

    }
}