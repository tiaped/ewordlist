package org.egedede.ewordlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ListController {

  @Autowired private WordListRepository listRepository;

  @PutMapping("/list")
  public WordList createList(@RequestParam(name = "list") String listName) {
    WordList save = listRepository.save(new WordList(null, listName));
    return save;
  }

  @GetMapping("/list/{listName}")
  public WordList getList(@PathVariable String listName) {
    return listRepository.findByName(listName);
  }
}
