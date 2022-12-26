package tn.esprit.test.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.test.entity.Events;
import tn.esprit.test.services.IEventsService;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/EventsC")

public class EventsController {

@Autowired
   IEventsService iEventsService;

    @GetMapping("/")
    public Iterable<Events>  GetAllEvents(){
        return iEventsService.retrieveAllEvents();
    }

    @GetMapping("/EventById/{idEvent}")
    public Optional< Events > GetEventbyId(@PathVariable("idEvent") Long idEvent){
        return iEventsService.findEventById(idEvent);
    }

    @PostMapping("/addEvent")
    @ResponseBody
    public void AddEvent(@RequestBody Events event) {
        iEventsService.addEvent(event);
    }


    @PutMapping("/updateEvent/{idEvent}")
    @ResponseBody
    public void updateUniversite(@RequestBody Events events , @PathVariable("idEvent")Long idEvent) {
        iEventsService.updateEvent(events,idEvent);


    }


    @DeleteMapping("/deleteEvent/{idEvent}")
    @ResponseBody
    public void deleteUniversite(@PathVariable("idEvent") Long idEvent ) {
        iEventsService.deleteEvent(idEvent);
    }


    @PostMapping("/addAndAssignEvent/{idUniversite}")
    @ResponseBody
    public void addAndAssignEvent(@RequestBody Events event , @PathVariable("idUniversite") Long idUniversite)
    {
        iEventsService.AddAndAssignEvent(event,idUniversite);
    }

    @GetMapping("/search/{nomEvent}")
    public Iterable<Events> searrch(@PathVariable("nomEvent") String nomEvent)
    {
        return iEventsService.ssearch(nomEvent);
    }
}
