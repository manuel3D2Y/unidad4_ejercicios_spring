package boots.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boots.dao.AstronautRepository;
import boots.model.Astronaut;



@Service @Transactional
public class AstronautService {

private final AstronautRepository astronautRepository;
	
	public AstronautService(AstronautRepository astronautRepository){
		super();
		this.astronautRepository = astronautRepository;
	}
	
	public List<Astronaut> findAll(){
		List<Astronaut> astronauts = new ArrayList<Astronaut>();
		for(Astronaut astronaut : astronautRepository.findAll()){
			astronauts.add(astronaut);
		}
		return astronauts;
	}
	
	public void save(Astronaut astronaut){
		astronautRepository.save(astronaut);
	}
	
	public void delete(int id){
		astronautRepository.delete(id);
	}
	
	public Astronaut findOne(int id){
		return astronautRepository.findOne(id);
	}
	
}
