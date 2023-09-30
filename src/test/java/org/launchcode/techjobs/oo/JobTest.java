package org.launchcode.techjobs.oo;

import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // Assert that the class of each field is correct.
        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        // Assert that the value of each field is correct.
        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job3.equals(job4));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String expectedOutput = System.lineSeparator() +
                "ID: 1" + System.lineSeparator() +
                "Name: Product tester" + System.lineSeparator() +
                "Employer: ACME" + System.lineSeparator() +
                "Location: Desert" + System.lineSeparator() +
                "Position Type: Quality control" + System.lineSeparator() +
                "Core Competency: Persistence" + System.lineSeparator();

        String actualOutput = job5.toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expectedOutput = System.lineSeparator() +
                "ID: 1" + System.lineSeparator() +
                "Name: Product tester" + System.lineSeparator() +
                "Employer: ACME" + System.lineSeparator() +
                "Location: Desert" + System.lineSeparator() +
                "Position Type: Quality control" + System.lineSeparator() +
                "Core Competency: Persistence" + System.lineSeparator();

        String actualOutput = job5.toString();

        assertEquals(expectedOutput, actualOutput);
    }


    @Test
    public void testToStringHandlesEmptyField() {
        Job job5 = new Job("Product tester", new Employer("ACME"),null,
                new PositionType("Quality control"),null);
        String expectedOutput = System.lineSeparator() +
                "ID: 1" + System.lineSeparator() +
                "Name: Product tester" + System.lineSeparator() +
                "Employer: ACME" + System.lineSeparator() +
                "Location: Data not available" + System.lineSeparator() +
                "Position Type: Quality control" + System.lineSeparator() +
                "Core Competency: Data not available" + System.lineSeparator();

        String actualOutput = job5.toString();

        assertEquals(expectedOutput, actualOutput);
    }

}
