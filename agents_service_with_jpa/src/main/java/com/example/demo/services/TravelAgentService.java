package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AddressBookDto;
import com.example.demo.dto.TravelAgentDto;
import com.example.demo.entity.TravelAgent;
import com.example.demo.repos.AgentRepository;
import com.example.demo.utils.TravelAgentMapper;

@Service
public class TravelAgentService {

	
	private AgentRepository repo;

	private TravelAgentMapper mapper;
	
	public TravelAgentService(AgentRepository repo,TravelAgentMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
		System.out.println(this.repo.getClass().getName());
	}
	
	
	public TravelAgentDto save(TravelAgentDto dto) {
		
		TravelAgent saved= this.repo.save(mapper.toEntity(dto));
		
		return mapper.toDto(saved);
	}
	
	
	public List<TravelAgentDto> findAll(){
		
		return this.repo.findAll()
				  .stream().map(mapper::toDto).toList();
	}
	
	public TravelAgentDto findById(Integer id) {
		
		TravelAgent found = this.repo.findById(id)
				 .orElseThrow(()-> new RuntimeException("Element with  Id:= "+id+ " Not Present"));
		
		return mapper.toDto(found);
	}


    public void remove(Integer id) {
    	
        if (!this.repo.existsById(id)) {
            throw new RuntimeException("Element with Id:= " + id + " Not Present");
        }
        this.repo.deleteById(id);
    }

    public TravelAgentDto update(Integer id, TravelAgentDto dtoUpdate) {
    	
        TravelAgent existingAgent = this.repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Element with Id:= " + id + " Not Present"));
        
        existingAgent.setFirstName(dtoUpdate.firstName());
        existingAgent.setPhoneNumber(dtoUpdate.phoneNumber());
        existingAgent.setDateOfBirth(dtoUpdate.dateOfBirth());
        existingAgent.setRole(dtoUpdate.role());
        
        TravelAgent updated = this.repo.save(existingAgent);
        return mapper.toDto(updated);
    }
    

    public TravelAgentDto partialUpdate(Integer id, long phoneNumber) {
        TravelAgent existingAgent = this.repo.findById(id)
                .orElseThrow(() -> new RuntimeException("with Id:= " + id + " Not Present"));
        
        existingAgent.setPhoneNumber(phoneNumber);
        
        TravelAgent updated = this.repo.save(existingAgent);
        return mapper.toDto(updated);
    }



      public List<TravelAgentDto> findByFirstName(String firstName){
    	  
    	  return this.repo.findByFirstName(firstName).stream()
    	                .map(mapper::toDto).toList();
      }

public List<TravelAgentDto> findByIdGrtThan(Integer id){
    	  
    	  return this.repo.idGrtThan(id).stream()
    	                .map(mapper::toDto).toList();
      }


//public List<TravelAgentDto> getByDateOfBirth(LocalDate date){
//	  
//	  return this.repo.getByDateOfBirth(date).stream()
//	                .map(mapper::toDto).toList();
//}

public List<AddressBookDto> getByDateOfBirth(LocalDate date){
	  
	   this.repo.findByDateOfBirth(date).forEach(System.out::println);
	   
	  return this.repo.findByDateOfBirth(date);
			  
}


}
