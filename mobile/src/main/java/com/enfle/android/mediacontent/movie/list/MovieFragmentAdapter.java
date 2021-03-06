package com.enfle.android.mediacontent.movie.list;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.enfle.android.mediacontent.R;

public class MovieFragmentAdapter extends FragmentStatePagerAdapter {

    private Context mContext;

    public MovieFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        MovieListType type;
        switch (position) {
            case 0:
                type = MovieListType.NOW_PLAYING;
                break;
            case 1:
                type = MovieListType.UPCOMING;
                break;
            case 2:
                type = MovieListType.LATEST;
                break;
            case 3:
                type = MovieListType.POPULAR;
                break;
            case 4:
                type = MovieListType.TOP_RATED;
                break;
            default:
                type = MovieListType.NOW_PLAYING;
        }
        Bundle bundle = new Bundle();
        bundle.putString(MovieListFragment.ARG_MOVIE_LIST_TYPE, type.name());
        Fragment fragment = new MovieListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.now_playing);
            case 1:
                return mContext.getString(R.string.upcoming);
            case 2:
                return mContext.getString(R.string.latest);
            case 3:
                return mContext.getString(R.string.popular);
            case 4:
                return mContext.getString(R.string.top_rated);
            default:
                return mContext.getString(R.string.now_playing);
        }
    }
}