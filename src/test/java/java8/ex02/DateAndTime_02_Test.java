package java8.ex02;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.UnsupportedTemporalTypeException;

import org.junit.Test;

/**
 * Exercice 02 - LocalDate
 */
public class DateAndTime_02_Test {

	@Test
	public void test_localDate_of() {

		// TODO créer un objet LocalDate à la date 24/12/2050
		LocalDate result1 =  LocalDate.of(2050, 12, 24);

		// TODO En exploitant les méthodes de l'objet result, valoriser les
		// différentes variables afin de rendre le test passant.
		int year = result1.getYear();
		Month month = result1.getMonth();
		int dayOfMonth = result1.getDayOfMonth();
		DayOfWeek dayOfWeek = result1.getDayOfWeek();
		int dayOfYear = result1.getDayOfYear();

		assertThat(year, is(2050));
		assertThat(month, is(Month.DECEMBER));
		assertThat(dayOfMonth, is(24));
		assertThat(dayOfWeek, is(DayOfWeek.SATURDAY));
		assertThat(dayOfYear, is(358));
	}

	@Test
	public void test_localDate_parse() {

		// TODO créer un objet LocalDate à la date 10/01/1990
		// TODO utiliser la méthode parse
		LocalDate result2 =  LocalDate.parse("1990-01-10"); // FORMAT ISO
		
		result2.getYear();
		result2.getMonth();
		result2.getDayOfMonth();
		result2.getDayOfWeek();
		result2.getDayOfYear();

		// TODO En exploitant les méthodes de l'objet result, valoriser les
		// différentes variables afin de rendre le test passant.
		int year = result2.getYear();
		Month month = result2.getMonth();
		int dayOfMonth = result2.getDayOfMonth();

		assertThat(year, is(1990));
		assertThat(month, is(Month.JANUARY));
		assertThat(dayOfMonth, is(10));
	}

	@Test
	public void test_localDate_format() {

		// TODO créer un objet LocalDate à la date 11/03/2015
		// en utilisant la méthode of
		LocalDate localDate =  LocalDate.of(2015, 3, 11);

		// TODO Formatter la date pour que le test soit passant
		String result3 = localDate.format(DateTimeFormatter.ofPattern("dd - MM - yyyy"));

		assertThat(result3, is("11 - 03 - 2015"));
	}

	@Test(expected = UnsupportedTemporalTypeException.class)
	public void test_localDate_format_with_hour() {

		// TODO créer un objet LocalDate à la date 11/03/2015
		// TODO utiliser la méthode of
		LocalDate localDate = LocalDate.of(2015, 3, 11);

		// TODO Formatter la date pour avoir l'affichage suivant : "11/03/2015 00:00:00"
		localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		
		assertThat(localDate, is("11/03/2015 00:00:00"));
	}

	@Test
	public void test_with() {

		// TODO créer un objet LocalDate à la date 10/01/2000
		// TODO utiliser la méthode of
		LocalDate localDate = LocalDate.of(2000, 01, 10);

		// TODO transformer la date précédente en 05/02/2015
		LocalDate result4 = localDate.plusYears(15).plusMonths(1).plusDays(-5);

		assertThat(result4.getYear(), is(2015));
		assertThat(result4.getMonth(), is(Month.FEBRUARY));
		assertThat(result4.getDayOfMonth(), is(5));
	}

}
