package de.hfu;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.*;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentService;
import de.hfu.residents.service.ResidentServiceException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
    public void utilTest() {
    	assert(Util.istErstesHalbjahr(1));
    }
    
    @Test (expected = IllegalStateException.class)
    public void queueLeerTest( ) {
    	Queue qEins = new Queue(3);
    	qEins.dequeue();
    }
    
    @Test 
    public void queueTest( ) {
    	Queue q = new Queue(3);
    	q.enqueue(1);
    	q.enqueue(2);
    	q.enqueue(3);
    	q.enqueue(4);
    	assert(q.dequeue() == 1);
    	assert(q.dequeue() == 2);
    	assert(q.dequeue() == 4);
    }
    
    
    class Residents implements ResidentRepository {

		@Override
		public List<Resident> getResidents() {
			// TODO Auto-generated method stub
			Vector<Resident> testResident = new Vector<Resident>();
			testResident.add(new Resident("David", "Pfau", "Rankweg", "Freudenstadt", new Date()));
			testResident.add(new Resident("Lukas", "Lokomotivfuehrer", "Lokstrasse", "Insel", new Date()));
			testResident.add(new Resident("Jim", "Knopf", "Lokstrasse", "Insel", new Date()));
			testResident.add(new Resident("Jimmy", "Knopf", "Robert Gerwig Platz", "Furtwangen", new Date()));
			testResident.add(new Resident("Can", "Demir", "Am Grosshausberg", "Furtwangen", new Date()));
			testResident.add(new Resident("Yannic", "Weinert", "Sportplatz", "Hotzenwald", new Date()));
			testResident.add(new Resident("Dominik", "Sprinzl", "Zahnriemenstrasse", "Civic", new Date()));
			testResident.add(new Resident("Linus", "Torvalds", "Kernelstrasse", "GNU/Linux", new Date()));
			return testResident;
		}
    	
    }
    
    @Test
    public void filterTest() {
    	BaseResidentService baseResidentService = new BaseResidentService();
    	Residents residentRepository = new Residents();
    	baseResidentService.setResidentRepository(residentRepository);
    	assert (baseResidentService.getFilteredResidentsList(new Resident("", "Knopf", "", "", new Date())).size() == 2);
    	assert (baseResidentService.getFilteredResidentsList(new Resident("", "Torvalds", "", "", new Date())).size() == 1);
    	assert (baseResidentService.getFilteredResidentsList(new Resident("D*", "", "", "", new Date())).size() == 2);
    	
    	try {
			assert (baseResidentService.getUniqueResident(new Resident("David", "", "", "", new Date())).getFamilyName() == "Pfau" );
		} catch (ResidentServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assert(false);
		}
    	try {
			assert (baseResidentService.getUniqueResident(new Resident("", "Torvalds", "", "", new Date())).getStreet() == "Kernelstrasse" );
		} catch (ResidentServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assert(false);
		}
    	try {
			baseResidentService.getUniqueResident(new Resident("", "", "", "Insel", new Date()));
			assert(false);
		} catch (ResidentServiceException e) {
			// TODO Auto-generated catch block
			assert(true);
		}
    }
    
    
}
