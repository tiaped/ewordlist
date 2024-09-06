package org.egedede.ewordlist;

import org.egedede.ewordlist.model.WordList;
import org.egedede.ewordlist.repository.WordListRepository;
import org.egedede.ewordlist.service.WordListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ListController {

  @Autowired private WordListService listService;

  @PutMapping("/list")
  public WordList createList(@RequestParam(name = "list") String listName) {
    listService.save(new WordList(null, listName));
    return listService.findByName(listName);
  }

  @GetMapping("/list/{listName}")
  public WordList getList(@PathVariable String listName) {
    WordList listByName = listService.findByName(listName);
    if (listByName == null) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND, "No list is associated to " + listName);
    }
    return listByName;
  }
}
