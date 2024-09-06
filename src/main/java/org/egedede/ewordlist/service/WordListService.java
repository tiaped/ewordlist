package org.egedede.ewordlist.service;

import org.egedede.ewordlist.model.WordList;

public interface WordListService {
  WordList findByName(String listName);

  void save(WordList list);
}
