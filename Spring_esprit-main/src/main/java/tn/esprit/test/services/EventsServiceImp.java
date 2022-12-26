package tn.esprit.test.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.test.entity.Events;
import tn.esprit.test.entity.Universite;
import tn.esprit.test.repositories.EventsRepository;
import tn.esprit.test.repositories.UniversiteRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class EventsServiceImp implements  IEventsService{

    @Autowired
    EventsRepository eventsRepository;
    @Autowired
    UniversiteRepository universiteRepository;


    public Long addEvent(Events e) {
        eventsRepository.save(e);
        log.info("add event");
        return e.getIdEvent();
    }




    public Iterable<Events> retrieveAllEvents() {return eventsRepository.findAll();}

    public Optional<Events> findEventById(Long idEvent) {
        return eventsRepository.findById(idEvent);
    }

    public void deleteEvent(Long idEvent) {
        eventsRepository.deleteById(idEvent);}

    public void updateEvent(Events events, Long idEvent ) {
        Events u = eventsRepository.findById(idEvent).get();
        u.setDateEvent(events.getDateEvent());
        u.setType(events.getType());
        u.setNomEvent((events.getNomEvent()));
        u.setDescription(events.getDescription());
        u.setLocation(events.getLocation());
        eventsRepository.save(u);}

    public Events retrieveEvent(Long idEvent) {
        return eventsRepository.findById(idEvent).get();
    }

    @Transactional
    public Events AddAndAssignEvent(Events e , Long idUniversite ){
        Universite univ = universiteRepository.findById(idUniversite).orElse(null);
        e.setUniv(univ);
        eventsRepository.save(e);
        return eventsRepository.save(e);

    }


    public List<Events> ssearch(String nomEvent )
    {

        return eventsRepository.search(nomEvent);
    }
}
