package com.zuehlke.cleancodeworkshop.inttoenum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SystemStateTest {
	private static final int ALL_SERVICES_OK = 0;
	private static final int COMMUNICATION_OK = 1;
	private static final int COMMUNICATION_DISTURBED = 2;
	private static final int MAIl_SERVICE_FAILURE = 3;
	private static final int REPORT_SERVICE_FAILURE = 4;
	private static final int DATABASE_CONNECTION_FAILURE = 5;
	private static final int INTERNAL_PROCESING_FAILURE = 6;

	@Test
	public void testGetStateAllServicesOk() {
		final SystemState state = new SystemState(ALL_SERVICES_OK);
		assertEquals(ALL_SERVICES_OK, state.getState());
	}

	@Test
	public void testGetStateCommunicationOk() {
		final SystemState state = new SystemState(COMMUNICATION_OK);
		assertEquals(COMMUNICATION_OK, state.getState());
	}

	@Test
	public void testGetStateReportServiceFailure() {
		final SystemState state = new SystemState(REPORT_SERVICE_FAILURE);
		assertEquals(REPORT_SERVICE_FAILURE, state.getState());
	}
	
	@Test
	public void testGetDescriptionForStateAllServicesOk() {
		assertEquals("All Services OK", SystemState.getDescriptionForState(ALL_SERVICES_OK));
	}

	@Test
	public void testGetDescriptionForStateCommunicationOk() {
		assertEquals("Communication OK", SystemState.getDescriptionForState(COMMUNICATION_OK));
	}
	
	@Test
	public void testGetDescriptionForStateReportServiceFailure() {
		assertEquals("ReportService Failure", SystemState.getDescriptionForState(REPORT_SERVICE_FAILURE));
	}

	@Test
	public void testGetDescriptionForUnknownState() {
		assertEquals("Unknown state", SystemState.getDescriptionForState(42));
		assertEquals("Unknown state", SystemState.getDescriptionForState(-42));
	}
	
	@Test
	public void testGetDescriptionForCornerCases() {
		assertEquals("Unknown state", SystemState.getDescriptionForState(7));
		assertEquals("Unknown state", SystemState.getDescriptionForState(-1));
	}
}
