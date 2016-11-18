package com.km2labs.mediacontent.common.movie.detail;

import com.km2labs.mediacontent.common.NetworkPresenter;
import com.km2labs.mediacontent.common.cache.DataCache;
import com.km2labs.mediacontent.common.movie.MovieService;
import com.km2labs.mediacontent.common.movie.bean.MovieDetailDto;

import rx.Observable;

/**
 * Created by : Subham Tyagi
 * Created on :  05/10/16.
 */

public class OverviewFragmentPresenter extends NetworkPresenter<OverviewFragmentContract.View> implements OverviewFragmentContract.Presenter {


    private MovieService mMovieService;

    private Integer mMovieId;

    public OverviewFragmentPresenter(MovieService movieService, DataCache dataCache) {
        super(dataCache);
        mMovieService = movieService;
    }


    @Override
    public void getMovieDetail(Integer movieId) {
        mMovieId = movieId;
        startLoading("MovieDetails");
    }

    @Override
    protected <D> void onRequestComplete(D data, String tag) {
        getView().onMovieDetailLoaded((MovieDetailDto) data);
    }

    @Override
    protected <D> Boolean isCachedDataValid(D data) {
        return data != null;
    }

    @Override
    protected Observable<?> getApiObservable(String tag) {
        return mMovieService.getMovieDetail(mMovieId, null);
    }

    @Override
    protected void handleError(String tag, Throwable throwable) {
        getView().onError();
    }
}