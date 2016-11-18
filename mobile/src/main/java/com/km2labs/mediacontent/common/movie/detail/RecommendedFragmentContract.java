package com.km2labs.mediacontent.common.movie.detail;

import com.km2labs.mediacontent.common.ui.adapter.RecyclerItemView;
import com.km2labs.mediacontent.common.ui.mvp.ILoadingView;
import com.km2labs.mediacontent.common.ui.mvp.IPresenter;

import java.util.List;

/**
 * Created by : Subham Tyagi
 * Created on :  04/10/16.
 */

public interface RecommendedFragmentContract {

    interface View extends ILoadingView {
        void showMovieList(List<RecyclerItemView> reviewList);
    }

    interface Presenter extends IPresenter<View> {
        void getRecommendedMovies(Integer movieId);
    }
}