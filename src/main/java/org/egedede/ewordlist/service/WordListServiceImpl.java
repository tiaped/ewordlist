package org.egedede.ewordlist.service;

import org.egedede.ewordlist.model.WordList;
import org.egedede.ewordlist.repository.WordListRepository;

public class WordListServiceImpl implements WordListService {
  private final WordListRepository listRepository;

  public WordListServiceImpl(WordListRepository listRepository) {
    this.listRepository = listRepository;
  }

  @Override
  public WordList findByName(String listName) {
    return null;
  }

  @Override
  public void save(WordList list) {}
}
