package com.PlantPlaces.enterprise;

import com.PlantPlaces.enterprise.dao.ISpecimenDAO;
import com.PlantPlaces.enterprise.dto.Specimen;
import com.PlantPlaces.enterprise.service.ISpecimenService;
import com.PlantPlaces.enterprise.service.SpecimenServiceStub;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
class EnterpriseApplicationTests {

	private ISpecimenService specimenService;
	private Specimen specimen = new Specimen();

	@MockBean
	private ISpecimenDAO specimenDAO;

	@Test
	void contextLoads() {
	}

	@Test
	void fetchSpecimenByID_returnsRedbudForID83() throws Exception {
		givenSpecimenDataAreAvailable();
		whenSearchSpecimenWithID83();
		thenReturnOneEasternRedbudSpecimenForID83();
	}

	private void givenSpecimenDataAreAvailable() throws Exception {
		Mockito.when(specimenDAO.save(specimen)).thenReturn(specimen);
		specimenService = new SpecimenServiceStub(specimenDAO);
	}

	private void whenSearchSpecimenWithID83() {
		specimen = specimenService.fetchById(83);
	}

	private void thenReturnOneEasternRedbudSpecimenForID83() {
		String description  = specimen.getDescription();
		assertEquals("Eastern Redbud", description);
	}

	@Test
	void saveSpecimen_ValidateReturnSpecimenWithLatitudeAndLongitude() throws Exception {
		givenSpecimenDataAreAvailable();
		whenUserCreatesANewSpecimenAndSaves();
		thenCreateNewSpecimenRecordAndReturnIt();
	}
	private void whenUserCreatesANewSpecimenAndSaves(){
		specimen.setLatitude("39.74");
		specimen.setLongitude("-84.51");
	}

	private void thenCreateNewSpecimenRecordAndReturnIt() throws Exception {
		Specimen createdSpecimen = specimenService.save(specimen);
		assertEquals(specimen,createdSpecimen);
		verify(specimenDAO, atLeastOnce()).save(specimen);
	}
}
