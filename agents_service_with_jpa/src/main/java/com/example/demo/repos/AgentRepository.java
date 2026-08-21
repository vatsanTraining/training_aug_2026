package com.example.demo.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.AddressBookDto;
import com.example.demo.entity.TravelAgent;
import com.example.demo.enums.AgentRole;

public interface AgentRepository extends JpaRepository<TravelAgent, Integer> {

	



	//DSL Query
	public List<TravelAgent> findByFirstName(String srchCrit);
	
	
	
	//Native Query
	@Query(value = "select * from travel_agents where id>:srchId",nativeQuery = true)
	public List<TravelAgent> idGrtThan(@Param("srchId") int id);
	
	
	
	// JPQL
	
    @Query(value = "from TravelAgent where dateOfBirth=:date",nativeQuery = false)
	public List<TravelAgent> getByDateOfBirth(@Param("date") LocalDate date);

    // Projection
	public List<AddressBookDto> findByDateOfBirth(@Param("date") LocalDate date);


    @Modifying
    @Query("UPDATE TravelAgent t SET t.role = :newRole WHERE t.firstName = :name")
    public int updateRoleByFirstName(@Param("newRole") AgentRole newRole, @Param("name") String name);

	
}
