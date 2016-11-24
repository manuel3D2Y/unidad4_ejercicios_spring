package boots.dao;

import org.springframework.data.repository.CrudRepository;

import boots.model.Astronaut;

public interface AstronautRepository extends CrudRepository<Astronaut, Integer>{

}
