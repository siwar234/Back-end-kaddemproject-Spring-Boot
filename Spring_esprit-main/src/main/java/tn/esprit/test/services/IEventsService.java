package tn.esprit.test.services;

import tn.esprit.test.entity.Events;

import java.util.List;
import java.util.Optional;
public interface IEventsService {

    public Long addEvent(Events event);

    public Iterable<Events> retrieveAllEvents();

    public Optional<Events> findEventById(Long idEvent);

    public void updateEvent(Events events, Long idEvent);

    public void deleteEvent(Long idEvent);

    public Events AddAndAssignEvent(Events event, Long idUniversite);

    public Iterable<Events> ssearch(String nomEvent);
}
