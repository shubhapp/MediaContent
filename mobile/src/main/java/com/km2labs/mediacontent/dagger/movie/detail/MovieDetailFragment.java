package com.km2labs.mediacontent.dagger.movie.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.km2labs.mediacontent.R;
import com.km2labs.mediacontent.common.movie.bean.MovieDetailDto;
import com.km2labs.mediacontent.common.movie.detail.MovieDetailContract;
import com.km2labs.mediacontent.common.movie.detail.MovieDetailPresenter;
import com.km2labs.mediacontent.common.ui.AbsNetworkFragment;
import com.km2labs.mediacontent.dagger.core.ui.fragment.BaseLoadingFragment;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovieDetailFragment extends AbsNetworkFragment implements MovieDetailContract.View {

    public static final String ARG_MOVIE_ID = "Args:Fragment:Movie:Detail:Id";

    @BindView(R.id.backdrop)
    ImageView mBackdrop;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.tablayout)
    TabLayout mTablayout;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    @Inject
    MovieDetailPresenter mPresenter;

    private MovieDetailDto mMovieDetailDto;

    //@Override
    protected int getLayoutResId() {
        return R.layout.movie_detail_fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    protected void loadData() {
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }

        int movieId = bundle.getInt(ARG_MOVIE_ID);

        if (movieId < 1) {
            return;
        }
        mPresenter.getMovieDetail(movieId);
    }

    @Override
    public void onMovieDetailReceived(MovieDetailDto movieDetailDto) {
        MovieDetailFragmentPagerAdapter adapter = new MovieDetailFragmentPagerAdapter(getContext(), getFragmentManager());
        adapter.setMovieDetailDto(movieDetailDto);
        mViewPager.setAdapter(adapter);
        mTablayout.setupWithViewPager(mViewPager, true);

        String imagePath = movieDetailDto.getBackdropPath();
        Picasso.with(mBackdrop.getContext())
                .load("http://image.tmdb.org/t/p/w500/" + imagePath)
                .fit()
                .into(mBackdrop);
    }

    @Override
    protected int getLayoutView() {
        return 0;
    }

    @Override
    protected void onRetry() {

    }

    @Override
    public void onRequestStart() {

    }

    @Override
    public void onRequestComplete(boolean success) {

    }

    @Override
    public void onError(Throwable error) {

    }
}
