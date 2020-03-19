package com.jenkin.attachmentservice.respositories;

import com.jenkin.attachmentservice.model.Appendix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttachmentRepository extends JpaRepository<Appendix,Integer> {
//    Appendix findFirstByMusicIdAndAppendixType(int musicId,String type);
//    Appendix findFirstByAppendixCode(String code);
//    List<Appendix>  findAllByMusicIdAndAppendixTypeOrderByAppendixIdAsc(int musicId,String type);
//    void deleteByMusicIdAndAppendixType(int musicId,String type);
//    void deleteByMusicId(int musicId);
    void deleteByAppendixCode( String fileCode);
}