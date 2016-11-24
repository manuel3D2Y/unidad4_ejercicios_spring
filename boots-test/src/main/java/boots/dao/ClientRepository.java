package boots.dao;

import org.springframework.data.repository.CrudRepository;

import boots.model.Client;

public interface ClientRepository extends CrudRepository<Client, Integer>{

}
