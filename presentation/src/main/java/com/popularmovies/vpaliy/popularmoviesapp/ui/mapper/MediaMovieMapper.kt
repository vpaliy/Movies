package com.popularmovies.vpaliy.popularmoviesapp.ui.mapper

import android.net.Uri
import com.popularmovies.vpaliy.data.mapper.Mapper
import com.popularmovies.vpaliy.domain.entity.Movie
import com.popularmovies.vpaliy.popularmoviesapp.ui.model.MediaModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton class MediaMovieMapper @Inject constructor():Mapper<MediaModel,Movie>{
    override fun map(fake: Movie): MediaModel {
        val poster=fake.poster?: Uri.parse("R.drawable.popcorn").toString()
        val backdrop=fake.backdropImage?:poster
        return MediaModel(fake.id,poster,fake.title,backdrop)
    }

    override fun reverse(real: MediaModel)=Movie().apply {
        this.id=real.id
        this.backdropImage=real.backdrop
        this.title=real.title
        this.poster=real.poster
    }
}