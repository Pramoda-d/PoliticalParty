package com.training.ratings.boundary;

import static com.training.ratings.testutils.TestUtils.boundaryTestFile;
import static com.training.ratings.testutils.TestUtils.currentTest;
import static com.training.ratings.testutils.TestUtils.testReport;
import static com.training.ratings.testutils.TestUtils.testAssert;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.training.ratings.dto.DevelopmentDto;
import com.training.ratings.dto.PoliticalLeaderDto;
import com.training.ratings.dto.PoliticalPartyDto;
import com.training.ratings.testutils.MasterData;

@ExtendWith(SpringExtension.class)
public class BoundaryTest {
	private static Validator validator;

	// ----------------------------------------------------------------------------------------------
	@BeforeAll
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testPoliticalPartyNameNotNull() throws Exception {
		PoliticalPartyDto politicalPartyDto = MasterData.getPartyDto();
		politicalPartyDto.setPartyName("");
		Set<ConstraintViolation<PoliticalPartyDto>> violations = validator.validate(politicalPartyDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testPoliticalPartyNameMinFive() throws Exception {
		PoliticalPartyDto politicalPartyDto = MasterData.getPartyDto();
		politicalPartyDto.setPartyName("Ab");
		Set<ConstraintViolation<PoliticalPartyDto>> violations = validator.validate(politicalPartyDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testPoliticalPartyNameMaxHundred() throws Exception {
		PoliticalPartyDto politicalPartyDto = MasterData.getPartyDto();
		String partyName = "";
		for (int i = 0; i < 120; i++) {
			partyName.concat("A");
		}
		politicalPartyDto.setPartyName(partyName);
		Set<ConstraintViolation<PoliticalPartyDto>> violations = validator.validate(politicalPartyDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testPartyFounderNameNotNull() throws Exception {
		PoliticalPartyDto politicalPartyDto = MasterData.getPartyDto();
		politicalPartyDto.setFounderName("");
		Set<ConstraintViolation<PoliticalPartyDto>> violations = validator.validate(politicalPartyDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testPartyFounderNameMinFive() throws Exception {
		PoliticalPartyDto politicalPartyDto = MasterData.getPartyDto();
		politicalPartyDto.setFounderName("Ab");
		Set<ConstraintViolation<PoliticalPartyDto>> violations = validator.validate(politicalPartyDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testPartyFounderNameMaxHundred() throws Exception {
		PoliticalPartyDto politicalPartyDto = MasterData.getPartyDto();
		String founderName = "";
		for (int i = 0; i < 120; i++) {
			founderName.concat("A");
		}
		politicalPartyDto.setFounderName(founderName);
		Set<ConstraintViolation<PoliticalPartyDto>> violations = validator.validate(politicalPartyDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testPoliticalLeaderPartyIdNotNull() throws Exception {
		PoliticalLeaderDto politicalLeaderDto = MasterData.getPoliticalLeaderDto();
		politicalLeaderDto.setPoliticalPartyId(null);
		Set<ConstraintViolation<PoliticalLeaderDto>> violations = validator.validate(politicalLeaderDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testPoliticalLeaderCandidateNameNotNull() throws Exception {
		PoliticalLeaderDto politicalLeaderDto = MasterData.getPoliticalLeaderDto();
		politicalLeaderDto.setCandidateName("");
		Set<ConstraintViolation<PoliticalLeaderDto>> violations = validator.validate(politicalLeaderDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testPoliticalLeaderCandidateNameMinFive() throws Exception {
		PoliticalLeaderDto politicalLeaderDto = MasterData.getPoliticalLeaderDto();
		politicalLeaderDto.setCandidateName("Ab");
		Set<ConstraintViolation<PoliticalLeaderDto>> violations = validator.validate(politicalLeaderDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testPoliticalLeaderCandidateNameMaxHundred() throws Exception {
		PoliticalLeaderDto politicalLeaderDto = MasterData.getPoliticalLeaderDto();
		String candidateName = "";
		for (int i = 0; i < 120; i++) {
			candidateName.concat("A");
		}
		politicalLeaderDto.setCandidateName(candidateName);
		Set<ConstraintViolation<PoliticalLeaderDto>> violations = validator.validate(politicalLeaderDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testPoliticalLeaderCandidateStateNotNull() throws Exception {
		PoliticalLeaderDto politicalLeaderDto = MasterData.getPoliticalLeaderDto();
		politicalLeaderDto.setCandidateState("");
		Set<ConstraintViolation<PoliticalLeaderDto>> violations = validator.validate(politicalLeaderDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testPoliticalLeaderCandidateStateMinFive() throws Exception {
		PoliticalLeaderDto politicalLeaderDto = MasterData.getPoliticalLeaderDto();
		politicalLeaderDto.setCandidateState("Ab");
		Set<ConstraintViolation<PoliticalLeaderDto>> violations = validator.validate(politicalLeaderDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testPoliticalLeaderCandidateStateMax100() throws Exception {
		PoliticalLeaderDto politicalLeaderDto = MasterData.getPoliticalLeaderDto();
		String candidateState = "";
		for (int i = 0; i < 100; i++) {
			candidateState.concat("A");
		}
		politicalLeaderDto.setCandidateState(candidateState);
		Set<ConstraintViolation<PoliticalLeaderDto>> violations = validator.validate(politicalLeaderDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testDevelopmentPoliticalLeaderIdNotNull() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setPoliticalLeaderId(null);
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testDevelopmentTitleNotNull() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setTitle("");
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testDevelopmentTitleMinFive() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setTitle("Ab");
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testDevelopmentTitleMaxHundred() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		String title = "";
		for (int i = 0; i < 120; i++) {
			title.concat("A");
		}
		developmentDto.setTitle(title);
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testDevelopmentActivityNotNull() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setActivity("");
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testDevelopmentActivityMinFive() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setActivity("Ab");
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testDevelopmentActivityMaxHundred() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		String activity = "";
		for (int i = 0; i < 120; i++) {
			activity.concat("A");
		}
		developmentDto.setActivity(activity);
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testDevelopmentBudgetNotNull() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setBudget("");
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testDevelopmentBudgetMinFive() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setBudget("Ab");
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testDevelopmentBudgetMaxHundred() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		String budget = "";
		for (int i = 0; i < 120; i++) {
			budget.concat("A");
		}
		developmentDto.setBudget(budget);
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testDevelopmentStateNotNull() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setState("");
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testDevelopmentStateMinThree() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setState("Ab");
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testDevelopmentStateMaxFifty() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		String state = "";
		for (int i = 0; i < 60; i++) {
			state.concat("A");
		}
		developmentDto.setState(state);
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testDevelopmentActivityMonthNotNull() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setActivityMonth(null);
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testDevelopmentActivityMonthMinOne() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setActivityMonth(0);
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testDevelopmentActivityMonthMaxTwelve() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();

		developmentDto.setActivityMonth(13);
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testDevelopmentActivityYearNotNull() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setActivityYear(null);
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testDevelopmentActivityYearMin2020() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setActivityYear(2012);
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testDevelopmentActivityYearMax2040() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();

		developmentDto.setActivityYear(2045);
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

}
