/*
 * The MIT License (MIT)
 * <p/>
 * Copyright (c) 2016 Bertrand Martel
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 */

package fr.bmartel.youtubetv.media;

import android.content.Context;
import android.graphics.Color;
import java.util.ArrayList;

import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.PlaybackControlsRowPresenter;
import fr.bmartel.youtubetv.IYoutubeApi;
import fr.bmartel.youtubetv.listener.IVideoInfoListener;
import fr.bmartel.youtubetv.model.VideoInfo;
import fr.bmartel.youtubetv.model.VideoQuality;

public abstract class VideoMediaPlayerGlue extends MediaPlayerGlue implements IVideoInfoListener {

    private final PlaybackControlsRow.HighQualityAction mHighQualityAction;

    private VideoInfo mVideoInfo = new VideoInfo("", "", "", new ArrayList<VideoQuality>());

    public VideoMediaPlayerGlue(Context context,
                                PlaybackOverlayFragment fragment,
                                IYoutubeApi youtubePlayer) {
        super(context, fragment, youtubePlayer);
        setVideoInfoListener(this);

        // Instantiate secondary actions
        //mClosedCaptioningAction = new PlaybackControlsRow.ClosedCaptioningAction(context);
        mHighQualityAction = new PlaybackControlsRow.HighQualityAction(context);
        mHighQualityAction.setLabel1("Quality");

        setFadingEnabled(true);
    }


    @Override
    protected void addSecondaryActions(ArrayObjectAdapter secondaryActionsAdapter) {
        //secondaryActionsAdapter.add(mClosedCaptioningAction);
        //secondaryActionsAdapter.add(mHighQualityAction);
        /*
        secondaryActionsAdapter.add(mThumbsDownAction);
        secondaryActionsAdapter.add(mThumbsUpAction);
        */
    }

    @Override
    public void onActionClicked(Action action) {
        super.onActionClicked(action);
        if (action == mHighQualityAction) {
            //mHighQualityAction.nextIndex();
            //mYoutubePlayer.pause();
            //mVideoActivity.displayQualityFragment(mVideoInfo.getAvailableQualityList());
        }
    }

    public void setupControlsRowPresenter(PlaybackControlsRowPresenter presenter) {
        // TODO: hahnr@ move into resources
        presenter.setProgressColor(Color.parseColor("#e3e3e3"));
        presenter.setBackgroundColor(Color.parseColor("#e52d27"));
    }

    @Override
    public void onVideoInfoReceived(VideoInfo videoInfo) {
        mVideoInfo = videoInfo;
    }
}
