package boots.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boots.dao.ClientRepository;
import boots.model.Client;


@Service @Transactional
public class ClientService {

	private final ClientRepository ClientRepository;
	
	public ClientService(ClientRepository clientRepository){
		super();
		this.ClientRepository = clientRepository;
	}
	
	public List<Client> findAll(){
		List<Client> clients = new ArrayList<Client>();
		for(Client client : ClientRepository.findAll()){
			clients.add(client);
		}
		return clients;
	}
	
	public void save(Client client){
		ClientRepository.save(client);
	}
	
	public void delete(int id){
		ClientRepository.delete(id);
	}
	
	public Client findOne(int id){
		return ClientRepository.findOne(id);
	}
}
