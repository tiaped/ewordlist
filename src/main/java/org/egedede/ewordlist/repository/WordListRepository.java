package org.egedede.ewordlist.repository;

import org.egedede.ewordlist.model.WordList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordListRepository extends JpaRepository<WordList, Long> {
  WordList findByName(String name);
}
