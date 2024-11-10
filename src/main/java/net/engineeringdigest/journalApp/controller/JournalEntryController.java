package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean create( @RequestBody JournalEntry journalReq ){
        journalEntries.put(journalReq.getId(), journalReq);
        return true;
    }

    @GetMapping("/{id}")
    public JournalEntry getById(@PathVariable(value = "id", required = true) long id){
        return journalEntries.get(id);
    }

    @DeleteMapping("/{id}")
    public JournalEntry deleteById(@PathVariable(value = "id", required = true) long id){
        return journalEntries.remove(id);
    }

    @PutMapping("/{id}")
    public JournalEntry updateById(@PathVariable(value = "id", required = true) long id,
                                   @RequestBody JournalEntry journalEntryReq){
        return journalEntries.put(journalEntryReq.getId(), journalEntryReq);
    }
}
