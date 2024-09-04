package org.egedede.ewordlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    WordList listByName = listRepository.findByName(listName);
    if (listByName == null) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND, "No list is associated to " + listName);
    }
    return listByName;
  }
}
