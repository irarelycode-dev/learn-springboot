package jpadepth.repositories.manytomany;

import jpadepth.entity.manytomany.songs.Song;
import jpadepth.entity.manytomany.songs.SongId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongsRepository extends CrudRepository<Song, SongId> {
}
